package telegram_bots;

import java.util.ArrayList;
import java.util.StringTokenizer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ThalantyrBot extends TelegramLongPollingBot {
	private ThalantyrHelper thelper;

	public ThalantyrBot() {
		thelper = new ThalantyrHelper();
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
					String outStringTienda = thelper.CMDtienda(chat_id, userInput);
					if (outStringTienda != null) {
						enviarMensaje(chat_id, (thelper.CMDtienda(chat_id, userInput)));
					} else {
						enviarError(chat_id);
					}
					
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
