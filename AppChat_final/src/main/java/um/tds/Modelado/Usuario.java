package um.tds.Modelado;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
	private Map<String,Mensaje> mensajesEnviados;	// Mapa con el telefono a quién lo envió y el mensaje
	private Map<String,Mensaje> mensajesRecividos;	// Mapa con el telefono de quién lo recivió y el mensaje

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
	
	public boolean esEnPeriodo(LocalDate inicio, LocalDate fin) {
		return (this.fechaRegistro.isAfter(inicio) && this.fechaRegistro.isBefore(fin));
	}

	public LinkedList<Contacto> getContactos() {
		return new LinkedList<Contacto>(contactos);
	}
	
	public Map<String, Mensaje> getMensajesEnviados() {
		return new HashMap<String, Mensaje>(mensajesEnviados);
	}

	public Map<String, Mensaje> getMensajesRecividos() {
		return new HashMap<String, Mensaje>(mensajesRecividos);
	}

	public void addMensajeEnviado(Mensaje mensaje) {
		for(Usuario u:mensaje.getReceptor()) {
			mensajesEnviados.put(u.getNumTelefono(), mensaje);
		}
		
	}
	
	public void addMensajeRecivido(Mensaje mensaje) {
		mensajesRecividos.put(mensaje.getEmisor().getNumTelefono(), mensaje);
	}
	
	public boolean addContacto(ContactoIndividual contacto) {
		for (Contacto c : contactos) {
			if (c instanceof ContactoIndividual) {
				if (c.getNombre().equals(contacto.getNombre())) {
					return false;
				} else if (((ContactoIndividual) c).getUsuario().equals(contacto.getUsuario())) {
					contactos.remove(contacto);
				} 
			}
		}
		return contactos.add(contacto);
	}
	
	public boolean addGrupo(Grupo grupo) {
		for (Contacto g : contactos) {
			if (g instanceof Grupo) {
				if (g.getNombre().equals(grupo.getNombre())) {
					return false;
				}
			}
		}
		return contactos.add(grupo);
	}
	
	public Mensaje enviarMensaje(String texto, int emoticono, Usuario... receptor) {
		Mensaje mensaje = new Mensaje(texto, emoticono, this, receptor);
		mensaje = mensaje.enviarMensaje(texto, emoticono, this, receptor);
		return mensaje;
	}

}
