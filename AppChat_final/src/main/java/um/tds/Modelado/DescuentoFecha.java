package um.tds.Modelado;

public class DescuentoFecha implements Descuento {
	private final static double DESCUENTO_FECHA_REGISTRO = 0.10;

	public double calcularDescuento(double precio) {
		return (1.0 - DESCUENTO_FECHA_REGISTRO) * precio ;
	}
}
