package ar.com.educacionit.bootcamp;

public class Rol extends Entity{
	private Long id;
	private String role;

	public Rol(Long id, String role) {
		if(id == null || role == null) {
			throw new IllegalArgumentException("Algun campo es null");
		}
		this.id = id;
		this.role = role;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Rol(String role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", role=" + role + "]";
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
