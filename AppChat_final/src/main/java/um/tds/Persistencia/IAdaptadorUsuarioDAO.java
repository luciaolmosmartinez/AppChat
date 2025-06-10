package um.tds.Persistencia;

import java.util.List;

import um.tds.Modelado.Usuario;

public interface IAdaptadorUsuarioDAO {
	public void registrarUsuario(Usuario usuario);
	
	public Usuario modificarUsuario(Usuario usuario);

	public Usuario recuperarUsuario(int id);

	public List<Usuario> recuperarTodosUsuarios();
}
