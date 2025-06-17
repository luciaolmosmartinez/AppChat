package um.tds.Ventanas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import um.tds.Modelado.Contacto;
import um.tds.Modelado.Mensaje;
import um.tds.Renderers.ContactoCellRenderer;
import um.tds.Renderers.MensajeCellRenderer;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class VentanaContactos implements ActionListener {

	private JFrame frmAppchat;
	private JMenuBar menuBar;
	private JMenuItem mntmPremium, mntmContactos, mntmMensajes, mntmPerfil;
	private JPanel panel;
	private JList<Contacto> list;
	private DefaultListModel<Contacto> contactos;
	private JButton btnNuevoContacto;
	private JButton btnNuevoGrupo;
	private JButton btnAtras;

	/**
	 * Create the frame.
	 */
	public void mostrarContactos(Dimension tam, Point ubi) {
		frmAppchat.setVisible(true);
		frmAppchat.setSize(tam);
		frmAppchat.setLocation(ubi);
	}

	/**
	 * Create the application.
	 */
	public VentanaContactos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAppchat = new JFrame();
		frmAppchat.setTitle("AppChat");
		frmAppchat.setIconImage(
				Toolkit.getDefaultToolkit().getImage(VentanaMain.class.getResource("/imagenes/gatoVentana2_2048.png")));
		frmAppchat.setBackground(new Color(255, 255, 255));
		frmAppchat.setVisible(true);
		frmAppchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAppchat.setBounds(100, 100, 633, 409);

		menuBar = new JMenuBar();
		menuBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		frmAppchat.setJMenuBar(menuBar);

		mntmPremium = new JMenuItem("PREMIUM");
		mntmPremium.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmPremium.setHorizontalTextPosition(SwingConstants.CENTER);
		menuBar.add(mntmPremium);

		mntmContactos = new JMenuItem("Contactos");
		mntmContactos.setHorizontalTextPosition(SwingConstants.CENTER);
		mntmContactos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(mntmContactos);

		mntmMensajes = new JMenuItem("Mensajes");
		mntmMensajes.setHorizontalTextPosition(SwingConstants.CENTER);
		mntmMensajes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(mntmMensajes);

		mntmPerfil = new JMenuItem("Perfil");
		mntmPerfil.setHorizontalTextPosition(SwingConstants.CENTER);
		mntmPerfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(mntmPerfil);

		panel = new JPanel();
		frmAppchat.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 180, 258, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 103, 74, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		contactos = new DefaultListModel<>();
		
		list = new JList<>();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.gridwidth = 2;
		gbc_list.gridheight = 4;
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 1;
		list.setCellRenderer(new ContactoCellRenderer());
		panel.add(list, gbc_list);
		
		btnNuevoContacto = new JButton("Añadir Contacto");
		GridBagConstraints gbc_btnNuevoContacto = new GridBagConstraints();
		gbc_btnNuevoContacto.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuevoContacto.gridx = 3;
		gbc_btnNuevoContacto.gridy = 2;
		panel.add(btnNuevoContacto, gbc_btnNuevoContacto);
		
		btnNuevoGrupo = new JButton("Crear Nuevo Grupo");
		GridBagConstraints gbc_btnNuevoGrupo = new GridBagConstraints();
		gbc_btnNuevoGrupo.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuevoGrupo.gridx = 3;
		gbc_btnNuevoGrupo.gridy = 3;
		panel.add(btnNuevoGrupo, gbc_btnNuevoGrupo);
		
		btnAtras = new JButton("Atrás");
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtras.gridx = 3;
		gbc_btnAtras.gridy = 4;
		panel.add(btnAtras, gbc_btnAtras);
		btnNuevoContacto.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNuevoContacto) {
			VentanaAnadirContacto aContacto = new VentanaAnadirContacto();
			frmAppchat.dispose();
			aContacto.mostrarAnadirContacto(frmAppchat.getSize(),frmAppchat.getLocation());
		}
		
	}

}
