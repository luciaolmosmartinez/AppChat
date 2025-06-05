package um.tds.Controlador;

import java.time.LocalDateTime;
import java.util.Date;

import um.tds.Modelado.Contacto;
import um.tds.Modelado.CreadorPDF;
import um.tds.Modelado.Usuario;
import um.tds.Persistencia.DAOException;
import um.tds.Persistencia.FactoriaDAO;
import um.tds.Persistencia.IAdaptadorContactoDAO;
import um.tds.Persistencia.IAdaptadorGrupoDAO;
import um.tds.Persistencia.IAdaptadorMensajeDAO;
import um.tds.Persistencia.IAdaptadorUsuarioDAO;
import um.tds.Repositorio.RepositorioUsuarios;
import umu.tds.appchat.controllers.ControladorAppChat;

public class AppChat { // clase controlador

	private IAdaptadorUsuarioDAO adaptadorUsuario;
	private IAdaptadorMensajeDAO adaptadorMensaje;
	private IAdaptadorContactoDAO adaptadorContacto;
	private IAdaptadorGrupoDAO adaptadorGrupo;

	private Usuario usuarioActual;
	private RepositorioUsuarios repoU;

	/*
	 * private static ControladorAppChat unicaInstancia; private FactoriaDAO
	 * factoriaDAO; private Contacto contactoSeleccionado;
	 */

	public AppChat(RepositorioUsuarios repoU) {
		inicializarAdaptadores();
		this.repoU = repoU;
	}

	public void inicializarAdaptadores() {
		FactoriaDAO factoria = null;
		try {
			factoria = FactoriaDAO.getFactoriaDAO(FactoriaDAO.PERSIST_TDS);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		adaptadorUsuario = factoria.getUsuarioDAO();
		adaptadorMensaje = factoria.getMensajeDAO();
		adaptadorContacto = factoria.getContactoDAO();
		adaptadorGrupo = factoria.getGrupoDAO();
	}

	public void registrarMensaje(String telefono, LocalDateTime fechaHora) {
		Usuario usuario = repoU.getUsuario(telefono);
		ventaActual.setCliente(cliente);
		mensaje.setFechaHora(fechaHora);
		cliente.addVenta(ventaActual);
		adaptadorVenta.registrarVenta(ventaActual);
		repoVentas.addVenta(ventaActual);
		adaptadorCliente.modificarCliente(cliente);
	}

	public void registrarContacto(String auxDni, String auxNombre) {
		Cliente cliente = new Cliente(auxDni, auxNombre);
		adaptadorCliente.registrarCliente(cliente);
		catalogoClientes.addCliente(cliente);
	}

	public void registrarUsuario(String nombre, String apellidos, String telefono, String correo, char[] contrasena,
			Date fecha, String saludo, String imagen) {
		Usuario usuario = new Usuario(nombre, apellidos, telefono, correo, contrasena, fecha, saludo, imagen);
		adaptadorUsuario.registrarUsuario(usuario);
		repoU.addUsuario(usuario);
	}

	public void registrarGrupo(double precio, String nombre, String descripcion) {
		Producto producto = new Producto(precio, nombre, descripcion);
		adaptadorProducto.registrarProducto(producto);
		repoProductos.add(producto);
	}

	public void crearVenta(Date fecha) {
		ventaActual = new Venta(fecha);
	}

	public void añadirLineaVenta(int unidades, int idProducto) {
		ventaActual.addLineaVenta(unidades, producto);
	}

	// Métodos nuestros antiguos
	public boolean crearUsuario(String nombre, String apellidos, String telefono, String correo, char[] contrasena,
			Date fecha, String saludo, String imagen) {
		Usuario usuario = new Usuario(nombre, apellidos, telefono, correo, contrasena, fecha, saludo, imagen);
		return repoU.crearUsuario(usuario);
	}

	public boolean iniciarSesion(String telefono, char[] contrasena) {
		this.usuarioActual = repoU.comprobarUsuario(telefono, contrasena);
		if (usuarioActual != null) {
			return true;
		} else {
			return false;
		}
	}

	public Usuario getUsuarioActual() {
		return usuarioActual;
	}

	public void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}

	public void enviarMensaje(Contacto receptor, String texto, int emoticono) {
		usuarioActual.enviarMensaje(receptor, texto, emoticono, usuarioActual);
	}

	public void crearPDF() {
		CreadorPDF.crearPDF();
	}
}
