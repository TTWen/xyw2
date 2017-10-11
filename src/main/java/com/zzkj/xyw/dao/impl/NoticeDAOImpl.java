package com.zzkj.xyw.dao.impl;

import org.springframework.stereotype.Repository;

import com.zzkj.xyw.dao.INoticeDAO;
import com.zzkj.xyw.model.Notice;

@Repository("noticeDao")
public class NoticeDAOImpl extends BaseDAOImpl<Notice, String> implements INoticeDAO{

}
