package um.tds;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import tds.BubbleText;
import java.awt.color.*;

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
import javax.swing.JScrollBar;

import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import java.awt.ScrollPane;
import java.awt.Choice;
import java.awt.List;
import java.awt.Scrollbar;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.DropMode;

public class Ventana_main2 extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private GridBagConstraints gbc_bubble_1;
	private JPanel panel;
	private JPanel panel_1;
	private Panel panel_2;
	private Panel panel_3;
	private Button button;
	private JTextField textField;
	private Button button_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JList list;
	private JPanel panel_4;
	private JScrollPane scrollPane;
	private JList list_1;

	/**
	 * Create the frame.
	 */
	public Ventana_main2() {
		setTitle("AppChat");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Ventana_main.class.getResource("/imagenes/gatoVentana2_2048.png")));
		setBackground(new Color(255, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 409);

		menuBar = new JMenuBar();
		menuBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		setJMenuBar(menuBar);

		mntmNewMenuItem = new JMenuItem("PREMIUM");
		mntmNewMenuItem.setHorizontalTextPosition(SwingConstants.CENTER);
		menuBar.add(mntmNewMenuItem);

		mntmNewMenuItem_1 = new JMenuItem("Contactos");
		menuBar.add(mntmNewMenuItem_1);

		mntmNewMenuItem_2 = new JMenuItem("Mensajes");
		menuBar.add(mntmNewMenuItem_2);

		mntmNewMenuItem_3 = new JMenuItem("Perfil");
		menuBar.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(494, 200));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		
		list = new JList();
		panel.add(list);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new Panel();
		panel_1.add(panel_2, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{83, 371, 66, 0};
		gbl_panel_2.rowHeights = new int[]{21, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		button = new Button("emoticonos");
		button.setName("emoticonos");
		button.setActionCommand("emoticonos");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.anchor = GridBagConstraints.NORTH;
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		panel_2.add(button, gbc_button);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_2.add(textField, gbc_textField);
		textField.setColumns(10);
		
		button_1 = new Button("enviar");
		button_1.setActionCommand("Enviar");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_1.anchor = GridBagConstraints.NORTH;
		gbc_button_1.gridx = 2;
		gbc_button_1.gridy = 0;
		panel_2.add(button_1, gbc_button_1);
		
		panel_3 = new Panel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		btnNewButton = new JButton("Imagen perfil");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_3.add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton_1 = new JButton("Nombre contacto/grupo");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 0;
		panel_3.add(btnNewButton_1, gbc_btnNewButton_1);
		
		panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(600, 290));
		panel_4.add(scrollPane);
		
		BubbleText bubble = new BubbleText(panel_4, 0, Color.PINK, "jaja", BubbleText.RECEIVED, 10);
		bubble.setSize(new Dimension(493, 82));
		bubble.setMaximumSize(new Dimension(498, 82));
		bubble.setPreferredSize(new Dimension(492, 61));
		GridBagConstraints gbc_bubble = new GridBagConstraints();
		gbc_bubble.gridx = 0;
		gbc_bubble.gridy = 0;
		BubbleText bubble1 = new BubbleText(panel_4, "hola", Color.PINK, "jaja", BubbleText.SENT, 10);
		bubble1.setAlignmentY(Component.CENTER_ALIGNMENT);
		bubble1.setSize(new Dimension(493, 82));
		bubble1.setMaximumSize(new Dimension(498, 82));
		bubble1.setPreferredSize(new Dimension(492, 61));
		GridBagConstraints gbc_bubble_1 = new GridBagConstraints();
		gbc_bubble_1.gridx = 0;
		gbc_bubble_1.gridy = 2;
		list_1 = new JList();
		list_1.add(bubble,gbc_bubble);
		list_1.add(bubble1,gbc_bubble_1);
		scrollPane.setViewportView(list_1);
	}

}
