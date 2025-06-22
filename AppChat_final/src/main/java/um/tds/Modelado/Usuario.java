package um.tds.Modelado;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Usuario {
	private int id;
	private String nombre;
	private char[] contrasena;
	private String numTelefono;
	private String email;
	private LocalDate fechaNacimiento;
	private String imagenPerfil; // sera el link de la imagen
	private String mensajeSaludo; // deberia ser de tipo mensaje?
	private LocalDate fechaRegistro; // fecha en la que el usuario se registro, para poder calcular el descuento
	private boolean premium;
	private List<Contacto> contactos; // lista de contactos que tiene el usuario
	/* private List<Mensaje> mensajes; */ // Lista con los mensajes que ha recibido o enviado el usuario
	private Map<String, List<Mensaje>> mensajes; // Mapa con los mensajes intercambiados con otros usuarios

	public Usuario(String nombre, String numTelefono, String email, char[] contrasena, LocalDate fechaNacimiento,
			String mensajeSaludo, String imagenPerfil) {
		this.id = 0; // Se actualizara al registrarse en la base de datos
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.numTelefono = numTelefono;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.mensajeSaludo = mensajeSaludo;
		this.fechaRegistro = LocalDate.now();
		if (imagenPerfil.equals("")) {
			this.imagenPerfil = "/imagenes/gato_perfil.png";
		} else {
			this.imagenPerfil = imagenPerfil;
		}

		this.premium = false;
		this.contactos = new LinkedList<Contacto>();
		/* this.mensajes = new LinkedList<>(); */
		this.mensajes = new LinkedHashMap<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public char[] getContrasena() {
		return contrasena;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getImagenPerfil() {
		return imagenPerfil;
	}

	public String getMensajeSaludo() {
		return mensajeSaludo;
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public boolean isPremium() {
		return premium;
	}

	public boolean esEnPeriodo(LocalDate inicio, LocalDate fin) {
		return (this.fechaRegistro.isAfter(inicio) && this.fechaRegistro.isBefore(fin));
	}

	public LinkedList<Contacto> getContactos() {
		return new LinkedList<Contacto>(contactos);
	}

	public Map<String, List<Mensaje>> getMensajes() {
		return new HashMap<String, List<Mensaje>>(mensajes);
	}

	public List<Mensaje> getUltimosMensajes() {
		List<Mensaje> m =  mensajes.values().stream().map(lista -> lista.get(lista.size() - 1)).collect(Collectors.toList());
		return m;
	}

	public boolean isContacto(String otroUsuario) {
		return contactos.stream().anyMatch(c -> {
			if (c instanceof ContactoIndividual) {
				Usuario u = ((ContactoIndividual) c).getUsuario();
				if (u != null) {
					return u.getNumTelefono().equals(otroUsuario);
				}
			} else if(c instanceof Grupo) {
				return String.valueOf(c.getId()).equals(otroUsuario);
			}
			return false;
		});
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setContrasena(char[] contrasena) {
		this.contrasena = contrasena;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setImagenPerfil(String imagenPerfil) {
		this.imagenPerfil = imagenPerfil;
	}

	public void setMensajeSaludo(String mensajeSaludo) {
		this.mensajeSaludo = mensajeSaludo;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	public void addMensaje(Mensaje mensaje) {
		/* mensajes.add(mensaje); */
		if (mensaje.getEmisor().equals(String.valueOf(getId()))) { // lo guarda en la lista del receptor (el otro)
			mensajes.get(mensaje.getReceptor()).add(mensaje);
		} else { // lo guarda en la lista del emisor (el otro)
			if (mensaje.getEmisor().equals(getNumTelefono())) { // lo guarda en la lista del receptor (el otro)
				if (!mensajes.containsKey(mensaje.getReceptor())) {
					mensajes.put(mensaje.getReceptor(), new LinkedList<>());
				}
				mensajes.get(mensaje.getReceptor()).add(mensaje);
			} else { // lo guarda en la lista del emisor (el otro)
				if (!mensajes.containsKey(mensaje.getEmisor())) {
					mensajes.put(mensaje.getEmisor(), new LinkedList<>());
				}
				mensajes.get(mensaje.getEmisor()).add(mensaje);
			}
		}
	}

	// Para añadir contactos, primero comprueba que no tenga un contacto con el
	// nombre del nuevo.
	// En el caso de que ya le haya asignado un contacto a este usuario, lo
	// actualiza, si no simplemente lo añade
	public String addContacto(ContactoIndividual contacto) {
		if (contactos.stream().filter(c -> c instanceof ContactoIndividual).map(c -> (ContactoIndividual) c).anyMatch(
				c -> (c.getNombre().equals(contacto.getNombre()) || c.getUsuario().equals(contacto.getUsuario())))) {
			// ya existe un contacto individual con este nombre
			return "Ya existe este contacto";
		}

		/*
		 * contactos.removeIf(c -> c instanceof ContactoIndividual &&
		 * ((ContactoIndividual) c).getUsuario().equals(contacto.getUsuario()));
		 */
		contactos.add(contacto);
		return "";
	}

	public boolean addGrupo(Grupo grupo) {
		if (contactos.stream().filter(g -> g instanceof Grupo).anyMatch(g -> g.getNombre().equals(grupo.getNombre()))) {
			return false;
		}
		return contactos.add(grupo);
	}

	public Mensaje enviarMensaje(String texto, int emoticono, String receptor, TipoReceptor tipoReceptor) {
		return new Mensaje(texto, emoticono, this.getNumTelefono(), receptor, tipoReceptor);
		// mensaje = mensaje.enviarMensaje(texto, emoticono, this.getNumTelefono(),
		// receptor, tipoReceptor);
		// return mensaje;
	}

	public Contacto recuperarContactoPorUsuario(Usuario u) {
		return contactos.stream().filter(c -> ((ContactoIndividual) c).getUsuario().equals(u)).findFirst().orElse(null);
	}

	public List<Mensaje> recuperarConversacion(Contacto contacto) {
		if (contacto instanceof Grupo) {
			return mensajes.get(String.valueOf(contacto.getId()));
		} else {
			return mensajes.get(((ContactoIndividual) contacto).getUsuario().getNumTelefono());
		}


	// Comprueba el número de mensajes que ha enviado el usuario en el último mes
	// para ver si merece el descuento
	public int getNumMensajesEnviadosUltimoMes() {
		return (int) mensajes.values().stream().flatMap(List::stream)
				.filter(m -> m.getEmisor().equals(this.getNumTelefono())
						&& m.getFechaHora().getMonth().equals(LocalDate.now().minusMonths(1).getMonth())
						&& m.getFechaHora().getYear() == LocalDate.now().minusMonths(1).getYear())
				.count();
	}

}