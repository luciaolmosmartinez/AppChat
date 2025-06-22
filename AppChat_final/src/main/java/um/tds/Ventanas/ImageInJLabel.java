package um.tds.Ventanas;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ImageInJLabel {
	public static void resizeImage(JLabel label, BufferedImage bufferedImage) {
		ImageIcon og = new ImageIcon(bufferedImage);
		if (og.getIconWidth() > 0 && og.getIconHeight() > 0) {
			Image image = og.getImage();
			Image resizedImage = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
			label.setIcon(new ImageIcon(resizedImage));
		}
	}
	
	public static void resizeImage(JMenu m, BufferedImage bufferedImage) {
		ImageIcon og = new ImageIcon(bufferedImage);
		if (og.getIconWidth() > 0 && og.getIconHeight() > 0) {
			Image image = og.getImage();
			Image resizedImage = image.getScaledInstance(m.getWidth(), m.getHeight(), Image.SCALE_SMOOTH);
			m.setIcon(new ImageIcon(resizedImage));
		}
	}
	
	public static void resizeImage(JMenuItem m, BufferedImage bufferedImage) {
		ImageIcon og = new ImageIcon(bufferedImage);
		if (og.getIconWidth() > 0 && og.getIconHeight() > 0) {
			Image image = og.getImage();
			Image resizedImage = image.getScaledInstance(m.getWidth(), m.getHeight(), Image.SCALE_SMOOTH);
			m.setIcon(new ImageIcon(resizedImage));
		}
	}
	
	public static void resizeImage(JButton b, BufferedImage bufferedImage) {
		ImageIcon og = new ImageIcon(bufferedImage);
		if (og.getIconWidth() > 0 && og.getIconHeight() > 0) {
			Image image = og.getImage();
			Image resizedImage = image.getScaledInstance(b.getWidth(), b.getHeight(), Image.SCALE_SMOOTH);
			b.setIcon(new ImageIcon(resizedImage));
		}
	}

	public static void actualizarImagen(JLabel label, BufferedImage bufferedImage) {
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
		ImageIcon og = new ImageIcon(bufferedImage);
		Image image = og.getImage();
		Image imagenEscalada = image.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(imagenEscalada));
	}
}
