package um.tds.Repositorio;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import um.tds.Modelado.ContactoIndividual;
import um.tds.Modelado.Grupo;
import um.tds.Modelado.Usuario;
import um.tds.Persistencia.DAOException;
import um.tds.Persistencia.FactoriaDAO;
import um.tds.Persistencia.IAdaptadorUsuarioDAO;

public class RepositorioUsuarios {

	private static RepositorioUsuarios unicaInstancia = new RepositorioUsuarios();
	private Map<String, Usuario> usuarios;
	private FactoriaDAO daofactoria;
	private IAdaptadorUsuarioDAO adaptadorUsuario;

	private RepositorioUsuarios() {
		try {
			// daofactoria = new FatoriaTDS();
			daofactoria = FactoriaDAO.getInstancia();
			adaptadorUsuario = daofactoria.getUsuarioDAO();
			usuarios = new HashMap<String, Usuario>();
			this.cargarUsuarios();
		} catch (DAOException eDAO) {
			eDAO.printStackTrace();
		}
	}

	public static RepositorioUsuarios getUnicaInstancia() {
		return unicaInstancia;
	}

	// Método de iniciación del repositorio
	private void cargarUsuarios() throws DAOException {
		adaptadorUsuario.recuperarTodosUsuarios().stream().forEach(u -> usuarios.put(u.getNumTelefono(), u));
	}

	// Método de añadir objetos al repositorio
	public boolean addUsuario(Usuario usuario) {
		if (!usuarios.values().stream() // si no hay alguno con el mismo número o correo
				.anyMatch(u -> u.getNumTelefono() == usuario.getNumTelefono())) {
			usuarios.put(usuario.getNumTelefono(), usuario);
			return true;
		}
		return false;
	}

	// Métodos query
	public Usuario getUsuario(String telefono) {
		return usuarios.get(telefono);
	}

	public List<Usuario> getUsuariosCreadosPeriodo(LocalDate inicio, LocalDate fin) {
		return usuarios.values().stream().filter(u -> u.esEnPeriodo(inicio, fin)).collect(Collectors.toList());
	}

	public List<Usuario> getAllUsuarios() {
		ArrayList<Usuario> lista = (ArrayList<Usuario>) usuarios.values();
		return lista;
	}

	// Comprueba que exista un usuario con el mismo numero de telefono y contrasena
	public Usuario comprobarUsuario(String telefono, char[] contrasena) {
		return usuarios.values().stream()
				.filter(u -> u.getNumTelefono().equals(telefono) && Arrays.equals(u.getContrasena(), contrasena))
				.findFirst().orElse(null);
	}

	// Actualiza el usuario dado en la lista de usuarios del repositorio
	public void actualizarUsuario(Usuario usuario) {
		usuarios.replace(usuario.getNumTelefono(), usuario);
	}

	// Actualiza el contacto dado en usuario y ello actualiza automáticamente el usuario en la lista de
	// usuarios del repositorio
	public Usuario modificarContacto(ContactoIndividual contacto, String nombre, Usuario usuario) {
		if (usuario.getContactos().stream().filter(c -> c instanceof ContactoIndividual)
				.anyMatch(c -> c.getNombre().equals(nombre))) {
			return null;
		}

		contacto.setNombre(nombre);

		return usuario;
	}
	
	// Actualiza el grupo sin importar si ya existe otro grupo con el mismo nombre.
	public Usuario modificarGrupo(Grupo grupo, String nombre, String imagen, Usuario usuario, List<ContactoIndividual> miembrosActualizados) {
		grupo.setNombre(nombre);
		grupo.setImagen(imagen);
		grupo.actualizarMiembros(miembrosActualizados);
		return usuario;
	}
}
