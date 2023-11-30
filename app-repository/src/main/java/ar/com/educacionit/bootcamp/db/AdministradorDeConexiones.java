package ar.com.educacionit.bootcamp.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexiones {

	public static Connection getConnection() {
		String usernameDb = System.getenv("USERNAME");
		String passwordDb = System.getenv("PASSWORD");
		String url = "jdbc:mysql://127.0.0.1:33060/educacionit-bootcamp-vicente-lopez?allowPublicKeyRetrieval=true&serverTimeZone=UTC&useSSL=false";//mysql|postgress|oracle
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		
		try {
			//carga dinamicamente el diver en la jvm
			Class.forName(driverClassName);
			
			return DriverManager.getConnection(url,usernameDb,passwordDb);
		}catch (Exception e) {
			throw new IllegalArgumentException("No se pudo obtener conexion para:" + url + " - " + driverClassName,e);
		}
	}
}
