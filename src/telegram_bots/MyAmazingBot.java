package telegram_bots;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyAmazingBot extends TelegramLongPollingBot {
	@Override
	public String getBotUsername() {
		return "ZaiussBot";
	}

	@Override
	public void onUpdateReceived(Update update) {
		if(update.hasMessage() && update.getMessage().hasText()) {
			long chat_id = update.getMessage().getChatId();
			System.out.println(chat_id);
			String mensajeDeTexto = update.getMessage().getText();
			if(mensajeDeTexto.substring(0,7).compareTo("/tienda")==0) {
				if(mensajeDeTexto.length()==7) {
					verCategorias(chat_id);
				}
				else if (mensajeDeTexto.length()==9) {
					switch (mensajeDeTexto.substring(8,9)) {
					case "1":
						System.out.println("Categoria 1");
						break;
					case "2":
						System.out.println("Categoria 2");
						break;
					default:
						System.out.println("Fail");
						break;
					}
				}	
			}
		}
	}

	public Boolean verCategorias(long chat_id) {
		String[] categorias = {"armas", "armaduras", "magicos", "clase"};
		String out = crearMensaje(categorias);
		SendMessage enviarMensaje = new SendMessage();
		enviarMensaje.enableHtml(true);
		enviarMensaje.setChatId(chat_id).setText(out);
		try {
			execute(enviarMensaje);
		}catch (TelegramApiException telegramException) {
			telegramException.printStackTrace();
		}
		return true;
	}
	
	public Boolean verArmas(long chat_id) {
		String[] armas = {"[001]-Espada larga - 100g", "[002]-Espada Corta - 50g", "[003]-Baston - 100", "[004]-Arco Corto - 50"};
		String out = crearMensaje(armas);
		SendMessage enviarMensaje = new SendMessage();
		enviarMensaje.enableHtml(true);
		enviarMensaje.setChatId(chat_id).setText(out);
		try {
			execute(enviarMensaje);
		}catch (TelegramApiException telegramException) {
			telegramException.printStackTrace();
		}
		return true;
	}
	
	public String crearMensaje(String[]lista) {
		String out = "<code>";
		for (int i = 0; i < lista.length; i++) {
			out += lista[i];
			out += "\n";
		}
		return out + "</code>";
	}
	
	@Override
	public String getBotToken() {
		return "654542961:AAGZDxcg6owBy-P-3oAH8pxQr6ppDfcXe0U";
	}
}
