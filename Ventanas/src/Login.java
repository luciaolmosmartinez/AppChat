

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Login {

	private JFrame frame;
	private JTextField txtValorDelTexto;
	private JLabel imagen_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { //en entorno multihilo
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("AppChat");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setIcon(new ImageIcon(Login.class.getResource("/recursos/new_891448 (2).png")));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setIcon(new ImageIcon(Login.class.getResource("/recursos/padlock_6610225.png")));
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JLabel Imagen = new JLabel("New label");
		String path ="https://png.pngtree.com/png-vector/20221203/ourmid/pngtree-cartoon-style-male-user-profile-icon-vector-illustraton-png-image_6489287.png";
		URL url;
		try {
			url = new URL(path);
			BufferedImage imagen = ImageIO.read(url);
			imagen_1 = new JLabel(new ImageIcon(imagen));
			imagen_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		} catch (IOException e) {
			e.printStackTrace();
		}
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_1.add(imagen_1);
		
		txtValorDelTexto = new JTextField();
		txtValorDelTexto.setText("valor del texto");
		panel_1.add(txtValorDelTexto);
		txtValorDelTexto.setColumns(15);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_1.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setRows(5);
		textArea.setColumns(15);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("opción 1");
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("opción 2");
		panel_1.add(rdbtnNewRadioButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("opcion 1");
		comboBox.addItem("opcion 2");
		comboBox.addItem("opcion 3");
		panel_1.add(comboBox);
		
		JMenu mnNewMenu = new JMenu("New menu");
		panel_1.add(mnNewMenu);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("File");
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New");
		menuBar.add(mntmNewMenuItem);
	}

	
	//VentanaRegistro registro = new VentanaRegistro();

}
