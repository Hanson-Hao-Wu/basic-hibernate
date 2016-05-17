package com.hao.basic.dao;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hao.basic.model.Pager;
import com.hao.basic.model.SystemContext;

@SuppressWarnings("unchecked")
public class BaseDao<T> implements IBaseDao<T> {
	
	private SessionFactory sessionFactory;
	
	private Class<T> clz;
	
	public Class<T> getClz() {
		if(clz == null) {
			clz =((Class<T>)(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Inject
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession() {
		return sessionFactory.openSession();
	}
	
	@Override
	public T add(T t) {
		getSession().save(t);
		return t;
	}
	
	@Override
	public void update(T t) {
		getSession().update(t);
	}
	
	@Override
	public void delete(int id) {
		getSession().delete(this.load(id));
	}
	
	@Override
	public T load(int id) {
		return (T)getSession().load(getClz(), id);
	}
	
	@Override
	public List<T> list(String hql, Object[] args) {
		
		return this.list(hql, args, null);
	}
	
	@Override
	public List<T> list(String hql, Object arg) {

		return this.list(hql, new Object[]{arg});
	}

	@Override
	public List<T> list(String hql) {

		return this.list(hql,null);
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public List<T> list(String hql, Object[] args, Map<String, Object> alias) {
		String order = SystemContext.getOrder();
		String sort = SystemContext.getSort();
		if(sort != null && !"".equals(sort.trim())){
			hql += " order by " + sort;
			if("desc".equals(order)) {
				hql += " asc";
			}
			else {
				hql += "desc";
			}
		}
		Query query = getSession().createQuery(hql);
		if(alias != null){
			Set<String> keys = alias.keySet();
			for(String key:keys) {
				Object val = alias.get(key);
				if(val instanceof Collection) {
					query.setParameter(key, (Collection)val);
				}else{
					query.setParameter(key, val);
				}
			}
		}
		if(args != null && args.length > 0){
			int index = 0;
			for(Object arg:args) {
				query.setParameter(index++, arg);
			}
		}
		
		return query.list();
	}

	@Override
	public List<T> list(String hql, Map<String, Object> alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<T> find(String hql, Object[] args) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Pager<T> find(String hql, Object arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<T> find(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<T> find(String hql, Object[] args, Map<String, Object> alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<T> find(String hql, Map<String, Object> alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object queryObject(String hql, Object[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object queryObject(String hql, Object arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object queryObject(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateByHql(String hql, Object[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateByHql(String hql, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateByHql(String hql) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<T> listBySql(String sql, Object[] args, Class<T> clz, boolean hasEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> listBySql(String sql, Object arg, Class<T> clz, boolean hasEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> listBySql(String sql, Class<T> clz, boolean hasEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> listBySql(String sql, Object[] args, Map<String, Object> alias, Class<T> clz, boolean hasEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> listBySql(String sql, Map<String, Object> alias, Class<T> clz, boolean hasEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<T> findBySql(String sql, Object[] args, Class<T> clz, boolean hasEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<T> findBySql(String sql, Object arg, Class<T> clz, boolean hasEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<T> findBySql(String sql, Class<T> clz, boolean hasEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<T> findBySql(String sql, Object[] args, Map<String, Object> alias, Class<T> clz, boolean hasEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<T> findBySql(String sql, Map<String, Object> alias, Class<T> clz, boolean hasEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
