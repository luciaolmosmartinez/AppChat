package um.tds.Repositorio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import um.tds.Modelado.Usuario;
import um.tds.Persistencia.DAOException;
import um.tds.Persistencia.FactoriaDAO;
import um.tds.Persistencia.IAdaptadorUsuarioDAO;

public class RepositorioUsuarios {
	private Map<String, Usuario> usuarios;
	private static RepositorioUsuarios unicaInstacia = new RepositorioUsuarios();

	private FactoriaDAO daofactoria;
	private IAdaptadorUsuarioDAO adaptadorUsuario;

	private RepositorioUsuarios() {
		try {
			// daofactoria = new FatoriaTDS();
			daofactoria = FactoriaDAO.getFactoriaDAO(FactoriaDAO.PERSIST_TDS);
			adaptadorUsuario = daofactoria.getUsuarioDAO();
			this.cargarRepositorio();
		} catch (DAOException eDAO) {
			eDAO.printStackTrace();
		}
	}

	public static RepositorioUsuarios getUnicaInstacia() {
		return unicaInstacia;
	}

	public static RepositorioUsuarios addUnicaInstacia() {
		// arreglar
		return unicaInstacia;
	}

	public static RepositorioUsuarios remuveUnicaInstacia() {
		// arreglar
		return unicaInstacia;
	}

	// Método de iniciación del repositorio
	private void cargarUsuarios() throws DAOException {
		usuarios = new HashMap<String, Usuario>();
		List<Usuario> usuariosBD = adaptadorUsuario.recuperarTodosadaptadorUsuarios();
		for (Usuario usuario : usuariosBD)
			usuarios.put(usuario.getNumTelefono(), usuario);
	}

	// Método de añadir objetos al repositorio
	public void addUsuario(Usuario usuario) {
		/*if (usuarios.stream() // si ya hay alguno con el mismo número o correo
				.anyMatch(u -> u.getEmail().equals(user.getEmail()) || u.getNumTelefono() == user.getNumTelefono())) {
			return false;
		} else {
			return usuarios.add(user);
		}*/
		
		usuarios.put(usuario.getNumTelefono(), usuario);
	}

	// Método de eliminar objetos del repositorio
	public void removeUsuario(Usuario usuario) {
		usuarios.remove(usuario.getNumTelefono());
	}

	// Métodos query
	public Usuario getUsuario(String telefono) {
		return usuarios.get(telefono);
	}

	public List<Usuario> getUsuariosPeriodo(Date inicio, Date fin) {
		Collection<Usuario> usuariosAll = this.usuarios.values();
		return usuariosAll.stream().filter(u -> u.esEnPeriodo(inicio, fin)).collect(Collectors.toList());
	}

	public List<Usuario> getAllUsuarios() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		for (Usuario venta : usuarios.values())
			lista.add(usuario);
		return lista;
	}

	/*public List<Usuario> getVentasCliente(String dni){
		
	}*/

	// metodos nuestros de antes
	public boolean crearUsuario(Usuario user) {
		if (usuarios.stream() // si ya hay alguno con el mismo número o correo
				.anyMatch(u -> u.getEmail().equals(user.getEmail()) || u.getNumTelefono() == user.getNumTelefono())) {
			return false;
		} else {
			return usuarios.add(user);
		}
	}

	public Usuario comprobarUsuario(String telefono, char[] contrasena) {
		return usuarios.stream().filter(
				u -> u.getNumTelefono() == Integer.parseInt(telefono) && Arrays.equals(u.getContrasena(), contrasena))
				.findFirst().orElse(null);
	}
}
