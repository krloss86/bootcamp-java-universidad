package ar.com.educacionit.bootcamp.connectors.meli;

import java.util.List;

import ar.com.educacionit.bootcamp.connectors.RestClientConnector;
import ar.com.educacionit.bootcamp.connectors.meli.dto.Categoria;
import jakarta.ws.rs.core.GenericType;

public class MeliConnector extends RestClientConnector<Categoria>{

	public MeliConnector(String url) {
		super(url, Categoria.class,new GenericType<List<Categoria>>() {});
	}
	
}
