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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import um.tds.Controlador.Controlador;
import um.tds.Modelado.ContactoIndividual;

public class VentanaModificarContacto implements ActionListener {

	private JFrame frmAppchat;
	private ContactoIndividual contacto;
	private JPanel panel;
	private JLabel lblModificar, lblNombre, lblTelefono, lblTelf, lblImagen, lblError;
	private JButton btnAtras, btnAceptar, btnRestaurar;
	private JTextField textFieldNombre;
	private GridBagConstraints gbc_lblImagen;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public VentanaModificarContacto(ContactoIndividual contacto, Dimension tam, Point ubi) {
		this.contacto = contacto;
		initialize(tam, ubi);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Dimension tam, Point ubi) {
		frmAppchat = new JFrame();
		frmAppchat.setBackground(new Color(255, 244, 244));
		frmAppchat.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaLogin.class.getResource("/imagenes/gatoVentana2_2048.png")));
		frmAppchat.setTitle("AppChat");
		frmAppchat.setBounds(300, 300, 907, 680);
		frmAppchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setBackground(new Color(255, 244, 244));
		frmAppchat.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblModificar = new JLabel("Modificar nombre de contacto:");
		lblModificar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblModificar = new GridBagConstraints();
		gbc_lblModificar.gridwidth = 4;
		gbc_lblModificar.insets = new Insets(0, 0, 5, 5);
		gbc_lblModificar.gridx = 2;
		gbc_lblModificar.gridy = 2;
		panel.add(lblModificar, gbc_lblModificar);

		btnAtras = new JButton("");
		btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtras.setPreferredSize(new Dimension(32, 32));
		btnAtras.setBackground(new Color(255, 255, 255));
		btnAtras.setIcon(
				new ImageIcon(VentanaModificarContacto.class.getResource("/imagenes/mod_boton-de-retroceso.png")));
		btnAtras.setSize(new Dimension(32, 32));
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAtras.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtras.gridx = 0;
		gbc_btnAtras.gridy = 0;
		panel.add(btnAtras, gbc_btnAtras);

		lblImagen = new JLabel("");
		lblImagen.setMinimumSize(new Dimension(10, 10));
		lblImagen.setSize(250, 250);

		try {
			BufferedImage image = ImageIO.read(getClass().getResource("/imagenes/gato_perfil.png"));
			lblImagen.setIcon(new ImageIcon(image));
			ImageInJLabel.resizeImage(lblImagen, image);
		} catch (IOException e) {
			e.printStackTrace();
		}

		gbc_lblImagen = new GridBagConstraints();
		gbc_lblImagen.gridheight = 5;
		gbc_lblImagen.insets = new Insets(0, 0, 5, 5);
		gbc_lblImagen.gridx = 1;
		gbc_lblImagen.gridy = 3;
		panel.add(lblImagen, gbc_lblImagen);

		lblNombre = new JLabel("<html><span style='color:red;'>*</span>Nombre:</html>");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 3;
		gbc_lblNombre.gridy = 4;
		panel.add(lblNombre, gbc_lblNombre);

		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridwidth = 2;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.gridx = 4;
		gbc_textFieldNombre.gridy = 4;
		panel.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		textFieldNombre.setText(contacto.getNombre());

		lblTelefono = new JLabel("<html><span style='color:red;'>*</span>Teléfono:</html>");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 3;
		gbc_lblTelefono.gridy = 6;
		panel.add(lblTelefono, gbc_lblTelefono);

		lblTelf = new JLabel(contacto.getUsuario().getNumTelefono());
		lblTelf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTelf = new GridBagConstraints();
		gbc_lblTelf.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTelf.gridwidth = 2;
		gbc_lblTelf.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelf.gridx = 4;
		gbc_lblTelf.gridy = 6;
		panel.add(lblTelf, gbc_lblTelf);

		btnRestaurar = new JButton("Restaurar");
		btnRestaurar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRestaurar.setBackground(new Color(255, 255, 255));
		btnRestaurar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRestaurar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_btnRestaurar = new GridBagConstraints();
		gbc_btnRestaurar.fill = GridBagConstraints.BOTH;
		gbc_btnRestaurar.insets = new Insets(0, 0, 5, 5);
		gbc_btnRestaurar.gridx = 3;
		gbc_btnRestaurar.gridy = 8;
		panel.add(btnRestaurar, gbc_btnRestaurar);

		lblError = new JLabel("El campo nombre no puede estar vacío");
		lblError.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.insets = new Insets(0, 0, 5, 5);
		gbc_lblError.gridx = 4;
		gbc_lblError.gridy = 8;
		panel.add(lblError, gbc_lblError);
		lblError.setVisible(false);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(255, 255, 255));
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAceptar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 5;
		gbc_btnAceptar.gridy = 8;
		panel.add(btnAceptar, gbc_btnAceptar);

		btnAceptar.addActionListener(this);
		btnAtras.addActionListener(this);
		btnRestaurar.addActionListener(this);

		frmAppchat.setSize(tam);
		frmAppchat.setLocation(ubi);
		frmAppchat.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			if (textFieldNombre.getText().equals("")) {
				lblError.setVisible(true);
			} else {
				if (textFieldNombre.getText().equals(contacto.getNombre())) {
					lblError.setText("El nombre indicado es el nombre actual de este contacto");
					lblError.setVisible(true);
				} else {
					if (Controlador.getUnicaInstancia().modificarContacto(contacto, textFieldNombre.getText())) {
						JOptionPane.showMessageDialog(frmAppchat, "Nombre de contacto modificado correctamente",
								"Enhorabuena", JOptionPane.PLAIN_MESSAGE);
						new VentanaContactos(frmAppchat.getSize(), frmAppchat.getLocation());
						frmAppchat.dispose();
					} else {
						lblError.setText("El nombre de contacto ya está utilizado");
						lblError.setVisible(true);
						textFieldNombre.setText("");
					}
				}
			}
		}
		if (e.getSource() == btnAtras) {
			new VentanaContactos(frmAppchat.getSize(), frmAppchat.getLocation());
			frmAppchat.dispose();
		}
		if (e.getSource() == btnRestaurar) {
			textFieldNombre.setText(contacto.getNombre());
			lblError.setVisible(false);
		}
	}
}
