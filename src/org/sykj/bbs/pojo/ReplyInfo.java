package org.sykj.bbs.pojo;

public class ReplyInfo {
	
	private Integer replyId;//回帖id
	private Integer themeId;//主题id
	private String replyBody;//回帖内容
	private String replyTime;//回帖时间
	private Integer userId;//用户id
	private String userName;//用户姓名
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


	
	
	public ReplyInfo() {
		super();
	}





	public ReplyInfo(Integer replyId, Integer themeId, String replyBody, String replyTime, Integer userId,
			String userName, String userSex, String userBirth, String userClass, Integer userExp, Integer userMoney,
			String userSpe, String userRegTime, String userLastTime, Integer authRange, String userPicture) {
		super();
		this.replyId = replyId;
		this.themeId = themeId;
		this.replyBody = replyBody;
		this.replyTime = replyTime;
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
	}





	public Integer getReplyId() {
		return replyId;
	}





	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}





	public Integer getThemeId() {
		return themeId;
	}





	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}





	public String getReplyBody() {
		return replyBody;
	}





	public void setReplyBody(String replyBody) {
		this.replyBody = replyBody;
	}





	public String getReplyTime() {
		return replyTime;
	}





	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
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





	@Override
	public String toString() {
		return "ReplyInfo [replyId=" + replyId + ", themeId=" + themeId + ", replyBody=" + replyBody + ", replyTime="
				+ replyTime + ", userId=" + userId + ", userName=" + userName + ", userSex=" + userSex + ", userBirth="
				+ userBirth + ", userClass=" + userClass + ", userExp=" + userExp + ", userMoney=" + userMoney
				+ ", userSpe=" + userSpe + ", userRegTime=" + userRegTime + ", userLastTime=" + userLastTime
				+ ", authRange=" + authRange + ", userPicture=" + userPicture + "]";
	}
	
	
	
	
	
	

}
