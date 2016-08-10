/**
 * @author jerry
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.jjbus.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jerry
 *
 */
public interface IUserBaseService {
	public JSONObject queryUserInfo(String id);
	public JSONObject queryHoldingList(String id);
	public JSONObject queryHistoryHoldList(String id);
}
