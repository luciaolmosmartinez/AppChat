package um.tds.Modelado;

import java.util.List;

public class SinFiltro implements Filtro {

	@Override
	public List<Mensaje> filtrarMensajes(List<Mensaje> lista) {
		return lista;
	}

}
