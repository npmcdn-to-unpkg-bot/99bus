/**
 * @author jerry
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.jjbus.action;
import javax.servlet.http.HttpServletRequest;

import org.hopen.bean.SessionInfo;
import org.hopen.jjbus.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jerry
 *
 */
@Controller
@RequestMapping("/vldt")
public class ValidateController extends BaseController {
	@Autowired
	IRegisterService registerService;
	@RequestMapping("/sndSMS")
	@ResponseBody
	public String sendSMS(String mobile,HttpServletRequest request){
		if(mobile == null || mobile.equals("")){
			mobile = SessionInfo.getUserInfo(request).getMobile();
		}
		JSONObject rjob = registerService.hisSendSMS(mobile);
		return rjob.getString("msg");
	}
}
