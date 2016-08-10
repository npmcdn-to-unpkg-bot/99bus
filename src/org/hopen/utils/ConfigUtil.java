package org.hopen.utils;

import java.util.ResourceBundle;

/**
 * 项目参数工具类
 * 
 * @author 
 * 
 */
public class ConfigUtil {

	private static final ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/hopen/cfg/spring/config");

	/**
	 * 获得sessionInfo名字
	 * 
	 * @return
	 */
	public static  String getSessionInfoName() {
		return bundle.getString("sessionInfoName");
	}

	/**
	 * 通过键获取值
	 * 
	 * @param key
	 * @return
	 */
	public static  String get(String key) {
		return bundle.getString(key);
	}
	public static  String getSecretKey() {
		return bundle.getString("secretKey");
	}
	public static  String getSignKey() {
		return bundle.getString("signKey");
	}
	public static String getBankList(){
		return bundle.getString("banklist");
	}
	public static String getPayUrl(){
		return bundle.getString("payUrl");
	}
}
