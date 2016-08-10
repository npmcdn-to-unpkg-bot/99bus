/**
 * @author jerry
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.bean;

import org.apache.http.NameValuePair;

/**
 * @author jerry
 *
 */
public class ReNameValuePair implements NameValuePair {

	String name;
	String value;
	/* (non-Javadoc)
	 * @see org.apache.http.NameValuePair#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	/* (non-Javadoc)
	 * @see org.apache.http.NameValuePair#getValue()
	 */
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}


}
