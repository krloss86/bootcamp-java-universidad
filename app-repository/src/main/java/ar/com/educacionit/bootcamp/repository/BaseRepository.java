package ar.com.educacionit.bootcamp.repository;

import java.util.Collection;
import java.util.Optional;

public interface BaseRepository<T> {
	public void save(T entidad);

	public void delete(Long id);

	public void update(T entidad);

	public Optional<T> getById(Long id);

	public Collection<T> findAll();
}
