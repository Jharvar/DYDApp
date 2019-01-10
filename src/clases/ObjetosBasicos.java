package clases;

public class ObjetosBasicos {

	private int id_objetos;
	private String nombre;
	private int precio;
	private int peso;
	private String danio;
	private String curacion;
	private String descripcion;
	
	public ObjetosBasicos() {
		//constructor por defecto
	}

	public ObjetosBasicos(int id_objetos, String nombre, int precio, int peso, String danio, String curacion,
			String descripcion) {
		this.id_objetos = id_objetos;
		this.nombre = nombre;
		this.precio = precio;
		this.peso = peso;
		this.danio = danio;
		this.curacion = curacion;
		this.descripcion = descripcion;
	}

	public int getId_objetos() {
		return id_objetos;
	}

	public void setId_objetos(int id_objetos) {
		this.id_objetos = id_objetos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getDanio() {
		return danio;
	}

	public void setDanio(String danio) {
		this.danio = danio;
	}

	public String getCuracion() {
		return curacion;
	}

	public void setCuracion(String curacion) {
		this.curacion = curacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "ObjetosBasicos [id_objetos=" + id_objetos + ", nombre=" + nombre + ", precio=" + precio + ", peso="
				+ peso + ", danio=" + danio + ", curacion=" + curacion + ", descripcion=" + descripcion + "]";
	}
	
	public String toStringTiendaListHtml(String fix) { 
		return fix + id_objetos + "-" + nombre + " - " + precio + "g\n"; 
	}
}
