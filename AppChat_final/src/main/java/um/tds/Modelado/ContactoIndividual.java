package um.tds.Modelado;

public class ContactoIndividual extends Contacto {
	private Usuario usuario;

	public ContactoIndividual(Usuario usuario, String nombre) {
		super(nombre);
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String getImagen() {
		return usuario.getImagenPerfil();
	}

}
