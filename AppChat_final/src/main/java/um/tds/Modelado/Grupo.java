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

	public List<ContactoIndividual> getMiembros() {
		return new LinkedList<ContactoIndividual>(miembros);
	}
	
	public void addMiembro(ContactoIndividual miembro) {
		miembros.add(miembro);
	}

}
