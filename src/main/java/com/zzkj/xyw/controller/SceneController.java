package com.zzkj.xyw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zzkj.xyw.model.Scene;
import com.zzkj.xyw.service.ISceneService;
import com.zzkj.xyw.util.UploadFile;

@Controller
public class SceneController {

	@Autowired
	private ISceneService sceneService;
	
	@RequestMapping("/manage/scene")
	public String sceneList(Integer pageNow, Model model) {
		
		
		return "/manage/scene";
	}
	
	@RequestMapping("/manage/scene/{pageNow}")
	public String sceneList2(@PathVariable Integer pageNow, Model model) {
		
		
		return "/manage/scene";
	}
	
	@RequestMapping("/manage/scene")
	public String addScene() {
		
		
		return "/manage/addScene";
	}
	
	// 添加
	@RequestMapping("/manage/addScene")
	public String addScene(Scene scene, MultipartFile file,Model model) 
			throws Exception{
		
		sceneService.create(scene);
		if (!file.isEmpty()) {
			String spic = UploadFile.doUpload("F:/xyw/scenepic/", file,
					scene.getSid());
			scene.setSpic(spic.substring(6));
			sceneService.update(scene);
		}
		return "/success";
	}
	
	
}
