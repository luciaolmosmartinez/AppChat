package um.tds.Renderers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import tds.BubbleText;
import um.tds.Controlador.Controlador;
import um.tds.Modelado.Mensaje;
import um.tds.Modelado.TipoReceptor;

public class MensajeCellRenderer extends JPanel implements ListCellRenderer<Mensaje> {
	private static final long serialVersionUID = 1L;
	private JLabel nameLabel;
	private JLabel imageLabel;
	private JLabel messageLabel;
	private JLabel timeLabel;
	private DateTimeFormatter formatoFecha;

	public MensajeCellRenderer() {
		setLayout(new BorderLayout(5, 5));
		messageLabel = new JLabel();
		imageLabel = new JLabel();
		nameLabel = new JLabel();
		timeLabel = new JLabel();

		add(imageLabel, BorderLayout.WEST);
		add(nameLabel, BorderLayout.NORTH);
		add(messageLabel, BorderLayout.CENTER);
		add(timeLabel, BorderLayout.EAST);
		
		formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Mensaje> list, Mensaje mensaje, int index,
			boolean isSelected, boolean cellHasFocus) {
		nameLabel.setText(Controlador.getUnicaInstancia().recuperarContactoMensaje(mensaje).getNombre()); // recupero el
																											// contacto
																											// del
																											// mensaje
		if (mensaje.getTexto().equals("")) { // es un icono
			messageLabel.setIcon(BubbleText.getEmoji(mensaje.getEmoticono()));
		} else { // es texto
			messageLabel.setText(mensaje.getTexto());
		}

		// mostramos la imagen del contacto
		if (mensaje.getTipoReceptor().equals(TipoReceptor.ID_GRUPO)) { // imagen del grupo
			imageLabel.setIcon(new ImageIcon(Controlador.getUnicaInstancia()
					.recuperarGrupo(Integer.parseInt(mensaje.getReceptor())).getImagen()));
		} else { // imagen del contacto
			imageLabel.setIcon(new ImageIcon(
					Controlador.getUnicaInstancia().recuperarUsuarioTelefono(mensaje.getReceptor()).getImagenPerfil()));
		}

		timeLabel.setText(mensaje.getFechaHora().format(formatoFecha));
		
		// Cambiar el fondo si el elemento está seleccionado
		if (isSelected) {
			setBackground(Color.PINK);
		} else {
			setBackground(Color.WHITE);
		}

		return this; // Retornar el componente renderizado
	}
}
