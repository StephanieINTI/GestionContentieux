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
public class Affaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAffaire;
	private String reference;
	private String titre;
	private String description;
	private int statut;

	@OneToMany(mappedBy = "affaire", fetch = FetchType.EAGER)
	private Set<Tache> listTaches = new HashSet<>();

	@OneToMany(mappedBy = "affaire", fetch = FetchType.EAGER)
	private Set<Document> listDocuments = new HashSet<>();

	public Affaire() {

	}

	
	public Affaire(Long idAffaire) {
		idAffaire = idAffaire;
	}


	public Long getIdAffaire() {
		return idAffaire;
	}

	public void setIdAffaire(Long idAffaire) {
		this.idAffaire = idAffaire;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public Set<Tache> getListTaches() {
		return listTaches;
	}

	public void setListTaches(Set<Tache> listTaches) {
		this.listTaches = listTaches;
	}

	public Set<Document> getListDocuments() {
		return listDocuments;
	}

	public void setListDocuments(Set<Document> listDocuments) {
		this.listDocuments = listDocuments;
	}

	

}
