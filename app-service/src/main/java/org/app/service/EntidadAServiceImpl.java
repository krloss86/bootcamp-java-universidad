package org.app.service;

import java.util.Collection;

import ar.com.educacionit.bootcamp.EntidadA;
import ar.com.educacionit.bootcamp.repository.EntidadARepository;
import ar.com.educacionit.bootcamp.repository.EntidadARepositoryImpl;

public class EntidadAServiceImpl implements EntidadAService {

	private EntidadARepository repository;
	
	public EntidadAServiceImpl() {
		this.repository = new EntidadARepositoryImpl();
	}
	
	@Override
	public Collection<EntidadA> buscarTodos() {		
		return this.repository.findAll();
	}
	
}
