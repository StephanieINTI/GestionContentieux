package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.inti.entities.Tribunal;
import com.inti.service.interfaces.ITribunalService;

@RestController
@CrossOrigin 
public class TribunauxController {

	@Autowired
	ITribunalService tribunalService;
	
	
	@RequestMapping(value = "/tribunal")
	public List<Tribunal> findAllTribunal() {
		return  tribunalService.findAll(Tribunal.class);
		
		
	}
}
