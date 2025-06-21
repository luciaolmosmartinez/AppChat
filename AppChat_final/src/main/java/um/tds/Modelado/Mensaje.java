package um.tds.Modelado;

import java.time.LocalDateTime;

public class Mensaje {
	private int id;
	private String texto; // null si hay emoticono y no texto?
	private int emoticono; // se determinara a partir de un numero que identifica el emoticono, null si no
							// hay emoticono?
	private String emisor; //numero de telefono
	private String receptor; //numero de telefono de quien lo reciba o id del grupo al que se manda
	private LocalDateTime fechaHora;
	private TipoReceptor tipoReceptor;
	
	public int getLength() {
		return this.texto.length();
	}

	/*public Mensaje(String texto, Usuario emisor, Usuario receptor) {
		this(texto, -1, emisor, receptor);
	}

	public Mensaje(int emoticono, Usuario emisor, Usuario receptor) {
		this("", emoticono, emisor, receptor);
	}*/

	public Mensaje(String texto, int emoticono, String emisor, String receptor, TipoReceptor tipoReceptor) {
		this.texto = texto;
		this.emoticono = emoticono;
		this.emisor = emisor;
		this.receptor = receptor;
		this.fechaHora = LocalDateTime.now();
		this.tipoReceptor = tipoReceptor;
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

	public String getEmisor() {
		return emisor;
	}

	public String getReceptor() {
		return receptor;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public TipoReceptor getTipoReceptor() {
		return tipoReceptor;
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

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	public void setTipoReceptor(TipoReceptor tipoReceptor) {
		this.tipoReceptor = tipoReceptor;
	}

	/*public Mensaje enviarMensaje(String texto, int emoticono, String emisor, String receptor, TipoReceptor tipoReceptor) {
		Mensaje mensaje = new Mensaje(texto, emoticono, emisor, receptor, tipoReceptor);
		return mensaje;
	}*/

}
