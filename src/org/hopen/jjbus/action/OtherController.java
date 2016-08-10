/**
 * @author jerry
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.jjbus.action;

import javax.servlet.http.HttpServletRequest;

import org.hopen.jjbus.service.IOtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jerry
 *
 */
@Controller
@RequestMapping("/thr")
public class OtherController extends BaseController {
	@Autowired
	IOtherService otherService;
	
	@RequestMapping("/toActvty")
	public String toActivity(HttpServletRequest request){
		JSONObject jobj = otherService.queryHelpActivityList(null, null);
		request.setAttribute("response", jobj);
		return "/actvty";
	}
	@RequestMapping("/toQuestion")
	public String toQuestion(HttpServletRequest request){
		JSONObject jobj = otherService.queryHelpQuestionList(null, null);
		request.setAttribute("response", jobj);
		return "/other/helplist";
	}
	@RequestMapping("/to406")
	public String to406(){
		
		return "/error/406";
	}
	@RequestMapping("/deving")
	public String deving(){
		return "/error/deving";
	}
}
