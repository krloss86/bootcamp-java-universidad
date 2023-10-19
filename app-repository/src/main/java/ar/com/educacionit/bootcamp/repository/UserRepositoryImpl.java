package ar.com.educacionit.bootcamp.repository;

import ar.com.educacionit.bootcamp.User;

public class UserRepositoryImpl extends BaseCrud<User> implements UserRepository {

	public UserRepositoryImpl() {
		super(User.class, "user");
	}


}
