package um.tds.Modelado;

public class SinDescuento implements Descuento {

	@Override
	public double calcularDescuento(double precio) {
		return precio;
	}

}
