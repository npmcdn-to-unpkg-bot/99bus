package org.hopen.jjbus.security;


import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
 * @author ZhengJinLing
 *
 */
public class Encrypt {
	public static String MD5(String input) {
		return MD5(input, Charset.defaultCharset());
	}

	public static String MD5(String input, String charset) {
		return MD5(input, Charset.forName(charset));
	}

	public static String MD5(String input, Charset charset) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(input.getBytes(charset));

		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

		byte[] tmp = md.digest();
		char[] str = new char[32];

		int k = 0;
		for (int i = 0; i < 16; i++) {
			byte byte0 = tmp[i];
			str[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];
			str[(k++)] = hexDigits[(byte0 & 0xF)];
		}
		String result = new String(str);

		return result;
	}

	public static String encryptSES(String input, String key) throws Exception {
		Ses ses = new Ses(key);

		byte[] byte_input = input.getBytes(Charset.forName("GB2312"));
		int len = ses.getEncryptResultLength(byte_input);

		byte[] output = new byte[len];
		ses.encrypt(byte_input, output);

		return new BASE64Encoder().encode(output);
	}

	public static String decryptSES(String input, String key) throws Exception {
		Ses ses = new Ses(key);

		byte[] byte_input = new BASE64Decoder().decodeBuffer(input);
		byte[] temp_output = new byte[input.length()];

		int output_len = ses.decrypt(byte_input, byte_input.length, temp_output);

		byte[] ouput = new byte[output_len];
		System.arraycopy(temp_output, 0, ouput, 0, output_len);

		return new String(ouput, Charset.forName("GB2312"));
	}

	public static String encrypt3DES(String input, String key) {
		try {
			return Byte.byte2hex(Des.encrypt(input.getBytes("UTF-8"), key.getBytes()));
		} catch (Exception e) {
		}
		return "";
	}

	public static String decrypt3DES(String input, String key) {
		try {
			return new String(Des.decrypt(Byte.hex2byte(input.getBytes()), key.getBytes()), "GB2312");
		} catch (Exception e) {
		}
		return "";
	}
}
