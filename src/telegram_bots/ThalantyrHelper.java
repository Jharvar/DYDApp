package telegram_bots;

import java.sql.SQLException;
import java.util.ArrayList;
import clases.Categorias;
import db.DB_Tienda;
import javassist.expr.NewArray;

public class ThalantyrHelper {

	private DB_Tienda tiendaDB = new DB_Tienda();

	/*
	 * CMD /tienda
	 */
	public String CMDtienda(long chat_id, ArrayList<String> userInput) {

		// /tienda (Sin argumento)
		if (userInput.size() == 1) {
			return getCategories(chat_id, userInput);
		}

		// /tienda con argumento.
		else if (userInput.size() == 2) {

			// Argumento de un digito *id_categoria
			if (userInput.get(1).length() == 1) {
				return "";
				// getCategory(chat_id, userInput.get(1));
			}

			// Argumento de 4 digitos *id_categoria(1) + *id_objeto(3)
			else if (userInput.get(1).length() == 4) {
				return getObject(chat_id, userInput.get(1));
			}

			// Argumentdo distinto a 1 o 4 (length)
			else {
				return null;
				// enviarError(chat_id);
			}
		} else {
			return null;
			// enviarError(chat_id);
		}
	}

	/*
	 * Muestra listado de categorias.
	 */
	public String getCategories(long chat_id, ArrayList<String> userInput) {
		String msj = "";
		try {
			ArrayList<Categorias> categorias = tiendaDB.keepCategories();
			for (Categorias c : categorias) {
				msj += c.toStringTiendaHtml();
			}
			// enviarMensaje(chat_id, msj);
			return msj;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * Muestra lista de objetos de una categoria.
	 */
	public String getCategory(long chat_id, String userString) {
		// Quizas se pueda mandar cualquier entero y si la bd nos da null
		// prescindir es estas comprobaciones...
		// int[] catAvaliable = { 1, 2, 3, 4 };
		Integer catSelected = getCodeCategoria(userString);
		if (catSelected == 0)
			return null;
		switch (catSelected) {
		case 1:
			//tiendaDB.keepObjects(catSelected);
			
			return "Categoria 1";
		case 2:
			return "Categoria 2";
		case 3:
			return "Categoria 3";

		default:
			return "Categoria erronea";
		}
		// ArrayList<Integer> categoriesDB = getAvaliableCategories();

		

	}
	
	public String getArmaString() {
		//tiendaDB.keepObjects(1);
		
		return null;
	}
	/*
	 * try { // Se pilla el int de categoria int c =
	 * Integer.parseInt(userString.charAt(0) + "");
	 * 
	 * // Se comprueba si esta dentro de las categorias disponibles for (int i = 0;
	 * i < catAvaliable.length; i++) { if (c == (i + 1)) { return ""; } } return "";
	 * } catch (NumberFormatException e) { return ""; } } }
	 */

	public ArrayList<Integer> getAvaliableCategories() {
		try {
			ArrayList<Integer> outList = new ArrayList<>();

			ArrayList<Categorias> c = tiendaDB.keepCategories();
			for (Categorias catObj : c) {
				outList.add(catObj.getId_categoria());
				System.out.println(catObj.getNombre_categoria() + " added to avaliables");
			}
		} catch (SQLException e) {

		}

		return null;

	}

	/*
	 * Muestra un objeto concreto
	 */
	private String getObject(long chat_id, String inputCode) {
		int[] codeArray = new int[2];
		codeArray[0] = getCodeCategoria(inputCode);
		codeArray[1] = getCodeObjeto(inputCode);
		if (codeArray[0] != 0 && codeArray[1] != 0) {
			// enviarMensaje(chat_id, "categoria: " + codeArray[0] + " objeto: " +
			// codeArray[1]);

			try {
				Object s = tiendaDB.getObjectToCategoria(codeArray[0], codeArray[1]);
				if (s != null) {
					return s.toString();
				} else {
					return null;
				}

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return null;
			}
		} else {
			return null;
			// enviarError(chat_id);
		}
	}

	/*
	 * Cuando el argumento es un codigo de objeto (4 caracteres). Devuelve int
	 * codigo de categoria --> argumento[0]
	 */
	public int getCodeCategoria(String inputCode) {
		// Quizas se pueda mandar cualquier entero y si la bd nos da null
		// prescindir es estas comprobaciones...
		int[] catAvaliable = { 1, 2, 3, 4 };
		try {
			// Se pilla el int de categoria
			int c = Integer.parseInt(inputCode.charAt(0) + "");

			// Se comprueba si esta dentro de las categorias disponibles
			for (int i = 0; i < catAvaliable.length; i++) {
				if (c == (i + 1)) {
					return c;
				}
			}
			return 0;
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	/*
	 * Cuando el argumento es un codigo de objeto (4 caracteres). Devuelve int
	 * codigo de objeto --> argumento[1-3]
	 */
	public int getCodeObjeto(String inputCode) {
		if (inputCode.length() == 4) {
			String codeString = "";
			try {
				if (inputCode.charAt(1) == '0' && inputCode.charAt(2) == '0') {
					codeString += String.valueOf(inputCode.charAt(3));
					return Integer.parseInt(codeString);
				} else if (inputCode.charAt(1) == '0') {
					codeString += String.valueOf(inputCode.charAt(2)) + String.valueOf(inputCode.charAt(3));
					return Integer.parseInt(codeString);
				} else {
					codeString += String.valueOf(String.valueOf(inputCode.charAt(1))
							+ String.valueOf(inputCode.charAt(2)) + String.valueOf(inputCode.charAt(3)));
					return Integer.parseInt(codeString);
				}
			} catch (NumberFormatException e) {
				return 0;
			}
		}
		return 0;
	}

}
