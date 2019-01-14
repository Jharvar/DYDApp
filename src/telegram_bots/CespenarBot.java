package telegram_bots;

import java.util.ArrayList;
import java.util.StringTokenizer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.groupadministration.KickChatMember;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CespenarBot extends TelegramLongPollingBot {
	private CespenarHelper thelper;
	private String helpSTR = "<b>OH! Brillantes!!! </b>\n-\n" + "<b>/tienda</b> -- Ver categorias.\n"
			+ "<b>/tienda X</b> -- Lista categoria.\n" + "<b>/tienda XXXX</b>-- Objeto.\n";

	public CespenarBot() {
		thelper = new CespenarHelper();
	}

	@Override
	public String getBotUsername() {
		return "Cespenar";
	}

	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			long chat_id = update.getMessage().getChatId();
			int user_id = update.getMessage().getFrom().getId();
			String userName = update.getMessage().getFrom().getUserName();
			String userInputString = update.getMessage().getText();
			System.out.println(userName + "(" + user_id + ") ->  " + userInputString);

			// Si el user no esta en la BD
			// if (!thelper.isDBClient(user_id)) {
			if (0 == 1) {
				System.out.println("Usuario no valido");
				kickAcoplado(user_id, chat_id);
			}
			// Usuario en la BD
			else {
				// Tokenizer del string input para enumerar argumentos
				ArrayList<String> userInput = getInputArray(userInputString);

				String cmd = getCommand(userInput);
				if (userInput.get(0).equals("/tienda")) {
					String outStringTienda = thelper.CMDtienda(chat_id, userInput);
					if (outStringTienda != null) {
						enviarMensaje(chat_id, (thelper.CMDtienda(chat_id, userInput)));
					} else {
						enviarError(chat_id);
					}
				} else if (userInput.get(0).equals("/help")) {
					enviarMensaje(chat_id, helpSTR);
				}
			}
		}
	}

	/*
	 * Devuelve un array de strings segun espacios (tokenizer), de esta forma se
	 * manejan mejor los argumentos.
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
		String[] avaliableCommandas = { "/tienda", "/help" };
		for (int i = 0; i < avaliableCommandas.length; i++) {
			if (p.get(0).equals(avaliableCommandas[i])) {
				return p.get(0);
			}
		}
		return null;
	}

	/*
	 * Kickea un id dado
	 */

	public Boolean kickAcoplado(int userId, long chatId) {
		KickChatMember k = new KickChatMember().setChatId(chatId).setUserId(userId);
		try {
			enviarMensaje(chatId, "A tomar por culo!");
			execute(k);
			return true;
		} catch (TelegramApiException e) {
			return false;
		}
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
		return "721182628:AAGl3e5ZSHyP1Zuv7ibpkdFqJ5i1mamgisA";
	}
}
