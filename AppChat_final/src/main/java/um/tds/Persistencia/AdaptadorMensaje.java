package um.tds.Persistencia;

import java.util.List;

import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import um.tds.Modelado.Mensaje;

public class AdaptadorMensaje implements IAdaptadorMensajeDAO {
	private static ServicioPersistencia servPersistencia;
	private static AdaptadorMensaje unicaInstancia = null;

	public static AdaptadorMensaje getUnicaInstancia() { // patron singleton
		if (unicaInstancia == null)
			return new AdaptadorMensaje();
		else
			return unicaInstancia;
	}

	private AdaptadorMensaje() {
		AdaptadorMensaje.servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}
	
	public Mensaje registrarMensaje(Mensaje mensaje) {
		return null;
	}

	public Mensaje recuperarMensaje(int id) {
		return null;
	}

	public List<Mensaje> recuperarTodosMensajes() {
		return null;
	}
}
