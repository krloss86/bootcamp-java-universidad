package ar.com.educacionit.rest.dto.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class UserRequestDTOTestCase {
	
	@Test
	public void when_create_then_exists() {
		//given
		var requestDTO = new UserRequestDTO(1l, "carlos");
		
		//then
		assertNotNull(requestDTO);
		
		//when		
	}
	
	@Test
	public void when_create_with_1_and_carlos_then_verify() {
		//given
		var requestDTO = new UserRequestDTO(1l, "carlos");
		
		//then
		assertEquals(1L,requestDTO.id());
		assertEquals("carlos",requestDTO.username());
		
		//when		
	}
}
