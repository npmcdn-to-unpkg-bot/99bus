package org.hopen.jjbus.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.hopen.utils.ConfigUtil;


import com.alibaba.fastjson.JSONObject;

public class SignUtil {
	private static String corpId = ConfigUtil.get("corpId");

	private static String appSecret = ConfigUtil.get("appSecret");
	
	private final static Logger log = Logger.getLogger(SignUtil.class);

	public static String getOpenId(String code) throws ClientProtocolException, IOException {
		String uristr = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
				+ corpId + "&secret=" + appSecret + "&code=" + code
				+ "&grant_type=authorization_code";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpGet httpGet = new HttpGet(uristr);
			CloseableHttpResponse response = httpclient.execute(httpGet);
			try {
				HttpEntity entity = response.getEntity();
				String str = "";
				if (entity != null) {
					InputStream instreams = entity.getContent();
					str = convertStreamToString(instreams);
					log.info("*********" + str);
					JSONObject jsonObj = JSONObject.parseObject(str);
					return jsonObj.getString("openid");
				}
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
		return null;
	}

	public static String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

}