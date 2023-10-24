package org.app.console;

import org.app.service.ServiceLocator;
import org.app.service.UserService;

import ar.com.educacionit.bootcamp.User;

public class UserMain 
{
    public static void main( String[] args )
    {
    	UserService service = (UserService) ServiceLocator.getService(UserService.class);    	
    	
    	User user =service.buscarPoId(1L);
    	
    	System.out.println(user);
    }
}
