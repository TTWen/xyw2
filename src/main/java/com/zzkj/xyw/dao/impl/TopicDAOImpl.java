package com.zzkj.xyw.dao.impl;

import org.springframework.stereotype.Repository;

import com.zzkj.xyw.dao.ITopicDAO;
import com.zzkj.xyw.model.Topic;

@Repository("topicDao")
public class TopicDAOImpl extends BaseDAOImpl<Topic, String> implements ITopicDAO{

}
