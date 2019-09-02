package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Utilisateur;
import com.inti.service.interfaces.IUtilisateurService;

@RestController
@CrossOrigin(origins = "*")
public class UtilisateurAvocatController {

	@Autowired
	IUtilisateurService utilisateurService;
	
	
	@RequestMapping(value="userAvocat")
	public List<Utilisateur> findAllUtilisateur () {
		return utilisateurService.findAll(Utilisateur.class);
	}
	
	
}

