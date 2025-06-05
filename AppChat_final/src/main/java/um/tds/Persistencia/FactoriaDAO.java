package um.tds.Persistencia;

public abstract class FactoriaDAO {
	private static FactoriaDAO INSTANCE;
	public final static String DAO_TDS = "um.tds.persistencia.FactoriaDAO_TDS";
	// Crea un tipo de factoria DAO. Solo existe el tipo TDS_FactoriaDAO
	public static FactoriaDAO getFactoriaDAO(String nombre) throws DAOException {
		if (INSTANCE == null)
			try {
				INSTANCE = (FactoriaDAO) Class.forName(nombre).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				throw new DAOException(e.getMessage());
			}
		return INSTANCE;
	}

	public static FactoriaDAO getFactoriaDAO() {
		return INSTANCE;
	}

	protected FactoriaDAO() {
	}

	public abstract IAdaptadorUsuarioDAO getUsurioDAO();

	public abstract IAdaptadorMensajeDAO getMensajeDAO();

	public abstract IAdaptadorContactoDAO getContactoDAO();

	public abstract IAdaptadorGrupoDAO getGrupoDAO();
}
