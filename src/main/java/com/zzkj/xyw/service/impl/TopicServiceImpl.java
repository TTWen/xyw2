package com.zzkj.xyw.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzkj.xyw.dao.ITopicDAO;
import com.zzkj.xyw.model.Topic;
import com.zzkj.xyw.service.ITopicService;

@Service("topicService")
public class TopicServiceImpl implements ITopicService {

	@Autowired
	private ITopicDAO topicDao;

	public void create(Topic tp) {
		// TODO Auto-generated method stub
		topicDao.add(tp);
	}

	public List<Topic> findByPage(int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		return topicDao.findByPage(pageNow, pageSize);
	}

	public void delete(String[] tpid) {
		// TODO Auto-generated method stub
		topicDao.delete(tpid, "tpid");

	}

	public int topicCnt(int ttid) {
		// TODO Auto-generated method stub

		return topicDao.cnt("Topic where tpttid=" + ttid);
	}

	public List<Topic> findByPage(int pageNow, int pageSize, int ttid) {

		return topicDao.findByPage(pageNow, pageSize, "tptime", true,
				Restrictions.eq("tpttid", ttid));
	}

}
