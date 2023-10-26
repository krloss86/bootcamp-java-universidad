package ar.com.educacionit.bootcamp;

import java.io.Serializable;

public abstract class Entity {

	protected Long id;
	
	public void setId(Long id) {
		this.id =id;
	}
	
	public Serializable getId() {
		return this.id;
	}
}
