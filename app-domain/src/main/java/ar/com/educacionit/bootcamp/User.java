package ar.com.educacionit.bootcamp;

import java.util.List;


public class User {

	private Long id;
	private String username;
	private String password;
	
	private List<Rol> roles;//pero no existe
	
	//se usa cuando el registro venga de la base
	public User(Long id, String username, String password) {
		//Anticurruption layer (D.D.D)
		if(id == null || username == null || password == null) {
			throw new IllegalArgumentException("Algun campo es null");
		}
		
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	//cuando se envie a grabar a la db
	public User(String username, String password) {
		if(username == null || password == null) {
			throw new IllegalArgumentException("Algun campo es null");
		}
		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void addRole(Rol role) {
		if(role == null) {
			throw new IllegalArgumentException("Role invalido");
		}
		this.roles.add(role);
	}
	public void setRoles(List<Rol> roles) {
		if(roles == null) {
			throw new IllegalArgumentException("Role invalido");
		}
		this.roles = roles;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", roles=" + roles + "]";
	}
	
}
