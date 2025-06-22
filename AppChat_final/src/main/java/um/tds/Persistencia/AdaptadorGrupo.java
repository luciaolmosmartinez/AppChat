package um.tds.Persistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import um.tds.Modelado.*;

public class AdaptadorGrupo implements IAdaptadorGrupoDAO {
	private static ServicioPersistencia servPersistencia;
	private static AdaptadorGrupo unicaInstancia = null;

	public static AdaptadorGrupo getUnicaInstancia() { // patron singleton
		if (unicaInstancia == null)
			return new AdaptadorGrupo();
		else
			return unicaInstancia;
	}

	private AdaptadorGrupo() {
		AdaptadorGrupo.servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}

	public void registrarGrupo(Grupo grupo) {
		// 1. Se comprueba que no está registrada la entidad que corresponde
		// al código del objeto (un objeto se crea con id = 0 o id = -1)
		Entidad eGrupo = null;
		try {
			eGrupo = servPersistencia.recuperarEntidad(grupo.getId());
		} catch (NullPointerException e) {
		}

		if (eGrupo != null) {
			return;
		}

		// 2. Se registran sus objetos agregados.
		// NO SE SI HACE FALTA
		AdaptadorContacto adaptadorC = AdaptadorContacto.getUnicaInstancia();
		for (ContactoIndividual c : grupo.getMiembros()) {
			adaptadorC.anadirContacto(c);
		}

		// 3. Se crea la entidad (ya tiene un id)
		eGrupo = new Entidad();
		eGrupo.setNombre("grupo");

		// 4. Se le añaden las propiedades a la entidad creada
		eGrupo.setPropiedades(new ArrayList<Propiedad>(
				Arrays.asList(new Propiedad("nombre", grupo.getNombre()), new Propiedad("imagen", grupo.getImagen()),
						new Propiedad("miembros", obtenerIdsMiembros(grupo.getMiembros())),
						new Propiedad("tipo", "grupo"))));

		// 5. Se registra la entidad y se asocia id al objeto almacenado.
		eGrupo = servPersistencia.registrarEntidad(eGrupo);
		grupo.setId(eGrupo.getId());
	}

	public Grupo recuperarGrupo(int id) {
		// 1. Si el objeto está en el pool se retorna
		if (PoolDAO.getUnicaInstancia().contiene(id))
			return (Grupo) PoolDAO.getUnicaInstancia().getObjeto(id);

		// 2. Si no lo está se recupera entidad y las propiedades de campos de tipo
		// primitivo
		String nombre = null;
		String imagen;
		List<ContactoIndividual> miembros;

		// Recupero la entidad
		Entidad eGrupo = servPersistencia.recuperarEntidad(id);

		// Recupero las propiedades de tipo primitivo
		nombre = servPersistencia.recuperarPropiedadEntidad(eGrupo, "nombre");
		imagen = servPersistencia.recuperarPropiedadEntidad(eGrupo, "imagen");

		// 3. Se crea el objeto, se inicializa con propiedades anteriores y se añade al
		// pool si es necesario
		Grupo grupo = new Grupo(nombre, imagen);
		grupo.setId(id);
		/*
		 * grupo.setNombre(nombre); grupo.setImagen(imagen);
		 */

		PoolDAO.getUnicaInstancia().addObjeto(id, grupo);

		// 4. Se recuperan los objetos referenciados y se actualiza el objeto
		miembros = obtenerMiembrosDesdeIds(servPersistencia.recuperarPropiedadEntidad(eGrupo, "miembros"));
		for (ContactoIndividual c : miembros) {
			grupo.addMiembro(c);
		}

		// 5. Se retorna el objeto
		return grupo;
	}

	public List<Grupo> recuperarTodosGrupos() {
		List<Grupo> grupos = new ArrayList<>();
		List<Entidad> eGrupos = servPersistencia.recuperarEntidades("grupo");
		for (Entidad eGrupo : eGrupos) {
			grupos.add(recuperarGrupo(eGrupo.getId()));
		}
		return grupos;
	}

	public void agregarEliminarMiembro(Grupo grupo) {
		// 1. Se recupera entidad
		Entidad eGrupo = servPersistencia.recuperarEntidad(grupo.getId());

		// 2. Se recorren sus propiedades y se actualiza su valor
		for (Propiedad prop : eGrupo.getPropiedades()) {
			if (prop.getNombre().equals("id")) {
				prop.setValor(String.valueOf(grupo.getId()));
			} else if (prop.getNombre().equals("nombre")) {
				prop.setValor(grupo.getNombre());
			} else if (prop.getNombre().equals("miembros")) {
				prop.setValor(obtenerIdsMiembros(grupo.getMiembros()));
			}
			servPersistencia.modificarPropiedad(prop);
		}
	}

	public void modificarGrupo(Grupo grupo) {
		// 1. Se recupera entidad
		Entidad eGrupo = servPersistencia.recuperarEntidad(grupo.getId());

		// 2. Se recorren sus propiedades y se actualiza su valor
		for (Propiedad prop : eGrupo.getPropiedades()) {
			if (prop.getNombre().equals("id")) {
				prop.setValor(String.valueOf(grupo.getId()));
			} else if (prop.getNombre().equals("nombre")) {
				prop.setValor(grupo.getNombre());
			} else if (prop.getNombre().equals("imagen")) {
				prop.setValor(grupo.getImagen());
			} else if (prop.getNombre().equals("miembros")) {
				prop.setValor(obtenerIdsMiembros(grupo.getMiembros()));
			}
			servPersistencia.modificarPropiedad(prop);
		}
	}

	/*
	 * public boolean eliminarGrupo(Grupo grupo) { return false; }
	 */

	private String obtenerIdsMiembros(List<ContactoIndividual> miembros) {
		String lista = "";
		for (ContactoIndividual c : miembros) {
			lista += c.getId() + " ";
		}
		return lista.trim();
	}

	private List<ContactoIndividual> obtenerMiembrosDesdeIds(String lista) {
		List<ContactoIndividual> miembros = new LinkedList<ContactoIndividual>();
		StringTokenizer strTok = new StringTokenizer(lista, " ");
		AdaptadorContacto adaptadorC = AdaptadorContacto.getUnicaInstancia();
		while (strTok.hasMoreTokens()) {
			String s = (String) strTok.nextElement();
			int id = Integer.parseInt(s);
			miembros.add((ContactoIndividual) adaptadorC.recuperarContacto(id));
		}
		return miembros;
	}
}
