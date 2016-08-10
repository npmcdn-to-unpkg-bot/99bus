/**
 * @author jerry
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.jjbus.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import org.hopen.jjbus.bean.OptResponse;
import org.hopen.jjbus.service.IProductService;
import org.hopen.jjbus.utils.HttpForJsonUtils;
import org.hopen.utils.DateUtils;
import org.hopen.utils.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jerry
 *
 */
@Service
@SuppressWarnings("unchecked")
public class ProductService implements IProductService {

	/* 
	 *  投资列表
	 */

	@Override
	public OptResponse<JSONObject> queryProductList(Map<String, String> params) {
		params.put("OPT", "10");
		JSONObject rObj = HttpForJsonUtils.post(params);
		OptResponse<JSONObject> jobj = JSONObject.toJavaObject(rObj, OptResponse.class);
		List<JSONObject> joblist = jobj.getList();
		if(joblist==null) return jobj;
		for(JSONObject jo:joblist){
			String periodUnit = jo.getString("period_unit");
			String amount = jo.getString("amount");
			String apr = jo.getString("apr");
			jo.put("amount_formatter", StringUtils.amountFormat(amount, 2));
			jo.put("apr_formatter", StringUtils.amountFormat(apr, 1));
			String has_invested_amount = jo.getString("has_invested_amount");
			jo.put("has_invested_amount_formatter", StringUtils.amountFormat(has_invested_amount, 2));
			String canInversterdAmt = String.valueOf(Double.parseDouble(amount)-Double.parseDouble(has_invested_amount));
			jo.put("can_inverster_amt_formatter", StringUtils.amountFormat(canInversterdAmt, 2));
			
			if(periodUnit.equals("-1")){
				jo.put("periodUnitStr","年");
			} else if(periodUnit.equals("0")){
				jo.put("periodUnitStr","个月");
			} else if(periodUnit.equals("1")){
				jo.put("periodUnitStr","天");
			}
		}
		return jobj;
	}

	/* 
	 * 债券变现
	 */
	@Override
	public OptResponse<JSONObject> queryTransferBidList(
			Map<String, String> params) {
		params.put("OPT", "30");
		JSONObject rObj = HttpForJsonUtils.post(params);
		return JSONObject.toJavaObject(rObj, OptResponse.class);
	}

	/* (non-Javadoc)
	 * @see org.hopen.jjbus.service.IProductService#queryProductDetail(java.util.Map)
	 */
	@Override
	public JSONObject queryProductDetail(Map<String, String> params) {
		params.put("OPT", "11");
		JSONObject rObj = HttpForJsonUtils.post(params);
		String remainTime = rObj.getString("remainTime").toString();
		String nowDt  = DateUtils.getNowDate("yyyy-MM-dd HH:mm:ss");
		long remainStr= DateUtils.decreaseMins(nowDt, remainTime, "yyyy-MM-dd HH:mm:ss");
		rObj.put("remainTimeCalc", remainStr);
		
		String borrowAmount = rObj.getString("borrowAmount");
		rObj.put("borrowAmount_formatter", StringUtils.amountFormat(borrowAmount, 2));
		
		String annualRate = rObj.getString("annualRate");
		rObj.put("annualRate_formatter", StringUtils.amountFormat(annualRate, 1));
		
		String canInvestAmount = rObj.getString("canInvestAmount");
		rObj.put("canInvestAmount_formatter", StringUtils.amountFormat(canInvestAmount, 2));
		
		return rObj;
	}

	/* (non-Javadoc)
	 */
	@Override
	public OptResponse<JSONObject> queryProductInverstRecord(Map<String, String> params) {
		params.put("OPT", "12");
		JSONObject rObj = HttpForJsonUtils.post(params);
		OptResponse<JSONObject> jobj = JSONObject.toJavaObject(rObj, OptResponse.class);
		List<JSONObject> joblist = jobj.getList();
		if(joblist==null) return jobj;
		for(JSONObject jo:joblist){
			JSONObject timeJson = jo.getJSONObject("time");
			long time = timeJson.getLongValue("time");
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String timeStr = sd.format(time);
			String invest_amount = jo.getString("invest_amount");
			jo.put("invest_amount_formatter", StringUtils.amountFormat(invest_amount, 2));
			jo.put("timeStr", timeStr);
		}
		return jobj;
	}
}
