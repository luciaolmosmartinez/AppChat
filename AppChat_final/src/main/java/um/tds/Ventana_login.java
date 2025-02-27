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
import javax.swing.ButtonGroup;
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

@SuppressWarnings("serial")
public class Ventana_login extends JFrame implements ActionListener {

	private JFrame frmAppchat;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField passwordField;
	private JTextField textField;
	private JPanel panelCentro, panel;
	private GridBagLayout gbl_panelCentro;
	private JButton btnAcceder, btnNoRecuerdo;
	private JLabel lblTelefono, lblContrasea, logo;
	private GridBagConstraints gbc_lblTelefono, gbc_textField, gbc_btnAcceder, gbc_lblContrasea, gbc_passwordField, gbc_btnNoRecuerdo;

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
		frmAppchat = new JFrame();
		frmAppchat.setBackground(new Color(255, 255, 255));
		frmAppchat.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Ventana_login.class.getResource("/imagenes/gatoVentana2_2048.png")));
		frmAppchat.setTitle("AppChat");
		frmAppchat.setBounds(300, 300, 517, 334);
		frmAppchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelCentro = new JPanel();
		panelCentro.setMaximumSize(new Dimension(100, 50));
		panelCentro.setBackground(new Color(255, 255, 255));
		panelCentro.setBorder(null);
		gbl_panelCentro = new GridBagLayout();
		gbl_panelCentro.columnWidths = new int[] { 20, 0, 0, 20, 20, 0 };
		gbl_panelCentro.rowHeights = new int[] { 20, 0, 0, 0, 0, 20, 0 };
		gbl_panelCentro.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelCentro.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panelCentro.setLayout(gbl_panelCentro);

		btnAcceder = new JButton("Acceder");
		btnAcceder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 1;
		panelCentro.add(lblTelefono, gbc_lblTelefono);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(20);
		gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		panelCentro.add(textField, gbc_textField);
		btnAcceder.setMaximumSize(new Dimension(100, 50));
		gbc_btnAcceder = new GridBagConstraints();
		gbc_btnAcceder.gridheight = 3;
		gbc_btnAcceder.fill = GridBagConstraints.BOTH;
		gbc_btnAcceder.insets = new Insets(0, 0, 5, 5);
		gbc_btnAcceder.gridx = 3;
		gbc_btnAcceder.gridy = 1;
		panelCentro.add(btnAcceder, gbc_btnAcceder);

		lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 3;
		panelCentro.add(lblContrasea, gbc_lblContrasea);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setColumns(20);
		gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 3;
		panelCentro.add(passwordField, gbc_passwordField);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		frmAppchat.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(panelCentro);

		btnNoRecuerdo = new JButton("No recuerdo la contraseña");
		btnNoRecuerdo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gbc_btnNoRecuerdo = new GridBagConstraints();
		gbc_btnNoRecuerdo.insets = new Insets(0, 0, 5, 5);
		gbc_btnNoRecuerdo.gridx = 2;
		gbc_btnNoRecuerdo.gridy = 4;
		panelCentro.add(btnNoRecuerdo, gbc_btnNoRecuerdo);

		logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		frmAppchat.getContentPane().add(logo, BorderLayout.NORTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
