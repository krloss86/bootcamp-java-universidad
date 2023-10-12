package org.app.console;

import org.app.service.EntidadAService;
import org.app.service.EntidadAServiceImpl;
import org.app.service.EntidadBService;
import org.app.service.EntidadBServiceImpl;

public class App 
{
    public static void main( String[] args )
    {
        //buscar todos las entidadA
    	EntidadAService service = new EntidadAServiceImpl();
    	var todos = service.buscarTodos();
    	System.out.println(todos);
    	
    	EntidadBService serviceB = new EntidadBServiceImpl();
    	var todosB = serviceB.buscarTodos();
    	System.out.println(todosB);
    }
}
