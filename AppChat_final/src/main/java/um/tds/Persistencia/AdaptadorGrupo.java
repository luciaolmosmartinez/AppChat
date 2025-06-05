package um.tds.Persistencia;

import java.util.List;

import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import um.tds.Modelado.Grupo;

public class AdaptadorGrupo implements IAdaptadorGrupoDAO{
	private static ServicioPersistencia servPersistencia;
	private static AdaptadorGrupo unicaInstancia = null;

	public static AdaptadorGrupo getUnicaInstancia() { // patron singleton
		if (unicaInstancia == null)
			return new AdaptadorGrupo();
		else
			return unicaInstancia;
	}

	private AdaptadorGrupo() {
		AdaptadorGrupo.servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}
	
	public Grupo registrarGrupo(Grupo grupo) {
		return null;
	}

	public Grupo recuperarGrupo(int id) {
		return null;
	}

	public List<Grupo> recuperarTodosGrupos() {
		return null;
	}
	
	public boolean agregarContacto(Grupo grupo) {
		return false;
	}
	
	public boolean eliminarContacto(Grupo grupo) {
		return false;
	}
}
