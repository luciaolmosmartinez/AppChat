package um.tds.Modelado;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RepositorioUsuarios {
	private Set<Usuario> usuarios = new HashSet<>();

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
