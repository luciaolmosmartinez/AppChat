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

public class Ventana_login {

	private JFrame frmAppchat;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_login window = new Ventana_login();
					window.frmAppchat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAppchat = new JFrame();
		frmAppchat.setBackground(new Color(255, 255, 255));
		frmAppchat.setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_login.class.getResource("/imagenes/gatoVentana2_2048.png")));
		frmAppchat.setTitle("AppChat");
		frmAppchat.setBounds(300, 300, 450, 261);
		frmAppchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(new Color(255, 255, 255));
		panelCentro.setBorder(null);
		GridBagLayout gbl_panelCentro = new GridBagLayout();
		gbl_panelCentro.columnWidths = new int[] { 20, 0, 0, 20, 0 };
		gbl_panelCentro.rowHeights = new int[] { 20, 0, 0, 0, 0, 20, 0 };
		gbl_panelCentro.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelCentro.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelCentro.setLayout(gbl_panelCentro);

		JLabel lblTelefono = new JLabel("Teléfono:");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 1;
		panelCentro.add(lblTelefono, gbc_lblTelefono);

		textField = new JTextField();
		textField.setColumns(20);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		panelCentro.add(textField, gbc_textField);
		
		JButton btnAcceder = new JButton("Acceder");
		GridBagConstraints gbc_btnAcceder = new GridBagConstraints();
		gbc_btnAcceder.insets = new Insets(0, 0, 5, 0);
		gbc_btnAcceder.gridx = 3;
		gbc_btnAcceder.gridy = 2;
		panelCentro.add(btnAcceder, gbc_btnAcceder);

		JLabel lblContrasea = new JLabel("Contraseña:");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 3;
		panelCentro.add(lblContrasea, gbc_lblContrasea);

		passwordField = new JPasswordField();
		passwordField.setColumns(20);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 3;
		panelCentro.add(passwordField, gbc_passwordField);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		frmAppchat.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWeights = new double[] { 1.0 };
		gbl_panel.columnWidths = new int[] { 0 };
		panel.setLayout(gbl_panel);
		panel.add(panelCentro);
		
		JButton btnNoRecuerdo = new JButton("No recuerdo la contraseña");
		GridBagConstraints gbc_btnNoRecuerdo = new GridBagConstraints();
		gbc_btnNoRecuerdo.insets = new Insets(0, 0, 5, 5);
		gbc_btnNoRecuerdo.gridx = 2;
		gbc_btnNoRecuerdo.gridy = 4;
		panelCentro.add(btnNoRecuerdo, gbc_btnNoRecuerdo);

		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon(Ventana_login.class.getResource("/vista/imagenes/chat.png")));
		frmAppchat.getContentPane().add(logo, BorderLayout.NORTH);

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
