package ar.com.educacionit.rest;

import java.net.URI;
import java.util.Optional;

import org.app.service.ArticuloService;
import org.app.service.ServiceLocator;

import ar.com.educacionit.bootcamp.Articulo;
import ar.com.educacionit.rest.dto.articulo.ArticuloMapper;
import ar.com.educacionit.rest.dto.articulo.ArticuloRequest;
import ar.com.educacionit.rest.dto.articulo.ArticuloRequestID;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("articulo")
public class ArticuloResource {

	private ArticuloService articuloService = (ArticuloService) ServiceLocator.getService(ArticuloService.class);

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postIt(ArticuloRequest input) {

		Articulo newArticulo = articuloService.buscarPoISBN(input.isbn());
		
		if(newArticulo != null) {
			return Response.created(URI.create("/articulo/" + newArticulo.getId())).build();
		}
		
		newArticulo = ArticuloMapper.INSTANCE.toArticulo(input);

		articuloService.guardar(newArticulo);

		return Response.created(URI.create("/articulo/" + newArticulo.getId())).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIt(@PathParam("id") Long id) {

		// no retornar nuestra Entity (Articulo)
		// un DTO
		Optional<Articulo> art = articuloService.buscarPoId(id);
		
		if(art.isEmpty()) {
			return Response.noContent().build();	
		}

		// conversion de Articulo entity a Record ArticuloResponse
		return Response.ok(ArticuloMapper.INSTANCE.toArticuloDto(art.get())).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeIt(@PathParam("id") Long id) {

		articuloService.eliminarPorId(id);

		return Response.ok().build();
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateIt(
			@PathParam("id") Long id,
			ArticuloRequestID input) {
		
		Optional<Articulo> articuloOptional = articuloService.buscarPoId(id);
		if(articuloOptional.isEmpty()) {
			return Response.status(Status.NOT_FOUND).build();//404
		}
		
		Articulo art = articuloOptional.get();
		if(!art.getId().equals(input.id())) {
			return Response.status(Status.CONFLICT).entity(input).build();//409
		}
		
		art.setIdioma(input.idioma());
		art.setNroPaginas(input.nroPaginas());
		art.setIsbn(input.isbn());
		
		articuloService.actualizar(art);
		
		return Response.ok(art).build();
	}
	
}
