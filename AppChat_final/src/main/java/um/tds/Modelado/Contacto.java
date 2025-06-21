package um.tds.Modelado;

public abstract class Contacto {
	private int id;
	private String nombre;

	public Contacto(String nombre) {
		this.nombre = nombre;
		this.id = 0; // Se actualizará al registrarse en la base de datos
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public abstract String getImagen();
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null || getClass() != obj.getClass())
	        return false;
	    Contacto other = (Contacto) obj;
	    // Si el id es mayor que 0, comparar por id (identidad única)
	    if (id > 0 && other.id > 0) {
	        return id == other.id;
	    }
	    // Si no, comparar por nombre
	    if (nombre == null) {
	        return other.nombre == null;
	    } else {
	        return nombre.equals(other.nombre);
	    }
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    if (id > 0) {
	        result = prime * result + id;
	    } else {
	        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
	    }
	    return result;
	}

}
