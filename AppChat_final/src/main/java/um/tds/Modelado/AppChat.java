package um.tds.Modelado;

import java.util.Date;

public class AppChat { //clase controlador
	
	private Usuario usuarioActual;
	private RepositorioUsuarios repoU;
	
	public AppChat(RepositorioUsuarios repoU) {
		this.repoU = repoU;
	}

	public boolean crearUsuario(String nombre, String apellidos, String telefono, String correo, char[] contrasena, Date fecha,
			String saludo, String imagen) {
		Usuario usuario = new Usuario(nombre,apellidos,telefono,correo,contrasena,fecha,saludo,imagen);
		return repoU.crearUsuario(usuario);
	}
	
	public boolean iniciarSesion(String telefono, char[] contrasena) {
		this.usuarioActual = repoU.comprobarUsuario(telefono,contrasena);
		if (usuarioActual != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Usuario getUsuarioActual() {
		return usuarioActual;
	}

	public void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}

	public void enviarMensaje(Contacto receptor, String texto, int emoticono) {
		usuarioActual.enviarMensaje(receptor,texto,emoticono,usuarioActual);
	}
	
	public void crearPDF() {
		CreadorPDF.crearPDF();
	}
}
