package ar.com.educacionit.bootcamp.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ar.com.educacionit.bootcamp.Articulo;

@TestMethodOrder(OrderAnnotation.class)
public class ArticuloRepositoryTestCase {

	@Order(1)
	@Test
	public void when_create_then_validate() {
		ArticuloRepository repository = new InMenArticuloRepositoryImpl();
		assertNotNull(repository);
	}

	@Test
	@Order(2)
	public void when_create_new_articulo_then_persistIt() {

		ArticuloRepository repository = new InMenArticuloRepositoryImpl();

		Articulo entity = new Articulo(1l, 1234567891L, 15, "espñol", LocalDate.now());

		repository.save(entity);

		assertNotNull(entity.getId());

		repository.delete((Long) entity.getId());
	}

	@Test
	@Order(3)
	public void when_create_without_isbn_then_fail() {

		ArticuloRepository repository = new InMenArticuloRepositoryImpl();

		assertThrows(RuntimeException.class, () -> {

			Articulo entity = new Articulo(1l, null, 15, "espñol", LocalDate.now());

			repository.save(entity);
		});

	}
	
	@Test
	@Order(4)
	public void when_create_duplicated_articulo_then_fail() {

		ArticuloRepository repository = new InMenArticuloRepositoryImpl();

		Articulo entity = new Articulo(1l, 1234567891L, 15, "espñol", LocalDate.now());

		repository.save(entity);

		assertThrows(RuntimeException.class, () -> {

			repository.save(entity);
		});
		
		repository.delete((Long) entity.getId());
	}
	
	@Test
	@Order(5)
	public void when_articulo_exist_then_deleteIt() {

		ArticuloRepository repository = new InMenArticuloRepositoryImpl();

		Articulo entity = new Articulo(1l, 1234567891L, 15, "espñol", LocalDate.now());

		repository.save(entity);
				
		repository.delete((Long) entity.getId());	
		
		//assertThrows(NoSuchElementException.class, () -> repository.getById((Long)entity.getId()).get());
		
		Optional<Articulo> inDb = repository.getById((Long)entity.getId());
		
		assertTrue(inDb.isEmpty());
	}
}
