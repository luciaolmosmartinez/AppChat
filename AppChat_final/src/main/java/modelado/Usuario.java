package modelado;

import java.time.LocalDate;

public class Usuario {
	private String nombre;
	private String contrasena;
	private int numTelefono;
	private String email;
	private LocalDate fechaNacimiento;
	private String imagenPerfil; // sera el link de la imagen
	private String mensajeSaludo; // deberia ser de tipo mensaje?
	private LocalDate fechaRegistro; // fecha en la que el usuario se registro, para poder calcular el descuento

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
}
