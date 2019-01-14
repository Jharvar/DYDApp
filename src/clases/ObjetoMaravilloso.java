package clases;

public class ObjetoMaravilloso {

	private int id_objeto_maravilloso;
	private String nombre;
	private int precio;
	private int peso;
	private String tipo_de_objeto;
	private String descripcion;
	
	public ObjetoMaravilloso() {
	}
	
	public ObjetoMaravilloso(int id_objeto_maravilloso, String nombre, int precio, int peso, String tipo_de_objeto,
			String descripcion) {
		this.id_objeto_maravilloso = id_objeto_maravilloso;
		this.nombre = nombre;
		this.precio = precio;
		this.peso = peso;
		this.tipo_de_objeto = tipo_de_objeto;
		this.descripcion = descripcion;
	}
	public int getId_objeto_maravilloso() {
		return id_objeto_maravilloso;
	}
	public void setId_objeto_maravilloso(int id_objeto_maravilloso) {
		this.id_objeto_maravilloso = id_objeto_maravilloso;
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
	public String getTipo_de_objeto() {
		return tipo_de_objeto;
	}
	public void setTipo_de_objeto(String tipo_de_objeto) {
		this.tipo_de_objeto = tipo_de_objeto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Nombre: "+ nombre + 
				"\nDescripcion: "+ descripcion +
				"\nPrecio: "+ precio+ "g" +
				"\nPeso: "+ peso +
				"\nTipo: "+ tipo_de_objeto +
				"\n Descripcion: \n"+
				descripcion;
	}
	public String getlistPrefix() {
		int p = getId_objeto_maravilloso();
		if(p < 10) {
			return "400"+ p;
		}else if(p <100) {
			return "40" + p;
		}else {
			return "4" + p;
		}
	}
	public String toStringHeadHtml() {
		return getlistPrefix()+ " - "+ nombre;
	}
	public String toStringTiendaListHtml() {
		return getlistPrefix()+ "-"+ nombre +" - "+ precio +"g\n";
	}
	
}
