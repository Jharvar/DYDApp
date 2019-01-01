package clases;

public class Armaduras {

	private int id_armaduras;
	private String nombre;
	private int precio;
	private int boni_CA;
	private int boni_defensa;
	private int penalizador;
	private String fallo_conjuro;
	private String velocidad;
	private String peso;
	public Armaduras(int id_armaduras, String nombre, int precio, int boni_CA, int boni_defensa, int penalizador,
			String fallo_conjuro, String velocidad, String peso) {
		
		this.id_armaduras = id_armaduras;
		this.nombre = nombre;
		this.precio = precio;
		this.boni_CA = boni_CA;
		this.boni_defensa = boni_defensa;
		this.penalizador = penalizador;
		this.fallo_conjuro = fallo_conjuro;
		this.velocidad = velocidad;
		this.peso = peso;
	}
	public int getId_armaduras() {
		return id_armaduras;
	}
	public void setId_armaduras(int id_armaduras) {
		this.id_armaduras = id_armaduras;
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
	public int getBoni_CA() {
		return boni_CA;
	}
	public void setBoni_CA(int boni_CA) {
		this.boni_CA = boni_CA;
	}
	public int getBoni_defensa() {
		return boni_defensa;
	}
	public void setBoni_defensa(int boni_defensa) {
		this.boni_defensa = boni_defensa;
	}
	public int getPenalizador() {
		return penalizador;
	}
	public void setPenalizador(int penalizador) {
		this.penalizador = penalizador;
	}
	public String getFallo_conjuro() {
		return fallo_conjuro;
	}
	public void setFallo_conjuro(String fallo_conjuro) {
		this.fallo_conjuro = fallo_conjuro;
	}
	public String getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(String velocidad) {
		this.velocidad = velocidad;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "Armaduras [id_armaduras=" + id_armaduras + ", nombre=" + nombre + ", precio=" + precio + ", boni_CA="
				+ boni_CA + ", boni_defensa=" + boni_defensa + ", penalizador=" + penalizador + ", fallo_conjuro="
				+ fallo_conjuro + ", velocidad=" + velocidad + ", peso=" + peso + "]";
	}
	
	
}
