package ar.com.educacionit.bootcamp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.educacionit.bootcamp.User;

public class UserRepositoryImpl extends BaseCrud<User> implements UserRepository {

	public UserRepositoryImpl() {
		super(User.class, "USER");
	}

	@Override
	protected User fromResultSetToEntity(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong(1);
		String useranme = resultSet.getString(2);
		String password = resultSet.getString(3);
		
		return new User(id, useranme, password);
	}

}
