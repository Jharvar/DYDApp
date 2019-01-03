
package telegram_bots;

import java.sql.SQLException;
import java.util.ArrayList;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import clases.UsuarioPersonaje;
import db.DB_UsuarioPersonaje;
import tools.Comandos;

public class TelegramServer extends TelegramLongPollingBot {
	
	private ArrayList<UsuarioPersonaje> personajes;
	private DB_UsuarioPersonaje DBUser;
	private SendMessage sendMessage;
	public TelegramServer() {
		// TODO Auto-generated constructor stub
		DBUser = new DB_UsuarioPersonaje();
		sendMessage = new SendMessage();
	}
	
	
	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "d&d_bot";
	}

	@Override
	public void onUpdateReceived(Update update) {
	
		
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return "711497116:AAGrvRTIPFX6hPNtvF0CJeJPfcMKcOjVkto";
	}
	/**
	 * 
	 * @param update
	 * @return boolean
	 */
	public boolean singin(Update update) {
		
		return false;
	}
	
	
	
	
	public void executeOptions(SendMessage sendMessage) {
		try {
			execute(sendMessage);
		} catch (TelegramApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	
	


