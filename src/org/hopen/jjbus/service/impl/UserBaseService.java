/**
 * @author jerry
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.jjbus.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.hopen.jjbus.service.IUserBaseService;
import org.hopen.jjbus.utils.HttpForJsonUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jerry
 *
 */
@Service
public class UserBaseService implements IUserBaseService {

	@Override
	public JSONObject queryUserInfo(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("OPT", "3");
		params.put("id", id);
		return HttpForJsonUtils.post(params);
	}
	@Override
	public JSONObject queryHoldingList(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("OPT", "42");
		params.put("id", id);
		return HttpForJsonUtils.post(params);
	}
	public JSONObject queryHistoryHoldList(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("OPT", "40");
		params.put("id", id);
		return HttpForJsonUtils.post(params);
	}
}
