package com.hao.basic.model;

import java.util.List;

/**
 * 
 * @author Hao
 *
 * @param <T>
 */
public class Pager<T> {
	/**
	 * the size of the page
	 */
	private int size;
	/**
	 * start page
	 */
	private int offset;
	/**
	 * total record
	 */
	private int total;
	/**
	 * total page record
	 */
	private List<T> datas;
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
}
