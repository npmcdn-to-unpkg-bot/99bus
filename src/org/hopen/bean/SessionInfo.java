package org.hopen.bean;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hopen.utils.ConfigUtil;

public class SessionInfo {
	private final static Logger logger = Logger.getLogger(SessionInfo.class);
	Map<String, Object> loginInfo = null;
	String transText = null;
	/**
	 * @return the transText
	 */
	public String getTransText() {
		return transText;
	}
	/**
	 * @param transText the transText to set
	 */
	public void setTransText(String transText) {
		this.transText = transText;
	}
	/**
	 * @return the loginInfo
	 */
	public Map<String, Object> getLoginInfo() {
		return loginInfo;
	}
	/**
	 * @param loginInfo the loginInfo to set
	 */
	public void setLoginInfo(Map<String, Object> loginInfo) {
		this.loginInfo = loginInfo;
	}

	String userId = null;
	String ips = null;
	String userName = null;
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	String mobile = null;
	String tmpUserName = null;
	String openId = null;
	String saveAction = null;
	
	/**
	 * @return the ips
	 */
	public String getIps() {
		return ips;
	}
	/**
	 * @param ips the ips to set
	 */
	public void setIps(String ips) {
		this.ips = ips;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTmpUserName() {
		return tmpUserName;
	}
	public void setTmpUserName(String tmpUserName) {
		this.tmpUserName = tmpUserName;
	}
	public String getPrvKey() {
		return prvKey;
	}
	public void setPrvKey(String prvKey) {
		this.prvKey = prvKey;
	}
	String prvKey = null;
	public String getSaveAction() {
		return saveAction;
	}
	public void setSaveAction(String saveAction) {
		this.saveAction = saveAction;
	}
	Map<String, Object> relaMap = new HashMap<String, Object>();
	
	public boolean isAuthorization(){
		String wxauth = ConfigUtil.get("wxauth");
		String userAuth = ConfigUtil.get("userauth");
		int  check = 0;
		if(wxauth == null || !wxauth.equals("0")){
			if(openId != null && !openId.equals("")){
				check = check + 1;
			}
		} else {
			check = check + 1;
		}
		if(userAuth == null || !userAuth.equals("0")){
			if(userName!= null && !userName.equals("")){
				check = check + 1;
			}
		} else {
			check = check + 1;
		}
		logger.debug("*****:" + userName + "|" + openId);
		return check == 2;
	}
	public boolean isBind(){
		if(openId!= null && !openId.equals("")&& tmpUserName!= null && !tmpUserName.equals("")){
			return true;
		} else {
			return false;
		}
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Map<String, Object> getRelaMap() {
		return relaMap;
	}
	public void setRelaMap(Map<String, Object> relaMap) {
		this.relaMap = relaMap;
	}
	public void clean(){
		userId = null;
		ips = null;
		userName = null;
		tmpUserName = null;
		openId = null;
		saveAction = null;
	}
	public static SessionInfo getUserInfo(HttpServletRequest request){
		return (SessionInfo)request.getSession().getAttribute(ConfigUtil.getSessionInfoName());
	}
}
