package ar.com.educacionit.bootcamp.connectors.reqres;

import java.util.List;

import ar.com.educacionit.bootcamp.connectors.RestClientConnector;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public class ReqResRestConnector extends RestClientConnector<PostRequestResponseDTO> {

	public ReqResRestConnector(String url) {
		super(url, PostRequestResponseDTO.class, new GenericType<List<PostRequestResponseDTO>>() {
		});
	}

	@Override
	public PostRequestResponseDTO create(Object dto) {
		Invocation.Builder invocation = super.buildInvocationBuilder("/api/users");

		Response response = this.buildPost(invocation, dto);

		if (response.getStatus() != Status.CREATED.getStatusCode()) {
			throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
		}

		return this.buildFromResponse(response);
	}
}
