package modelado;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class MensajeCellRenderer extends JPanel implements ListCellRenderer<Mensaje> {
	private static final long serialVersionUID = 1L;
	private JLabel nameLabel;
	private JLabel imageLabel;
	private JLabel messageLabel;

	public MensajeCellRenderer() {
		setLayout(new BorderLayout(5, 5));
		messageLabel = new JLabel();
		imageLabel = new JLabel();
		nameLabel = new JLabel();

		add(imageLabel, BorderLayout.WEST);
		add(nameLabel, BorderLayout.NORTH);
		add(messageLabel, BorderLayout.CENTER);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Mensaje> list, Mensaje mensaje, int index,
			boolean isSelected, boolean cellHasFocus) {
		nameLabel.setText(mensaje.getEmisor().getNombre());
		messageLabel.setText(mensaje.getTexto());

		try {
			URL imageURL = new URL("https://robohash.org/" + mensaje.getLength());
			Image image = ImageIO.read(imageURL);
			ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_SMOOTH)); // Tamaño ajustado
			imageLabel.setIcon(imageIcon);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Cambiar el fondo si el elemento está seleccionado
		if (isSelected) {
			setBackground(list.getSelectionBackground());
		} else {
			setBackground(list.getBackground());
		}

		return this; // Retornar el componente renderizado
	}
}
