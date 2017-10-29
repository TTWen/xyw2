package com.zzkj.xyw.dao.impl;

import org.springframework.stereotype.Repository;

import com.zzkj.xyw.dao.IFeedbackDAO;
import com.zzkj.xyw.model.Feedback;

@Repository("feedbackDao")
public class FeedbackDAOImpl extends BaseDAOImpl<Feedback, String> implements
		IFeedbackDAO {

}
