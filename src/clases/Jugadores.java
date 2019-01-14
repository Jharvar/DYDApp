package clases;

public class Jugadores {
	
	//Atributos de la clase
	private int idPersonaje;
	private String npersonaje;
	private String clase;
	private String dinero;
	/**
	 * 
	 * @param idPersonaje
	 * @param npersonaje
	 * @param clase
	 * @param dinero
	 */
	public Jugadores(int idPersonaje, String npersonaje, String clase, String dinero) {
		this.idPersonaje = idPersonaje;
		this.npersonaje = npersonaje;
		this.clase = clase;
		this.dinero = dinero;
	}
	public int getIdPersonaje() {
		return idPersonaje;
	}
	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}
	public String getNpersonaje() {
		return npersonaje;
	}
	public void setNpersonaje(String npersonaje) {
		this.npersonaje = npersonaje;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public String getDinero() {
		return dinero;
	}
	public void setDinero(String dinero) {
		this.dinero = dinero;
	}
	@Override
	public String toString() {
		return "UsuarioPersonaje [idPersonaje=" + idPersonaje + ", npersonaje=" + npersonaje + ", clase=" + clase
				+ ", dinero=" + dinero + "]";
	}
}
