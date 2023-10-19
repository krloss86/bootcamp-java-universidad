package ar.com.educacionit.bootcamp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.bootcamp.User;
import ar.com.educacionit.bootcamp.db.AdministradorDeConexiones;

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
		String sql = "SELECT * FROM "+ this.table + " WHERE ID = " + id;
		
		User user = null;
		
		//JDBC: par poder consultar a la tabla via java
		
		try(Connection connection = AdministradorDeConexiones.getConnection()) {
			//armar el sql
			PreparedStatement statement = connection.prepareStatement(sql);
			
			//recibir los datos
			ResultSet resultSet = statement.executeQuery();
			
			//procesar los registro
			if(resultSet.next()) {//hay registro que mirar
				//extraigo los datos
				Long _id = resultSet.getLong(1);
				String useranme = resultSet.getString(2);
				String password = resultSet.getString(3);
				
				user = new User(_id, useranme, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		//Api Reflection
		return (T)user;
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
