package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.UsuarioPersonaje;

public class DB_UsuarioPersonaje extends DB {
	//atributos de la clase
	private ArrayList<UsuarioPersonaje> listaPersonajes;
	private Statement st;
	private ResultSet rs;
	private Conexion conexion;
	
	public DB_UsuarioPersonaje() {
		listaPersonajes = new ArrayList<>();
		conexion = new Conexion();
	}
	/**
	 * 
	 * @return ArrayList<UsuarioPersonaje>
	 * @throws SQLException
	 */
	public ArrayList<UsuarioPersonaje> mostrarUsuario() throws SQLException{
		conexion.openConexion();
		st = conexion.openConexion().createStatement();
		rs = st.executeQuery("SELECT * FROM jugadores");
		while (rs.next()) {
			listaPersonajes.add(new UsuarioPersonaje(rs.getInt("id_jugador"), rs.getString("personaje"), rs.getString("clase"), rs.getString("dinero")));
		}
		rs.close();
		st.close();
		conexion.closeConexion();
		return listaPersonajes;
		
	}

}
