package ar.com.educacionit.bootcamp.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.app.service.ArticuloService;
import org.app.service.ServiceLocator;

import ar.com.educacionit.bootcamp.exporters.IExport;
import ar.com.educacionit.bootcamp.exporters.PDFExporter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/articulo/export")
public class ExportController extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ext = req.getParameter("EXPORT_TYPE");
		
		IExport export = new PDFExporter();		
		export.setPath(getServletContext().getResource("/reports/listado_articulos.jasper"));
		
		Properties properties = new Properties();
		properties.load(new FileInputStream(new File(getClass().getResource("/application.properties").getFile())));
		
		export.setOutputPath((String)properties.get("EXPORT_REPORT_BASE_PATH"));
		
		ArticuloService list = (ArticuloService)ServiceLocator.getService(ArticuloService.class);
		export.export(list.buscarTodos());
		
	}
}
