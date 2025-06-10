package um.tds.Repositorio;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import beans.Entidad;
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
	
	public static RepositorioUsuarios getUnicaInstancia(){
		return unicaInstancia;
	}
	

	// Método de iniciación del repositorio
	private void cargarUsuarios() throws DAOException {
		adaptadorUsuario.recuperarTodosUsuarios().stream()
			.forEach(u -> usuarios.put(u.getNumTelefono(), u));
	}
	
	// Método de añadir objetos al repositorio
	public boolean addUsuario(Usuario usuario) {
		if (!usuarios.values().stream() // si no hay alguno con el mismo número o correo
				.anyMatch(u -> u.getEmail().equals(usuario.getEmail()) || u.getNumTelefono() == usuario.getNumTelefono())) {
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

	public Usuario comprobarUsuario(String telefono, char[] contrasena) {
		return usuarios.values().stream().filter(
				u -> u.getNumTelefono() == telefono && Arrays.equals(u.getContrasena(), contrasena))
				.findFirst().orElse(null);
	}
}
