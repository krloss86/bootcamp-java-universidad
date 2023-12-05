package ar.com.educacionit.bootcamp.db;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ar.com.educacionit.bootcamp.db.AdministradorDeConexiones;

@TestMethodOrder(OrderAnnotation.class)
public class AdministradorDeConexionesTestCase {

	@Test
	@Disabled
	@Order(2)
	public void when_get_connection_then_fail() {

		assertThrows(IllegalArgumentException.class, () -> AdministradorDeConexiones.getConnection());
	}
	
	@Test
	@Order(1)
	@DisplayName("Cuando obtenemos conexion, validar!")
	public void when_get_connection_then_ok() {
		assertNotNull(AdministradorDeConexiones.getConnection());
	}
}
