package com.zzkj.xyw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzkj.xyw.dao.INoticeDAO;
import com.zzkj.xyw.model.Notice;
import com.zzkj.xyw.service.INoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements INoticeService{

	@Autowired
	private INoticeDAO noticeDao;

	public void create(Notice ntc) {
		// TODO Auto-generated method stub
		noticeDao.add(ntc);
	}

	public List<Notice> findByPage(int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		return noticeDao.findByPage(pageNow, pageSize);
	}

	public void delete(String[] nid) {
		// TODO Auto-generated method stub
		noticeDao.delete(nid, "nid");
		
	}

	public int noticeCnt() {
		// TODO Auto-generated method stub
		
		return noticeDao.cnt("Notice");
	}
	
	
}
