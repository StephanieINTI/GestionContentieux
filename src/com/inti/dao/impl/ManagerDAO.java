package com.inti.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inti.dao.interfaces.IDAO;

@Repository("daoGeneric")
public class ManagerDAO<T> implements IDAO<T> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(T obj) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(obj);
	}

	@Override
	public void update(T obj) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(obj);

	}

	@Override
	public void remove(T obj) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(obj);

	}

	@Override
	public List<T> findAll(Class<?> c) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(c);
		return crit.list();
	}

	@Override
	public T findOne(Class<?> c, Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (T) session.get(c, id);
	}

}
