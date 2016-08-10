/**
 * @author jerry
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.jjbus.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jerry
 *
 */
public interface IRegisterService {
	public JSONObject  hisSendSMS(String mobile);
	public JSONObject  hisValidateSMS(Map<String, String> info);
	public JSONObject  queryRegAgreement();
	public JSONObject  storeRegister(Map<String, String> info);
	public JSONObject  storeBind(Map<String, String> info);
}
