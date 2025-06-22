package um.tds.Ventanas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import um.tds.Controlador.Controlador;

public class VentanaOferta implements ActionListener {
	private JFrame frmAppchat;
	private JButton btnAtras;
	private JPanel panel;
	private String ventanaAnterior;
	private JLabel lblHaztePremium, lblPrecio, lblPrecioDescuento, lblBeneficios;
	private JButton btnPremium;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public VentanaOferta(Dimension tam, Point ubi, String ventanaAnterior) {
		initialize(tam, ubi, ventanaAnterior);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Dimension tam, Point ubi, String ventanaAnterior) {
		this.ventanaAnterior = ventanaAnterior;

		frmAppchat = new JFrame();
		frmAppchat.getContentPane().setBackground(new Color(255, 244, 244));
		frmAppchat.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		panel = new JPanel();
		panel.setBackground(new Color(255, 244, 244));
		frmAppchat.getContentPane().add(panel);
		frmAppchat.setBackground(new Color(255, 244, 244));
		frmAppchat.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaLogin.class.getResource("/imagenes/gatoVentana2_2048.png")));
		frmAppchat.setTitle("AppChat");
		frmAppchat.setBounds(300, 300, 612, 373);
		frmAppchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 50, 0, 0, 0, 50, 0 };
		gbl_panel.rowHeights = new int[] { 32, 0, 0, 0, 0, 0, 0, 0, 0, 40, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		btnAtras = new JButton("");
		btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtras.setPreferredSize(new Dimension(32, 32));
		btnAtras.setBackground(new Color(255, 255, 255));
		btnAtras.setIcon(new ImageIcon(VentanaContactos.class.getResource("/imagenes/mod_boton-de-retroceso.png")));
		btnAtras.setSize(new Dimension(32, 32));
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtras.gridx = 0;
		gbc_btnAtras.gridy = 0;
		panel.add(btnAtras, gbc_btnAtras);

		lblHaztePremium = new JLabel("HÁGASE PREMIUM");
		lblHaztePremium.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblHaztePremium = new GridBagConstraints();
		gbc_lblHaztePremium.insets = new Insets(0, 0, 5, 5);
		gbc_lblHaztePremium.gridx = 2;
		gbc_lblHaztePremium.gridy = 2;
		panel.add(lblHaztePremium, gbc_lblHaztePremium);

		lblPrecio = new JLabel();
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 2;
		gbc_lblPrecio.gridy = 4;
		panel.add(lblPrecio, gbc_lblPrecio);
		escribirPrecio(lblPrecio, Controlador.getUnicaInstancia().getPrecioPremium());

		lblPrecioDescuento = new JLabel("New label");
		lblPrecioDescuento.setFont(new Font("Tahoma", Font.PLAIN, 24));
		escribirPrecioOferta(lblPrecioDescuento, Controlador.getUnicaInstancia().getPrecioFinal());
		GridBagConstraints gbc_lblPrecioDescuento = new GridBagConstraints();
		gbc_lblPrecioDescuento.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioDescuento.gridx = 2;
		gbc_lblPrecioDescuento.gridy = 5;
		panel.add(lblPrecioDescuento, gbc_lblPrecioDescuento);

		lblBeneficios = new JLabel("¡ Exporte sus conversaciones en formato pdf !");
		lblBeneficios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblBeneficios = new GridBagConstraints();
		gbc_lblBeneficios.insets = new Insets(0, 0, 5, 5);
		gbc_lblBeneficios.gridx = 2;
		gbc_lblBeneficios.gridy = 7;
		panel.add(lblBeneficios, gbc_lblBeneficios);

		btnPremium = new JButton("PREMIUM");
		btnPremium.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPremium.setBackground(new Color(255, 255, 255));
		btnPremium.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPremium.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnPremium.setIcon(new ImageIcon(VentanaContactos.class.getResource("/imagenes/orejas_no_premium.png")));
		GridBagConstraints gbc_btnPremium = new GridBagConstraints();
		gbc_btnPremium.fill = GridBagConstraints.BOTH;
		gbc_btnPremium.insets = new Insets(0, 0, 5, 5);
		gbc_btnPremium.gridx = 2;
		gbc_btnPremium.gridy = 9;
		panel.add(btnPremium, gbc_btnPremium);

		btnAtras.addActionListener(this);
		btnPremium.addActionListener(this);

		frmAppchat.setSize(tam);
		frmAppchat.setLocation(ubi);
		frmAppchat.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAtras) {
			if (ventanaAnterior.equals("VentanaMain")) {
				new VentanaMain(frmAppchat.getSize(), frmAppchat.getLocation(),null);
				frmAppchat.dispose();
			} else if (ventanaAnterior.equals("VentanaContactos")) {
				new VentanaContactos(frmAppchat.getSize(), frmAppchat.getLocation());
				frmAppchat.dispose();
			} else if (ventanaAnterior.equals("VentanaPerfil")) {
				new VentanaPerfil(frmAppchat.getSize(), frmAppchat.getLocation(), "");
				frmAppchat.dispose();
			}
		}
		if (e.getSource() == btnPremium) {
			new VentanaPago(frmAppchat.getSize(), frmAppchat.getLocation(), ventanaAnterior);
			frmAppchat.dispose();
		}

	}

	public static void escribirPrecio(JLabel label, double original) {
		String texto = String.format("<html><span style='color: gray; text-decoration: line-through;'>%.2f€</span> ",
				original);
		label.setText(texto);
	}

	public static void escribirPrecioOferta(JLabel label, double descuento) {
		String texto = String.format("<html><span style='color: green; font-weight: bold;'>%.2f€</span></html>",
				descuento);
		label.setText(texto);
	}
}
