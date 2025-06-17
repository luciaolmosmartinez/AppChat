package um.tds.Persistencia;

import java.util.List;

import um.tds.Modelado.Usuario;

public interface IAdaptadorUsuarioDAO {
	public void registrarUsuario(Usuario usuario);
	
	public void modificarUsuario(Usuario usuario);

	public Usuario recuperarUsuarioId(int id);
	
	public Usuario recuperarUsuarioTelefono(String numTelefono);

	public List<Usuario> recuperarTodosUsuarios();
}
