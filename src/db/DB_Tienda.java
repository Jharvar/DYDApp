package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Armaduras;
import clases.Armas;
import clases.Categorias;
import clases.Jugadores;
import clases.ObjetoMaravilloso;
import clases.ObjetoBasico;

public class DB_Tienda extends DB {

	// Atributos de la clase para obtener objetos únicos
	private Armas weapon;
	private Armaduras armor;
	private ObjetoBasico basicObject;
	private ObjetoMaravilloso magicObject;

	// Atributos de la clase
	private ArrayList<Categorias> listaCategorias;
	private ArrayList<Armas> listaArmas;
	private ArrayList<Armaduras> listaArmaduras;
	private ArrayList<ObjetoBasico> listaObjetosBasicos;
	private ArrayList<ObjetoMaravilloso> listaObjetosMaravillosos;

	private ArrayList<Jugadores> listaJugadores;

	// Atributos de operaciones
	private Conexion conexion;
	private Statement st;
	private ResultSet rs;

	public DB_Tienda() {
		conexion = new Conexion();
		listaJugadores = getJugadores();
	}

	/**
	 * 
	 * @return {@link ArrayList}
	 */

	public ArrayList<Categorias> keepCategories() {
		try {
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
		} catch (SQLException e) {
			return null;
		}
		return listaCategorias;
	}

	/**
	 * 
	 * @param id_objeto
	 * @return {@link ArrayList}
	 * @throws SQLException
	 */

	public ArrayList<?> keepObjects(int id_objeto) {
		try {
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
				rs = st.executeQuery("SELECT * FROM objeto_maravilloso");
				return keepMagicObject(rs);
			}
			return null;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	/**
	 * @param rs
	 * @return {@link ArrayList}
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
	 * @return {@link ArrayList}
	 * @throws SQLException
	 */
	public ArrayList<Armaduras> keepArmors(ResultSet rs) throws SQLException {
		listaArmaduras = new ArrayList<>();
		while (rs.next()) {
			listaArmaduras.add(new Armaduras(rs.getInt("id_armaduras"), rs.getString("nombre"), rs.getInt("precio"),
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
	 * @return {@link ArrayList}
	 * @throws SQLException
	 */
	public ArrayList<ObjetoBasico> keepBasicObjects(ResultSet rs) throws SQLException {
		listaObjetosBasicos = new ArrayList<>();
		while (rs.next()) {
			listaObjetosBasicos.add(new ObjetoBasico(rs.getInt("id_objetos"), rs.getString("nombre"),
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
	 * @param rs
	 * @return {@link ArrayList}
	 * @throws SQLException
	 */

	public ArrayList<ObjetoMaravilloso> keepMagicObject(ResultSet rs) throws SQLException {
		listaObjetosMaravillosos = new ArrayList<>();
		while (rs.next()) {
			listaObjetosMaravillosos.add(new ObjetoMaravilloso(rs.getInt("id_objeto_maravilloso"),
					rs.getString("nombre"), rs.getInt("precio"), rs.getInt("peso"), rs.getString("tipo_de_objeto"),
					rs.getString("descripcion")));
		}
		rs.close();
		st.close();
		conexion.closeConexion();
		return listaObjetosMaravillosos;
	}

	/**
	 * 
	 * @param categoria
	 * @param id_objeto
	 * @return {@link Object}
	 * 
	 */

	public Object getObjectToCategoria(int categoria, int id_objeto) {
		switch (categoria) {
		case 1:
			return getWeapon(id_objeto);
		case 2:
			return getArmor(id_objeto);
		case 3:
			return getBasicObject(id_objeto);
		case 4:

			return getMagicObject(id_objeto);

		}
		return null;
	}

	/**
	 * 
	 * 
	 * @param id_objeto
	 * 
	 * @param id_objeto
	 * 
	 * @return {@link Armas}
	 * 
	 */
	public Armas getWeapon(int id_objeto) {
		try {
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
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	/**
	 * 
	 * @param id_objeto
	 * @return {@link Armaduras}
	 * 
	 */
	public Armaduras getArmor(int id_objeto) {
		try {
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
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	/**
	 * 
	 * @param id_objeto
	 * @return {@link ObjetoBasico}
	 * 
	 */
	public ObjetoBasico getBasicObject(int id_objeto) {
		try {
			conexion.openConexion();
			st = conexion.openConexion().createStatement();
			rs = st.executeQuery("SELECT * FROM objetos_basicos WHERE id_objetos='" + id_objeto + "'");
			if (rs.first()) {
				basicObject = new ObjetoBasico(rs.getInt("id_objetos"), rs.getString("nombre"), rs.getInt("precio"),
						rs.getInt("peso"), rs.getString("danio"), rs.getString("curacion"),
						rs.getString("descripcion"));
			}
			return basicObject;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;

		}

	}

	/**
	 * 
	 * @param id_objeto
	 * @return {@link ObjetoMaravilloso}
	 */

	public ObjetoMaravilloso getMagicObject(int id_objeto) {
		try {
			conexion.openConexion();
			st = conexion.openConexion().createStatement();
			rs = st.executeQuery("SELECT * FROM objeto_maravilloso WHERE id_objeto_maravilloso='" + id_objeto + "'");
			if (rs.first()) {
				magicObject = new ObjetoMaravilloso(rs.getInt("id_objeto_maravilloso"), rs.getString("nombre"),
						rs.getInt("precio"), rs.getInt("peso"), rs.getString("tipo_de_objeto"),
						rs.getString("descripcion"));
			}
			return magicObject;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}

	/**
	 * 
	 * @return {@link ArrayList}
	 */
	public ArrayList<Jugadores> getJugadores() {
		try {
			listaJugadores = new ArrayList<>();
			conexion.openConexion();
			st = conexion.openConexion().createStatement();
			rs = st.executeQuery("SELECT * FROM jugadores");
			while (rs.next()) {
				listaJugadores.add(new Jugadores(rs.getInt("id_jugador"), rs.getString("personaje"),
						rs.getString("clase"), rs.getString("dinero")));

			}

			rs.close();
			st.close();
			conexion.closeConexion();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listaJugadores;

	}

	/**
	 * 
	 * @param user
	 * @param money
	 * @return <code>true</code>
	 */

	public boolean isClient(int chatId) {
		if (listaJugadores.isEmpty()) {
			listaJugadores = getJugadores();
			for (int i = 0; i < listaJugadores.size(); i++) {
				if (chatId == listaJugadores.get(i).getIdPersonaje()) {
					return true;
				}
			}
		} else {
			for (int i = 0; i < listaJugadores.size(); i++) {
				if (chatId == listaJugadores.get(i).getIdPersonaje()) {
					return true;
				}
			}
			return false;
		}
		return false;
	}
}