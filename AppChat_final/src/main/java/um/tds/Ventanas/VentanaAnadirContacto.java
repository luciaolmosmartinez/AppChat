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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import um.tds.Controlador.Controlador;
import java.awt.Cursor;

public class VentanaAnadirContacto implements ActionListener {

	private JFrame frmAppchat;
	private JPanel contentPane, panel_1;
	private JMenuBar menuBar;
	private JMenu mnPerfil;
	private JMenuItem mntmPremium, mntmContactos, mntmMensajes, mntmEditarPerfil, mntmCerrarSesion;
	private GridBagConstraints gbc_lblImagen, gbc_txtNombre, gbc_txtTelefono;
	private JLabel lblImagen, lblNombre, lblTelefono, lblError;
	private JTextField txtNombre, txtTelefono;
	private GridBagLayout gbl_panel_1;
	private JButton btnAceptar, btnCancelar;
	private String ventanaAnterior;
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
	public VentanaAnadirContacto(Dimension tam, Point ubi, String ventanaAnterior) {
		String[] partes = ventanaAnterior.split(":");
		this.ventanaAnterior = partes[0]; 
		
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
		contentPane.setMaximumSize(new Dimension(494, 200));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmAppchat.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 244, 244));
		contentPane.add(panel_1, BorderLayout.CENTER);
		gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 218, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
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

		lblNombre = new JLabel("<html><span style='color:red;'>*</span>Nombre:</html>");
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

		lblTelefono = new JLabel("<html><span style='color:red;'>*</span>Teléfono:</html>");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.gridx = 2;
		gbc_lblTelefono.gridy = 3;
		panel_1.add(lblTelefono, gbc_lblTelefono);

		txtTelefono = new JTextField();
		gbc_txtTelefono = new GridBagConstraints();
		gbc_txtTelefono.gridwidth = 3;
		gbc_txtTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefono.gridx = 3;
		gbc_txtTelefono.gridy = 3;
		panel_1.add(txtTelefono, gbc_txtTelefono);
		txtTelefono.setColumns(10);
		
		if (this.ventanaAnterior.equals("VentanaMain")) {
			txtTelefono.setText(partes[1]);
		}

		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setBackground(Color.RED);
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.insets = new Insets(0, 0, 5, 5);
		gbc_lblError.gridx = 1;
		gbc_lblError.gridy = 5;
		panel_1.add(lblError, gbc_lblError);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setBackground(new Color(255, 255, 255));
		btnAceptar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.BOTH;
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 5;
		panel_1.add(btnAceptar, gbc_btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.fill = GridBagConstraints.BOTH;
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 5;
		gbc_btnCancel.gridy = 5;
		panel_1.add(btnCancelar, gbc_btnCancel);

		btnAceptar.addActionListener(this);
		btnCancelar.addActionListener(this);
		mntmPremium.addActionListener(this);
		mntmContactos.addActionListener(this);
		mntmCerrarSesion.addActionListener(this);
		mntmEditarPerfil.addActionListener(this);

		frmAppchat.setVisible(true);
		frmAppchat.setSize(tam);
		frmAppchat.setLocation(ubi);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			if (txtNombre.getText().equals("") || txtTelefono.getText().equals("")) {
				lblError.setText("Debe rellenar los campos indicados con un asterisco");
			} else {
				String texto = Controlador.getUnicaInstancia().registrarContacto(txtTelefono.getText(),
						txtNombre.getText());
				if (texto.equals("")) {
					new VentanaContactos(frmAppchat.getSize(), frmAppchat.getLocation());
					// vContactos.mostrarContactos(frmAppchat.getSize(), frmAppchat.getLocation());
					frmAppchat.dispose();
				} else {
					lblError.setText(texto);
				}

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
				new VentanaOferta(frmAppchat.getSize(), frmAppchat.getLocation(), "VentanaAnadirContacto");
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
			new VentanaPerfil(frmAppchat.getSize(), frmAppchat.getLocation(), "VentanaAnadirContacto");
			frmAppchat.dispose();
		}
	}

}
