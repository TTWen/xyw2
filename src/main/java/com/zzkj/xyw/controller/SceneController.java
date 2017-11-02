package com.zzkj.xyw.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zzkj.xyw.model.Scene;
import com.zzkj.xyw.service.ISceneService;
import com.zzkj.xyw.util.ControllerUtil;
import com.zzkj.xyw.util.UploadFile;

@Controller
public class SceneController {

	@Autowired
	private ISceneService sceneService;

	/*
	 * 管理员
	 */
	// 设置查找的省份
	@RequestMapping("/manage/scene")
	public String setProvice(String province, HttpSession session, Model model) {

		if (province == null) {
			province = "";
		}
		session.setAttribute("province", province);
		return sceneList(0, province, model);
	}

	// 景点一览
	public String sceneList(Integer pageNow, String province, Model model) {

		int pageSize = 2;
		int cnt = 0;
		if (pageNow == null) {
			pageNow = 0;
		}
		Criterion c = Restrictions.ge("sid", 1);
		if (!"".equals(province)) {
			c = Restrictions.eq("sprovince", province);
		}
		cnt = sceneService.cnt(c);
		List<Scene> sceneList = sceneService.findByPage(pageNow, pageSize, c);
		if (cnt == 0) {
			model.addAttribute("msg", "无景点信息！");
		}
		ControllerUtil.addParam(model, pageSize, pageNow, sceneList,
				"sceneList", cnt);
		return "/manage/scene";
	}

	@RequestMapping("/manage/scene/{pageNow}")
	public String sceneList2(@PathVariable Integer pageNow, Model model,
			HttpSession session) {

		String province = (String) session.getAttribute("province");
		return sceneList(pageNow, province, model);
	}

	// 添加景点页面
	@RequestMapping("/manage/scene/add")
	public String addScene() {

		return "/manage/addScene";
	}

	// 添加
	@RequestMapping("/manage/addScene")
	public String addScene(Scene scene, MultipartFile file, Model model)
			throws Exception {

		sceneService.create(scene);
		if (!file.isEmpty()) {
			String spic = UploadFile.doUpload("F:/xyw/scenepic/", file,
					scene.getSid());
			scene.setSpic(spic.substring(6));
			sceneService.update(scene);
		}
		return "/success";
	}

	// 删除
	@RequestMapping("/manage/deleteScene/{sid}")
	public String deleteScene(@PathVariable int sid, Model model,
			HttpSession session) {

		sceneService.delete(new String[] { String.valueOf(sid) });
		return "/success";
	}

	// 修改页面
	@RequestMapping("/manage/scene/modify/{sid}")
	public String modifyScene(@PathVariable int sid, Model model) {

		Scene scene = sceneService.findById(sid);
		model.addAttribute("scene", scene);
		return "/manage/modifyScene";
	}

	// 修改
	@RequestMapping("/manage/modifyScene")
	public String modifyScene(Scene scene, Model model, MultipartFile file)
			throws Exception {

		sceneService.update(scene);
		if (!file.isEmpty()) {
			String spic = UploadFile.doUpload("F:/xyw/scenepic/", file,
					scene.getSid());
			scene.setSpic(spic.substring(6));
			sceneService.update(scene);
		}
		return "/success";
	}

	/*
	 * 用户
	 */
	// 景点页
	@RequestMapping("/user/scene")
	public String setFirst(HttpSession session, Model model) {

		String first = "all";
		String[] letter = new String[] { "A", "B", "C", "D", "E", "F", "G",
				"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
				"T", "U", "V", "W", "X", "Y", "Z" };
		session.setAttribute("letter", letter);
		return userScene(model, first);
	}

	public String userScene(Model model, String first) {

		int k = 8;
		// 返回热门景点list
		List<Scene> hotSceneList = sceneService.topK(k);
		// 返回城市list

		if ("all".equals(first)) {

			List<List<Scene>> allCity = sceneService.findAll();
			model.addAttribute("allCity", allCity);
		} else {
			List<Scene> cityList = sceneService.findByFirst(first);
			model.addAttribute("cityList", cityList);
		}
		model.addAttribute("hotSceneList", hotSceneList);

		return "/scene";
	}

	@RequestMapping("/user/scene/{first}")
	public String userScene(@PathVariable String first, Model model) {

		return userScene(model, first);
	}

	@RequestMapping("/user/sceneDetail/{sid}")
	public String sceneDetail(@PathVariable int sid, Model model) {

		Scene scene = sceneService.findById(sid);
		model.addAttribute("scene", scene);
		return "/sceneDetail";
	}

}
