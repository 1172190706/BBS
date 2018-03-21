package org.sykj.bbs.pojo;

import java.util.List;

public class BclassTheme {
	

	private Integer classId;//栏目id
	private String className;//栏目名称
	private String classMsg;//栏目介绍
	private String moderatorName;//版主
	private Integer moderatorId;//版主Id
	private Integer userId;//版主id
	private String userName; // 用户名称/版主名称
	private Integer themeCount;//帖子总数
	private Integer signCount;//精品贴总数
	private Integer noReplyCount;//未回复总数
	private String classPicture;//图片地址
	
	private List<Theme> tl;
	
	
	
	
	


	public BclassTheme() {
		super();
	}
	
	
	public BclassTheme(Integer classId, String className, String classMsg, String moderatorName, Integer moderatorId,
			Integer userId, String userName, Integer themeCount, Integer signCount, Integer noReplyCount,
			String classPicture, List<Theme> tl) {
		super();
		this.classId = classId;
		this.className = className;
		this.classMsg = classMsg;
		this.moderatorName = moderatorName;
		this.moderatorId = moderatorId;
		this.userId = userId;
		this.userName = userName;
		this.themeCount = themeCount;
		this.signCount = signCount;
		this.noReplyCount = noReplyCount;
		this.classPicture = classPicture;
		this.tl = tl;
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
	public List<Theme> getTl() {
		return tl;
	}
	public void setTl(List<Theme> tl) {
		this.tl = tl;
	}
	public String getModeratorName() {
		return moderatorName;
	}
	public void setModeratorName(String moderatorName) {
		this.moderatorName = moderatorName;
	}

	public Integer getModeratorId() {
		return moderatorId;
	}
	public void setModeratorId(Integer moderatorId) {
		this.moderatorId = moderatorId;
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
	public String getClassPicture() {
		return classPicture;
	}
	public void setClassPicture(String classPicture) {
		this.classPicture = classPicture;
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
	public Integer getThemeCount() {
		return themeCount;
	}
	public void setThemeCount(Integer themeCount) {
		this.themeCount = themeCount;
	}
	public Integer getSignCount() {
		return signCount;
	}
	public void setSignCount(Integer signCount) {
		this.signCount = signCount;
	}
	public Integer getNoReplyCount() {
		return noReplyCount;
	}
	public void setNoReplyCount(Integer noReplyCount) {
		this.noReplyCount = noReplyCount;
	}
	@Override
	public String toString() {
		return "BclassTheme [classId=" + classId + ", className=" + className + ", classMsg=" + classMsg
				+ ", moderatorName=" + moderatorName + ", moderatorId=" + moderatorId + ", userId=" + userId
				+ ", userName=" + userName + ", themeCount=" + themeCount + ", signCount=" + signCount
				+ ", noReplyCount=" + noReplyCount + ", classPicture=" + classPicture + ", tl=" + tl + "]";
	}
	

	

	


}
