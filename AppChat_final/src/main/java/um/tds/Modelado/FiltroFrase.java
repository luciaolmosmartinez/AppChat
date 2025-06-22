package um.tds.Modelado;

import java.util.List;
import java.util.stream.Collectors;

public class FiltroFrase extends FiltroDecorator {

	private String busqueda;

	public FiltroFrase(Filtro f, String b) {
		super(f);
		this.busqueda = b;
	}
	
	@Override
	public List<Mensaje> filtrarMensajes(List<Mensaje> lista) {
		List<Mensaje> l = lista.stream()
				.filter(m -> m.getTexto().contains(busqueda))
				.collect(Collectors.toList());
		return super.filtrarMensajes(l);
	}

}
