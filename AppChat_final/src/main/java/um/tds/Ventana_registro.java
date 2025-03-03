package um.tds;

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

import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;

import java.awt.Font;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class Ventana_registro extends JFrame implements ActionListener {

	private JFrame frmAppchat;
	private JPanel contentPane, panelBotones;
	private JTextField testNombre, testApellidos, testTelefono, textField, textField_1;
	private JLabel fecha, saludo, lblEmail, imagen, nombre, foto, apellidos, telefono, contraseña, confirmar;
	private JTextArea testSaludo;
	private JButton aceptar, cancelar;
	private JScrollPane scrollPane;
	private Component horizontalGlue;
	private JDateChooser dateChooser;
	private JPasswordField testContraseña, testConfirmar;
	private GridBagLayout gbl_contentPane;
	private GridBagConstraints gbc_nombre, gbc_testNombre, gbc_apellidos, gbc_testApellidos, gbc_telefono,
			gbc_testTelefono, gbc_contraseña, gbc_textField, gbc_confirmar, gbc_lblEmail, gbc_testConfirmar,
			gbc_testContraseña, gbc_fecha, gbc_dateChooser, gbc_saludo, gbc_scrollPane, gbc_imagen, gbc_foto,
			gbc_panelBotones, gbc_textField_1;
	private JButton btnAtras;

	public void mostrarRegistro() {
		setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Ventana_registro(Ventana_inicio v) {
		initialize(v);
		frmAppchat.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(Ventana_inicio v) {

		frmAppchat = new JFrame();
		frmAppchat.setBackground(new Color(255, 255, 255));
		frmAppchat.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Ventana_login.class.getResource("/imagenes/gatoVentana2_2048.png")));
		frmAppchat.setTitle("AppChat");
		frmAppchat.setBounds(300, 300, 907, 680);
		frmAppchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmAppchat.getContentPane().add(contentPane);
		// setContentPane(contentPane);

		gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 20, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		btnAtras = new JButton("");
		btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtras.setPreferredSize(new Dimension(32, 32));
		btnAtras.setBackground(new Color(255, 255, 255));
		btnAtras.setIcon(new ImageIcon(Ventana_login.class.getResource("/imagenes/mod_boton-de-retroceso.png")));
		btnAtras.setSize(new Dimension(32, 32));
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAtras.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtras.gridx = 0;
		gbc_btnAtras.gridy = 0;
		contentPane.add(btnAtras, gbc_btnAtras);

		nombre = new JLabel("Nombre:");
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_nombre = new GridBagConstraints();
		gbc_nombre.anchor = GridBagConstraints.EAST;
		gbc_nombre.insets = new Insets(0, 0, 5, 5);
		gbc_nombre.gridx = 1;
		gbc_nombre.gridy = 1;
		contentPane.add(nombre, gbc_nombre);

		testNombre = new JTextField();
		gbc_testNombre = new GridBagConstraints();
		gbc_testNombre.gridwidth = 3;
		gbc_testNombre.insets = new Insets(0, 0, 5, 5);
		gbc_testNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_testNombre.gridx = 2;
		gbc_testNombre.gridy = 1;
		contentPane.add(testNombre, gbc_testNombre);
		testNombre.setColumns(10);

		apellidos = new JLabel("Apellidos:");
		apellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_apellidos = new GridBagConstraints();
		gbc_apellidos.anchor = GridBagConstraints.EAST;
		gbc_apellidos.insets = new Insets(0, 0, 5, 5);
		gbc_apellidos.gridx = 1;
		gbc_apellidos.gridy = 2;
		contentPane.add(apellidos, gbc_apellidos);

		testApellidos = new JTextField();
		gbc_testApellidos = new GridBagConstraints();
		gbc_testApellidos.gridwidth = 3;
		gbc_testApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_testApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_testApellidos.gridx = 2;
		gbc_testApellidos.gridy = 2;
		contentPane.add(testApellidos, gbc_testApellidos);
		testApellidos.setColumns(10);

		telefono = new JLabel("Teléfono:");
		telefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_telefono = new GridBagConstraints();
		gbc_telefono.anchor = GridBagConstraints.EAST;
		gbc_telefono.insets = new Insets(0, 0, 5, 5);
		gbc_telefono.gridx = 1;
		gbc_telefono.gridy = 3;
		contentPane.add(telefono, gbc_telefono);

		testTelefono = new JTextField();
		gbc_testTelefono = new GridBagConstraints();
		gbc_testTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_testTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_testTelefono.gridx = 2;
		gbc_testTelefono.gridy = 3;
		contentPane.add(testTelefono, gbc_testTelefono);
		testTelefono.setColumns(10);

		contraseña = new JLabel("Contraseña:");
		contraseña.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_contraseña = new GridBagConstraints();
		gbc_contraseña.anchor = GridBagConstraints.EAST;
		gbc_contraseña.insets = new Insets(0, 0, 5, 5);
		gbc_contraseña.gridx = 1;
		gbc_contraseña.gridy = 4;
		contentPane.add(contraseña, gbc_contraseña);

		textField = new JTextField();
		textField.setColumns(10);
		gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 4;
		contentPane.add(textField, gbc_textField);

		confirmar = new JLabel("Confirmar contraseña:");
		confirmar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_confirmar = new GridBagConstraints();
		gbc_confirmar.anchor = GridBagConstraints.EAST;
		gbc_confirmar.insets = new Insets(0, 0, 5, 5);
		gbc_confirmar.gridx = 3;
		gbc_confirmar.gridy = 4;
		contentPane.add(confirmar, gbc_confirmar);

		testConfirmar = new JPasswordField();
		gbc_testConfirmar = new GridBagConstraints();
		gbc_testConfirmar.insets = new Insets(0, 0, 5, 5);
		gbc_testConfirmar.fill = GridBagConstraints.HORIZONTAL;
		gbc_testConfirmar.gridx = 4;
		gbc_testConfirmar.gridy = 4;
		contentPane.add(testConfirmar, gbc_testConfirmar);

		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 5;
		contentPane.add(lblEmail, gbc_lblEmail);

		testContraseña = new JPasswordField();
		gbc_testContraseña = new GridBagConstraints();
		gbc_testContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_testContraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_testContraseña.gridx = 2;
		gbc_testContraseña.gridy = 5;
		contentPane.add(testContraseña, gbc_testContraseña);

		fecha = new JLabel("Fecha:");
		fecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_fecha = new GridBagConstraints();
		gbc_fecha.anchor = GridBagConstraints.EAST;
		gbc_fecha.insets = new Insets(0, 0, 5, 5);
		gbc_fecha.gridx = 1;
		gbc_fecha.gridy = 6;
		contentPane.add(fecha, gbc_fecha);

		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setBackground(new Color(255, 255, 255));
		gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 6;
		contentPane.add(dateChooser, gbc_dateChooser);

		saludo = new JLabel("Saludo:");
		saludo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_saludo = new GridBagConstraints();
		gbc_saludo.gridheight = 2;
		gbc_saludo.anchor = GridBagConstraints.NORTHEAST;
		gbc_saludo.insets = new Insets(0, 0, 5, 5);
		gbc_saludo.gridx = 1;
		gbc_saludo.gridy = 7;
		contentPane.add(saludo, gbc_saludo);

		scrollPane = new JScrollPane();
		gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 7;
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
		gbc_imagen.gridy = 7;
		contentPane.add(imagen, gbc_imagen);

		foto = new JLabel("");
		foto.setSize(150, 150);
		foto.setIcon(new ImageIcon(Ventana_registro.class.getResource("/imagenes/gato_perfil.png")));
		ImageInJLabel.resizeImage(foto, Ventana_Perfil.class.getResource("/imagenes/gato_perfil.png"));
		gbc_foto = new GridBagConstraints();
		gbc_foto.fill = GridBagConstraints.BOTH;
		gbc_foto.gridheight = 4;
		gbc_foto.insets = new Insets(0, 0, 5, 5);
		gbc_foto.gridx = 4;
		gbc_foto.gridy = 5;
		contentPane.add(foto, gbc_foto);

		panelBotones = new JPanel();
		panelBotones.setBackground(new Color(255, 255, 255));
		gbc_panelBotones = new GridBagConstraints();
		gbc_panelBotones.insets = new Insets(0, 0, 5, 5);
		gbc_panelBotones.fill = GridBagConstraints.BOTH;
		gbc_panelBotones.gridx = 2;
		gbc_panelBotones.gridy = 9;
		contentPane.add(panelBotones, gbc_panelBotones);
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));

		aceptar = new JButton("Aceptar");
		aceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelBotones.add(aceptar);

		horizontalGlue = Box.createHorizontalGlue();
		panelBotones.add(horizontalGlue);

		cancelar = new JButton("Cancelar");
		cancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelBotones.add(cancelar);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 9;
		contentPane.add(textField_1, gbc_textField_1);

		btnAtras.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAtras) {
			frmAppchat.dispose();
			Ventana_inicio inicio = new Ventana_inicio();
			inicio.setLocationRelativeTo(this);
			inicio.mostrarInicio();
			return;
		}
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}

}
