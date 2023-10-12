package ar.com.educacionit.bootcamp.repository;

import ar.com.educacionit.bootcamp.EntidadB;

public class EntidadBRepositoryImpl extends BaseCrud<EntidadB> implements EntidadBRepository {

	public EntidadBRepositoryImpl() {
		super(EntidadB.class, "tablab");
	}


}
