package main;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegram_bots.CespenarBot;

public class Principal {

	public static void main(String[] args) {
		//Inicializamos Contexto De La API
		ApiContextInitializer.init();
		
		//Instanciamos Bot de Telegram con la Api
		TelegramBotsApi bostsApi = new TelegramBotsApi();
		
		//Registrar nuestro bot
		try {
			// Jarvar
			//bostsApi.registerBot(new TelegramServer());
			
			// Zaiuss
			bostsApi.registerBot(new CespenarBot());
			
		}catch (TelegramApiException telAe) {
			telAe.getCause();
		}
	}
}
