package um.tds.Ventanas;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class VentanaNoRecuerdo extends JFrame implements ActionListener {

	private JFrame frmAppchat;
	private JTextField textEmail;
	private JPanel panel;
	private GridBagLayout gbl_panel;
	private JLabel lbl1, lbl2, lblError;
	private GridBagConstraints gbc_lbl1, gbc_lbl2, gbc_textEmail, gbc_btnAceptar, gbc_lblError;
	private JButton btnAceptar;

	public void mostrarNoRecuerdo(Dimension tam, Point ubi) {
		frmAppchat.setVisible(true);
		frmAppchat.setSize(tam);
		frmAppchat.setLocation(ubi);
	}

	public VentanaNoRecuerdo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAppchat = new JFrame();
		frmAppchat.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaNoRecuerdo.class.getResource("/imagenes/gatoVentana2_2048.png")));
		frmAppchat.setTitle("AppChat");
		frmAppchat.setBounds(100, 100, 477, 300);
		frmAppchat.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		panel = new JPanel();
		panel.setBackground(new Color(255, 244, 244));
		frmAppchat.getContentPane().add(panel, BorderLayout.CENTER);
		gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 34, 291, 7, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 19, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lbl1 = new JLabel("Si ha olvidado su contraseña, introduzca su correo electrónico.");
		lbl1.setMaximumSize(new Dimension(288, 13));
		lbl1.setMinimumSize(new Dimension(288, 13));
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		gbc_lbl1 = new GridBagConstraints();
		gbc_lbl1.insets = new Insets(0, 0, 5, 5);
		gbc_lbl1.gridx = 1;
		gbc_lbl1.gridy = 1;
		panel.add(lbl1, gbc_lbl1);

		lbl2 = new JLabel("Le llegará un enlace para cambiarla.");
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		gbc_lbl2 = new GridBagConstraints();
		gbc_lbl2.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2.gridx = 1;
		gbc_lbl2.gridy = 2;
		panel.add(lbl2, gbc_lbl2);

		textEmail = new JTextField();
		textEmail.setMinimumSize(new Dimension(277, 17));
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textEmail.gridx = 1;
		gbc_textEmail.gridy = 3;
		panel.add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setMinimumSize(new Dimension(77, 21));
		btnAceptar.setMaximumSize(new Dimension(77, 21));
		btnAceptar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnAceptar.setBackground(new Color(255, 255, 255));
		gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 3;
		panel.add(btnAceptar, gbc_btnAceptar);
		
		lblError = new JLabel("La dirección de correo electrónico no existe");
		lblError.setForeground(new Color(255, 0, 0));
		gbc_lblError = new GridBagConstraints();
		gbc_lblError.insets = new Insets(0, 0, 5, 5);
		gbc_lblError.gridx = 1;
		gbc_lblError.gridy = 4;
		panel.add(lblError, gbc_lblError);
		lblError.setVisible(false);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frmAppchat.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frmAppchat.getHeight()) / 2);
		frmAppchat.setLocation(x, y);

		frmAppchat.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		btnAceptar.addActionListener(this);
	}

	public static boolean esCorreoValido(String correo) {
	    return Pattern.matches("^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$", correo);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			if(textEmail.getText().equals("")){
				lblError.setVisible(true);
			} else {
				if(esCorreoValido(textEmail.getText())) {
					// Envía correo
				} else {
					textEmail.setText("");
					lblError.setVisible(true);
				}
			}
			return;
		}
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
