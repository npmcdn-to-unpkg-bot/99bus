/**
 * @author jerry
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.jjbus.service.impl;

import java.util.Map;

import org.hopen.jjbus.service.IUserService;
import org.hopen.jjbus.utils.HttpForJsonUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jerry
 *
 */
@Service
public class UserService implements IUserService {

	@Override
	public JSONObject hisUpdateLoginPwd(Map<String, String> map) {
		map.put("OPT", "105");
		return HttpForJsonUtils.post(map);
	}

	@Override
	public JSONObject hisLogin(Map<String, String> info) {
		info.put("OPT", "1");
		info.put("deviceType", "1");
		return HttpForJsonUtils.post(info);
	}

	@Override
	public JSONObject hisSetTradPwd(Map<String, String> info) {
		info.put("OPT", "103");
		return HttpForJsonUtils.post(info);
	}
	@Override
	public JSONObject hisUpdateTradPwd(Map<String, String> info) {
		info.put("OPT", "104");
		return HttpForJsonUtils.post(info);
	}
	@Override
	public JSONObject hisReSetLoginPwd(Map<String, String> info) {
		info.put("OPT", "6");
		return HttpForJsonUtils.post(info);
	}
}
