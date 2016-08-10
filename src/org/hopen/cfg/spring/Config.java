package org.hopen.cfg.spring;

import java.util.HashMap;
import java.util.Map;

public class Config {
	public final static Map<String, String> msgMap = new HashMap<String, String>();
	public final static Map<String, String> configMap = new HashMap<String, String>();
	public static String getMsg(String key){
		if(msgMap!= null) {
			return msgMap.get(key).toString();
		} else {
			return "not defined";
		}
	}
	public static String getConfig(String key){
		if(configMap!= null) {
			return configMap.get(key).toString();
		} else {
			return "not defined";
		}
	}
}
