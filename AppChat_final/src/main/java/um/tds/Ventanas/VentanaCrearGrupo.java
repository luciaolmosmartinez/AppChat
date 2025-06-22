package um.tds.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import um.tds.Controlador.Controlador;
import um.tds.Modelado.Contacto;
import um.tds.Modelado.ContactoIndividual;
import um.tds.Renderers.ContactoCellRenderer;

public class VentanaCrearGrupo implements ActionListener {

	private JFrame frmAppchat;
	private JPanel contentPane, panel, panel_1;
	private JMenuBar menuBar;
	private JMenu mnPerfil;
	private JMenuItem mntmPremium, mntmContactos, mntmMensajes, mntmEditarPerfil, mntmCerrarSesion;
	private GridBagConstraints gbc_lblImagen, gbc_txtNombre;
	private JLabel lblImagen, lblNombre, lblError;
	private JTextField txtNombre;
	private GridBagLayout gbl_panel_1;
	private JButton btnAceptar, btnCancelar;
	private String ventanaAnterior;
	private JTextField txtRutaImagen;
	private JLabel lblElegirImagen;
	private JList<Contacto> list;
	private DefaultListModel<Contacto> contactos;
	private JScrollPane scrollPane;
	private List<Contacto> cSeleccionados;

	/**
	 * Create the frame.
	 */
	/*
	 * public void mostrarAnadirContacto(Dimension tam, Point ubi, ActionListener
	 * ventanaAnterior) { frmAppchat.setVisible(true); frmAppchat.setSize(tam);
	 * frmAppchat.setLocation(ubi); this.ventanaAnterior = ventanaAnterior; }
	 */

	/**
	 * Create the frame.
	 */
	public VentanaCrearGrupo(Dimension tam, Point ubi, String ventanaAnterior) {
		frmAppchat = new JFrame();
		frmAppchat.setTitle("AppChat");
		frmAppchat.setIconImage(
				Toolkit.getDefaultToolkit().getImage(VentanaMain.class.getResource("/imagenes/gatoVentana2_2048.png")));
		frmAppchat.setBackground(new Color(255, 255, 255));
		frmAppchat.setVisible(true);
		frmAppchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAppchat.setBounds(100, 100, 946, 585);

		menuBar = new JMenuBar();
		menuBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		frmAppchat.setJMenuBar(menuBar);

		mntmPremium = new JMenuItem("PREMIUM");
		mntmPremium.setBackground(new Color(255, 255, 255));
		mntmPremium.setHorizontalTextPosition(SwingConstants.CENTER);
		menuBar.add(mntmPremium);

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
		contentPane.setMaximumSize(new Dimension(494, 200));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmAppchat.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setBackground(new Color(255, 244, 244));
		contentPane.add(panel, BorderLayout.WEST);

		scrollPane = new JScrollPane();
		panel.add(scrollPane);

		contactos = new DefaultListModel<>();

		list = new JList<>(contactos);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.gridwidth = 2;
		gbc_list.gridheight = 5;
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 1;
		list.setCellRenderer(new ContactoCellRenderer());
		//panel.add(list, gbc_list);

		scrollPane.setViewportView(list);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 244, 244));
		contentPane.add(panel_1, BorderLayout.CENTER);
		gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 218, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		lblImagen = new JLabel("");
		lblImagen.setSize(250, 250);
		lblImagen.setIcon(new ImageIcon(VentanaAnadirContacto.class.getResource("/imagenes/gato_perfil.png")));
		ImageInJLabel.resizeImage(lblImagen, VentanaAnadirContacto.class.getResource("/imagenes/gato_perfil.png"));
		gbc_lblImagen = new GridBagConstraints();
		gbc_lblImagen.gridheight = 3;
		gbc_lblImagen.insets = new Insets(0, 0, 5, 5);
		gbc_lblImagen.gridx = 1;
		gbc_lblImagen.gridy = 1;
		panel_1.add(lblImagen, gbc_lblImagen);

		lblNombre = new JLabel("<html><span style='color:red;'>*</span>Nombre del grupo:</html>");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 2;
		gbc_lblNombre.gridy = 2;
		panel_1.add(lblNombre, gbc_lblNombre);

		txtNombre = new JTextField();
		gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 3;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 3;
		gbc_txtNombre.gridy = 2;
		panel_1.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);

		lblElegirImagen = new JLabel("Imagen:");
		lblElegirImagen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblElegirImagen = new GridBagConstraints();
		gbc_lblElegirImagen.anchor = GridBagConstraints.EAST;
		gbc_lblElegirImagen.insets = new Insets(0, 0, 5, 5);
		gbc_lblElegirImagen.gridx = 2;
		gbc_lblElegirImagen.gridy = 3;
		panel_1.add(lblElegirImagen, gbc_lblElegirImagen);

		txtRutaImagen = new JTextField();
		txtRutaImagen.setColumns(10);
		GridBagConstraints gbc_txtRutaImagen = new GridBagConstraints();
		gbc_txtRutaImagen.gridwidth = 3;
		gbc_txtRutaImagen.insets = new Insets(0, 0, 5, 5);
		gbc_txtRutaImagen.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRutaImagen.gridx = 3;
		gbc_txtRutaImagen.gridy = 3;
		panel_1.add(txtRutaImagen, gbc_txtRutaImagen);

		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setBackground(Color.RED);
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.insets = new Insets(0, 0, 5, 5);
		gbc_lblError.gridx = 1;
		gbc_lblError.gridy = 5;
		panel_1.add(lblError, gbc_lblError);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(255, 255, 255));
		btnAceptar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.BOTH;
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 5;
		panel_1.add(btnAceptar, gbc_btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.fill = GridBagConstraints.BOTH;
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 5;
		gbc_btnCancel.gridy = 5;
		panel_1.add(btnCancelar, gbc_btnCancel);

		btnAceptar.addActionListener(this);
		btnCancelar.addActionListener(this);
		list.addListSelectionListener(e -> contactosSeleccionados());
		actualizarContactos();

		frmAppchat.setVisible(true);
		frmAppchat.setSize(tam);
		frmAppchat.setLocation(ubi);
		cSeleccionados = new LinkedList<>();
		this.ventanaAnterior = ventanaAnterior;

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			if (txtNombre.getText().equals("")) {
				lblError.setText("Debe ponerle un nombre al grupo");
			} else {
				if (txtRutaImagen.getText().equals(""))
					Controlador.getUnicaInstancia().registrarGrupo(txtNombre.getText(), "/imagenes/gato_perfil.png",
							cSeleccionados);
				new VentanaContactos(frmAppchat.getSize(), frmAppchat.getLocation());
				// vContactos.mostrarContactos(frmAppchat.getSize(), frmAppchat.getLocation());
				frmAppchat.dispose();
			}

		}
		if (e.getSource() == btnCancelar) {
			if (ventanaAnterior.equals("VentanaContactos")) {
				new VentanaContactos(frmAppchat.getSize(), frmAppchat.getLocation());
				frmAppchat.dispose();
			} else {
				new VentanaMain(frmAppchat.getSize(), frmAppchat.getLocation(), null);
				frmAppchat.dispose();
			}
		}
	}

	private void contactosSeleccionados() {
		cSeleccionados = list.getSelectedValuesList();
	}

	private void actualizarContactos() {
		Controlador.getUnicaInstancia().recuperarContactos().stream().filter(c -> c instanceof ContactoIndividual)
				.forEach(c -> contactos.addElement(c));
	}
}
