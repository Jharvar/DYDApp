package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.ObjetosBasicos;

public class DB_ObjetosBasicos extends ObjetosBasicos {
	
	private Conexion conexion;
	private Statement st;
	private ResultSet rs;
	private ArrayList<ObjetosBasicos> listaObjetosBasicos;
	
	public DB_ObjetosBasicos() {
		conexion = new Conexion();
		listaObjetosBasicos = new ArrayList<>();
	}
	
	public ArrayList<ObjetosBasicos> mostrarObjetosBásicos() throws SQLException{
		conexion.openConexion();
		st = conexion.openConexion().createStatement();
		rs = st.executeQuery("SELECT * FROM objetos_basicos");
		while(rs.next()) {
			listaObjetosBasicos.add(new ObjetosBasicos(rs.getInt("id_objetos"),rs.getString("nombre"), rs.getInt("precio"),rs.getInt("peso"), rs.getString("danio"),rs.getString("curacion"), rs.getString("descripcion")));
		}
		rs.close();
		st.close();
		conexion.closeConexion();
		return listaObjetosBasicos;
		
	}
}
