package modelado;

public class ContactoIndividual extends Contacto {
	private Usuario usuario;

	public ContactoIndividual(Usuario usuario, String nombre) {
		super(nombre);
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
