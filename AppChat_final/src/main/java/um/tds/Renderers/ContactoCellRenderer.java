package um.tds.Renderers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import um.tds.Modelado.Contacto;
import um.tds.Modelado.ContactoIndividual;
import um.tds.Modelado.Grupo;

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
		// Set the text
		nameLabel.setText(contacto.getNombre());

		if(contacto instanceof Grupo) {
			Grupo g = (Grupo) contacto;
			imageLabel.setIcon(new ImageIcon(ContactoCellRenderer.class.getResource(g.getImagen())));
		} else if(contacto instanceof ContactoIndividual){
			ContactoIndividual i = (ContactoIndividual) contacto;
			imageLabel.setIcon(new ImageIcon(ContactoCellRenderer.class.getResource(i.getUsuario().getImagenPerfil())));
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