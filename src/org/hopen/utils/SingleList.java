package org.hopen.utils;

import java.util.ArrayList;

public class SingleList<E> extends ArrayList<E> {
	
	/**
	 * @Fields serialVersionUID:TODO(用以句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	public boolean add(E e) {
		boolean addFlag = true;
		for (E obj: this) {
			if (obj.equals(e)) {
				addFlag = false;
				break;
			}
		}
		if (addFlag) {
			super.add(e);
		}else{
		}
		return true;
	}
	public void reSet(){
		
	}
}
