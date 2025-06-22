package um.tds.Renderers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import um.tds.Modelado.Contacto;
import um.tds.Ventanas.ImageInJLabel;

public class ContactoCellRenderer extends JPanel implements ListCellRenderer<Contacto> {
	private static final long serialVersionUID = 1L;
	private JLabel nameLabel;
	private JLabel imageLabel;

	public ContactoCellRenderer() {
		setLayout(new BorderLayout(5, 5));

		nameLabel = new JLabel();
		imageLabel = new JLabel();

		add(imageLabel, BorderLayout.WEST);
		add(nameLabel, BorderLayout.CENTER);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Contacto> list, Contacto contacto, int index,
			boolean isSelected, boolean cellHasFocus) {
		if (contacto != null) {
			nameLabel.setText(contacto.getNombre());
			try {
				imageLabel.setIcon(new ImageIcon(contacto.getImagenDirecta()));
				imageLabel.setSize(50, 50);
				ImageInJLabel.resizeImage(imageLabel, contacto.getImagenDirecta());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Set background and foreground based on selection
		if (isSelected) {
			setBackground(Color.PINK);
		} else {
			setBackground(Color.WHITE);
		}

		return this;
	}
}