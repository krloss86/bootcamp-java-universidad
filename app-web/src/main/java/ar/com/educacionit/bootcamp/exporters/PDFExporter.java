package ar.com.educacionit.bootcamp.exporters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;

import ar.com.educacionit.bootcamp.Articulo;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class PDFExporter implements IExport {

	private URL path;
	private String outputPath;
	
	public void setPath(URL path) {
		this.path = path;
	}
	
	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath; 
	}
	
	@Override
	public void export(Collection<Articulo> list) {
		//obtener el file (.jrxml)
		
		try {
			File file = new File(path.toURI().getPath());
			FileInputStream fis = new FileInputStream(file);
			
			var params = new HashMap<String,Object>();
			params.put("usuario", "CARLOS LOPEZ");
			
			//recien uso las clases de jasper
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
			JasperPrint jasperPrint = JasperFillManager.fillReport(fis,params,dataSource);
			
			OutputStream output = new FileOutputStream(new File( outputPath + jasperPrint.getName() + ".pdf")); 
			JasperExportManager.exportReportToPdfStream(jasperPrint, output);
			output.close();
			System.out.println(jasperPrint.getName());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
