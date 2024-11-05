import javax.swing.JFrame;

public class HolaMundoSwing {

	public static void main(String[] args) {
		
		//JFrame ventana = new JFrame("Hola Mundo"); // también se puede poner el título en el constructor
		JFrame ventana = new JFrame();
		ventana.setTitle("Hola Mundo"); // Ponerle titulo a la ventana
		ventana.setSize(600, 300);	// Para establecerle un tamaño a la ventana al crearla
		ventana.setLocation(500,200); // Para saber donde va a colocar la ventana en la pantalla al crearla
		// Por defecto al cerrar la ventana con la equis se cierra también la aplicación (La venta principal guay, pero las demás que no cierren la app)
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Para que la equis cierre la ventana y la app
		ventana.setResizable(true); // para que pueda encogerse o ampliarse la ventana
		
		ventana.setVisible(true); // Para que se pueda ver la ventana al ejecutar

	}

}
