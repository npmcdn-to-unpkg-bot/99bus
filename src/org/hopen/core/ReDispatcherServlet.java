/**
 * @author jerry
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.core;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hopen.utils.ConfigUtil;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author jerry
 *
 */
public class ReDispatcherServlet extends DispatcherServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String authKey = null;
	private  String isGetLimit = null;
	private  String isServerAuth = null;
	private  String webdomain=null;
	private  String resourceUrl = null;
	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		if(authKey == null){
			authKey = ConfigUtil.get("authKey");
		}
		if(isGetLimit == null){
			isGetLimit = ConfigUtil.get("getlimit");
		}
		if(isServerAuth == null){
			isServerAuth = ConfigUtil.get("serverAuth");
		}
		if(webdomain == null){
			webdomain = ConfigUtil.get("webdomain");
		}
		if(resourceUrl == null) {
			resourceUrl = ConfigUtil.get("resourceUrl");
		}
		super.init(config);
	}
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.DispatcherServlet#doService(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doService(HttpServletRequest arg0, HttpServletResponse arg1)
			throws Exception {
		// TODO Auto-generated method stub
		Object authKeyObj = arg0.getParameter("authKey");
		String authKeyIn = authKeyObj==null?"":authKeyObj.toString();
		Object authSession = arg0.getSession().getAttribute("authKey");
		if(isServerAuth.equals("1")){
			if(authSession!= null && authSession.equals(authKey)){
			} else	if(authKeyIn == null || !authKeyIn.equals(authKey)){
				arg0.getRequestDispatcher("/error/serverAUTH.jsp").forward(arg0, arg1);
				return;
			} else {
				arg0.getSession().setAttribute("authKey",authKey);
			}
		} 
		
		String method = arg0.getMethod();
		if(isGetLimit.equals("0")&&!method.equals("POST")){
			arg0.getRequestDispatcher("/error/406.jsp").forward(arg0, arg1);
			return;
		}
		arg0.setAttribute("webdomain", webdomain);
		arg0.setAttribute("resourceUrl", resourceUrl);
		super.doService(arg0, arg1);
	}
}
