package com.xt.ebook.dao;

import java.io.Serializable;
import java.util.List;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class BaseDAOImpl<T, PK extends Serializable> extends HibernateDaoSupport implements IBaseDAO<T, PK> {

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

	public T findById(PK id) {

		return (T) getHibernateTemplate().get(cls, id);
	}

	public List<T> findByIds(PK[] ids) {

		return null;
	}

	public List<T> findByPage(int pageNow, int pageSize) {

		HibernateTemplate ht = getHibernateTemplate();
		DetachedCriteria criteria = DetachedCriteria.forClass(cls);
		return (List<T>) ht.findByCriteria(criteria, pageNow, pageSize);
	}

	public List<T> find(String hql, String param) {

		
		return null;
	}

}
