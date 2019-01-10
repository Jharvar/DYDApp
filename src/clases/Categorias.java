package clases;

public class Categorias {

	private int id_categoria;
	private String nombre_categoria;
	private int id_objetos;
	
	public Categorias(int id_categoria, String nombre_categoria, int id_objetos) {
		this.id_categoria = id_categoria;
		this.nombre_categoria = nombre_categoria;
		this.id_objetos = id_objetos;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNombre_categoria() {
		return nombre_categoria;
	}

	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}

	public int getId_objetos() {
		return id_objetos;
	}

	public void setId_objetos(int id_objetos) {
		this.id_objetos = id_objetos;
	}

	@Override
	public String toString() {
		return "Categorias [id_categoria=" + id_categoria + ", nombre_categoria=" + nombre_categoria + ", id_objetos="
				+ id_objetos + "]";
	}
	
	public String toStringTienda() { 
		return id_categoria + " - " + nombre_categoria; 
	}
	public String toStringTiendaHtml() { 
		return id_categoria + " - " + nombre_categoria + "\n"; 
	}
}