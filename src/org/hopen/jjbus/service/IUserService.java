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
public interface IUserService {
	public JSONObject  hisUpdateLoginPwd(Map<String, String> info);
	public JSONObject  hisLogin(Map<String, String> info);	
	public JSONObject  hisSetTradPwd(Map<String, String> info);
	public JSONObject  hisUpdateTradPwd(Map<String, String> info);
	public JSONObject  hisReSetLoginPwd(Map<String, String> info);
}
