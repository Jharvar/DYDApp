package clases;

public class ObjetoBasico {

	private int id_objetos;
	private String nombre;
	private int precio;
	private int peso;
	private String danio;
	private String curacion;
	private String descripcion;
	
	public ObjetoBasico() {
	}

	public ObjetoBasico(int id_objetos, String nombre, int precio, int peso, String danio, String curacion,
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
		return "Nombre: " + nombre + 
				"\nDescripcion: " + descripcion + 
				"\nPeso: "	+ peso + "lb" +
				"\nDanio: " + danio + 
				"\nCuracion: " + curacion +  
				"\nPrecio: " + precio + "g";
	}
	
	public String getlistPrefix() {
		int p = getId_objetos();
		if (p < 10) {
			return "300" + p;
		} else if (p < 100) {
			return "30" + p;
		} else {
			return "3" + p;
		}
	}
	
	public String toStringHeadHtml() { 
		return getlistPrefix() + " - " + nombre; 
	}
	
	public String toStringTiendaListHtml() { 
		return getlistPrefix() + "-" + nombre + " - " + precio + "g\n"; 
	}
}
