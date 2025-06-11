package um.tds.Persistencia;

import java.util.List;

import um.tds.Modelado.Grupo;

public interface IAdaptadorGrupoDAO {
	public void registrarGrupo(Grupo grupo);

	public Grupo recuperarGrupo(int id);

	public List<Grupo> recuperarTodosGrupos();
	
	public void agregarEliminarMiembro(Grupo grupo);
	
	//public boolean eliminarGrupo(Grupo grupo);
}
