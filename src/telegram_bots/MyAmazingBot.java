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

		if(update.hasMessage() && update.getMessage().hasText()) {
			long chat_id = update.getMessage().getChatId();
			String mensajeDeTexto = update.getMessage().getText();
			System.out.println(chat_id + " envia: " + mensajeDeTexto);
			
			// Convierte el input recibido en ArrayList<String> (se valida mejor).
			ArrayList<String> p = getArgs(mensajeDeTexto); 

			// TIENDA
			if (isTiendaCommand(p)){
				enviarMensaje(chat_id, CMDtienda(p));
			}
			
			// COMPRAR
			if (isComprarCommand(p)) {
				// TODO
			}
			
			// VENDER
			if (isComprarCommand(p)) {
				// TODO
			}
		}
	}
	
	private boolean isComprarCommand(ArrayList<String> p) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 *  Devuelve el input en array
	 */
	public ArrayList<String> getArgs(String msj) {
		StringTokenizer st = new StringTokenizer(msj);
		ArrayList<String> p = new ArrayList<>();
		while (st.hasMoreElements()) {
			p.add(st.nextElement().toString());
		}
		return p;
	}
	
	/*
	 * Valida /tienda
	 */
	public Boolean isTiendaCommand(ArrayList<String> params) {
		if (params.size() > 0) {
			if(params.get(0).equals("/tienda")) {
				System.out.println("Comando tienda identificado");
				return true;
			}
		}
		return false;
	}
	
	/*
	 * /tienda + args
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
		}catch (TelegramApiException telegramException) {
			telegramException.printStackTrace();
			return false;
		}	
	}
	
	@Override
	public String getBotToken() {
		return "654542961:AAGZDxcg6owBy-P-3oAH8pxQr6ppDfcXe0U";
	}
}
