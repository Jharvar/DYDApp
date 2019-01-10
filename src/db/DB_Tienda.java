package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Armaduras;
import clases.Armas;
import clases.Categorias;
import clases.ObjetosBasicos;

public class DB_Tienda extends DB {

	// Atributos de la clase para obtener objetos únicos
	private Armas weapon;
	private Armaduras armor;
	private ObjetosBasicos basicObject;
	// Atributos de la clase
	private ArrayList<Categorias> listaCategorias;
	private ArrayList<Armas> listaArmas;
	private ArrayList<Armaduras> listaArmaduras;
	private ArrayList<ObjetosBasicos> listaObjetosBasicos;

	// Atributos de operaciones
	private Conexion conexion;
	private Statement st;
	private ResultSet rs;

	public DB_Tienda() {
		conexion = new Conexion();

	}

	public ArrayList<Categorias> keepCategories() throws SQLException {
		conexion.openConexion();
		st = conexion.openConexion().createStatement();
		rs = st.executeQuery("SELECT * FROM categorias");
		listaCategorias = new ArrayList<>();
		while (rs.next()) {
			listaCategorias
					.add(new Categorias(rs.getInt("id_categoria"), rs.getString("nombre"), rs.getInt("id_objeto")));
		}
		rs.close();
		st.close();
		conexion.closeConexion();
		return listaCategorias;
	}

	/**
	 * 
	 * @param id_objeto
	 * @return ArrayList<?>
	 * @throws SQLException
	 */

	public ArrayList<?> keepObjects(int id_objeto) throws SQLException {
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
	 * @param rs
	 * @return ArrayList<Armas>
	 * @throws SQLException
	 */

	public ArrayList<Armas> keepWeapons(ResultSet rs) throws SQLException {
		listaArmas = new ArrayList<>();
		while (rs.next()) {
			listaArmas.add(new Armas(rs.getInt("id_armas"), rs.getString("nombre"), rs.getInt("precio"),
					rs.getString("danio"), rs.getString("critico"), rs.getString("distancia"), rs.getInt("peso"),
					rs.getString("tipo_danio"), rs.getString("artefacto")));
		}
		rs.close();
		st.close();
		conexion.closeConexion();
		return listaArmas;
	}

	/**
	 * @param rs
	 * @return ArrayList<Armaduras>
	 * @throws SQLException
	 */
	public ArrayList<Armaduras> keepArmors(ResultSet rs) throws SQLException {
		listaArmaduras = new ArrayList<>();
		while (rs.next()) {
			listaArmaduras.add(new Armaduras(rs.getInt("id_armadura"), rs.getString("nombre"), rs.getInt("precio"),
					rs.getInt("boni_CA"), rs.getInt("boni_defensa"), rs.getInt("penalizador"),
					rs.getString("fallo_conjuro"), rs.getString("velocidad"), rs.getString("peso")));
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
	public ArrayList<ObjetosBasicos> keepBasicObjects(ResultSet rs) throws SQLException {
		listaObjetosBasicos = new ArrayList<>();
		while (rs.next()) {
			listaObjetosBasicos.add(new ObjetosBasicos(rs.getInt("id_objetos"), rs.getString("nombre"),
					rs.getInt("precio"), rs.getInt("peso"), rs.getString("danio"), rs.getString("curacion"),
					rs.getString("descripcion")));
		}
		rs.close();
		st.close();
		conexion.closeConexion();
		return listaObjetosBasicos;
	}

	/**
	 * 
	 * @param categoria
	 * @param id_objeto
	 * @return Object
	 * @throws SQLException
	 */
	public Object getObjectToCategoria(int categoria, int id_objeto) throws SQLException {
		switch (categoria) {
		case 1:
			return getWeapon(id_objeto);
		case 2:
			return getArmor(id_objeto);
		case 3:
			return getBasicObject(id_objeto);
		}

		return null;
	}

	/**
	 * 
	 * @param id_objeto
	 * @return Armas
	 * @throws SQLException
	 */
	public Armas getWeapon(int id_objeto) throws SQLException {
		conexion.openConexion();
		st = conexion.openConexion().createStatement();
		rs = st.executeQuery("SELECT * FROM armas WHERE id_armas='" + id_objeto + "'");
		if (rs.first()) {
			weapon = new Armas(rs.getInt("id_armas"), rs.getString("nombre"), rs.getInt("precio"),
					rs.getString("danio"), rs.getString("critico"), rs.getString("distancia"), rs.getInt("peso"),
					rs.getString("tipo_danio"), rs.getString("artefacto"));
		} else {
			System.out.println("Registro no encontrado");
		}
		rs.close();
		st.close();
		conexion.closeConexion();
		return weapon;
	}

	/**
	 * 
	 * @param id_objeto
	 * @return Armaduras
	 * @throws SQLException
	 */
	public Armaduras getArmor(int id_objeto) throws SQLException {
		conexion.openConexion();
		st = conexion.openConexion().createStatement();
		rs = st.executeQuery("SELECT * FROM armaduras where id_armaduras='" + id_objeto + "'");
		if (rs.first()) {
			armor = new Armaduras(rs.getInt("id_armaduras"), rs.getString("nombre"), rs.getInt("precio"),
					rs.getInt("boni_CA"), rs.getInt("boni_defensa"), rs.getInt("penalizador"),
					rs.getString("fallo_conjuro"), rs.getString("velocidad"), rs.getString("peso"));
		}
		rs.close();
		st.close();
		conexion.closeConexion();
		return armor;
	}

	/**
	 * 
	 * @param id_objeto
	 * @return ObjectosBasicos
	 * @throws SQLException
	 */
	public ObjetosBasicos getBasicObject(int id_objeto) throws SQLException {
		conexion.openConexion();
		st = conexion.openConexion().createStatement();
		rs = st.executeQuery("SELECT * FROM objeto_basico WHERE id_objetos='" + id_objeto + "'");
		if (rs.first()) {
			basicObject = new ObjetosBasicos(rs.getInt("id_objetos"), rs.getString("nombre"), rs.getInt("precio"),
					rs.getInt("peso"), rs.getString("danio"), rs.getString("curacion"), rs.getString("descripcion"));
		}
		return basicObject;
	}
}