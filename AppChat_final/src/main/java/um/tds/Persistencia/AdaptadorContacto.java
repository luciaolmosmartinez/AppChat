package um.tds.Persistencia;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import um.tds.Modelado.ContactoIndividual;
import um.tds.Modelado.Mensaje;
import um.tds.Modelado.Usuario;

public class AdaptadorContacto implements IAdaptadorContactoDAO {
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

	public void anadirContacto(ContactoIndividual contacto) {
		// 1. Se comprueba que no está registrada la entidad que corresponde
		// al código del objeto (un objeto se crea con id = 0 o id = -1)
		Entidad eContacto = null;
		try {
			eContacto = servPersistencia.recuperarEntidad(contacto.getId());
		} catch (NullPointerException e) {
		}

		if (eContacto != null) {
			return;
		}

		// 2. Se registran sus objetos agregados, pero no tiene

		// 3. Se crea la entidad (ya tiene un id)
		eContacto = new Entidad();
		eContacto.setNombre("contacto");

		// 4. Se le añaden las propiedades a la entidad creada
		eContacto.setPropiedades(new ArrayList<Propiedad>(Arrays.asList(new Propiedad("nombre", contacto.getNombre()),
				new Propiedad("usuario", String.valueOf(contacto.getUsuario())))));

		// 5. Se registra la entidad y se asocia id al objeto almacenado.
		eContacto = servPersistencia.registrarEntidad(eContacto);
		contacto.setId(eContacto.getId());
	}

	public ContactoIndividual recuperarContacto(int id) {
		// 1. Si el objeto está en el pool se retorna
		if (PoolDAO.getUnicaInstancia().contiene(id))
			return (ContactoIndividual) PoolDAO.getUnicaInstancia().getObjeto(id);

		// 2. Si no lo está se recupera entidad y las propiedades de campos de tipo
		// primitivo
		String nombre = null;
		Usuario usuario = null;

		// Recupero la entidad
		Entidad eContactoIndividual = servPersistencia.recuperarEntidad(id);

		// Recupero las propiedades de tipo primitivo
		nombre = servPersistencia.recuperarPropiedadEntidad(eContactoIndividual, "nombre");

		// 3. Se crea el objeto, se inicializa con propiedades anteriores y se añade al
		// pool si es necesario
		ContactoIndividual contactoIndividual = new ContactoIndividual(usuario, nombre);
		contactoIndividual.setId(id);
		//contactoIndividual.setNombre(nombre);

		PoolDAO.getUnicaInstancia().addObjeto(id, contactoIndividual);

		// 4. Se recuperan los objetos referenciados y se actualiza el objeto
		AdaptadorUsuario adaptadorUsuario = AdaptadorUsuario.getUnicaInstancia();
		int idUsuario = Integer.parseInt(servPersistencia.recuperarPropiedadEntidad(eContactoIndividual, "usuario"));
		usuario = adaptadorUsuario.recuperarUsuario(idUsuario);
		contactoIndividual.setUsuario(usuario);

		// 5. Se retorna el objeto
		return contactoIndividual;
	}

	public List<ContactoIndividual> recuperarTodosContactos() {
		return null;
	}
}
