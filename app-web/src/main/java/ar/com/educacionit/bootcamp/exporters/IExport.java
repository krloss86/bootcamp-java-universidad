package ar.com.educacionit.bootcamp.exporters;

import java.net.URL;
import java.util.Collection;

import ar.com.educacionit.bootcamp.Articulo;

public interface IExport {
	public void export(Collection<Articulo> list);
	public void setPath(URL path);
	public void setOutputPath(String outputPath);
}
