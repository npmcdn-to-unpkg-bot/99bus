package org.hopen.jjbus.service.impl;

import java.util.Map;

import org.hopen.framework.exception.JYRunException;
import org.hopen.jjbus.dao.IWxBindDao;
import org.hopen.jjbus.service.IWxBindService;
import org.hopen.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author jerry
 *
 */
@Service("wxBindService")
public class WxBindService implements IWxBindService {
	
	@Autowired
	private IWxBindDao wxBindDao;
	@Override
	public Map<String, Object> queryUserInfo(String openId) {
		return wxBindDao.queryUserInfo(openId);
	}
	/* (non-Javadoc)
	 * @see org.hopen.jjbus.service.IWxBindService#addForBind(java.util.Map)
	 */
	@Override
	public boolean addForBind(Map<String, Object> userInfo) {
		
		String openId = StringUtils.getExistsValue(userInfo, "openid");
		String userName = StringUtils.getExistsValue(userInfo, "username");
		if(wxBindDao.existsCheckForOpenId(openId)){
			throw new JYRunException("微信已绑定过，请取消绑定后再登录");
		}
		if(wxBindDao.existsCheckForUserName(userName)){
			throw new JYRunException("用户已绑定过微信，请使用原微信登录取消绑定后再登录");
		}
		return this.wxBindDao.addForBind(userInfo);
	}
	public boolean updateForLogin(String openid){
		return this.wxBindDao.updateForLogin(openid);
	}
	/* (non-Javadoc)
	 * @see org.hopen.jjbus.service.IWxBindService#updateForQuit(java.lang.String)
	 */
	@Override
	public boolean updateForQuit(String userName) {
		return this.wxBindDao.updateForQuit(userName);
	}
	/* (non-Javadoc)
	 * @see org.hopen.jjbus.service.IWxBindService#addForHistory(java.util.Map)
	 */
	@Override
	public boolean addForHistory(Map<String, Object> userInfo) {
		String userName = StringUtils.getExistsValue(userInfo, "username");
		if(wxBindDao.existsCheckForUserName(userName)){
			return this.wxBindDao.updateForLoginByUserName(userInfo);
		} else {
			return this.wxBindDao.addForBind(userInfo);
		}
	}
}
