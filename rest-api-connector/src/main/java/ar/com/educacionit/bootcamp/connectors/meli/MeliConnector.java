package ar.com.educacionit.bootcamp.connectors.meli;

import java.util.List;

import ar.com.educacionit.bootcamp.connectors.RestClientConnector;
import ar.com.educacionit.bootcamp.connectors.meli.dto.Categoria;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation.Builder;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class MeliConnector extends RestClientConnector<Categoria>{

	public MeliConnector(String url) {
		super(url, Categoria.class,new GenericType<List<Categoria>>() {});
	}

	protected Response buildPost(Builder invocation, Categoria dto) {
		return invocation.post(Entity.entity(dto,MediaType.APPLICATION_JSON));
	}
	
}
