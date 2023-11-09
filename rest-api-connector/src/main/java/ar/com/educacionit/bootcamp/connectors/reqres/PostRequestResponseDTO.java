package ar.com.educacionit.bootcamp.connectors.reqres;

public class PostRequestResponseDTO {

	private String name;
	private String job;
	private Long id;
	private String createdAt;

	
	/*/
    "name": "morpheus",
    "job": "leader",
    "id": "656",
    "createdAt": "2023-11-09T01:03:39.517Z"
    */
	
	public PostRequestResponseDTO() {
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}


	@Override
	public String toString() {
		return "PostRequestResponseDTO [name=" + name + ", job=" + job + ", id=" + id + ", createdAt=" + createdAt
				+ "]";
	}
	
}
