package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import controllers.JPAUtil;

public abstract class GenDAOJPA<T> implements DAO<T> {

	protected Class<T> entityClass;

	public void insert(T entity) {
		getEm().persist(entity);
	}
	
	public void insertMany(List<T> entities) {
		for (T e : entities) {
			insert(e);
		}
	}
	
	public List<T> getPage(int linhas, int offset) {
		List<T> l = new ArrayList<T>();
		
		CriteriaBuilder criteriaBuilder = getEm().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
		Root<T> from = criteriaQuery.from(entityClass);
		CriteriaQuery<T> select = criteriaQuery.select(from);
		TypedQuery<T> typedQuery = getEm().createQuery(select);
		typedQuery.setFirstResult(offset);
		typedQuery.setMaxResults(linhas);
		l = typedQuery.getResultList();
		
		return l;
	}

	public void delete(T entity) {
		getEm().remove(entity);
	}
	
	public void update(T entity) {
		getEm().merge(entity);
	}
	
	public T getById(Object id) {
		return getEm().find(entityClass, id);
	}

	public List<T> getAllAsAList() {
		CriteriaQuery<T> cq = getEm().getCriteriaBuilder().createQuery(entityClass);
		cq.from(entityClass);
		
		return getEm().createQuery(cq).getResultList();
	}

	public void beginTransaction() {
		JPAUtil.beginTransaction();
	}

	public void commit() {
		JPAUtil.commit();
	}

	public void rollback() {
		JPAUtil.rollback();
	}

	public void close() {
		JPAUtil.closeEntityManager();
	}
	
	public EntityManager getEm() {
		return JPAUtil.getEntityManager();
	}

}
