package um.tds.Controlador;

import java.time.LocalDate;
import java.util.List;

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
	private String contactoActual;
	private TipoReceptor tReceptor;

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

	public boolean registrarUsuario(String nombre, String telefono, String correo, char[] contrasena, LocalDate fecha,
			String saludo, String imagen) {
		Usuario usuario = new Usuario(nombre, telefono, correo, contrasena, fecha, saludo, imagen);
		adaptadorUsuario.registrarUsuario(usuario);
		return repoU.addUsuario(usuario);
	}

	public void registrarMensaje(String texto, int emoticono) {
		Mensaje mensaje; // el emisor será el usuario actual, el receptor será el contacto actual,
							// tambien se guardara si es un grupo o no
		mensaje = new Mensaje(texto, emoticono, usuarioActual.getNumTelefono(), contactoActual, tReceptor);

		// Persistir mensaje
		adaptadorMensaje.registrarMensaje(mensaje);

		// Se recuperan los usuarios relaccionados con el mensaje y se les añade mensaje
		Usuario usuarioE = repoU.getUsuario(usuarioActual.getNumTelefono());
		Usuario usuarioR;
		usuarioE.addMensaje(mensaje);
		adaptadorUsuario.modificarUsuario(usuarioE); // Actualizar usuario almacenado
		if (tReceptor.equals(TipoReceptor.ID_GRUPO)) {
			Grupo g = recuperarGrupo(Integer.parseInt(contactoActual));
			for (ContactoIndividual c : g.getMiembros()) {
				usuarioR = c.getUsuario();
				usuarioR.addMensaje(mensaje);
				adaptadorUsuario.modificarUsuario(usuarioR); // Actualizar usuario almacenado
			}

		}

	}

	public void registrarContacto(String numTelefono, String nombre) {
		Usuario usuario = recuperarUsuarioTelefono(numTelefono);
		
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

	public Grupo recuperarGrupo(int id) {
		return AdaptadorGrupo.getUnicaInstancia().recuperarGrupo(id);
	}

	public Usuario recuperarUsuarioTelefono(String numTelefono) {
		return AdaptadorUsuario.getUnicaInstancia().recuperarUsuarioTelefono(numTelefono);
	}

	public Contacto recuperarContacto(int id) {
		return AdaptadorContacto.getUnicaInstancia().recuperarContacto(id);
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
		// repoU.addMensaje(mensaje);
	}

	public void crearPDF() {
		CreadorPDF.crearPDF();
	}

	public Contacto recuperarContactoMensaje(Mensaje mensaje) {
		if (mensaje.getEmisor().equals(usuarioActual.getNumTelefono())) { // quiero recuperar el contacto al que se lo
																			// he enviado
			if (mensaje.getTipoReceptor().equals(TipoReceptor.ID_GRUPO)) { // es un grupo
				return recuperarGrupo(Integer.parseInt(mensaje.getReceptor()));
			} else { // es un contacto individual
				Usuario u = recuperarUsuarioTelefono(mensaje.getReceptor());
				return recuperarContacto(u.getId());
			}
		} else { // quiero recuperar el contacto que me lo ha enviado
			Usuario u = recuperarUsuarioTelefono(mensaje.getEmisor());
			return recuperarContacto(u.getId());
		}
	}

	public List<Mensaje> getUltimosMensajes() {
		return usuarioActual.getUltimosMensajes();
	}
	
	public String recuperarOtroUsuario(Mensaje mensaje) {
		if (mensaje.getEmisor().equals(usuarioActual.getNumTelefono())) {
			return mensaje.getReceptor();
		} else {
			return mensaje.getEmisor();
		}
	}
	
	public boolean isContacto(Mensaje mensaje) {
		return usuarioActual.isContacto(recuperarOtroUsuario(mensaje));
	}
}
