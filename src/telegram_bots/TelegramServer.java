package telegram_bots;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramServer extends TelegramLongPollingBot {

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

}
