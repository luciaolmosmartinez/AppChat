package um.tds.Persistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import um.tds.Modelado.Contacto;
import um.tds.Modelado.ContactoIndividual;
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
			e.printStackTrace();
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
				new Propiedad("usuario", String.valueOf(contacto.getUsuario().getId())),
				new Propiedad("tipo", "individual"))));

		// 5. Se registra la entidad y se asocia id al objeto almacenado.
		eContacto = servPersistencia.registrarEntidad(eContacto);
		contacto.setId(eContacto.getId());
	}

	/*
	 * public ContactoIndividual recuperarContacto(int id) { // 1. Si el objeto está
	 * en el pool se retorna if (PoolDAO.getUnicaInstancia().contiene(id)) return
	 * (ContactoIndividual) PoolDAO.getUnicaInstancia().getObjeto(id);
	 * 
	 * // 2. Si no lo está se recupera entidad y las propiedades de campos de tipo
	 * // primitivo String nombre = null; Usuario usuario = null;
	 * 
	 * // Recupero la entidad Entidad eContactoIndividual =
	 * servPersistencia.recuperarEntidad(id);
	 * 
	 * // Recupero las propiedades de tipo primitivo nombre =
	 * servPersistencia.recuperarPropiedadEntidad(eContactoIndividual, "nombre");
	 * 
	 * // 3. Se crea el objeto, se inicializa con propiedades anteriores y se añade
	 * al // pool si es necesario ContactoIndividual contactoIndividual = new
	 * ContactoIndividual(usuario, nombre); contactoIndividual.setId(id);
	 * //contactoIndividual.setNombre(nombre);
	 * 
	 * PoolDAO.getUnicaInstancia().addObjeto(id, contactoIndividual);
	 * 
	 * // 4. Se recuperan los objetos referenciados y se actualiza el objeto
	 * AdaptadorUsuario adaptadorUsuario = AdaptadorUsuario.getUnicaInstancia(); int
	 * idUsuario = Integer.parseInt(servPersistencia.recuperarPropiedadEntidad(
	 * eContactoIndividual, "usuario")); usuario =
	 * adaptadorUsuario.recuperarUsuarioId(idUsuario);
	 * contactoIndividual.setUsuario(usuario);
	 * 
	 * // 5. Se retorna el objeto return contactoIndividual; }
	 */

	public List<ContactoIndividual> recuperarTodosContactos() {
		List<ContactoIndividual> contactos = new ArrayList<>();
		List<Entidad> eContactos = servPersistencia.recuperarEntidades("contacto");
		for (Entidad eContacto : eContactos) {
			contactos.add((ContactoIndividual) recuperarContacto(eContacto.getId()));
		}
		return contactos;
	}

	public Contacto recuperarContacto(int id) {
		// 1. Si el objeto está en el pool se retorna
		if (PoolDAO.getUnicaInstancia().contiene(id)) {
			Object obj = PoolDAO.getUnicaInstancia().getObjeto(id);
			if (obj instanceof Contacto) {
				return (Contacto) obj;
			}
		}

		// 2. Recuperar entidad
		Entidad eContacto = servPersistencia.recuperarEntidad(id);

		String tipo = servPersistencia.recuperarPropiedadEntidad(eContacto, "tipo"); // Asumiendo que guardas esto

		if (tipo == null) {
			// Por defecto, asumimos ContactoIndividual o puedes lanzar excepción
			tipo = "individual";
		}

		if (tipo.equalsIgnoreCase("individual")) {
			// Recuperar contacto individual
			return recuperarContactoIndividual(id, eContacto);
		} else if (tipo.equalsIgnoreCase("grupo")) {
			// Recuperar grupo con AdaptadorGrupo
			return AdaptadorGrupo.getUnicaInstancia().recuperarGrupo(id);
		} else {
			// Otro tipo o error
			throw new RuntimeException("Tipo de contacto desconocido: " + tipo);
		}
	}

	private ContactoIndividual recuperarContactoIndividual(int id, Entidad eContactoIndividual) {
		// Código similar al que tienes en recuperarContactoActual...
		String nombre = servPersistencia.recuperarPropiedadEntidad(eContactoIndividual, "nombre");
		int idUsuario = Integer.parseInt(servPersistencia.recuperarPropiedadEntidad(eContactoIndividual, "usuario"));
		Usuario usuario = AdaptadorUsuario.getUnicaInstancia().recuperarUsuarioId(idUsuario);
		ContactoIndividual contacto = new ContactoIndividual(usuario, nombre);
		contacto.setId(id);
		PoolDAO.getUnicaInstancia().addObjeto(id, contacto);
		return contacto;
	}

	public void modificarContacto(ContactoIndividual contacto) {
		// 1. Se recupera entidad
		Entidad eContacto = servPersistencia.recuperarEntidad(contacto.getId());

		// 2. Se recorren sus propiedades y se actualiza su valor
		for (Propiedad prop : eContacto.getPropiedades()) {
			if (prop.getNombre().equals("id")) {
				prop.setValor(String.valueOf(contacto.getId()));
			} else if (prop.getNombre().equals("nombre")) {
				prop.setValor(contacto.getNombre());
			} else if (prop.getNombre().equals("usuario")) {
				prop.setValor(String.valueOf(contacto.getUsuario().getId()));
			}
			servPersistencia.modificarPropiedad(prop);
		}
	}
}
