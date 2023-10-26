package org.app.service;

import ar.com.educacionit.bootcamp.Rol;
import ar.com.educacionit.bootcamp.repository.RoleRepositoryImpl;

public class RoleServiceImpl extends AbstractEntidadBaseService<Rol> implements RoleService {
	
	public RoleServiceImpl() {
		super(new RoleRepositoryImpl());
	}

}
