package org.hopen.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {
	public static String getPropertie(String path,String key){
		Properties pro = new Properties();
		File  file = new File(path);
		FileReader fr = null;
		String val = null;
		try {
			fr = new FileReader(file);
			pro.load(fr);
			val = pro.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(fr!=null)
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return val;
	}
	public static void storePropertie(String path,String key,String value){
		Properties pro = new Properties();
		File  file = new File(path);
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(file);
			pro.load(fr);
			pro.put(key, value);
			fw = new FileWriter(file);
			pro.store(fw, "大海无量 commit");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(fr!=null)fr.close();
				if(fw!=null)fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
