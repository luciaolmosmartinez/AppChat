package modelado;

import java.time.LocalDateTime;
import tds.BubbleText;

public class Mensaje {
	private String texto; // null si hay emoticono y no texto?
	private int emoticono; // se determinara a partir de un numero que identifica el emoticono, null si no
							// hay emoticono?
	private Usuario emisor;
	private Usuario receptor;
	private LocalDateTime fechaHora;

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

}
