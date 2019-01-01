package clases;

public class Armas {

	private int id_armas;
	private String nombre;
	private int precio;
	private String danio;
	private String critico;
	private String distancia;
	private int peso;
	private String tipo_danio;
	private String artefacto;
	
	public Armas() {
		//constructor por defecto
	}

	public Armas(int id_armas, String nombre, int precio, String danio, String critico, String distancia, int peso,
			String tipo_danio, String artefacto) {
		this.id_armas = id_armas;
		this.nombre = nombre;
		this.precio = precio;
		this.danio = danio;
		this.critico = critico;
		this.distancia = distancia;
		this.peso = peso;
		this.tipo_danio = tipo_danio;
		this.artefacto = artefacto;
	}

	public int getId_armas() {
		return id_armas;
	}

	public void setId_armas(int id_armas) {
		this.id_armas = id_armas;
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

	public String getDanio() {
		return danio;
	}

	public void setDanio(String danio) {
		this.danio = danio;
	}

	public String getCritico() {
		return critico;
	}

	public void setCritico(String critico) {
		this.critico = critico;
	}

	public String getDistancia() {
		return distancia;
	}

	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getTipo_danio() {
		return tipo_danio;
	}

	public void setTipo_danio(String tipo_danio) {
		this.tipo_danio = tipo_danio;
	}

	public String getArtefacto() {
		return artefacto;
	}

	public void setArtefacto(String artefacto) {
		this.artefacto = artefacto;
	}

	@Override
	public String toString() {
		return "Armas [id_armas=" + id_armas + ", nombre=" + nombre + ", precio=" + precio + ", danio=" + danio
				+ ", critico=" + critico + ", distancia=" + distancia + ", peso=" + peso + ", tipo_danio=" + tipo_danio
				+ ", artefacto=" + artefacto + "]";
	}
	
	
}
