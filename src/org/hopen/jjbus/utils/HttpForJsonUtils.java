/**
 * @author jerry
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.jjbus.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.hopen.utils.ConfigUtil;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jerry
 * 
 */
public class HttpForJsonUtils {
	private final static String domain = ConfigUtil.get("domains");
	private final static String signKey = ConfigUtil.get("signKey");
	private static Logger logger = Logger.getLogger(HttpForJsonUtils.class);

	public static JSONObject post(Map<String, String> params) {
		JSONObject jsobj = null;
		try {
			jsobj = post(null, params, "UTF-8");
			if(jsobj.isEmpty()){
				jsobj = JSONObject.parseObject("{'error':-1,'msg':'对方处理失败'}"); 
			}
		} catch (Throwable e) {
			e.printStackTrace();
			jsobj = JSONObject.parseObject("{'error':-1,'msg':'系统错误！请稍后重试！'}");
		}
		return jsobj;
	}

	public static JSONObject post(String url, Map<String, String> params) {
		JSONObject jsobj = null;
		try {
			return post(url, params, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			jsobj = JSONObject.parseObject("{error:-1,msg:'系统错误！请稍后重试！'}");
		}
		return jsobj;
	}
	@SuppressWarnings("rawtypes")
	public static JSONObject postInParams(String url, Map<String, String> params,
			String charSet) throws Exception {
		if(url ==null) url = "";
		long start = System.currentTimeMillis();
		 List<NameValuePair> list = new ArrayList<NameValuePair>();  
         
		Iterator iterator = params.entrySet().iterator();  
         HttpPost httpPost = new HttpPost(url);
         while(iterator.hasNext()){  
             @SuppressWarnings("unchecked")
			 Entry<String,String> elem = (Entry<String, String>) iterator.next();  
             list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));  
         }  
         if(list.size() > 0){  
             UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8");  
             httpPost.setEntity(entity);  
         }  
        
		// 这边使用适用正常的表单提交
		SSLContext sc = SSLContext.getInstance("TLS");
		// 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
		X509TrustManager trustManager = new X509TrustManager() {
			@Override
			public void checkClientTrusted(
					java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
					String paramString) throws CertificateException {
			}

			@Override
			public void checkServerTrusted(
					java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
					String paramString) throws CertificateException {
			}

			@Override
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		sc.init(null, new TrustManager[] { trustManager }, null);
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse result = null;
		String resData = null;
		
		RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(3000)
					.setConnectTimeout(3000).build();//设置请求和传输超时时间
		
		httpPost.setConfig(requestConfig);
		try {
			httpclient = HttpClients.custom().setSSLContext(sc).build();
			result = httpclient.execute(httpPost);
			// 请求结束，返回结果
			resData = EntityUtils.toString(result.getEntity());
			logger.info("ret:" +resData);
			long end = System.currentTimeMillis();
			double tm = (end - start) / 1000;
			logger.info("http [opt=" + params.get("OPT") + "]request has :"
					+ tm + "s");
		} finally {
			result.close();
			httpclient.close();
		}
		return JSONObject.parseObject(resData);
	}
	/**
	 * 
	 * @param url
	 *            路径
	 * @param params
	 *            参数
	 * @param charSet
	 *            字符集
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	private static JSONObject post(String url, Map<String, String> params,
			String charSet) throws Exception {
		if(url ==null) url = "";
		long start = System.currentTimeMillis();
		params.put("body", "");
		String data = UrlUtils.buildUrl(domain + url, signKey,params);
		HttpPost httpPost = new HttpPost(data);
		// 这边使用适用正常的表单提交
		SSLContext sc = SSLContext.getInstance("TLS");
		// 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
		X509TrustManager trustManager = new X509TrustManager() {
			@Override
			public void checkClientTrusted(
					java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
					String paramString) throws CertificateException {
			}

			@Override
			public void checkServerTrusted(
					java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
					String paramString) throws CertificateException {
			}

			@Override
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		sc.init(null, new TrustManager[] { trustManager }, null);
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse result = null;
		String resData = null;
		
//		RequestConfig requestConfig = RequestConfig.custom()
//					.setSocketTimeout(2000)
//					.setConnectTimeout(2000).build();//设置请求和传输超时时间
//		
//		httpPost.setConfig(requestConfig);
		try {
			httpclient = HttpClients.custom().setSSLContext(sc).build();
			result = httpclient.execute(httpPost);
			// 请求结束，返回结果
			resData = EntityUtils.toString(result.getEntity());
			logger.info("ret:" +resData);
			long end = System.currentTimeMillis();
			double tm = (end - start) / 1000;
			logger.info("http [opt=" + params.get("OPT") + "]request has :"
					+ tm + "s");
		} finally {
			result.close();
			httpclient.close();
		}
		return JSONObject.parseObject(resData);
	}
}
