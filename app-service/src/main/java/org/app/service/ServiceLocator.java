package org.app.service;

public class ServiceLocator {

	public static EntidadBaseService getService(Class clazz) {
		
		String name = clazz.getCanonicalName() + "Impl";
		
		try {
			//API Reflection
			return (EntidadBaseService)Class.forName(name).getConstructors()[0].newInstance();
		} catch (Exception e) {
			throw new IllegalArgumentException(name);
		}
	}
}
