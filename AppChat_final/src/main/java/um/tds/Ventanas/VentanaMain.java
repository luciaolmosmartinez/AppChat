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

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import tds.BubbleText;
import um.tds.Controlador.Controlador;
import um.tds.Modelado.Contacto;
import um.tds.Modelado.ContactoIndividual;
import um.tds.Modelado.Grupo;
import um.tds.Modelado.Mensaje;
import um.tds.Modelado.TipoReceptor;
import um.tds.Modelado.Usuario;
import um.tds.Renderers.MensajeCellRenderer;
import javax.swing.border.TitledBorder;
import java.awt.Font;

public class VentanaMain implements ActionListener {

	private JFrame frmAppchat;
	private JPanel contentPane, panelCentral, panelContacto, panelEscribir, panelMensajes, panelEmoticonos;
	private JMenuBar menuBar;
	private JLabel lblImagen, lblContacto;
	private JButton btnEmoticono, btnEnviar, btnAgregar;
	private JTextField textField;
	private JMenu mnPerfil;
	private JMenuItem mntmPremium, mntmContactos, mntmMensajes, mntmEditarPerfil, mntmCerrarSesion;
	private JList<Mensaje> list;
	private GridBagConstraints gbc_lblImagen, gbc_lblConrtacto, gbc_btnEmoticono, gbc_textField, gbc_btnEnviar, gbc_btnAgregar;
	private JScrollPane scrollPane, scrollPane_1;
	private GridBagLayout gbl_panelContacto, gbl_panelEscribir;
	private BoxLayout gbl_panelMensajes;
	private DefaultListModel<Mensaje> mensajes;
	private Contacto contacto;
	private Usuario u;

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
		this.contacto = c;
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
		mntmPremium.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		mntmContactos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmContactos.setBackground(new Color(255, 255, 255));
		menuBar.add(mntmContactos);

		mntmMensajes = new JMenuItem("Mensajes");
		mntmMensajes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmMensajes.setBackground(new Color(255, 255, 255));
		menuBar.add(mntmMensajes);

		mnPerfil = new JMenu("Perfil");
		mnPerfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnPerfil.setBackground(Color.WHITE);
		mnPerfil.setSize(30, 30);
		mnPerfil.setIcon(new ImageIcon(
				VentanaMain.class.getResource(Controlador.getUnicaInstancia().getUsuarioActual().getImagenPerfil())));
		ImageInJLabel.resizeImage(mnPerfil,
				VentanaPerfil.class.getResource(Controlador.getUnicaInstancia().getUsuarioActual().getImagenPerfil()));
		menuBar.add(mnPerfil);

		mntmEditarPerfil = new JMenuItem("Editar perfil");
		mntmEditarPerfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmEditarPerfil.setBackground(new Color(255, 255, 255));
		mnPerfil.add(mntmEditarPerfil);

		mntmCerrarSesion = new JMenuItem("Cerrar sesión");
		mntmCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		list.setFixedCellWidth(300);
		scrollPane_1.setViewportView(list);
		list.setCellRenderer(new MensajeCellRenderer());

		panelCentral = new JPanel();
		panelCentral.setBackground(new Color(255, 255, 255));
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setSize(new Dimension(465, 100));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setMaximumSize(new Dimension(1400, 200));
		scrollPane.setPreferredSize(new Dimension(465, 100));
		// scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelCentral.add(scrollPane, BorderLayout.CENTER);

		panelMensajes = new JPanel();
		panelMensajes.setBackground(new Color(255, 255, 255));
		panelMensajes.setLayout(new BoxLayout(panelMensajes, BoxLayout.Y_AXIS));
		panelMensajes.setAlignmentY(Component.TOP_ALIGNMENT);
		gbl_panelMensajes = new BoxLayout(panelMensajes, BoxLayout.Y_AXIS);
		
		panelMensajes.setLayout(gbl_panelMensajes);
		panelMensajes.setMinimumSize(new Dimension(465, 100));
		
		scrollPane.setViewportView(panelMensajes);

		panelContacto = new JPanel();
		panelContacto.setBackground(new Color(255, 255, 255));
		panelCentral.add(panelContacto, BorderLayout.NORTH);
		gbl_panelContacto = new GridBagLayout();
		gbl_panelContacto.columnWidths = new int[] { 0, 54, 65, 81, 40, 0 };
		gbl_panelContacto.rowHeights = new int[] { 14, 0 };
		gbl_panelContacto.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelContacto.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelContacto.setLayout(gbl_panelContacto);
		
		panelEmoticonos = new JPanel();
		panelEmoticonos.setPreferredSize(new Dimension(350, 300)); //tamano perfecto para que salgan todos los emoticonos bien
		
		for(int i = 0; i <= BubbleText.MAXICONO; i++) {
			JButton b = new JButton(BubbleText.getEmoji(i));
			b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			int indice = i;
			b.addActionListener(e -> mensajeEmoticono(indice));
			panelEmoticonos.add(b);
			//panelEmoticonos.add(Box.createRigidArea(new Dimension(25, 0)));		
		}
		
		lblImagen = new JLabel("");
		gbc_lblImagen = new GridBagConstraints();
		gbc_lblImagen.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblImagen.insets = new Insets(0, 0, 0, 5);
		gbc_lblImagen.gridx = 1;
		gbc_lblImagen.gridy = 0;
		panelContacto.add(lblImagen, gbc_lblImagen);

		lblContacto = new JLabel("");
		gbc_lblConrtacto = new GridBagConstraints();
		gbc_lblConrtacto.insets = new Insets(0, 0, 0, 5);
		gbc_lblConrtacto.anchor = GridBagConstraints.WEST;
		gbc_lblConrtacto.gridx = 2;
		gbc_lblConrtacto.gridy = 0;
		panelContacto.add(lblContacto, gbc_lblConrtacto);
		
		btnAgregar = new JButton("");
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnAgregar.setMinimumSize(new Dimension(10, 9));
		btnAgregar.setBackground(Color.WHITE);
		gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.gridx = 4;
		gbc_btnAgregar.gridy = 0;

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
		btnEmoticono.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panelEscribir.add(textField, gbc_textField);
		textField.setColumns(10);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnviar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnEnviar.setBackground(new Color(255, 255, 255));
		btnEnviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gbc_btnEnviar = new GridBagConstraints();
		gbc_btnEnviar.fill = GridBagConstraints.BOTH;
		gbc_btnEnviar.gridx = 2;
		gbc_btnEnviar.gridy = 0;
		panelEscribir.add(btnEnviar, gbc_btnEnviar);

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
		actualizarMensajes();

		panelCentral.setVisible(false);

		btnEnviar.addActionListener(this);
		btnEmoticono.addActionListener(this);
		mntmContactos.addActionListener(this);
		mntmCerrarSesion.addActionListener(this);
		mntmEditarPerfil.addActionListener(this);
		mntmPremium.addActionListener(this);
		
		list.addListSelectionListener(e -> {
		    if (!e.getValueIsAdjusting()) {
		    	conversacionSeleccionada();
		    }
		});

		frmAppchat.setVisible(true);
		frmAppchat.setSize(tam);
		frmAppchat.setLocation(ubi);
		u = null;

		if (contacto != null) {
			mostrarVentanaConvo(null);
		}
		panelMensajes.revalidate();
		panelMensajes.repaint();
	}

	public void actionPerformed(ActionEvent e) {
		// Si no hay texto meter "" si no hay emoticono meter -1, no pueden estar los
		// dos
		if (e.getSource() == btnEnviar) {
			if (textField.getText().equals("")) {

			} else {
				Controlador.getUnicaInstancia().registrarMensaje(textField.getText(), -1, u);
				List<Mensaje> mensajesRecientes = Controlador.getUnicaInstancia().getUltimosMensajes();
				mensajes.clear();
				for (Mensaje m : mensajesRecientes) {
					mensajes.addElement(m);
				}
				list.setModel(mensajes);
				list.setCellRenderer(
						new MensajeCellRenderer(/* frmAppchat.getSize(), frmAppchat.getLocation(), frmAppchat */));
				textField.setText("");
				mostrarVentanaConvo(u);
				panelMensajes.revalidate();
				panelMensajes.repaint();
			}
		}
		if (e.getSource() == btnEmoticono) {
			JDialog dialog = new JDialog(frmAppchat, "Emoticonos", false);
			dialog.setContentPane(panelEmoticonos);
			dialog.pack();
			dialog.setLocationRelativeTo(frmAppchat);
			dialog.setVisible(true);
		}
		if(e.getSource() == btnAgregar) {
			new VentanaAnadirContacto(frmAppchat.getSize(), frmAppchat.getLocation(),"VentanaMain:"+lblContacto.getText());
			frmAppchat.dispose();
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
		if(e.getSource() == mntmCerrarSesion){
			Controlador.getUnicaInstancia().cerrarSesion();
			new VentanaInicio(frmAppchat.getSize(), frmAppchat.getLocation());
			frmAppchat.dispose();
		}
		if(e.getSource() == mntmEditarPerfil) {
			new VentanaPerfil(frmAppchat.getSize(), frmAppchat.getLocation(),"VentanaMain");
			frmAppchat.dispose();
		}
		// añadir foto gato en botón emoticono
	}

	private void conversacionSeleccionada() {
		//u = null;
		Mensaje seleccionado = list.getSelectedValue();
		if (seleccionado != null) {
			contacto = Controlador.getUnicaInstancia().recuperarContactoMensaje(seleccionado);
			if (contacto == null) {
				String tmp = Controlador.getUnicaInstancia().recuperarOtroUsuario(seleccionado);
				u = Controlador.getUnicaInstancia().recuperarUsuarioTelefono(tmp);
			}
			mostrarVentanaConvo(u);
			list.clearSelection(); // Limpia para evitar loops
		}
		panelMensajes.revalidate();
		panelMensajes.repaint();
	}

	private void mostrarVentanaConvo(Usuario u) {
		panelMensajes.removeAll();
		if (u != null) { // conversacion con usuario no contacto
			lblContacto.setText(u.getNumTelefono());
			lblImagen.setIcon(new ImageIcon(VentanaMain.class.getResource(u.getImagenPerfil())));
			lblImagen.setSize(50, 50);
			ImageInJLabel.resizeImage(lblImagen, VentanaMain.class.getResource(u.getImagenPerfil()));
			btnAgregar.setIcon(new ImageIcon(VentanaMain.class.getResource("/imagenes/agregar.png")));
			btnAgregar.setSize(50,50);
			ImageInJLabel.resizeImage(btnAgregar, VentanaMain.class.getResource("/imagenes/agregar.png"));
			panelContacto.add(btnAgregar, gbc_btnAgregar);
			btnAgregar.addActionListener(this);

			Controlador.getUnicaInstancia().setContactoActual(null);
			Controlador.getUnicaInstancia().setTipoReceptor(TipoReceptor.NUM_TELF);
			List<Mensaje> tmp = Controlador.getUnicaInstancia().recuperarConversacion(u);
			for (Mensaje m : tmp) {
				if (m.getTexto().equals("")) {
					if (m.getEmisor().equals(u.getNumTelefono())) {
						panelMensajes.add(new BubbleText(panelMensajes, m.getEmoticono(), new Color(254,219,219), "",
								BubbleText.RECEIVED, 10));
					} else {
						panelMensajes.add(
								new BubbleText(panelMensajes, m.getEmoticono(), Color.PINK, "", BubbleText.SENT, 10));
					}
				} else {
					if (m.getEmisor().equals(u.getNumTelefono())) {
						panelMensajes.add(
								new BubbleText(panelMensajes, m.getTexto(), new Color(254,219,219), "", BubbleText.RECEIVED, 10));
					} else {
						panelMensajes
								.add(new BubbleText(panelMensajes, m.getTexto(), Color.PINK, "", BubbleText.SENT, 10));
					}
				}
				panelMensajes.add(Box.createVerticalStrut(10));
			}

		} else { // conversacion con contacto
			lblContacto.setText(contacto.getNombre());
			lblImagen.setIcon(new ImageIcon(VentanaMain.class.getResource(contacto.getImagen())));
			lblImagen.setSize(50, 50);
			ImageInJLabel.resizeImage(lblImagen, VentanaPerfil.class.getResource(contacto.getImagen()));
			String c = "";
			if (contacto instanceof Grupo) {
				c = String.valueOf(contacto.getId());
				Controlador.getUnicaInstancia().setContactoActual(c);
				Controlador.getUnicaInstancia().setTipoReceptor(TipoReceptor.ID_GRUPO);
			} else {
				c = String.valueOf(((ContactoIndividual) contacto).getUsuario().getNumTelefono());
				Controlador.getUnicaInstancia().setContactoActual(c);
				Controlador.getUnicaInstancia().setTipoReceptor(TipoReceptor.NUM_TELF);
			}
			List<Mensaje> tmp = Controlador.getUnicaInstancia().recuperarConversacion(contacto);
			if (tmp != null) {
				for (Mensaje m : tmp) {
					if (m.getTexto().equals("")) {
						if (m.getEmisor().equals(c)) {
							panelMensajes.add(new BubbleText(panelMensajes, m.getEmoticono(), new Color(254,219,219), "",
									BubbleText.RECEIVED, 10));
						} else {
							panelMensajes.add(new BubbleText(panelMensajes, m.getEmoticono(), Color.PINK, "",
									BubbleText.SENT, 10));
						}
					} else {
						if (m.getEmisor().equals(c)) {
							panelMensajes.add(new BubbleText(panelMensajes, m.getTexto(), new Color(254,219,219), "",
									BubbleText.RECEIVED, 10));
						} else {
							panelMensajes.add(
									new BubbleText(panelMensajes, m.getTexto(), Color.PINK, "", BubbleText.SENT, 10));
						}
					}
					panelMensajes.add(Box.createVerticalStrut(10));
				}
			}

		}
		SwingUtilities.invokeLater(() -> {
			JScrollBar vertical = scrollPane.getVerticalScrollBar();
			vertical.setValue(vertical.getMaximum());
		});
		panelMensajes.revalidate();
		panelMensajes.repaint();
		panelCentral.setVisible(true);

	}

	private void actualizarMensajes() {
		Controlador.getUnicaInstancia().getUltimosMensajes().stream().forEach(c -> mensajes.addElement(c));
		panelMensajes.revalidate();
		panelMensajes.repaint();
	}
	
	private void mensajeEmoticono(int i) {
		Controlador.getUnicaInstancia().registrarMensaje("", i, u);
		List<Mensaje> mensajesRecientes = Controlador.getUnicaInstancia().getUltimosMensajes();
		mensajes.clear();
		for (Mensaje m : mensajesRecientes) {
			mensajes.addElement(m);
		}
		list.setModel(mensajes);
		list.setCellRenderer(
				new MensajeCellRenderer(/* frmAppchat.getSize(), frmAppchat.getLocation(), frmAppchat */));
		textField.setText("");
		mostrarVentanaConvo(u);
		panelMensajes.revalidate();
		panelMensajes.repaint();
	}
}
