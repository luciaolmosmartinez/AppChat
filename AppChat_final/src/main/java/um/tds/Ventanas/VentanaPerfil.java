package um.tds.Ventanas;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Point;
import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.ImageIcon;

public class VentanaPerfil implements ActionListener {

	private JFrame frame;
	private JTextField txtnombreDelPerfil, txtnmeroDeTelfono, txtemail, txtapellidos;
	private JMenuBar menuBar;
	private JMenuItem mntmNewMenuItem, mntmNewMenuItem_1, mntmNewMenuItem_2, mntmNewMenuItem_3;
	private JPanel panel;
	private GridBagLayout gbl_panel;
	private JLabel nombre, lblApellidos, icono, telefono, fecha, lblEmail, saludo, lblNewLabel;
	private GridBagConstraints gbc_nombre, gbc_txtnombreDelPerfil, gbc_btnimagenPremium, gbc_txtapellidos,
			gbc_lblApellidos, gbc_icono, gbc_telefono, gbc_txtnmeroDeTelfono, gbc_fecha, gbc_dateChooser, gbc_lblEmail,
			gbc_txtemail, gbc_btnNewButton, gbc_saludo, gbc_txtrsaludo, gbc_lblNewLabel, gbc_btnNewButton_1,
			gbc_btnNewButton_2;
	private JButton btnimagenPremium, btnNewButton, btnNewButton_1, btnNewButton_2;
	private JDateChooser dateChooser;
	private JTextArea txtrsaludo;

	public void mostrarPerfil(Dimension tam, Point ubi) {
		frame.setVisible(true);
		frame.setSize(tam);
		frame.setLocation(ubi);
	}

	/**
	 * Create the application.
	 */
	public VentanaPerfil() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1060, 667);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		mntmNewMenuItem = new JMenuItem("PREMIUM");
		menuBar.add(mntmNewMenuItem);

		mntmNewMenuItem_1 = new JMenuItem("Contacto");
		menuBar.add(mntmNewMenuItem_1);

		mntmNewMenuItem_2 = new JMenuItem("Mensajes");
		menuBar.add(mntmNewMenuItem_2);

		mntmNewMenuItem_3 = new JMenuItem("Perfil");
		menuBar.add(mntmNewMenuItem_3);

		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 137, 64, 104, 128, 146, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		nombre = new JLabel("Nombre:");
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_nombre = new GridBagConstraints();
		gbc_nombre.insets = new Insets(0, 0, 5, 5);
		gbc_nombre.anchor = GridBagConstraints.EAST;
		gbc_nombre.gridx = 2;
		gbc_nombre.gridy = 1;
		panel.add(nombre, gbc_nombre);

		txtnombreDelPerfil = new JTextField();
		txtnombreDelPerfil.setText("(Nombre)");
		gbc_txtnombreDelPerfil = new GridBagConstraints();
		gbc_txtnombreDelPerfil.gridwidth = 2;
		gbc_txtnombreDelPerfil.insets = new Insets(0, 0, 5, 5);
		gbc_txtnombreDelPerfil.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtnombreDelPerfil.gridx = 3;
		gbc_txtnombreDelPerfil.gridy = 1;
		panel.add(txtnombreDelPerfil, gbc_txtnombreDelPerfil);
		txtnombreDelPerfil.setColumns(10);

		btnimagenPremium = new JButton("(Imagen premium)");
		btnimagenPremium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		gbc_btnimagenPremium = new GridBagConstraints();
		gbc_btnimagenPremium.gridheight = 2;
		gbc_btnimagenPremium.insets = new Insets(0, 0, 5, 5);
		gbc_btnimagenPremium.gridx = 5;
		gbc_btnimagenPremium.gridy = 1;
		panel.add(btnimagenPremium, gbc_btnimagenPremium);

		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 2;
		gbc_lblApellidos.gridy = 2;
		panel.add(lblApellidos, gbc_lblApellidos);

		txtapellidos = new JTextField();
		txtapellidos.setText("(Apellidos)");
		txtapellidos.setColumns(10);
		gbc_txtapellidos = new GridBagConstraints();
		gbc_txtapellidos.gridwidth = 2;
		gbc_txtapellidos.insets = new Insets(0, 0, 5, 5);
		gbc_txtapellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtapellidos.gridx = 3;
		gbc_txtapellidos.gridy = 2;
		panel.add(txtapellidos, gbc_txtapellidos);

		icono = new JLabel("");
		icono.setAlignmentX(Component.CENTER_ALIGNMENT);
		icono.setSize(170, 170);
		icono.setIcon(new ImageIcon(VentanaPerfil.class.getResource("/imagenes/hombre_barba.png")));
		ImageInJLabel.resizeImage(icono, VentanaPerfil.class.getResource("/imagenes/hombre_barba.png"));
		icono.setPreferredSize(new Dimension(170, 170));
		icono.setMaximumSize(new Dimension(512, 512));
		gbc_icono = new GridBagConstraints();
		gbc_icono.gridheight = 5;
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
		gbc_telefono.gridy = 3;
		panel.add(telefono, gbc_telefono);

		txtnmeroDeTelfono = new JTextField();
		txtnmeroDeTelfono.setText("(Número de teléfono)");
		gbc_txtnmeroDeTelfono = new GridBagConstraints();
		gbc_txtnmeroDeTelfono.gridwidth = 2;
		gbc_txtnmeroDeTelfono.insets = new Insets(0, 0, 5, 5);
		gbc_txtnmeroDeTelfono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtnmeroDeTelfono.gridx = 3;
		gbc_txtnmeroDeTelfono.gridy = 3;
		panel.add(txtnmeroDeTelfono, gbc_txtnmeroDeTelfono);
		txtnmeroDeTelfono.setColumns(10);

		fecha = new JLabel("Fecha:");
		fecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_fecha = new GridBagConstraints();
		gbc_fecha.insets = new Insets(0, 0, 5, 5);
		gbc_fecha.anchor = GridBagConstraints.EAST;
		gbc_fecha.gridx = 2;
		gbc_fecha.gridy = 4;
		panel.add(fecha, gbc_fecha);

		dateChooser = new JDateChooser();
		dateChooser.setPreferredSize(new Dimension(80, 19));
		dateChooser.setMinimumSize(new Dimension(40, 19));
		dateChooser.getCalendarButton().setBackground(Color.WHITE);
		gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 3;
		gbc_dateChooser.gridy = 4;
		panel.add(dateChooser, gbc_dateChooser);

		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.gridx = 2;
		gbc_lblEmail.gridy = 6;
		panel.add(lblEmail, gbc_lblEmail);

		txtemail = new JTextField();
		txtemail.setText("(Email)");
		gbc_txtemail = new GridBagConstraints();
		gbc_txtemail.gridwidth = 2;
		gbc_txtemail.insets = new Insets(0, 0, 5, 5);
		gbc_txtemail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtemail.gridx = 3;
		gbc_txtemail.gridy = 6;
		panel.add(txtemail, gbc_txtemail);
		txtemail.setColumns(10);

		btnNewButton = new JButton("Cambiar contraseña");
		gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 8;
		panel.add(btnNewButton, gbc_btnNewButton);

		saludo = new JLabel("Saludo:");
		saludo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbc_saludo = new GridBagConstraints();
		gbc_saludo.insets = new Insets(0, 0, 5, 5);
		gbc_saludo.gridx = 2;
		gbc_saludo.gridy = 8;
		panel.add(saludo, gbc_saludo);

		txtrsaludo = new JTextArea();
		txtrsaludo.setText("(saludo)");
		gbc_txtrsaludo = new GridBagConstraints();
		gbc_txtrsaludo.gridheight = 2;
		gbc_txtrsaludo.gridwidth = 2;
		gbc_txtrsaludo.insets = new Insets(0, 0, 5, 5);
		gbc_txtrsaludo.fill = GridBagConstraints.BOTH;
		gbc_txtrsaludo.gridx = 3;
		gbc_txtrsaludo.gridy = 8;
		panel.add(txtrsaludo, gbc_txtrsaludo);

		lblNewLabel = new JLabel("Usuario desde: ");
		gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 11;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		btnNewButton_1 = new JButton("Cancelar");
		gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 11;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);

		btnNewButton_2 = new JButton("Aceptar");
		gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 5;
		gbc_btnNewButton_2.gridy = 11;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
	}

	public void actionPerformed(ActionEvent e) {

	}

}
