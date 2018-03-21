/**
 * 
 */
package org.sykj.bbs.pojo;

import java.util.LinkedList;
import java.util.Vector;

/**
 * @author Administrator
 * @param <T>
 *
 */
public class PageBean<T> {
	private int pageSize;//每页显示的总条数
	private int pageTotal;//总页数
	private int p;//当前P页
	private int count;//记录总条数
	private LinkedList<T> linkedList=new LinkedList<T>();
	public PageBean() {
		
	}

	public PageBean(int pageSize, int count) {
		this.pageSize = pageSize;
		this.count = count;
		this.pageTotal = (int)(Math.ceil(count*1.0/pageSize));
	}
	public int getPageSize() {
		return pageSize;
	}
	
	/**
	 * @param pagetotal 要设置的 pagetotal
	 */
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public int getPageTotal() {
		return pageTotal;
	}
	
	public int getP() {
		return p;
	}
	
	public int getCount() {
		return count;
	}
	
	public LinkedList<T> getLinkedList() {
		return linkedList;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public void setP(int p) {
		if (p<=1) {p=1;}
		if(p>=pageTotal){p=pageTotal;}
		this.p = p;
		
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public void addData(T g) {
		this.linkedList.add(g);
	}

	@Override
	public String toString() {
		return "PageBean [pageSize=" + pageSize + ", pageTotal=" + pageTotal + ", p=" + p + ", count=" + count
				+ ", linkedList=" + linkedList + "]";
	}
	
	
	

}
