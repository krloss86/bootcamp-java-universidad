package org.app.service;

import java.util.List;

import ar.com.educacionit.bootcamp.Rol;
import ar.com.educacionit.bootcamp.User;
import ar.com.educacionit.bootcamp.repository.RoleRepository;
import ar.com.educacionit.bootcamp.repository.RoleRepositoryImpl;
import ar.com.educacionit.bootcamp.repository.UserRepositoryImpl;

public class UserServiceImpl extends AbstractEntidadBaseService<User> implements UserService {
	
	private RoleRepository roleRepository;
	
	public UserServiceImpl() {
		super(new UserRepositoryImpl());
		this.roleRepository = new RoleRepositoryImpl();
	}

	@Override
	public User buscarPoId(Long id) {
		User user = super.buscarPoId(id);
		if(user != null) {
			List<Rol> roles = this.roleRepository.findByUserId(id);
			user.setRoles(roles);
		}
		return user;
	}

}
