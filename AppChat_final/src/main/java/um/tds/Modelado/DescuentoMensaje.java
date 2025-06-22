package um.tds.Modelado;

public class DescuentoMensaje implements Descuento {
	private final static double DESCUENTO_MUCHOS_MENSAJES = 0.50;

	public double calcularDescuento(double precio) {
		return (1.0 - DESCUENTO_MUCHOS_MENSAJES) * precio ;
	}
}
