package org.hopen.jjbus.service;

import java.util.Map;

public interface IWxBindService {
	public Map<String, Object> queryUserInfo(String openId);
	public boolean addForBind(Map<String, Object> userInfo);
	public boolean addForHistory(Map<String, Object> userInfo);
	public boolean updateForLogin(String openid);
	public boolean updateForQuit(String userName);
}

