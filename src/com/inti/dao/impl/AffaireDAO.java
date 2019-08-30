package com.inti.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inti.dao.interfaces.IAffaireDAO;
import com.inti.entities.Affaire;

@Repository ("affaireDAO")
public class AffaireDAO extends ManagerDAO<Affaire> implements IAffaireDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Affaire getAffaireByTitre(String titre) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Affaire.class);
		criteria.add(Restrictions.eq("titre", titre));
		return (Affaire) criteria.uniqueResult();
	}

}
