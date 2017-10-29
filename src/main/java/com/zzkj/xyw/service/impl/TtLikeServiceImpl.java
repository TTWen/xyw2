package com.zzkj.xyw.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzkj.xyw.dao.ITraveltipDAO;
import com.zzkj.xyw.dao.ITtCltDAO;
import com.zzkj.xyw.dao.ITtLikeDAO;
import com.zzkj.xyw.model.Traveltip;
import com.zzkj.xyw.model.TraveltipOp;
import com.zzkj.xyw.model.TtClt;
import com.zzkj.xyw.model.TtLike;
import com.zzkj.xyw.service.ITtLikeService;

@Service("ttLikeService")
public class TtLikeServiceImpl implements ITtLikeService {

	@Autowired
	private ITtLikeDAO ttLikeDao;
	@Autowired
	private ITtCltDAO ttCltDao;
	@Autowired
	private ITraveltipDAO traveltipDao;

	public void create(TtLike like) {
		// TODO Auto-generated method stub

		ttLikeDao.add(like);
	}

	public void delete(String criteria) {
		// TODO Auto-generated method stub

		ttLikeDao.delete(criteria);
	}

	// 用户对当前页攻略的操作记录list
	public List<TraveltipOp> findAll(List<Traveltip> traveltipList, Integer luid) {
		
		List<TraveltipOp> ttopList = new ArrayList<TraveltipOp>();
		// 当前页攻略id组成的list
		List<Integer> ttids = new ArrayList<Integer>();
		
		int i = 0;
		for (Traveltip tt : traveltipList) {
			
			ttids.add(tt.getTtid());
			// ttopList 初始化
			ttopList.add(new TraveltipOp());
			ttopList.get(i).setTt(tt);
			ttopList.get(i).setClt(0);
			ttopList.get(i).setLike(0);
			i++;
		}
		
		// 当前用户已登录
		if(luid != null) {
			List<TtLike> like = ttLikeDao
					.findAll(Restrictions.and(Restrictions.in("lttid", ttids),
							Restrictions.eq("luid", luid)));

			List<TtClt> clt = ttCltDao
					.findAll(Restrictions.and(Restrictions.in("cttid", ttids),
							Restrictions.eq("cuid", luid)));

			List<Integer> likettid = new ArrayList<Integer>();
			List<Integer> cltttid = new ArrayList<Integer>();

			for (TtLike li : like) {
				likettid.add(li.getLttid());
			}
			for (TtClt li : clt) {
				cltttid.add(li.getCttid());
			}

			int j = 0;
			for (Integer ttid : ttids) {
				// 设置用户的点赞操作
				if (likettid.contains(ttid)) {
					ttopList.get(j).setLike(1);
				}

				// 设置用户的收藏操作
				if (cltttid.contains(ttid)) {
					ttopList.get(j).setClt(1);
				}
				
				j++;
			}
		}
		// 当前用户是游客
		return ttopList;
	}
}
