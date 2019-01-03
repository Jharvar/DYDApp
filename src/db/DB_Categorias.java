package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Armaduras;
import clases.Armas;
import clases.Categorias;
import clases.ObjetosBasicos;

public class DB_Categorias extends DB{
	
	
	//Atributos de la clase
	private ArrayList<Categorias> listaCategorias;
	private ArrayList<Armas> listaArmas;
	private ArrayList<Armaduras> listaArmaduras;
	private ArrayList<ObjetosBasicos> listaObjetosBasicos;
	//Atributos de operaciones
	private Conexion conexion;
	private Statement st;
	private ResultSet rs;
	
	public DB_Categorias() {
		conexion = new Conexion();
		listaCategorias = new ArrayList<>();
		listaArmas = new ArrayList<>();
		listaArmaduras = new ArrayList<>();
		listaObjetosBasicos = new ArrayList<>();
	}
	
	public ArrayList<Categorias> keepCategories() throws SQLException{
		conexion.openConexion();
		st = conexion.openConexion().createStatement();
		rs = st.executeQuery("SELECT * FROM categorias");
		while (rs.next()) {
			listaCategorias.add(new Categorias(rs.getInt("id_categoria"), rs.getString("nombre"), rs.getInt("id_objeto")));
		}
		rs.close();
		st.close();
		conexion.closeConexion();
		return listaCategorias;
	}
	
	public ArrayList<?> keepObjects(int id_objeto) throws SQLException{
		conexion.openConexion();
		st = conexion.openConexion().createStatement();
		switch (id_objeto) {
		case 1:
			rs = st.executeQuery("SELECT * FROM armas");
			return keepWeapons(rs);
		case 2:
			rs = st.executeQuery("SELECT * FROM armaduras");
			return keepArmors(rs);
		case 3:
			rs = st.executeQuery("SELECT * FROM objetos_basicos");
			return keepBasicObjects(rs);
		case 4:
			return null;
		
		}
		return null;
		
		
	
	}
	/**
	 * 
	 * @param rs
	 * @return ArrayList<Armas>
	 * @throws SQLException
	 */
	
	public ArrayList<Armas> keepWeapons(ResultSet rs) throws SQLException {
		while (rs.next()) {
			listaArmas.add(new Armas(rs.getInt("id_armas"), rs.getString("nombre"), rs.getInt("precio"),rs.getString("danio"),rs.getString("critico"), rs.getString("distancia"), rs.getInt("peso"), rs.getString("tipo_danio"), rs.getString("artefacto")));
		}
		rs.close();
		st.close();
		conexion.closeConexion();
		return listaArmas;
	}
	/**
	 * 
	 * @param rs
	 * @return ArrayList<Armaduras>
	 * @throws SQLException
	 */
	public ArrayList<Armaduras> keepArmors(ResultSet rs) throws SQLException{
		while(rs.next()) {
			listaArmaduras.add(new Armaduras(rs.getInt("id_armadura"), rs.getString("nombre"), rs.getInt("precio"), rs.getInt("boni_CA"), rs.getInt("boni_defensa"), rs.getInt("penalizador"), rs.getString("fallo_conjuro"), rs.getString("velocidad"), rs.getString("peso")));
		}
		rs.close();
		st.close();
		conexion.closeConexion();
		return listaArmaduras;
	}
	/**
	 * 
	 * @param rs
	 * @return ArrayList<ObjetosBasicos>
	 * @throws SQLException
	 */
	public ArrayList<ObjetosBasicos> keepBasicObjects(ResultSet rs) throws SQLException{
		while(rs.next()) {
			listaObjetosBasicos.add(new ObjetosBasicos(rs.getInt("id_objetos"),rs.getString("nombre"), rs.getInt("precio"),rs.getInt("peso"), rs.getString("danio"),rs.getString("curacion"), rs.getString("descripcion")));
		}
		rs.close();
		st.close();
		conexion.closeConexion();
		return listaObjetosBasicos;
	}
}


