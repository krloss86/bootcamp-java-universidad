package ar.com.educacionit.bootcamp.connectors;

import java.util.List;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.Invocation.Builder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public abstract class RestClientConnector<T> {

	private String url;
	private Class<T> type;
	private GenericType<List<T>> listType;

	public RestClientConnector(String url, Class<T> type, GenericType<List<T>> listType) {
		this.url = url;
		this.type = type;
		this.listType = listType;
	}

	public T get() {

		Invocation.Builder invoBuilder = commongLogic();
		
		Response response = invoBuilder.get();
		
		T responseDto = this.buildFromResponse(response);

		return responseDto;
	}

	public List<T> find() {

		Invocation.Builder invoBuilder = commongLogic();
		
		Response response = invoBuilder.get(); 
		
		List<T> responseDto = this.buildListFromResponse(response);

		return responseDto;
	}
	
	public void create(T dto) {

		Invocation.Builder invocation = commongLogic();
		
		Response response = this.buildPost(invocation, dto);

		if (response.getStatus() != Status.OK.getStatusCode()) {
			throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
		}
		
		// T responseDto = this.buildFromResponse(response);

		//return responseDto;
	}
	
	protected abstract Response buildPost(Builder invocation, T dto);

	private Invocation.Builder commongLogic() {
		Client client = ClientBuilder.newClient();

		WebTarget target = this.buildWebTarget(client);

		Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);

		/*Response response = this.buildResponse(invocation);

		if (response.getStatus() != Status.OK.getStatusCode()) {
			throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
		}
		return response;
		*/
		return invocation;
	}


	protected T buildFromResponse(Response response) {
		// un objeto simple
		return response.readEntity(this.type);
	}

	protected List<T> buildListFromResponse(Response response) {
		return response.readEntity(this.listType);
	}

	private WebTarget buildWebTarget(Client client) {
		return client.target(url);
	}
}
