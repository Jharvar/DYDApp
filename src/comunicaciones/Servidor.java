package comunicaciones;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread {

	//Atributos de la clase
	private DataInputStream dis;
	private DataOutputStream dos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	//Atributos - variables de las Comunicaciones
	private Socket socketCliente;
	/**
	 * 
	 * @param PORT
	 * @param cliente
	 */
	public Servidor(Socket cliente) {
			this.socketCliente=cliente;
	}
	
	public void openStreams() {
		try {
			if(socketCliente.isConnected()) {
				ois = new ObjectInputStream(socketCliente.getInputStream());
				dis = new DataInputStream(socketCliente.getInputStream());
				dos = new DataOutputStream(socketCliente.getOutputStream());
				oos = new ObjectOutputStream(socketCliente.getOutputStream());
			}
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void closeStreams() {
		try {
			if(socketCliente.isClosed()) {
				ois.close();
				dis.close();
				dos.close();
				oos.close();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
