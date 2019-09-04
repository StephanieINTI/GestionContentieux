package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Utilisateur;
import com.inti.service.interfaces.IUtilisateurService;

@RestController
@CrossOrigin(origins = "*")
public class UtilisateurAdminController {
	
	@Autowired
	IUtilisateurService utilisateurService;
	
	@RequestMapping(value="userAdmin", method = RequestMethod.POST)
	public void saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		utilisateurService.save(utilisateur);;
	}
	
	@RequestMapping(value="userAdmin")
	public List<Utilisateur> findAllUtilisateur () {
		return utilisateurService.findAll(Utilisateur.class);
	}
	
	@RequestMapping(value="userAdmin/{idUtilisateur}")
	public Utilisateur findOneUtilisateur(@PathVariable("idUtilisateur") Long idUtilisateur) {
		return utilisateurService.findOne(Utilisateur.class, idUtilisateur);
		
	}
	
	@RequestMapping(value="userAdmin/{idUtilisateur}", method=RequestMethod.PUT)
	public void updateUtilisateur(@PathVariable("idUtilisateur") Long idUtilisateur, @RequestBody Utilisateur utilisateur) {
		Utilisateur currentUtilisateur = utilisateurService.findOne(Utilisateur.class, idUtilisateur); 
		currentUtilisateur.setNomUtilisateur(utilisateur.getNomUtilisateur());
		currentUtilisateur.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
		currentUtilisateur.setListRoles(utilisateur.getListRoles());
		utilisateurService.update(currentUtilisateur);
		utilisateurService.save(currentUtilisateur);
	}
}
