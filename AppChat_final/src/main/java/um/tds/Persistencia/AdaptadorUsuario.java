package um.tds.Persistencia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.*;
import um.tds.Modelado.*;

public class AdaptadorUsuario implements IAdaptadorUsuarioDAO {
	private static ServicioPersistencia servPersistencia;
	private static AdaptadorUsuario unicaInstancia = null;
	private SimpleDateFormat dateFormat1;
	private DateTimeFormatter dateFormat;

	private AdaptadorUsuario() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
		dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	}

	public static AdaptadorUsuario getUnicaInstancia() { // patron singleton
		if (unicaInstancia == null) {
			return new AdaptadorUsuario();
		} else {
			return unicaInstancia;
		}
	}

	// cuando se registra un usuario se le asigna un identificador único
	public void registrarUsuario(Usuario usuario) {
		// 1. Se comprueba que no está registrada la entidad que corresponde
		// al código del objeto (un objeto se crea con id = 0 o id = -1)
		Entidad eUsuario = null;
		try {
			eUsuario = servPersistencia.recuperarEntidad(usuario.getId());
		} catch (NullPointerException e) {
		}

		if (eUsuario != null) {
			return;
		}
		if (!(existeUsuarioConTelefono(usuario.getNumTelefono()) || existeUsuarioConEmail(usuario.getEmail()))) {
			// 2. Se registran sus objetos agregados.
			AdaptadorContacto adaptadorC = AdaptadorContacto.getUnicaInstancia();
			AdaptadorGrupo adaptadorG = AdaptadorGrupo.getUnicaInstancia();
			for (Contacto c : usuario.getContactos()) {
				if (c instanceof ContactoIndividual) {
					adaptadorC.anadirContacto((ContactoIndividual) c);
				} else {
					adaptadorG.registrarGrupo((Grupo) c);
				}
			}
			AdaptadorMensaje adaptadorM = AdaptadorMensaje.getUnicaInstancia();
			for (Mensaje m : usuario.getMensajesEnviados().values()) {
				adaptadorM.registrarMensaje(m);
			}
			for (Mensaje m : usuario.getmensajesRecibidos().values()) {
				adaptadorM.registrarMensaje(m);
			}

			// 3. Se crea la entidad (ya tiene un id)
			eUsuario = new Entidad();
			eUsuario.setNombre("usuario");

			// 4. Se le añaden las propiedades a la entidad creada
			eUsuario.setPropiedades(new ArrayList<Propiedad>(Arrays.asList(new Propiedad("nombre", usuario.getNombre()),
					new Propiedad("contrasena", String.valueOf(usuario.getContrasena())),
					new Propiedad("numTelefono", usuario.getNumTelefono()), new Propiedad("email", usuario.getEmail()),
					new Propiedad("fechaNacimiento", dateFormat1.format(usuario.getFechaNacimiento())),
					new Propiedad("imagenPerfil", usuario.getImagenPerfil()),
					new Propiedad("mensajeSaludo", usuario.getMensajeSaludo()),
					new Propiedad("fechaRegistro", usuario.getFechaRegistro().format(dateFormat)),
					new Propiedad("premium", String.valueOf(usuario.isPremium())),
					new Propiedad("contactos", obtenerIdsContactos(usuario.getContactos())),
					new Propiedad("descuento", String.valueOf(usuario.getDescuento())),
					new Propiedad("mensajesEnviados", obtenerIdsMensajes(usuario.getMensajesEnviados())),
					new Propiedad("mensajesRecibidos", obtenerIdsMensajes(usuario.getmensajesRecibidos())))));

			// 5. Se registra la entidad y se asocia id al objeto almacenado.
			eUsuario = servPersistencia.registrarEntidad(eUsuario);
			usuario.setId(eUsuario.getId());
		}
	}

	public Usuario modificarUsuario(Usuario usuario) {
		return null;
	}

	public Usuario recuperarUsuario(int id) {
		// 1. Si el objeto está en el pool se retorna
		if (PoolDAO.getUnicaInstancia().contiene(id))
			return (Usuario) PoolDAO.getUnicaInstancia().getObjeto(id);

		// 2. Si no lo está se recupera entidad y las propiedades de campos de tipo
		// primitivo
		String nombre = null;
		char[] contrasena;
		String numTelefono = null;
		String email = null;
		Date fechaNacimiento = null;
		String imagenPerfil = null;
		String mensajeSaludo = null;
		LocalDate fechaRegistro = null;
		boolean premium;
		List<Contacto> contactos;
		Descuento descuento;
		List<Mensaje> mensajesEnviados;
		List<Mensaje> mensajesRecibidos;

		// Recupero la entidad
		Entidad eUsuario = servPersistencia.recuperarEntidad(id);

		// Recupero las propiedades de tipo primitivo
		nombre = servPersistencia.recuperarPropiedadEntidad(eUsuario, "nombre");
		contrasena = servPersistencia.recuperarPropiedadEntidad(eUsuario, "contrasena").toCharArray();
		numTelefono = servPersistencia.recuperarPropiedadEntidad(eUsuario, "numTelefono");
		email = servPersistencia.recuperarPropiedadEntidad(eUsuario, "email");
		try {
			fechaNacimiento = dateFormat1
					.parse(servPersistencia.recuperarPropiedadEntidad(eUsuario, "fechaNacimiento"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		imagenPerfil = servPersistencia.recuperarPropiedadEntidad(eUsuario, "imagenPerfil");
		mensajeSaludo = servPersistencia.recuperarPropiedadEntidad(eUsuario, "mensajeSaludo");
		fechaRegistro = LocalDate.parse(servPersistencia.recuperarPropiedadEntidad(eUsuario, "fechaRegistro"));
		premium = Boolean.valueOf(servPersistencia.recuperarPropiedadEntidad(eUsuario, "premium"));

		// 3. Se crea el objeto, se inicializa con propiedades anteriores y se añade al
		// pool si es necesario
		Usuario usuario = new Usuario(nombre, numTelefono, email, contrasena, fechaNacimiento, mensajeSaludo,
				imagenPerfil);
		usuario.setId(id);
		/*
		 * usuario.setNombre(nombre); usuario.setContrasena(contrasena);
		 * usuario.setNumTelefono(numTelefono); usuario.setEmail(email);
		 * usuario.setFechaNacimiento(fechaNacimiento);
		 * usuario.setImagenPerfil(imagenPerfil);
		 * usuario.setMensajeSaludo(mensajeSaludo);
		 */
		usuario.setFechaRegistro(fechaRegistro);
		usuario.setPremium(premium);

		PoolDAO.getUnicaInstancia().addObjeto(id, usuario);

		// 4. Se recuperan los objetos referenciados y se actualiza el objeto
		contactos = obtenerContactosDesdeIds(servPersistencia.recuperarPropiedadEntidad(eUsuario, "contactos"));
		for (Contacto c : contactos) {
			if (c instanceof ContactoIndividual) {
				usuario.addContacto((ContactoIndividual) c);
			} else {
				usuario.addGrupo((Grupo) c);
			}
		}
		
		//descuento = servPersistencia.recuperarPropiedadEntidad(eUsuario, "descuento");
		//usuario.setDescuento(descuento);
		
		mensajesEnviados = obtenerMensajesDesdeIds(
				servPersistencia.recuperarPropiedadEntidad(eUsuario, "mensajesEnviados"));
		for (Mensaje m : mensajesEnviados) {
			usuario.addMensajeEnviado(m);
		}
		
		mensajesRecibidos = obtenerMensajesDesdeIds(
				servPersistencia.recuperarPropiedadEntidad(eUsuario, "mensajesRecibidos"));
		for (Mensaje m : mensajesRecibidos) {
			usuario.addMensajeRecibido(m);
		}
		
		// 5. Se retorna el objeto
		return usuario;
	}

	public List<Usuario> recuperarTodosUsuarios() {

		return null;
	}

	private String obtenerIdsContactos(List<Contacto> contactos) {
		String lista = "";
		for (Contacto c : contactos) {
			lista += c.getId() + " ";
		}
		return lista.trim();
	}

	private List<Contacto> obtenerContactosDesdeIds(String lista) {
		List<Contacto> contactos = new LinkedList<Contacto>();
		StringTokenizer strTok = new StringTokenizer(lista, " ");
		AdaptadorContacto adaptadorC = AdaptadorContacto.getUnicaInstancia();
		while (strTok.hasMoreTokens()) {
			contactos.add(adaptadorC.recuperarContacto(Integer.valueOf((String) strTok.nextElement())));
		}
		return contactos;
	}

	private String obtenerIdsMensajes(Map<String, Mensaje> mensajes) {
		String lista = "";
		for (Mensaje m : mensajes.values()) {
			lista += m.getId() + " ";
		}
		return lista.trim();
	}

	private List<Mensaje> obtenerMensajesDesdeIds(String lista) {
		List<Mensaje> mensajes = new LinkedList<Mensaje>();
		StringTokenizer strTok = new StringTokenizer(lista, " ");
		AdaptadorMensaje adaptadorM = AdaptadorMensaje.getUnicaInstancia();

		while (strTok.hasMoreTokens()) {
			mensajes.add(adaptadorM.recuperarMensaje(Integer.valueOf((String) strTok.nextElement())));
		}
		return mensajes;
	}

	private boolean existeUsuarioConTelefono(String telefono) {
		List<Entidad> entidades = servPersistencia.recuperarEntidades("usuario");

		for (Entidad e : entidades) {
			for (Propiedad p : e.getPropiedades()) {
				if (p.getNombre().equals("numTelefono") && p.getValor().equals(telefono)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean existeUsuarioConEmail(String email) {
		List<Entidad> entidades = servPersistencia.recuperarEntidades("usuario");

		for (Entidad e : entidades) {
			for (Propiedad p : e.getPropiedades()) {
				if (p.getNombre().equals("email") && p.getValor().equals(email)) {
					return true;
				}
			}
		}
		return false;
	}

}
