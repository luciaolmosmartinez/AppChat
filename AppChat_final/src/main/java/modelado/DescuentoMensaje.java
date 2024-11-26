package modelado;

import java.time.LocalDate;

public class DescuentoMensaje implements Descuento {
	@Override
	public boolean calcularDescuento(LocalDate registroU) {
		boolean descuento = true;
		return descuento;
	}
}
