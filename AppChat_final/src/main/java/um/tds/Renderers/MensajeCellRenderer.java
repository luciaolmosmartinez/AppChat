package um.tds.Renderers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.time.format.DateTimeFormatter;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import tds.BubbleText;
import um.tds.Controlador.Controlador;
import um.tds.Modelado.Mensaje;
import um.tds.Modelado.TipoReceptor;
import um.tds.Ventanas.ImageInJLabel;
import um.tds.Ventanas.VentanaPerfil;

public class MensajeCellRenderer extends JPanel implements ListCellRenderer<Mensaje> {
	private static final long serialVersionUID = 1L;
	private JLabel nameLabel;
	private JLabel imageLabel;
	private JLabel messageLabel;
	private JLabel timeLabel;
	private DateTimeFormatter formatoFecha;
	private JPanel panelEste;

	public MensajeCellRenderer() {
		setLayout(new BorderLayout(5, 5));
		messageLabel = new JLabel();
		imageLabel = new JLabel();
		nameLabel = new JLabel();
		timeLabel = new JLabel();

		panelEste = new JPanel();
		panelEste.setLayout(new BoxLayout(panelEste, BoxLayout.Y_AXIS));

		// Para alinearlo arriba
		timeLabel.setAlignmentY(Component.TOP_ALIGNMENT);

		panelEste.add(timeLabel);

		// Añadir al panel principal
		add(panelEste, BorderLayout.EAST);

		add(imageLabel, BorderLayout.WEST);
		add(nameLabel, BorderLayout.NORTH);
		add(messageLabel, BorderLayout.CENTER);

		formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Mensaje> list, Mensaje mensaje, int index,
			boolean isSelected, boolean cellHasFocus) {
		if (Controlador.getUnicaInstancia().isContacto(mensaje)) {
			// recupero el contacto del mensaje
			nameLabel.setText(Controlador.getUnicaInstancia().recuperarContactoMensaje(mensaje).getNombre());
		} else {
			// recupero el numero de telefono del otro usuario, nunca sera un grupo
			nameLabel.setText(Controlador.getUnicaInstancia().recuperarOtroUsuario(mensaje));
		}

		if (mensaje.getTexto().equals("")) { // es un icono
			messageLabel.setIcon(BubbleText.getEmoji(mensaje.getEmoticono()));
		} else { // es texto
			messageLabel.setText(mensaje.getTexto());
		}

		imageLabel.setSize(50, 50);
		// mostramos la imagen del contacto
		if (mensaje.getTipoReceptor().equals(TipoReceptor.ID_GRUPO)) { // imagen del grupo
			imageLabel.setIcon(new ImageIcon(MensajeCellRenderer.class.getResource(Controlador.getUnicaInstancia()
					.recuperarGrupo(Integer.parseInt(mensaje.getReceptor())).getImagen())));
			ImageInJLabel.resizeImage(imageLabel, VentanaPerfil.class.getResource(Controlador.getUnicaInstancia()
					.recuperarGrupo(Integer.parseInt(mensaje.getReceptor())).getImagen()));
		} else { // imagen del contacto
			imageLabel.setIcon(new ImageIcon(MensajeCellRenderer.class.getResource(Controlador.getUnicaInstancia()
					.recuperarUsuarioTelefono(mensaje.getReceptor()).getImagenPerfil())));
			ImageInJLabel.resizeImage(imageLabel, VentanaPerfil.class.getResource(
					Controlador.getUnicaInstancia().recuperarUsuarioTelefono(mensaje.getReceptor()).getImagenPerfil()));
		}

		timeLabel.setText(mensaje.getFechaHora().format(formatoFecha));

		/*btnAnadir.setIcon(new ImageIcon(MensajeCellRenderer.class.getResource("/imagenes/agregar.png")));
		btnAnadir.setSize(50,50);
		ImageInJLabel.resizeImage(imageLabel, VentanaPerfil.class.getResource(
				Controlador.getUnicaInstancia().recuperarUsuarioTelefono(mensaje.getReceptor()).getImagenPerfil()));
		btnAnadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));*/

		// Cambiar el fondo si el elemento está seleccionado
		if (isSelected) {
			setBackground(Color.PINK);
			panelEste.setBackground(Color.PINK);
		} else {
			setBackground(Color.WHITE);
			panelEste.setBackground(Color.WHITE);
		}

		//btnAnadir.addActionListener(this);

		return this; // Retornar el componente renderizado
	}

	/*@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAnadir) {
			new VentanaAnadirContacto(tam, ubi, "");
			frame.dispose();
			// vAC.mostrarAnadirContacto(tam,ubi);
		}
	}*/
}
