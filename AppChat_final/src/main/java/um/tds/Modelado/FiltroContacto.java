package um.tds.Modelado;

import java.util.List;
import java.util.stream.Collectors;

import um.tds.Controlador.Controlador;

public class FiltroContacto extends FiltroDecorator {

	private String busqueda;

	public FiltroContacto(Filtro f, String b) {
		super(f);
		this.busqueda = b;
	}

	@Override
	public List<Mensaje> filtrarMensajes(List<Mensaje> lista) {
		List<Mensaje> l = lista.stream()
				.filter(m -> Controlador.getUnicaInstancia().recuperarContactoMensaje(m).getNombre().equals(busqueda))
				.collect(Collectors.toList());
		return super.filtrarMensajes(l);
	}

}
