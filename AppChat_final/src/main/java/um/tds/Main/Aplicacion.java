package um.tds.Main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Properties;

import javax.swing.UIManager;

import com.jtattoo.plaf.fast.FastLookAndFeel;

import um.tds.Ventanas.VentanaInicio;

public class Aplicacion {
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				DataLoader.cargarDatosIniciales();
				try {
					Properties propiedades = new Properties();
					propiedades.put("windowTitleBackgroundColor", "254 127 154");
					propiedades.put("foregroundColor", "118 5 65"); // Color del texto
					propiedades.put("controlColor", "255 255 255"); // Color de botones y paneles
					propiedades.put("buttonColor", "255 255 255"); // Color de los botones
					propiedades.put("frameColor", "254 127 154"); // Color del marco de la ventana
					propiedades.put("rolloverColor", "254 127 154"); // Color al pasar el mouse
					propiedades.put("selectionBackgroundColor", "255 255 255"); // Fondo de selección
					propiedades.put("Menu.background", "255 255 255");
					propiedades.put("Menu.selectionBackground", "255 255 255");  
					propiedades.put("MenuItem.background", "255 255 255");
					propiedades.put("MenuItem.selectionBackground", "255 255 255");
					FastLookAndFeel.setTheme(propiedades);
					UIManager.setLookAndFeel(new FastLookAndFeel());
					// llama a la ventana main
					try {
						Dimension tamVentana = new Dimension(900, 550);
						Dimension tamPantalla = Toolkit.getDefaultToolkit().getScreenSize();
						int x = (tamPantalla.width - tamVentana.width) / 2;
						int y = (tamPantalla.height - tamVentana.height) / 2;
						new VentanaInicio(tamVentana, new Point(x, y));
						//ventana.mostrarInicio(tamVentana, new Point(x, y));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
