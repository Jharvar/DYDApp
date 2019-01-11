package db;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBMetada {

	//Atributos de la clase
	private String nombre;
	private String driver;
	private String url;
	private String usuario;
	private String schema;
	private String tabla;
	//Atributos de tipo operacion
	private DatabaseMetaData dbmd;
	private ResultSet rs;
	private Conexion conexion;
	private ArrayList<String> listadoTablas;
	public DBMetada() {
		conexion = new Conexion();
		listadoTablas = new ArrayList<>();
		try {
		conexion.openConexion();
		dbmd = conexion.openConexion().getMetaData();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
	public String getNombre() throws SQLException {
		return nombre = dbmd.getDatabaseProductName();
	}
	public String getDriver() throws SQLException{
		return driver = dbmd.getDriverName();
	}
	public String getUrl() throws SQLException{
		return url = dbmd.getURL();
	}
	public String getUserName() throws SQLException{
		return usuario = dbmd.getUserName();
	}
	public String getSchema() throws SQLException{
		rs = dbmd.getTables(null, "dyd", null, null);
		if(rs.next()) {
			schema = rs.getString(2);
		}
		return schema;
	}
	public ArrayList<String> getTableList() throws SQLException{
		listadoTablas.clear();
		if(listadoTablas.isEmpty()) {
			rs = dbmd.getTables(null, "dyd", null, null);
			while(rs.next()) {
				tabla = rs.getString(4);
				listadoTablas.add(tabla);
			}
		}
		
		return listadoTablas;
	}
	
	public void closeConections()  {
		try {
			if(!conexion.openConexion().isClosed()) {
				rs.close();
				conexion.closeConexion();
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
