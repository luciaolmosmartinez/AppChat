package um.tds.Modelado;

import java.util.List;
import java.util.stream.Collectors;

import um.tds.Controlador.Controlador;

public class FiltroTelefono extends FiltroDecorator {

	private String busqueda;

	public FiltroTelefono(Filtro f, String b) {
		super(f);
		this.busqueda = b;
	}

	@Override
	public List<Mensaje> filtrarMensajes(List<Mensaje> lista) {
		List<Mensaje> l = lista.stream()
				.filter(m -> m.getEmisor().equals(busqueda)
						|| (esNumeroTelefono(m.getReceptor()) && m.getReceptor().equals(busqueda))
						|| (!esNumeroTelefono(m.getReceptor()) && Controlador.getUnicaInstancia()
								.recuperarGrupo(Integer.parseInt(m.getReceptor())).getMiembros().stream()
								.anyMatch(mi -> mi.getUsuario().getNumTelefono().equals(busqueda))))
				.collect(Collectors.toList());
		return super.filtrarMensajes(l);
	}

	public boolean esNumeroTelefono(String n) {
		if (n.length() == 9) {
			return true;
		} else {
			return false;
		}
	}

}
