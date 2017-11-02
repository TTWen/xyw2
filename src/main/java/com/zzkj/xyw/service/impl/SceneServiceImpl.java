package com.zzkj.xyw.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzkj.xyw.dao.ISceneDAO;
import com.zzkj.xyw.model.Scene;
import com.zzkj.xyw.service.ISceneService;

@Service("sceneService")
public class SceneServiceImpl implements ISceneService {

	@Autowired
	private ISceneDAO sceneDao;

	public void create(Scene ntc) {
		// TODO Auto-generated method stub
		sceneDao.add(ntc);
	}

	public List<Scene> findByPage(int pageNow, int pageSize, Criterion c) {
		// TODO Auto-generated method stub
		return sceneDao.findByPage(pageNow, pageSize, "sid", true, c);
	}

	public void delete(String[] id) {
		// TODO Auto-generated method stub
		sceneDao.delete(id, "sid");

	}

	public int cnt(Criterion c) {
		// TODO Auto-generated method stub

		return sceneDao.findAll(c).size();
	}

	public void update(Scene scene) {
		// TODO Auto-generated method stub
		sceneDao.update(scene);
	}

	public Scene findById(int id) {
		// TODO Auto-generated method stub
		return sceneDao.findById(id);
	}

	public List<Scene> topK(int k) {
		// TODO Auto-generated method stub
		return sceneDao.findByPage(0, k, "sview", false);
	}

	public List<Scene> findByFirst(String first) {
		// TODO Auto-generated method stub
		Criterion c = Restrictions.eq("sfpy", first);

		return sceneDao.findAll(c);
	}

	public List<List<Scene>> findAll() {
		// TODO Auto-generated method stub
		String hql = "SELECT sprovince FROM Scene GROUP BY sprovince";
		List<String> provinceList = sceneDao.findCol(hql);
		System.out.println(provinceList);
		List<List<Scene>> allCity = new ArrayList<List<Scene>>();
		for (String provice : provinceList) {
			System.out.println(provice);
			allCity.add(sceneDao.findAll(Restrictions.eq("sprovince", provice)));
		}
		return allCity;
	}

}
