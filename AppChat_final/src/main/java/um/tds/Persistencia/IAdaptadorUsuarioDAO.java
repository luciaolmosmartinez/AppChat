package um.tds.Persistencia;

import java.util.List;

import um.tds.Modelado.Usuario;

public interface IAdaptadorUsuarioDAO {
	public Usuario registrarUsuario(Usuario usuario);

	public void borrarUsuario(Usuario usuario);

	public Usuario modificarUsuario(Usuario usuario);

	public Usuario recuperarUsuario(String numTelefono);

	public List<Usuario> recuperarTodosUsuarios();
}
