package jwd.knjizara.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Glas {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@ManyToOne(fetch=FetchType.EAGER)
	private Knjiga knjiga;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Knjiga getKnjiga() {
		return knjiga;
	}
	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
		if(knjiga!=null && !knjiga.getGlasovi().contains(this)){
			knjiga.getGlasovi().add(this);
		}
	}
}
