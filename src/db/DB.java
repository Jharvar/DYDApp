package db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB {
	//atributos de la clase para establecer la conexion con la base de datos
	private Conexion con;
	private PreparedStatement pr;
	int fila;
	//constructor por defecto para instanciar los atributos
	public DB() {
		con = new Conexion();
		fila =0;
	}
	/**
	 *  metodo para insertar un nuevo registro en la base de datos en la base de datos
	 * @param query
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean insertToDB(String query) throws SQLException {
		con.openConexion();
		if(!con.openConexion().isClosed()){
			pr = con.openConexion().prepareStatement(query);
			fila = pr.executeUpdate();
			if(fila == 1) {
				con.closeConexion();
				return true;
				
			}else {
				fila =0;
				con.closeConexion();
				return false;
			}
		}
		con.closeConexion();
		return false;
	}
	/**
	 * metodo que actualiza un registro de una tabla de la base de datos
	 * @param query
	 * @return booleam
	 * @throws SQLException
	 */
	public boolean updateToDB(String query) throws SQLException{
		con.openConexion();
		if(!con.openConexion().isClosed()) {
			pr = con.openConexion().prepareStatement(query);
			fila = pr.executeUpdate();
			if(fila == 1) {
				con.closeConexion();
				return true;
			}else {
				fila = 0;
				con.closeConexion();
				return false;
			}
		}
		con.closeConexion();
		return false;
	}
	/**
	 * 
	 * @param query
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean deleteToDB(String query) throws SQLException {
		con.openConexion();
		if(!con.openConexion().isClosed()) {
			pr= con.openConexion().prepareStatement(query);
			fila = pr.executeUpdate();
			if(fila ==1) {
				con.closeConexion();
				return true;
			}else {
				fila =0;
				con.closeConexion();
				return false;
			}
		}
		con.closeConexion();
		return false;
	}
}
