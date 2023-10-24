package org.modulo.b;

import java.sql.Connection;

import ar.com.educacionit.bootcamp.db.AdministradorDeConexiones;

public class AppTest {
	public static void main(String[] args) {

		Connection con = AdministradorDeConexiones.getConnection();

		System.out.println(con);
	}
}
