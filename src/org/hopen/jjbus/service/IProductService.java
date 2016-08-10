/**
 * @author jerry
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.jjbus.service;

import java.util.Map;
import org.hopen.jjbus.bean.OptResponse;
import com.alibaba.fastjson.JSONObject;

/**
 * @author jerry
 *
 */
public interface IProductService {
	public OptResponse<JSONObject> queryProductList(Map<String, String> params);
	public OptResponse<JSONObject> queryTransferBidList(Map<String, String> params);
	public JSONObject queryProductDetail(Map<String, String> params);
	public OptResponse<JSONObject> queryProductInverstRecord(Map<String, String> param);
}

