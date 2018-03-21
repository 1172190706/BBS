package org.sykj.bbs.pojo;

import java.util.ArrayList;
import java.util.List;

public class BclassPage {

	 private Integer total;
	 private Integer start;
	 private Integer end;
     private List<Bclass> rows = new ArrayList<>();
     public BclassPage() {
		// TODO Auto-generated constructor stub
	}
	public BclassPage(Integer total, Integer start, Integer end, List<Bclass> rows) {
		super();
		this.total = total;
		this.start = start;
		this.end = end;
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "BclassPage [total=" + total + ", start=" + start + ", end=" + end + ", rows=" + rows + "]";
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getEnd() {
		return end;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}
	public List<Bclass> getRows() {
		return rows;
	}
	public void setRows(List<Bclass> rows) {
		this.rows = rows;
	}
 
     
}
