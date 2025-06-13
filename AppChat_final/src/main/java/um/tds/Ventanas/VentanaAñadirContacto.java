package um.tds.Ventanas;

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

public class VentanaAñadirContacto implements ActionListener {

	private JFrame frmAppchat;
	private JPanel contentPane, panel, panel_1;
	private JMenuBar menuBar;
	private JMenuItem mntmNewMenuItem, mntmNewMenuItem_1, mntmNewMenuItem_2, mntmNewMenuItem_3;
	private GridBagConstraints gbc_bubble_1, gbc_lblNewLabel, gbc_txtNombre, gbc_txtTelfono, gbc_lblNewLabel_1,
			gbc_btnNewButton, gbc_btnNewButton_1;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel, lblNewLabel_1;
	private JTextField txtNombre, txtTelfono, txtEmail;
	private JButton btnNewButton, btnNewButton_1;
	private GridBagLayout gbl_panel_1;

	/**
	 * Create the frame.
	 */
	public VentanaAñadirContacto() {
		frmAppchat.setTitle("AppChat");
		frmAppchat.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaMain.class.getResource("/imagenes/gatoVentana2_2048.png")));
		frmAppchat.setBackground(new Color(255, 255, 255));
		frmAppchat.setVisible(true);
		frmAppchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAppchat.setBounds(100, 100, 633, 409);

		menuBar = new JMenuBar();
		menuBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		frmAppchat.setJMenuBar(menuBar);

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
		frmAppchat.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);

		scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1);

		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		lblNewLabel = new JLabel("gato");
		gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		txtNombre = new JTextField();
		txtNombre.setText("Nombre");
		gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 3;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 3;
		gbc_txtNombre.gridy = 1;
		panel_1.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);

		txtTelfono = new JTextField();
		txtTelfono.setText("Teléfono");
		gbc_txtTelfono = new GridBagConstraints();
		gbc_txtTelfono.gridwidth = 3;
		gbc_txtTelfono.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelfono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelfono.gridx = 3;
		gbc_txtTelfono.gridy = 2;
		panel_1.add(txtTelfono, gbc_txtTelfono);
		txtTelfono.setColumns(10);

		lblNewLabel_1 = new JLabel("Información opcional");
		gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 5;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtEmail = new JTextField();
		txtEmail.setText("Email");
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.gridwidth = 5;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 6;
		panel_1.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);

		btnNewButton = new JButton("Cancelar");
		gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 9;
		panel_1.add(btnNewButton, gbc_btnNewButton);

		btnNewButton_1 = new JButton("Aceptar");
		gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 6;
		gbc_btnNewButton_1.gridy = 9;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
	}

	public void actionPerformed(ActionEvent e) {

	}

}
