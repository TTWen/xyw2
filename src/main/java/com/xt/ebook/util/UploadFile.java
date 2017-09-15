package com.xt.ebook.util;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {

	public static String doUpload(String rootPath, MultipartFile file, int id)
			throws Exception {

		// 获得文件类型（可以判断如果不是图片，禁止上传）
		String contentType = file.getContentType();
		System.out.println(contentType);
		// 获得文件后缀名称
		String imgName = contentType.substring(contentType.indexOf("/") + 1);
		System.out.println(imgName);
		String path = rootPath + id + "." + imgName;
		file.transferTo(new File(path));
		return path;
	}
}
