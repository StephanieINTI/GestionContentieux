package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inti.service.interfaces.IService;

@Service
@Transactional
public class ManagerService<T> implements IService<T> {

	@Autowired
	@Qualifier("daoGeneric")
	IDAO<T> dao;
	
	
	
	public void save(T obj) {
		dao.save(obj);
		
	}

	public void update(T obj) {
		dao.update(obj);
		
	}

	public void remove(T obj) {
		dao.remove(obj);
		
	}

	public List<T> findAll(Class<?> c) {
		return dao.findAll(c);
	}

	public T findOne(Class<?> c, Long id) {
		
		return dao.findOne(c, id);
	}

	
	}

}
