package um.tds.Controlador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import um.tds.Modelado.*;
import um.tds.Persistencia.*;
import um.tds.Repositorio.RepositorioUsuarios;

public class Controlador { // clase controlador
	private static Controlador unicaInstancia;
	
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
// DICE QUE LOS FILTROS EN EL CONTROLADOR USANDO LOS ADAPTADORES, NO EN EL REPOSITORIO
	
	private Controlador() {
		this.inicializarAdaptadores();
		this.inicializarRepositorioUsuarios();
	}
	
	public static Controlador getUnicaInstancia() {
		if (unicaInstancia == null)
			unicaInstancia = new Controlador();
		return unicaInstancia;
	}

	public void inicializarAdaptadores() {
		FactoriaDAO factoria = null;
		try {
			factoria = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		adaptadorUsuario = factoria.getUsuarioDAO();
		adaptadorMensaje = factoria.getMensajeDAO();
		adaptadorContacto = factoria.getContactoDAO();
		adaptadorGrupo = factoria.getGrupoDAO();
	}
	
	private void inicializarRepositorioUsuarios() {
		try {
	        repoU = RepositorioUsuarios.getUnicaInstancia();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public boolean registrarUsuario(String nombre, String telefono, String correo, char[] contrasena,
			LocalDate fecha, String saludo, String imagen) {
		Usuario usuario = new Usuario(nombre, telefono, correo, contrasena, fecha, saludo, imagen);
		adaptadorUsuario.registrarUsuario(usuario);
		return repoU.addUsuario(usuario);
	}

	public void registrarMensaje(String texto, int emoticono, String emisor, String receptor, TipoReceptor tipoReceptor) {
		Mensaje mensaje = new Mensaje(texto, emoticono, emisor, receptor, tipoReceptor);

		// Persistir mensaje
		adaptadorMensaje.registrarMensaje(mensaje);

		// Se recuperan los usuarios relaccionados con el mensaje y se les añade mensaje
		Usuario usuarioE = repoU.getUsuario(emisor);
		Usuario usuarioR = repoU.getUsuario(receptor);

		usuarioE.addMensaje(mensaje);
		usuarioR.addMensaje(mensaje);

		// Actualizar usuario almacenado
		adaptadorUsuario.modificarUsuario(usuarioE);
		adaptadorUsuario.modificarUsuario(usuarioR);
	}

	public void registrarContacto(Usuario usuario, String nombre) {
		ContactoIndividual contacto = new ContactoIndividual(usuario, nombre);

		// Persistir contacto
		adaptadorContacto.anadirContacto(contacto);

		// Se añade el contacto al usuario que lo crea
		usuarioActual.addContacto(contacto);

		// Actualizar usuario almacenado
		adaptadorUsuario.modificarUsuario(usuarioActual);
	}

	public void registrarGrupo(String nombre, String imagen) {
		Grupo grupo = new Grupo(nombre, imagen);

		// Persistir grupo
		adaptadorGrupo.registrarGrupo(grupo);

		// Se añade el grupo al usuario que lo crea
		usuarioActual.addGrupo(grupo);

		// Actualizar usuario almacenado
		adaptadorUsuario.modificarUsuario(usuarioActual);
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

	// Funciones antiguas
	public void enviarMensaje(String texto, int emoticono, String receptor, TipoReceptor tipoReceptor) {
		Mensaje mensaje = usuarioActual.enviarMensaje(texto, emoticono, receptor, tipoReceptor);
		adaptadorMensaje.registrarMensaje(mensaje);
		//repoU.addMensaje(mensaje);
	}

	public void crearPDF() {
		CreadorPDF.crearPDF();
	}
}
