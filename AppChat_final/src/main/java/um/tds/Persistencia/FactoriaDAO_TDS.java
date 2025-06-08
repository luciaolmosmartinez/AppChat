package um.tds.Persistencia;

public class FactoriaDAO_TDS extends FactoriaDAO{
	public IAdaptadorUsuarioDAO getUsuarioDAO() {
		return AdaptadorUsuario.getUnicaInstancia();
	}

	public IAdaptadorContactoDAO getContactoDAO() {
		return AdaptadorContacto.getUnicaInstancia();
	}

	public IAdaptadorMensajeDAO getMensajeDAO() {
		return AdaptadorMensaje.getUnicaInstancia();
	}

	public IAdaptadorGrupoDAO getGrupoDAO() {
		return AdaptadorGrupo.getUnicaInstancia();
	}
}
