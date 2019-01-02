package telegram_bots;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyAmazingBot extends TelegramLongPollingBot {

	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public void onUpdateReceived(Update update) {
		// TODO Auto-generated method stub
		//Comprobamos si recibimos un mensaje y si el mensaje contiene un texto
		if(update.hasMessage() && update.getMessage().hasText()) {
			//creamos una cadena y guardamos el texto recibido
			String mensajeDeTexto = update.getMessage().getText();
			//localizamos el identificador del chat  y se lo asignamos a la variable de tipo long
			long chat_id = update.getMessage().getChatId();
			//creamos un objeto de tipo SendMessage y le añadimos el id y el texto que se ha enviado
			SendMessage enviarMensaje = new SendMessage().setChatId(chat_id).setText(mensajeDeTexto);
			
			try {
				//a continuacion ejecutamos el mensaje
				execute(enviarMensaje);
			}catch (TelegramApiException telegramException) {
				// TODO: handle exception
				telegramException.printStackTrace();
			}
		
		}
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return "";
	}

}
