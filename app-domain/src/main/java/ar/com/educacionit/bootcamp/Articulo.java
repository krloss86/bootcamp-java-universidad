package ar.com.educacionit.bootcamp;

import java.time.LocalDate;

public class Articulo extends Entity{
	private Long editorial;
	private Long isbn;
	private Integer nroPaginas;
	private String idioma;
	private LocalDate fechaPublicacion;
	
	public Articulo(Long id,
			Long editorial, Long isbn, Integer nroPaginas, String idioma, LocalDate fechaPublicacion) {		
		this.id = id;
		init(editorial, isbn, nroPaginas, idioma, fechaPublicacion);
	}

	
	public Articulo(Long editorial, Long isbn, Integer nroPaginas, String idioma, LocalDate fechaPublicacion) {
		super();
		init(editorial, isbn, nroPaginas, idioma, fechaPublicacion);
	}
	
	private void init(Long editorial, Long isbn, Integer nroPaginas, String idioma, LocalDate fechaPublicacion) {
		this.editorial = editorial;
		this.isbn = isbn;
		this.nroPaginas = nroPaginas;
		this.idioma = idioma;
		this.fechaPublicacion = fechaPublicacion;
	}


	public Long getEditorial() {
		return editorial;
	}


	public void setEditorial(Long editorial) {
		this.editorial = editorial;
	}


	public Long getIsbn() {
		return isbn;
	}


	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}


	public Integer getNroPaginas() {
		return nroPaginas;
	}


	public void setNroPaginas(Integer nroPaginas) {
		this.nroPaginas = nroPaginas;
	}


	public String getIdioma() {
		return idioma;
	}


	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}


	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}


	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}


	@Override
	public String toString() {
		return "Articulo [editorial=" + editorial + ", isbn=" + isbn + ", nroPaginas=" + nroPaginas + ", idioma="
				+ idioma + ", fechaPublicacion=" + fechaPublicacion + "]";
	}
	
	
}
