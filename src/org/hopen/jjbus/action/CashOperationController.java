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
import org.hopen.jjbus.service.ICashOperationService;
import org.hopen.utils.ConfigUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author jerry
 * 
 */
@Controller
@RequestMapping("/cshoprtn")
public class CashOperationController extends BaseController {
	@Autowired
	ICashOperationService cashOperationSevice;
	
	@RequestMapping("/toDrawInFyPage")
	public String toDrawInFyPage(HttpServletRequest request, String amount) {
		request.setAttribute("page", SessionInfo.getUserInfo(request).getTransText());
		SessionInfo.getUserInfo(request).setTransText(null);
		return "/acct/fyWithPayInPage";
	}
	@RequestMapping("/toDrwIn")
	public String toDrawInNew(HttpServletRequest request, String amount) {
		if (amount == null || amount == "" || Float.parseFloat(amount) <= 0) {
			request.setAttribute("msg", "充值金额必须大于0");
			return "forward:/usrbs/toCptl";
		}
		Map<String, String> jobj = new HashMap<String, String>();
		jobj.put("userId", SessionInfo.getUserInfo(request).getUserId());
		jobj.put("amount", amount);
		JSONObject job = cashOperationSevice.queryPayInPage(jobj);
		String htmlPar = job.getString("htmlParam");
		Document document = Jsoup.parse(htmlPar);
		Element e = document.getElementById("frm1");
		e.attr("target","fyFrame");
		job.put("htmlParam", document.html());
		SessionInfo.getUserInfo(request).setTransText(document.html());
		String error = job.getString("error");
		if(!error.equals("-1")){
			request.setAttribute("msg", job.getString("msg"));
			return "forward:/usrbs/toCptl";
		}
		request.setAttribute("response", job);
		return "/acct/in_money";
	}
	
	@RequestMapping("/toDrwOt")
	public String toDrawOut(HttpServletRequest request) {
		String userId = SessionInfo.getUserInfo(request).getUserId();
		JSONObject jobj = cashOperationSevice.queryCashInit(userId);
		String error = jobj.getString("error");
		if(!error.equals("-1")){
			request.setAttribute("msg", jobj.getString("msg"));
			return "forward:/usr/toCptl";
		} 
		request.setAttribute("response", jobj);
		return "/acct/draw_money";
	}
	@RequestMapping("/toDrawOutPage")
	public String toDrawOutPage(HttpServletRequest request){
		request.setAttribute("page", SessionInfo.getUserInfo(request).getTransText());
		SessionInfo.getUserInfo(request).setTransText(null);
		return "/acct/fyWithDrawPage";
	}
	@RequestMapping("/drawRqst")
	public String drawRqst(HttpServletRequest request,String bankId,String amount,String payPassword) {
		String userId = SessionInfo.getUserInfo(request).getUserId();
		Map<String, String> inMap = new HashMap<String, String>();
		inMap.put("user_id", userId);
		inMap.put("amount", amount);
		inMap.put("payPassword",Encrypt.encrypt3DES(payPassword, ConfigUtil.getSecretKey()));
		inMap.put("bankId", bankId);
		JSONObject jobj = cashOperationSevice.storeDrawRqst(inMap);
		String error = jobj.getString("error");
		if(!error.equals("-1")){
			request.setAttribute("msg", jobj.getString("msg"));
			request.setAttribute("amount", amount);
			return "forward:/cshoprtn/toDrwOt";
		} 
		String htmlParam = jobj.getString("htmlParam");
		Document document = Jsoup.parse(htmlParam);
		Elements e = document.getElementsByAttributeValue("id", "frm1");
		e.attr("target","fyFrame");
		SessionInfo.getUserInfo(request).setTransText(document.html());
		request.setAttribute("response", jobj);
		return "/acct/draw_brige";
	}
	@RequestMapping("/checkTrad")
	@ResponseBody
	public JSONObject checkTrad(HttpServletRequest request) {
		String userId = SessionInfo.getUserInfo(request).getUserId();
		if(userId != null && !userId.equals("")){
			JSONObject jobj = cashOperationSevice.queryCashInit(userId);
			String error = jobj.getString("error");
			boolean setTradPwd = jobj.getBoolean("payPasswordStatus");
			if(error.equals("-1")&&setTradPwd){
				return JSONObject.parseObject("{error:-1,msg:'检查通过'}");
			} else {
				return JSONObject.parseObject("{error:-8,msg:'未设置交易密码'}");
			}
		} else {
			return JSONObject.parseObject("{error:-9,msg:'未登录'}");
		}
		
	}
	
	@RequestMapping("/checkBank")
	@ResponseBody
	public JSONObject checkBank(HttpServletRequest request) {
		String userId = SessionInfo.getUserInfo(request).getUserId();
		JSONObject jobj = cashOperationSevice.queryCashInit(userId);
		String error = jobj.getString("error");
		JSONArray bankList = jobj.getJSONArray("bankList");
		if(error.equals("-1")&&bankList != null &&bankList.size()>0){
			return JSONObject.parseObject("{error:-1,msg:'检查通过'}");
		} else {
			return JSONObject.parseObject("{error:9999,msg:'检查失败'}");
		}
	}

	@RequestMapping("/inverstBid")
	public String inverstBid(HttpServletRequest request, String borrowId,
			String amount, String dealPwd) {
		String userid = SessionInfo.getUserInfo(request).getUserId();
		Map<String, String> map = new HashMap<String, String>();
		map.put("borrowId", borrowId);
		map.put("userId", userid);
		map.put("amount", amount);
		map.put("dealPwd", Encrypt.encrypt3DES(dealPwd, ConfigUtil.getSecretKey()));
		JSONObject rjob = cashOperationSevice.stroeInverstBid(map);
		String error = rjob.getString("error");
		if (!error.equals("-1")) {
			return "forward:/prdct/toBdDtl?bid=" +borrowId +"&msg=" + rjob.get("msg");
		}
		request.setAttribute("msg",rjob.getString("msg"));
		return "forward:/usrbs/toCptl";
	}
	
	@RequestMapping("/toQueryTradList")
	public String toQueryTradList(HttpServletRequest request, String borrowId,
			String amount, String dealPwd) {
		String userid = SessionInfo.getUserInfo(request).getUserId();
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", userid);
		map.put("purpose", "0");
		JSONObject rjob = cashOperationSevice.queryTradRecord(map);
		request.setAttribute("response", rjob);
		return "/user/tradlist";
	}
}
