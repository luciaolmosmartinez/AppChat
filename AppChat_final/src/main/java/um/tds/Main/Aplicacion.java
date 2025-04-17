package um.tds.Main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.Properties;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.jtattoo.plaf.fast.FastLookAndFeel;

import um.tds.Modelado.RepositorioUsuarios;
import um.tds.Modelado.AppChat;
import um.tds.Ventanas.*;

public class Aplicacion {
	private static RepositorioUsuarios repoU = new RepositorioUsuarios();
	private static AppChat controlador;
	
	public static void main(final String[] args) {
		controlador = new AppChat(repoU);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Properties propiedades = new Properties();
					propiedades.put("windowTitleBackgroundColor", "254 127 154");
					propiedades.put("foregroundColor", "118 5 65"); // Color del texto
					propiedades.put("controlColor", "255 255 255"); // Color de botones y paneles
					propiedades.put("buttonColor", "255 255 255"); // Color de los botones
					propiedades.put("frameColor", "254 127 154"); // Color del marco de la ventana
					propiedades.put("rolloverColor", "254 127 154"); // Color al pasar el mouse
					propiedades.put("selectionBackgroundColor", "255 255 255"); // Fondo de selección
					FastLookAndFeel.setTheme(propiedades);
					UIManager.setLookAndFeel(new FastLookAndFeel());
					VentanaInicio ventana = new VentanaInicio(controlador);
					ventana.mostrarInicio();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
