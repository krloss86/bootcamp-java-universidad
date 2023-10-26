package ar.com.educacionit.bootcamp;

import java.io.Serializable;

public abstract class Entity {
	public abstract void setId(Long id);
	public abstract Serializable getId(); 
}
