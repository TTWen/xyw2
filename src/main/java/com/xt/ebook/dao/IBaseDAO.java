package com.xt.ebook.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDAO<T, PK extends Serializable> {

	// 添加  
    public void add(T t);
    
    // 删除  
    public void delete(T t);
    
    // 更新  
    public void update(T t);
    
    // 根据id查询  
    public T findById(PK id);
    
    public List<T> findByIds(PK[] ids);
    
    // 分页
    public List<T> findByPage(int pageNow, int pageSize);
    
    // 根据具体的hql语句查找实体类
    List<T> find(String hql , String param);
    
}
