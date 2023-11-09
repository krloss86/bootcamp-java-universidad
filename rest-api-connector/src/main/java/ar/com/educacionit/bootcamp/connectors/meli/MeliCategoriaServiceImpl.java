package ar.com.educacionit.bootcamp.connectors.meli;

import java.util.List;

import ar.com.educacionit.bootcamp.connectors.meli.dto.Categoria;

public class MeliCategoriaServiceImpl implements MeliCategoriaService {

	private MeliConnector executor;
	
	public MeliCategoriaServiceImpl(String url) {
		executor = new MeliConnector(url);
	}
	
	public Categoria getCategoria(String categoria) {
		return this.executor.get("/categories/"+categoria);
	}

	public List<Categoria> findCategorias() {
		return executor.find("/sites/MLA/categories");
	}

	public void creatCategoria(Categoria dto) {
		executor.create(dto);
	}
}
