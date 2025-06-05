package um.tds.Persistencia;

import java.util.List;

import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import um.tds.Modelado.Usuario;

public class AdaptadorUsuario implements IAdaptadorUsuarioDAO {
	private static ServicioPersistencia servPersistencia;
	private static AdaptadorUsuario unicaInstancia = null;

	public static AdaptadorUsuario getUnicaInstancia() { // patron singleton
		if (unicaInstancia == null)
			return new AdaptadorUsuario();
		else
			return unicaInstancia;
	}

	private AdaptadorUsuario() {
		AdaptadorUsuario.servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}
	
	public Usuario registrarUsuario(Usuario usuario) {
		return null;
	}

	public void borrarUsuario(Usuario usuario) {
		
	}

	public Usuario modificarUsuario(Usuario usuario) {
		return null;
	}

	public Usuario recuperarUsuario(String numTelefono) {
		return null;
	}

	public List<Usuario> recuperarTodosUsuarios() {
		return null;
	}
}
