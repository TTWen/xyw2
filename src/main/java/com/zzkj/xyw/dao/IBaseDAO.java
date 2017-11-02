package com.zzkj.xyw.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

public interface IBaseDAO<T, PK extends Serializable> {

	// 添加
	public void add(T t);

	// 删除
	public void delete(T t);

	// 批量
	public void delete(String[] ids, String idName);

	// 按条件删除
	public void delete(String criteria);

	// 更新
	public void update(T t);

	// 根据id查询
	public T findById(int id);

	// 默认分页
	public List<T> findByPage(int pageNow, int pageSize);

	// 按条件分页
	public List<T> findByPage(int pageNow, int pageSize, String orderBy,
			boolean isAsc, Criterion... criterions);

	public List<T> findAll(Criterion... criterions);

	// 总数
	public int cnt(String tblname);

	// 根据具体的hql语句查找实体类
	public List<T> find(String hql, String[] param);

	// 查找列
	public List findCol(String hql);

}
