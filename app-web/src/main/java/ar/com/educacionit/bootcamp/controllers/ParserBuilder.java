package ar.com.educacionit.bootcamp.controllers;

import ar.com.educacionit.bootcamp.parsers.CSVArticuloFileParser;
import ar.com.educacionit.bootcamp.parsers.Iparser;

public class ParserBuilder {

	public static Iparser buildParser(String fileName) {
		switch (getExt(fileName)) {
			case "CSV": {
				return new CSVArticuloFileParser();
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + fileName);
			}
	}

	public static String getExt(String fileName) {
		String[] aux = fileName.split("\\.");
		//[bla,doc]
		return aux[aux.length-1].toUpperCase();
	}
}
