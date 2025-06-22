package um.tds.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import um.tds.Controlador.Controlador;

public class VentanaLogin implements ActionListener {

	private JFrame frmAppchat;
	private JPasswordField password;
	private JTextField textTelf;
	private JPanel panelCentro, panel;
	private GridBagLayout gbl_panelCentro;
	private JButton btnAcceder, btnNoRecuerdo, btnCancelar;
	private JLabel titulo, imagen, lblTelefono, lblContrasea, lblError;
	private GridBagConstraints gbc_lblTelefono, gbc_textTelf, gbc_btnAcceder, gbc_lblContrasea, gbc_password,
			gbc_btnNoRecuerdo, gbc_titulo, gbc_imagen, gbc_btnCancelar, gbc_lblError;

	public VentanaLogin(Dimension tam, Point ubi) {
		initialize(tam, ubi);
	}

	private void initialize(Dimension tam, Point ubi) {
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
		gbl_panelCentro.rowHeights = new int[] { 0, 20, 0, 0, 0, 0, 0, 0, 50, 0 };
		gbl_panelCentro.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelCentro.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
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

		try {
			BufferedImage image = ImageIO.read(getClass().getResource("/imagenes/gato_enter.png"));
			imagen.setIcon(new ImageIcon(image));
			ImageInJLabel.resizeImage(imagen, image);
		} catch (IOException e) {
			e.printStackTrace();
		}

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

		lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		gbc_lblError = new GridBagConstraints();
		gbc_lblError.gridwidth = 3;
		gbc_lblError.insets = new Insets(0, 0, 5, 5);
		gbc_lblError.gridx = 1;
		gbc_lblError.gridy = 6;
		panelCentro.add(lblError, gbc_lblError);
		lblError.setVisible(false);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frmAppchat.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frmAppchat.getHeight()) / 2);
		frmAppchat.setLocation(x, y);
		btnAcceder.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnNoRecuerdo.addActionListener(this);

		frmAppchat.setVisible(true);
		frmAppchat.setSize(tam);
		frmAppchat.setLocation(ubi);
	}

	public static boolean esTelfValido(String telf) {
		return Pattern.matches("\\d{9}", telf);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAcceder) {
			if (lblError.isVisible()) {
				lblError.setVisible(false);
			}

			if (textTelf.getText().equals("") || password.getPassword().length == 0) {
				lblError.setText("Se deben rellenar todos los campos");
				lblError.setVisible(true);
			} else {
				if (esTelfValido(textTelf.getText())) {
					if (Controlador.getUnicaInstancia().iniciarSesion(textTelf.getText(), password.getPassword())) {
						new VentanaMain(frmAppchat.getSize(), frmAppchat.getLocation(), null);
						frmAppchat.dispose();
					} else {
						textTelf.setText("");
						password.setText("");
						lblError.setText("Credenciales inválidos");
						lblError.setVisible(true);
					}
				} else {
					textTelf.setText("");
					lblError.setText("El teléfono no existe");
					lblError.setVisible(true);
				}
			}

		} else if (e.getSource() == btnCancelar) {
			new VentanaInicio(frmAppchat.getSize(), frmAppchat.getLocation());
			frmAppchat.dispose();
			return;
		}
	}
}
