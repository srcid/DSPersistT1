package dao;

import java.util.List;

public interface DAO<T> {

	public void insert(T entity);
	public void insertMany(List<T> entities);
	public List<T> getPage(int linhas, int offset);
	public void delete(T entity);
	public void update(T entity);
	public T getById(Object id);
	public List<T> getAllAsAList();
	public void beginTransaction();
	public void commit();
	public void rollback();
	public void close();
}
