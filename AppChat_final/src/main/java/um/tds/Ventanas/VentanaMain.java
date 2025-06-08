package um.tds.Ventanas;

import java.awt.BorderLayout;
import tds.BubbleText;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JPopupMenu;

import javax.swing.JMenuBar;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import java.awt.List;
import java.awt.Point;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class VentanaMain extends JFrame implements ActionListener {

	private JFrame frmAppchat;
	private JPanel contentPane, panelOeste, panelCentral, panelContacto, panelEscribir, panelMensajes;
	private JMenuBar menuBar;
	private JLabel lblImagen, lblConrtacto;
	private JButton btnEmoticono, btnEnviar;
	private JTextField textField;
	private JMenuItem mntmNewMenuItem, mntmNewMenuItem_1, mntmNewMenuItem_2, mntmNewMenuItem_3;
	private List list;
	private GridBagConstraints gbc_bubble_1, gbc_lblImagen, gbc_lblConrtacto, gbc_btnEmoticono,
			gbc_textField, gbc_btnEnviar;
	private GridBagConstraints gbc_bubble_1_2;
	private GridBagConstraints gbc_bubble_1_1;
	private JScrollPane scrollPane;
	private GridBagLayout gbl_panelContacto, gbl_panelEscribir, gbl_panelMensajes;
	private BubbleText bubble, bubble_3, bubble_2, bubble_1;

	/**
	 * Create the frame.
	 */
	public void mostrarMain(Dimension tam, Point ubi) {
		frmAppchat.setVisible(true);
		frmAppchat.setSize(tam);
		frmAppchat.setLocation(ubi);
	}

	/**
	 * Create the application.
	 */
	public VentanaMain() {
		initialize();
	}
	
	public void initialize() {
		frmAppchat = new JFrame();
		frmAppchat.setTitle("AppChat");
		frmAppchat.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaMain.class.getResource("/imagenes/gatoVentana2_2048.png")));
		frmAppchat.setBackground(new Color(255, 255, 255));
		frmAppchat.setVisible(true);
		frmAppchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAppchat.setBounds(100, 100, 633, 409);

		menuBar = new JMenuBar();
		menuBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		frmAppchat.setJMenuBar(menuBar);

		mntmNewMenuItem = new JMenuItem("PREMIUM");
		mntmNewMenuItem.setHorizontalTextPosition(SwingConstants.CENTER);
		menuBar.add(mntmNewMenuItem);

		mntmNewMenuItem_1 = new JMenuItem("Contactos");
		menuBar.add(mntmNewMenuItem_1);

		mntmNewMenuItem_2 = new JMenuItem("Mensajes");
		menuBar.add(mntmNewMenuItem_2);

		mntmNewMenuItem_3 = new JMenuItem("Perfil");
		menuBar.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(494, 400));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmAppchat.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panelOeste = new JPanel();
		panelOeste.setBackground(new Color(255, 255, 255));
		contentPane.add(panelOeste, BorderLayout.WEST);

		list = new List();
		panelOeste.add(list);

		panelCentral = new JPanel();
		panelCentral.setBackground(new Color(255, 255, 255));
		panelCentral.setPreferredSize(new Dimension(494, 10));
		panelCentral.setMaximumSize(new Dimension(494, 400));
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setSize(new Dimension(465, 100));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setMaximumSize(new Dimension(1400, 200));
		scrollPane.setPreferredSize(new Dimension(465, 100));
		panelCentral.add(scrollPane, BorderLayout.WEST);

		panelMensajes = new JPanel();
		panelMensajes.setSize(new Dimension(465, 0));
		panelMensajes.setMinimumSize(new Dimension(5, 5));
		panelMensajes.setBackground(new Color(255, 255, 255));
		panelMensajes.setMaximumSize(new Dimension(1400, 200));
		scrollPane.setViewportView(panelMensajes);

		panelContacto = new JPanel();
		panelContacto.setBackground(new Color(255, 255, 255));
		panelCentral.add(panelContacto, BorderLayout.NORTH);
		gbl_panelContacto = new GridBagLayout();
		gbl_panelContacto.columnWidths = new int[] { 0, 97, 65, 81, 0 };
		gbl_panelContacto.rowHeights = new int[] { 14, 0 };
		gbl_panelContacto.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelContacto.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelContacto.setLayout(gbl_panelContacto);

		lblImagen = new JLabel("foto contacto");
		gbc_lblImagen = new GridBagConstraints();
		gbc_lblImagen.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblImagen.insets = new Insets(0, 0, 0, 5);
		gbc_lblImagen.gridx = 1;
		gbc_lblImagen.gridy = 0;
		panelContacto.add(lblImagen, gbc_lblImagen);

		lblConrtacto = new JLabel("nombre contacto");
		gbc_lblConrtacto = new GridBagConstraints();
		gbc_lblConrtacto.insets = new Insets(0, 0, 0, 5);
		gbc_lblConrtacto.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblConrtacto.gridx = 2;
		gbc_lblConrtacto.gridy = 0;
		panelContacto.add(lblConrtacto, gbc_lblConrtacto);

		panelEscribir = new JPanel();
		panelEscribir.setBackground(new Color(255, 255, 255));
		panelCentral.add(panelEscribir, BorderLayout.SOUTH);
		gbl_panelEscribir = new GridBagLayout();
		gbl_panelEscribir.columnWidths = new int[] { 89, 0, 0, 0 };
		gbl_panelEscribir.rowHeights = new int[] { 23, 0 };
		gbl_panelEscribir.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelEscribir.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelEscribir.setLayout(gbl_panelEscribir);

		btnEmoticono = new JButton("emoticonos");
		gbc_btnEmoticono = new GridBagConstraints();
		gbc_btnEmoticono.insets = new Insets(0, 0, 0, 5);
		gbc_btnEmoticono.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnEmoticono.gridx = 0;
		gbc_btnEmoticono.gridy = 0;
		panelEscribir.add(btnEmoticono, gbc_btnEmoticono);

		textField = new JTextField();
		gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panelEscribir.add(textField, gbc_textField);
		textField.setColumns(10);

		btnEnviar = new JButton("Enviar");
		gbc_btnEnviar = new GridBagConstraints();
		gbc_btnEnviar.gridx = 2;
		gbc_btnEnviar.gridy = 0;
		panelEscribir.add(btnEnviar, gbc_btnEnviar);
		gbl_panelMensajes = new GridBagLayout();
		gbl_panelMensajes.columnWidths = new int[] { 451, 0 };
		gbl_panelMensajes.rowHeights = new int[] { 82, 30, 82, 62, 0 };
		gbl_panelMensajes.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelMensajes.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
		panelMensajes.setLayout(gbl_panelMensajes);
		panelMensajes.setSize(118, 118);
		panelMensajes.setMinimumSize(new Dimension(118, 118));
		panelMensajes.setMaximumSize(new Dimension(118, 118));
		panelMensajes.setPreferredSize(new Dimension(465, 100));
		panelMensajes.setAlignmentX(Component.LEFT_ALIGNMENT);

		bubble = new BubbleText(panelMensajes, "Adios", Color.PINK, "jaja", BubbleText.SENT, 10);
		bubble.setPreferredSize(new Dimension(465, 100));
		bubble.setSize(new Dimension(85, 71));
		bubble.setMinimumSize(new Dimension(5, 5));

		gbc_bubble_1 = new GridBagConstraints();
		gbc_bubble_1.anchor = GridBagConstraints.SOUTH;
		gbc_bubble_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_bubble_1.insets = new Insets(0, 0, 5, 0);
		gbc_bubble_1.gridx = 0;
		gbc_bubble_1.gridy = 0;
		panelMensajes.add(bubble, gbc_bubble_1);
		bubble_1 = new BubbleText(panelMensajes, "adiós", Color.PINK, "jaja", BubbleText.SENT, 10);
		bubble_1.setPreferredSize(new Dimension(465, 100));
		bubble_1.setSize(new Dimension(85, 71));
		bubble_1.setMinimumSize(new Dimension(5, 5));

		gbc_bubble_1 = new GridBagConstraints();
		gbc_bubble_1.anchor = GridBagConstraints.SOUTH;
		gbc_bubble_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_bubble_1.insets = new Insets(0, 0, 5, 0);
		gbc_bubble_1.gridx = 0;
		gbc_bubble_1.gridy = 2;
		panelMensajes.add(bubble_1, gbc_bubble_1);
		bubble_2 = new BubbleText(panelMensajes, "HOLA", Color.PINK, "jeje", BubbleText.RECEIVED, 10);
		bubble_2.setPreferredSize(new Dimension(465, 100));
		bubble_2.setSize(new Dimension(85, 71));
		bubble_2.setMinimumSize(new Dimension(5, 5));

		gbc_bubble_1_1 = new GridBagConstraints();
		gbc_bubble_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_bubble_1_1.anchor = GridBagConstraints.SOUTH;
		gbc_bubble_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_bubble_1_1.gridx = 0;
		gbc_bubble_1_1.gridy = 3;
		panelMensajes.add(bubble_2, gbc_bubble_1_1);
		bubble_3 = new BubbleText(panelMensajes, "HOLA", Color.PINK, "jeje", BubbleText.RECEIVED, 10);
		bubble_3.setPreferredSize(new Dimension(465, 100));
		bubble_3.setSize(new Dimension(85, 71));
		bubble_3.setMinimumSize(new Dimension(5, 5));

		gbc_bubble_1_2 = new GridBagConstraints();
		gbc_bubble_1_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_bubble_1_2.anchor = GridBagConstraints.SOUTH;
		gbc_bubble_1_2.gridx = 0;
		gbc_bubble_1_2.gridy = 4;
		panelMensajes.add(bubble_3, gbc_bubble_1_2);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Si no hay texto meter "" si no hay emoticono meter -1, no pueden estar los dos
		// añadir foto gato en botón emoticono
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}

}
