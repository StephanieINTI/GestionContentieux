package com.inti.dao.impl;

<<<<<<< HEAD
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
=======

>>>>>>> master
import org.springframework.stereotype.Repository;

import com.inti.dao.interfaces.IUtilisateurDAO;
import com.inti.entities.Utilisateur;

@Repository
public class UtilisateurDAO extends ManagerDAO<Utilisateur> implements IUtilisateurDAO {

<<<<<<< HEAD
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Utilisateur findOneByUsername(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		// on cherche un utilisateur par son username
		Criteria crit = session.createCriteria(Utilisateur.class);
		crit.add(Restrictions.eq("username", username));
		// Retourne l'utilisateur avec un unique results
		return (Utilisateur) crit.uniqueResult();
	}
=======
	
 
>>>>>>> master

}
