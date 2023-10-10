package ar.com.educacionit.bootcamp.repository;

import java.util.Collection;

import ar.com.educacionit.bootcamp.EntidadA;

public interface EntidadARepository {
	public void save(EntidadA entidad);//guardar (db, archivo, memoria, etc) 
	public void delete(String id);//eliminar (db, archivo, memoria, etc) 
	public void update(EntidadA entidad);//actualizar (db, archivo, memoria, etc) 
	public EntidadA getById(String id);//actualizar (db, archivo, memoria, etc)
	public Collection<EntidadA> findAll();
	//agrego aca lo que necesito
}
