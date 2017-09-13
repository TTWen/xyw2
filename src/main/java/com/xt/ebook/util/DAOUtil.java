package com.xt.ebook.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DAOUtil {
	
	/**
	 * md5加密，不可逆加密，用于数据校验
	 */
	public String md5(String inStr) {
		MessageDigest md5 = null;
		// 加盐
		inStr = inStr + "{*nbsjt*asar#cdxd#}";
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();  
        byte[] byteArray = new byte[charArray.length];
        
        for (int i = 0; i < charArray.length; i++)  
            byteArray[i] = (byte) charArray[i];  
        byte[] md5Bytes = md5.digest(byteArray);  
        StringBuffer hexValue = new StringBuffer();  
        for (int i = 0; i < md5Bytes.length; i++){  
            int val = ((int) md5Bytes[i]) & 0xff;  
            if (val < 16)  
                hexValue.append("0");  
            hexValue.append(Integer.toHexString(val));  
        }
        return hexValue.toString();
	}
	
	/**
	 * 加密、解密（除密码之外的数据使用该方法）
	 * convertMD5(s) 加密
	 * convertMD5(dao.convertMD5(s)) 解密
	 */
	public String convertMD5(String inStr){  
		
        char[] a = inStr.toCharArray();  
        for (int i = 0; i < a.length; i++){  
            a[i] = (char) (a[i] ^ '*');
        }  
        String s = new String(a);  
        return s;
    }
	
}
