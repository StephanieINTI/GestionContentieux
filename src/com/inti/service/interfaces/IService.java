package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Affaire;


public interface IService<T> {
	Affaire save(T obj);

	void update(T obj);

	void remove(T obj);

	List<T> findAll(Class<?> c);

	T findOne(Class<?> c, Long id);



}
