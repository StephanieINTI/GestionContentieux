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
	private Long idTribunal;
	private String adresse;
	private Double fax;
	private Double tel;
	private String region;

	@OneToMany(mappedBy = "tribunal", fetch = FetchType.EAGER)
	private Set<Tache> listTaches = new HashSet<>();

	public Tribunal() {

	}

	public Tribunal(Long idTribunal) {
		idTribunal = idTribunal;
	}

	public Long getIdTribunal() {
		return idTribunal;
	}


	public void setIdTribunal(Long idTribunal) {
		this.idTribunal = idTribunal;
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


	public Set<Tache> getListTaches() {
		return listTaches;
	}


	public void setListTaches(Set<Tache> listTaches) {
		this.listTaches = listTaches;
	}

	

}
