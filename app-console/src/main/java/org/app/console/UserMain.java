package org.app.console;

import org.app.service.UserService;
import org.app.service.UserServiceImpl;

public class UserMain 
{
    public static void main( String[] args )
    {
    	UserService serviceB = new UserServiceImpl();
    	var todosB = serviceB.buscarTodos();
    	System.out.println(todosB);
    }
}
