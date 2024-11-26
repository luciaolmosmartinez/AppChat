package modelado;

import java.time.LocalDate;

public class DescuentoFecha implements Descuento {

	private LocalDate comienzo;
	private LocalDate fin;

	public DescuentoFecha(LocalDate comienzo, LocalDate fin) {
		this.comienzo = comienzo;
		this.fin = fin;
	}

	@Override
	public boolean calcularDescuento(LocalDate registroU) {
		boolean descuento = true;
		return descuento;
	}
}
