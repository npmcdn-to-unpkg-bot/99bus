package org.hopen.jjbus.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import org.hopen.jjbus.security.Encrypt;


public class UrlUtils {

	public static String buildUrl(String urlBase, String key, Map<String, String> parameters) throws UnsupportedEncodingException {
		if ((parameters.containsKey("_s")) || (parameters.containsKey("_t"))) {
			throw new RuntimeException("在使用 com.shove.gateways.GeneralRestGateway.buildUrl 方法构建通用 REST 接口 Url 时，不能使用 _s, _t 此保留字作为参数名。");
		}
		if (StringUtils.isBlank(key)) {
			throw new RuntimeException("在使用 com.shove.gateways.GeneralRestGateway.buildUrl 方法构建通用 REST 接口 Url 时，必须提供一个用于摘要签名用的 key (俗称 MD5 加盐)。");
		}
		parameters.put("_t", Convert.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss", "1970-01-01 00:00:00"));

		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<String> parameterNames = new ArrayList(parameters.keySet());
		Collections.sort(parameterNames);
		if ((!urlBase.endsWith("?")) && (!urlBase.endsWith("&"))) {
			urlBase = urlBase + (urlBase.indexOf("?") == -1 ? "?" : "&");
		}
		String signData = "";
		for (int i = 0; i < parameters.size(); i++) {
			String _key = (String) parameterNames.get(i);
			String _value = (String) parameters.get(_key);

			signData = signData + _key + "=" + _value;
			urlBase = urlBase + _key + "=" + URLEncoder.encode(_value, "utf-8");
			if (i < parameters.size() - 1) {
				signData = signData + "&";
				urlBase = urlBase + "&";
			}
		}
		urlBase = urlBase + "&_s=" + Encrypt.MD5(new StringBuilder(String.valueOf(signData)).append(key).toString(), "utf-8");
		return urlBase;
	}

}
