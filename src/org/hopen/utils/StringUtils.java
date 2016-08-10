package org.hopen.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hopen.framework.exception.JYRunException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class StringUtils {
	public static String getXmlStringValue(String text, String key) {
		int index = text.indexOf(key) + key.length();
		int end = text.indexOf(key, index);
		return text.substring(index + 1, end - 2);
	}

	public static Object[] pushArray(Object[] arrays, Object obj) {
		if (arrays != null) {
			arrays = Arrays.copyOf(arrays, arrays.length + 1);
			arrays[arrays.length - 1] = obj;
		} else {
			arrays = new Object[1];
			arrays[0] = obj;
		}
		return arrays;
	}

	public static Object[] pushArray(Object[] arrays, Object[] obj) {
		if (arrays != null) {
			int len = arrays.length;
			arrays = Arrays.copyOf(arrays, len + obj.length);
			for (int i = 0; i < obj.length; i++) {
				arrays[len + i] = obj[i];
			}
		} else {
			arrays = obj;
		}
		return arrays;
	}

	public static String getExistsValue(Map<String, Object> params, String key) {
		Object value = params.get(key);
		if (value == null) {
			throw new JYRunException("必输项：" + key);
		} else {
			return value.toString();
		}
	}

	public static String getValue(Map<String, ?> params, String key) {
		Object value = params.get(key);
		if (value == null) {
			return "";
		} else {
			return value.toString();
		}
	}
	/**
	 * 
	 * @param text
	 * @param checkType
	 *            0：只可以为数字字母组合
	 * @return
	 */
	public static Boolean checkString(String text, int minLen, int maxLen,
			int checkType) {
		// var p = /(?!^\d+$)(?!^[a-zA-Z]+$)[0-9a-zA-Z]{4,23}/
		String notOnlyletter = "(?!^\\d+$)"; // 排除全数字
		String noOnlyNum = "(?!^[a-zA-Z]+$)";// 排除全字母
		String letterOrNum = "[0-9a-zA-Z]";// 字符或字母4-23位
		String len = "{" + minLen + "," + maxLen + "}";
		switch (checkType) {
		case 0:
			String regx = notOnlyletter + noOnlyNum + letterOrNum + len;
			Pattern pattern = Pattern.compile(regx);
			Matcher matcher = pattern.matcher("");
			return matcher.matches();
		default:
			break;
		}
		return false;

	}

	public static String jsoupTest(String str, String findKey, String findValue) {
		Document document = Jsoup.parse(str);
		Elements e = document.getElementsByAttributeValue(findKey, findValue);
		return e.attr("value");
	}

	/**
	 * 金额格式化
	 * 
	 * @param s
	 *            金额
	 * @param len
	 *            小数位数
	 * @return 格式后的金额
	 */
	public static String amountFormat(String s, int len) {
		if (s == null || s.length() < 1) {
			return "";
		}
		NumberFormat formater = null;
		double num = Double.parseDouble(s);
		if (len == 0) {
			formater = new DecimalFormat("#0.00");

		} else {
			StringBuffer buff = new StringBuffer();
			buff.append("###,##0.");
			for (int i = 0; i < len; i++) {
				buff.append("0");
			}
			formater = new DecimalFormat(buff.toString());
		}
		return formater.format(num);
	}
	public static void   main(String [] args){
		System.out.println(amountFormat(".00", 2));
	}
}
