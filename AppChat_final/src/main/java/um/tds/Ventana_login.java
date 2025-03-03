package um.tds;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.Box;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class Ventana_login extends JFrame implements ActionListener {

	private JFrame frmAppchat;
	private JPasswordField passwordField;
	private JTextField textField;
	private JPanel panelCentro, panel;
	private GridBagLayout gbl_panelCentro;
	private JButton btnAcceder, btnNoRecuerdo;
	private JLabel lblTelefono, lblContrasea, logo;
	private GridBagConstraints gbc_lblTelefono, gbc_textField, gbc_btnAcceder, gbc_lblContrasea, gbc_passwordField, gbc_btnNoRecuerdo;
	private JButton btnAtras;
	private JLabel lblNewLabel;
	private Ventana_inicio v;

	public void mostrarLogin() {
		setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public Ventana_login(Ventana_inicio v) {
		initialize(v);
		frmAppchat.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Ventana_inicio v) {
		this.v = v;
		frmAppchat = new JFrame();
		frmAppchat.getContentPane().setBackground(new Color(255, 244, 244));
		frmAppchat.setBackground(new Color(255, 255, 255));
		frmAppchat.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Ventana_login.class.getResource("/imagenes/gatoVentana2_2048.png")));
		frmAppchat.setTitle("AppChat");
		frmAppchat.setBounds(300, 300, 906, 499);
		frmAppchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelCentro = new JPanel();
		panelCentro.setMaximumSize(new Dimension(100, 50));
		panelCentro.setBackground(new Color(255, 244, 244));
		panelCentro.setBorder(null);
		gbl_panelCentro = new GridBagLayout();
		gbl_panelCentro.columnWidths = new int[] { 20, 0, 259, 96, 20, 0 };
		gbl_panelCentro.rowHeights = new int[] { 0, 20, 0, 0, 0, 0, 20, 0 };
		gbl_panelCentro.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelCentro.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panelCentro.setLayout(gbl_panelCentro);

		btnAcceder = new JButton("Acceder");
		btnAcceder.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnAcceder.setBackground(new Color(255, 255, 255));
		btnAcceder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
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
		panelCentro.add(btnAtras, gbc_btnAtras);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIconTextGap(0);
		lblNewLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setSize(new Dimension(140, 80));
		lblNewLabel.setIcon(new ImageIcon(Ventana_login.class.getResource("/imagenes/gato_enter.png")));
		ImageInJLabel.resizeImage(lblNewLabel, Ventana_Perfil.class.getResource("/imagenes/gato_enter.png"));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 0);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 1;
		panelCentro.add(lblNewLabel, gbc_lblNewLabel);

		lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 2;
		panelCentro.add(lblTelefono, gbc_lblTelefono);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(20);
		gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		panelCentro.add(textField, gbc_textField);
		btnAcceder.setMaximumSize(new Dimension(100, 50));
		gbc_btnAcceder = new GridBagConstraints();
		gbc_btnAcceder.gridheight = 3;
		gbc_btnAcceder.fill = GridBagConstraints.BOTH;
		gbc_btnAcceder.insets = new Insets(0, 0, 5, 5);
		gbc_btnAcceder.gridx = 3;
		gbc_btnAcceder.gridy = 2;
		panelCentro.add(btnAcceder, gbc_btnAcceder);

		lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 4;
		panelCentro.add(lblContrasea, gbc_lblContrasea);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setColumns(20);
		gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 4;
		panelCentro.add(passwordField, gbc_passwordField);

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

		logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		frmAppchat.getContentPane().add(logo, BorderLayout.NORTH);

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
