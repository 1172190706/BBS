package org.sykj.bbs.pojo;

import java.util.ArrayList;
import java.util.List;

public class ThemePage {

	 private Integer total;
	 private Integer start;
	 private Integer end;
     private List<Theme> rows = new ArrayList<>();
     public ThemePage() {
    	 start=0;
    	 end=10;
	}
	@Override
	public String toString() {
		return "ThemePage [total=" + total + ", start=" + start + ", end=" + end + ", rows=" + rows + "]";
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
	public List<Theme> getRows() {
		return rows;
	}
	public void setRows(List<Theme> rows) {
		this.rows = rows;
	}
 
	
     
}
