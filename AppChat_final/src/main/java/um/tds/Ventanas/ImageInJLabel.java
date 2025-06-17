package um.tds.Ventanas;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageInJLabel {
	public static void resizeImage(JLabel label, URL originalIcon) {
		ImageIcon og = new ImageIcon(originalIcon);
		if (og.getIconWidth() > 0 && og.getIconHeight() > 0) {
			Image image = og.getImage();
			Image resizedImage = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
			label.setIcon(new ImageIcon(resizedImage));
		}
	}

	public static void actualizarImagen(JLabel label, URL originalIcon) {
		int ancho = label.getWidth();
		int alto = label.getHeight();
		
		if (ancho == 0 || alto == 0) {
			return;
		}
		if (ancho > alto) {
			ancho = alto;
		} else if (alto > ancho) {
			alto = ancho;
		}
		// Escalar la imagen manteniendo la calidad
		ImageIcon og = new ImageIcon(originalIcon);
		Image image = og.getImage();
		Image imagenEscalada = image.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(imagenEscalada));
	}
}
