package org.sykj.bbs.pojo;

public class BclassInfo {
	
	private Integer userId;//版主id
	private String userName; // 用户名称/版主名称
	private Integer classId;//栏目id
	private String className;//栏目名称
	private String classMsg;//栏目介绍
	private String classPicture;//图片地址
	private Integer authId; //权限
	private String authMsg;//权限描述
	
	
	
	/**
	 * 
	 */
	public BclassInfo() {
		super();
	}

	



	public BclassInfo(Integer userId, String userName, Integer classId, String className, String classMsg,
			String classPicture, Integer authId, String authMsg) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.classId = classId;
		this.className = className;
		this.classMsg = classMsg;
		this.classPicture = classPicture;
		this.authId = authId;
		this.authMsg = authMsg;
	}







	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassMsg() {
		return classMsg;
	}
	public void setClassMsg(String classMsg) {
		this.classMsg = classMsg;
	}
	public String getClassPicture() {
		return classPicture;
	}
	public void setClassPicture(String classPicture) {
		this.classPicture = classPicture;
	}

	public Integer getAuthId() {
		return authId;
	}

	public void setAuthId(Integer authId) {
		this.authId = authId;
	}

	public String getAuthMsg() {
		return authMsg;
	}


	public void setAuthMsg(String authMsg) {
		this.authMsg = authMsg;
	}


	@Override
	public String toString() {
		return "BclassInfo [userId=" + userId + ", userName=" + userName + ", classId=" + classId + ", className="
				+ className + ", classMsg=" + classMsg + ", classPicture=" + classPicture + ", authId=" + authId
				+ ", authMsg=" + authMsg + "]";
	}





	
	
	
	
	
	
	
	

}
