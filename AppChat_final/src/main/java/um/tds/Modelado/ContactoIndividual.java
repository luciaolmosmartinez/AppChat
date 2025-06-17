package um.tds.Modelado;

public class ContactoIndividual extends Contacto {
	private Usuario usuario;
	private String email;

	public ContactoIndividual(Usuario usuario, String nombre, String email) {
		super(nombre);
		this.usuario = usuario;
		this.email = email;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
