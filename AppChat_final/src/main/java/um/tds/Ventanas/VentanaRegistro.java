package um.tds.Ventanas;

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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import um.tds.Controlador.Controlador;

public class VentanaRegistro implements ActionListener {

	private JFrame frmAppchat;
	private JPanel contentPane, panelBotones;
	private JTextField textNombre, textTelefono, textImagen, textEmail;
	private JLabel fecha, saludo, lblEmail, imagen, nombre, foto, telefono, contrasena, confirmar, titulo, lblError;
	private JTextArea testSaludo;
	private JButton cancelar, aceptar;
	private JScrollPane scrollPane;
	private JDateChooser dateChooser;
	private GridBagLayout gbl_contentPane;
	private GridBagConstraints gbc_nombre, gbc_textNombre, gbc_telefono, gbc_textTelefono, gbc_contrasena,
			gbc_confirmar, gbc_lblEmail, gbc_fecha, gbc_dateChooser, gbc_saludo, gbc_scrollPane, gbc_imagen, gbc_foto,
			gbc_panelBotones, gbc_textImagen, gbc_titulo, gbc_passContrasena, gbc_passContrasenaRepe, gbc_textEmail,
			gbc_lblError;
	private Component horizontalGlue;
	private JPasswordField passContrasena, passContrasenaRepe;

	/**
	 * Create the frame.
	 */
	public VentanaRegistro(Dimension tam, Point ubi) {
		initialize(tam, ubi);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(Dimension tam, Point ubi) {

		frmAppchat = new JFrame();
		frmAppchat.setBackground(new Color(255, 244, 244));
		frmAppchat.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaLogin.class.getResource("/imagenes/gatoVentana2_2048.png")));
		frmAppchat.setTitle("AppChat");
		frmAppchat.setBounds(300, 300, 907, 680);
		frmAppchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 244, 244));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmAppchat.getContentPane().add(contentPane);
		// setContentPane(contentPane);

		gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 20, 0, 0, 0, 0, 116, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				0.0, 1.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		titulo = new JLabel("AppChat");
		titulo.setForeground(new Color(254, 127, 154));
		titulo.setFont(new Font("Brush Script MT", Font.BOLD, 75));
		gbc_titulo = new GridBagConstraints();
		gbc_titulo.gridwidth = 2;
		gbc_titulo.gridheight = 6;
		gbc_titulo.anchor = GridBagConstraints.NORTHEAST;
		gbc_titulo.insets = new Insets(0, 0, 5, 0);
		gbc_titulo.gridx = 5;
		gbc_titulo.gridy = 0;
		contentPane.add(titulo, gbc_titulo);

		lblError = new JLabel("La dirección de correo electrónico no existe");
		lblError.setForeground(new Color(255, 0, 0));
		gbc_lblError = new GridBagConstraints();
		gbc_lblError.gridwidth = 3;
		gbc_lblError.insets = new Insets(0, 0, 5, 5);
		gbc_lblError.gridx = 2;
		gbc_lblError.gridy = 4;
		contentPane.add(lblError, gbc_lblError);
		lblError.setVisible(false);

		nombre = new JLabel("<html><span style='color:red;'>*</span>Nombre completo:</html>");
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_nombre = new GridBagConstraints();
		gbc_nombre.anchor = GridBagConstraints.EAST;
		gbc_nombre.insets = new Insets(0, 0, 5, 5);
		gbc_nombre.gridx = 1;
		gbc_nombre.gridy = 6;
		contentPane.add(nombre, gbc_nombre);

		textNombre = new JTextField();
		gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.gridwidth = 4;
		gbc_textNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.gridx = 2;
		gbc_textNombre.gridy = 6;
		contentPane.add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);

		telefono = new JLabel("<html><span style='color:red;'>*</span>Teléfono:</html>");
		telefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_telefono = new GridBagConstraints();
		gbc_telefono.anchor = GridBagConstraints.EAST;
		gbc_telefono.insets = new Insets(0, 0, 5, 5);
		gbc_telefono.gridx = 1;
		gbc_telefono.gridy = 7;
		contentPane.add(telefono, gbc_telefono);

		textTelefono = new JTextField();
		gbc_textTelefono = new GridBagConstraints();
		gbc_textTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_textTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTelefono.gridx = 2;
		gbc_textTelefono.gridy = 7;
		contentPane.add(textTelefono, gbc_textTelefono);
		textTelefono.setColumns(10);

		contrasena = new JLabel("<html><span style='color:red;'>*</span>Contraseña:</html>");
		contrasena.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_contrasena = new GridBagConstraints();
		gbc_contrasena.anchor = GridBagConstraints.EAST;
		gbc_contrasena.insets = new Insets(0, 0, 5, 5);
		gbc_contrasena.gridx = 1;
		gbc_contrasena.gridy = 8;
		contentPane.add(contrasena, gbc_contrasena);

		passContrasena = new JPasswordField();
		gbc_passContrasena = new GridBagConstraints();
		gbc_passContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_passContrasena.fill = GridBagConstraints.HORIZONTAL;
		gbc_passContrasena.gridx = 2;
		gbc_passContrasena.gridy = 8;
		contentPane.add(passContrasena, gbc_passContrasena);

		confirmar = new JLabel("<html><span style='color:red;'>*</span>Confirmar contraseña:</html>");
		confirmar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_confirmar = new GridBagConstraints();
		gbc_confirmar.anchor = GridBagConstraints.EAST;
		gbc_confirmar.insets = new Insets(0, 0, 5, 5);
		gbc_confirmar.gridx = 3;
		gbc_confirmar.gridy = 8;
		contentPane.add(confirmar, gbc_confirmar);

		passContrasenaRepe = new JPasswordField();
		gbc_passContrasenaRepe = new GridBagConstraints();
		gbc_passContrasenaRepe.gridwidth = 2;
		gbc_passContrasenaRepe.insets = new Insets(0, 0, 5, 5);
		gbc_passContrasenaRepe.fill = GridBagConstraints.HORIZONTAL;
		gbc_passContrasenaRepe.gridx = 4;
		gbc_passContrasenaRepe.gridy = 8;
		contentPane.add(passContrasenaRepe, gbc_passContrasenaRepe);

		lblEmail = new JLabel("<html><span style='color:red;'>*</span>Email:</html>");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 9;
		contentPane.add(lblEmail, gbc_lblEmail);

		textEmail = new JTextField();
		gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 2;
		gbc_textEmail.gridy = 9;
		contentPane.add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);

		fecha = new JLabel("Fecha de nacimiento:");
		fecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_fecha = new GridBagConstraints();
		gbc_fecha.anchor = GridBagConstraints.EAST;
		gbc_fecha.insets = new Insets(0, 0, 5, 5);
		gbc_fecha.gridx = 1;
		gbc_fecha.gridy = 10;
		contentPane.add(fecha, gbc_fecha);

		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooser.getCalendarButton().setBackground(new Color(255, 255, 255));
		gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 10;
		contentPane.add(dateChooser, gbc_dateChooser);

		saludo = new JLabel("Saludo:");
		saludo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_saludo = new GridBagConstraints();
		gbc_saludo.gridheight = 2;
		gbc_saludo.anchor = GridBagConstraints.NORTHEAST;
		gbc_saludo.insets = new Insets(0, 0, 5, 5);
		gbc_saludo.gridx = 1;
		gbc_saludo.gridy = 11;
		contentPane.add(saludo, gbc_saludo);

		scrollPane = new JScrollPane();
		gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 11;
		contentPane.add(scrollPane, gbc_scrollPane);

		testSaludo = new JTextArea();
		scrollPane.setViewportView(testSaludo);

		imagen = new JLabel("Imagen:");
		imagen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_imagen = new GridBagConstraints();
		gbc_imagen.anchor = GridBagConstraints.NORTHEAST;
		gbc_imagen.gridheight = 2;
		gbc_imagen.insets = new Insets(0, 0, 5, 5);
		gbc_imagen.gridx = 3;
		gbc_imagen.gridy = 11;
		contentPane.add(imagen, gbc_imagen);

		foto = new JLabel("");
		foto.setSize(250, 250);
		foto.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/imagenes/gato_perfil.png")));
		ImageInJLabel.resizeImage(foto, VentanaPerfil.class.getResource("/imagenes/gato_perfil.png"));
		gbc_foto = new GridBagConstraints();
		gbc_foto.gridwidth = 2;
		gbc_foto.fill = GridBagConstraints.BOTH;
		gbc_foto.gridheight = 4;
		gbc_foto.insets = new Insets(0, 0, 5, 5);
		gbc_foto.gridx = 4;
		gbc_foto.gridy = 9;
		contentPane.add(foto, gbc_foto);

		panelBotones = new JPanel();
		panelBotones.setBackground(new Color(255, 244, 244));
		gbc_panelBotones = new GridBagConstraints();
		gbc_panelBotones.insets = new Insets(0, 0, 5, 5);
		gbc_panelBotones.fill = GridBagConstraints.BOTH;
		gbc_panelBotones.gridx = 2;
		gbc_panelBotones.gridy = 13;
		contentPane.add(panelBotones, gbc_panelBotones);
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));

		aceptar = new JButton("Aceptar");
		aceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		aceptar.setMinimumSize(new Dimension(77, 21));
		aceptar.setMaximumSize(new Dimension(77, 21));
		aceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		aceptar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		aceptar.setBackground(Color.WHITE);
		panelBotones.add(aceptar);

		horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setForeground(new Color(255, 244, 244));
		horizontalGlue.setBackground(new Color(255, 244, 244));
		panelBotones.add(horizontalGlue);

		cancelar = new JButton("Cancelar");
		cancelar.setBackground(new Color(255, 255, 255));
		cancelar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cancelar.setMaximumSize(new Dimension(77, 21));
		cancelar.setMinimumSize(new Dimension(77, 21));
		cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelBotones.add(cancelar);

		textImagen = new JTextField();
		textImagen.setColumns(10);
		gbc_textImagen = new GridBagConstraints();
		gbc_textImagen.gridwidth = 2;
		gbc_textImagen.insets = new Insets(0, 0, 5, 5);
		gbc_textImagen.fill = GridBagConstraints.HORIZONTAL;
		gbc_textImagen.gridx = 4;
		gbc_textImagen.gridy = 13;
		contentPane.add(textImagen, gbc_textImagen);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frmAppchat.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frmAppchat.getHeight()) / 2);
		frmAppchat.setLocation(x, y);
		aceptar.addActionListener(this);
		cancelar.addActionListener(this);

		frmAppchat.setVisible(true);
		frmAppchat.setSize(tam);
		frmAppchat.setLocation(ubi);
	}

	public static boolean esCorreoValido(String correo) {
		return Pattern.matches("^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$", correo);
	}

	public static boolean esTelfValido(String telf) {
		return Pattern.matches("\\d{9}", telf);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == aceptar) { 
			if (textNombre.getText().equals("") || textTelefono.getText().equals("") || textEmail.getText().equals("")
					|| passContrasena.getPassword().length == 0 || passContrasenaRepe.getPassword().length == 0) {
				lblError.setText("Se deben rellenar todos los campos marcados con *");
				lblError.setVisible(true);
			} else {
				if (esCorreoValido(textEmail.getText())) {
					if (esTelfValido(textTelefono.getText())) {
						if (Arrays.equals(passContrasena.getPassword(), passContrasenaRepe.getPassword())) {
							LocalDate fechaNacimiento = null;
							if (dateChooser.getDate() != null) {
								fechaNacimiento = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault())
										.toLocalDate();
							}
							if (fechaNacimiento == null || fechaNacimiento.isBefore(LocalDate.now())) {
								if (Controlador.getUnicaInstancia().registrarUsuario(textNombre.getText(),
										textTelefono.getText(), textEmail.getText(), passContrasena.getPassword(),
										fechaNacimiento, testSaludo.getText(), textImagen.getText())) {
									new VentanaLogin(frmAppchat.getSize(), frmAppchat.getLocation());
									frmAppchat.dispose();
									// login.mostrarLogin(frmAppchat.getSize(),frmAppchat.getLocation());

								} else {
									textTelefono.setText("");
									textEmail.setText("");
									lblError.setText("El telefono ya está registrado");
									lblError.setVisible(true);
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
						textTelefono.setText("");
						lblError.setText("El teléfono no existe");
						lblError.setVisible(true);
					}
				} else {
					textEmail.setText("");
					lblError.setText("La dirección de correo electrónico no existe");
					lblError.setVisible(true);
				}
			}
		} else { // btnCancelar
			new VentanaInicio(frmAppchat.getSize(), frmAppchat.getLocation());
			frmAppchat.dispose();
			return;
		}
	}

}
