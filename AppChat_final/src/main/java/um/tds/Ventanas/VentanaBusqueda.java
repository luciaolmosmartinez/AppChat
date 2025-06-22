package um.tds.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import um.tds.Controlador.Controlador;
import um.tds.Modelado.Contacto;
import um.tds.Modelado.ContactoIndividual;
import um.tds.Modelado.Grupo;
import um.tds.Modelado.Mensaje;
import um.tds.Renderers.ContactoCellRenderer;
import um.tds.Renderers.MensajeCellRenderer;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Cursor;
import javax.swing.JScrollPane;

public class VentanaBusqueda implements ActionListener {

	private JFrame frmAppchat;
	private JMenuBar menuBar;
	private JMenu mnPerfil;
	private JMenuItem mntmPremium, mntmContactos, mntmMensajes, mntmEditarPerfil, mntmCerrarSesion;
	private JPanel panel;
	private JList<Mensaje> list;
	private DefaultListModel<Mensaje> mensajes;
	private JButton btnAtras;
	private javax.swing.event.ListSelectionListener listenerModificar;
	private javax.swing.event.ListSelectionListener listenerMandarMensaje;
	private JTextField textField;
	private JButton btnBuscar;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnFiltroTelefono;
	private JRadioButton rdbtnFiltroFrase;

	/**
	 * Create the frame.
	 */

	/**
	 * Create the application.
	 */
	public VentanaBusqueda(Dimension tam, Point ubi) {
		initialize(tam, ubi);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Dimension tam, Point ubi) {
		listenerModificar = l -> contactoSeleccionadoModificar();
		listenerMandarMensaje = l -> contactoSeleccionadoMandarMensaje();
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
				VentanaContactos.class.getResource(Controlador.getUnicaInstancia().getUsuarioActual().getImagenPerfil())));
		ImageInJLabel.resizeImage(mnPerfil,
				VentanaContactos.class.getResource(Controlador.getUnicaInstancia().getUsuarioActual().getImagenPerfil()));
		menuBar.add(mnPerfil);

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
		gbl_panel.columnWidths = new int[] { 0, 180, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 103, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		mensajes = new DefaultListModel<>();

		btnAtras = new JButton("");
		btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtras.setPreferredSize(new Dimension(32, 32));
		btnAtras.setBackground(new Color(255, 255, 255));
		btnAtras.setIcon(new ImageIcon(VentanaContactos.class.getResource("/imagenes/mod_boton-de-retroceso.png")));
		btnAtras.setSize(new Dimension(32, 32));
		ImageInJLabel.resizeImage(btnAtras,
				VentanaContactos.class.getResource("/imagenes/mod_boton-de-retroceso.png"));
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAtras.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtras.gridx = 0;
		gbc_btnAtras.gridy = 0;
		panel.add(btnAtras, gbc_btnAtras);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setSize(new Dimension(130, 31));
		btnBuscar.setPreferredSize(new Dimension(130, 31));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnBuscar.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscar.gridx = 2;
		gbc_btnBuscar.gridy = 0;
		panel.add(btnBuscar, gbc_btnBuscar);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 244, 244));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		panel.add(panel_1, gbc_panel_1);
		
		rdbtnNewRadioButton = new JRadioButton("Filtro contactos");
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
		panel_1.add(rdbtnNewRadioButton);
		
		rdbtnFiltroTelefono = new JRadioButton("Filtro teléfono");
		rdbtnFiltroTelefono.setBackground(Color.WHITE);
		panel_1.add(rdbtnFiltroTelefono);
		
		rdbtnFiltroFrase = new JRadioButton("Filtro frase");
		rdbtnFiltroFrase.setBackground(Color.WHITE);
		panel_1.add(rdbtnFiltroFrase);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		panel.add(scrollPane, gbc_scrollPane);

		list = new JList<>(mensajes);
		scrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setCellRenderer(new MensajeCellRenderer());
		list.addListSelectionListener(listenerModificar);
		btnAtras.addActionListener(this);
		mntmPremium.addActionListener(this);
		mntmContactos.addActionListener(this);
		mntmCerrarSesion.addActionListener(this);
		mntmEditarPerfil.addActionListener(this);
		actualizarMensajes();
		
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
		if (e.getSource() == mntmPremium) {
			new VentanaOferta(frmAppchat.getSize(), frmAppchat.getLocation(),"VentanaContactos");
			frmAppchat.dispose();
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
			new VentanaPerfil(frmAppchat.getSize(), frmAppchat.getLocation(),"VentanaContactos");
			frmAppchat.dispose();
		}
	}

	/*private void contactoSeleccionadoModificar() {
		if (list.getSelectedValue() instanceof Grupo) {
			new VentanaModificarGrupo((Grupo) list.getSelectedValue(), frmAppchat.getSize(), frmAppchat.getLocation());
			frmAppchat.dispose();
		} else {
			frmAppchat.dispose();
			new VentanaModificarContacto((ContactoIndividual) list.getSelectedValue(), frmAppchat.getSize(),
					frmAppchat.getLocation());
		}
	}*/

	/*private void contactoSeleccionadoMandarMensaje() {
		new VentanaMain(frmAppchat.getSize(), frmAppchat.getLocation(), list.getSelectedValue());
		frmAppchat.dispose();
	}*/

	private void actualizarMensajes() {
		Controlador.getUnicaInstancia().getUltimosMensajes().stream().forEach(c -> mensajes.addElement(c));
	}
	
	private void actualizarMensajesFiltrados() {
		Controlador.getUnicaInstancia().getMensajesFiltrados().stream().forEach(c -> mensajes.addElement(c));
	}

}
