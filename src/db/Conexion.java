package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	public Connection openConexion()throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/dyd", "jharvar", "venitocamelas");
	}
	public void closeConexion() throws SQLException {
		if(!openConexion().isClosed()) {openConexion().close();}
	}
}
