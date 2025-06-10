package um.tds.Modelado;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import tds.BubbleText;

public class Mensaje {
	private int id;
	private String texto; // null si hay emoticono y no texto?
	private int emoticono; // se determinara a partir de un numero que identifica el emoticono, null si no
							// hay emoticono?
	private Usuario emisor;
	private List<Usuario> receptor;
	private LocalDateTime fechaHora;

	public int getLength() {
		return this.texto.length();
	}

	/*public Mensaje(String texto, Usuario emisor, Usuario receptor) {
		this(texto, -1, emisor, receptor);
	}

	public Mensaje(int emoticono, Usuario emisor, Usuario receptor) {
		this("", emoticono, emisor, receptor);
	}*/

	public Mensaje(String texto, int emoticono, Usuario emisor, Usuario...receptores) {
		this.texto = texto;
		this.emoticono = emoticono;
		this.emisor = emisor;
		this.receptor = new LinkedList<Usuario>();
		for (Usuario u : receptores) {
			receptor.add(u);
		}
		this.fechaHora = LocalDateTime.now();
		this.id = 0;	//Se actualizará al registrarse en la base de datos
	}

	public int getId() {
		return id;
	}
	
	public String getTexto() {
		return texto;
	}

	public int getEmoticono() {
		return emoticono;
	}

	public Usuario getEmisor() {
		return emisor;
	}

	public List<Usuario> getReceptor() {
		return new LinkedList<Usuario>(receptor);
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setEmoticono(int emoticono) {
		this.emoticono = emoticono;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public void setEmisor(Usuario emisor) {
		this.emisor = emisor;
	}

	public void addReceptor(Usuario receptor) {
		this.receptor.add(receptor);
	}

	public Mensaje enviarMensaje(String texto, int emoticono, Usuario emisor, Usuario...receptor) {
		Mensaje mensaje = new Mensaje(texto, emoticono, emisor, receptor);
		return mensaje;
	}

}
