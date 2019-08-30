package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.inti.entities.Affaire;
import com.inti.service.interfaces.IAffaireService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AffaireController {
	@Autowired
	IAffaireService affaireService;
	
	
	@RequestMapping(value="/affaire", method = RequestMethod.POST)
	public ModelAndView saveAffaire (@ModelAttribute("a") Affaire affaire) {
		affaireService.save(affaire);
		return new ModelAndView("redirect:/affaire");
	}
	
	@RequestMapping(value="/affaire")
	public List<Affaire> findAllAffaire () {
		return affaireService.findAll(Affaire.class);
	}
	
	public Affaire getAffaireByTitre(@PathVariable("titre") String titre) {
		return affaireService.getAffaireByTitre(titre);
		
	}

}
