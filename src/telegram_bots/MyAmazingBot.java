package telegram_bots;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import clases.Categorias;
import db.DB_Tienda;

public class MyAmazingBot extends TelegramLongPollingBot {
	private DB_Tienda tiendaDB;

	public MyAmazingBot() {
		tiendaDB = new DB_Tienda();
	}

	@Override
	public String getBotUsername() {
		return "ZaiussBot";
	}

	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			
			// Guarda chat_id y el input (string)
			long chat_id = update.getMessage().getChatId();
			String userInputString = update.getMessage().getText();
			System.out.println(chat_id + " envia: " + userInputString);
			
			// Tokenizer del string input para enumerar argumentos
			ArrayList<String> userInput = getInputArray(userInputString);
			
			/*
			 *  Valida si el comando esta disponible,
			 *  si es un comando registrado entra en el switch.
			 */
			String cmd = getCommand(userInput);
			if (cmd != null) {
				switch (cmd) {
				case "/tienda":
					CMDtienda(chat_id, userInput);
					break;

				case "/comprar":
					break;

				case "/vender":
					break;

				default:
					enviarError(chat_id);
					break;
				}
			} else {
				enviarError(chat_id);
			}
		}
	}
	
	/*
	 * Devuelve un array de strings segun espacios (tokenizer),
	 * de esta forma se manejan mejor los argumentos.
	 */
	public ArrayList<String> getInputArray(String msj) {
		StringTokenizer st = new StringTokenizer(msj);
		ArrayList<String> p = new ArrayList<>();
		p.clear();
		while (st.hasMoreElements()) {
			p.add(st.nextElement().toString());
		}
		return p;
	}

	/*
	 * Valida el comando y devuelve un string con el nombre del comando
	 */
	public String getCommand(ArrayList<String> p) {
		String[] avaliableCommandas = { "/tienda", "/comprar", "/vender" };
		for (int i = 0; i < avaliableCommandas.length; i++) {
			if (p.get(0).equals(avaliableCommandas[i])) {
				return p.get(0);
			}
		}
		return null;
	}
	
	/*
	 * CMD /tienda
	 */
	public void CMDtienda(long chat_id, ArrayList<String> userInput) {

		// /tienda (Sin argumento)
		if (userInput.size() == 1) {
			showCategories(chat_id, userInput);
		}

		// /tienda con argumento.
		else if (userInput.size() == 2) {

			// Argumento de un digito *id_categoria
			if (userInput.get(1).length() == 1) {
				showCategory(chat_id, userInput.get(1));
			}

			// Argumento de 4 digitos *id_categoria(1) + *id_objeto(3)
			else if (userInput.get(1).length() == 4) {
				showObject(chat_id, userInput.get(1));
			}

			// Argumentdo distinto a 1 o 4 (length)
			else {
				enviarError(chat_id);
			}
		} else {
			enviarError(chat_id);
		}
	}
	
	/*
	 * Muestra listado de categorias.
	 */
	public void showCategories(long chat_id, ArrayList<String> userInput) {
		String msj = "";
		try {
			ArrayList<Categorias> categorias = tiendaDB.keepCategories();
			for (Categorias c : categorias) {
				msj += c.toStringTiendaHtml();
			}
			enviarMensaje(chat_id, msj);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Muestra lista de objetos de una categoria.
	 */
	public void showCategory(long chat_id, String userString) {
		try {
			int c = Integer.parseInt(userString);
			if (isCategory(c)) {
				// jarvar select category(int)
				enviarMensaje(chat_id, "Categoria: " + c);
			} else {
				enviarError(chat_id);
			}
			// else:enviarError(chat_id);
		} catch (NumberFormatException e) {
			enviarError(chat_id);
		}
	}

	/*
	 * Muestra un objeto concreto
	 */
	private void showObject(long chat_id, String inputCode) {
		int[] codeArray = new int[2];
		codeArray[0] = getCodeCategoria(inputCode);
		codeArray[1] = getCodeObjeto(inputCode);
		if (codeArray[0] != 0 && codeArray[1] != 0) {
			enviarMensaje(chat_id, "categoria: " + codeArray[0] + " objeto: " + codeArray[1]);
		} else {
			enviarError(chat_id);
		}
	}

	/*
	 * Cuando el argumento es un codigo de objeto (4 caracteres).
	 * Devuelve int codigo de categoria --> argumento[0]
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
	 * Cuando el argumento es un codigo de objeto (4 caracteres).
	 * Devuelve int codigo de objeto --> argumento[1-3]
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

	/*
	 * Valida si la categoria es valida. 
	 * (quizas con recibir un null sea suficiente y no haga falta en un futuro)
	 */
	public boolean isCategory(int c) {
		int[] catAvaliable = { 1, 2, 3, 4 };
		for (int i = 0; i < catAvaliable.length; i++) {
			if (c == i + 1) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Enviar un texto
	 */
	public Boolean enviarMensaje(long chat_id, String txt) {
		SendMessage sm = new SendMessage();
		sm.enableHtml(true);
		sm.setChatId(chat_id).setText(txt);
		try {
			execute(sm);
			return true;
		} catch (TelegramApiException telegramException) {
			telegramException.printStackTrace();
			return false;
		}
	}

	/*
	 * Envia error
	 */
	public Boolean enviarError(long chat_id) {
		SendMessage sm = new SendMessage();
		sm.enableHtml(true);
		String error = "<code> Error!! </code>";
		sm.setChatId(chat_id).setText(error);
		try {
			execute(sm);
			return true;
		} catch (TelegramApiException telegramException) {
			telegramException.printStackTrace();
			return false;
		}
	}

	@Override
	public String getBotToken() {
		return "654542961:AAGZDxcg6owBy-P-3oAH8pxQr6ppDfcXe0U";
	}
}
