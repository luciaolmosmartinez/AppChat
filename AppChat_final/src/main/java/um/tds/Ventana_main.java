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

public class Ventana_main extends JFrame {

	private JPanel contentPane;
	private JPanel panelOeste;
	private JPanel panelCentral;
	private JMenuBar menuBar;
	private JPanel panelContacto;
	private JPanel panelEscribir;
	private JLabel lblImagen;
	private JLabel lblConrtacto;
	private JButton btnEmoticono;
	private JTextField textField;
	private JButton btnEnviar;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private List list;
	private GridBagConstraints gbc_bubble_1;
	private JScrollPane scrollPane;
	private JPanel panelMensajes;

	/**
	 * Create the frame.
	 */
	public Ventana_main() {
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
		contentPane.setMaximumSize(new Dimension(494, 32767));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panelOeste = new JPanel();
		panelOeste.setBackground(new Color(255, 255, 255));
		contentPane.add(panelOeste, BorderLayout.WEST);

		list = new List();
		panelOeste.add(list);

		panelCentral = new JPanel();
		panelCentral.setBackground(new Color(255, 255, 255));
		panelCentral.setPreferredSize(new Dimension(494, 10));
		panelCentral.setMaximumSize(new Dimension(494, 32767));
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setMaximumSize(new Dimension(1400, 200));
		scrollPane.setPreferredSize(new Dimension(1400, 100));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelCentral.add(scrollPane, BorderLayout.WEST);
		
		panelMensajes = new JPanel();
		panelMensajes.setBackground(new Color(255, 255, 255));
		panelMensajes.setMaximumSize(new Dimension(494, 200));
		scrollPane.setViewportView(panelMensajes);

		panelContacto = new JPanel();
		panelContacto.setBackground(new Color(255, 255, 255));
		panelCentral.add(panelContacto, BorderLayout.NORTH);
		GridBagLayout gbl_panelContacto = new GridBagLayout();
		gbl_panelContacto.columnWidths = new int[] { 0, 97, 65, 81, 0 };
		gbl_panelContacto.rowHeights = new int[] { 14, 0 };
		gbl_panelContacto.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelContacto.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
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
		panelEscribir.setBackground(new Color(255, 255, 255));
		panelCentral.add(panelEscribir, BorderLayout.SOUTH);
		GridBagLayout gbl_panelEscribir = new GridBagLayout();
		gbl_panelEscribir.columnWidths = new int[] { 89, 0, 0, 0 };
		gbl_panelEscribir.rowHeights = new int[] { 23, 0 };
		gbl_panelEscribir.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelEscribir.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
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
		GridBagLayout gbl_panelMensajes = new GridBagLayout();
		gbl_panelMensajes.columnWidths = new int[]{499, 0};
		gbl_panelMensajes.rowHeights = new int[]{82, 30, 82, 30, 85, 85, 85, 85, 85, 85, 72, 40, 72, 40, 72, 0};
		gbl_panelMensajes.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelMensajes.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelMensajes.setLayout(gbl_panelMensajes);
		
		BubbleText bubble = new BubbleText(panelMensajes, 0, Color.PINK, "jaja", BubbleText.RECEIVED, 10);
		bubble.setAlignmentX(Component.LEFT_ALIGNMENT);
		bubble.setPreferredSize(new Dimension(494, 112));
		bubble.setSize(new Dimension(118, 118));
		GridBagConstraints gbc_bubble_1 = new GridBagConstraints();
		gbc_bubble_1.anchor = GridBagConstraints.NORTH;
		gbc_bubble_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_bubble_1.insets = new Insets(0, 0, 5, 0);
		gbc_bubble_1.gridx = 0;
		gbc_bubble_1.gridy = 0;
		panelMensajes.add(bubble, gbc_bubble_1);
		bubble = new BubbleText(panelMensajes, 0, Color.PINK, "jaja", BubbleText.SENT, 10);
		bubble.setAlignmentX(Component.LEFT_ALIGNMENT);
		bubble.setPreferredSize(new Dimension(494, 112));
		bubble.setSize(new Dimension(118, 118));
		gbc_bubble_1 = new GridBagConstraints();
		gbc_bubble_1.anchor = GridBagConstraints.NORTH;
		gbc_bubble_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_bubble_1.insets = new Insets(0, 0, 5, 0);
		gbc_bubble_1.gridx = 0;
		gbc_bubble_1.gridy = 2;
		panelMensajes.add(bubble, gbc_bubble_1);
		bubble = new BubbleText(panelMensajes, "HOLA", Color.PINK, "jeje", BubbleText.RECEIVED, 10);
		bubble.setAlignmentX(Component.LEFT_ALIGNMENT);
		bubble.setPreferredSize(new Dimension(494, 112));
		bubble.setSize(new Dimension(118, 118));
		gbc_bubble_1 = new GridBagConstraints();
		gbc_bubble_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_bubble_1.insets = new Insets(0, 0, 5, 0);
		gbc_bubble_1.gridx = 0;
		gbc_bubble_1.gridy = 4;
		panelMensajes.add(bubble, gbc_bubble_1);
		bubble = new BubbleText(panelMensajes, "HOLA", Color.PINK, "jeje", BubbleText.RECEIVED, 10);
		bubble.setAlignmentX(Component.LEFT_ALIGNMENT);
		bubble.setPreferredSize(new Dimension(494, 112));
		bubble.setSize(new Dimension(118, 118));
		gbc_bubble_1 = new GridBagConstraints();
		gbc_bubble_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_bubble_1.insets = new Insets(0, 0, 5, 0);
		gbc_bubble_1.gridx = 0;
		gbc_bubble_1.gridy = 5;
		panelMensajes.add(bubble, gbc_bubble_1);
		bubble = new BubbleText(panelMensajes, "HOLA", Color.PINK, "jeje", BubbleText.RECEIVED, 10);
		bubble.setAlignmentX(Component.LEFT_ALIGNMENT);
		bubble.setPreferredSize(new Dimension(494, 112));
		bubble.setSize(new Dimension(118, 118));
		gbc_bubble_1 = new GridBagConstraints();
		gbc_bubble_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_bubble_1.insets = new Insets(0, 0, 5, 0);
		gbc_bubble_1.gridx = 0;
		gbc_bubble_1.gridy = 6;
		panelMensajes.add(bubble, gbc_bubble_1);
		bubble = new BubbleText(panelMensajes, "HOLA", Color.PINK, "jeje", BubbleText.RECEIVED, 10);
		bubble.setAlignmentX(Component.LEFT_ALIGNMENT);
		bubble.setPreferredSize(new Dimension(494, 112));
		bubble.setSize(new Dimension(118, 118));
		gbc_bubble_1 = new GridBagConstraints();
		gbc_bubble_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_bubble_1.insets = new Insets(0, 0, 5, 0);
		gbc_bubble_1.gridx = 0;
		gbc_bubble_1.gridy = 7;
		panelMensajes.add(bubble, gbc_bubble_1);
		
		bubble = new BubbleText(panelMensajes, "HOLA", Color.PINK, "jeje", BubbleText.RECEIVED, 10);
		bubble.setAlignmentX(Component.LEFT_ALIGNMENT);
		bubble.setPreferredSize(new Dimension(494, 112));
		bubble.setSize(new Dimension(118, 118));
		gbc_bubble_1 = new GridBagConstraints();
		gbc_bubble_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_bubble_1.insets = new Insets(0, 0, 5, 0);
		gbc_bubble_1.gridx = 0;
		gbc_bubble_1.gridy = 8;
		panelMensajes.add(bubble, gbc_bubble_1);
		bubble = new BubbleText(panelMensajes, "HOLA", Color.PINK, "jeje", BubbleText.RECEIVED, 10);
		bubble.setAlignmentX(Component.LEFT_ALIGNMENT);
		bubble.setPreferredSize(new Dimension(494, 112));
		bubble.setSize(new Dimension(118, 118));
		gbc_bubble_1 = new GridBagConstraints();
		gbc_bubble_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_bubble_1.insets = new Insets(0, 0, 5, 0);
		gbc_bubble_1.gridx = 0;
		gbc_bubble_1.gridy = 9;
		panelMensajes.add(bubble, gbc_bubble_1);
		bubble = new BubbleText(panelMensajes, "HOLA", Color.PINK, "jeje", BubbleText.RECEIVED, 10);
		bubble.setAlignmentX(Component.LEFT_ALIGNMENT);
		bubble.setPreferredSize(new Dimension(494, 112));
		bubble.setSize(new Dimension(118, 118));
		gbc_bubble_1 = new GridBagConstraints();
		gbc_bubble_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_bubble_1.insets = new Insets(0, 0, 5, 0);
		gbc_bubble_1.gridx = 0;
		gbc_bubble_1.gridy = 10;
		panelMensajes.add(bubble, gbc_bubble_1);
		bubble = new BubbleText(panelMensajes, "HOLA", Color.PINK, "jeje", BubbleText.RECEIVED, 10);
		bubble.setAlignmentX(Component.LEFT_ALIGNMENT);
		bubble.setPreferredSize(new Dimension(494, 112));
		bubble.setSize(new Dimension(118, 118));
		gbc_bubble_1 = new GridBagConstraints();
		gbc_bubble_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_bubble_1.insets = new Insets(0, 0, 5, 0);
		gbc_bubble_1.gridx = 0;
		gbc_bubble_1.gridy = 12;
		panelMensajes.add(bubble, gbc_bubble_1);
		bubble = new BubbleText(panelMensajes, "HOLA", Color.PINK, "jeje", BubbleText.RECEIVED, 10);
		bubble.setAlignmentX(Component.LEFT_ALIGNMENT);
		bubble.setPreferredSize(new Dimension(494, 112));
		bubble.setSize(new Dimension(118, 118));
		gbc_bubble_1 = new GridBagConstraints();
		gbc_bubble_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_bubble_1.gridx = 0;
		gbc_bubble_1.gridy = 14;
		panelMensajes.add(bubble, gbc_bubble_1);
	}

}
