package ar.com.educacionit.bootcamp.streams;

import java.util.ArrayList;
import java.util.List;

public class MainList {

	public static void main(String[] args) {

		List<Integer> valores = List.of(5, 7, 9, 8, 15);
		
		//valores > a 9
		
		//guardar en lista auxiliar
		var auxiliar = new ArrayList<Integer>();
		for (Integer v : valores) {
			if(v > 9) {
				auxiliar.add(v);
			}
		}
		//15
		System.out.println(auxiliar);
	}

}
