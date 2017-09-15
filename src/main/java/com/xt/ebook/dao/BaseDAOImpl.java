package com.xt.ebook.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
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
	public T findById(int id) {

		return (T) getHibernateTemplate().get(cls, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String hql, String[] param) {

		return (List<T>) getHibernateTemplate().find(hql, param);
	}

	public int cnt(String tblname) {

		// hibernate的count返回long型
		String hql = "select count(1) from "+ tblname;
		return Integer.parseInt(String.valueOf(getHibernateTemplate().iterate(
				hql).next()));
	}

	@SuppressWarnings("unchecked")
	public List<T> findByPage(int pageNow, int pageSize) {

		HibernateTemplate ht = getHibernateTemplate();
		DetachedCriteria criteria = DetachedCriteria.forClass(cls);
		return (List<T>) ht.findByCriteria(criteria, pageNow*pageSize, pageSize);
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

		return (List<T>) getHibernateTemplate().findByCriteria(criteria,
				pageNow*pageSize, pageSize);
	}

	public List<T> findByPage(int pageNow, int pageSize, String orderBy,
			boolean isAsc, float min, float max) {

		findByPage(pageNow*pageSize, pageSize, orderBy, isAsc,
				Restrictions.between("bsalepr", min, max));
		return null;
	}

	public List<T> findByPage(int pageNow, int pageSize, String orderBy,
			boolean isAsc, String keyword) {

		return findByPage(pageNow*pageSize, pageSize, orderBy, isAsc, Restrictions.or(
				Restrictions.like("bname", keyword, MatchMode.ANYWHERE),
				Restrictions.like("bauth", keyword, MatchMode.ANYWHERE),
				Restrictions.like("bisbn", keyword, MatchMode.ANYWHERE)));
	}

	// 批量删除，使用deleteAll效率低
	public void delete(String[] ids, String idName) {
		// TODO Auto-generated method stub
		// String[] ids = lid;
		String str = "";
		for (int i = 0; i < ids.length; i++) {
			str += "'" + ids[i] + "'";
			if (i != (ids.length - 1))
				str += ",";
		}
		final String hql = "delete from "+ cls.getSimpleName() +
				" where "+ idName +" in (" + str + ")";
		getHibernateTemplate().execute(new HibernateCallback<T>() {

            public T doInHibernate(Session session) {
                Query query = session.createQuery(hql);
                query.executeUpdate();
                return null;
            }
        });
	}

	public int cnt(String tblname, String criteria) {
		// TODO Auto-generated method stub
		String hql = "select count(1) from "+ tblname +criteria;
		return Integer.parseInt(String.valueOf(getHibernateTemplate().iterate(
				hql).next()));
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(Criterion... criterions) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(cls);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}

	public List<T> findByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return findAll(Restrictions.or(
				Restrictions.like("bname", keyword, MatchMode.ANYWHERE),
				Restrictions.like("bauth", keyword, MatchMode.ANYWHERE),
				Restrictions.like("bisbn", keyword, MatchMode.ANYWHERE)));
	}

}
