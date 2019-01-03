package telegram_bots;

import java.sql.SQLException;
import java.util.ArrayList;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import clases.Armas;
import db.DB_Armas;
import db.DB_Tienda;
import tools.Identificadores;

public class MyAmazingBot extends TelegramLongPollingBot {

	
	private DB_Tienda tienda;
	private ArrayList<Armas> armas2;
	// Array harcodeados hasta hacer la conexion con jarvar
	String[] armas = {"[001]-Espada larga", "[002]-Espada Corta", "[003]-Baston", "[004]-Arco Corto"};
	String[] armaduras = {"[010]-Cuero", "[012]-Cuero tachonado", "[013]-Completa", "[014]-Placas"};
	String[] categorias = {"armas", "armaduras", "magicos", "clase"};
	
	public MyAmazingBot() {
		tienda = new DB_Tienda();
	}

	
	
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
			
			// Opcion tienda 
			if(mensajeDeTexto.substring(0,7).compareTo("/tienda")==0) {
				tienda(mensajeDeTexto, chat_id,update);
			}
			
			// Opcion ver
			// Opcion comprar
			// Opcion vender
		}
	}

	public void tienda(String mensaje, long chat_id , Update update) {

		// TIENDA (categorias)
		if (mensaje.length() == 7) {
			String[] jarvarArray = categorias; // <<-- Array Jarvar
			String salida = crearMensaje(jarvarArray);
			enviarMensaje(chat_id, salida);
		} 
		
		// TIENDA X
		else if (mensaje.length() == 9) {
			switch (mensaje.substring(8,9)) {
			case "1":
				System.out.println("Categoria 1");
				String[] jarvarArrayArmas = armas; // <<-- Array Jarvar
				String salidaArmas = crearMensaje(jarvarArrayArmas);
				enviarMensaje(chat_id, salidaArmas);
				break;
			case "2":
				System.out.println("Categoria 2");
				String[] jarvarArrayArmaduras = armaduras; // <<-- Array Jarvar
				String salidaArmaduras = crearMensaje(jarvarArrayArmaduras);
				enviarMensaje(chat_id, salidaArmaduras);
				break;
			default:
				System.out.println("Fail");
				break;
			}
		}

		String comando = update.getMessage().getText();
		SendMessage enviarMensaje = new SendMessage();
		

	}
		
		
	

	public String crearMensaje(String[]lista) {
		String out = "<code>";
		for (int i = 0; i < lista.length; i++) {
			out += lista[i];
			out += "\n";
		}
		return out + "</code>";
	}
	
	public Boolean enviarMensaje(long chat_id, String txt) {	
		SendMessage enviarMensaje = new SendMessage();
		enviarMensaje.enableHtml(true);
		enviarMensaje.setChatId(chat_id).setText(txt);
		try {
			execute(enviarMensaje);
			return true;
		}catch (TelegramApiException telegramException) {
			telegramException.printStackTrace();
			return false;
		}	
	}
	
	@Override
	public String getBotToken() {
		return Identificadores.KEY_API_JHARVAR;
	}
}

