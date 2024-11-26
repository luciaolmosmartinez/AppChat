package modelado;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Usuario {
	private String nombre;
	private String contrasena;
	private int numTelefono;
	private String email;
	private LocalDate fechaNacimiento;
	private String imagenPerfil; // sera el link de la imagen
	private String mensajeSaludo; // deberia ser de tipo mensaje?
	private LocalDate fechaRegistro; // fecha en la que el usuario se registro, para poder calcular el descuento
	private boolean premium;
	private LinkedList<Contacto> contactos; //lista de contactos que tiene el usuario

	public Usuario(String nombre, String contrasena, int numTelefono, String email, LocalDate fechaNacimiento,
			String mensajeSaludo) {
		this(nombre, contrasena, numTelefono, email, fechaNacimiento, "", mensajeSaludo);
	}

	public Usuario(String nombre, String contrasena, int numTelefono, String email, LocalDate fechaNacimiento,
			String imagenPerfil, String mensajeSaludo) {
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

	public String getNombre() {
		return nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public int getNumTelefono() {
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

}
