package ar.com.educacionit.bootcamp.controllers.jersey;

import java.io.IOException;
import java.util.List;

import org.app.service.ServiceLocator;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.educacionit.bootcamp.controllers.jersey.meli.dto.Categoria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@WebServlet("/categorias")
public class ListResourceController extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//url del servicio
		String url  = "https://api.mercadolibre.com/sites/";
		
		String endPoint = "MLA/categories";//id viene por parametro
		
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target(url).path(endPoint);
		
		Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);

		Response response = invocation.get(); 
		
		if(response.getStatus() != Status.OK.getStatusCode()) {
			throw new RuntimeException (response.getStatusInfo().getReasonPhrase());
		}
		
		GenericType<List<Categoria>> listType = new GenericType<List<Categoria>>() {}; 
		
		List<Categoria> list = response.readEntity(listType);
		
		//convetir objetos a json usando jackson2
		ObjectMapper mapper = new ObjectMapper(); 
		String json = mapper.writeValueAsString(list);
		
		resp.getWriter().print(json);
	}
}
