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

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (!(obj instanceof ContactoIndividual))
	        return false;
	    if (!super.equals(obj))
	        return false;
	    ContactoIndividual other = (ContactoIndividual) obj;
	    if (usuario == null) {
	        if (other.usuario != null)
	            return false;
	    } else if (!usuario.equals(other.usuario))
	        return false;
	    return true;
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = super.hashCode();
	    result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
	    return result;
	}

}
