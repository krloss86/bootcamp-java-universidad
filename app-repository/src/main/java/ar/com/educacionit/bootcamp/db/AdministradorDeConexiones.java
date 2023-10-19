package ar.com.educacionit.bootcamp.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexiones {

	public static Connection getConnection() {
		String usernameDb = "root";
		String passwordDb = "secret";
		String url = "jdbc:mysql://127.0.0.1/educacionit-bootcamp-vicente-lopez?serverTimeZone=UTC&userSSL=false";//mysql|postgress|oracle
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		
		try {
			//carga dinamicamente el diver en la jvm
			Class.forName(driverClassName);
			
			return DriverManager.getConnection(url,usernameDb,passwordDb);
		}catch (Exception e) {
			throw new IllegalArgumentException("No se pudo obtener conexion para:" + url + " - " + driverClassName);
		}
	}
}
