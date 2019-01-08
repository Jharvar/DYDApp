package telegram_bots;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

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
		//if (update.hasMessage() && update.getMessage().hasText()) {
		if (update.hasMessage()) {
			long chat_id = update.getMessage().getChatId();
			String mensajeDeTexto = update.getMessage().getText();
			//String t = update.get
			//System.out.println(chat_id + " envia: " + mensajeDeTexto);

			// Convierte el input recibido en ArrayList<String> (se valida mejor).
			ArrayList<String> pArgs = new ArrayList<>();
			pArgs.clear();
			pArgs =  getArgs(mensajeDeTexto);
			// getCommand ya valida, sino devuelve null.
			String cmd = getCommand(pArgs);
			if (cmd != null) {
				switch (cmd) {
				case "/tienda":
					enviarMensaje(chat_id, CMDtienda(pArgs));
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
	 * Devuelve el input en array
	 */
	public ArrayList<String> getArgs(String msj) {
		StringTokenizer st = new StringTokenizer(msj);
		ArrayList<String> p = new ArrayList<>();
		p.clear();
		while (st.hasMoreElements()) {
			p.add(st.nextElement().toString());
		}
		return p;
	}

	/*
	 * Valida el comando y devuelve array valido.
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
	 * Command /tienda
	 */
	public String CMDtienda(ArrayList<String> args) {
		String msj = "";
		if (args.size() == 1) {
			try {
				ArrayList<Categorias> categorias = tiendaDB.keepCategories();
				for (Categorias c : categorias) {
					msj += c.toStringTiendaHtml();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return msj;
}

	/*
	 * Envia un String a un id
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
