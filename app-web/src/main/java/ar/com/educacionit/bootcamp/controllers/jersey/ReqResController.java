package ar.com.educacionit.bootcamp.controllers.jersey;

import java.io.IOException;

import ar.com.educacionit.bootcamp.connectors.reqres.PostRequestDTO;
import ar.com.educacionit.bootcamp.connectors.reqres.PostRequestResponseDTO;
import ar.com.educacionit.bootcamp.connectors.reqres.ReqResRestService;
import ar.com.educacionit.bootcamp.connectors.reqres.ReqResRestServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/meli/reqres")
public class ReqResController extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ReqResRestService servieRest = new ReqResRestServiceImpl("https://reqres.in");
		
		PostRequestDTO request = new PostRequestDTO("nombre", "carpitero");
		
		PostRequestResponseDTO response = servieRest.create(request);
		
		resp.getWriter().print(response);
	}
}
