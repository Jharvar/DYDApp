package telegram_bots;

import java.sql.SQLException;
import java.util.ArrayList;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import clases.Armas;
import db.DB_Armas;

public class MyAmazingBot extends TelegramLongPollingBot {

	private ArrayList<Armas> armas;
	
	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "d&d_bot";
	}

	@Override
	public void onUpdateReceived(Update update) {
		// TODO Auto-generated method stub
		String comando = update.getMessage().getText();
		SendMessage enviarMensaje = new SendMessage();
		
	}
		
		
	

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return "711497116:AAGrvRTIPFX6hPNtvF0CJeJPfcMKcOjVkto";
	}

}
