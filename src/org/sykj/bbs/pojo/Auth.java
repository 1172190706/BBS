package org.sykj.bbs.pojo;

/**
 * 权限组
 */

public class Auth {

	// Fields

	private Integer authId;//权限id
	private Integer authRange;//权限范围 int （1超管，2副超管，3总版主，4版主，5普通用户）
	private String authMsg;//权限描述

	// Constructors

	/** default constructor */
	public Auth() {
	}
	
	
	public Auth(String authMsg) {
		super();
		this.authMsg = authMsg;
	}



	/** full constructor */
	public Auth(Integer authRange, String authMsg) {
		this.authRange = authRange;
		this.authMsg = authMsg;
	}

	// Property accessors

	public Integer getAuthId() {
		return this.authId;
	}

	public void setAuthId(Integer authId) {
		this.authId = authId;
	}

	public Integer getAuthRange() {
		return this.authRange;
	}

	public void setAuthRange(Integer authRange) {
		this.authRange = authRange;
	}

	public String getAuthMsg() {
		return this.authMsg;
	}

	public void setAuthMsg(String authMsg) {
		this.authMsg = authMsg;
	}


	@Override
	public String toString() {
		return "Auth [authId=" + authId + ", authRange=" + authRange + ", authMsg=" + authMsg + "]";
	}

}