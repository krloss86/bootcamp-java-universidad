package ar.com.educacionit.bootcamp.repository;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseCrud<T> implements BaseRepository<T> {

	private Class<T> type;
	private String table;
	
	public BaseCrud(Class<T> type,String table) {
		this.type = type;
		this.table = table;
	}
	
	@Override
	public void delete(String id) {
		//eliminar entidad por id
		System.out.println("Eliminandio " + type.getName() + "por id="+id);
	}
	
	@Override
	public Collection<T> findAll() {
		System.out.println("findAll " + type.getName());
		return new ArrayList<>();
	}
	@Override
	public T getById(String id) {
		System.out.println("Buscando " + type.getName() + "por id="+id);
		
		//Api Reflection
		return null;
	}
	@Override
	public void save(T entidad) {
		System.out.println("Grabando " + type.getName() + entidad);		
	}
	
	@Override
	public void update(T entidad) {
		System.out.println("Actualizando " + type.getName() + entidad);		
	}
}
