package um.tds.Modelado;

import java.util.LinkedList;

public class Grupo extends Contacto {
	private LinkedList<ContactoIndividual> miembros;

	public Grupo(String nombre) {
		super(nombre);
		this.miembros = new LinkedList<>();
	}
	
	public LinkedList<ContactoIndividual> getMiembros() {
		return new LinkedList<ContactoIndividual>(miembros);
	}

}
