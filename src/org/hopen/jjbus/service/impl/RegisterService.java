/**
 * @author jerry
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.jjbus.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.hopen.jjbus.service.IRegisterService;
import org.hopen.jjbus.utils.HttpForJsonUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jerry
 *
 */
@Service
public class RegisterService implements IRegisterService {

	@Override
	public JSONObject hisSendSMS(String mobile) {
		Map<String, String> map =  new HashMap<String, String>();
		map.put("cellPhone", "+86"+mobile);
		map.put("OPT", "4");
		//return HttpForJsonUtils.post(map);
		return JSONObject.parseObject("{error:-1,msg:'发送成功'}");
	}

	@Override
	public JSONObject hisValidateSMS(Map<String, String> info) {
		info.put("OPT", "5");
		//return HttpForJsonUtils.post(info);
		return JSONObject.parseObject("{error:-1,msg:'验证成功'}");
	}

	@Override
	public JSONObject queryRegAgreement() {
		Map<String, String> map =  new HashMap<String, String>();
		map.put("OPT", "8");
		return HttpForJsonUtils.post(map);
	}

	@Override
	public JSONObject storeRegister(Map<String, String> info) {
		info.put("OPT", "2");
		return HttpForJsonUtils.post(info);
	}

	@Override
	public JSONObject storeBind(Map<String, String> info) {
		info.put("OPT", "165");
		return HttpForJsonUtils.post(info);
	}
}
