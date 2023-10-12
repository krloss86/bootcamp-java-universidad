package ar.com.educacionit.bootcamp.repository;

import java.util.Collection;

public interface BaseRepository<T> {
	public void save(T entidad);

	public void delete(String id);

	public void update(T entidad);

	public T getById(String id);

	public Collection<T> findAll();
}
