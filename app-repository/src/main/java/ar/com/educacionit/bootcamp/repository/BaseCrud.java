package ar.com.educacionit.bootcamp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import ar.com.educacionit.bootcamp.Entity;
import ar.com.educacionit.bootcamp.db.AdministradorDeConexiones;
							/*                   */
public abstract class BaseCrud<T extends Entity> implements BaseRepository<T> {

	private Class<T> type;
	protected String table;
	
	public BaseCrud(Class<T> type,String table) {
		this.type = type;
		this.table = table;
	}
	
	@Override
	public void delete(Long id) {
		//eliminar entidad por id
		System.out.println("Eliminandio " + type.getName() + "por id="+id);
		//														 1 2 3 4 5.. N
		String sql = "DELETE FROM "+ this.table + " WHERE ID = ?";
		
		try(Connection connection = AdministradorDeConexiones.getConnection()) {
			
			PreparedStatement statement = connection.prepareStatement(sql);
			//                ?
			statement.setLong(1, id);
			
			int res = statement.executeUpdate();
			if(res > 0) {
				System.out.println("Se elimino el id:" + id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public Collection<T> findAll() {
		System.out.println("findAll " + type.getName());
		String sql = "SELECT * FROM "+ this.table;
		List<T> list = new ArrayList<>();
		
		try(Connection connection = AdministradorDeConexiones.getConnection()) {
			
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {//hay registro que mirar
				list.add(this.fromResultSetToEntity(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return list;
	}
	
	@Override
	public Optional<T> getById(Long id) {
		String sql = "SELECT * FROM "+ this.table + " WHERE ID = " + id;
		System.out.println(sql);
		T entity = null;
		
		//JDBC: par poder consultar a la tabla via java
		
		try(Connection connection = AdministradorDeConexiones.getConnection()) {
			
			//armar el sql
			PreparedStatement statement = connection.prepareStatement(sql);
			
			//recibir los datos
			ResultSet resultSet = statement.executeQuery();
			
			//id|col2|colmN
			//procesar los registro
			if(resultSet.next()) {//hay registro que mirar
				//extraigo los datos
				entity = this.fromResultSetToEntity(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		//Api Reflection
		return Optional.ofNullable(entity);
	}
	
	//cada RespositoryImpl debe implementar como extrae la data desde ResultSet
	protected abstract T fromResultSetToEntity(ResultSet res) throws SQLException;
	
	@Override
	public void save(T entidad) {
		String sql ="INSERT INTO " + this.table + this.getSaveSQL();
		System.out.println(sql);
		try(Connection connection = AdministradorDeConexiones.getConnection()) {
			
			PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			saveEntity(entidad, statement);
			
			statement.executeUpdate();
			
			ResultSet resKey = statement.getGeneratedKeys();
			if(resKey.next()) {
				entidad.setId(resKey.getLong(1));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
	
	protected abstract String getSaveSQL();
	protected abstract void saveEntity(T entidad,PreparedStatement pst) throws SQLException;
	
	//update es similar al save!!!
	//ver que campos son actualizables 
	@Override
	public void update(T entidad) {
		String sql = "update " + this.table + " set " + getUpdateSQL() + " where id = ?";
		
		try(Connection connection = AdministradorDeConexiones.getConnection()) {
			
			PreparedStatement statement = connection.prepareStatement(sql);

			setUpdateSQL(entidad, statement);
			
			statement.setLong(getLast(sql),(Long)entidad.getId());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public int getLast(String sql) {
		int idx = 0;
		for(char c : sql.toCharArray()) {
			if(c == '?') {
				idx ++;
			}
		}
		return idx;
	}

	protected abstract String getUpdateSQL();
	protected abstract void setUpdateSQL(T entity, PreparedStatement pst) throws SQLException;
	
	public List<T> findBySQL(String sql) {
		List<T> list = new ArrayList<>();
		
		try(Connection connection = AdministradorDeConexiones.getConnection()) {
			
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {//hay registro que mirar
				list.add(this.fromResultSetToEntity(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return list;
	}
	
}
