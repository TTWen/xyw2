package com.xt.ebook.dao;

import java.io.Serializable;
import java.util.List;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class BaseDAOImpl<T, PK extends Serializable> extends
		HibernateDaoSupport implements IBaseDAO<T, PK> {

	private Class cls;

	public BaseDAOImpl() {

		Class clazz = this.getClass();
		// 得到当前对象父类的参数化类型,一般使用type子接口ParameterizedType
		Type type = clazz.getGenericSuperclass();
		ParameterizedType ptype = (ParameterizedType) type;
		// 得到实际类型参数
		Type[] types = ptype.getActualTypeArguments();
		Class clazzParameter = (Class) types[0];
		this.cls = clazzParameter;
	}

	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	public void add(T t) {

		getHibernateTemplate().save(t);
	}

	public void delete(T t) {

		getHibernateTemplate().delete(t);
	}

	public void update(T t) {

		getHibernateTemplate().update(t);
	}

	@SuppressWarnings("unchecked")
	public T findById(PK id) {

		return (T) getHibernateTemplate().get(cls, id);
	}

	public List<T> findByIds(PK[] ids) {

		return null;
	}

	@SuppressWarnings("unchecked")
	public List<T> findByPage(int pageNow, int pageSize) {

		HibernateTemplate ht = getHibernateTemplate();
		DetachedCriteria criteria = DetachedCriteria.forClass(cls);
		return (List<T>) ht.findByCriteria(criteria, pageNow, pageSize);
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String hql, String[] param) {

		return (List<T>) getHibernateTemplate().find(hql, param);
	}

	public int cnt(String hql) {

		// hibernate的count返回long型
		return Integer.parseInt(String.valueOf(getHibernateTemplate().iterate(
				hql).next()));

	}

	@SuppressWarnings("unchecked")
	public List<T> findByPage(int pageNow, int pageSize, String orderBy,
			boolean isAsc, Criterion... criterions) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(cls);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		if (isAsc)
			criteria.addOrder(Order.asc(orderBy));
		else
			criteria.addOrder(Order.desc(orderBy));

		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}

	public List<T> findByPage(int pageNow, int pageSize, String orderBy,
			boolean isAsc, float min, float max) {
		
		findByPage(pageNow, pageSize, orderBy, isAsc,
				Restrictions.between("bsalepr", min, max));
		return null;
	}

	public List<T> findByPage(int pageNow, int pageSize, String orderBy,
			boolean isAsc, String keyword) {

		return findByPage(pageNow, pageSize, orderBy, isAsc, Restrictions.or(
				Restrictions.like("bname", keyword, MatchMode.ANYWHERE),
				Restrictions.like("bauth", keyword, MatchMode.ANYWHERE),
				Restrictions.like("isbn", keyword, MatchMode.ANYWHERE)));
	}

}
