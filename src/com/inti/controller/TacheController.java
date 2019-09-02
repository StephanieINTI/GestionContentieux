package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.inti.entities.Tache;
import com.inti.service.interfaces.ITacheService;


@CrossOrigin("*")
@RestController
public class TacheController {

	@Autowired
	ITacheService tacheService;
	
	@RequestMapping(value="tache", method = RequestMethod.POST)
	public void saveTache(@RequestBody Tache tache) {
		tacheService.save(tache);
	}
	
	@RequestMapping(value = "tache",method=RequestMethod.GET)
	public List<Tache> findAllTache() {
		return  tacheService.findAll(Tache.class);
		
		
	}
}
