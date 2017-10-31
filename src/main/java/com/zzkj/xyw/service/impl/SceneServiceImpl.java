package com.zzkj.xyw.service.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
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

}
