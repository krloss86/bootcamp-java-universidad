package ar.com.educacionit.bootcamp.parsers;

import java.io.InputStream;
import java.util.Collection;

import ar.com.educacionit.bootcamp.Articulo;

public interface Iparser {
	public Collection<Articulo> parse(InputStream is);
}
