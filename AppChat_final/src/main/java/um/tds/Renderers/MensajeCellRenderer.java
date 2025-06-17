package um.tds.Renderers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import tds.BubbleText;
import um.tds.Controlador.Controlador;
import um.tds.Modelado.Mensaje;
import um.tds.Modelado.TipoReceptor;
import um.tds.Ventanas.VentanaAnadirContacto;

public class MensajeCellRenderer extends JPanel implements ListCellRenderer<Mensaje>, ActionListener {
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JLabel nameLabel;
	private JLabel imageLabel;
	private JLabel messageLabel;
	private JLabel timeLabel;
	private JButton btnAnadir;
	private JPanel panel;
	private DateTimeFormatter formatoFecha;
	private Dimension tam;
	private Point ubi;

	public MensajeCellRenderer(Dimension tam, Point ubi, JFrame f) {
		this.tam = tam;
		this.ubi = ubi;
		this.frame = f;
		setLayout(new BorderLayout(5, 5));
		messageLabel = new JLabel();
		imageLabel = new JLabel();
		nameLabel = new JLabel();
		timeLabel = new JLabel();
		btnAnadir = new JButton();
		panel = new JPanel();

		add(imageLabel, BorderLayout.WEST);
		add(nameLabel, BorderLayout.NORTH);
		add(messageLabel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(panel, BorderLayout.EAST);

		panel.add(timeLabel);
		panel.add(btnAnadir);

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

		// mostramos la imagen del contacto
		if (mensaje.getTipoReceptor().equals(TipoReceptor.ID_GRUPO)) { // imagen del grupo
			imageLabel.setIcon(new ImageIcon(MensajeCellRenderer.class.getResource(Controlador.getUnicaInstancia()
					.recuperarGrupo(Integer.parseInt(mensaje.getReceptor())).getImagen())));
		} else { // imagen del contacto
			imageLabel.setIcon(new ImageIcon(MensajeCellRenderer.class.getResource(
					Controlador.getUnicaInstancia().recuperarUsuarioTelefono(mensaje.getReceptor()).getImagenPerfil())));
		}

		timeLabel.setText(mensaje.getFechaHora().format(formatoFecha));
		
		btnAnadir.setIcon(new ImageIcon(MensajeCellRenderer.class.getResource("/imagenes/agregar.png")));
		btnAnadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// Cambiar el fondo si el elemento está seleccionado
		if (isSelected) {
			setBackground(Color.PINK);
		} else {
			setBackground(Color.WHITE);
		}

		btnAnadir.addActionListener(this);
		
		return this; // Retornar el componente renderizado
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAnadir) {
			VentanaAnadirContacto vAC = new VentanaAnadirContacto();
			frame.dispose();
			vAC.mostrarAnadirContacto(tam,ubi);
		}
	}
}
