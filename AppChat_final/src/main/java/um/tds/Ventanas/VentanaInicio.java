package um.tds.Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.Cursor;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import um.tds.Controlador.Controlador;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Point;

public class VentanaInicio implements ActionListener {

	private JFrame frmAppchat;
	private JPanel panelSuperior, panelCentral;
	private JLabel titulo, lblNewLabel;
	private JButton btnInicioSesion, btnRegistro;

	public void mostrarInicio(Dimension tam, Point ubi) {
		frmAppchat.setVisible(true);
		frmAppchat.setSize(tam);
		frmAppchat.setLocation(ubi);
	}

	/**
	 * Create the application.
	 */
	public VentanaInicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAppchat = new JFrame();
		frmAppchat.setVisible(true);
		frmAppchat.setForeground(new Color(254, 127, 154));
		frmAppchat.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaInicio.class.getResource("/imagenes/gatoVentana2_2048.png")));
		frmAppchat.setTitle("AppChat");
		frmAppchat.setBackground(new Color(255, 255, 255));
		frmAppchat.getContentPane().setBackground(new Color(255, 255, 255));
		frmAppchat.setBounds(100, 100, 942, 680);
		frmAppchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frmAppchat.setAutoRequestFocus(true);

		panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(255, 244, 244));
		frmAppchat.getContentPane().add(panelSuperior, BorderLayout.NORTH);

		titulo = new JLabel("AppChat");
		titulo.setForeground(new Color(254, 127, 154));
		titulo.setFont(new Font("Brush Script MT", Font.BOLD, 75));
		panelSuperior.add(titulo);

		panelCentral = new JPanel();
		panelCentral.setBackground(new Color(255, 244, 244));
		frmAppchat.getContentPane().add(panelCentral, BorderLayout.CENTER);
		GridBagLayout gbl_panelCentral = new GridBagLayout();
		gbl_panelCentral.columnWidths = new int[] { 0, 93, 120, 120, 0, 255, 0, 0 };
		gbl_panelCentral.rowHeights = new int[] { 30, 0, 141, 75, 50, 0, 0 };
		gbl_panelCentral.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panelCentral.rowWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		panelCentral.setLayout(gbl_panelCentral);

		lblNewLabel = new JLabel("");
		lblNewLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblNewLabel.setPreferredSize(new Dimension(300, 300));
		lblNewLabel.setIconTextGap(0);
		lblNewLabel.setSize(300, 300);
		lblNewLabel.setIcon(new ImageIcon(VentanaInicio.class.getResource("/imagenes/gatoVentana2_2048.png")));
		ImageInJLabel.resizeImage(lblNewLabel, VentanaPerfil.class.getResource("/imagenes/gatoVentana2_2048.png"));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.gridheight = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 0);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		panelCentral.add(lblNewLabel, gbc_lblNewLabel);

		btnInicioSesion = new JButton("Iniciar Sesión");
		btnInicioSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInicioSesion.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnInicioSesion.setPreferredSize(new Dimension(180, 50));
		btnInicioSesion.setMinimumSize(new Dimension(140, 50));
		btnInicioSesion.setMaximumSize(new Dimension(150, 60));
		btnInicioSesion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnInicioSesion.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnInicioSesion = new GridBagConstraints();
		gbc_btnInicioSesion.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInicioSesion.insets = new Insets(0, 0, 5, 5);
		gbc_btnInicioSesion.gridx = 3;
		gbc_btnInicioSesion.gridy = 2;
		panelCentral.add(btnInicioSesion, gbc_btnInicioSesion);

		btnRegistro = new JButton("Registrarse");
		btnRegistro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistro.setBackground(new Color(255, 255, 255));
		btnRegistro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnRegistro.setMinimumSize(new Dimension(140, 50));
		btnRegistro.setMaximumSize(new Dimension(150, 60));
		btnRegistro.setPreferredSize(new Dimension(180, 50));
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_btnRegistro = new GridBagConstraints();
		gbc_btnRegistro.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegistro.gridx = 3;
		gbc_btnRegistro.gridy = 3;
		panelCentral.add(btnRegistro, gbc_btnRegistro);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frmAppchat.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frmAppchat.getHeight()) / 2);
		frmAppchat.setLocation(x, y);

		// Manejadores
		btnInicioSesion.addActionListener(this);
		btnRegistro.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInicioSesion) {
			VentanaLogin login = new VentanaLogin();
			login.setLocation(frmAppchat.getX(), frmAppchat.getY());
			frmAppchat.dispose();
			login.mostrarLogin(frmAppchat.getSize(),frmAppchat.getLocation());
			return;
		}

		if (e.getSource() == btnRegistro) {
			VentanaRegistro registro = new VentanaRegistro();
			//registro.setLocation(frmAppchat.getX(), frmAppchat.getY());
			frmAppchat.dispose();
			registro.mostrarRegistro(frmAppchat.getSize(),frmAppchat.getLocation());
			return;
		}
		return;
	}

}
