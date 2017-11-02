package com.zzkj.xyw.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzkj.xyw.dao.ITraveltipDAO;
import com.zzkj.xyw.model.Search;
import com.zzkj.xyw.model.Traveltip;
import com.zzkj.xyw.service.ITraveltipService;

@Service("traveltipService")
public class TraveltipServiceImpl implements ITraveltipService {

	@Autowired
	private ITraveltipDAO traveltipDao;

	public void create(Traveltip tt) {
		// TODO Auto-generated method stub

		traveltipDao.add(tt);
	}

	// 默认排序 按热度排序
	public List<Traveltip> findByPage(int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		return traveltipDao.findByPage(pageNow, pageSize, "ttlike", false);
	}

	// 按查询条件查询攻略list
	public int cnt(Integer pageNow, int pageSize,
			List<Traveltip> traveltipList, HttpSession session) {

		Search sc = (Search) session.getAttribute("search");

		if (pageNow == null) {
			pageNow = 0;
		}

		String kword = sc.getKeyword();
		String sort = sc.getSort();
		String city = sc.getCity();
		// 关键字模糊查询
		SimpleExpression se1 = Restrictions.like("tttitle", kword,
				MatchMode.ANYWHERE);
		SimpleExpression se2 = Restrictions.like("ttcontent", kword,
				MatchMode.ANYWHERE);
		SimpleExpression se3 = Restrictions.like("ttcity", kword,
				MatchMode.ANYWHERE);

		SimpleExpression secity = Restrictions.ge("ttid", 1);
		// 默认按照热度降序排列
		String orderBy = "ttlike";
		boolean isAsc = false;

		// 选择攻略城市
		if (city != null) {
			secity = Restrictions.like("ttcity", city, MatchMode.ANYWHERE);
		}

		// 第一位1 按照ttlike
		// 第一位0 按照ttime
		// 第二位 0 降序 1 升序
		if (sort != null) {
			if ("10".equals(sort)) {
				orderBy = "ttlike";
				isAsc = false;
			} else if ("11".equals(sort)) {
				orderBy = "ttlike";
				isAsc = true;
			} else if ("01".equals(sort)) {
				orderBy = "ttime";
				isAsc = true;
			} else if ("00".equals(sort)) {
				orderBy = "ttime";
				isAsc = false;
			}
		}
		// 合并所有查询条件
		LogicalExpression le = Restrictions.and(Restrictions.or(se1, se2, se3),
				secity);
		traveltipList.addAll(traveltipDao.findByPage(pageNow, pageSize,
				orderBy, isAsc, le));
		return traveltipList.size();
	}

	public void delete(String[] ttid) {
		// TODO Auto-generated method stub

		traveltipDao.delete(ttid, "ttid");
	}

	public int ttCnt() {
		// TODO Auto-generated method stub
		return traveltipDao.cnt("Traveltip");
	}

	public Traveltip findById(int ttid) {
		// TODO Auto-generated method stub
		return traveltipDao.findById(ttid);
	}

	public void update(Traveltip tt) {
		// TODO Auto-generated method stub
		Traveltip tt2 = traveltipDao.findById(tt.getTtid());
		tt2.setTtcity(tt.getTtcity());
		tt2.setTtcontent(tt.getTtcontent());
		tt2.setTtime(tt.getTtime());
		// 修改后变为未审核
		tt2.setTtischeck(0);
		if (!"0".equals(tt.getTtpic())) {
			tt2.setTtpic(tt.getTtpic());
		}
		traveltipDao.update(tt2);
	}

	public List<Traveltip> findAll(List<Integer> ttids) {
		// TODO Auto-generated method stub

		return traveltipDao.findAll(Restrictions.in("ttid", ttids));
	}

	public int cnt(Criterion criterion) {
		// TODO Auto-generated method stub

		return traveltipDao.findAll(criterion).size();
	}

	public List<Traveltip> findByPage(int pageNow, int pageSize,
			Criterion... criterion) {
		// TODO Auto-generated method stub

		return traveltipDao.findByPage(pageNow, pageSize, "ttime", false,
				criterion);
	}

}
