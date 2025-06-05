package um.tds.Modelado;

import java.time.LocalDateTime;
import tds.BubbleText;

public class Mensaje {
	private int id;
	private String texto; // null si hay emoticono y no texto?
	private int emoticono; // se determinara a partir de un numero que identifica el emoticono, null si no
							// hay emoticono?
	private Usuario emisor;
	private Usuario receptor;
	private LocalDateTime fechaHora;

	public int getLength() {
		return this.texto.length();
	}

	public Mensaje(String texto, Usuario emisor, Usuario receptor) {
		this(texto, -1, emisor, receptor);
	}

	public Mensaje(int emoticono, Usuario emisor, Usuario receptor) {
		this("", emoticono, emisor, receptor);
	}

	public Mensaje(String texto, int emoticono, Usuario emisor, Usuario receptor) {
		this.texto = texto;
		this.emoticono = emoticono;
		this.emisor = emisor;
		this.receptor = receptor;
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

	public Usuario getReceptor() {
		return receptor;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Mensaje enviarMensaje(Contacto receptor, String texto, int emoticono, Usuario emisor) {
		Mensaje mensaje = new Mensaje(texto, emoticono, emisor, emisor);
		return mensaje;
	}

}
