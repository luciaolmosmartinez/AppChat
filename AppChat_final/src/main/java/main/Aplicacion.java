package main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.Properties;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.jtattoo.plaf.fast.FastLookAndFeel;

import um.tds.*;

public class Aplicacion {
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Properties propiedades = new Properties();
					propiedades.put("windowTitleBackgroundColor", "254 127 154");
		            propiedades.put("foregroundColor", "254 127 154");    // Color del texto
		            propiedades.put("controlColor", "255 255 255");    // Color de botones y paneles
		            propiedades.put("buttonColor", "255 255 255");     // Color de los botones
		            propiedades.put("frameColor", "254 127 154");      // Color del marco de la ventana
		            propiedades.put("rolloverColor", "254 127 154");   // Color al pasar el mouse
		            propiedades.put("selectionBackgroundColor", "255 255 255"); // Fondo de selección
		            FastLookAndFeel.setTheme(propiedades);
					UIManager.setLookAndFeel(new FastLookAndFeel());
					Ventana_inicio ventana = new Ventana_inicio();
					ventana.mostrarInicio();
				} catch (Exception e) {				
					e.printStackTrace();
				}
			}
		});
	}
}
