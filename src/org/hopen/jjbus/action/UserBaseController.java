/**
 * @author jerry
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.jjbus.action;


import javax.servlet.http.HttpServletRequest;
import org.hopen.bean.SessionInfo;
import org.hopen.jjbus.service.ICashOperationService;
import org.hopen.jjbus.service.IUserBaseService;
import org.hopen.jjbus.service.IUserService;
import org.hopen.jjbus.service.IWxBindService;
import org.hopen.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author jerry
 *
 */
@Controller
@RequestMapping("/usrbs")
public class UserBaseController extends BaseController {
	@Autowired
	IWxBindService bindService;
	@Autowired
	IUserBaseService userBaseService;
	@Autowired
	ICashOperationService cashOperationService;
	@Autowired
	IUserService userService;
	@RequestMapping("/toCptl")
	public String toCapitail(HttpServletRequest request){
		SessionInfo sessionInfo = SessionInfo.getUserInfo(request);
		String userId = sessionInfo.getUserId();
		JSONObject jobj = cashOperationService.queryCashInit(userId);
		String error = jobj.getString("error");
		if(error.equals("-1")){
			request.setAttribute("userBalance", StringUtils.getValue(jobj, "userBalance"));
			request.setAttribute("withdrawalAmount", StringUtils.getValue(jobj, "withdrawalAmount"));
		}
		
		JSONObject respHistory = userBaseService.queryHistoryHoldList(userId);
		JSONObject respHolding = userBaseService.queryHoldingList(userId);
		request.setAttribute("respHistory", respHistory);
		request.setAttribute("respHolding", respHolding);
		return "/cptl";
	}
	@RequestMapping("/toInf")
	public String toInfo(HttpServletRequest request){
		
		String id = SessionInfo.getUserInfo(request).getUserId();
		JSONObject user = userBaseService.queryUserInfo(id);
		JSONObject jobj = cashOperationService.queryCashInit(id);
		JSONArray bankList = jobj.getJSONArray("bankList");
		if(bankList!=null&&bankList.size()>0){
			user.put("bindCard",true);
		}
		boolean isSetTrad = jobj.getBooleanValue("payPasswordStatus");
		user.put("setTradPwd",isSetTrad);
		user.put("headerImg",SessionInfo.getUserInfo(request).getLoginInfo().get("headImg").toString());
		
		if(!user.getString("error").equals("-1")) {
			request.setAttribute("msg", user.getString("msg"));
		} else {
			request.setAttribute("response", user);
		}
	
		return "/info";
	}
}
