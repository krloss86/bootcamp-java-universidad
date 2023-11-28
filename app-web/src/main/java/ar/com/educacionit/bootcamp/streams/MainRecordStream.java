package ar.com.educacionit.bootcamp.streams;

import java.util.List;
import java.util.stream.Collectors;

public class MainRecordStream {

	public static void main(String[] args) {
		//crear un lista de record
		List<Item> items = List.of(
				new Item(1L,"Item1",250.5),
				new Item(2L,"Item2",450.5),
				new Item(3L,"Item3",650.5)				
				);
		
		//aplicar filtro por precio > 260
		var filtrados = items.stream()
			.filter(i -> i.precio() > 260)
			.collect(Collectors.toList());
		
		System.out.println(filtrados);
		
		//convertir los datos
		var precios = filtrados.stream()
				.map( i -> i.precio())
				.collect(Collectors.toList());
		
		System.out.println(precios);
		
		//calcular la suma
		var suma = precios.stream().
			reduce(0D,(acum,current) -> acum + current);
		System.out.println(suma);
		
		//en sola linea
		var suma2 = items.stream()
			.filter(i -> i.precio() > 260)
			.map(i -> i.precio())
			.reduce(0D,(acum,current) -> acum + current);
		System.out.println(suma2);

	}

}
