package um.tds;

import java.util.Properties;

import javax.swing.UIManager;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("controlColor", "254 127 154");
		props.put("rolloverColor", "254 127 154"); 
		props.put("windowTitleForegroundColor", "254 127 154");
        props.put("windowTitleBackgroundColor", "254 127 154");
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			Ventana_inicio inicio = new Ventana_inicio();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
