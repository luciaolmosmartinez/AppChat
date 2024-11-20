package um.tds;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.SwingConstants;

public class Ventana_main extends JFrame {

	private JPanel contentPane;
	private JPanel panelOeste;
	private JPanel panelCentral;
	private JMenuBar menuBar;
	private JButton btnPremium;
	private JButton btnPerfil;
	private JComboBox comboBoxBuscaMensaje;
	private JComboBox comboBoxBuscaContacto;
	private JPanel panelContacto;
	private JPanel panelEscribir;
	private JPanel panelMensajes;
	private JLabel lblImagen;
	private JLabel lblConrtacto;
	private JButton btnEmoticono;
	private JTextField textField;
	private JButton btnEnviar;

	/**
	 * Create the frame.
	 */
	public Ventana_main() {
		setTitle("AppChat");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_main.class.getResource("/imagenes/gatoVentana2_2048.png")));
		setBackground(new Color(255, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 409);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		btnPremium = new JButton("Premium");
		menuBar.add(btnPremium);
		
		comboBoxBuscaContacto = new JComboBox();
		menuBar.add(comboBoxBuscaContacto);
		
		comboBoxBuscaMensaje = new JComboBox();
		menuBar.add(comboBoxBuscaMensaje);
		
		btnPerfil = new JButton("Perfil");
		menuBar.add(btnPerfil);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		
		panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		panelContacto = new JPanel();
		panelCentral.add(panelContacto, BorderLayout.NORTH);
		GridBagLayout gbl_panelContacto = new GridBagLayout();
		gbl_panelContacto.columnWidths = new int[]{0, 97, 65, 81, 0};
		gbl_panelContacto.rowHeights = new int[]{14, 0};
		gbl_panelContacto.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelContacto.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelContacto.setLayout(gbl_panelContacto);
		
		lblImagen = new JLabel("foto contacto");
		GridBagConstraints gbc_lblImagen = new GridBagConstraints();
		gbc_lblImagen.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblImagen.insets = new Insets(0, 0, 0, 5);
		gbc_lblImagen.gridx = 1;
		gbc_lblImagen.gridy = 0;
		panelContacto.add(lblImagen, gbc_lblImagen);
		
		lblConrtacto = new JLabel("nombre contacto");
		GridBagConstraints gbc_lblConrtacto = new GridBagConstraints();
		gbc_lblConrtacto.insets = new Insets(0, 0, 0, 5);
		gbc_lblConrtacto.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblConrtacto.gridx = 2;
		gbc_lblConrtacto.gridy = 0;
		panelContacto.add(lblConrtacto, gbc_lblConrtacto);
		
		panelEscribir = new JPanel();
		panelCentral.add(panelEscribir, BorderLayout.SOUTH);
		GridBagLayout gbl_panelEscribir = new GridBagLayout();
		gbl_panelEscribir.columnWidths = new int[]{89, 0, 0, 0};
		gbl_panelEscribir.rowHeights = new int[]{23, 0};
		gbl_panelEscribir.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelEscribir.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelEscribir.setLayout(gbl_panelEscribir);
		
		btnEmoticono = new JButton("emoticonos");
		GridBagConstraints gbc_btnEmoticono = new GridBagConstraints();
		gbc_btnEmoticono.insets = new Insets(0, 0, 0, 5);
		gbc_btnEmoticono.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnEmoticono.gridx = 0;
		gbc_btnEmoticono.gridy = 0;
		panelEscribir.add(btnEmoticono, gbc_btnEmoticono);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panelEscribir.add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnEnviar = new JButton("Enviar");
		GridBagConstraints gbc_btnEnviar = new GridBagConstraints();
		gbc_btnEnviar.gridx = 2;
		gbc_btnEnviar.gridy = 0;
		panelEscribir.add(btnEnviar, gbc_btnEnviar);
		
		panelMensajes = new JPanel();
		panelCentral.add(panelMensajes, BorderLayout.CENTER);

	}

}
