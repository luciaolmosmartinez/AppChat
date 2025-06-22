package um.tds.Ventanas;

import java.awt.BorderLayout;
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
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class VentanaInicio implements ActionListener {

	private JFrame frmAppchat;
	private JPanel panelSuperior, panelCentral;
	private JLabel titulo, lblNewLabel;
	private JButton btnInicioSesion, btnRegistro;

	public VentanaInicio(Dimension tam, Point ubi) {
		initialize(tam, ubi);
	}

	private void initialize(Dimension tam, Point ubi) {
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

		try {
			BufferedImage image = ImageIO.read(getClass().getResource("/imagenes/gatoVentana2_2048.png"));
			lblNewLabel.setIcon(new ImageIcon(image));
			ImageInJLabel.resizeImage(lblNewLabel, image);
		} catch (IOException e) {
			e.printStackTrace();
		}

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

		frmAppchat.setVisible(true);
		frmAppchat.setSize(tam);
		frmAppchat.setLocation(ubi);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInicioSesion) {
			new VentanaLogin(frmAppchat.getSize(), frmAppchat.getLocation());
			frmAppchat.dispose();
			return;
		}

		if (e.getSource() == btnRegistro) {
			new VentanaRegistro(frmAppchat.getSize(), frmAppchat.getLocation());
			frmAppchat.dispose();
			return;
		}
		return;
	}

}
