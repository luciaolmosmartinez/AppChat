package um.tds.Controlador;

import java.time.LocalDateTime;
import java.util.Date;

import um.tds.Modelado.Contacto;
import um.tds.Modelado.ContactoIndividual;
import um.tds.Modelado.CreadorPDF;
import um.tds.Modelado.Grupo;
import um.tds.Modelado.Mensaje;
import um.tds.Modelado.Usuario;
import um.tds.Persistencia.DAOException;
import um.tds.Persistencia.FactoriaDAO;
import um.tds.Persistencia.IAdaptadorContactoDAO;
import um.tds.Persistencia.IAdaptadorGrupoDAO;
import um.tds.Persistencia.IAdaptadorMensajeDAO;
import um.tds.Persistencia.IAdaptadorUsuarioDAO;
import um.tds.Repositorio.RepositorioUsuarios;

public class Controlador { // clase controlador

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

	public Controlador(RepositorioUsuarios repoU) {
		inicializarAdaptadores();
		this.repoU = repoU;
	}

	public void inicializarAdaptadores() {
		FactoriaDAO factoria = null;
		try {
			factoria = FactoriaDAO.getFactoriaDAO(FactoriaDAO.DAO_TDS);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		adaptadorUsuario = factoria.getUsuarioDAO();
		adaptadorMensaje = factoria.getMensajeDAO();
		adaptadorContacto = factoria.getContactoDAO();
		adaptadorGrupo = factoria.getGrupoDAO();
	}

	public boolean registrarUsuario(String nombre, String apellidos, String telefono, String correo, char[] contrasena,
			Date fecha, String saludo, String imagen) {
		Usuario usuario = new Usuario(nombre, apellidos, telefono, correo, contrasena, fecha, saludo, imagen);
		adaptadorUsuario.registrarUsuario(usuario);
		return repoU.addUsuario(usuario);
	}

	public void registrarMensaje(String texto, int emoticono, Usuario emisor, Usuario receptor) {
		Mensaje mensaje = new Mensaje(texto, emoticono, emisor, receptor);

		// Persistir mensaje
		adaptadorMensaje.registrarMensaje(mensaje);

		// Se recuperan los usuarios relaccionados con el mensaje y se les añade mensaje
		Usuario usuarioE = repoU.getUsuario(emisor.getNumTelefono());
		Usuario usuarioR = repoU.getUsuario(receptor.getNumTelefono());

		usuarioE.addMensajeEnviado(mensaje);
		usuarioR.addMensajeRecivido(mensaje);

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

	public void registrarGrupo(String nombre) {
		Grupo grupo = new Grupo(nombre);

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
	public void enviarMensaje(String texto, int emoticono, Usuario... receptor) {
		usuarioActual.enviarMensaje(texto, emoticono, receptor);
	}

	public void crearPDF() {
		CreadorPDF.crearPDF();
	}
}
