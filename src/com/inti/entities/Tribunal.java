package com.inti.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tribunal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdTribunal;
	private String adresse;
	private Double fax;
	private Double tel;
	private String region;

	@OneToMany(mappedBy = "tribunal", fetch = FetchType.EAGER)
	private Set<Tache> listTache = new HashSet<>();

	public Tribunal() {

	}

	
	public Tribunal(Long idTribunal) {
		IdTribunal = idTribunal;
	}


	public Long getIdTribunal() {
		return IdTribunal;
	}

	public void setIdTribunal(Long idTribunal) {
		IdTribunal = idTribunal;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Double getFax() {
		return fax;
	}

	public void setFax(Double fax) {
		this.fax = fax;
	}

	public Double getTel() {
		return tel;
	}

	public void setTel(Double tel) {
		this.tel = tel;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Set<Tache> getListTache() {
		return listTache;
	}

	public void setListTache(Set<Tache> listTache) {
		this.listTache = listTache;
	}

}
