package um.tds.Persistencia;

import java.util.List;

import um.tds.Modelado.Contacto;
import um.tds.Modelado.ContactoIndividual;

public interface IAdaptadorContactoDAO {
	public void anadirContacto(ContactoIndividual contacto);

	public Contacto recuperarContacto(int id);

	public List<ContactoIndividual> recuperarTodosContactos();
	
	public void modificarContacto(ContactoIndividual contacto);
}
