package org.app.console;

import org.app.service.ServiceLocator;
import org.app.service.UserService;

import ar.com.educacionit.bootcamp.User;

public class UserMain 
{
    public static void main( String[] args )
    {
    	UserService service = (UserService) ServiceLocator.getService(UserService.class);    	
    	
    	/*User user6 =service.buscarPoId(6L);*/
    	
    	//service.eliminarPorId(7L);
    	/*
    	User user = service.buscarPoId(6L);
    	
    	System.out.println(user6);
    	System.out.println(user);
    	*/
    	
    	User newUser = new User("PEPE", "PEPE1234");
    	service.guardar(newUser);
    	
    	System.out.println(newUser.getId()); //se lo setea la implementacion de CrudBase!
    }
}
