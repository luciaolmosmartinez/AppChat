package um.tds.Modelado;

public abstract class Contacto {
	private int id;
	private String nombre;

	public Contacto(String nombre) {
		this.nombre = nombre;
		this.id = 0;	//Se actualizará al registrarse en la base de datos
	}

	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}	
	
	public void setId() {
		this.id = id;
	}
}
