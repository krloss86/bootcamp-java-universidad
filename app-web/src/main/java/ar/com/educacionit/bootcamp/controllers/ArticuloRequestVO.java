package ar.com.educacionit.bootcamp.controllers;

import jakarta.servlet.http.HttpServletRequest;
//value object
public class ArticuloRequestVO {
	private Long editorial;
	private Long isbn;
	private Integer nroPaginas;
	private String idioma;
	
	public ArticuloRequestVO(HttpServletRequest req) {
		if(req.getParameter("editorial") == null) {
			throw new IllegalArgumentException("Editorial invalida");
		}
		this.editorial = Long.parseLong(req.getParameter("editorial"));//fk
		
		if(req.getParameter("isbn") == null) {
			throw new IllegalArgumentException("ISBN invalida");
		}
		this.isbn = Long.parseLong(req.getParameter("isbn"));
		
		if(req.getParameter("paginas") == null) {
			throw new IllegalArgumentException("paginas");
		}
		
		this.nroPaginas = Integer.parseInt(req.getParameter("paginas"));
		
		if(req.getParameter("idioma") == null) {
			throw new IllegalArgumentException("idioma invalido");
		}
		this.idioma = req.getParameter("idioma");
	}

	public Long getEditorial() {
		return editorial;
	}

	public Long getIsbn() {
		return isbn;
	}

	public Integer getNroPaginas() {
		return nroPaginas;
	}

	public String getIdioma() {
		return idioma;
	}
}
