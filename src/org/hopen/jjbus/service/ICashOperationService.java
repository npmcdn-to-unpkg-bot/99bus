/**
 * @author jerry
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.jjbus.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jerry
 *
 */
@Service
public interface ICashOperationService {
	public JSONObject stroeInverstBid(Map<String, String> map);
	public JSONObject queryCashInit(String id);
	public JSONObject queryPayInPage(Map<String, String> map);
	public JSONObject storeDrawRqst(Map<String, String> map);
	public JSONObject queryTradRecord(Map<String, String> map);
}
