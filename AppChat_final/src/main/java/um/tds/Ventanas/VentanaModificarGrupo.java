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
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import um.tds.Controlador.Controlador;
import um.tds.Modelado.ContactoIndividual;
import um.tds.Modelado.Grupo;
import um.tds.Renderers.ContactoCellRenderer;

public class VentanaModificarGrupo implements ActionListener {

	private JFrame frmAppchat;
	private Grupo grupo;
	private JPanel panel;
	private JLabel lblModificar, lblNombre, lblImagen, lblError, lblMiembros, lblNoMiembros, lblEliminar, lblAnadir;
	private JButton btnAtras, btnAceptar, btnRestaurar;
	private JTextField textFieldNombre, textFieldImagen;
	private GridBagConstraints gbc_lblImagen;
	private JList<ContactoIndividual> listMiembros, listNoMiembros;
	private List<ContactoIndividual> miembrosActualizados;
	private DefaultListModel<ContactoIndividual> contactosMiembros, contactosNoMiembros;
	private JScrollPane scrollMiembros, scrollNoMiembros;
	private JMenuBar menuBar;
	private JMenuItem mntmPremium, mntmContactos, mntmMensajes, mntmEditarPerfil, mntmCerrarSesion;
	private JMenu mnPerfil;

	public VentanaModificarGrupo(Grupo grupo, Dimension tam, Point ubi) {
		this.grupo = grupo;
		initialize(tam, ubi);
	}

	private void initialize(Dimension tam, Point ubi) {
		frmAppchat = new JFrame();
		frmAppchat.setBackground(new Color(255, 244, 244));
		frmAppchat.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaLogin.class.getResource("/imagenes/gatoVentana2_2048.png")));
		frmAppchat.setTitle("AppChat");
		frmAppchat.setBounds(300, 300, 907, 680);
		frmAppchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuBar = new JMenuBar();
		menuBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		frmAppchat.setJMenuBar(menuBar);

		mntmPremium = new JMenuItem("");
		mntmPremium.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmPremium.setBackground(new Color(255, 255, 255));
		mntmPremium.setHorizontalTextPosition(SwingConstants.CENTER);
		menuBar.add(mntmPremium);

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
			mnPerfil.setIcon(
					new ImageIcon(Controlador.getUnicaInstancia().getUsuarioActual().getImagenPerfilDirecta()));
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
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		contactosMiembros = new DefaultListModel<>();
		contactosNoMiembros = new DefaultListModel<>();

		btnAtras = new JButton("");
		btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtras.setPreferredSize(new Dimension(32, 32));
		btnAtras.setBackground(new Color(255, 255, 255));
		btnAtras.setIcon(
				new ImageIcon(VentanaModificarContacto.class.getResource("/imagenes/mod_boton-de-retroceso.png")));
		btnAtras.setSize(new Dimension(32, 32));
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAtras.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtras.gridx = 0;
		gbc_btnAtras.gridy = 0;
		panel.add(btnAtras, gbc_btnAtras);

		lblModificar = new JLabel("Modificar Grupo:");
		lblModificar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblModificar = new GridBagConstraints();
		gbc_lblModificar.gridwidth = 7;
		gbc_lblModificar.insets = new Insets(0, 0, 5, 0);
		gbc_lblModificar.gridx = 2;
		gbc_lblModificar.gridy = 1;
		panel.add(lblModificar, gbc_lblModificar);

		lblImagen = new JLabel("");
		lblImagen.setMinimumSize(new Dimension(10, 10));
		lblImagen.setSize(250, 250);

		try {
			BufferedImage image = ImageIO.read(getClass().getResource("/imagenes/gato_perfil.png"));
			lblImagen.setIcon(new ImageIcon(image));
			ImageInJLabel.resizeImage(lblImagen, image);
		} catch (IOException e) {
			e.printStackTrace();
		}

		gbc_lblImagen = new GridBagConstraints();
		gbc_lblImagen.gridwidth = 2;
		gbc_lblImagen.gridheight = 4;
		gbc_lblImagen.insets = new Insets(0, 0, 5, 5);
		gbc_lblImagen.gridx = 1;
		gbc_lblImagen.gridy = 2;
		panel.add(lblImagen, gbc_lblImagen);

		lblNombre = new JLabel("<html><span style='color:red;'>*</span>Nombre:</html>");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 3;
		gbc_lblNombre.gridy = 2;
		panel.add(lblNombre, gbc_lblNombre);

		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridwidth = 4;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.gridx = 4;
		gbc_textFieldNombre.gridy = 2;
		panel.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		textFieldNombre.setText(grupo.getNombre());

		lblMiembros = new JLabel("Miembros del grupo:");
		lblMiembros.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblMiembros = new GridBagConstraints();
		gbc_lblMiembros.gridwidth = 2;
		gbc_lblMiembros.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiembros.gridx = 3;
		gbc_lblMiembros.gridy = 3;
		panel.add(lblMiembros, gbc_lblMiembros);

		lblNoMiembros = new JLabel("Posibles nuevos miembros del grupo:");
		GridBagConstraints gbc_lblNoMiembros = new GridBagConstraints();
		gbc_lblNoMiembros.gridwidth = 2;
		gbc_lblNoMiembros.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoMiembros.gridx = 6;
		gbc_lblNoMiembros.gridy = 3;
		panel.add(lblNoMiembros, gbc_lblNoMiembros);

		scrollMiembros = new JScrollPane();
		scrollMiembros.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollMiembros = new GridBagConstraints();
		gbc_scrollMiembros.fill = GridBagConstraints.BOTH;
		gbc_scrollMiembros.gridwidth = 2;
		gbc_scrollMiembros.gridheight = 2;
		gbc_scrollMiembros.insets = new Insets(0, 0, 5, 5);
		gbc_scrollMiembros.gridx = 3;
		gbc_scrollMiembros.gridy = 4;

		panel.add(scrollMiembros, gbc_scrollMiembros);

		listMiembros = new JList<>(contactosMiembros);
		listMiembros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listMiembros.setCellRenderer(new ContactoCellRenderer());
		scrollMiembros.setViewportView(listMiembros);

		scrollNoMiembros = new JScrollPane();
		scrollNoMiembros.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollNoMiembros = new GridBagConstraints();
		gbc_scrollNoMiembros.fill = GridBagConstraints.BOTH;
		gbc_scrollNoMiembros.gridwidth = 2;
		gbc_scrollNoMiembros.gridheight = 2;
		gbc_scrollNoMiembros.insets = new Insets(0, 0, 5, 5);
		gbc_scrollNoMiembros.gridx = 6;
		gbc_scrollNoMiembros.gridy = 4;
		panel.add(scrollNoMiembros, gbc_scrollNoMiembros);

		listNoMiembros = new JList<>(contactosNoMiembros);
		listNoMiembros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listNoMiembros.setCellRenderer(new ContactoCellRenderer());
		scrollNoMiembros.setViewportView(listNoMiembros);

		textFieldImagen = new JTextField();
		GridBagConstraints gbc_textFieldImagen = new GridBagConstraints();
		gbc_textFieldImagen.gridwidth = 2;
		gbc_textFieldImagen.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldImagen.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldImagen.gridx = 1;
		gbc_textFieldImagen.gridy = 6;
		panel.add(textFieldImagen, gbc_textFieldImagen);
		textFieldImagen.setColumns(10);
		textFieldImagen.setText(grupo.getImagenRuta());

		lblEliminar = new JLabel("Selecciona un miembro para eliminarlo");
		GridBagConstraints gbc_lblEliminar = new GridBagConstraints();
		gbc_lblEliminar.gridwidth = 2;
		gbc_lblEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_lblEliminar.gridx = 3;
		gbc_lblEliminar.gridy = 6;
		panel.add(lblEliminar, gbc_lblEliminar);

		lblAnadir = new JLabel("Selecciona un miembro para añadirlo");
		GridBagConstraints gbc_lblAnadir = new GridBagConstraints();
		gbc_lblAnadir.gridwidth = 2;
		gbc_lblAnadir.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnadir.gridx = 6;
		gbc_lblAnadir.gridy = 6;
		panel.add(lblAnadir, gbc_lblAnadir);

		btnRestaurar = new JButton("Restaurar");
		btnRestaurar.setBackground(new Color(255, 255, 255));
		btnRestaurar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRestaurar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRestaurar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_btnRestaurar = new GridBagConstraints();
		gbc_btnRestaurar.fill = GridBagConstraints.VERTICAL;
		gbc_btnRestaurar.insets = new Insets(0, 0, 5, 5);
		gbc_btnRestaurar.gridx = 3;
		gbc_btnRestaurar.gridy = 8;
		panel.add(btnRestaurar, gbc_btnRestaurar);

		lblError = new JLabel("El campo nombre no puede estar vacío");
		lblError.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.gridwidth = 3;
		gbc_lblError.insets = new Insets(0, 0, 5, 5);
		gbc_lblError.gridx = 4;
		gbc_lblError.gridy = 8;
		panel.add(lblError, gbc_lblError);
		lblError.setVisible(false);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setBackground(new Color(255, 255, 255));
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAceptar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 7;
		gbc_btnAceptar.gridy = 8;
		panel.add(btnAceptar, gbc_btnAceptar);

		btnAceptar.addActionListener(this);
		btnAtras.addActionListener(this);
		btnRestaurar.addActionListener(this);
		listMiembros.addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				eliminarMiembro();
			}
		});

		listNoMiembros.addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				anadirMiembro();
			}
		});

		frmAppchat.setVisible(true);
		frmAppchat.setSize(tam);
		frmAppchat.setLocation(ubi);
		miembrosActualizados = grupo.getMiembros();
		actualizarContactosMiembros();
		actualizarContactosNoMiembros();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			if (textFieldNombre.getText().equals("")) {
				lblError.setVisible(true);
			} else {
				boolean igual = (grupo.getMiembros().size() > 0
						&& grupo.getMiembros().stream().allMatch(m -> miembrosActualizados.contains(m)));
				if (textFieldNombre.getText().equals(grupo.getNombre())
						&& textFieldImagen.getText().equals(grupo.getImagenRuta()) && igual) {
					lblError.setText("No se ha modificado el grupo");
					lblError.setVisible(true);
				} else {
					Controlador.getUnicaInstancia().modificarGrupo(grupo, textFieldNombre.getText(),
							textFieldImagen.getText(), miembrosActualizados);
					JOptionPane.showMessageDialog(frmAppchat, "Grupo modificado correctamente", "Enhorabuena",
							JOptionPane.PLAIN_MESSAGE);
					new VentanaContactos(frmAppchat.getSize(), frmAppchat.getLocation());
					frmAppchat.dispose();
				}
			}
			// PERSISTIR CAMBIOS MIEMBROS
		}
		if (e.getSource() == btnAtras) {
			new VentanaContactos(frmAppchat.getSize(), frmAppchat.getLocation());
			frmAppchat.dispose();
		}
		if (e.getSource() == btnRestaurar) {
			textFieldNombre.setText(grupo.getNombre());
			textFieldImagen.setText(grupo.getImagenRuta());
			actualizarContactosMiembros();
			actualizarContactosNoMiembros();
			lblError.setVisible(false);
		}

	}

	private void eliminarMiembro() {
		ContactoIndividual seleccionado = listMiembros.getSelectedValue();
		if (seleccionado != null) {
			miembrosActualizados.remove(seleccionado);
			contactosMiembros.removeElement(seleccionado);
			contactosNoMiembros.addElement(seleccionado);
			listMiembros.clearSelection(); // Limpia para evitar loops
		}
	}

	private void actualizarContactosMiembros() {
		grupo.getMiembros().stream().forEach(c -> contactosMiembros.addElement(c));
	}

	private void anadirMiembro() {
		ContactoIndividual seleccionado = listNoMiembros.getSelectedValue();
		if (seleccionado != null) {
			miembrosActualizados.add(seleccionado);
			contactosNoMiembros.removeElement(seleccionado);
			contactosMiembros.addElement(seleccionado);
			listNoMiembros.clearSelection(); // Limpia para evitar loops
		}
	}

	private void actualizarContactosNoMiembros() {
		Controlador.getUnicaInstancia().recuperarNoMiembros(grupo).stream()
				.forEach(c -> contactosNoMiembros.addElement(c));
	}
}
