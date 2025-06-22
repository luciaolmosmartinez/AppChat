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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import um.tds.Controlador.Controlador;

public class VentanaPerfil implements ActionListener {

	private JFrame frmAppchat;
	private JTextField txtNombre, txtEmail, textImagen;
	private JMenuBar menuBar;
	private JMenu mnPerfil, mnPdf;
	private JMenuItem mntmPremium, mntmContactos, mntmMensajes, mntmEditarPerfil, mntmCerrarSesion, mntmContactosPdf,
			mntmMensajesPdf;
	private JPanel panel;
	private GridBagLayout gbl_panel;
	private JLabel nombre, icono, telefono, telf, fecha, lblEmail, saludo, lblRegistro, contrasenaRepe, contrasena,
			lblError, siPremium;
	private GridBagConstraints gbc_nombre, gbc_txtNombre, gbc_btnimagenNoPremium, gbc_icono, gbc_telefono, gbc_fecha,
			gbc_dateChooser, gbc_lblEmail, gbc_txtEmail, gbc_saludo, gbc_txtrsaludo, gbc_lblRegistro, gbc_btnRestaurar,
			gbc_btnNewButton_2;
	private JButton btnimagenNoPremium, btnRestaurar, btnAceptar, btnAtras;
	private JDateChooser dateChooser;
	private JTextArea txtsaludo;
	private JPasswordField passContrasena, passContrasenaRepe;
	private String ventanaAnterior;

	/**
	 * Create the application.
	 */
	public VentanaPerfil(Dimension tam, Point ubi, String ventanaAnterior) {
		initialize(tam, ubi, ventanaAnterior);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Dimension tam, Point ubi, String ventanaAnterior) {
		this.ventanaAnterior = ventanaAnterior;

		frmAppchat = new JFrame();
		frmAppchat.setBackground(new Color(255, 244, 244));
		frmAppchat.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaLogin.class.getResource("/imagenes/gatoVentana2_2048.png")));
		frmAppchat.setTitle("AppChat");
		frmAppchat.setBounds(300, 300, 907, 680);
		frmAppchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuBar = new JMenuBar();
		menuBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		frmAppchat.setJMenuBar(menuBar);

		mntmPremium = new JMenuItem("");
		mntmPremium.setBackground(new Color(255, 255, 255));
		mntmPremium.setHorizontalTextPosition(SwingConstants.CENTER);
		menuBar.add(mntmPremium);
		if (Controlador.getUnicaInstancia().getUsuarioActual().isPremium()) {

			try {
				BufferedImage image = ImageIO.read(getClass().getResource("/imagenes/orejas_premium.png"));
				mntmPremium.setIcon(new ImageIcon(image));
				mntmPremium.setSize(new Dimension(64, 32));
				ImageInJLabel.resizeImage(mntmPremium, image);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {

			try {
				BufferedImage image = ImageIO.read(getClass().getResource("/imagenes/orejas_no_premium.png"));
				mntmPremium.setIcon(new ImageIcon(image));
				mntmPremium.setSize(new Dimension(64, 32));
				ImageInJLabel.resizeImage(mntmPremium, image);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

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
		} catch (IOException e) {
			e.printStackTrace();
		}

		menuBar.add(mnPerfil);

		mntmEditarPerfil = new JMenuItem("Editar perfil");
		mntmEditarPerfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmEditarPerfil.setBackground(new Color(255, 255, 255));
		mnPerfil.add(mntmEditarPerfil);

		mntmCerrarSesion = new JMenuItem("Cerrar sesión");
		mntmCerrarSesion.setBackground(new Color(255, 255, 255));
		mnPerfil.add(mntmCerrarSesion);

		panel = new JPanel();
		panel.setBackground(new Color(255, 244, 244));
		frmAppchat.getContentPane().add(panel, BorderLayout.CENTER);
		gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 137, 64, 104, 128, 146, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		btnAtras = new JButton("");
		btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtras.setPreferredSize(new Dimension(32, 32));
		btnAtras.setBackground(new Color(255, 255, 255));
		btnAtras.setIcon(new ImageIcon(VentanaContactos.class.getResource("/imagenes/mod_boton-de-retroceso.png")));
		btnAtras.setSize(new Dimension(32, 32));
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAtras.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtras.gridx = 0;
		gbc_btnAtras.gridy = 0;
		panel.add(btnAtras, gbc_btnAtras);

		nombre = new JLabel("<html><span style='color:red;'>*</span>Nombre completo:</html>");
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_nombre = new GridBagConstraints();
		gbc_nombre.insets = new Insets(0, 0, 5, 5);
		gbc_nombre.anchor = GridBagConstraints.EAST;
		gbc_nombre.gridx = 2;
		gbc_nombre.gridy = 1;
		panel.add(nombre, gbc_nombre);

		txtNombre = new JTextField();
		txtNombre.setText(Controlador.getUnicaInstancia().getUsuarioActual().getNombre());
		gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 3;
		gbc_txtNombre.gridy = 1;
		panel.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);

		if (Controlador.getUnicaInstancia().getUsuarioActual().isPremium()) {
			siPremium = new JLabel();

			try {
				BufferedImage image = ImageIO.read(getClass().getResource("/imagenes/orejas_premium.png"));
				siPremium.setIcon(new ImageIcon(image));
				siPremium.setSize(new Dimension(64, 32));
				ImageInJLabel.resizeImage(siPremium, image);
			} catch (IOException e) {
				e.printStackTrace();
			}

			GridBagConstraints gbc_siPremium = new GridBagConstraints();
			gbc_siPremium.insets = new Insets(0, 0, 5, 5);
			gbc_siPremium.gridx = 5;
			gbc_siPremium.gridy = 1;
			panel.add(siPremium, gbc_siPremium);
		} else {
			btnimagenNoPremium = new JButton("");
			btnimagenNoPremium.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnimagenNoPremium.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnimagenNoPremium
					.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			btnimagenNoPremium.setBackground(new Color(255, 244, 244));

			try {
				BufferedImage image = ImageIO.read(getClass().getResource("/imagenes/orejas_no_premium.png"));
				btnimagenNoPremium.setIcon(new ImageIcon(image));
				btnimagenNoPremium.setSize(new Dimension(64, 32));
				ImageInJLabel.resizeImage(btnimagenNoPremium, image);
			} catch (IOException e) {
				e.printStackTrace();
			}

			btnimagenNoPremium.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new VentanaOferta(frmAppchat.getSize(), frmAppchat.getLocation(), "VentanaPerfil");
					frmAppchat.dispose();
				}
			});
			gbc_btnimagenNoPremium = new GridBagConstraints();
			gbc_btnimagenNoPremium.insets = new Insets(0, 0, 5, 5);
			gbc_btnimagenNoPremium.gridx = 5;
			gbc_btnimagenNoPremium.gridy = 1;
			panel.add(btnimagenNoPremium, gbc_btnimagenNoPremium);
		}

		icono = new JLabel("");
		icono.setAlignmentX(Component.CENTER_ALIGNMENT);
		icono.setSize(170, 170);

		try {
			icono.setIcon(new ImageIcon(Controlador.getUnicaInstancia().getUsuarioActual().getImagenPerfilDirecta()));
			ImageInJLabel.resizeImage(icono,
					Controlador.getUnicaInstancia().getUsuarioActual().getImagenPerfilDirecta());
		} catch (IOException e) {
			e.printStackTrace();
		}

		icono.setPreferredSize(new Dimension(170, 170));
		icono.setMaximumSize(new Dimension(512, 512));
		gbc_icono = new GridBagConstraints();
		gbc_icono.gridheight = 6;
		gbc_icono.insets = new Insets(0, 0, 5, 5);
		gbc_icono.gridx = 1;
		gbc_icono.gridy = 1;
		panel.add(icono, gbc_icono);

		telefono = new JLabel("Teléfono:");
		telefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_telefono = new GridBagConstraints();
		gbc_telefono.insets = new Insets(0, 0, 5, 5);
		gbc_telefono.anchor = GridBagConstraints.EAST;
		gbc_telefono.gridx = 2;
		gbc_telefono.gridy = 2;
		panel.add(telefono, gbc_telefono);

		telf = new JLabel(Controlador.getUnicaInstancia().getUsuarioActual().getNumTelefono());
		telf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_telf = new GridBagConstraints();
		gbc_telf.anchor = GridBagConstraints.WEST;
		gbc_telf.gridwidth = 2;
		gbc_telf.insets = new Insets(0, 0, 5, 5);
		gbc_telf.gridx = 3;
		gbc_telf.gridy = 2;
		panel.add(telf, gbc_telf);

		fecha = new JLabel("Fecha de nacimiento:");
		fecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_fecha = new GridBagConstraints();
		gbc_fecha.insets = new Insets(0, 0, 5, 5);
		gbc_fecha.anchor = GridBagConstraints.EAST;
		gbc_fecha.gridx = 2;
		gbc_fecha.gridy = 3;
		panel.add(fecha, gbc_fecha);

		dateChooser = new JDateChooser();
		if (Controlador.getUnicaInstancia().getUsuarioActual().getFechaNacimiento() != null) {
			dateChooser.setDate(Date.from(Controlador.getUnicaInstancia().getUsuarioActual().getFechaNacimiento()
					.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		}

		dateChooser.setPreferredSize(new Dimension(80, 19));
		dateChooser.setMinimumSize(new Dimension(40, 19));
		dateChooser.getCalendarButton().setBackground(Color.WHITE);
		gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 3;
		gbc_dateChooser.gridy = 3;
		panel.add(dateChooser, gbc_dateChooser);

		lblEmail = new JLabel("<html><span style='color:red;'>*</span>Email:</html>");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.gridx = 2;
		gbc_lblEmail.gridy = 4;
		panel.add(lblEmail, gbc_lblEmail);

		txtEmail = new JTextField();
		txtEmail.setText(Controlador.getUnicaInstancia().getUsuarioActual().getEmail());
		gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.gridwidth = 2;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 3;
		gbc_txtEmail.gridy = 4;
		panel.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);

		contrasena = new JLabel("<html><span style='color:red;'>*</span>Contraseña:</html>");
		contrasena.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_contrasena = new GridBagConstraints();
		gbc_contrasena.anchor = GridBagConstraints.EAST;
		gbc_contrasena.insets = new Insets(0, 0, 5, 5);
		gbc_contrasena.gridx = 2;
		gbc_contrasena.gridy = 5;
		panel.add(contrasena, gbc_contrasena);

		passContrasena = new JPasswordField();
		String contra = new String(Controlador.getUnicaInstancia().getUsuarioActual().getContrasena());
		passContrasena.setText(contra);
		GridBagConstraints gbc_passContrasena = new GridBagConstraints();
		gbc_passContrasena.gridwidth = 2;
		gbc_passContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_passContrasena.fill = GridBagConstraints.HORIZONTAL;
		gbc_passContrasena.gridx = 3;
		gbc_passContrasena.gridy = 5;
		panel.add(passContrasena, gbc_passContrasena);

		contrasenaRepe = new JLabel("<html><span style='color:red;'>*</span>Confirmar contraseña:</html>");
		contrasenaRepe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_contrasenaRepe = new GridBagConstraints();
		gbc_contrasenaRepe.insets = new Insets(0, 0, 5, 5);
		gbc_contrasenaRepe.anchor = GridBagConstraints.NORTHEAST;
		gbc_contrasenaRepe.gridx = 2;
		gbc_contrasenaRepe.gridy = 6;
		panel.add(contrasenaRepe, gbc_contrasenaRepe);

		passContrasenaRepe = new JPasswordField();
		passContrasenaRepe.setText(contra);
		GridBagConstraints gbc_passContrasenaRepe = new GridBagConstraints();
		gbc_passContrasenaRepe.anchor = GridBagConstraints.NORTH;
		gbc_passContrasenaRepe.gridwidth = 2;
		gbc_passContrasenaRepe.insets = new Insets(0, 0, 5, 5);
		gbc_passContrasenaRepe.fill = GridBagConstraints.HORIZONTAL;
		gbc_passContrasenaRepe.gridx = 3;
		gbc_passContrasenaRepe.gridy = 6;
		panel.add(passContrasenaRepe, gbc_passContrasenaRepe);

		textImagen = new JTextField();
		textImagen.setText(Controlador.getUnicaInstancia().getUsuarioActual().getImagenPerfilRuta());
		textImagen.setColumns(10);
		GridBagConstraints gbc_textImagen = new GridBagConstraints();
		gbc_textImagen.insets = new Insets(0, 0, 5, 5);
		gbc_textImagen.fill = GridBagConstraints.HORIZONTAL;
		gbc_textImagen.gridx = 1;
		gbc_textImagen.gridy = 7;
		panel.add(textImagen, gbc_textImagen);

		saludo = new JLabel("Saludo:");
		saludo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_saludo = new GridBagConstraints();
		gbc_saludo.insets = new Insets(0, 0, 5, 5);
		gbc_saludo.gridx = 2;
		gbc_saludo.gridy = 9;
		panel.add(saludo, gbc_saludo);

		txtsaludo = new JTextArea();
		txtsaludo.setText(Controlador.getUnicaInstancia().getUsuarioActual().getMensajeSaludo());
		gbc_txtrsaludo = new GridBagConstraints();
		gbc_txtrsaludo.gridheight = 2;
		gbc_txtrsaludo.gridwidth = 2;
		gbc_txtrsaludo.insets = new Insets(0, 0, 5, 5);
		gbc_txtrsaludo.fill = GridBagConstraints.BOTH;
		gbc_txtrsaludo.gridx = 3;
		gbc_txtrsaludo.gridy = 9;
		panel.add(txtsaludo, gbc_txtrsaludo);

		lblError = new JLabel("La dirección de correo electrónico no existe");
		lblError.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.gridwidth = 3;
		gbc_lblError.insets = new Insets(0, 0, 5, 5);
		gbc_lblError.gridx = 2;
		gbc_lblError.gridy = 11;
		panel.add(lblError, gbc_lblError);
		lblError.setVisible(false);

		lblRegistro = new JLabel(
				"Usuario desde: " + Controlador.getUnicaInstancia().getUsuarioActual().getFechaRegistro().toString());
		gbc_lblRegistro = new GridBagConstraints();
		gbc_lblRegistro.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegistro.gridx = 1;
		gbc_lblRegistro.gridy = 12;
		panel.add(lblRegistro, gbc_lblRegistro);

		btnRestaurar = new JButton("Restaurar valores");
		btnRestaurar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRestaurar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRestaurar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnRestaurar.setBackground(new Color(255, 255, 255));
		gbc_btnRestaurar = new GridBagConstraints();
		gbc_btnRestaurar.fill = GridBagConstraints.BOTH;
		gbc_btnRestaurar.insets = new Insets(0, 0, 5, 5);
		gbc_btnRestaurar.gridx = 4;
		gbc_btnRestaurar.gridy = 12;
		panel.add(btnRestaurar, gbc_btnRestaurar);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnAceptar.setBackground(new Color(255, 255, 255));
		gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 5;
		gbc_btnNewButton_2.gridy = 12;
		panel.add(btnAceptar, gbc_btnNewButton_2);

		btnAtras.addActionListener(this);
		btnRestaurar.addActionListener(this);
		btnAceptar.addActionListener(this);
		mntmContactos.addActionListener(this);
		mntmCerrarSesion.addActionListener(this);
		mntmEditarPerfil.addActionListener(this);
		mntmPremium.addActionListener(this);
		mntmContactosPdf.addActionListener(this);
		mntmMensajesPdf.addActionListener(this);

		frmAppchat.setSize(tam);
		frmAppchat.setLocation(ubi);
		frmAppchat.setVisible(true);
	}

	public static boolean esCorreoValido(String correo) {
		return Pattern.matches("^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$", correo);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRestaurar) {
			txtNombre.setText(Controlador.getUnicaInstancia().getUsuarioActual().getNombre());

			try {
				icono.setIcon(
						new ImageIcon(Controlador.getUnicaInstancia().getUsuarioActual().getImagenPerfilDirecta()));
				ImageInJLabel.resizeImage(icono,
						Controlador.getUnicaInstancia().getUsuarioActual().getImagenPerfilDirecta());
			} catch (IOException ex) {
				ex.printStackTrace();
			}

			txtEmail.setText(Controlador.getUnicaInstancia().getUsuarioActual().getEmail());
			dateChooser.setDate(Date.from(Controlador.getUnicaInstancia().getUsuarioActual().getFechaNacimiento()
					.atStartOfDay(ZoneId.systemDefault()).toInstant()));
			String contra = new String(Controlador.getUnicaInstancia().getUsuarioActual().getContrasena());
			passContrasena.setText(contra);
			passContrasenaRepe.setText(contra);
			txtsaludo.setText(Controlador.getUnicaInstancia().getUsuarioActual().getMensajeSaludo());
			textImagen.setText(Controlador.getUnicaInstancia().getUsuarioActual().getImagenPerfilRuta());
			lblError.setVisible(false);
		}
		if (e.getSource() == btnAtras) {
			if (ventanaAnterior.equals("VentanaMain")) {
				new VentanaMain(frmAppchat.getSize(), frmAppchat.getLocation(), null);
				frmAppchat.dispose();
			} else if (ventanaAnterior.equals("VentanaContactos")) {
				new VentanaContactos(frmAppchat.getSize(), frmAppchat.getLocation());
				frmAppchat.dispose();
			} else {
				new VentanaMain(frmAppchat.getSize(), frmAppchat.getLocation(), null);
				frmAppchat.dispose();
			}

		}
		if (e.getSource() == btnAceptar) {
			if (txtNombre.getText().equals("") || txtEmail.getText().equals("")
					|| passContrasena.getPassword().length == 0 || passContrasenaRepe.getPassword().length == 0) {
				lblError.setText("Se deben rellenar todos los campos marcados con *");
				lblError.setVisible(true);
			} else {
				//Solo intentara modificar el usuario si se ha modificado algun dato de verdad
				if (esCorreoValido(txtEmail.getText())) {
					if (Arrays.equals(passContrasena.getPassword(), passContrasenaRepe.getPassword())) {
						LocalDate fechaNacimiento = null;
						if (dateChooser.getDate() != null) {
							fechaNacimiento = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault())
									.toLocalDate();
						}
						if (fechaNacimiento == null || fechaNacimiento.isBefore(LocalDate.now())) {
							Controlador.getUnicaInstancia().modificarUsuario(txtNombre.getText(), txtEmail.getText(),
									passContrasena.getPassword(), fechaNacimiento, txtsaludo.getText(),
									textImagen.getText());
							lblError.setVisible(false);
							JOptionPane.showMessageDialog(frmAppchat, "Su perfil se ha modificado correctamente",
									"Enhorabuena", JOptionPane.PLAIN_MESSAGE);
							// Vuelve a la ventana anterior
							if (ventanaAnterior.equals("VentanaMain")) {
								new VentanaMain(frmAppchat.getSize(), frmAppchat.getLocation(), null);
								frmAppchat.dispose();
							} else if (ventanaAnterior.equals("VentanaContactos")) {
								new VentanaContactos(frmAppchat.getSize(), frmAppchat.getLocation());
								frmAppchat.dispose();
							}
						} else {
							lblError.setText("La fecha de nacimiento no puede ser posterior a la fecha actual.");
							lblError.setVisible(true);
						}
					} else {
						passContrasena.setText("");
						passContrasenaRepe.setText("");
						lblError.setText("Las contraseñas no coinciden");
						lblError.setVisible(true);
					}
				} else {
					txtEmail.setText("");
					lblError.setText("La dirección de correo electrónico no existe");
					lblError.setVisible(true);
				}
			}
		}
		if (e.getSource() == mntmPremium) {
			if (Controlador.getUnicaInstancia().getUsuarioActual().isPremium()) {
				int res = JOptionPane.showConfirmDialog(frmAppchat, "¿Está seguro de que desea dejar de ser Premium?",
						"Dejar de ser premium", JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION) {
					Controlador.getUnicaInstancia().setPremium(false);

					try {
						BufferedImage image = ImageIO.read(getClass().getResource("/imagenes/orejas_premium.png"));
						mntmPremium.setIcon(new ImageIcon(image));
						mntmPremium.setSize(new Dimension(64, 32));
						ImageInJLabel.resizeImage(mntmPremium, image);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			} else {
				new VentanaOferta(frmAppchat.getSize(), frmAppchat.getLocation(), "VentanaMain");
				frmAppchat.dispose();
			}
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
	}

}
