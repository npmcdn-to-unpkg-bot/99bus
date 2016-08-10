/**
 * @author jerry
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.jjbus.action;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.hopen.bean.SessionInfo;
import org.hopen.framework.encryption.RSAEncrypt;
import org.hopen.jjbus.security.Encrypt;
import org.hopen.jjbus.service.ICashOperationService;
import org.hopen.jjbus.service.IRegisterService;
import org.hopen.jjbus.service.IUserService;
import org.hopen.jjbus.service.IWxBindService;
import org.hopen.utils.ConfigUtil;
import org.hopen.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSONObject;

/**
 * @author jerry
 *
 */

@Controller
@RequestMapping("/usr")
public class UserController extends BaseController {
	
	@Autowired
	IWxBindService bindService;
	@Autowired
	IUserService userService;
	@Autowired
	IRegisterService registerService;
	@Autowired
	ICashOperationService cashOperationService;
	
	@RequestMapping("/toLgn")
	public String toLogin(HttpServletRequest request){
		RSAEncrypt rsaEncrypt = new RSAEncrypt();
		rsaEncrypt.genKeyPair();
		String pubKey = rsaEncrypt.getStringPublicKey();
		request.setAttribute("pubKey", pubKey);
		SessionInfo.getUserInfo(request).setPrvKey(
				rsaEncrypt.getStringPrivateKey());
		return "/lgn";
	}
	
	@RequestMapping("/lgn")
	public String bind(HttpServletRequest request, String userName, String pwd) {
		String realUserName = null;
		
		String realpwd = null;
		if (userName == null || pwd == null || userName.equals("")
				|| pwd.equals("")) {
			request.setAttribute("msg", "用户密码不可为空");
			return "forward:/usr/toLgn";
		}
		SessionInfo sessionInfo = SessionInfo.getUserInfo(request);
		try {
			RSAEncrypt rsaEncrypt = new RSAEncrypt();
			rsaEncrypt.loadPrivateKey(sessionInfo.getPrvKey());
			byte[] userBytes = rsaEncrypt.decrypt(rsaEncrypt.getPrivateKey(),
					userName);
			realUserName = new String(userBytes);
			byte[] pwdBytes = rsaEncrypt.decrypt(rsaEncrypt.getPrivateKey(),
					pwd);
			realpwd = new String(pwdBytes);
			if (realUserName == null || realpwd == null || realUserName.equals("")
					|| realpwd.equals("")) {
				request.setAttribute("msg", "用户密码不可为空");
				return "forward:/usr/toLgn";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "不可预测知错误：" + e.getMessage());
			return "forward:/usr/toLgn";
		}
		//登录login
		Map<String, String> info = new HashMap<String,String>();
		info.put("name", realUserName);
		info.put("pwd", Encrypt.encrypt3DES(realpwd,ConfigUtil.getSecretKey()));
		
		Map<String, Object> job = userService.hisLogin(info);
		String error = StringUtils.getValue(job, "error");
		if(!error.equals("-1")){
			request.setAttribute("msg", StringUtils.getValue(job, "msg"));
			return "forward:/usr/toLgn";
		} else {
			Map<String, Object> userInfo = new HashMap<String, Object>();
			userInfo.put("username", realUserName);
			userInfo.put("pwd", Encrypt.encrypt3DES(realpwd,ConfigUtil.getSecretKey()));
			
			bindService.addForHistory(userInfo);
			sessionInfo.setUserId(StringUtils.getValue(job, "id"));
			sessionInfo.setUserName(StringUtils.getValue(job, "username"));
			sessionInfo.setMobile(realUserName);
			sessionInfo.setLoginInfo(job);
		}
		
		String action = sessionInfo.getSaveAction();
		if (action != null) {
			return "forward:" + sessionInfo.getSaveAction();
		} else {
			return "forward:/prdct/index";
		}
	}
	@RequestMapping("/quit")
	public  String quit(HttpServletRequest request){
		SessionInfo sessionInfo = SessionInfo.getUserInfo(request);
		bindService.updateForQuit(sessionInfo.getUserName());
		sessionInfo.setUserId(null);
		sessionInfo.setIps(null);
		sessionInfo.setOpenId(null);
		sessionInfo.setUserName(null);
		sessionInfo.setTmpUserName(null);
		return "forward:/prdct/index";
	}
	@RequestMapping("/toSetTradPwd")
	public String toSetTradPwd(HttpServletRequest request){
		String userName = SessionInfo.getUserInfo(request).getMobile();
		String cellPhone = userName.substring(0,3) + "******" + userName.substring(10);
		request.setAttribute("showUseName", cellPhone);
		return "/user/setTradPwd";
	}
	@RequestMapping("/setTradPwd")
	public String setTradPwd(HttpServletRequest request,String tradpwd,String randomCode){
		Map<String, String> info  = new HashMap<String,String>();
		SessionInfo user = SessionInfo.getUserInfo(request);
		info.put("id", user.getUserId());
		info.put("cellPhone", user.getMobile());
		info.put("newdealpwd", Encrypt.encrypt3DES(tradpwd, ConfigUtil.getSecretKey()));
		info.put("randomCode", randomCode);
		JSONObject jobj = userService.hisSetTradPwd(info);
		String error = jobj.getString("error");
		if(!error.equals("-1")){
			request.setAttribute("msg", jobj.getString("msg"));
			return "forward:/usr/toSetTradPwd";
		}
		request.setAttribute("msg", "交易密码设置成功");
		return "forward:/usrbs/toInf";
	}
	@RequestMapping("/toUpdateTradPwd")
	public String toUpdateTradPwd(HttpServletRequest request){
		String userName = SessionInfo.getUserInfo(request).getMobile();
		String cellPhone = userName.substring(0,3) + "******" + userName.substring(10);
		request.setAttribute("showUseName", cellPhone);
		return "/user/updateTradPwd";
	}
	@RequestMapping("/updateTradPwd")
	public String updateTradPwd(HttpServletRequest request,String newdealpwd,String randomCode,String currentdealpwd){
		Map<String, String> info  = new HashMap<String,String>();
		SessionInfo user = SessionInfo.getUserInfo(request);
		info.put("id", user.getUserId());
		info.put("currentdealpwd", Encrypt.encrypt3DES(currentdealpwd, ConfigUtil.getSecretKey()));
		info.put("cellPhone", user.getMobile());
		info.put("newdealpwd", Encrypt.encrypt3DES(newdealpwd, ConfigUtil.getSecretKey()));
		info.put("randomCode", randomCode);
		JSONObject jobj = userService.hisUpdateTradPwd(info);
		String error = jobj.getString("error");
		if(!error.equals("-1")){
			request.setAttribute("msg", jobj.getString("msg"));
			return "forward:/usr/toUpdateTradPwd";
		}
		request.setAttribute("msg", "交易密码修改成功");
		return "forward:/usrbs/toInf";
	}
	@RequestMapping("/toFindTradPwd")
	public String toFindTradPwd(HttpServletRequest request){
		String userName = SessionInfo.getUserInfo(request).getMobile();
		String cellPhone = userName.substring(0,3) + "******" + userName.substring(10);
		request.setAttribute("showUseName", cellPhone);
		return "/user/findTradPwd";
	}
	@RequestMapping("/findTradPwd")
	public String findTradPwd(HttpServletRequest request ,String tradpwd,String randomCode){
		Map<String, String> info  = new HashMap<String,String>();
		SessionInfo user = SessionInfo.getUserInfo(request);
		info.put("id", user.getUserId());
		info.put("cellPhone", user.getMobile());
		info.put("newdealpwd", Encrypt.encrypt3DES(tradpwd, ConfigUtil.getSecretKey()));
		info.put("randomCode", randomCode);
		JSONObject jobj = userService.hisSetTradPwd(info);
		String error = jobj.getString("error");
		if(!error.equals("-1")){
			request.setAttribute("msg", jobj.getString("msg"));
			return "forward:/usr/toFindTradPwd";
		}
		request.setAttribute("msg", "交易密码重置成功");
		return "forward:/usrbs/toInf";
	}
	@RequestMapping("/toUpdateLoginPwdShow")
	public String toUpdateLoginPwdShow(HttpServletRequest request ,String tradpwd,String randomCode){
		String mobile = SessionInfo.getUserInfo(request).getMobile();
		String mobileShow = mobile.substring(0,3) + "*******" + mobile.substring(10);
		request.setAttribute("mobileShow", mobileShow);
		return "/user/updateLoginPwdShow";		
	}
	@RequestMapping("/toUpdateLoginPwd")
	public String toUpdateLoginPwd(HttpServletRequest request ,String tradpwd,String randomCode){
		String mobile = SessionInfo.getUserInfo(request).getMobile();
		registerService.hisSendSMS(mobile);
		String mobileShow = mobile.substring(0,3) + "*******" + mobile.substring(10);
		request.setAttribute("mobileShow", mobileShow);
		return "/user/updateLoginPwd";		
	}
	@RequestMapping("/updateLoginPwd")
	public String updateLoginPwd(HttpServletRequest request ,String oldloginpwd,String randomCode,String newloginpwd){
		String mobile = SessionInfo.getUserInfo(request).getMobile();
		Map<String, String> info = new HashMap<String, String>();
		info.put("id", SessionInfo.getUserInfo(request).getUserId());
		info.put("randomCode", randomCode);
		info.put("cellPhone", mobile);
		info.put("oldloginpwd", Encrypt.encrypt3DES(oldloginpwd,ConfigUtil.getSecretKey()));
		info.put("newloginpwd", Encrypt.encrypt3DES(newloginpwd,ConfigUtil.getSecretKey()));
		JSONObject jobj = userService.hisUpdateLoginPwd(info);
		String error = jobj.getString("error");
		request.setAttribute("msg",jobj.getString("msg"));
		if(!error.equals("-1")){
			return "forward:/usr/toUpdateLoginPwd";
		}
		return "forward:/usrbs/toInf";		
	}
	@RequestMapping("/toResetLoginPwdShow")
	public String toResetLoginPwdShow(HttpServletRequest request ,String tradpwd,String randomCode){
		return "/user/resetLoginPwdShow";		
	}
	@RequestMapping("/toResetLoginPwd")
	public String toResetLoginPwd(HttpServletRequest request,String mobile,String msg){
		SessionInfo.getUserInfo(request).setMobile(mobile);
		registerService.hisSendSMS(mobile);
		String mobileShow = mobile.substring(0,3) + "*******" + mobile.substring(10);
		request.setAttribute("mobileShow", mobileShow);
		if(msg!= null ){
			request.setAttribute("msg", msg);
		}
		return "/user/resetLoginPwd";		
	}
	@RequestMapping("/resetLoginPwd")
	public String resetLoginPwd(HttpServletRequest request,String newloginpwd,String randomCode){
		String mobile = SessionInfo.getUserInfo(request).getMobile();
		Map<String, String> map = new HashMap<String, String>();
		map.put("cellPhone", mobile);
		map.put("randomCode", randomCode);
		JSONObject jobj=registerService.hisValidateSMS(map);
		String error = jobj.getString("error");
		if(!error.equals("-1")){
			return "forward:/usr/toResetLoginPwd?mobile="+mobile+"&msg="+jobj.getString("msg");
		}
		Map<String, String> inMap = new HashMap<String, String>();
		inMap.put("newpwd", Encrypt.encrypt3DES(newloginpwd,ConfigUtil.getSecretKey()));
		inMap.put("cellPhone", mobile);
		JSONObject retJson = userService.hisReSetLoginPwd(inMap);
		String uErr = retJson.getString("error");
		if(!uErr.equals("-1")){
			return "forward:/usr/toResetLoginPwd?mobile="+mobile+"&msg="+retJson.getString("msg");
		}
		request.setAttribute("msg", retJson.getString("msg"));
		return "forward:/usr/toLgn";		
	}
}
