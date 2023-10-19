package org.app.service;

import ar.com.educacionit.bootcamp.User;
import ar.com.educacionit.bootcamp.repository.UserRepositoryImpl;

public class UserServiceImpl extends AbstractEntidadBaseService<User> implements UserService {
	
	public UserServiceImpl() {
		super(new UserRepositoryImpl());
	}

}
