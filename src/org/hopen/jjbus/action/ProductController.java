/**
  * @author jerry
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.jjbus.action;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.hopen.jjbus.bean.OptResponse;
import org.hopen.jjbus.service.IOtherService;
import org.hopen.jjbus.service.IProductService;
import org.hopen.jjbus.service.IUserBaseService;
import org.hopen.utils.DateUtils;
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
@RequestMapping("/prdct")
public class ProductController extends BaseController {
	@Autowired
	IProductService productService;
	@Autowired
	IOtherService otherService;
	@Autowired
	IUserBaseService userBaseService;
	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		String endDate ="";
		String startDate = DateUtils.getNowDate("yyyy-MM-dd", Calendar.MONTH, -3);
		Map<String, String> params = new HashMap<String,String>();
		params.put("apr", "0");
		params.put("amount", "0");
		params.put("startDate", startDate);
		params.put("endDate", endDate);
		params.put("orderType", "0");
		OptResponse<JSONObject> bids = productService.queryProductList(params);
		
		JSONObject jobj = otherService.queryBanner();
		JSONArray bannerList = jobj.getJSONArray("homeAds");
		request.setAttribute("adsList", bannerList);
		if(!bids.getError().equals("-1")){
			request.setAttribute("msg", bids.getMsg());
		}
		request.setAttribute("jresponse", bids);
		
		return "/index";
	}
	@RequestMapping("toLst")
	public String toList(HttpServletRequest request){
		Map<String, String> params = new HashMap<String,String>();
		params.put("apr", "");
		params.put("amount", "");
		params.put("startDate", "");
		params.put("endDate", "");
		params.put("orderType", "");
		OptResponse<JSONObject> bids = productService.queryProductList(params);
		if(!bids.getError().equals("-1")){
			request.setAttribute("msg", bids.getMsg());
		} 
	
		request.setAttribute("response", bids);
		
		return "/prdctlst";
	}
	@RequestMapping("/toBdDtl")
	public String toBidDetail(HttpServletRequest request,String bid,String msg,String product_name){
		Map<String, String> params = new HashMap<String,String>();
		Map<String, String> paramsQr = new HashMap<String,String>();
		params.put("borrowId", bid);
		params.put("userId", "");
		paramsQr.putAll(params);
		JSONObject jobj = productService.queryProductDetail(params);
		jobj.put("product_name", product_name);
		OptResponse<JSONObject> inverstRecord = productService.queryProductInverstRecord(paramsQr);
		String borrowerid = jobj.getString("bidUserIdSign");
		JSONObject borrowerInfo = userBaseService.queryUserInfo(borrowerid);
		request.setAttribute("response", jobj);
		request.setAttribute("inverstRecord", inverstRecord);
		request.setAttribute("borrowerInfo", borrowerInfo);
		if(msg != null) request.setAttribute("msg", msg);
		return "/bddtl";
	}
	@RequestMapping("/toOverBdDtl")
	public String toOverBdDtl(HttpServletRequest request,String bid,String msg,String product_name){
		Map<String, String> params = new HashMap<String,String>();
		Map<String, String> paramsQr = new HashMap<String,String>();
		params.put("borrowId", bid);
		params.put("userId", "");
		paramsQr.putAll(params);
		JSONObject jobj = productService.queryProductDetail(params);
		jobj.put("product_name", product_name);
		OptResponse<JSONObject> inverstRecord = productService.queryProductInverstRecord(paramsQr);
		String borrowerid = jobj.getString("bidUserIdSign");
		JSONObject borrowerInfo = userBaseService.queryUserInfo(borrowerid);
		request.setAttribute("response", jobj);
		request.setAttribute("inverstRecord", inverstRecord);
		request.setAttribute("borrowerInfo", borrowerInfo);
		if(msg != null) request.setAttribute("msg", msg);
		return "/overbddtl";
	}
	
	
	@RequestMapping("/toTrnsfrLst")
	public String toTransferList(HttpServletRequest request){
		String endDate = DateUtils.getNowDate("yyyy-MM-dd");
		String startDate = DateUtils.getNowDate("yyyy-MM-dd", Calendar.MONTH, -1);
		Map<String, String> params = new HashMap<String,String>();
		params.put("apr", "0");
		params.put("amount", "0");
		params.put("startDate", startDate);
		params.put("endDate", endDate);
		params.put("orderType", "3");
		OptResponse<JSONObject> bids = productService.queryTransferBidList(params);
		if(!bids.getError().equals("-1")){
			request.setAttribute("msg", bids.getMsg());
		} else {
			request.setAttribute("response", bids);
		}
		
		return "/trnsfrlst";
	}
	@RequestMapping("/toTrsfrBdDtl")
	public String toTrsfrBidDetail(HttpServletRequest request){
		return "/trnsfrbddtl";
	}
	@RequestMapping("/toJckrBd")
	public String toJackarooBid(HttpServletRequest request){
		return "/jckrbd";
	}
}
