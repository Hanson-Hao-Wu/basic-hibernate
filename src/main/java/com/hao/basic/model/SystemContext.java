package com.hao.basic.model;

/**
 * ThreadLocal
 * @author Hao
 *
 */
public class SystemContext {
	private static ThreadLocal<Integer> pageSize;
	private static ThreadLocal<Integer> pageOffset;
	private static ThreadLocal<String> sort;
	private static ThreadLocal<String> order;
	
	public static Integer getPageSize() {
		return pageSize.get();
	}
	public static void setPageSize(Integer _pageSize) {
		pageSize.set(_pageSize);
	}
	public static void removePageSize() {
		pageSize.remove();
	}
	public static Integer getPageOffset() {
		return pageOffset.get();
	}
	public static void setPageOffset(Integer _pageOffset) {
		pageOffset.set(_pageOffset);
	}
	public static void removePageOffset() {
		pageOffset.remove();
	}
	public static String getSort() {
		return sort.get();
	}
	public static void setSort(String _sort) {
		SystemContext.sort.set(_sort);
	}
	public static void removeSort() {
		sort.remove();
	}
	public static String getOrder() {
		return order.get();
	}
	public static void setOrder(String _order) {
		SystemContext.order.set(_order);
	}
	public static void removeOrder() {
		order.remove();
	}
	
	
}
