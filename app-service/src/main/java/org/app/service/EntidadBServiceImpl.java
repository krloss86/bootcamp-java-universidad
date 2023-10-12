package org.app.service;

import ar.com.educacionit.bootcamp.EntidadB;
import ar.com.educacionit.bootcamp.repository.EntidadBRepositoryImpl;

public class EntidadBServiceImpl extends AbstractEntidadBaseService<EntidadB> implements EntidadBService {
	
	public EntidadBServiceImpl() {
		super(new EntidadBRepositoryImpl());
	}

}
