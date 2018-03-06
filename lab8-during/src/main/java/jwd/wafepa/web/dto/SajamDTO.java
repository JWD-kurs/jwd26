package jwd.wafepa.web.dto;

public class SajamDTO {

	private Long id;
	private String naziv;
	private String mesto;
	private String otvaranje;
	private String zatvaranje;
	private Integer cena;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getMesto() {
		return mesto;
	}
	public void setMesto(String mesto) {
		this.mesto = mesto;
	}
	public String getOtvaranje() {
		return otvaranje;
	}
	public void setOtvaranje(String otvaranje) {
		this.otvaranje = otvaranje;
	}
	public String getZatvaranje() {
		return zatvaranje;
	}
	public void setZatvaranje(String zatvaranje) {
		this.zatvaranje = zatvaranje;
	}
	public Integer getCena() {
		return cena;
	}
	public void setCena(Integer cena) {
		this.cena = cena;
	}
	
	
}
