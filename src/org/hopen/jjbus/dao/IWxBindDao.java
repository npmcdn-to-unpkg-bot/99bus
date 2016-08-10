package org.hopen.jjbus.dao;

import java.util.Map;

public interface IWxBindDao {
	public Map<String, Object> queryUserInfo(String openId);
	public boolean existsCheck(String openId, String userName);
	public boolean existsCheckForOpenId(String openId);
	public boolean existsCheckForUserName(String userName);
	public boolean addForBind(Map<String, Object> userInfo);
	public boolean updateForLogin(String openid);
	public boolean updateForQuit(String userName);
	public boolean updateForLoginByUserName (Map<String, Object> map);
	
}
