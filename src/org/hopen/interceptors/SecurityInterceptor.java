package org.hopen.interceptors;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.hopen.bean.SessionInfo;
import org.hopen.cfg.spring.Config;
import org.hopen.utils.ConfigUtil;
//import org.hopen.wx.service.ISysConfigService;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 权限拦截
 * 
 * 
 */
public class SecurityInterceptor implements HandlerInterceptor {

	private static final Logger logger = Logger
			.getLogger(SecurityInterceptor.class);

	private List<String> excludeUrls;
	private List<String> devCludeUrls;
	
	/**
	 * @return the devCludeUrls
	 */
	public List<String> getDevCludeUrls() {
		return devCludeUrls;
	}

	/**
	 * @param devCludeUrls the devCludeUrls to set
	 */
	public void setDevCludeUrls(List<String> devCludeUrls) {
		this.devCludeUrls = devCludeUrls;
	}

	private List<String> excludeClientLimitUrls;
	

	public List<String> getExcludeClientLimitUrls() {
		return excludeClientLimitUrls;
	}

	public void setExcludeClientLimitUrls(List<String> excludeClientLimitUrls) {
		this.excludeClientLimitUrls = excludeClientLimitUrls;
	}

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	/**
	 * 完成页面的render后调
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception)
			throws Exception {

	}

	/**
	 * 在调用controller具体方法后拦
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object object,
			ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 在调用controller具体方法前拦
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object object) throws Exception {
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		
		SessionInfo sessionInfo = (SessionInfo) request.getSession()
				.getAttribute(ConfigUtil.getSessionInfoName());
		if (sessionInfo == null) {
			sessionInfo = new SessionInfo();
			request.getSession().setAttribute(ConfigUtil.getSessionInfoName(),
					sessionInfo);
		}
		String rAddr =request.getRemoteAddr();
		String rHost =request.getRemoteHost();
		int rPort =request.getRemotePort();
		String rUser =request.getRemoteUser();
		logger.info("remote:" + rAddr + "|" + rHost +"|"+ rPort+"|"+rUser);
		if (Config.msgMap == null || Config.msgMap.size() == 0) {
			// sysConfigService.reloadMsg();
		}
		/**开发排除**/
		if (devCludeUrls.contains(url)) {
			request.getRequestDispatcher("/thr/deving").forward(request,response);
			return false;
		}
		
		/** 权限列表排除 **/
		if (excludeUrls.contains(url)) {
			return true;
		}

		if (sessionInfo != null && sessionInfo.isAuthorization()) {
			return true;
		} else {
			if (url != null && !url.equals("")&&!url.equals("/usr/toLgn")) {
				sessionInfo.setSaveAction(url);
			}
			request.getRequestDispatcher("/usr/toLgn").forward(request,response);
			return false;
		}
	}
}
