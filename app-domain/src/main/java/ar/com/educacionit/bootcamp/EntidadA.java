package ar.com.educacionit.bootcamp;

import java.time.LocalDate;
import java.util.Objects;

public class EntidadA {

	private String id;//UUID
	private String atributeA;
	private LocalDate atributoB;
	private Long atributoC;
	
	public EntidadA(String id, String atributeA, LocalDate atributoB, Long atributoC) {
		this.id = id;
		this.atributeA = atributeA;
		this.atributoB = atributoB;
		this.atributoC = atributoC;
	}
	public EntidadA(String atributeA, LocalDate atributoB, Long atributoC) {
		this.atributeA = atributeA;
		this.atributoB = atributoB;
		this.atributoC = atributoC;
	}
	public String getAtributeA() {
		return atributeA;
	}
	public void setAtributeA(String atributeA) {
		this.atributeA = atributeA;
	}
	public LocalDate getAtributoB() {
		return atributoB;
	}
	public void setAtributoB(LocalDate atributoB) {
		this.atributoB = atributoB;
	}
	public Long getAtributoC() {
		return atributoC;
	}
	public void setAtributoC(Long atributoC) {
		this.atributoC = atributoC;
	}
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "EntidadA [id=" + id + ", atributeA=" + atributeA + ", atributoB=" + atributoB + ", atributoC="
				+ atributoC + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntidadA other = (EntidadA) obj;
		return Objects.equals(id, other.id);
	}
	
}
