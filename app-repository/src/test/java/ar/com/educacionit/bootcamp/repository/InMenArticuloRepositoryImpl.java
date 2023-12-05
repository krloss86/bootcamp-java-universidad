package ar.com.educacionit.bootcamp.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import ar.com.educacionit.bootcamp.Articulo;

public class InMenArticuloRepositoryImpl implements ArticuloRepository{

	private Map<Long, Articulo> inMemDB = new HashMap<>();
	
	@Override
	public void save(Articulo entidad) {
		if(entidad.getIsbn() == null) {
			throw new RuntimeException("ISBN nulo");
		}
		
		if(inMemDB.get(entidad.getId()) != null) {
			throw new RuntimeException("Duplicado");
		}
		
		Long id = (long)(Math.random() * 100000);
		entidad.setId(id);
		inMemDB.put(id, entidad);		
	}

	@Override
	public void delete(Long id) {
		inMemDB.remove(id);		
	}

	@Override
	public void update(Articulo entidad) {
		inMemDB.put((Long)entidad.getId(), entidad);	
	}

	@Override
	public Optional<Articulo> getById(Long id) {
		return Optional.ofNullable(inMemDB.get(id));
	}

	@Override
	public Collection<Articulo> findAll() {
		return inMemDB.values();
	}

	@Override
	public Articulo getByISBN(Long isbn) {
		Optional<Articulo> op =  inMemDB.values()
				.stream()
				.filter(x -> x.getIsbn().equals(isbn))//intermedia
				.findFirst();//terminal
		return op.orElseThrow();
	}

}
