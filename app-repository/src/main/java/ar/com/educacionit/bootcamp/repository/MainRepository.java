package ar.com.educacionit.bootcamp.repository;

public class MainRepository {

	public static void main(String[] args) {

		EntidadARepository repository = new EntidadARepositoryImpl();		
		repository.findAll();
		repository.findByAtributoX();
		
		EntidadBRepository repositoryB = new EntidadBRepositoryImpl();		
		repositoryB.findAll();
	}

}
