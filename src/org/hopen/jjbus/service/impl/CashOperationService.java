/**
 * @author jerry
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.jjbus.service.impl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.hopen.jjbus.service.ICashOperationService;
import org.hopen.jjbus.utils.HttpForJsonUtils;
import org.hopen.utils.StringUtils;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author jerry
 *
 */
@Service
public class CashOperationService implements ICashOperationService{

	@Override
	public JSONObject stroeInverstBid(Map<String, String> map) {
		map.put("OPT", "16");
		return HttpForJsonUtils.post(map);
	}

	@Override
	public JSONObject queryCashInit(String id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", id);
		map.put("OPT", "145");
		JSONObject jobj = HttpForJsonUtils.post(map);
		String withdrawalAmount = jobj.getString("withdrawalAmount");
		String userBalance = jobj.getString("userBalance");
		jobj.put("withdrawalAmount", StringUtils.amountFormat(withdrawalAmount,2));
		jobj.put("userBalance", StringUtils.amountFormat(userBalance,2));
		return jobj;
	}

	@Override
	public JSONObject queryPayInPage(Map<String, String> map) {
		map.put("OPT", "164");
		map.put("type", "1");
		return HttpForJsonUtils.post(map);
	}

	@Override
	public JSONObject storeDrawRqst(Map<String, String> map) {
		map.put("OPT", "144");
		map.put("type","1");
		return HttpForJsonUtils.post(map);	
	}

	@Override
	public JSONObject queryTradRecord(Map<String, String> map) {
		map.put("OPT","97");
		String currPage = StringUtils.getValue(map, "currPage");
		if(currPage.equals("")){
			map.put("currPage", "1");
		}
		
		JSONObject jobj = HttpForJsonUtils.post(map);
		JSONArray jobArr=jobj.getJSONObject("page").getJSONArray("page");
		if(jobArr==null) return jobj;
		for(int i = 0; i < jobArr.size();i++){
			for(int m = i; m < jobArr.size();m++){
				JSONObject joi = jobArr.getJSONObject(i);
				JSONObject timeJsoni = joi.getJSONObject("time");
				long timei = timeJsoni.getLongValue("time");
				
				JSONObject jom = jobArr.getJSONObject(m);
				JSONObject timeJsonm = jom.getJSONObject("time");
				long timem = timeJsonm.getLongValue("time");
				if(timei < timem) {
					jobArr.set(i,jom);
					jobArr.set(m,joi);
				}
			}
		}
		for(int i = 0; i < jobArr.size();i++){
			JSONObject jo = jobArr.getJSONObject(i);
			JSONObject timeJson = jo.getJSONObject("time");
			long time = timeJson.getLongValue("time");
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String timeStr = sd.format(time);
			jo.put("timeStr", timeStr);
		}
		return jobj;
	}
}
