package ar.com.educacionit.bootcamp;

import java.time.LocalDate;
import java.util.Objects;

public class EntidadB {
//alt+shit+s
	private String id;//UUID
	private String atributeD;
	private LocalDate atributoE;
	private Long atributoF;
	public EntidadB(String id, String atributeD, LocalDate atributoE, Long atributoF) {
		super();
		this.id = id;
		this.atributeD = atributeD;
		this.atributoE = atributoE;
		this.atributoF = atributoF;
	}
	public EntidadB(String atributeD, LocalDate atributoE, Long atributoF) {
		super();
		this.atributeD = atributeD;
		this.atributoE = atributoE;
		this.atributoF = atributoF;
	}
	public String getAtributeD() {
		return atributeD;
	}
	public void setAtributeD(String atributeD) {
		this.atributeD = atributeD;
	}
	public LocalDate getAtributoE() {
		return atributoE;
	}
	public void setAtributoE(LocalDate atributoE) {
		this.atributoE = atributoE;
	}
	public Long getAtributoF() {
		return atributoF;
	}
	public void setAtributoF(Long atributoF) {
		this.atributoF = atributoF;
	}
	public String getId() {
		return id;
	}
	@Override
	public String toString() {
		return "EntidadB [id=" + id + ", atributeD=" + atributeD + ", atributoE=" + atributoE + ", atributoF="
				+ atributoF + "]";
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
		EntidadB other = (EntidadB) obj;
		return Objects.equals(id, other.id);
	}
	
}
