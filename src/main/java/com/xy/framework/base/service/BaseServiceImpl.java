package com.xy.framework.base.service;

import java.io.Serializable;
import java.util.List;

import com.xy.framework.base.dao.IBaseDao;

@SuppressWarnings("unchecked")
public abstract class BaseServiceImpl<E, PK extends Serializable> implements IBaseService<E, PK> {

	@SuppressWarnings("rawtypes")
	protected abstract IBaseDao getBaseDao();

	public E getById(String id) {
		return (E) getBaseDao().getById(id);
	}

	public void deleteById(String id) {
		getBaseDao().deleteById(id);
	}

	public void save(E entity) {
		getBaseDao().save(entity);
	}

	public void update(E entity) {
		getBaseDao().update(entity);
	}

	public List<E> findAll() {
		return getBaseDao().findAll();
	}

	public int getCount() {
		return getBaseDao().getCount();
	}

	public boolean isExist(String propertyName, Object propertyValue) {
		return getBaseDao().isExist(propertyName, propertyValue);
	}

	@SuppressWarnings("rawtypes")
	public Object queryCustomObject(String statementName, Object paraObject, Class clas) {
		return null;
	}

	@SuppressWarnings("rawtypes")
	public Object queryCustomList(String statementName, Object paraObject, Class clas) {
		return null;
	}

}
