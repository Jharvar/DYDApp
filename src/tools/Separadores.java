package tools;

import java.io.File;
import java.util.StringTokenizer;

public class Separadores {

	//atributos de la clase
	StringTokenizer token_separador;
	
	public Separadores() {
		//constructor por defecto
	}
	
	/**
	 * Constructor parametrizado
	 * recibe la ruta del fichero en cuestion y el separador en este caso
	 * @param ruta
	 * @param separador
	 */
	public Separadores(String ruta, String separador) {
		token_separador = new StringTokenizer(ruta, separador);
	}
	/**
	 * 
	 * @return String
	 * Metodo que cambia la ruta de un fichero o directorio 
	 * de Windows a Linux y viceversa
	 */
	public String cambiarRuta() {
		String nuevaRuta ="";
		while(token_separador.hasMoreTokens()) {
			nuevaRuta+=token_separador.nextToken()+File.separator;
		}
		return nuevaRuta;
	}
}
