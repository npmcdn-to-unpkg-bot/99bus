package org.hopen.jjbus.utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;


public class HttpUtils {

	public static void closeStream(InputStreamReader isr, BufferedReader br, HttpURLConnection conn) {
		try {
			if (br != null) {
				br.close();
			}
			if (isr != null) {
				isr.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String request(String url, String param) {
		InputStreamReader isr = null;
		BufferedReader br = null;
		HttpURLConnection conn = null;
		String ret = "";
		try {
			URL u = new URL(url);
			conn = (HttpURLConnection) u.openConnection();
			conn.setRequestMethod("POST");
			//设置超时时间 单位毫秒  30秒
			//conn.setConnectTimeout(30000);
			//conn.setReadTimeout(30000);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			
			if(StringUtils.isNotBlank(param)){
				conn.getOutputStream().write(param.toString().getBytes("UTF-8"));
				conn.getOutputStream().flush();
				conn.getOutputStream().close();
			}
			
			//if (conn.getResponseCode() == 200) {//如果请求成功 
			isr = new InputStreamReader(conn.getInputStream());
			if (isr != null) {
				br = new BufferedReader(isr);
				String temp;
				while ((temp = br.readLine()) != null) {
					ret += temp;
				}
			}
			//}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStream(isr, br, conn);
		}
		return ret;
	}

	public static String request(String url, Map<String, Object> params) throws UnsupportedEncodingException {
		StringBuffer param = new StringBuffer();
		for (String key : params.keySet()) {
			if (params.get(key) != null) {//判断是否为空
				param.append(key).append("=").append(URLEncoder.encode(params.get(key).toString(), "UTF-8")).append("&");
			}
		}
		return request(url, param.toString());
	}

}
