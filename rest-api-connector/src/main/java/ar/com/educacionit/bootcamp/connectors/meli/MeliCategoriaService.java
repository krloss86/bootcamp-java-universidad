package ar.com.educacionit.bootcamp.connectors.meli;

import java.util.List;

import ar.com.educacionit.bootcamp.connectors.meli.dto.Categoria;

public interface MeliCategoriaService {

	public Categoria getCategoria(String categoria);
	public void creatCategoria(Categoria dto);
	public List<Categoria> findCategorias();
}
