package org.app.console;

import org.app.service.RoleService;
import org.app.service.ServiceLocator;

import ar.com.educacionit.bootcamp.Rol;

public class RoleMain 
{
    public static void main( String[] args )
    {
    	RoleService service = (RoleService) ServiceLocator.getService(RoleService.class);    	
    	
    	Rol newUser = service.buscarPoId(1L);
    	newUser.setRole("usuario");
    	
    	service.actualizar(newUser);
    }
}
