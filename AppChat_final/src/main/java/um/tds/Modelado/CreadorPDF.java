package um.tds.Modelado;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import um.tds.Controlador.Controlador;

public class CreadorPDF {
	private static final int TAMAÑO_TITULO = 32;
	private static final String EXTENSION = ".pdf";
	private static final String TITULO_PDF_1 = "Contactos añadidos en AppChat de ";
	private static final String TITULO_PDF_2 = "Conversación en AppChat entre ";
	private static final String MENSAJE_CONTACTOS = "Listado de contactos individuales:";
	private static final String MENSAJE_GRUPOS = "Listado de grupos:";

	public CreadorPDF() {
	}

	// Para crear el documento con los contactos
	public boolean createPdfContactos(Usuario usuario, Path ruta) {
		FileOutputStream archivo = null;
		try {
			archivo = new FileOutputStream(ruta + EXTENSION);

			Document documento = new Document();

			PdfWriter.getInstance(documento, archivo);

			documento.open();

			agregarTitulo(documento, usuario.getNombre());
			documento.add(new Paragraph(MENSAJE_CONTACTOS));
			agregarListadoContactos(documento, usuario.getContactosIndividuales());
			documento.add(new Paragraph(MENSAJE_GRUPOS));
			agregarListadoGrupos(documento, usuario.getContactosGrupos());

			documento.close();
			return true;

		} catch (IOException | DocumentException e) {
			return false;
		}
	}

	private void agregarTitulo(Document documento, String nombreUsuario) throws IOException, DocumentException {
		// Crear fuente en negrita (HELVETICA_BOLD) con tamaño definido
		Font fuenteTitulo = new Font(Font.FontFamily.HELVETICA, TAMAÑO_TITULO, Font.BOLD);

		// Crear el párrafo del título con esa fuente
		Paragraph titulo = new Paragraph(TITULO_PDF_1 + nombreUsuario, fuenteTitulo);
		titulo.setAlignment(Paragraph.ALIGN_CENTER);

		// Agregar contenido al documento
		documento.add(titulo);
	}

	//Version para contacto individual
	private void agregarListadoContactos(Document documento, List<ContactoIndividual> contactos) {
		AtomicInteger contador = new AtomicInteger(1);
		contactos.forEach(contacto -> {
			Paragraph p = new Paragraph(contador.getAndIncrement() + ". " + contacto.getNombre() + ": "
					+ contacto.getUsuario().getNumTelefono());
			try {
				documento.add(p);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		});
	}

	//Version para grupo
	private void agregarListadoGrupos(Document documento, List<Grupo> grupos) {
		AtomicInteger contador = new AtomicInteger(1);
		grupos.forEach(grupo -> {
			Paragraph p = new Paragraph(contador.getAndIncrement() + ". " + grupo.getNombre() + ":\n");
			grupo.getMiembros().forEach(miembro -> {
				p.add("  - " + miembro.getNombre() + ": " + miembro.getUsuario().getNumTelefono() + "\n");
			});
			try {
				documento.add(p);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		});
	}

	// Para crear el documento con la conversacion
	public boolean createPdfMensajes(Usuario usuario, Contacto contacto, Usuario otro, Path ruta) {
		FileOutputStream archivo = null;
		try {
			archivo = new FileOutputStream(ruta + EXTENSION);

			Document documento = new Document();

			PdfWriter.getInstance(documento, archivo);

			documento.open();

			if (contacto == null) { // entras si es un usuario no registrado

				agregarTitulo2(documento, usuario.getNombre(), otro.getNumTelefono());

				// Ordenar los mensajes por fecha (de más antiguo a más reciente)
				List<Mensaje> mensajesOrdenados = usuario.getMensajes().get(otro.getNumTelefono()).stream()
						.sorted((m1, m2) -> m1.getFechaHora().compareTo(m2.getFechaHora())) // Ordenar por
																							// fecha
						.collect(Collectors.toList());

				// Añadir los mensajes al PDF, cada mensaje en una línea
				for (Mensaje mensaje : mensajesOrdenados) {
					String contenidoMensaje;
					Paragraph parrafo;

					if (mensaje.getEmisor().equals(usuario.getNumTelefono())) {
						if (mensaje.getTexto() == "") {
							contenidoMensaje = String.format("%s (%s): %s", usuario.getNombre(),
									mensaje.getFechaHora().toString(), mensaje.getEmoticono());
						} else {
							contenidoMensaje = String.format("%s (%s): %s", usuario.getNombre(),
									mensaje.getFechaHora().toString(), mensaje.getTexto());
						}
						parrafo = new Paragraph(contenidoMensaje);
						parrafo.setAlignment(Element.ALIGN_RIGHT); // Alinear a la derecha
					} else {
						if (mensaje.getTexto() == "") {
							contenidoMensaje = String.format("%s (%s): %s", mensaje.getEmisor(),
									mensaje.getFechaHora().toString(), mensaje.getEmoticono());
						} else {
							contenidoMensaje = String.format("%s (%s): %s", mensaje.getEmisor(),
									mensaje.getFechaHora().toString(), mensaje.getTexto());
						}
						parrafo = new Paragraph(contenidoMensaje);
						parrafo.setAlignment(Element.ALIGN_LEFT); // Alinear a la izquierda
					}

					documento.add(parrafo);
				}
			} else { // para contactos individuales y grupos
				agregarTitulo2(documento, usuario.getNombre(), contacto.getNombre());

				List<Mensaje> mensajesOrdenados;

				if (contacto instanceof ContactoIndividual) {
					// Ordenar los mensajes por fecha (de más antiguo a más reciente)
					mensajesOrdenados = usuario.getMensajes()
							.get(((ContactoIndividual) contacto).getUsuario().getNumTelefono()).stream()
							.sorted((m1, m2) -> m1.getFechaHora().compareTo(m2.getFechaHora())) // Ordenar por
																								// fecha
							.collect(Collectors.toList());
				} else {
					// Ordenar los mensajes por fecha (de más antiguo a más reciente)
					mensajesOrdenados = usuario.getMensajes().get(Integer.toString(contacto.getId())).stream()
							.sorted((m1, m2) -> m1.getFechaHora().compareTo(m2.getFechaHora())) // Ordenar por
																								// fecha
							.collect(Collectors.toList());
				}
				// Añadir los mensajes al PDF, cada mensaje en una línea
				for (Mensaje mensaje : mensajesOrdenados) {
					String contenidoMensaje;
					Paragraph parrafo;

					if (mensaje.getEmisor().equals(usuario.getNumTelefono())) { // mensaje enviado
						if (mensaje.getTexto() == "") {
							contenidoMensaje = String.format("%s (%s): %s", usuario.getNombre(),
									mensaje.getFechaHora().toString(), mensaje.getEmoticono());
						} else {
							contenidoMensaje = String.format("%s (%s): %s", usuario.getNombre(),
									mensaje.getFechaHora().toString(), mensaje.getTexto());
						}

						parrafo = new Paragraph(contenidoMensaje);
						parrafo.setAlignment(Element.ALIGN_RIGHT); // Alinear a la derecha
					} else { // mensaje recibido (solo seran contactos individuales)
						Contacto c = Controlador.getUnicaInstancia().recuperarContactoMensaje(mensaje);
						contenidoMensaje = String.format("%s (%s): %s", c.getNombre(),
								mensaje.getFechaHora().toString(), mensaje.getTexto());
						parrafo = new Paragraph(contenidoMensaje);
						parrafo.setAlignment(Element.ALIGN_LEFT); // Alinear a la izquierda
					}
					documento.add(parrafo);
				}
			}
			documento.close();
			return true;

		} catch (IOException | DocumentException e) {
			return false;
		}
	}

	private void agregarTitulo2(Document documento, String nombreUsuario, String nombreOtroUsuario)
			throws IOException, DocumentException {
		// Crear fuente en negrita (HELVETICA_BOLD) con tamaño definido
		Font fuenteTitulo = new Font(Font.FontFamily.HELVETICA, TAMAÑO_TITULO, Font.BOLD);

		// Crear el párrafo del título con esa fuente
		Paragraph titulo = new Paragraph(TITULO_PDF_2 + nombreUsuario + " y " + nombreOtroUsuario, fuenteTitulo);
		titulo.setAlignment(Paragraph.ALIGN_CENTER);

		// Agregar contenido al documento
		documento.add(titulo);
	}

}