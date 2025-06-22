package um.tds.Modelado;

import java.util.LinkedList;
import java.util.List;

public class Grupo extends Contacto {
	private String imagen;
	private List<ContactoIndividual> miembros;
	
	public Grupo(String nombre, String imagen) {
		super(nombre);
		this.miembros = new LinkedList<>();
		this.imagen = imagen;
	}
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public List<ContactoIndividual> getMiembros() {
		return new LinkedList<ContactoIndividual>(miembros);
	}
	
	public void addMiembro(ContactoIndividual miembro) {
		miembros.add(miembro);
	}
	
	public void actualizarMiembros(List<ContactoIndividual> miembrosActualizados) {
		this.miembros = miembrosActualizados;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (!(obj instanceof Grupo))
	        return false;
	    if (!super.equals(obj))
	        return false;
	    Grupo other = (Grupo) obj;
	    if (imagen == null) {
	        if (other.imagen != null)
	            return false;
	    } else if (!imagen.equals(other.imagen))
	        return false;
	    if (miembros == null) {
	        if (other.miembros != null)
	            return false;
	    } else if (!miembros.equals(other.miembros))
	        return false;
	    return true;
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = super.hashCode();
	    result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
	    result = prime * result + ((miembros == null) ? 0 : miembros.hashCode());
	    return result;
	}

}
