package um.tds.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import um.tds.Controlador.Controlador;
import um.tds.Modelado.Mensaje;
import um.tds.Renderers.MensajeCellRenderer;

public class VentanaBusqueda implements ActionListener {

	private JFrame frmAppchat;
	private JMenuBar menuBar;
	private JMenu mnPerfil, mnPdf;
	private JMenuItem mntmPremium, mntmContactos, mntmMensajes, mntmEditarPerfil, mntmCerrarSesion, mntmContactosPdf,
			mntmMensajesPdf;
	private JPanel panel;
	private JList<Mensaje> list;
	private DefaultListModel<Mensaje> mensajes;
	private JButton btnAtras;
	private JTextField txtContacto;
	private JButton btnBuscar;
	private JScrollPane scrollPane;
	private JRadioButton rdbtnFiltroContactos;
	private JRadioButton rdbtnFiltroPorTelefono;
	private JRadioButton rdbtnFiltroPorFrase;
	private JTextField txtFrase;
	private JTextField txtTelefono;

	/**
	 * Create the frame.
	 */

	/**
	 * Create the application.
	 */
	public VentanaBusqueda(Dimension tam, Point ubi, String ventanaAnterior) {
		initialize(tam, ubi);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Dimension tam, Point ubi) {
		// listenerModificar = l -> contactoSeleccionadoModificar();
		// listenerMandarMensaje = l -> contactoSeleccionadoMandarMensaje();
		frmAppchat = new JFrame();
		frmAppchat.setTitle("AppChat");
		frmAppchat.setIconImage(
				Toolkit.getDefaultToolkit().getImage(VentanaMain.class.getResource("/imagenes/gatoVentana2_2048.png")));
		frmAppchat.setBackground(new Color(255, 255, 255));
		frmAppchat.setVisible(true);
		frmAppchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAppchat.setBounds(100, 100, 633, 409);

		menuBar = new JMenuBar();
		menuBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		frmAppchat.setJMenuBar(menuBar);

		mntmPremium = new JMenuItem("PREMIUM");
		mntmPremium.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmPremium.setBackground(new Color(255, 255, 255));
		mntmPremium.setHorizontalTextPosition(SwingConstants.CENTER);
		menuBar.add(mntmPremium);
		
		mnPdf = new JMenu("Documento PDF");
		mnPdf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnPdf.setHorizontalAlignment(SwingConstants.LEFT);
		mnPdf.setPreferredSize(new Dimension(180, 26));
		mnPdf.setBackground(Color.WHITE);
		menuBar.add(mnPdf);

		mntmContactosPdf = new JMenuItem("Generar documento con información de contactos");
		mntmContactosPdf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmContactosPdf.setBackground(new Color(255, 255, 255));
		mnPdf.add(mntmContactosPdf);

		mntmMensajesPdf = new JMenuItem("Generar documento con la conversación");
		mntmMensajesPdf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmMensajesPdf.setBackground(new Color(255, 255, 255));
		mnPdf.add(mntmMensajesPdf);

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
		try {
			mnPerfil.setIcon(
					new ImageIcon(Controlador.getUnicaInstancia().getUsuarioActual().getImagenPerfilDirecta()));
			ImageInJLabel.resizeImage(mnPerfil,
					Controlador.getUnicaInstancia().getUsuarioActual().getImagenPerfilDirecta());
			menuBar.add(mnPerfil);
		} catch (IOException e) {
			e.printStackTrace();
		}

		mntmEditarPerfil = new JMenuItem("Editar perfil");
		mntmEditarPerfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmEditarPerfil.setBackground(new Color(255, 255, 255));
		mnPerfil.add(mntmEditarPerfil);

		mntmCerrarSesion = new JMenuItem("Cerrar sesión");
		mntmCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmCerrarSesion.setBackground(new Color(255, 255, 255));
		mnPerfil.add(mntmCerrarSesion);

		panel = new JPanel();
		panel.setBackground(new Color(255, 244, 244));
		frmAppchat.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 180, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 103, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		mensajes = new DefaultListModel<>();

		btnAtras = new JButton("");
		btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtras.setPreferredSize(new Dimension(32, 32));
		btnAtras.setBackground(new Color(255, 255, 255));
		try {
			BufferedImage image = ImageIO.read(getClass().getResource("/imagenes/mod_boton-de-retroceso.png"));
			btnAtras.setIcon(new ImageIcon(image));
			btnAtras.setSize(new Dimension(32, 32));
			ImageInJLabel.resizeImage(btnAtras, image);
		} catch (IOException e) {
			e.printStackTrace();
		}

		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAtras.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtras.gridx = 0;
		gbc_btnAtras.gridy = 0;
		panel.add(btnAtras, gbc_btnAtras);

		rdbtnFiltroContactos = new JRadioButton("Filtrar por contacto");
		rdbtnFiltroContactos.setBackground(Color.WHITE);
		GridBagConstraints gbc_rdbtnFiltroContactos = new GridBagConstraints();
		gbc_rdbtnFiltroContactos.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnFiltroContactos.gridx = 1;
		gbc_rdbtnFiltroContactos.gridy = 0;
		panel.add(rdbtnFiltroContactos, gbc_rdbtnFiltroContactos);

		txtContacto = new JTextField();
		GridBagConstraints gbc_txtContacto = new GridBagConstraints();
		gbc_txtContacto.insets = new Insets(0, 0, 5, 5);
		gbc_txtContacto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtContacto.gridx = 2;
		gbc_txtContacto.gridy = 0;
		panel.add(txtContacto, gbc_txtContacto);
		txtContacto.setColumns(10);
		txtContacto.setEditable(false);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setSize(new Dimension(130, 31));
		btnBuscar.setPreferredSize(new Dimension(130, 31));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnBuscar.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscar.gridx = 3;
		gbc_btnBuscar.gridy = 0;
		panel.add(btnBuscar, gbc_btnBuscar);

		rdbtnFiltroPorTelefono = new JRadioButton("Filtro por teléfono");
		rdbtnFiltroPorTelefono.setBackground(Color.WHITE);
		GridBagConstraints gbc_rdbtnFiltroPorTelfono = new GridBagConstraints();
		gbc_rdbtnFiltroPorTelfono.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnFiltroPorTelfono.gridx = 1;
		gbc_rdbtnFiltroPorTelfono.gridy = 1;
		panel.add(rdbtnFiltroPorTelefono, gbc_rdbtnFiltroPorTelfono);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		GridBagConstraints gbc_txtTelefono = new GridBagConstraints();
		gbc_txtTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefono.gridx = 2;
		gbc_txtTelefono.gridy = 1;
		panel.add(txtTelefono, gbc_txtTelefono);
		txtTelefono.setEditable(false);

		rdbtnFiltroPorFrase = new JRadioButton("Filtro por frase");
		rdbtnFiltroPorFrase.setBackground(Color.WHITE);
		GridBagConstraints gbc_rdbtnFiltroPorFrase = new GridBagConstraints();
		gbc_rdbtnFiltroPorFrase.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnFiltroPorFrase.gridx = 1;
		gbc_rdbtnFiltroPorFrase.gridy = 2;
		panel.add(rdbtnFiltroPorFrase, gbc_rdbtnFiltroPorFrase);

		txtFrase = new JTextField();
		txtFrase.setColumns(10);
		GridBagConstraints gbc_txtFrase = new GridBagConstraints();
		gbc_txtFrase.insets = new Insets(0, 0, 5, 5);
		gbc_txtFrase.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFrase.gridx = 2;
		gbc_txtFrase.gridy = 2;
		panel.add(txtFrase, gbc_txtFrase);
		txtFrase.setEditable(false);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		panel.add(scrollPane, gbc_scrollPane);

		list = new JList<>(mensajes);
		scrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setCellRenderer(new MensajeCellRenderer());
		// list.addListSelectionListener(listenerModificar);
		btnBuscar.addActionListener(this);
		btnAtras.addActionListener(this);
		mntmPremium.addActionListener(this);
		mntmContactos.addActionListener(this);
		mntmCerrarSesion.addActionListener(this);
		mntmEditarPerfil.addActionListener(this);
		mntmContactosPdf.addActionListener(this);
		mntmMensajesPdf.addActionListener(this);

		rdbtnFiltroContactos.addActionListener(this);
		rdbtnFiltroPorTelefono.addActionListener(this);
		rdbtnFiltroPorFrase.addActionListener(this);

		frmAppchat.setVisible(true);
		frmAppchat.setSize(tam);
		frmAppchat.setLocation(ubi);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAtras) {
			new VentanaMain(frmAppchat.getSize(), frmAppchat.getLocation(), null);
			frmAppchat.dispose();
			// vMain.mostrarMain(frmAppchat.getSize(), frmAppchat.getLocation());
		}
		if (e.getSource() == btnBuscar) {
			if (txtContacto.getText().equals("") && txtTelefono.getText().equals("") && txtFrase.getText().equals("")) {

			} else {
				List<Mensaje> lista = Controlador.getUnicaInstancia().busquedaMensajes(txtFrase.getText(),
						txtTelefono.getText(), txtContacto.getText());
				mensajes.clear();
				actualizarMensajes(lista);
			}
		}
		if (e.getSource() == mntmPremium) {
			new VentanaOferta(frmAppchat.getSize(), frmAppchat.getLocation(), "VentanaContactos");
			frmAppchat.dispose();
		}
		if (e.getSource() == mntmContactosPdf) {
			JFileChooser fileC = new JFileChooser();
			int seleccion = fileC.showSaveDialog(null);

			if (seleccion == JFileChooser.APPROVE_OPTION) {
				Path ruta = Paths.get(fileC.getSelectedFile().getAbsolutePath());
				// Genera el pdf
				if (!Controlador.getUnicaInstancia().createPdfContactos(ruta)) {
					JOptionPane.showMessageDialog(frmAppchat, "Ha habido un error al crear el documento", "Error",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		}
		if (e.getSource() == mntmMensajesPdf) {
			if (Controlador.getUnicaInstancia().getUsuarioActual().isPremium()) {
					JOptionPane.showMessageDialog(frmAppchat, "Debes tener abierta la conversación que deseas exportar",
							"Información", JOptionPane.PLAIN_MESSAGE);
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
			new VentanaPerfil(frmAppchat.getSize(), frmAppchat.getLocation(), "VentanaContactos");
			frmAppchat.dispose();
		}
		if (e.getSource() == rdbtnFiltroContactos) {
			if (rdbtnFiltroContactos.isSelected()) {
				txtContacto.setEditable(true);
			} else {
				txtContacto.setEditable(false);
			}
		}
		if (e.getSource() == rdbtnFiltroPorTelefono) {
			if (rdbtnFiltroPorTelefono.isSelected()) {
				txtTelefono.setEditable(true);
			} else {
				txtTelefono.setEditable(false);
			}
		}
		if (e.getSource() == rdbtnFiltroPorFrase) {
			if (rdbtnFiltroPorFrase.isSelected()) {
				txtFrase.setEditable(true);
			} else {
				txtFrase.setEditable(false);
			}
		}
	}

	/*
	 * private void contactoSeleccionadoModificar() { if (list.getSelectedValue()
	 * instanceof Grupo) { new VentanaModificarGrupo((Grupo)
	 * list.getSelectedValue(), frmAppchat.getSize(), frmAppchat.getLocation());
	 * frmAppchat.dispose(); } else { frmAppchat.dispose(); new
	 * VentanaModificarContacto((ContactoIndividual) list.getSelectedValue(),
	 * frmAppchat.getSize(), frmAppchat.getLocation()); } }
	 */

	/*
	 * private void contactoSeleccionadoMandarMensaje() { new
	 * VentanaMain(frmAppchat.getSize(), frmAppchat.getLocation(),
	 * list.getSelectedValue()); frmAppchat.dispose(); }
	 */

	private void actualizarMensajes(List<Mensaje> m) {
		m.stream().forEach(c -> mensajes.addElement(c));
	}

	/*
	 * private void actualizarMensajesFiltrados() { //
	 * Controlador.getUnicaInstancia().getMensajesFiltrados().stream().forEach(c ->
	 * // mensajes.addElement(c)); }
	 */

}
