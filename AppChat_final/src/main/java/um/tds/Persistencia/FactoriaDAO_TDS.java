package um.tds.Persistencia;

public class FactoriaDAO_TDS extends FactoriaDAO{
	public FactoriaDAO_TDS() {}
	
	@Override
	public IAdaptadorUsuarioDAO getUsuarioDAO() {
		return AdaptadorUsuario.getUnicaInstancia();
	}

	@Override
	public IAdaptadorContactoDAO getContactoDAO() {
		return AdaptadorContacto.getUnicaInstancia();
	}

	@Override
	public IAdaptadorMensajeDAO getMensajeDAO() {
		return AdaptadorMensaje.getUnicaInstancia();
	}

	@Override
	public IAdaptadorGrupoDAO getGrupoDAO() {
		return AdaptadorGrupo.getUnicaInstancia();
	}
}
