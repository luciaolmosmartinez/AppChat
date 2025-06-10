package um.tds.Persistencia;


public abstract class FactoriaDAO {
	private static FactoriaDAO unicaInstancia;
	
	public final static String DAO_TDS = "um.tds.Persistencia.FactoriaDAO_TDS";
	
	// Crea un tipo de factoria DAO. Solo existe el tipo FactoriaDAO_TDS
	public static FactoriaDAO getInstancia(String tipo) throws DAOException {
		if (unicaInstancia == null) {
			try {
				unicaInstancia = (FactoriaDAO) Class.forName(tipo).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				throw new DAOException(e.getMessage());
			}
		}
		return unicaInstancia;
	}

	public static FactoriaDAO getInstancia() throws DAOException {
		if (unicaInstancia == null) {
			return getInstancia (FactoriaDAO.DAO_TDS);
		} else {
			return unicaInstancia;
		}
	}

	// Constructor
	protected FactoriaDAO() {
	}

	// Metodos factoria que devuelven adaptadores que implementen estas interfaces
	public abstract IAdaptadorUsuarioDAO getUsuarioDAO();

	public abstract IAdaptadorMensajeDAO getMensajeDAO();

	public abstract IAdaptadorContactoDAO getContactoDAO();

	public abstract IAdaptadorGrupoDAO getGrupoDAO();
}
