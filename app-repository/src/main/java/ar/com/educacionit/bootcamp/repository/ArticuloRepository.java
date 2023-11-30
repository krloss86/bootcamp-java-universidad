package ar.com.educacionit.bootcamp.repository;

import ar.com.educacionit.bootcamp.Articulo;

public interface ArticuloRepository extends BaseRepository<Articulo>{

	public Articulo getByISBN(Long isbn);
}
