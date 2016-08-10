/**
 * @author Administrator
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.jjbus.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.hopen.jjbus.service.IOtherService;
import org.hopen.jjbus.utils.HttpForJsonUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Administrator
 *
 */
@Service
public class OtherService implements IOtherService {
	
	@Override
	public JSONObject query166(String userid) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("OPT", "166");
		params.put("userid", userid);
		return HttpForJsonUtils.post(params);
	}

	@Override
	public JSONObject queryBanner() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("OPT", "122");
		return HttpForJsonUtils.post(params);
	}

	@Override
	public JSONObject queryHelpTypeList() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("OPT", "74");
		return HttpForJsonUtils.post(params);
	}

	@Override
	public JSONObject queryHelpQuestionList(String id,String page) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("OPT", "75");
		if(id==null||id.equals("")){
			params.put("id", "13");
		} else{
			params.put("id", id);
		}
		if(page == null ||page.equals("")){
			params.put("currPage", "1");
		} else {
			params.put("currPage", page);
		}
		return HttpForJsonUtils.post(params);
	}
	
	
	@Override
	public JSONObject queryOperationShowList(String id,String page) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("OPT", "75");
		if(id==null||id.equals("")){
			params.put("id", "14");
		} else{
			params.put("id", id);
		}
		if(page == null ||page.equals("")){
			params.put("currPage", "1");
		} else {
			params.put("currPage", page);
		}
		return HttpForJsonUtils.post(params);
	}
	@Override
	public JSONObject queryHelpActivityList(String id,String page) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("OPT", "75");
		if(id==null||id.equals("")){
			params.put("id", "15");
		} else{
			params.put("id", id);
		}
		if(page == null ||page.equals("")){
			params.put("currPage", "1");
		} else {
			params.put("currPage", page);
		}
		JSONObject jobj = HttpForJsonUtils.post(params);
		JSONArray jarry = jobj.getJSONArray("list");
		int cnt = 0;
		for(int i = 0;i< jarry.size();i++){
			JSONObject jTmp = jarry.getJSONObject(i);
			String content = jTmp.getString("content");
			Document document = Jsoup.parse(content);
			Elements e = document.getElementsByTag("img");
			if(e!= null&& e.size()>0){
				Element eTmp = e.get(0);
				String value = eTmp.attr("src");
				jTmp.put("imgUrl",value);
			}
			boolean userd = jTmp.getBoolean("is_use");
			if(userd){
				cnt = cnt + 1;
			}
		}
		if(cnt > 0){
			jobj.put("hasActvty", true);
		} else {
			jobj.put("hasActvty", false);
		}
		return jobj; 
	}
}
