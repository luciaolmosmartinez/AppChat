package um.tds.Persistencia;

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
	private DateTimeFormatter dateFormat;

	private AdaptadorUsuario() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
		dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	}

	public static AdaptadorUsuario getUnicaInstancia() { // patron singleton
		if (unicaInstancia == null) {
			return new AdaptadorUsuario();
		} else {
			return unicaInstancia;
		}
	}

	// Registra el usuario dado en la base de datos
	// cuando se registra un usuario se le asigna un identificador único
	public void registrarUsuario(Usuario usuario) {
		// 1. Se comprueba que no está registrada la entidad que corresponde
		// al código del objeto (un objeto se crea con id = 0 o id = -1)
		Entidad eUsuario = null;
		try {
			eUsuario = servPersistencia.recuperarEntidad(usuario.getId());
		} catch (Exception e) {
		}

		if (eUsuario != null) {
			return;
		}
		
		if (!(existeUsuarioConTelefono(usuario.getNumTelefono()))) {
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
			for (List<Mensaje> ms : usuario.getMensajes().values()) {
				for(Mensaje m : ms) {
					adaptadorM.registrarMensaje(m);
				}
			}

			// 3. Se crea la entidad (ya tiene un id) y se le pone nombre
			eUsuario = new Entidad();
			eUsuario.setNombre("usuario");
			String fechaN = (usuario.getFechaNacimiento()==null) ? "":usuario.getFechaNacimiento().format(dateFormat);
			// 4. Se le añaden las propiedades a la entidad creada
			eUsuario.setPropiedades(new ArrayList<Propiedad>(Arrays.asList(new Propiedad("nombre", usuario.getNombre()),
					new Propiedad("contrasena", String.valueOf(usuario.getContrasena())),
					new Propiedad("numTelefono", usuario.getNumTelefono()), new Propiedad("email", usuario.getEmail()),
					new Propiedad("fechaNacimiento", fechaN),
					new Propiedad("imagenPerfil", usuario.getImagenPerfil()),
					new Propiedad("mensajeSaludo", usuario.getMensajeSaludo()),
					new Propiedad("fechaRegistro", usuario.getFechaRegistro().format(dateFormat)),
					new Propiedad("premium", String.valueOf(usuario.isPremium())),
					new Propiedad("contactos", obtenerIdsContactos(usuario.getContactos())),
					new Propiedad("descuento", String.valueOf(usuario.getDescuento())),
					new Propiedad("mensajesEnviados", obtenerIdsMensajes(usuario.getMensajes())))));

			// 5. Se registra la entidad y se asocia id al objeto almacenado.
			eUsuario = servPersistencia.registrarEntidad(eUsuario);
			usuario.setId(eUsuario.getId());
		}
	}

	
	// Actualiza el usuario dado en la base de datos
	public void modificarUsuario(Usuario usuario) {
		// 1. Se recupera entidad
		Entidad eUsuario = servPersistencia.recuperarEntidad(usuario.getId());
		
		// 2. Se recorren sus propiedades y se actualiza su valor
		String fechaN = (usuario.getFechaNacimiento()==null) ? "":usuario.getFechaNacimiento().format(dateFormat);
		for (Propiedad prop : eUsuario.getPropiedades()) {
			if (prop.getNombre().equals("id")) {
				prop.setValor(String.valueOf(usuario.getId()));
			} else if (prop.getNombre().equals("nombre")) {
				prop.setValor(usuario.getNombre());
			} else if (prop.getNombre().equals("contrasena")) {
				prop.setValor(String.valueOf(usuario.getContrasena()));
			} else if (prop.getNombre().equals("numTelefono")) {
				prop.setValor(String.valueOf(usuario.getNumTelefono()));
			} else if (prop.getNombre().equals("email")) {
				prop.setValor(String.valueOf(usuario.getEmail()));
			} else if (prop.getNombre().equals("fechaNacimiento")) {
				prop.setValor(fechaN);
			} else if (prop.getNombre().equals("imagenPerfil")) {
				prop.setValor(usuario.getImagenPerfil());
			} else if (prop.getNombre().equals("mensajeSaludo")) {
				prop.setValor(usuario.getMensajeSaludo());
			} else if (prop.getNombre().equals("fechaRegistro")) {
				prop.setValor(usuario.getFechaRegistro().format(dateFormat));
			} else if (prop.getNombre().equals("premium")) {
				prop.setValor(String.valueOf(usuario.isPremium()));
			} else if (prop.getNombre().equals("contactos")) {
				prop.setValor(obtenerIdsContactos(usuario.getContactos()));
			} else if (prop.getNombre().equals("descuento")) {
				prop.setValor(String.valueOf(usuario.getDescuento()));
			} else if (prop.getNombre().equals("mensajesEnviados")) {
				prop.setValor(obtenerIdsMensajes(usuario.getMensajes()));
			} 
			servPersistencia.modificarPropiedad(prop);
		}
	}

	// Recupera el usuario guardado en la base de datos con el id dado
	public Usuario recuperarUsuarioId(int id) {
		// 1. Si el objeto está en el pool se retorna
		if (PoolDAO.getUnicaInstancia().contiene(id))
			return (Usuario) PoolDAO.getUnicaInstancia().getObjeto(id);

		// 2. Si no lo está se recupera entidad y las propiedades de campos de tipo
		// primitivo
		String nombre = null;
		char[] contrasena;
		String numTelefono = null;
		String email = null;
		LocalDate fechaNacimiento = null;
		String imagenPerfil = null;
		String mensajeSaludo = null;
		LocalDate fechaRegistro = null;
		boolean premium;
		List<Contacto> contactos;
		Descuento descuento;
		List<Mensaje> mensajes;

		// Recupero la entidad
		Entidad eUsuario = servPersistencia.recuperarEntidad(id);

		// Recupero las propiedades de tipo primitivo
		nombre = servPersistencia.recuperarPropiedadEntidad(eUsuario, "nombre");
		contrasena = servPersistencia.recuperarPropiedadEntidad(eUsuario, "contrasena").toCharArray();
		numTelefono = servPersistencia.recuperarPropiedadEntidad(eUsuario, "numTelefono");
		email = servPersistencia.recuperarPropiedadEntidad(eUsuario, "email");
		fechaNacimiento = (servPersistencia.recuperarPropiedadEntidad(eUsuario, "fechaNacimiento") == "") ? null : LocalDate.parse(servPersistencia.recuperarPropiedadEntidad(eUsuario, "fechaNacimiento"),dateFormat);
		imagenPerfil = servPersistencia.recuperarPropiedadEntidad(eUsuario, "imagenPerfil");
		mensajeSaludo = servPersistencia.recuperarPropiedadEntidad(eUsuario, "mensajeSaludo");
		fechaRegistro = LocalDate.parse(servPersistencia.recuperarPropiedadEntidad(eUsuario, "fechaRegistro"),dateFormat);
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

		// descuento = servPersistencia.recuperarPropiedadEntidad(eUsuario,"descuento");
		// usuario.setDescuento(descuento);

		mensajes = obtenerMensajesDesdeIds(
				servPersistencia.recuperarPropiedadEntidad(eUsuario, "mensajesEnviados"));
		for (Mensaje m : mensajes) {
			usuario.addMensaje(m);
		}


		// 5. Se retorna el objeto
		return usuario;
	}
	
	// Recupera el usuario que tenga el telefono dado
	public Usuario recuperarUsuarioTelefono(String numTelefono) {
		List<Usuario> users = recuperarTodosUsuarios();
		return users.stream().filter(
				u -> u.getNumTelefono().equals(numTelefono)).findFirst().orElse(null);
	}

	// Recupera una lista con todos los usuarios de la memoria
	public List<Usuario> recuperarTodosUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		List<Entidad> eUsuarios = servPersistencia.recuperarEntidades("usuario");
		for(Entidad eUsuario : eUsuarios) {
			usuarios.add(recuperarUsuarioId(eUsuario.getId()));
		}
		return usuarios;
	}

	// Combierte la lista de contactos de un usuario en un String
	private String obtenerIdsContactos(List<Contacto> contactos) {
		String lista = "";
		for (Contacto c : contactos) {
			lista += c.getId() + " ";
		}
		return lista.trim();
	}

	// Combierte un String en una lista de contactos
	private List<Contacto> obtenerContactosDesdeIds(String lista) {
		List<Contacto> contactos = new LinkedList<Contacto>();
		StringTokenizer strTok = new StringTokenizer(lista, " ");
		AdaptadorContacto adaptadorC = AdaptadorContacto.getUnicaInstancia();
		while (strTok.hasMoreTokens()) {
			contactos.add(adaptadorC.recuperarContacto(Integer.valueOf((String) strTok.nextElement())));
		}
		return contactos;
	}

	// Combierte la lista de mensajes de un usuario en un String
	private String obtenerIdsMensajes(Map<String,List<Mensaje>> mensajes) {
		String lista = "";
		for (List<Mensaje> ms : mensajes.values()) {
			for(Mensaje m : ms) {
				lista += m.getId() + " ";
			}
		}
		return lista.trim();
	}
	
	// Combierte un String en una lista de mensajes
	private List<Mensaje> obtenerMensajesDesdeIds(String lista) {
		List<Mensaje> mensajes = new LinkedList<Mensaje>();
		StringTokenizer strTok = new StringTokenizer(lista, " ");
		AdaptadorMensaje adaptadorM = AdaptadorMensaje.getUnicaInstancia();
		while (strTok.hasMoreTokens()) {
			mensajes.add(adaptadorM.recuperarMensaje(Integer.valueOf((String) strTok.nextElement())));
		}
		return mensajes;
	}

	// Comprueba si ya existe un usuario en la base de datos que tenga el telefono dado
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

}