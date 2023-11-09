package org.app.console;

import ar.com.educacionit.bootcamp.connectors.reqres.PostRequestDTO;
import ar.com.educacionit.bootcamp.connectors.reqres.PostRequestResponseDTO;
import ar.com.educacionit.bootcamp.connectors.reqres.ReqResRestService;
import ar.com.educacionit.bootcamp.connectors.reqres.ReqResRestServiceImpl;


public class ReqResController {

	public static void main(String[] args) {
		
		ReqResRestService servieRest = new ReqResRestServiceImpl("https://reqres.in");
		
		PostRequestDTO request = new PostRequestDTO("nombre", "carpitero");
		
		PostRequestResponseDTO response = servieRest.create(request);
		
		System.out.println(response);
	}
}
