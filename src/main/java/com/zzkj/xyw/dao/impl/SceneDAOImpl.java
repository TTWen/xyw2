package com.zzkj.xyw.dao.impl;

import org.springframework.stereotype.Repository;

import com.zzkj.xyw.dao.ISceneDAO;
import com.zzkj.xyw.model.Scene;

@Repository("sceneDao")
public class SceneDAOImpl extends BaseDAOImpl<Scene, String> implements
		ISceneDAO {

}
