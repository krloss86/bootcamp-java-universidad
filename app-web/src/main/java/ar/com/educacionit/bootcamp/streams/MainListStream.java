package ar.com.educacionit.bootcamp.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainListStream {

	public static void main(String[] args) {

		List<Integer> valores = List.of(5, 7, 9, 8, 15);
		
		//paso 1 a partir de la collection genero el stream
		Stream<Integer> sti = valores.stream();
		
		//aplicar una operacion intermedia
		sti = sti.filter(v -> v > 9);
		
		//aplicar operacion terminal
		List<Integer> filtered = sti.collect(Collectors.toList());
		
		System.out.println(filtered);
	}

}
