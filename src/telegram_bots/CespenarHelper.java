package telegram_bots;

import java.util.ArrayList;
import clases.Armaduras;
import clases.Armas;
import clases.Categorias;
import clases.ObjetoMaravilloso;
import clases.ObjetoBasico;
import db.DB_Tienda;

public class CespenarHelper {
	private DB_Tienda tiendaDB = new DB_Tienda();

	/*
	 * CMD /tienda
	 */
	public String CMDtienda(long chat_id, ArrayList<String> userInput) {
		// "/tienda"
		if (userInput.size() == 1) {
			return getCategories(chat_id, userInput);

		} else if (userInput.size() == 2) {
			// "/tienda X"
			if (userInput.get(1).length() == 1) {
				return getCategory(userInput.get(1));
			}
			// "/tienda XXXX"
			else if (userInput.get(1).length() == 4) {
				return getObject(chat_id, userInput.get(1));
			}
		}
		return null;
	}

	/*
	 * Muestra listado de categorias disponibles.
	 */
	public String getCategories(long chat_id, ArrayList<String> userInput) {
		String msj = "\"Cespenar sirve siempre al magnifico\".\n-\n";
		ArrayList<Categorias> categorias = tiendaDB.keepCategories();
		for (Categorias c : categorias) {
			msj += c.toStringTiendaHtml();
		}
		return msj;
	}

	/*
	 * Muestra lista de objetos segun su categoria
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
			return getWonderObject();
		}
	}

	/*
	 * Lista de Armas
	 */
	public String getArmaString() {
		String headOut = "Thalantyr's place.\nARMAS.";
		String bodyOut = "";
		ArrayList<?> a = tiendaDB.keepObjects(1);
		Armas arm = new Armas();
		for (Object object : a) {
			arm = (Armas) object;
			bodyOut += arm.toStringTiendaListHtml();
		}
		return fortmatHtmlList(headOut, bodyOut);
	}

	/*
	 * Lista de Armaduras
	 */
	public String getArmadurasString() {
		String headOut = "Thalantyr's place.\nARMADURAS.";
		String bodyOut = "";
		ArrayList<?> a = tiendaDB.keepObjects(2);
		Armaduras arm = new Armaduras();
		for (Object object : a) {
			arm = (Armaduras) object;
			bodyOut += arm.toStringTiendaListHtml();
		}
		return fortmatHtmlList(headOut, bodyOut);
	}

	/*
	 * Lista de Objetos Basicos
	 */
	public String getBasicObjectString() {
		String headOut = "Thalantyr's place.\nOBJETOS BASICOS.";
		String bodyOut = "";
		ArrayList<?> a = tiendaDB.keepObjects(3);
		ObjetoBasico ob = new ObjetoBasico();
		for (Object object : a) {
			ob = (ObjetoBasico) object;
			bodyOut += ob.toStringTiendaListHtml();
		}
		return fortmatHtmlList(headOut, bodyOut);
	}
	
	/*
	 * Lista de Objetos Maravillosos
	 */
	public String getWonderObject() {
		String headOut = "Thalantyr's place.\nOBJETOS MARAVILLOSOS.";
		String bodyOut = "";
		ArrayList<?> a = tiendaDB.keepObjects(4);
		ObjetoMaravilloso om = new ObjetoMaravilloso();
		for (Object object : a) {
			om = (ObjetoMaravilloso) object;
			bodyOut += om.toStringTiendaListHtml();
		}
		return fortmatHtmlList(headOut, bodyOut);
	}

	/*
	 * Formato HTML con head + body + stats
	 */
	public String fortmatHtmlList(String head, String body) {
		String l = "+ + + + + + + + + + + + + +\n";
		String h = l + head + "\n" + l;
		String b = "<code>" + body + "</code>";
		return h + b;
	}

	/*
	 * Obtiene lista de categorias de la BD
	 */
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
	 * Devuelve el string detail de un categoria/objeto
	 */
	private String getObjectString(int cat, int obj) {
		String headOut = "";
		String bodyOut = "";
		switch (cat) {
		case 1:
			Armas wep = new Armas();
			wep = tiendaDB.getWeapon(obj);
			if (wep == null)
				return null;
			headOut += wep.toStringHeadHtml();
			bodyOut += wep.toString() + "\n";
			break;
		case 2:
			Armaduras arm = new Armaduras();
			arm = tiendaDB.getArmor(obj);
			if (arm == null)
				return null;
			headOut += arm.toStringHeadHtml();
			bodyOut += arm.toString() + "\n";
			break;
		case 3:
			ObjetoBasico ob = new ObjetoBasico();
			ob = tiendaDB.getBasicObject(obj);
			if (ob == null)
				return null;
			headOut += ob.toStringHeadHtml();
			bodyOut += ob.toString() + "\n";
			break;
		case 4:
			ObjetoMaravilloso om = new ObjetoMaravilloso();
			om = tiendaDB.getMagicObject(obj);
			if (om == null)
				return null;
			headOut += om.toStringHeadHtml();
			bodyOut += om.toString() + "\n";
			break;
		default:
			break;
		}
		return fortmatHtmlList(headOut, bodyOut);
	}

	/*
	 * Comprueba si el chat_id esta en la BD
	 */
	public boolean isDBClient(int chatid) {
		return tiendaDB.isClient(chatid);
	}
	
	/*
	 * Valida el input y pide string a getObjectString.
	 */
	private String getObject(long chat_id, String inputCode) {
		int[] codeArray = new int[2];
		codeArray[0] = getCodeCategoria(inputCode);
		codeArray[1] = getCodeObjeto(inputCode);
		if (codeArray[0] != 0 && codeArray[1] != 0) {
			return getObjectString(codeArray[0], codeArray[1]);
		}
		return null;
	}

	/*
	 * Valida CodeCategoria
	 */
	public int getCodeCategoria(String inputCode) {
		int[] catAvaliable = { 1, 2, 3, 4 };
		try {
			int c = Integer.parseInt(inputCode.charAt(0) + "");
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
	 * Valida Code Objeto
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
