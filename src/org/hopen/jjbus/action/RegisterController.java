/**
 * @author jerry
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.jjbus.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.hopen.bean.SessionInfo;
import org.hopen.jjbus.security.Encrypt;
import org.hopen.jjbus.service.IOtherService;
import org.hopen.jjbus.service.IRegisterService;
import org.hopen.jjbus.service.IUserBaseService;
import org.hopen.jjbus.service.IUserService;
import org.hopen.utils.ConfigUtil;
import org.hopen.utils.RegExpValidatorUtils;
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
@RequestMapping("/rgstr")
public class RegisterController extends BaseController {
	@Autowired
	IRegisterService registerService;
	@Autowired
	IUserService userService;
	@Autowired
	IOtherService otherService;
	@Autowired
	IUserBaseService userBaseService;
	
	@RequestMapping("/toRgstr")
	public String toRegister(HttpServletRequest request){
		return "/user/inputTel";
	}
	@RequestMapping("/toAgrmnt")
	public String toAgreement(HttpServletRequest request){
		Map<String,Object> job = registerService.queryRegAgreement();
		String error = StringUtils.getValue(job, "error");
		if(!error.equals("-1")){
			request.setAttribute("msg", StringUtils.getValue(job, "msg"));
			return "forward:/rgstr/toRegister";
		} else {
			request.setAttribute("content", StringUtils.getValue(job, "content"));
		}
		return "/user/agreement";
	}
	@RequestMapping("/toInptPWD")
	public String toInputPWD(HttpServletRequest request,String mobile){
		//验证输入
		if(RegExpValidatorUtils.IsTelephone(mobile)) {
			request.setAttribute("msg", "手机号长度必须11位，且必须为数字");
			request.setAttribute("mobile",mobile);
			return "/toRgstr";
		}
		//发验证码
		registerService.hisSendSMS(mobile);
		String header = mobile.substring(0,3);
		String end = mobile.substring(8);
		request.setAttribute("mobile", mobile);
		request.setAttribute("mobileshow", header+"*****"+ end);
		return "/user/inputInfo";
	}
	@RequestMapping("/toBndCrd")
	public String toBindCard(HttpServletRequest request){
		String userId =SessionInfo.getUserInfo(request).getUserId();
		JSONObject json = otherService.query166(userId);
		JSONObject prsInfo = userBaseService.queryUserInfo(userId);
		request.setAttribute("response", json);
		request.setAttribute("user", prsInfo);
		return "/user/bindCard";
	}
	
	@RequestMapping("/bind")
	public String bind(String realityName
			,String idNumber
			,String bank_cd
			,String bank_nm
			,String capAcntNo
			,String password
			,String bank_city
			,HttpServletRequest request){
		Map<String, String> params = new HashMap<String,String>();
		params.put("userId", SessionInfo.getUserInfo(request).getUserId());
		params.put("realityName", realityName);
		params.put("idNumber", idNumber);
		params.put("bank_cd", bank_cd);
		params.put("bank_nm", bank_nm);
		params.put("capAcntNo", capAcntNo);
		params.put("password", password);
		params.put("bank_city", bank_city);
		JSONObject jobj = registerService.storeBind(params);
		String errorIn  = StringUtils.getValue(jobj, "error");
		request.setAttribute("msg", StringUtils.getValue(jobj, "msg"));
		if(!errorIn.equals("-1")){
			request.setAttribute("realityName", realityName);
			request.setAttribute("idNumber", idNumber);
			request.setAttribute("bank_cd", bank_cd);
			request.setAttribute("bank_nm", bank_nm);
			request.setAttribute("capAcntNo", capAcntNo);
			request.setAttribute("password", Encrypt.encrypt3DES(password, ConfigUtil.getSecretKey()));
			request.setAttribute("bank_city", bank_city);
			return "forward:/rgstr/toBndCrd";
		} 
		return "forward:/usrbs/toInf";
	}
	
	@RequestMapping("/rgstr")
	public String register(HttpServletRequest request,String randomCode,String mobile,String name,String pwd,String pwd2,String referrerName){
		String msg = "";
		SessionInfo sessionInfo = SessionInfo.getUserInfo(request); 
		if(pwd!= null && pwd2!= null && !pwd.equals("") && !pwd.equals("")&&pwd.equals(pwd2)){
			Map<String, String> rMap = new HashMap<String,String>();
			rMap.put("name", name);
			rMap.put("code", randomCode);
			rMap.put("mobile", mobile);
			rMap.put("pwd", Encrypt.encrypt3DES(pwd,ConfigUtil.getSecretKey()));
			rMap.put("referrerName", referrerName);
			JSONObject regJob = registerService.storeRegister(rMap);
			String errorIn  = StringUtils.getValue(regJob, "error");
			if(errorIn.equals("-1")){
				Map<String, String> info = new HashMap<String, String>();
				info.put("name", mobile);
				info.put("pwd", Encrypt.encrypt3DES(pwd,ConfigUtil.getSecretKey()));
				Map<String, Object> job = userService.hisLogin(info);
				String error = StringUtils.getValue(job, "error");
				if(!error.equals("-1")){
					request.setAttribute("msg", StringUtils.getValue(job, "msg"));
					return "forward:/usr/toLgn";
				} else {
					sessionInfo.setUserId(StringUtils.getValue(job, "id"));
					sessionInfo.setUserName(StringUtils.getValue(job, "username"));
					sessionInfo.setMobile(mobile);
					sessionInfo.setLoginInfo(job);
				}
				return "forward:/usrbs/toInf";
			} else {
				msg = StringUtils.getValue(regJob, "msg");
			}
		} else {
			msg = "密码不能为空，且两次密码不能相同！";
		}
		request.setAttribute("msg", msg);
		String header = mobile.substring(0,3);
		String end = mobile.substring(8);
		request.setAttribute("mobile", mobile);
		request.setAttribute("mobileshow", header+"*****"+ end);
		return "/user/inputInfo";
	}
}
