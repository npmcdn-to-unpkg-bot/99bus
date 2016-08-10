package org.hopen.framework.bean;

import java.util.List;
import java.util.Map;

/**
 * **********************************************************************
 * <p>复杂关系bean</p>
 * @author  jerry
 * @version 1.00 2015-7-29 jerry
 ***********************************************************************
 */
public class RelationBean {
	Map<String, Object> attr;
	List<RelationBean>  subRealationList;
	public Map<String, Object> getAttr() {
		return attr;
	}
	public void setAttr(Map<String, Object> attr) {
		this.attr = attr;
	}
	public List<RelationBean> getSubRealationList() {
		return subRealationList;
	}
	public void setSubRealationList(List<RelationBean> subRealationList) {
		this.subRealationList = subRealationList;
	}
}
