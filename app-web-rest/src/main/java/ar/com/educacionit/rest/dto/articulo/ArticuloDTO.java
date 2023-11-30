package ar.com.educacionit.rest.dto.articulo;

import java.io.Serializable;

public record ArticuloDTO(Serializable id, Long edit, Long isbn, Integer paginas, String idioma) {

}
