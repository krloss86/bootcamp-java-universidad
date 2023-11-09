package ar.com.educacionit.bootcamp.controllers.jersey;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.educacionit.bootcamp.connectors.meli.MeliCategoriaService;
import ar.com.educacionit.bootcamp.connectors.meli.MeliCategoriaServiceImpl;
import ar.com.educacionit.bootcamp.connectors.meli.dto.Categoria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/meli/categoria")
public class MeliController extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MeliCategoriaService servieRest = new MeliCategoriaServiceImpl("https://api.mercadolibre.com");

		Categoria c = new Categoria();
		c.setId("12345");
		c.setName("Name");
		
		servieRest.creatCategoria(c);
		
//		List<Categoria> categorias = servieRest.findCategorias();
//		Categoria categoria = servieRest.getCategoria("MLA3530");
//		ObjectMapper mapper = new ObjectMapper();
//		
//		String jsonList = mapper.writeValueAsString(categorias);
////		String json = mapper.writeValueAsString(categoria);
//		
//		System.out.println(jsonList);
////		System.out.println(json);
		
//		resp.getWriter().print(jsonList);
	}
}
