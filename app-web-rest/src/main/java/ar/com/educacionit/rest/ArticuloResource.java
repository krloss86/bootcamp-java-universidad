package ar.com.educacionit.rest;

import java.net.URI;
import java.time.LocalDate;

import org.app.service.ArticuloService;
import org.app.service.ServiceLocator;

import ar.com.educacionit.bootcamp.Articulo;
import ar.com.educacionit.rest.dto.articulo.ArticuloRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("articulo")
public class ArticuloResource {

	private ArticuloService articuloService = (ArticuloService) ServiceLocator.getService(ArticuloService.class);

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postIt(ArticuloRequest input) {
		LocalDate fechaPublicacion = LocalDate.now();

		// Collection<Articulo> entity = service.buscarTodos();
		Articulo newArticulo = new Articulo(
				input.editorial(), 
				input.isbn(), 
				input.nroPaginas(),
				input.idioma(), 
				fechaPublicacion);

		articuloService.guardar(newArticulo);
		
		return Response.created(
				URI.create("/articulo/"+newArticulo.getId())
			).build();
	}

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt(
    		@QueryParam("id") Long id
    		) {
		
        return Response.ok(
        		articuloService.buscarPoId(id)
    		).build();
    }
	// public record Resource (Long id, String descripcion) { }
}
