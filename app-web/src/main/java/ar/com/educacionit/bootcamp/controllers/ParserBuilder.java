package ar.com.educacionit.bootcamp.controllers;

import ar.com.educacionit.bootcamp.parsers.CSVArticuloFileParser;
import ar.com.educacionit.bootcamp.parsers.Iparser;

public class ParserBuilder {

	public static Iparser buildParser(String fileName) {
		String ext = getExt(fileName);
		ParserEnum _parseEnum = ParserEnum.valueOf(ext);
		Iparser parser = _parseEnum.parser;
		return parser;
	}

	public static String getExt(String fileName) {
		String[] aux = fileName.split("\\.");
		//[bla,doc]
		return aux[aux.length-1].toUpperCase();
	}
	
	private enum ParserEnum {
		CSV(new CSVArticuloFileParser()),
		XLS(new CSVArticuloFileParser()),
		XSLX(new CSVArticuloFileParser())
		;
		
		private Iparser parser;		
		
		private ParserEnum(Iparser parser) {
			this.parser = parser;
		}		
	}
}
