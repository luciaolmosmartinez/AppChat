package um.tds.Modelado;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;

public class Usuario {
	private String nombre;
	private char[] contrasena;
	private String numTelefono;
	private String email;
	private LocalDate fechaNacimiento;
	private String imagenPerfil; // sera el link de la imagen
	private String mensajeSaludo; // deberia ser de tipo mensaje?
	private LocalDate fechaRegistro; // fecha en la que el usuario se registro, para poder calcular el descuento
	private boolean premium;
	private LinkedList<Contacto> contactos; // lista de contactos que tiene el usuario
	private Descuento descuento;

	public Usuario(String nombre, String apellidos, String telefono, String correo, char[] contrasena, Date fecha,
			String saludo, String imagen) {
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.numTelefono = telefono;
		this.email = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.mensajeSaludo = mensajeSaludo;
		this.fechaRegistro = LocalDate.now();
		this.imagenPerfil = imagenPerfil;
		this.premium = false;
		this.contactos = new LinkedList<>();
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

	public LinkedList<Contacto> getContactos() {
		return new LinkedList<Contacto>(contactos);
	}

	public Mensaje enviarMensaje(Contacto receptor, String texto, int emoticono, Usuario emisor) {
		Mensaje mensaje = new Mensaje(texto, emoticono, emisor, emisor);
		mensaje = mensaje.enviarMensaje(receptor, texto, emoticono, emisor);
		return mensaje;
	}

}
