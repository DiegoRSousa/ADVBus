package com.uepb.advbus.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import com.uepb.advbus.util.JpaUtil;

public class RepositoryBase<T> {

	private EntityManager manager = JpaUtil.getEntityManager();
	private Class<T> entityClass;
	
	
	public RepositoryBase(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	public void beginTransaction() {	
		this.manager.getTransaction().begin();
	}
	
	public void commit() {
		this.manager.getTransaction().commit();
	}
	
	
	public void close() {
		manager.close();
		JpaUtil.close();
	}
	
	public void commitAndClose() {
		commit();
		close();
	}
	
	public void add(T entity) {
		this.manager.persist(entity);
	}
	
	public T getById(Long id) {
		return this.manager.find(entityClass, id);
	}
	
	public List<T> getAll() {
		
		CriteriaQuery cq = this.manager.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return this.manager.createQuery(cq).getResultList();
	}
	
	public T update(T entiy) {
		return this.manager.merge(entiy);
	}
	
	public void delete(T entiy) {
		this.manager.remove(entiy);
	}
}
