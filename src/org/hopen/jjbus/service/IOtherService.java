/**
 * @author Administrator
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.jjbus.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Administrator
 *
 */
public interface IOtherService {
		public JSONObject query166(String userid);
		public JSONObject queryBanner();
		public JSONObject queryHelpTypeList();
		
		public JSONObject queryHelpQuestionList(String id,String page);
		public JSONObject queryHelpActivityList(String id,String page);
		public JSONObject queryOperationShowList(String id,String page);
}
