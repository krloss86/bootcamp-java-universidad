package ar.com.educacionit.rest.dto.articulo;

import java.time.LocalDate;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ar.com.educacionit.bootcamp.Articulo;

@Mapper
public interface ArticuloMapper {

	ArticuloMapper INSTANCE = Mappers.getMapper(ArticuloMapper.class);

	@Mapping(source = "editorial", target = "edit")
	@Mapping(source = "nroPaginas", target = "paginas")
	ArticuloDTO toArticuloDto(Articulo car);

	default Articulo toArticulo(ArticuloRequest input) {
		return new Articulo(input.editorial(), input.isbn(), input.nroPaginas(), input.idioma(), LocalDate.now());
	}
}
