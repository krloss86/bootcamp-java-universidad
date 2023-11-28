package ar.com.educacionit.bootcamp.streams;

public record Item(Long id,String descripcion,Double precio) {

	public Item(Long id,String descripcion,Double precio){
		this.id  = id;
		this.descripcion = descripcion;
		this.precio = precio;
	}
}
