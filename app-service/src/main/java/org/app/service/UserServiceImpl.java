package org.app.service;

import java.util.List;
import java.util.Optional;

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
	public Optional<User> buscarPoId(Long id) {
		Optional<User> user = super.buscarPoId(id);
		if(user.isPresent()) {
			List<Rol> roles = this.roleRepository.findByUserId(id);
			user.get().setRoles(roles);
		}
		return user;
	}

}
