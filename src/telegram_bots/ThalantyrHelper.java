package telegram_bots;
import java.sql.SQLException;
import java.util.ArrayList;
import clases.Armaduras;
import clases.Armas;
import clases.Categorias;
import clases.ObjetosBasicos;
import db.DB_Tienda;

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
				return getCategory(userInput.get(1));
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
		ArrayList<Categorias> categorias = tiendaDB.keepCategories();
		for (Categorias c : categorias) {
			msj += c.toStringTiendaHtml();
		}
		return msj;
	}

	/*
	 * Muestra lista de objetos de una categoria.
	 */
	public String getCategory(String userString) {
		Integer catSelected = getCodeCategoria(userString);
		if (catSelected == 0)
			return null;
		
		switch (catSelected) {
		case 1:
			return getArmaString();
		case 2:
			return getArmadurasString();
		case 3:
			return getBasicObjectString();
		default:
			return "Proximamente ,)";
		}
	}

	public String getArmaString() {
		String out = "\t\t[$] ARMAS [$]\t\t\n";
		ArrayList<?> a = tiendaDB.keepObjects(1);
		Armas arm = new Armas();
		for (Object object : a) {
			arm = (Armas) object;
			if (arm.getId_armas() < 10) {
				out += arm.toStringTiendaListHtml("100");
			} else if (arm.getId_armas() < 100) {

				out += arm.toStringTiendaListHtml("10");
			} else {
				out += arm.toStringTiendaListHtml("1");
			}
		}
		return out;
	}

	public String getArmadurasString() {
		String out = "\t\t[$] ARMADURAS [$]\t\t\n";
		ArrayList<?> a = tiendaDB.keepObjects(2);
		Armaduras arm = new Armaduras();
		for (Object object : a) {
			arm = (Armaduras) object;
			if (arm.getId_armaduras() < 10) {
				out += arm.toStringTiendaListHtml("200");
			} else if (arm.getId_armaduras() < 100) {

				out += arm.toStringTiendaListHtml("20");
			} else {
				out += arm.toStringTiendaListHtml("2");
			}
		}
		return out;
	}

	public String getBasicObjectString() {
		String out = "\t\t[$] OBJETOS BASICOS [$]\t\t\n";
		ArrayList<?> a = tiendaDB.keepObjects(3);
		ObjetosBasicos ob = new ObjetosBasicos();
		for (Object object : a) {
			ob = (ObjetosBasicos) object;
			if (ob.getId_objetos() < 10) {
				out += ob.toStringTiendaListHtml("300");
			} else if (ob.getId_objetos() < 100) {

				out += ob.toStringTiendaListHtml("30");
			} else {
				out += ob.toStringTiendaListHtml("3");
			}
		}
		return out;
	}

	public ArrayList<Integer> getAvaliableCategories() {
		ArrayList<Integer> outList = new ArrayList<>();

		ArrayList<Categorias> c = tiendaDB.keepCategories();
		for (Categorias catObj : c) {
			outList.add(catObj.getId_categoria());
			System.out.println(catObj.getNombre_categoria() + " added to avaliables");
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
