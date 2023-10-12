package ar.com.educacionit.bootcamp.repository;

import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.bootcamp.EntidadA;

public class EntidadARepositoryImpl extends BaseCrud<EntidadA> implements EntidadARepository {

	public EntidadARepositoryImpl() {
		super(EntidadA.class, "tablaa");
	}

	@Override
	public Collection<EntidadA> findByAtributoX() {
		System.out.println("Buscando algo en la base por el atributX de la entidad EntidadA");
		return new ArrayList<>();
	}

}
