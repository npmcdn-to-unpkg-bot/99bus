/**
 * @author jerry
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.jjbus.bean;

import java.util.List;

/**
 * @author jerry
 *
 */
public class OptResponse<T> {
	private String totalNum = null;
	private String msg = null;
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * @return the totalNum
	 */
	public String getTotalNum() {
		return totalNum;
	}
	/**
	 * @param totalNum the totalNum to set
	 */
	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	/**
	 * @return the list
	 */
	public List<T> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<T> list) {
		this.list = list;
	}
	private String error = null;
	private List<T> list;
}
