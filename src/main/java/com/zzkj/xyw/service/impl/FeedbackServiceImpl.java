package com.zzkj.xyw.service.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzkj.xyw.dao.IFeedbackDAO;
import com.zzkj.xyw.model.Feedback;
import com.zzkj.xyw.service.IFeedbackService;

@Service("feedbackService")
public class FeedbackServiceImpl implements IFeedbackService {

	@Autowired
	private IFeedbackDAO feedbackDao;

	public void create(Feedback fb) {
		// TODO Auto-generated method stub
		feedbackDao.add(fb);
	}

	public List<Feedback> findByPage(int pageNow, int pageSize, Criterion c) {
		// TODO Auto-generated method stub
		return feedbackDao.findByPage(pageNow, pageSize, "ftime", false, c);
	}

	public void delete(String[] id) {
		// TODO Auto-generated method stub
		feedbackDao.delete(id, "fid");
	}

	public int cnt(Criterion c) {
		// TODO Auto-generated method stub

		return feedbackDao.findAll(c).size();
	}

	public Feedback findById(int id) {
		// TODO Auto-generated method stub

		return feedbackDao.findById(id);
	}

	public void update(Feedback fb) {
		// TODO Auto-generated method stub

		feedbackDao.update(fb);
	}

}
