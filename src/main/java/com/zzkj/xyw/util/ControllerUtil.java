package com.zzkj.xyw.util;

import java.util.List;

import org.springframework.ui.Model;

public class ControllerUtil {

	public static void addParam(Model model, int pageSize, int pageNow,
			List list, String listName, int cnt) {
		int allPages = 0;
		if(cnt != 0) {
			allPages = (cnt -1)/pageSize + 1;
		} else {
			pageNow = -1;
		}
		model.addAttribute(listName, list);
		model.addAttribute("pageNow", pageNow);
		model.addAttribute("allPages", allPages);
	}
}
