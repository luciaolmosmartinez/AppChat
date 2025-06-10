package um.tds.Modelado;

import java.time.LocalDate;
import java.util.*;

public class Usuario {
	private int id;
	private String nombre;
	private char[] contrasena;
	private String numTelefono;
	private String email;
	private Date fechaNacimiento;
	private String imagenPerfil; // sera el link de la imagen
	private String mensajeSaludo; // deberia ser de tipo mensaje?
	private LocalDate fechaRegistro; // fecha en la que el usuario se registro, para poder calcular el descuento
	private boolean premium;
	private List<Contacto> contactos; // lista de contactos que tiene el usuario
	private Descuento descuento;
	private Map<String, Mensaje> mensajesEnviados; // Mapa con el telefono a quién lo envió y el mensaje
	private Map<String, Mensaje> mensajesRecibidos; // Mapa con el telefono de quién lo recivió y el mensaje

	public Usuario(String nombre, String numTelefono, String email, char[] contrasena, Date fechaNacimiento,
			String mensajeSaludo, String imagenPerfil) {
		this.id = 0; // Se actualizará al registrarse en la base de datos
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.numTelefono = numTelefono;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.mensajeSaludo = mensajeSaludo;
		this.fechaRegistro = LocalDate.now();
		this.imagenPerfil = imagenPerfil;
		this.premium = false;
		this.contactos = new LinkedList<>();
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

	public Date getFechaNacimiento() {
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
	

	public Descuento getDescuento() {
		return descuento;
	}

	public boolean esEnPeriodo(LocalDate inicio, LocalDate fin) {
		return (this.fechaRegistro.isAfter(inicio) && this.fechaRegistro.isBefore(fin));
	}

	public LinkedList<Contacto> getContactos() {
		return new LinkedList<Contacto>(contactos);
	}

	public Map<String, Mensaje> getMensajesEnviados() {
		return new HashMap<String, Mensaje>(mensajesEnviados);
	}

	public Map<String, Mensaje> getmensajesRecibidos() {
		return new HashMap<String, Mensaje>(mensajesRecibidos);
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

	public void setFechaNacimiento(Date fechaNacimiento) {
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

	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}

	public void addMensajeEnviado(Mensaje mensaje) {
		mensaje.getReceptor().stream()
							 .forEach(u -> mensajesEnviados.put(u.getNumTelefono(), mensaje));
	}

	public void addMensajeRecibido(Mensaje mensaje) {
		mensajesRecibidos.put(mensaje.getEmisor().getNumTelefono(), mensaje);
	}

	// igual que la siguiente pero sin stream
	/*
	 * public boolean addContacto(ContactoIndividual contacto) { for (Contacto c :
	 * contactos) { if (c instanceof ContactoIndividual) { if
	 * (c.getNombre().equals(contacto.getNombre())) { return false; } else if
	 * (((ContactoIndividual) c).getUsuario().equals(contacto.getUsuario())) {
	 * contactos.remove(contacto); } } } return contactos.add(contacto); }
	 */

	public boolean addContacto(ContactoIndividual contacto) {
		if (contactos.stream()
					 .filter(c -> c instanceof ContactoIndividual)
					 .anyMatch(c -> c.getNombre().equals(contacto.getNombre()))) {
			return false;
		}
		contactos.removeIf(c -> c instanceof ContactoIndividual
				&& ((ContactoIndividual) c).getUsuario().equals(contacto.getUsuario()));

		return contactos.add(contacto);
	}

	public boolean addGrupo(Grupo grupo) {
		if(contactos.stream()
					.filter(g -> g instanceof Grupo)
					.anyMatch(g -> g.getNombre().equals(grupo.getNombre()))) {
			return false;
		}
		return contactos.add(grupo);
	}

	public Mensaje enviarMensaje(String texto, int emoticono, Usuario... receptor) {
		Mensaje mensaje = new Mensaje(texto, emoticono, this, receptor);
		mensaje = mensaje.enviarMensaje(texto, emoticono, this, receptor);
		return mensaje;
	}

}
