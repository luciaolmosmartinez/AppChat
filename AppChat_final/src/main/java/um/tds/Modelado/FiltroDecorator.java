package um.tds.Modelado;

import java.util.List;

public class FiltroDecorator implements Filtro {

	protected Filtro filtro;
	
	public FiltroDecorator(Filtro filtro) {
		this.filtro = filtro;
	}
	
	@Override
	public List<Mensaje> filtrarMensajes(List<Mensaje> lista) {
		return this.filtro.filtrarMensajes(lista);
	}

}
