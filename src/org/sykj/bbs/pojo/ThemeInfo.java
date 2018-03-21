package org.sykj.bbs.pojo;

import java.util.List;

public class ThemeInfo {
	
	
	private Integer themeId;//主题ID
	private Integer userId;//发帖人id
	private String userName;//发帖人姓名
	private String userSex;//性别
	private String userBirth;//生日
	private String userClass;//班级
	private Integer userExp;//经验值
	private Integer userMoney;//金币
	private String userSpe;//擅长领域
	private String userRegTime;//注册时间
	private String userLastTime;//上次登陆时间
	private Integer authRange;//权限值
	private String userPicture;//头像路径
	private Integer classId;//栏目id
	private Integer themeClassId;//主题类别(求助、转载、新闻、资料等) id
	private String themeClassName;//主题类别(求助、转载、新闻、资料等)
	private String themeClass;//主题分类
	private String themeTitle;//主题标题
	private String themeBody;//主题内容
	private String themeTime;//发帖时间
	private Integer themeViewCount;//浏览量
	private Integer themeSign;//主题标记(普通?精华等)int(0,1)
	private Integer themeIsTop;//是否置顶（0，1）
	private String themeUpTime;//发帖更新时间
	private String className;//板块名称
	private Integer themeReplyCount;//回复数量
	private List<ReplyInfo> replyList;  //Reply 主题回复集合

	
	
	public ThemeInfo() {
		super();
	}


	

	public ThemeInfo(Integer themeId, Integer userId, String userName, String userSex, String userBirth,
			String userClass, Integer userExp, Integer userMoney, String userSpe, String userRegTime,
			String userLastTime, Integer authRange, String userPicture, Integer classId, Integer themeClassId,
			String themeClassName, String themeClass, String themeTitle, String themeBody, String themeTime,
			Integer themeViewCount, Integer themeSign, Integer themeIsTop, String themeUpTime, String className,
			Integer themeReplyCount, List<ReplyInfo> replyList) {
		super();
		this.themeId = themeId;
		this.userId = userId;
		this.userName = userName;
		this.userSex = userSex;
		this.userBirth = userBirth;
		this.userClass = userClass;
		this.userExp = userExp;
		this.userMoney = userMoney;
		this.userSpe = userSpe;
		this.userRegTime = userRegTime;
		this.userLastTime = userLastTime;
		this.authRange = authRange;
		this.userPicture = userPicture;
		this.classId = classId;
		this.themeClassId = themeClassId;
		this.themeClassName = themeClassName;
		this.themeClass = themeClass;
		this.themeTitle = themeTitle;
		this.themeBody = themeBody;
		this.themeTime = themeTime;
		this.themeViewCount = themeViewCount;
		this.themeSign = themeSign;
		this.themeIsTop = themeIsTop;
		this.themeUpTime = themeUpTime;
		this.className = className;
		this.themeReplyCount = themeReplyCount;
		this.replyList = replyList;
	}





	public String getThemeClassName() {
		return themeClassName;
	}




	public void setThemeClassName(String themeClassName) {
		this.themeClassName = themeClassName;
	}




	public Integer getThemeId() {
		return themeId;
	}


	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
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


	public String getUserSex() {
		return userSex;
	}


	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}


	public String getUserBirth() {
		return userBirth;
	}


	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}


	public String getUserClass() {
		return userClass;
	}


	public void setUserClass(String userClass) {
		this.userClass = userClass;
	}


	public Integer getUserExp() {
		return userExp;
	}


	public void setUserExp(Integer userExp) {
		this.userExp = userExp;
	}


	public Integer getUserMoney() {
		return userMoney;
	}


	public void setUserMoney(Integer userMoney) {
		this.userMoney = userMoney;
	}


	public String getUserSpe() {
		return userSpe;
	}


	public void setUserSpe(String userSpe) {
		this.userSpe = userSpe;
	}


	public String getUserRegTime() {
		return userRegTime;
	}


	public void setUserRegTime(String userRegTime) {
		this.userRegTime = userRegTime;
	}


	public String getUserLastTime() {
		return userLastTime;
	}


	public void setUserLastTime(String userLastTime) {
		this.userLastTime = userLastTime;
	}


	public Integer getAuthRange() {
		return authRange;
	}


	public void setAuthRange(Integer authRange) {
		this.authRange = authRange;
	}


	public String getUserPicture() {
		return userPicture;
	}


	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}


	public Integer getClassId() {
		return classId;
	}


	public void setClassId(Integer classId) {
		this.classId = classId;
	}


	public Integer getThemeClassId() {
		return themeClassId;
	}


	public void setThemeClassId(Integer themeClassId) {
		this.themeClassId = themeClassId;
	}


	public String getThemeClass() {
		return themeClass;
	}


	public void setThemeClass(String themeClass) {
		this.themeClass = themeClass;
	}


	public String getThemeTitle() {
		return themeTitle;
	}


	public void setThemeTitle(String themeTitle) {
		this.themeTitle = themeTitle;
	}


	public String getThemeBody() {
		return themeBody;
	}


	public void setThemeBody(String themeBody) {
		this.themeBody = themeBody;
	}


	public String getThemeTime() {
		return themeTime;
	}


	public void setThemeTime(String themeTime) {
		this.themeTime = themeTime;
	}


	public Integer getThemeViewCount() {
		return themeViewCount;
	}


	public void setThemeViewCount(Integer themeViewCount) {
		this.themeViewCount = themeViewCount;
	}


	public Integer getThemeSign() {
		return themeSign;
	}


	public void setThemeSign(Integer themeSign) {
		this.themeSign = themeSign;
	}


	public Integer getThemeIsTop() {
		return themeIsTop;
	}


	public void setThemeIsTop(Integer themeIsTop) {
		this.themeIsTop = themeIsTop;
	}


	public String getThemeUpTime() {
		return themeUpTime;
	}


	public void setThemeUpTime(String themeUpTime) {
		this.themeUpTime = themeUpTime;
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public Integer getThemeReplyCount() {
		return themeReplyCount;
	}


	public void setThemeReplyCount(Integer themeReplyCount) {
		this.themeReplyCount = themeReplyCount;
	}


	public List<ReplyInfo> getReplyList() {
		return replyList;
	}


	public void setReplyList(List<ReplyInfo> replyList) {
		this.replyList = replyList;
	}


	@Override
	public String toString() {
		return "ThemeInfo [themeId=" + themeId + ", userId=" + userId + ", userName=" + userName + ", userSex="
				+ userSex + ", userBirth=" + userBirth + ", userClass=" + userClass + ", userExp=" + userExp
				+ ", userMoney=" + userMoney + ", userSpe=" + userSpe + ", userRegTime=" + userRegTime
				+ ", userLastTime=" + userLastTime + ", authRange=" + authRange + ", userPicture=" + userPicture
				+ ", classId=" + classId + ", themeClassId=" + themeClassId + ", themeClassName=" + themeClassName
				+ ", themeClass=" + themeClass + ", themeTitle=" + themeTitle + ", themeBody=" + themeBody
				+ ", themeTime=" + themeTime + ", themeViewCount=" + themeViewCount + ", themeSign=" + themeSign
				+ ", themeIsTop=" + themeIsTop + ", themeUpTime=" + themeUpTime + ", className=" + className
				+ ", themeReplyCount=" + themeReplyCount + ", replyList=" + replyList + "]";
	}
	
	
	
	
	
	
	

}
