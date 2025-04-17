package um.tds.Ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import um.tds.Modelado.AppChat;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.WindowEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.event.WindowAdapter;

@SuppressWarnings("serial")
public class VentanaLogin extends JFrame implements ActionListener {

	private JFrame frmAppchat;
	private JPasswordField password;
	private JTextField textTelf;
	private JPanel panelCentro, panel;
	private GridBagLayout gbl_panelCentro;
	private JButton btnAcceder, btnNoRecuerdo;
	private JLabel titulo, imagen, lblTelefono, lblContrasea, lblErrorVacio, lblErrorMal, lblErrorTelf;
	private GridBagConstraints gbc_lblTelefono, gbc_textTelf, gbc_btnAcceder, gbc_lblContrasea, gbc_password,
			gbc_btnNoRecuerdo, gbc_titulo, gbc_imagen, gbc_btnCancelar, gbc_lblErrorVacio, gbc_lblErrorMal,
			gbc_lblErrorTelf;
	private JButton btnCancelar;
	private AppChat control;

	public void mostrarLogin() {
		frmAppchat.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public VentanaLogin(AppChat controlador) {
		control = controlador;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAppchat = new JFrame();
		frmAppchat.getContentPane().setBackground(new Color(255, 244, 244));
		frmAppchat.setBackground(new Color(255, 255, 255));
		frmAppchat.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaLogin.class.getResource("/imagenes/gatoVentana2_2048.png")));
		frmAppchat.setTitle("AppChat");
		frmAppchat.setBounds(300, 300, 906, 499);
		frmAppchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelCentro = new JPanel();
		panelCentro.setMaximumSize(new Dimension(100, 50));
		panelCentro.setBackground(new Color(255, 244, 244));
		panelCentro.setBorder(null);
		gbl_panelCentro = new GridBagLayout();
		gbl_panelCentro.columnWidths = new int[] { 50, 150, 259, 96, 99, 150, 50, 0 };
		gbl_panelCentro.rowHeights = new int[] { 0, 20, 0, 0, 0, 0, 0, 0, 0, 50, 0 };
		gbl_panelCentro.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelCentro.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		panelCentro.setLayout(gbl_panelCentro);

		btnAcceder = new JButton("Acceder");
		btnAcceder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAcceder.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnAcceder.setBackground(new Color(255, 255, 255));
		btnAcceder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAcceder.setMaximumSize(new Dimension(100, 50));
		gbc_btnAcceder = new GridBagConstraints();
		gbc_btnAcceder.gridwidth = 2;
		gbc_btnAcceder.gridheight = 3;
		gbc_btnAcceder.fill = GridBagConstraints.BOTH;
		gbc_btnAcceder.insets = new Insets(0, 0, 5, 5);
		gbc_btnAcceder.gridx = 3;
		gbc_btnAcceder.gridy = 2;
		panelCentro.add(btnAcceder, gbc_btnAcceder);

		titulo = new JLabel("AppChat");
		titulo.setForeground(new Color(254, 127, 154));
		titulo.setFont(new Font("Brush Script MT", Font.BOLD, 75));
		gbc_titulo = new GridBagConstraints();
		gbc_titulo.gridwidth = 3;
		gbc_titulo.anchor = GridBagConstraints.NORTHEAST;
		gbc_titulo.insets = new Insets(0, 0, 5, 0);
		gbc_titulo.gridx = 4;
		gbc_titulo.gridy = 0;
		panelCentro.add(titulo, gbc_titulo);

		imagen = new JLabel("");
		imagen.setIconTextGap(0);
		imagen.setVerticalTextPosition(SwingConstants.BOTTOM);
		imagen.setVerticalAlignment(SwingConstants.BOTTOM);
		imagen.setSize(new Dimension(140, 80));
		imagen.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/gato_enter.png")));
		ImageInJLabel.resizeImage(imagen, VentanaPerfil.class.getResource("/imagenes/gato_enter.png"));
		gbc_imagen = new GridBagConstraints();
		gbc_imagen.gridwidth = 2;
		gbc_imagen.anchor = GridBagConstraints.SOUTH;
		gbc_imagen.insets = new Insets(0, 0, 5, 5);
		gbc_imagen.gridx = 3;
		gbc_imagen.gridy = 1;
		panelCentro.add(imagen, gbc_imagen);

		lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 2;
		panelCentro.add(lblTelefono, gbc_lblTelefono);

		textTelf = new JTextField();
		textTelf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textTelf.setColumns(20);
		gbc_textTelf = new GridBagConstraints();
		gbc_textTelf.insets = new Insets(0, 0, 5, 5);
		gbc_textTelf.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTelf.gridx = 2;
		gbc_textTelf.gridy = 2;
		panelCentro.add(textTelf, gbc_textTelf);

		lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 4;
		panelCentro.add(lblContrasea, gbc_lblContrasea);

		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		password.setColumns(20);
		gbc_password = new GridBagConstraints();
		gbc_password.fill = GridBagConstraints.HORIZONTAL;
		gbc_password.insets = new Insets(0, 0, 5, 5);
		gbc_password.gridx = 2;
		gbc_password.gridy = 4;
		panelCentro.add(password, gbc_password);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		frmAppchat.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(panelCentro);

		btnNoRecuerdo = new JButton("No recuerdo la contraseña");
		btnNoRecuerdo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNoRecuerdo.setBorder(null);
		btnNoRecuerdo.setBackground(new Color(255, 244, 244));
		btnNoRecuerdo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gbc_btnNoRecuerdo = new GridBagConstraints();
		gbc_btnNoRecuerdo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNoRecuerdo.insets = new Insets(0, 0, 5, 5);
		gbc_btnNoRecuerdo.gridx = 2;
		gbc_btnNoRecuerdo.gridy = 5;
		panelCentro.add(btnNoRecuerdo, gbc_btnNoRecuerdo);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setMaximumSize(new Dimension(100, 50));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnCancelar.setBackground(new Color(255, 255, 255));
		gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridwidth = 2;
		gbc_btnCancelar.fill = GridBagConstraints.BOTH;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 5;
		panelCentro.add(btnCancelar, gbc_btnCancelar);

		lblErrorVacio = new JLabel("Se deben rellenar todos los campos");
		lblErrorVacio.setForeground(new Color(255, 0, 0));
		gbc_lblErrorVacio = new GridBagConstraints();
		gbc_lblErrorVacio.gridwidth = 3;
		gbc_lblErrorVacio.insets = new Insets(0, 0, 5, 5);
		gbc_lblErrorVacio.gridx = 1;
		gbc_lblErrorVacio.gridy = 6;
		panelCentro.add(lblErrorVacio, gbc_lblErrorVacio);
		lblErrorVacio.setVisible(false);

		lblErrorTelf = new JLabel("El teléfono no existe");
		lblErrorTelf.setForeground(new Color(255, 0, 0));
		gbc_lblErrorTelf = new GridBagConstraints();
		gbc_lblErrorTelf.gridwidth = 3;
		gbc_lblErrorTelf.insets = new Insets(0, 0, 5, 5);
		gbc_lblErrorTelf.gridx = 1;
		gbc_lblErrorTelf.gridy = 7;
		panelCentro.add(lblErrorTelf, gbc_lblErrorTelf);
		lblErrorTelf.setVisible(false);

		lblErrorMal = new JLabel("Credenciales inválidos");
		lblErrorMal.setForeground(new Color(255, 0, 0));
		gbc_lblErrorMal = new GridBagConstraints();
		gbc_lblErrorMal.gridwidth = 3;
		gbc_lblErrorMal.insets = new Insets(0, 0, 5, 5);
		gbc_lblErrorMal.gridx = 1;
		gbc_lblErrorMal.gridy = 8;
		panelCentro.add(lblErrorMal, gbc_lblErrorMal);
		lblErrorMal.setVisible(false);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frmAppchat.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frmAppchat.getHeight()) / 2);
		frmAppchat.setLocation(x, y);
		btnAcceder.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnNoRecuerdo.addActionListener(this);
	}

	public static boolean esTelfValido(String telf) {
		return Pattern.matches("\\d{9}", telf);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAcceder) {
			if (lblErrorMal.isVisible()) {
				lblErrorMal.setVisible(false);
			} else if (lblErrorVacio.isVisible()) {
				lblErrorVacio.setVisible(false);
			} else if (lblErrorTelf.isVisible()) {
				lblErrorTelf.setVisible(false);
			}

			if (textTelf.getText().equals("") || password.getPassword().length == 0) {
				lblErrorVacio.setVisible(true);
			} else {
				if (esTelfValido(textTelf.getText())) {
					if (control.iniciarSesion(textTelf.getText(), password.getPassword())) {
						VentanaMain main = new VentanaMain();
						main.setLocationRelativeTo(frmAppchat);
						frmAppchat.dispose();
						main.mostrarMain();
					} else {
						textTelf.setText("");
						password.setText("");
						lblErrorMal.setVisible(true);
					}
				} else {
					textTelf.setText("");
					lblErrorTelf.setVisible(true);
				}
			}

		} else if (e.getSource() == btnCancelar) {
			VentanaInicio inicio = new VentanaInicio(control);
			inicio.setLocationRelativeTo(frmAppchat);
			frmAppchat.dispose();
			inicio.mostrarInicio();
			return;
		} else if (e.getSource() == btnNoRecuerdo) {
			VentanaNoRecuerdo nR = new VentanaNoRecuerdo();
			frmAppchat.setEnabled(false);
			nR.mostrarNoRecuerdo();
			// ARREGLAR
			nR.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) { // Cambiar de windowClosed a windowClosing
					frmAppchat.setEnabled(true); // Vuelve a habilitar la ventana padre
					frmAppchat.toFront(); // La trae al frente por si queda detrás de otras
				}
			});
		}
	}
}
