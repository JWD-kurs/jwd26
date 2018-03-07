package jwd.wafepa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Stand {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String zakupac;
	@Column
	private Integer povrsina;
	@ManyToOne(fetch=FetchType.EAGER)
	private Sajam sajam;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getZakupac() {
		return zakupac;
	}
	public void setZakupac(String zakupac) {
		this.zakupac = zakupac;
	}
	public Integer getPovrsina() {
		return povrsina;
	}
	public void setPovrsina(Integer povrsina) {
		this.povrsina = povrsina;
	}
	public Sajam getSajam() {
		return sajam;
	}
	public void setSajam(Sajam sajam) {
		this.sajam = sajam;
		if(sajam!=null && !sajam.getStandovi().contains(this)){
			sajam.getStandovi().add(this);
		}
	}
	

}
