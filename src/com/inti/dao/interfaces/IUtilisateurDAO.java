package com.inti.dao.interfaces;

<<<<<<< HEAD
import com.inti.entities.Utilisateur;
=======

public interface IUtilisateurDAO {
>>>>>>> master

public interface IUtilisateurDAO extends IDAO<Utilisateur>{
	Utilisateur findOneByUsername (String username);
}
