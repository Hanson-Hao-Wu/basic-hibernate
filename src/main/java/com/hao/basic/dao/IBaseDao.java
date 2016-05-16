package com.hao.basic.dao;

import java.util.List;
import java.util.Map;

import com.hao.basic.model.Pager;

/**
 * 
 * @author Hao
 * public DAO handler object
 * @param <T>
 */
public interface IBaseDao<T> {
	
	public T add(T t);
	public void update(T t);
	public void delete(int id);
	public T load(int id);
	
	
	public List<T> list(String hql, Object[] args);
	public List<T> list(String hql, Object arg);
	public List<T> list(String hql);
	public List<T> list(String hql, Object[] args, Map<String, Object> alias);
	public List<T> list(String hql, Map<String, Object> alias);
	
	/**
	 * pager object
	 * @param hql
	 * @param args
	 * @return
	 */
	public Pager<T> find(String hql, Object[] args);
	public Pager<T> find(String hql, Object arg);
	public Pager<T> find(String hql);
	public Pager<T> find(String hql, Object[] args, Map<String, Object> alias);
	public Pager<T> find(String hql, Map<String, Object> alias);
	
	/**
	 * search Object base on hql
	 */
	public Object queryObject(String hql, Object[] args);
	public Object queryObject(String hql, Object arg);
	public Object queryObject(String hql);
	
	/**
	 * update Object base on hql
	 */
	public void updateByHql(String hql, Object[] args);
	public void updateByHql(String hql, Object arg);
	public void updateByHql(String hql);
	
	/**
	 * list Object base on sql
	 */
	public List<T> listBySql(String sql, Object[] args, Class<T> clz, boolean hasEntity);
	public List<T> listBySql(String sql, Object arg, Class<T> clz, boolean hasEntity);
	public List<T> listBySql(String sql, Class<T> clz, boolean hasEntity);
	public List<T> listBySql(String sql, Object[] args, Map<String, Object> alias, Class<T> clz, boolean hasEntity);
	public List<T> listBySql(String sql, Map<String, Object> alias, Class<T> clz, boolean hasEntity);
	
	/**
	 * list Pager base on sql
	 */
	public Pager<T> findBySql(String sql, Object[] args, Class<T> clz, boolean hasEntity);
	public Pager<T> findBySql(String sql, Object arg, Class<T> clz, boolean hasEntity);
	public Pager<T> findBySql(String sql, Class<T> clz, boolean hasEntity);
	public Pager<T> findBySql(String sql, Object[] args, Map<String, Object> alias, Class<T> clz, boolean hasEntity);
	public Pager<T> findBySql(String sql, Map<String, Object> alias, Class<T> clz, boolean hasEntity);
	
}
