package org.sykj.bbs.pojo;
/**
 * 论坛模块表
 */

public class Themeclass {

	// Fields

	private Integer themeClassId;//栏目id
	private String themeClassName;//栏目名称

	// Constructors

	/** default constructor */
	public Themeclass() {
	}

	/** full constructor */
	public Themeclass(String themeClassName) {
		this.themeClassName = themeClassName;
	}

	

	public Themeclass(Integer themeClassId, String themeClassName) {
		super();
		this.themeClassId = themeClassId;
		this.themeClassName = themeClassName;
	}

	public Integer getThemeClassId() {
		return this.themeClassId;
	}

	public void setThemeClassId(Integer themeClassId) {
		this.themeClassId = themeClassId;
	}

	public String getThemeClassName() {
		return this.themeClassName;
	}

	public void setThemeClassName(String themeClassName) {
		this.themeClassName = themeClassName;
	}

	@Override
	public String toString() {
		return "Themeclass [themeClassId=" + themeClassId + ", themeClassName=" + themeClassName + "]";
	}
	

}