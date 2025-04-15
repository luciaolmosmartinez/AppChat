package um.tds.Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class VentanaBusqueda extends JFrame implements ActionListener {

	private JFrame frmAppchat;
	private JPanel contentPane, panel, panel_1, panel_2;
	private JTextField textField;
	private JMenuBar menuBar;
	private JMenuItem mntmNewMenuItem, mntmNewMenuItem_1, mntmNewMenuItem_2, mntmNewMenuItem_3;
	private JRadioButton rdbtnNewRadioButton, rdbtnNewRadioButton_1, rdbtnNewRadioButton_2;
	private JButton btnNewButton;
	private GridBagLayout gbl_panel, gbl_panel_1;
	private GridBagConstraints gbc_panel_2, gbc_rdbtnNewRadioButton, gbc_rdbtnNewRadioButton_1,
			gbc_rdbtnNewRadioButton_2, gbc_lblNewLabel, gbc_list;
	private JLabel lblNewLabel;
	private JList list;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaBusqueda() {
		frmAppchat.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaBusqueda.class.getResource("/imagenes/gatoVentana2_2048.png")));
		frmAppchat.setTitle("AppChat");
		frmAppchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAppchat.setBounds(100, 100, 633, 409);

		menuBar = new JMenuBar();
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frmAppchat.setContentPane(contentPane);

		panel = new JPanel();
		panel.setToolTipText("");
		contentPane.add(panel, BorderLayout.WEST);
		gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 109, 0 };
		gbl_panel.rowHeights = new int[] { 23, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		panel_2 = new JPanel();
		gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);

		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);

		btnNewButton = new JButton("Buscar");
		panel_2.add(btnNewButton);

		rdbtnNewRadioButton = new JRadioButton("Frase");
		gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton.gridx = 0;
		gbc_rdbtnNewRadioButton.gridy = 1;
		panel.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("Teléfono");
		gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton_1.gridx = 0;
		gbc_rdbtnNewRadioButton_1.gridy = 2;
		panel.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);

		rdbtnNewRadioButton_2 = new JRadioButton("Contacto");
		gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton_2.gridx = 0;
		gbc_rdbtnNewRadioButton_2.gridy = 3;
		panel.add(rdbtnNewRadioButton_2, gbc_rdbtnNewRadioButton_2);

		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 53, 1, 0 };
		gbl_panel_1.rowHeights = new int[] { 14, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		lblNewLabel = new JLabel("Resultados");
		gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		list = new JList();
		gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 0, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 2;
		gbc_list.gridy = 1;
		panel_1.add(list, gbc_list);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
