package um.tds.Persistencia;

import java.util.List;

import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import um.tds.Modelado.ContactoIndividual;

public class AdaptadorContacto implements IAdaptadorContactoDAO{
	private static ServicioPersistencia servPersistencia;
	private static AdaptadorContacto unicaInstancia = null;

	public static AdaptadorContacto getUnicaInstancia() { // patron singleton
		if (unicaInstancia == null)
			return new AdaptadorContacto();
		else
			return unicaInstancia;
	}

	private AdaptadorContacto() {
		AdaptadorContacto.servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}
	
	public ContactoIndividual anadirContacto(ContactoIndividual contacto) {
		return null;
	}

	public ContactoIndividual recuperarContacto(int id) {
		return null;
	}

	public List<ContactoIndividual> recuperarTodosContactos() {
		return null;
	}
}
