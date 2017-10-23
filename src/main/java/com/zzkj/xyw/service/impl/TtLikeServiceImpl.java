package com.zzkj.xyw.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzkj.xyw.dao.ITraveltipDAO;
import com.zzkj.xyw.dao.ITtCltDAO;
import com.zzkj.xyw.dao.ITtLikeDAO;
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

	public List<TraveltipOp> findAll(List<Integer> ttids, int luid) {
		// TODO Auto-generated method stub

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

		// 记录用户操作的list
		List<TraveltipOp> traveltipopli = new ArrayList<TraveltipOp>();

		for (Integer ttid : ttids) {
			TraveltipOp ttop = new TraveltipOp();
			// 设置用户的点赞操作
			if (likettid.contains(ttid)) {
				ttop.setLike(1);
			} else {
				ttop.setLike(0);
			}

			// 设置用户的收藏操作
			if (cltttid.contains(ttid)) {
				ttop.setClt(1);
			} else {
				ttop.setClt(0);
			}
			// 设置用户操作的攻略对象
			ttop.setTt(traveltipDao.findById(ttid));
			traveltipopli.add(ttop);
		}

		return traveltipopli;
	}

}
