package org.sykj.bbs.pojo;

/**
 * 版主表
 */

public class Moderator {

	// Fields

	private Integer mdId;//ID
	private Integer userId;//版主id
	private Integer classId;//栏目id（所管理的栏目）

	// Constructors

	/** default constructor */
	public Moderator() {
	}

	/** full constructor */
	public Moderator(Integer userId, Integer classId) {
		this.userId = userId;
		this.classId = classId;
	}

	// Property accessors

	public Integer getMdId() {
		return this.mdId;
	}

	public void setMdId(Integer mdId) {
		this.mdId = mdId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	@Override
	public String toString() {
		return "Moderator [mdId=" + mdId + ", userId=" + userId + ", classId=" + classId + "]";
	}

	
	
}