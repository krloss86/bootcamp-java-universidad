package ar.com.educacionit.bootcamp.streams;

public class MainFunctionalInterface {

	public static void main(String[] args) {
		 
		IUpload a = (name) -> System.out.println("subiendo: " + name);
		
		a.upload("pepe");
	}
}
