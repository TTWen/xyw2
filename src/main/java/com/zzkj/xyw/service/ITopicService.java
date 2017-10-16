package com.zzkj.xyw.service;

import java.util.List;

import com.zzkj.xyw.model.Topic;

public interface ITopicService {

	// C
	public void create(Topic tp);
	
	// R
	public List<Topic> findByPage(int pageNow, int pageSize);
	public List<Topic> findByPage(int pageNow, int pageSize, int ttid);
	
	// D
	public void delete(String[] tpid);
	
	// 某个攻略下的评论数
	public int topicCnt(int ttid);
}
