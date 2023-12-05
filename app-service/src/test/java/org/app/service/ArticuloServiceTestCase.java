package org.app.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class ArticuloServiceTestCase {

	@Test
	public void when_create_then_exists() {
		ArticuloService service = new ArticuloServiceImpl();
		assertNotNull(service);
	}
	
}
