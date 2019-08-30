package com.inti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inti.dao.interfaces.IAffaireDAO;

import com.inti.entities.Affaire;
import com.inti.service.interfaces.IAffaireService;

@Service
@Transactional
public class AffaireService extends ManagerService<Affaire> implements IAffaireService{

	@Autowired
	@Qualifier("affaireDAO")
	IAffaireDAO dao;
	
	@Override
	public Affaire getAffaireByTitre(String titre) {
		return dao.getAffaireByTitre(titre);
	}

}
