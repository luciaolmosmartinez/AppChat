package um.tds.Modelado;

public class AppChat {
	
	private Usuario usuarioActual;
	
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
