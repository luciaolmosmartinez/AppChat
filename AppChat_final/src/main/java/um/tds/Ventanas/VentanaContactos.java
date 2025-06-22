package um.tds.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import um.tds.Controlador.Controlador;
import um.tds.Modelado.Contacto;
import um.tds.Modelado.ContactoIndividual;
import um.tds.Modelado.Grupo;
import um.tds.Renderers.ContactoCellRenderer;

public class VentanaContactos implements ActionListener {

	private JFrame frmAppchat;
	private JMenuBar menuBar;
	private JMenu mnPerfil, mnPdf;
	private JMenuItem mntmPremium, mntmContactos, mntmMensajes, mntmEditarPerfil, mntmCerrarSesion, mntmContactosPdf,
			mntmMensajesPdf;
	private JPanel panel;
	private JList<Contacto> list;
	private DefaultListModel<Contacto> contactos;
	private JButton btnNuevoContacto, btnNuevoGrupo, btnAtras, btnEnviarMensaje;
	private JLabel lblInfo;
	private javax.swing.event.ListSelectionListener listenerModificar;
	private javax.swing.event.ListSelectionListener listenerMandarMensaje;

	/**
	 * Create the frame.
	 */

	/**
	 * Create the application.
	 */
	public VentanaContactos(Dimension tam, Point ubi) {
		initialize(tam, ubi);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Dimension tam, Point ubi) {
		listenerModificar = l -> contactoSeleccionadoModificar();
		listenerMandarMensaje = l -> contactoSeleccionadoMandarMensaje();
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
		
		mnPdf = new JMenu("Documento PDF");
		mnPdf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnPdf.setHorizontalAlignment(SwingConstants.LEFT);
		mnPdf.setPreferredSize(new Dimension(180, 26));
		mnPdf.setBackground(Color.WHITE);
		menuBar.add(mnPdf);

		mntmContactosPdf = new JMenuItem("Generar documento con información de contactos");
		mntmContactosPdf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmContactosPdf.setBackground(new Color(255, 255, 255));
		mnPdf.add(mntmContactosPdf);

		mntmMensajesPdf = new JMenuItem("Generar documento con la conversación");
		mntmMensajesPdf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmMensajesPdf.setBackground(new Color(255, 255, 255));
		mnPdf.add(mntmMensajesPdf);

		mntmPremium = new JMenuItem("");
		mntmPremium.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmPremium.setBackground(new Color(255, 255, 255));
		mntmPremium.setHorizontalTextPosition(SwingConstants.CENTER);
		menuBar.add(mntmPremium);
		if (Controlador.getUnicaInstancia().getUsuarioActual().isPremium()) {
			try {
				BufferedImage image = ImageIO.read(getClass().getResource("/imagenes/orejas_premium.png"));
				mntmPremium.setIcon(new ImageIcon(image));
				mntmPremium.setSize(new Dimension(64, 32));
				ImageInJLabel.resizeImage(mntmPremium, image);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			try {
				BufferedImage  image = ImageIO.read(getClass().getResource("/imagenes/orejas_premium.png"));
				mntmPremium.setIcon(new ImageIcon(image));
				mntmPremium.setSize(new Dimension(64, 32));
				ImageInJLabel.resizeImage(mntmPremium, image);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		mntmContactos = new JMenuItem("Contactos");
		mntmContactos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmContactos.setBackground(new Color(255, 255, 255));
		menuBar.add(mntmContactos);

		mntmMensajes = new JMenuItem("Mensajes");
		mntmMensajes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmMensajes.setBackground(new Color(255, 255, 255));
		menuBar.add(mntmMensajes);

		mnPerfil = new JMenu("Perfil");
		mnPerfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnPerfil.setBackground(Color.WHITE);
		mnPerfil.setSize(30, 30);

		try {
			mnPerfil.setIcon(new ImageIcon(Controlador.getUnicaInstancia().getUsuarioActual().getImagenPerfilDirecta()));
			ImageInJLabel.resizeImage(mnPerfil,
					Controlador.getUnicaInstancia().getUsuarioActual().getImagenPerfilDirecta());
			menuBar.add(mnPerfil);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		mntmEditarPerfil = new JMenuItem("Editar perfil");
		mntmEditarPerfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmEditarPerfil.setBackground(new Color(255, 255, 255));
		mnPerfil.add(mntmEditarPerfil);

		mntmCerrarSesion = new JMenuItem("Cerrar sesión");
		mntmCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmCerrarSesion.setBackground(new Color(255, 255, 255));
		mnPerfil.add(mntmCerrarSesion);

		panel = new JPanel();
		panel.setBackground(new Color(255, 244, 244));
		frmAppchat.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 180, 258, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 103, 51, 0, 49, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		contactos = new DefaultListModel<>();

		btnAtras = new JButton("");
		btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtras.setPreferredSize(new Dimension(32, 32));
		btnAtras.setBackground(new Color(255, 255, 255));
		try {
			BufferedImage image = ImageIO.read(getClass().getResource("/imagenes/mod_boton-de-retroceso.png"));
			btnAtras.setIcon(new ImageIcon(image));
			btnAtras.setSize(new Dimension(32, 32));
			ImageInJLabel.resizeImage(btnAtras, image);
		} catch (IOException e) {
			e.printStackTrace();
		}

		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAtras.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtras.gridx = 0;
		gbc_btnAtras.gridy = 0;
		panel.add(btnAtras, gbc_btnAtras);

		lblInfo = new JLabel("Pulsa sobre el contacto o el grupo para modificarlo:");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblInfo = new GridBagConstraints();
		gbc_lblInfo.gridwidth = 2;
		gbc_lblInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblInfo.gridx = 1;
		gbc_lblInfo.gridy = 0;
		panel.add(lblInfo, gbc_lblInfo);

		list = new JList<>(contactos);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.gridwidth = 2;
		gbc_list.gridheight = 5;
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 1;
		list.setCellRenderer(new ContactoCellRenderer());
		panel.add(list, gbc_list);

		btnNuevoContacto = new JButton("Añadir Contacto");
		btnNuevoContacto.setBackground(new Color(255, 255, 255));
		btnNuevoContacto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNuevoContacto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevoContacto.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_btnNuevoContacto = new GridBagConstraints();
		gbc_btnNuevoContacto.fill = GridBagConstraints.BOTH;
		gbc_btnNuevoContacto.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuevoContacto.gridx = 4;
		gbc_btnNuevoContacto.gridy = 2;
		panel.add(btnNuevoContacto, gbc_btnNuevoContacto);

		btnNuevoGrupo = new JButton("Crear Nuevo Grupo");
		btnNuevoGrupo.setSize(new Dimension(130, 31));
		btnNuevoGrupo.setPreferredSize(new Dimension(130, 31));
		btnNuevoGrupo.setBackground(new Color(255, 255, 255));
		btnNuevoGrupo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNuevoGrupo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevoGrupo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_btnNuevoGrupo = new GridBagConstraints();
		gbc_btnNuevoGrupo.fill = GridBagConstraints.BOTH;
		gbc_btnNuevoGrupo.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuevoGrupo.gridx = 4;
		gbc_btnNuevoGrupo.gridy = 4;
		panel.add(btnNuevoGrupo, gbc_btnNuevoGrupo);

		btnEnviarMensaje = new JButton("Enviar mensaje a");
		btnEnviarMensaje.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnviarMensaje.setSize(new Dimension(130, 31));
		btnEnviarMensaje.setPreferredSize(new Dimension(130, 31));
		btnEnviarMensaje.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnviarMensaje.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnEnviarMensaje.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnEnviarMensaje = new GridBagConstraints();
		gbc_btnEnviarMensaje.fill = GridBagConstraints.BOTH;
		gbc_btnEnviarMensaje.insets = new Insets(0, 0, 0, 5);
		gbc_btnEnviarMensaje.gridx = 2;
		gbc_btnEnviarMensaje.gridy = 6;
		panel.add(btnEnviarMensaje, gbc_btnEnviarMensaje);

		btnNuevoContacto.addActionListener(this);
		btnAtras.addActionListener(this);
		mntmPremium.addActionListener(this);
		mntmContactos.addActionListener(this);
		mntmCerrarSesion.addActionListener(this);
		mntmEditarPerfil.addActionListener(this);
		mntmContactosPdf.addActionListener(this);
		mntmMensajesPdf.addActionListener(this);
		btnNuevoGrupo.addActionListener(this);
		btnEnviarMensaje.addActionListener(this);
		list.addListSelectionListener(listenerModificar);
		actualizarContactos();

		frmAppchat.setVisible(true);
		frmAppchat.setSize(tam);
		frmAppchat.setLocation(ubi);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevoContacto) {
			new VentanaAnadirContacto(frmAppchat.getSize(), frmAppchat.getLocation(), "VentanaContactos");
			frmAppchat.dispose();
			// aContacto.mostrarAnadirContacto(frmAppchat.getSize(),
			// frmAppchat.getLocation(),this);
		}
		if (e.getSource() == btnAtras) {
			new VentanaMain(frmAppchat.getSize(), frmAppchat.getLocation(), null);
			frmAppchat.dispose();
			// vMain.mostrarMain(frmAppchat.getSize(), frmAppchat.getLocation());
		}
		if (e.getSource() == btnNuevoGrupo) {
			new VentanaCrearGrupo(frmAppchat.getSize(), frmAppchat.getLocation(), "VentanaContactos");
			frmAppchat.dispose();
		}
		if (e.getSource() == btnEnviarMensaje) {
			list.removeListSelectionListener(listenerModificar);
			list.addListSelectionListener(listenerMandarMensaje);
		}
		if (e.getSource() == mntmPremium) {
			if (Controlador.getUnicaInstancia().getUsuarioActual().isPremium()) {
				int res = JOptionPane.showConfirmDialog(frmAppchat, "¿Está seguro de que desea dejar de ser Premium?",
						"Dejar de ser premium", JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION) {
					Controlador.getUnicaInstancia().setPremium(false);
					
					try {
						BufferedImage image = ImageIO.read(getClass().getResource("/imagenes/orejas_premium.png"));
						mntmPremium.setIcon(new ImageIcon(image));
						mntmPremium.setSize(new Dimension(64, 32));
						ImageInJLabel.resizeImage(mntmPremium,image);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					
				}
			} else {
				new VentanaOferta(frmAppchat.getSize(), frmAppchat.getLocation(), "VentanaMain");
				frmAppchat.dispose();
			}
		}
		if (e.getSource() == mntmContactosPdf) {
			JFileChooser fileC = new JFileChooser();
			int seleccion = fileC.showSaveDialog(null);

			if (seleccion == JFileChooser.APPROVE_OPTION) {
				Path ruta = Paths.get(fileC.getSelectedFile().getAbsolutePath());
				// Genera el pdf
				if (!Controlador.getUnicaInstancia().createPdfContactos(ruta)) {
					JOptionPane.showMessageDialog(frmAppchat, "Ha habido un error al crear el documento", "Error",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		}
		if (e.getSource() == mntmMensajesPdf) {
			if (Controlador.getUnicaInstancia().getUsuarioActual().isPremium()) {
					JOptionPane.showMessageDialog(frmAppchat, "Debes tener abierta la conversación que deseas exportar",
							"Información", JOptionPane.PLAIN_MESSAGE);
			} else {
				new VentanaOferta(frmAppchat.getSize(), frmAppchat.getLocation(), "VentanaMain");
				frmAppchat.dispose();
			}
		}

		if (e.getSource() == mntmContactos) {
			new VentanaContactos(frmAppchat.getSize(), frmAppchat.getLocation());
			frmAppchat.dispose();
			// contacto.mostrarContactos(frmAppchat.getSize(), frmAppchat.getLocation());
		}
		if (e.getSource() == mntmCerrarSesion) {
			Controlador.getUnicaInstancia().cerrarSesion();
			new VentanaInicio(frmAppchat.getSize(), frmAppchat.getLocation());
			frmAppchat.dispose();
		}
		if (e.getSource() == mntmEditarPerfil) {
			new VentanaPerfil(frmAppchat.getSize(), frmAppchat.getLocation(), "VentanaContactos");
			frmAppchat.dispose();
		}
	}

	private void contactoSeleccionadoModificar() {
		if (list.getSelectedValue() instanceof Grupo) {
			new VentanaModificarGrupo((Grupo) list.getSelectedValue(), frmAppchat.getSize(), frmAppchat.getLocation());
			frmAppchat.dispose();
		} else {
			frmAppchat.dispose();
			new VentanaModificarContacto((ContactoIndividual) list.getSelectedValue(), frmAppchat.getSize(),
					frmAppchat.getLocation());
		}
	}

	private void contactoSeleccionadoMandarMensaje() {
		new VentanaMain(frmAppchat.getSize(), frmAppchat.getLocation(), list.getSelectedValue());
		frmAppchat.dispose();
	}

	private void actualizarContactos() {
		Controlador.getUnicaInstancia().recuperarContactos().stream().forEach(c -> contactos.addElement(c));
	}

}
