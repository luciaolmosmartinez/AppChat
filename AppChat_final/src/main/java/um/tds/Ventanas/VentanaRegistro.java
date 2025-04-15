package um.tds.Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.Box;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;

import java.awt.Font;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class VentanaRegistro extends JFrame implements ActionListener {

	private JFrame frmAppchat;
	private JPanel contentPane, panelBotones;
	private JTextField textNombre, textApellidos, textTelefono, textImagen, textEmail;
	private JLabel fecha, saludo, lblEmail, imagen, nombre, foto, apellidos, telefono, contraseña, confirmar, titulo,
			lblErrorVacio, lblErrorRepe, lblErrorContrasenas, lblErrorEmail, lblErrorTelf;
	private JTextArea testSaludo;
	private JButton cancelar, aceptar;
	private JScrollPane scrollPane;
	private JDateChooser dateChooser;
	private GridBagLayout gbl_contentPane;
	private GridBagConstraints gbc_nombre, gbc_textNombre, gbc_apellidos, gbc_textApellidos, gbc_telefono,
			gbc_textTelefono, gbc_contraseña, gbc_confirmar, gbc_lblEmail, gbc_fecha, gbc_dateChooser, gbc_saludo,
			gbc_scrollPane, gbc_imagen, gbc_foto, gbc_panelBotones, gbc_textImagen, gbc_titulo, gbc_passContrasena,
			gbc_passContrasenaRepe, gbc_textEmail, gbc_lblErrorVacio, gbc_lblErrorRepe, gbc_lblErrorContrasenas,
			gbc_lblErrorEmail, gbc_lblErrorTelf;
	private Component horizontalGlue;
	private JPasswordField passContrasena, passContrasenaRepe;

	public void mostrarRegistro() {
		frmAppchat.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {

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
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
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

		lblErrorVacio = new JLabel("Se deben rellenar todos los campos marcados con *");
		lblErrorVacio.setForeground(new Color(255, 0, 0));
		gbc_lblErrorVacio = new GridBagConstraints();
		gbc_lblErrorVacio.gridwidth = 3;
		gbc_lblErrorVacio.insets = new Insets(0, 0, 5, 5);
		gbc_lblErrorVacio.gridx = 2;
		gbc_lblErrorVacio.gridy = 1;
		contentPane.add(lblErrorVacio, gbc_lblErrorVacio);
		lblErrorVacio.setVisible(false);

		lblErrorRepe = new JLabel("El telefono y/o el correo electrónico ya está registrado");
		lblErrorRepe.setForeground(new Color(255, 0, 0));
		gbc_lblErrorRepe = new GridBagConstraints();
		gbc_lblErrorRepe.gridwidth = 3;
		gbc_lblErrorRepe.insets = new Insets(0, 0, 5, 5);
		gbc_lblErrorRepe.gridx = 2;
		gbc_lblErrorRepe.gridy = 2;
		contentPane.add(lblErrorRepe, gbc_lblErrorRepe);
		lblErrorRepe.setVisible(false);

		lblErrorContrasenas = new JLabel("Las contraseñas no coinciden");
		lblErrorContrasenas.setForeground(new Color(255, 0, 0));
		gbc_lblErrorContrasenas = new GridBagConstraints();
		gbc_lblErrorContrasenas.gridwidth = 3;
		gbc_lblErrorContrasenas.insets = new Insets(0, 0, 5, 5);
		gbc_lblErrorContrasenas.gridx = 2;
		gbc_lblErrorContrasenas.gridy = 3;
		contentPane.add(lblErrorContrasenas, gbc_lblErrorContrasenas);
		lblErrorContrasenas.setVisible(false);

		lblErrorEmail = new JLabel("La dirección de correo electrónico no existe");
		lblErrorEmail.setForeground(new Color(255, 0, 0));
		gbc_lblErrorEmail = new GridBagConstraints();
		gbc_lblErrorEmail.gridwidth = 3;
		gbc_lblErrorEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblErrorEmail.gridx = 2;
		gbc_lblErrorEmail.gridy = 4;
		contentPane.add(lblErrorEmail, gbc_lblErrorEmail);
		lblErrorEmail.setVisible(false);

		lblErrorTelf = new JLabel("El teléfono no existe");
		lblErrorTelf.setForeground(new Color(255, 0, 0));
		gbc_lblErrorTelf = new GridBagConstraints();
		gbc_lblErrorTelf.gridwidth = 3;
		gbc_lblErrorTelf.insets = new Insets(0, 0, 5, 5);
		gbc_lblErrorTelf.gridx = 2;
		gbc_lblErrorTelf.gridy = 5;
		contentPane.add(lblErrorTelf, gbc_lblErrorTelf);
		lblErrorTelf.setVisible(false);

		nombre = new JLabel("<html><span style='color:red;'>*</span>Nombre:</html>");
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

		apellidos = new JLabel("<html><span style='color:red;'>*</span>Apellidos:</html>");
		apellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_apellidos = new GridBagConstraints();
		gbc_apellidos.anchor = GridBagConstraints.EAST;
		gbc_apellidos.insets = new Insets(0, 0, 5, 5);
		gbc_apellidos.gridx = 1;
		gbc_apellidos.gridy = 7;
		contentPane.add(apellidos, gbc_apellidos);

		textApellidos = new JTextField();
		gbc_textApellidos = new GridBagConstraints();
		gbc_textApellidos.gridwidth = 4;
		gbc_textApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_textApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textApellidos.gridx = 2;
		gbc_textApellidos.gridy = 7;
		contentPane.add(textApellidos, gbc_textApellidos);
		textApellidos.setColumns(10);

		telefono = new JLabel("<html><span style='color:red;'>*</span>Teléfono:</html>");
		telefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_telefono = new GridBagConstraints();
		gbc_telefono.anchor = GridBagConstraints.EAST;
		gbc_telefono.insets = new Insets(0, 0, 5, 5);
		gbc_telefono.gridx = 1;
		gbc_telefono.gridy = 8;
		contentPane.add(telefono, gbc_telefono);

		textTelefono = new JTextField();
		gbc_textTelefono = new GridBagConstraints();
		gbc_textTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_textTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTelefono.gridx = 2;
		gbc_textTelefono.gridy = 8;
		contentPane.add(textTelefono, gbc_textTelefono);
		textTelefono.setColumns(10);

		contraseña = new JLabel("<html><span style='color:red;'>*</span>Contraseña:</html>");
		contraseña.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_contraseña = new GridBagConstraints();
		gbc_contraseña.anchor = GridBagConstraints.EAST;
		gbc_contraseña.insets = new Insets(0, 0, 5, 5);
		gbc_contraseña.gridx = 1;
		gbc_contraseña.gridy = 9;
		contentPane.add(contraseña, gbc_contraseña);

		passContrasena = new JPasswordField();
		gbc_passContrasena = new GridBagConstraints();
		gbc_passContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_passContrasena.fill = GridBagConstraints.HORIZONTAL;
		gbc_passContrasena.gridx = 2;
		gbc_passContrasena.gridy = 9;
		contentPane.add(passContrasena, gbc_passContrasena);

		confirmar = new JLabel("<html><span style='color:red;'>*</span>Confirmar contraseña:</html>");
		confirmar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_confirmar = new GridBagConstraints();
		gbc_confirmar.anchor = GridBagConstraints.EAST;
		gbc_confirmar.insets = new Insets(0, 0, 5, 5);
		gbc_confirmar.gridx = 3;
		gbc_confirmar.gridy = 9;
		contentPane.add(confirmar, gbc_confirmar);

		passContrasenaRepe = new JPasswordField();
		gbc_passContrasenaRepe = new GridBagConstraints();
		gbc_passContrasenaRepe.gridwidth = 2;
		gbc_passContrasenaRepe.insets = new Insets(0, 0, 5, 5);
		gbc_passContrasenaRepe.fill = GridBagConstraints.HORIZONTAL;
		gbc_passContrasenaRepe.gridx = 4;
		gbc_passContrasenaRepe.gridy = 9;
		contentPane.add(passContrasenaRepe, gbc_passContrasenaRepe);

		lblEmail = new JLabel("<html><span style='color:red;'>*</span>Email:</html>");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 10;
		contentPane.add(lblEmail, gbc_lblEmail);

		textEmail = new JTextField();
		gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 2;
		gbc_textEmail.gridy = 10;
		contentPane.add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);

		fecha = new JLabel("<html><span style='color:red;'>*</span>Fecha:</html>");
		fecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_fecha = new GridBagConstraints();
		gbc_fecha.anchor = GridBagConstraints.EAST;
		gbc_fecha.insets = new Insets(0, 0, 5, 5);
		gbc_fecha.gridx = 1;
		gbc_fecha.gridy = 11;
		contentPane.add(fecha, gbc_fecha);

		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooser.getCalendarButton().setBackground(new Color(255, 255, 255));
		gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 11;
		contentPane.add(dateChooser, gbc_dateChooser);

		saludo = new JLabel("Saludo:");
		saludo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_saludo = new GridBagConstraints();
		gbc_saludo.gridheight = 2;
		gbc_saludo.anchor = GridBagConstraints.NORTHEAST;
		gbc_saludo.insets = new Insets(0, 0, 5, 5);
		gbc_saludo.gridx = 1;
		gbc_saludo.gridy = 12;
		contentPane.add(saludo, gbc_saludo);

		scrollPane = new JScrollPane();
		gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 12;
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
		gbc_imagen.gridy = 12;
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
		gbc_foto.gridy = 10;
		contentPane.add(foto, gbc_foto);

		panelBotones = new JPanel();
		panelBotones.setBackground(new Color(255, 244, 244));
		gbc_panelBotones = new GridBagConstraints();
		gbc_panelBotones.insets = new Insets(0, 0, 5, 5);
		gbc_panelBotones.fill = GridBagConstraints.BOTH;
		gbc_panelBotones.gridx = 2;
		gbc_panelBotones.gridy = 14;
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
		gbc_textImagen.gridy = 14;
		contentPane.add(textImagen, gbc_textImagen);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frmAppchat.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frmAppchat.getHeight()) / 2);
		frmAppchat.setLocation(x, y);
		aceptar.addActionListener(this);
		cancelar.addActionListener(this);
	}

	public static boolean esCorreoValido(String correo) {
		return Pattern.matches("^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$", correo);
	}

	public static boolean esTelfValido(String telf) {
		return Pattern.matches("\\d{9}", telf);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == aceptar) {
			if (lblErrorRepe.isVisible()) {
				lblErrorRepe.setVisible(false);
			} else if (lblErrorContrasenas.isVisible()) {
				lblErrorContrasenas.setVisible(false);
			} else if (lblErrorEmail.isVisible()) {
				lblErrorEmail.setVisible(false);
			} else if (lblErrorTelf.isVisible()) {
				lblErrorTelf.setVisible(false);
			} else if (lblErrorVacio.isVisible()) {
				lblErrorVacio.setVisible(false);
			}
			
			if(textNombre.getText().equals("") || textApellidos.getText().equals("") || textTelefono.getText().equals("") || textEmail.getText().equals("") || passContrasena.getPassword().length == 0 ||  passContrasenaRepe.getPassword().length == 0){
				lblErrorVacio.setVisible(true);
			} else {
				if(esCorreoValido(textEmail.getText())) {
					if(esTelfValido(textTelefono.getText())) {
						if (Arrays.equals(passContrasena.getPassword(),passContrasenaRepe.getPassword())) { 
							//if(controlador.Registrar(textNombre.getText(), textApellidos.getText(), textTelefono.getText(), textEmail.getText(), passContrasena.getPassword())) {
								VentanaLogin login = new VentanaLogin();
								frmAppchat.dispose();
								login.mostrarLogin();
							/*} else {
								textTelefono.setText("");
								textEmail.setText("");
								lblErrorRepe.setVisible(true);
							}*/
						} else {
							passContrasena.setText("");
							passContrasenaRepe.setText("");
							lblErrorContrasenas.setVisible(true);
						}
					} else {
						textTelefono.setText("");
						lblErrorTelf.setVisible(true);
					}
				} else {
					textEmail.setText("");
					lblErrorEmail.setVisible(true);
				}
			}
		} else {	// btnCancelar
		    frmAppchat.dispose();
			VentanaInicio inicio = new VentanaInicio();
			inicio.setLocationRelativeTo(frmAppchat);
			inicio.mostrarInicio();
			return;
		}
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}

}
