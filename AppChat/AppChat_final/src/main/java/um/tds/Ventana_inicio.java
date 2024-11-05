package um.tds;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

public class Ventana_inicio {

	private JFrame frmAppchat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_inicio window = new Ventana_inicio();
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
	public Ventana_inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAppchat = new JFrame();
		frmAppchat.setTitle("AppChat");
		frmAppchat.setBackground(new Color(255, 255, 255));
		frmAppchat.getContentPane().setBackground(new Color(255, 255, 255));
		frmAppchat.setBounds(100, 100, 655, 492);
		frmAppchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(255, 255, 255));
		frmAppchat.getContentPane().add(panelSuperior, BorderLayout.NORTH);
		
		JLabel lblAppChat = new JLabel("AppChat");
		lblAppChat.setForeground(new Color(255, 128, 192));
		lblAppChat.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 59));
		panelSuperior.add(lblAppChat);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(new Color(255, 255, 255));
		frmAppchat.getContentPane().add(panelCentral, BorderLayout.CENTER);
		GridBagLayout gbl_panelCentral = new GridBagLayout();
		gbl_panelCentral.columnWidths = new int[]{20, 146, 0, 0};
		gbl_panelCentral.rowHeights = new int[]{0, 48, 0, 51, 0, 0};
		gbl_panelCentral.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelCentral.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelCentral.setLayout(gbl_panelCentral);
		
		Component separadorSuperior = Box.createVerticalStrut(20);
		separadorSuperior.setPreferredSize(new Dimension(0, 70));
		GridBagConstraints gbc_separadorSuperior = new GridBagConstraints();
		gbc_separadorSuperior.insets = new Insets(0, 0, 5, 5);
		gbc_separadorSuperior.gridx = 1;
		gbc_separadorSuperior.gridy = 0;
		panelCentral.add(separadorSuperior, gbc_separadorSuperior);
		
		JButton btnInicioSesion = new JButton("Iniciar Sesión");
		btnInicioSesion.setPreferredSize(new Dimension(180, 50));
		btnInicioSesion.setMinimumSize(new Dimension(20, 20));
		btnInicioSesion.setMaximumSize(new Dimension(150, 60));
		btnInicioSesion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnInicioSesion.setBorder(new MatteBorder(0, 1, 4, 4, (Color) new Color(192, 192, 192)));
		btnInicioSesion.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnInicioSesion = new GridBagConstraints();
		gbc_btnInicioSesion.insets = new Insets(0, 0, 5, 5);
		gbc_btnInicioSesion.gridx = 1;
		gbc_btnInicioSesion.gridy = 1;
		panelCentral.add(btnInicioSesion, gbc_btnInicioSesion);
		
		Component separadorCentral = Box.createVerticalStrut(20);
		GridBagConstraints gbc_separadorCentral = new GridBagConstraints();
		gbc_separadorCentral.insets = new Insets(0, 0, 5, 5);
		gbc_separadorCentral.gridx = 1;
		gbc_separadorCentral.gridy = 2;
		panelCentral.add(separadorCentral, gbc_separadorCentral);
		
		JButton btnRegistro = new JButton("Registrarse");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistro.setBackground(new Color(255, 255, 255));
		btnRegistro.setBorder(new MatteBorder(0, 1, 4, 4, (Color) new Color(192, 192, 192)));
		btnRegistro.setMinimumSize(new Dimension(20, 20));
		btnRegistro.setMaximumSize(new Dimension(150, 60));
		btnRegistro.setPreferredSize(new Dimension(180, 50));
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_btnRegistro = new GridBagConstraints();
		gbc_btnRegistro.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegistro.gridx = 1;
		gbc_btnRegistro.gridy = 3;
		panelCentral.add(btnRegistro, gbc_btnRegistro);
	}

}
