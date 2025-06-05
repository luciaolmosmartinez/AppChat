package um.tds.Persistencia;

import java.util.List;

import um.tds.Modelado.Grupo;

public interface IAdaptadorGrupoDAO {
	public Grupo registrarGrupo(Grupo grupo);

	public Grupo recuperarGrupo(int id);

	public List<Grupo> recuperarTodosGrupos();
	
	public boolean agregarContacto(Grupo grupo);
	
	public boolean eliminarContacto(Grupo grupo);
}
