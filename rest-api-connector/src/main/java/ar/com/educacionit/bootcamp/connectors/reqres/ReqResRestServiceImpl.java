package ar.com.educacionit.bootcamp.connectors.reqres;

public class ReqResRestServiceImpl implements ReqResRestService {

	private ReqResRestConnector connector;
	
	public ReqResRestServiceImpl(String url) {
		this.connector = new ReqResRestConnector(url);
	}


	@Override
	public PostRequestResponseDTO create(PostRequestDTO request) {
		return this.connector.create(request);
	}

}
