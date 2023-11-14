package ar.com.educacionit.bootcamp.controllers;

import java.io.IOException;
import java.io.InputStream;

import org.app.service.ArticuloService;
import org.app.service.ServiceLocator;

import ar.com.educacionit.bootcamp.Articulo;
import ar.com.educacionit.bootcamp.parsers.CSVArticuloFileParser;
import ar.com.educacionit.bootcamp.parsers.Iparser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/api/articulo/upload")
@MultipartConfig
public class UploadController extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part filePart = req.getPart("file");
		
		//name
		String fileName = filePart.getSubmittedFileName();
		
		Long size = filePart.getSize();
		
		InputStream is = filePart.getInputStream();
		
		Iparser parser = ParserBuilder.buildParser(fileName);
		
		var nuevosResitros= parser.parse(is);
		
		//ahora podria cargarlos en la db!
		
		ArticuloService service = (ArticuloService) ServiceLocator.getService(ArticuloService.class);
		
		for (Articulo articulo : nuevosResitros) {
			service.guardar(articulo);			
		}
	}
	
}
