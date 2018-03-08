package jwd.wafepa.web.dto;

public class StandDTO {
	private Long id;
	private String zakupac;
	private Integer povrsina;
	private Long sajamId;
	private String sajamNaziv;
	
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
	public Long getSajamId() {
		return sajamId;
	}
	public void setSajamId(Long sajamId) {
		this.sajamId = sajamId;
	}
	public String getSajamNaziv() {
		return sajamNaziv;
	}
	public void setSajamNaziv(String sajamNaziv) {
		this.sajamNaziv = sajamNaziv;
	}
}
