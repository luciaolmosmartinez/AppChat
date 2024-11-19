package um.tds;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import javax.swing.Box;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import java.awt.Font;

public class Ventana_registro extends JFrame {

	private JPanel contentPane;
	private JTextField testNombre;
	private JTextField testApellidos;
	private JTextField testTelefono;
	private JLabel fecha;
	private JLabel saludo;
	private JTextArea testSaludo;
	private JPanel panelBotones;
	private JButton aceptar;
	private JButton cancelar;
	private JScrollPane scrollPane;
	private Component horizontalGlue;
	private JLabel imagen;
	private JLabel foto;
	private JTextField URLimagen;
	private JDateChooser dateChooser;
	private JPasswordField testContraseña;
	private JPasswordField testConfirmar;

	/**
	 * Create the frame.
	 */
	public Ventana_registro() {
		setTitle("AppChat");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_registro.class.getResource("/imagenes/gatoVentana2_2048.png")));
		setBackground(new Color(255, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 409);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 20, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel nombre = new JLabel("Nombre:");
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_nombre = new GridBagConstraints();
		gbc_nombre.anchor = GridBagConstraints.EAST;
		gbc_nombre.insets = new Insets(0, 0, 5, 5);
		gbc_nombre.gridx = 1;
		gbc_nombre.gridy = 1;
		contentPane.add(nombre, gbc_nombre);

		testNombre = new JTextField();
		GridBagConstraints gbc_testNombre = new GridBagConstraints();
		gbc_testNombre.gridwidth = 3;
		gbc_testNombre.insets = new Insets(0, 0, 5, 5);
		gbc_testNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_testNombre.gridx = 2;
		gbc_testNombre.gridy = 1;
		contentPane.add(testNombre, gbc_testNombre);
		testNombre.setColumns(10);

		JLabel apellidos = new JLabel("Apellidos:");
		apellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_apellidos = new GridBagConstraints();
		gbc_apellidos.anchor = GridBagConstraints.EAST;
		gbc_apellidos.insets = new Insets(0, 0, 5, 5);
		gbc_apellidos.gridx = 1;
		gbc_apellidos.gridy = 2;
		contentPane.add(apellidos, gbc_apellidos);

		testApellidos = new JTextField();
		GridBagConstraints gbc_testApellidos = new GridBagConstraints();
		gbc_testApellidos.gridwidth = 3;
		gbc_testApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_testApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_testApellidos.gridx = 2;
		gbc_testApellidos.gridy = 2;
		contentPane.add(testApellidos, gbc_testApellidos);
		testApellidos.setColumns(10);

		JLabel telefono = new JLabel("Telefono:");
		telefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_telefono = new GridBagConstraints();
		gbc_telefono.anchor = GridBagConstraints.EAST;
		gbc_telefono.insets = new Insets(0, 0, 5, 5);
		gbc_telefono.gridx = 1;
		gbc_telefono.gridy = 3;
		contentPane.add(telefono, gbc_telefono);

		testTelefono = new JTextField();
		GridBagConstraints gbc_testTelefono = new GridBagConstraints();
		gbc_testTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_testTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_testTelefono.gridx = 2;
		gbc_testTelefono.gridy = 3;
		contentPane.add(testTelefono, gbc_testTelefono);
		testTelefono.setColumns(10);

		JLabel contraseña = new JLabel("Contraseña:");
		contraseña.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_contraseña = new GridBagConstraints();
		gbc_contraseña.anchor = GridBagConstraints.EAST;
		gbc_contraseña.insets = new Insets(0, 0, 5, 5);
		gbc_contraseña.gridx = 1;
		gbc_contraseña.gridy = 4;
		contentPane.add(contraseña, gbc_contraseña);
				
				testContraseña = new JPasswordField();
				GridBagConstraints gbc_testContraseña = new GridBagConstraints();
				gbc_testContraseña.insets = new Insets(0, 0, 5, 5);
				gbc_testContraseña.fill = GridBagConstraints.HORIZONTAL;
				gbc_testContraseña.gridx = 2;
				gbc_testContraseña.gridy = 4;
				contentPane.add(testContraseña, gbc_testContraseña);
		
				JLabel confirmar = new JLabel("Confirmar contraseña:");
				confirmar.setFont(new Font("Tahoma", Font.PLAIN, 12));
				GridBagConstraints gbc_confirmar = new GridBagConstraints();
				gbc_confirmar.anchor = GridBagConstraints.EAST;
				gbc_confirmar.insets = new Insets(0, 0, 5, 5);
				gbc_confirmar.gridx = 3;
				gbc_confirmar.gridy = 4;
				contentPane.add(confirmar, gbc_confirmar);
		
		testConfirmar = new JPasswordField();
		GridBagConstraints gbc_testConfirmar = new GridBagConstraints();
		gbc_testConfirmar.insets = new Insets(0, 0, 5, 5);
		gbc_testConfirmar.fill = GridBagConstraints.HORIZONTAL;
		gbc_testConfirmar.gridx = 4;
		gbc_testConfirmar.gridy = 4;
		contentPane.add(testConfirmar, gbc_testConfirmar);

		fecha = new JLabel("Fecha:");
		fecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_fecha = new GridBagConstraints();
		gbc_fecha.anchor = GridBagConstraints.EAST;
		gbc_fecha.insets = new Insets(0, 0, 5, 5);
		gbc_fecha.gridx = 1;
		gbc_fecha.gridy = 5;
		contentPane.add(fecha, gbc_fecha);

		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 5;
		contentPane.add(dateChooser, gbc_dateChooser);

		saludo = new JLabel("Saludo:");
		saludo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_saludo = new GridBagConstraints();
		gbc_saludo.gridheight = 2;
		gbc_saludo.anchor = GridBagConstraints.NORTHEAST;
		gbc_saludo.insets = new Insets(0, 0, 5, 5);
		gbc_saludo.gridx = 1;
		gbc_saludo.gridy = 6;
		contentPane.add(saludo, gbc_saludo);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 6;
		contentPane.add(scrollPane, gbc_scrollPane);

		testSaludo = new JTextArea();
		scrollPane.setViewportView(testSaludo);

		imagen = new JLabel("Imagen:");
		imagen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_imagen = new GridBagConstraints();
		gbc_imagen.anchor = GridBagConstraints.NORTHEAST;
		gbc_imagen.gridheight = 2;
		gbc_imagen.insets = new Insets(0, 0, 5, 5);
		gbc_imagen.gridx = 3;
		gbc_imagen.gridy = 6;
		contentPane.add(imagen, gbc_imagen);

		URLimagen = new JTextField();
		GridBagConstraints gbc_URLimagen = new GridBagConstraints();
		gbc_URLimagen.anchor = GridBagConstraints.NORTH;
		gbc_URLimagen.fill = GridBagConstraints.HORIZONTAL;
		gbc_URLimagen.insets = new Insets(0, 0, 5, 5);
		gbc_URLimagen.gridx = 4;
		gbc_URLimagen.gridy = 6;
		contentPane.add(URLimagen, gbc_URLimagen);
		URLimagen.setColumns(10);

		foto = new JLabel("");
		foto.setIcon(new ImageIcon(Ventana_registro.class.getResource("/vista/imagenes/gente.png")));
		GridBagConstraints gbc_foto = new GridBagConstraints();
		gbc_foto.insets = new Insets(0, 0, 5, 5);
		gbc_foto.gridx = 4;
		gbc_foto.gridy = 7;
		contentPane.add(foto, gbc_foto);

		panelBotones = new JPanel();
		panelBotones.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panelBotones = new GridBagConstraints();
		gbc_panelBotones.insets = new Insets(0, 0, 5, 5);
		gbc_panelBotones.fill = GridBagConstraints.BOTH;
		gbc_panelBotones.gridx = 2;
		gbc_panelBotones.gridy = 8;
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

	}

}
