package ar.com.educacionit.bootcamp.streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainListStream2 {

	public static void main(String[] args) {

		List<Integer> valores = List.of();
		
		Optional<Integer> max = valores.stream().max(Integer::compareTo);
				
		System.out.println(max.get());
		
		//paso 1 a partir de la collection genero el stream
		var filtered = valores.stream()				
				.map(v -> v * 1)
//				.peek(v -> System.out.println(v))/*ver sin modificar el dato dentro del stream*/
				.filter(v -> v % 2 == 0)
				.filter(v -> v > 6)
				.collect(Collectors.toList());
		
		//reducir a una suma todos los valores
		
		var suma = filtered.stream()
			.reduce(10,(subtotal,current) -> subtotal + current);
		
		var maximo = max(valores);
		System.out.println(maximo);
	}
	
	public static Integer max(List<Integer> list) {
		return list.stream().max(Integer::compareTo).orElseThrow();		/*ver olElse..?*/
	}
}
