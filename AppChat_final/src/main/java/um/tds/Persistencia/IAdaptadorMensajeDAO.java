package um.tds.Persistencia;

import java.util.List;

import um.tds.Modelado.Mensaje;

public interface IAdaptadorMensajeDAO {
	public void registrarMensaje(Mensaje mensaje);

	public Mensaje recuperarMensaje(int id);

	public List<Mensaje> recuperarTodosMensajes();
}
