package ar.com.educacionit.bootcamp.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;

import org.app.service.ArticuloService;
import org.app.service.ServiceLocator;

import ar.com.educacionit.bootcamp.Articulo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/articulo")
public class ArticuloController extends HttpServlet{

	private static final long serialVersionUID = -8497230951902767955L;
	private ArticuloService service = (ArticuloService )ServiceLocator.getService(ArticuloService.class);

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// /api/articulo/id
		if(req.getParameter("id") == null || req.getParameter("id").isEmpty()) {
			Collection<Articulo> articulos = service.buscarTodos();
			resp.getWriter().print(articulos);
		}else {
			Long id = Long.parseLong(req.getParameter("id"));		
			Articulo articulo = service.buscarPoId(id);		
			resp.getWriter().print(articulo);
		}		
	}
	
	//alta de articulo	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		//recibir datos por request!!
		ArticuloRequestVO input = new ArticuloRequestVO(req);
		
		LocalDate fechaPublicacion = LocalDate.now();
		
		//Collection<Articulo> entity  = service.buscarTodos();
		Articulo newArticulo = new Articulo(input.getEditorial(),
				input.getIsbn(), 
				input.getNroPaginas(),
				input.getIdioma(),
				fechaPublicacion);
		
		service.guardar(newArticulo);
		
		resp.getWriter().print("articulo id:" + newArticulo.getId() + " alta ok");
	}
	
}
