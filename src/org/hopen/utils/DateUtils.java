package org.hopen.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * 
 * @author jerry
 *
 */
public class DateUtils {
	/**
	 * 
	 * @param formatter yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getNowDate(String formatter){
		Calendar cald = Calendar.getInstance();
		SimpleDateFormat sd = new SimpleDateFormat(formatter);
		return sd.format(cald.getTime()); 
	}
	public static String formate(String dt,String fromFormatter,String toFormatter){
		Calendar cald = Calendar.getInstance();
		SimpleDateFormat fromsd = new SimpleDateFormat(fromFormatter);
		SimpleDateFormat tosd = new SimpleDateFormat(toFormatter);
		try {
			cald.setTime(fromsd.parse(dt));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return tosd.format(cald.getTime()); 
	}
	public static String getNowDate(String formatter,int field,int amount){
		Calendar cald = Calendar.getInstance();
		cald.add(field, amount);
		SimpleDateFormat sd = new SimpleDateFormat(formatter);
		return sd.format(cald.getTime()); 
	}
	public static String getDate(String date,String formatter,int field,int amount){
		Calendar cald = Calendar.getInstance();
		SimpleDateFormat sd = new SimpleDateFormat(formatter);
		try {
			cald.setTime(sd.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cald.add(field, amount);
		
		return sd.format(cald.getTime()); 
	}
	/**
	 * 
	 * @param formatter yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String decrease(String start,String end,String formatter){
		SimpleDateFormat sd = new SimpleDateFormat(formatter);
		try {
			long startdt = sd.parse(start).getTime();
			long endDt = sd.parse(end).getTime();
			long diff  = endDt-startdt;
			long days =    diff / (1000 * 60 * 60 * 24); 
			long hours =   (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60); 
			long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
			//long second =  (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60)-minutes*(1000*60))/(1000);
			return hours+"小时"+minutes+"分";//+second+"秒"; 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	public static long decreaseMins(String start,String end,String formatter){
		SimpleDateFormat sd = new SimpleDateFormat(formatter);
		try {
			long startdt = sd.parse(start).getTime();
			long endDt = sd.parse(end).getTime();
			long diff  = endDt-startdt;
			return diff;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static void main(String [] args){
		System.out.println(decrease("20150621101100","20150621300100","yyyymmddHHmmss"));
	}
}
