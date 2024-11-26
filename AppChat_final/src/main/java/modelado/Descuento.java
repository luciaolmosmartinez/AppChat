package modelado;

import java.time.LocalDate;

public interface Descuento {
	public boolean calcularDescuento(LocalDate registroU);
}
