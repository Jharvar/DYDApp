package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Armas;

public class DB_Armas extends DB {
	
	//variables atributo con las que operamos en la clase
	private Conexion conexion;
	private Statement st;
	private ResultSet rs;
	private ArrayList<Armas>listadoArmas;
	
	/**
	 * Constructor por defecto
	 */
	public DB_Armas() {
		conexion = new Conexion();
		listadoArmas=new ArrayList<>();
	}
	/**
	 * Metodo que retorna una lista de armas de la tabla armas de la base de datos
	 * @return ArrayList<Armas>
	 * @throws SQLException
	 */
	public ArrayList<Armas> mostrarArmas() throws SQLException{
		conexion.openConexion();
		st= conexion.openConexion().createStatement();
		rs = st.executeQuery("SELECT * FROM armas");
		while(rs.next()) {
			listadoArmas.add(new Armas(rs.getInt("id_armas"), rs.getString("nombre"), rs.getInt("precio"),rs.getString("danio"),rs.getString("critico"), rs.getString("distancia"), rs.getInt("peso"), rs.getString("tipo_danio"), rs.getString("artefacto")));
		}
		rs.close();
		st.close();
		conexion.closeConexion();
		return listadoArmas;
	}

}
