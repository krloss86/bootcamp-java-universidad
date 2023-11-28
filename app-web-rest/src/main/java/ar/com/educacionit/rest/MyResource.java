package ar.com.educacionit.rest;

import org.app.service.ServiceLocator;
import org.app.service.UserService;

import ar.com.educacionit.rest.dto.user.UserRequestDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("myresource")
public class MyResource {

	private UserService userService = (UserService)ServiceLocator.getService(UserService.class);
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
        return Response.ok(userService.buscarTodos()).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postIt(
    		UserRequestDTO request
		) {
    	return Response.ok(request).build();
    }
    
    //public record Resource (Long id, String descripcion) { }
}
