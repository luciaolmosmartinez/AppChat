package um.tds.ServicioDescuento;

import java.time.LocalDate;
import java.time.Month;

import um.tds.Modelado.*;

public class ServicioDescuento {
	private static final double PRECIO_PREMIUM = 19.95;
	private static final LocalDate COMIENZO = LocalDate.of(2025, Month.FEBRUARY, 21);
	private static final LocalDate FIN = LocalDate.of(2025, Month.JUNE, 21);
	private static final int MUCHOS_MENSAJES = 300;
	
	private Descuento descuento;

	public ServicioDescuento() {}

	public double getPrecioPremium() {
		return PRECIO_PREMIUM;
	}

	// Elige el descuento que se va a aplicar, estan ordenadas de mayor a menor
	// descuento
	public double calcualarPrecioFinal(Usuario usuario) {
		if (usuario.getNumMensajesEnviadosUltimoMes() >= MUCHOS_MENSAJES) {
			descuento = new DescuentoMensaje();
		} else if (usuario.getFechaRegistro().isAfter(COMIENZO) && usuario.getFechaRegistro().isBefore(FIN)) {
			descuento = new DescuentoFecha();
		} else {
			descuento = new SinDescuento();
		}
		
		// Aplica el descuento
		return descuento.calcularDescuento(PRECIO_PREMIUM);
	}
}
