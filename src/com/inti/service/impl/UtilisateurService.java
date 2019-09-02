package com.inti.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inti.entities.Utilisateur;
import com.inti.service.interfaces.IUtilisateurService;

@Service
@Transactional
public class UtilisateurService extends ManagerService<Utilisateur> implements IUtilisateurService{

}
