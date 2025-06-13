package um.tds.Persistencia;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import um.tds.Modelado.Mensaje;
import um.tds.Modelado.TipoReceptor;
import um.tds.Modelado.Usuario;

public class AdaptadorMensaje implements IAdaptadorMensajeDAO {
	private static ServicioPersistencia servPersistencia;
	private static AdaptadorMensaje unicaInstancia = null;
	private DateTimeFormatter dateFormat;

	public static AdaptadorMensaje getUnicaInstancia() { // patron singleton
		if (unicaInstancia == null)
			return new AdaptadorMensaje();
		else
			return unicaInstancia;
	}

	private AdaptadorMensaje() {
		AdaptadorMensaje.servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
		dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	}

	public void registrarMensaje(Mensaje mensaje) {
		// 1. Se comprueba que no está registrada la entidad que corresponde
		// al código del objeto (un objeto se crea con id = 0 o id = -1)
		Entidad eMensaje = null;
		try {
			eMensaje = servPersistencia.recuperarEntidad(mensaje.getId());
		} catch (NullPointerException e) {
		}

		if (eMensaje != null) {
			return;
		}

		// 2. Se registran sus objetos agregados.
		// NO SE SI HACE FALTA
		/*
		 * AdaptadorUsuario adaptadorU = AdaptadorUsuario.getUnicaInstancia(); for
		 * (Usuario u : Mensaje.getReceptor()) { adaptadorU.registrarUsuario(u); }
		 */

		// 3. Se crea la entidad (ya tiene un id)
		eMensaje = new Entidad();
		eMensaje.setNombre("mensaje");

		// 4. Se le añaden las propiedades a la entidad creada
		eMensaje.setPropiedades(new ArrayList<Propiedad>(Arrays.asList(new Propiedad("texto", mensaje.getTexto()),
				new Propiedad("emoticono", String.valueOf(mensaje.getEmoticono())),
				new Propiedad("emisor", String.valueOf(mensaje.getEmisor())),
				new Propiedad("receptor", (mensaje.getReceptor())),
				new Propiedad("fechaHora", mensaje.getFechaHora().format(dateFormat)),
				new Propiedad("tipoReceptor", String.valueOf(mensaje.getTipoReceptor())))));

		// 5. Se registra la entidad y se asocia id al objeto almacenado.
		eMensaje = servPersistencia.registrarEntidad(eMensaje);
		mensaje.setId(eMensaje.getId());
	}

	public Mensaje recuperarMensaje(int id) {
		// 1. Si el objeto está en el pool se retorna
		if (PoolDAO.getUnicaInstancia().contiene(id))
			return (Mensaje) PoolDAO.getUnicaInstancia().getObjeto(id);

		// 2. Si no lo está se recupera entidad y las propiedades de campos de tipo
		// primitivo
		String texto = null;
		int emoticono = -1;
		String emisor = null;
		String receptor = null;
		LocalDateTime fechaHora = null;
		TipoReceptor tipoReceptor = null;

		// Recupero la entidad
		Entidad eMensaje = servPersistencia.recuperarEntidad(id);

		// Recupero las propiedades de tipo primitivo
		texto = servPersistencia.recuperarPropiedadEntidad(eMensaje, "texto");
		emoticono = Integer.parseInt(servPersistencia.recuperarPropiedadEntidad(eMensaje, "emoticono"));
		emisor = servPersistencia.recuperarPropiedadEntidad(eMensaje, "emisor");
		receptor = servPersistencia.recuperarPropiedadEntidad(eMensaje, "receptor");
		fechaHora = LocalDateTime.parse(servPersistencia.recuperarPropiedadEntidad(eMensaje, "fechaHora"));


		// 3. Se crea el objeto, se inicializa con propiedades anteriores y se añade al
		// pool si es necesario
		//Mensaje mensaje = new Mensaje(texto, emoticono, emisor, receptor);
		Mensaje mensaje = new Mensaje(texto, emoticono, emisor, receptor, tipoReceptor);
		mensaje.setId(id);
		/*mensaje.setTexto(texto);
		mensaje.setEmoticono(emoticono);*/
		mensaje.setFechaHora(fechaHora);

		PoolDAO.getUnicaInstancia().addObjeto(id, mensaje);

		// 4. Se recuperan los objetos referenciados y se actualiza el objeto
		//tipoReceptor = servPersistencia.recuperarPropiedadEntidad(eMensaje,"tipoReceptor");
		//mensaje.setTipoReceptor(tipoReceptor);
		

		// 5. Se retorna el objeto
		return mensaje;
	}

	public List<Mensaje> recuperarTodosMensajes() {
		List<Mensaje> mensajes = new ArrayList<>();
		List<Entidad> eMensajes = servPersistencia.recuperarEntidades("mensaje");
		for(Entidad eMensaje : eMensajes) {
			mensajes.add(recuperarMensaje(eMensaje.getId()));
		}
		return mensajes;
	}
}
