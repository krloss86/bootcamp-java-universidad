package ar.com.educacionit.bootcamp.controllers.jersey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.educacionit.bootcamp.connectors.RestClientConnector;
import ar.com.educacionit.bootcamp.controllers.jersey.meli.dto.Categoria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings({"serial","rawtypes","unchecked"})

@WebServlet("/meli/categoria")
public class MeliController extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RestClientConnector<List<Categoria>> connector = new RestClientConnector(
				"https://api.mercadolibre.com/sites/MLA/categories", 
				Categoria.class); 

		List<Categoria> type = new ArrayList<>();
		
		List<Categoria> categorias = connector.execute();
		
		ObjectMapper mapper = new ObjectMapper(); 
		String json = mapper.writeValueAsString(categorias);
		
		resp.getWriter().print(json);
	}
}
