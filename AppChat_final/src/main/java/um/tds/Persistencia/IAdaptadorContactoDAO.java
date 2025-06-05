package um.tds.Persistencia;

import java.util.List;

import um.tds.Modelado.ContactoIndividual;

public interface IAdaptadorContactoDAO {
	public ContactoIndividual anadirContacto(ContactoIndividual contacto);

	public ContactoIndividual recuperarContacto(int id);

	public List<ContactoIndividual> recuperarTodosContactos();
}
