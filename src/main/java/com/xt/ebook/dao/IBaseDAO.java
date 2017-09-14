package com.xt.ebook.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

public interface IBaseDAO<T, PK extends Serializable> {

	// 添加
	public void add(T t);

	// 删除
	public void delete(T t);

	// 更新
	public void update(T t);

	// 根据id查询
	public T findById(PK id);

	// 分页
	public List<T> findByPage(int pageNow, int pageSize);

	// 按列排序
	public List<T> findByPage(int pageNow, int pageSize, String orderBy,
			boolean isAsc, Criterion... criterions);

	// 按价格区间
	public List<T> findByPage(int pageNow, int pageSize, String orderBy,
			boolean isAsc, float min, float max);

	// 关键字搜索书
	public List<T> findByPage(int pageNow, int pageSize, String orderBy,
			boolean isAsc, String keyword);

	// 总数
	public int cnt(String hql);

	// 根据具体的hql语句查找实体类
	public List<T> find(String hql, String[] param);

}
