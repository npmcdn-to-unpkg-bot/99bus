package org.hopen.core;

import java.util.HashMap;
import java.util.Map;

/**
 * **********************************************************************
 * <p>类的详细说明</p>
 *
 * @author  jerry
 * @version 1.00 2014-10-9 jerry
 * <p>      9.99 9999/99/99 修改者姓名 修改内容说明</p>
 * <p>      9.99 9999/99/99 修改者姓名 修改内容说明</p>
 ***********************************************************************
 */
public class SystemVariables{
	private static Map<Integer, String> sysStatusMap = new HashMap<Integer, String>();
	static{
		sysStatusMap.put(0, "NORMAL");
		sysStatusMap.put(1, "WAITING INITIALIZATION");
		sysStatusMap.put(2, "INITIALIZING");
	}
	private  static SystemVariables sysVar;
	private  int sysStatus = 1;
	private  Map<String, Object> systemParams;
	public int getSysStatus() {
		return sysStatus;
	}

	public void setSysStatus(int sysStatus) {
		this.sysStatus = sysStatus;
	}
	private  Map<String, Map<String, Object>> emnuMap;
	private  Boolean sysn = true;
	public Map<String, Map<String, Object>> getEmnuMap() {
		return emnuMap;
	}

	public void setEmnuMap(Map<String, Map<String, Object>> emnuMap) {
		this.emnuMap = emnuMap;
	}
	public static String getSysStatusLabel(){
		int status = SystemVariables.getInstance().getSysStatus();
		return SystemVariables.sysStatusMap.get(status);
	}
	public static SystemVariables getInstance(){
		if (sysVar == null) {
			sysVar = new SystemVariables();
		}
		if (sysVar.getSysn()) {
			sysVar.setEmnuMap(new HashMap<String, Map<String,Object>>());
			sysVar.setSystemParams(new HashMap<String, Object>());
		}
		return sysVar;
	}
	
	public Boolean getSysn() {
		return sysn;
	}

	public void setSysn(Boolean sysn) {
		this.sysn = sysn;
	}
	public  Map<String, Object> getSystemParams() {
		return systemParams;
	}

	public  void setSystemParams(Map<String, Object> systemParams) {
		this.systemParams = systemParams;
	}
	public  void putKeyValue(String key,Object object){
		systemParams.put(key, object);
	}
	public  Object getValue(String key){
		Object val = systemParams.get(key);
		return val;
	}
	public  void putEnumKeyValue(String key,String key2,String value){
		Object obj = emnuMap.get(key);
		if (obj == null ) {
			Map<String, Object> iMap = new HashMap<String, Object>();
			emnuMap.put(key, iMap);
		}
		Map<String, Object> objIn = (Map<String, Object>)emnuMap.get(key);
		objIn.put(key2,value);
	}
	public String getEnumKeyValue(String key,String key2){
		Object obj = emnuMap.get(key);
		if (obj == null ) {
			return "";
		}
		@SuppressWarnings("unchecked")
		Map<String, Object> rMap = (Map<String, Object>)obj;
		Object rVal =rMap.get(key2);
		return (rVal == null ? "":rVal.toString());
	}
}
