package um.tds.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import um.tds.Controlador.Controlador;

public class VentanaPago implements ActionListener {

	private JFrame frmAppchat;
	private JButton btnCancelar, btnAceptar;
	private String ventanaAnterior;
	private JLabel lblIntroduzca, lblNumCuenta, lblFechaCaducidad, lblCvv, lblError;
	private JTextField textNumeroCuenta, textFechaCaducidad, textCvv;

	public VentanaPago(Dimension tam, Point ubi, String ventanaAnterior) {
		initialize(tam, ubi, ventanaAnterior);
	}

	private void initialize(Dimension tam, Point ubi, String ventanaAnterior) {
		this.ventanaAnterior = ventanaAnterior;

		frmAppchat = new JFrame();
		frmAppchat.setBackground(new Color(255, 244, 244));
		frmAppchat.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaLogin.class.getResource("/imagenes/gatoVentana2_2048.png")));
		frmAppchat.setTitle("AppChat");
		frmAppchat.setBounds(300, 300, 907, 680);
		frmAppchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 244, 244));
		frmAppchat.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblIntroduzca = new JLabel("Introduzca los datos de su targeta");
		lblIntroduzca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblIntroduzca = new GridBagConstraints();
		gbc_lblIntroduzca.gridwidth = 6;
		gbc_lblIntroduzca.insets = new Insets(0, 0, 5, 5);
		gbc_lblIntroduzca.gridx = 1;
		gbc_lblIntroduzca.gridy = 1;
		panel.add(lblIntroduzca, gbc_lblIntroduzca);

		lblNumCuenta = new JLabel("<html><span style='color:red;'>*</span>Número de cuenta:</html>");
		lblNumCuenta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNumCuenta = new GridBagConstraints();
		gbc_lblNumCuenta.anchor = GridBagConstraints.EAST;
		gbc_lblNumCuenta.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumCuenta.gridx = 1;
		gbc_lblNumCuenta.gridy = 3;
		panel.add(lblNumCuenta, gbc_lblNumCuenta);

		textNumeroCuenta = new JTextField();
		GridBagConstraints gbc_textNumeroCuenta = new GridBagConstraints();
		gbc_textNumeroCuenta.gridwidth = 5;
		gbc_textNumeroCuenta.insets = new Insets(0, 0, 5, 5);
		gbc_textNumeroCuenta.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNumeroCuenta.gridx = 2;
		gbc_textNumeroCuenta.gridy = 3;
		panel.add(textNumeroCuenta, gbc_textNumeroCuenta);
		textNumeroCuenta.setColumns(10);

		lblFechaCaducidad = new JLabel("<html><span style='color:red;'>*</span>Fecha de caducidad:</html>");
		lblFechaCaducidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFechaCaducidad = new GridBagConstraints();
		gbc_lblFechaCaducidad.anchor = GridBagConstraints.EAST;
		gbc_lblFechaCaducidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaCaducidad.gridx = 1;
		gbc_lblFechaCaducidad.gridy = 5;
		panel.add(lblFechaCaducidad, gbc_lblFechaCaducidad);

		textFechaCaducidad = new JTextField();
		GridBagConstraints gbc_textFechaCaducidad = new GridBagConstraints();
		gbc_textFechaCaducidad.gridwidth = 2;
		gbc_textFechaCaducidad.insets = new Insets(0, 0, 5, 5);
		gbc_textFechaCaducidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFechaCaducidad.gridx = 2;
		gbc_textFechaCaducidad.gridy = 5;
		panel.add(textFechaCaducidad, gbc_textFechaCaducidad);
		textFechaCaducidad.setColumns(10);

		lblCvv = new JLabel("<html><span style='color:red;'>*</span>CVV:</html>");
		lblCvv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCvv = new GridBagConstraints();
		gbc_lblCvv.anchor = GridBagConstraints.EAST;
		gbc_lblCvv.insets = new Insets(0, 0, 5, 5);
		gbc_lblCvv.gridx = 5;
		gbc_lblCvv.gridy = 5;
		panel.add(lblCvv, gbc_lblCvv);

		textCvv = new JTextField();
		GridBagConstraints gbc_textCvv = new GridBagConstraints();
		gbc_textCvv.insets = new Insets(0, 0, 5, 5);
		gbc_textCvv.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCvv.gridx = 6;
		gbc_textCvv.gridy = 5;
		panel.add(textCvv, gbc_textCvv);
		textCvv.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAceptar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnAceptar.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.BOTH;
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 7;
		panel.add(btnAceptar, gbc_btnAceptar);

		lblError = new JLabel("Se deben rellenar todos los campos marcados con *");
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblError.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.gridwidth = 4;
		gbc_lblError.insets = new Insets(0, 0, 5, 5);
		gbc_lblError.gridx = 2;
		gbc_lblError.gridy = 7;
		panel.add(lblError, gbc_lblError);
		lblError.setVisible(false);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.BOTH;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 6;
		gbc_btnCancelar.gridy = 7;
		panel.add(btnCancelar, gbc_btnCancelar);

		btnCancelar.addActionListener(this);
		btnAceptar.addActionListener(this);

		frmAppchat.setVisible(true);
		frmAppchat.setSize(tam);
		frmAppchat.setLocation(ubi);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			new VentanaOferta(frmAppchat.getSize(), frmAppchat.getLocation(), ventanaAnterior);
			frmAppchat.dispose();
		}
		if (e.getSource() == btnAceptar) {
			if (textNumeroCuenta.getText().equals("") || textFechaCaducidad.getText().equals("")
					|| textCvv.getText().equals("")) {
				lblError.setText("Se deben rellenar todos los campos marcados con *");
				lblError.setVisible(true);
			} else {
				if (esIbanValido(textNumeroCuenta.getText())) {
					if (esCvvValido(textCvv.getText())) {
						if (esFechaValida(textFechaCaducidad.getText())) {
							if (fechaNoCaducada(textFechaCaducidad.getText())) {
								JOptionPane.showMessageDialog(frmAppchat, "Pago realizado correctamente",
										"Enhorabuena", JOptionPane.PLAIN_MESSAGE);
								Controlador.getUnicaInstancia().setPremium(true);
								new VentanaMain(frmAppchat.getSize(), frmAppchat.getLocation(),null);
								frmAppchat.dispose();
							} else {
								textFechaCaducidad.setText("");
								lblError.setText("La tarjeta está caducada");
								lblError.setVisible(true);
							}
						} else {
							textFechaCaducidad.setText("");
							lblError.setText("La fecha de caduciad debe tener el formato MM/YY");
							lblError.setVisible(true);
						}
					} else {
						textCvv.setText("");
						lblError.setText("El CVV debe tener tres dígitos");
						lblError.setVisible(true);
					}
				} else {
					textNumeroCuenta.setText("");
					lblError.setText("El número de cuenta debe tener el formato XXXX XXXX XXXX XXXX");
					lblError.setVisible(true);
				}
			}
		}
	}

	public static boolean esIbanValido(String iban) {
		return Pattern.matches("(\\w{4} ){3}\\w{4}", iban); // Formato XXXX XXXX XXXX XXXX
	}

	public static boolean esFechaValida(String fecha) {
		return fecha.matches("^(0[1-9]|1[0-2])/\\d{2}$");// Formato MM/YY
	}

	public static boolean esCvvValido(String cvv) {
		return Pattern.matches("\\d{3}", cvv);
	}

	public boolean fechaNoCaducada(String fecha) {
		try {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
	        YearMonth ym = YearMonth.parse(fecha, formatter);
	        YearMonth ahora = YearMonth.now();
	        return !ym.isBefore(ahora);  // la fecha no puede ser anterior al mes actual
	    } catch (DateTimeParseException e) {
	        return false;
	    }
	}
}
