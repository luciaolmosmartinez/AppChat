package um.tds.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import tds.BubbleText;
import um.tds.Controlador.Controlador;
import um.tds.Modelado.Contacto;
import um.tds.Modelado.ContactoIndividual;
import um.tds.Modelado.Grupo;
import um.tds.Modelado.Mensaje;
import um.tds.Modelado.TipoReceptor;
import um.tds.Renderers.MensajeCellRenderer;
import java.awt.Font;

public class VentanaMain implements ActionListener {

	private JFrame frmAppchat;
	private JPanel contentPane, panelCentral, panelContacto, panelEscribir, panelMensajes;
	private JMenuBar menuBar;
	private JLabel lblImagen, lblContacto;
	private JButton btnEmoticono, btnEnviar;
	private JTextField textField;
	private JMenu mnPerfil;
	private JMenuItem mntmPremium, mntmContactos, mntmMensajes, mntmEditarPerfil, mntmCerrarSesion;
	private JList<Mensaje> list;
	private GridBagConstraints gbc_bubble_1, gbc_lblImagen, gbc_lblConrtacto, gbc_btnEmoticono, gbc_textField,
			gbc_btnEnviar, gbc_bubble_1_2, gbc_bubble_1_1;
	private JScrollPane scrollPane, scrollPane_1;
	private GridBagLayout gbl_panelContacto, gbl_panelEscribir, gbl_panelMensajes;
	private BubbleText bubble, bubble_3, bubble_2, bubble_1;
	private DefaultListModel<Mensaje> mensajes;
	private Contacto contacto;

	/**
	 * Create the frame.
	 */
	/*
	 * public void mostrarMain(Dimension tam, Point ubi) {
	 * frmAppchat.setVisible(true); frmAppchat.setSize(tam);
	 * frmAppchat.setLocation(ubi); }
	 */

	/**
	 * Create the application.
	 */
	public VentanaMain(Dimension tam, Point ubi, Contacto c) {
		if (c != null) {
			this.contacto = c;
		}
		initialize(tam, ubi);
	}

	public void initialize(Dimension tam, Point ubi) {
		frmAppchat = new JFrame();
		frmAppchat.setTitle("AppChat");
		frmAppchat.setIconImage(
				Toolkit.getDefaultToolkit().getImage(VentanaMain.class.getResource("/imagenes/gatoVentana2_2048.png")));
		frmAppchat.setBackground(new Color(255, 255, 255));
		frmAppchat.setVisible(true);
		frmAppchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAppchat.setBounds(100, 100, 633, 409);

		menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		frmAppchat.setJMenuBar(menuBar);

		mntmPremium = new JMenuItem("");
		mntmPremium.setBackground(new Color(255, 255, 255));
		mntmPremium.setHorizontalTextPosition(SwingConstants.CENTER);
		menuBar.add(mntmPremium);
		if (Controlador.getUnicaInstancia().getUsuarioActual().isPremium()) {
			mntmPremium.setIcon(new ImageIcon(VentanaPerfil.class.getResource("/imagenes/orejas_premium.png")));
			mntmPremium.setSize(new Dimension(64, 32));
			ImageInJLabel.resizeImage(mntmPremium, VentanaPerfil.class.getResource("/imagenes/orejas_premium.png"));
		} else {
			mntmPremium.setIcon(new ImageIcon(VentanaPerfil.class.getResource("/imagenes/orejas_premium.png")));
			mntmPremium.setSize(new Dimension(64, 32));
			ImageInJLabel.resizeImage(mntmPremium, VentanaPerfil.class.getResource("/imagenes/orejas_No_premium.png"));
		}
		
		mntmContactos = new JMenuItem("Contactos");
		mntmContactos.setBackground(new Color(255, 255, 255));
		menuBar.add(mntmContactos);

		mntmMensajes = new JMenuItem("Mensajes");
		mntmMensajes.setBackground(new Color(255, 255, 255));
		menuBar.add(mntmMensajes);

		mnPerfil = new JMenu("Perfil");
		mnPerfil.setBackground(Color.WHITE);
		mnPerfil.setSize(30, 30);
		mnPerfil.setIcon(new ImageIcon(
				VentanaMain.class.getResource(Controlador.getUnicaInstancia().getUsuarioActual().getImagenPerfil())));
		ImageInJLabel.resizeImage(mnPerfil,
				VentanaPerfil.class.getResource(Controlador.getUnicaInstancia().getUsuarioActual().getImagenPerfil()));
		menuBar.add(mnPerfil);

		mntmEditarPerfil = new JMenuItem("Editar perfil");
		mntmEditarPerfil.setBackground(new Color(255, 255, 255));
		mnPerfil.add(mntmEditarPerfil);

		mntmCerrarSesion = new JMenuItem("Cerrar sesión");
		mntmCerrarSesion.setBackground(new Color(255, 255, 255));
		mnPerfil.add(mntmCerrarSesion);

		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(494, 400));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmAppchat.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		/*
		 * panelOeste = new JPanel(); panelOeste.setMinimumSize(new Dimension(100, 10));
		 * panelOeste.setBackground(new Color(255, 255, 255));
		 * contentPane.add(panelOeste, BorderLayout.WEST);
		 */

		mensajes = new DefaultListModel<>();

		// panel = new JPanel();
		// panelOeste.add(panel);

		scrollPane_1 = new JScrollPane();
		frmAppchat.getContentPane().add(scrollPane_1, BorderLayout.WEST);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		list = new JList<>(mensajes);
		scrollPane_1.setViewportView(list);
		list.setCellRenderer(new MensajeCellRenderer(frmAppchat.getSize(), frmAppchat.getLocation(), frmAppchat));

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
		panelCentral.add(scrollPane, BorderLayout.CENTER);

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
		gbl_panelContacto.columnWidths = new int[] { 0, 97, 65, 81, 82, 0 };
		gbl_panelContacto.rowHeights = new int[] { 14, 0 };
		gbl_panelContacto.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelContacto.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelContacto.setLayout(gbl_panelContacto);

		lblImagen = new JLabel("");
		gbc_lblImagen = new GridBagConstraints();
		gbc_lblImagen.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblImagen.insets = new Insets(0, 0, 0, 5);
		gbc_lblImagen.gridx = 1;
		gbc_lblImagen.gridy = 0;
		panelContacto.add(lblImagen, gbc_lblImagen);

		lblContacto = new JLabel("");
		lblContacto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gbc_lblConrtacto = new GridBagConstraints();
		gbc_lblConrtacto.insets = new Insets(0, 0, 0, 5);
		gbc_lblConrtacto.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblConrtacto.gridx = 2;
		gbc_lblConrtacto.gridy = 0;
		panelContacto.add(lblContacto, gbc_lblConrtacto);

		panelEscribir = new JPanel();
		panelEscribir.setBackground(new Color(255, 255, 255));
		panelCentral.add(panelEscribir, BorderLayout.SOUTH);
		gbl_panelEscribir = new GridBagLayout();
		gbl_panelEscribir.columnWidths = new int[] { 38, 0, 0, 0 };
		gbl_panelEscribir.rowHeights = new int[] { 23, 0 };
		gbl_panelEscribir.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelEscribir.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelEscribir.setLayout(gbl_panelEscribir);

		btnEmoticono = new JButton();
		btnEmoticono.setMinimumSize(new Dimension(10, 10));
		btnEmoticono.setBackground(new Color(255, 255, 255));
		btnEmoticono.setSize(30, 30);
		btnEmoticono.setIcon(new ImageIcon(VentanaMain.class.getResource("/imagenes/gato_cabeza.png")));
		ImageInJLabel.resizeImage(btnEmoticono, VentanaPerfil.class.getResource("/imagenes/gato_cabeza.png"));
		btnEmoticono.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gbc_btnEmoticono = new GridBagConstraints();
		gbc_btnEmoticono.insets = new Insets(0, 0, 0, 5);
		gbc_btnEmoticono.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnEmoticono.gridx = 0;
		gbc_btnEmoticono.gridy = 0;
		panelEscribir.add(btnEmoticono, gbc_btnEmoticono);

		textField = new JTextField();
		gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panelEscribir.add(textField, gbc_textField);
		textField.setColumns(10);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setBackground(new Color(255, 255, 255));
		btnEnviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gbc_btnEnviar = new GridBagConstraints();
		gbc_btnEnviar.fill = GridBagConstraints.BOTH;
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

		/*
		 * bubble = new BubbleText(panelMensajes, "Adios", Color.PINK, "jaja",
		 * BubbleText.SENT, 10); bubble.setPreferredSize(new Dimension(465, 100));
		 * bubble.setSize(new Dimension(85, 71)); bubble.setMinimumSize(new Dimension(5,
		 * 5));
		 * 
		 * gbc_bubble_1 = new GridBagConstraints(); gbc_bubble_1.anchor =
		 * GridBagConstraints.SOUTH; gbc_bubble_1.fill = GridBagConstraints.HORIZONTAL;
		 * gbc_bubble_1.insets = new Insets(0, 0, 5, 0); gbc_bubble_1.gridx = 0;
		 * gbc_bubble_1.gridy = 0; panelMensajes.add(bubble, gbc_bubble_1); bubble_1 =
		 * new BubbleText(panelMensajes, "adiós", Color.PINK, "jaja", BubbleText.SENT,
		 * 10); bubble_1.setPreferredSize(new Dimension(465, 100)); bubble_1.setSize(new
		 * Dimension(85, 71)); bubble_1.setMinimumSize(new Dimension(5, 5));
		 * 
		 * gbc_bubble_1 = new GridBagConstraints(); gbc_bubble_1.anchor =
		 * GridBagConstraints.SOUTH; gbc_bubble_1.fill = GridBagConstraints.HORIZONTAL;
		 * gbc_bubble_1.insets = new Insets(0, 0, 5, 0); gbc_bubble_1.gridx = 0;
		 * gbc_bubble_1.gridy = 2; panelMensajes.add(bubble_1, gbc_bubble_1); bubble_2 =
		 * new BubbleText(panelMensajes, "HOLA", Color.PINK, "jeje",
		 * BubbleText.RECEIVED, 10); bubble_2.setPreferredSize(new Dimension(465, 100));
		 * bubble_2.setSize(new Dimension(85, 71)); bubble_2.setMinimumSize(new
		 * Dimension(5, 5));
		 * 
		 * gbc_bubble_1_1 = new GridBagConstraints(); gbc_bubble_1_1.fill =
		 * GridBagConstraints.HORIZONTAL; gbc_bubble_1_1.anchor =
		 * GridBagConstraints.SOUTH; gbc_bubble_1_1.insets = new Insets(0, 0, 5, 0);
		 * gbc_bubble_1_1.gridx = 0; gbc_bubble_1_1.gridy = 3;
		 * panelMensajes.add(bubble_2, gbc_bubble_1_1); bubble_3 = new
		 * BubbleText(panelMensajes, "HOLA", Color.PINK, "jeje", BubbleText.RECEIVED,
		 * 10); bubble_3.setPreferredSize(new Dimension(465, 100)); bubble_3.setSize(new
		 * Dimension(85, 71)); bubble_3.setMinimumSize(new Dimension(5, 5));
		 * 
		 * gbc_bubble_1_2 = new GridBagConstraints(); gbc_bubble_1_2.fill =
		 * GridBagConstraints.HORIZONTAL; gbc_bubble_1_2.anchor =
		 * GridBagConstraints.SOUTH; gbc_bubble_1_2.gridx = 0; gbc_bubble_1_2.gridy = 4;
		 * panelMensajes.add(bubble_3, gbc_bubble_1_2);
		 */

		panelCentral.setVisible(false);

		btnEnviar.addActionListener(this);
		btnEmoticono.addActionListener(this);
		mntmContactos.addActionListener(this);
		mntmCerrarSesion.addActionListener(this);
		mntmEditarPerfil.addActionListener(this);
		mntmPremium.addActionListener(this);
		list.addListSelectionListener(e -> conversacionSeleccionada(list.getSelectedValue()));

		frmAppchat.setVisible(true);
		frmAppchat.setSize(tam);
		frmAppchat.setLocation(ubi);

		if (contacto != null) {
			mostrarVentanaConvo();
		}

	}

	public void actionPerformed(ActionEvent e) {
		// Si no hay texto meter "" si no hay emoticono meter -1, no pueden estar los
		// dos
		if (e.getSource() == btnEnviar) {
			if (textField.getText().equals("")) {

			} else {
				Controlador.getUnicaInstancia().registrarMensaje(textField.getText(), -1);
				List<Mensaje> mensajesRecientes = Controlador.getUnicaInstancia().getUltimosMensajes();
				mensajes.clear();
				for (Mensaje m : mensajesRecientes) {
					mensajes.addElement(m);
				}
				list.setModel(mensajes);
				list.setCellRenderer(
						new MensajeCellRenderer(frmAppchat.getSize(), frmAppchat.getLocation(), frmAppchat));
				scrollPane.revalidate();
				scrollPane.repaint();
			}
		}
		if (e.getSource() == mntmPremium) {
			if (Controlador.getUnicaInstancia().getUsuarioActual().isPremium()) {
				int res = JOptionPane.showConfirmDialog(frmAppchat, "¿Está seguro de que desea dejar de ser Premium?",
						"Dejar de ser premium", JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION) {
					Controlador.getUnicaInstancia().setPremium(false);
					mntmPremium.setIcon(new ImageIcon(VentanaPerfil.class.getResource("/imagenes/orejas_premium.png")));
					mntmPremium.setSize(new Dimension(64, 32));
					ImageInJLabel.resizeImage(mntmPremium, VentanaPerfil.class.getResource("/imagenes/orejas_No_premium.png"));
				}
			} else {
				new VentanaOferta(frmAppchat.getSize(), frmAppchat.getLocation(), "VentanaMain");
				frmAppchat.dispose();
			}
		}
		if (e.getSource() == mntmContactos) {
			new VentanaContactos(frmAppchat.getSize(), frmAppchat.getLocation());
			frmAppchat.dispose();
			// contacto.mostrarContactos(frmAppchat.getSize(), frmAppchat.getLocation());
		}
		if (e.getSource() == mntmCerrarSesion) {
			Controlador.getUnicaInstancia().cerrarSesion();
			new VentanaInicio(frmAppchat.getSize(), frmAppchat.getLocation());
			frmAppchat.dispose();
		}
		if (e.getSource() == mntmEditarPerfil) {
			new VentanaPerfil(frmAppchat.getSize(), frmAppchat.getLocation(), "VentanaMain");
			frmAppchat.dispose();
		}
		// añadir foto gato en botón emoticono
	}

	private void conversacionSeleccionada(Mensaje seleccionado) {
		contacto = Controlador.getUnicaInstancia().recuperarContactoMensaje(seleccionado);
		mostrarVentanaConvo();
	}

	private void mostrarVentanaConvo() {
		lblContacto.setText(contacto.getNombre());
		lblImagen.setIcon(new ImageIcon(VentanaMain.class.getResource(contacto.getImagen())));
		lblImagen.setSize(50, 50);
		ImageInJLabel.resizeImage(lblImagen, VentanaPerfil.class.getResource(contacto.getImagen()));
		panelCentral.setVisible(true);
		if (contacto instanceof Grupo) {
			Controlador.getUnicaInstancia().setContactoActual(String.valueOf(contacto.getId()));
			Controlador.getUnicaInstancia().setTipoReceptor(TipoReceptor.ID_GRUPO);
		} else {
			Controlador.getUnicaInstancia()
					.setContactoActual(String.valueOf(((ContactoIndividual) contacto).getUsuario().getNumTelefono()));
			Controlador.getUnicaInstancia().setTipoReceptor(TipoReceptor.NUM_TELF);
		}

	}
}
