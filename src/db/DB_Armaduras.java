package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Armaduras;

public class DB_Armaduras extends DB {
	
	private Conexion conexion;
	private Statement st;
	private ResultSet rs;
	private ArrayList<Armaduras> listaArmaduras;
	
	public DB_Armaduras() {
		conexion = new Conexion();
		listaArmaduras = new ArrayList<>();
	}

	public ArrayList<Armaduras> mostrarArmaduras() throws SQLException{
		conexion.openConexion();
		st = conexion.openConexion().createStatement();
		rs = st.executeQuery("SELECT * FROM armaduras");
		while(rs.next()) {
			listaArmaduras.add(new Armaduras(rs.getInt("id_armadura"), rs.getString("nombre"), rs.getInt("precio"), rs.getInt("boni_CA"), rs.getInt("boni_defensa"), rs.getInt("penalizador"), rs.getString("fallo_conjuro"), rs.getString("velocidad"), rs.getString("peso")));
		}
		rs.close();
		st.close();
		conexion.closeConexion();
		return listaArmaduras;
	}
}
