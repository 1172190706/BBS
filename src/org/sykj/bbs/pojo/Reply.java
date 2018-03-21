package org.sykj.bbs.pojo;

/**
<<<<<<< .mine
 * 回帖表00
 * 000
=======
 * 回帖表12345678911
>>>>>>> .r4
 */

public class Reply  {

	// Fields

	private Integer replyId;//回帖id
	private Integer themeId;//主题id
	private String replyBody;//回帖内容
	private Integer userId;//用户id
	private String userName;//用户姓名
	private String replyTime;//回帖时间
	private String userPwd;
	private String state;
	private String authMsg;
	private String authId;
	private String userPassQ;//密保问题
	private String userPassA;//密保答案
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

	// Constructors

	/** default constructor */
	public Reply() {
	}


	public Reply(Integer replyId, Integer themeId, String replyBody,
			Integer userId, String userName, String replyTime) {
		super();
		this.replyId = replyId;
		this.themeId = themeId;
		this.replyBody = replyBody;
		this.userId = userId;
		this.userName = userName;
		this.replyTime = replyTime;
	}



	// Property accessors

	public Reply(Integer themeId, String replyBody, Integer userId) {
		super();
		this.themeId = themeId;
		this.replyBody = replyBody;
		this.userId = userId;
	}


	public Integer getReplyId() {
		return this.replyId;
	}

	

	public Reply(Integer replyId, Integer themeId, String replyBody, Integer userId, String userName, String replyTime,
			String userPwd, String state, String authMsg, String authId, String userPassQ, String userPassA,
			String userSex, String userBirth, String userClass, Integer userExp, Integer userMoney, String userSpe,
			String userRegTime, String userLastTime, Integer authRange, String userPicture) {
		super();
		this.replyId = replyId;
		this.themeId = themeId;
		this.replyBody = replyBody;
		this.userId = userId;
		this.userName = userName;
		this.replyTime = replyTime;
		this.userPwd = userPwd;
		this.state = state;
		this.authMsg = authMsg;
		this.authId = authId;
		this.userPassQ = userPassQ;
		this.userPassA = userPassA;
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


	public String getUserPwd() {
		return userPwd;
	}


	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getAuthMsg() {
		return authMsg;
	}


	public void setAuthMsg(String authMsg) {
		this.authMsg = authMsg;
	}


	public String getAuthId() {
		return authId;
	}


	public void setAuthId(String authId) {
		this.authId = authId;
	}


	public String getUserPassQ() {
		return userPassQ;
	}


	public void setUserPassQ(String userPassQ) {
		this.userPassQ = userPassQ;
	}


	public String getUserPassA() {
		return userPassA;
	}


	public void setUserPassA(String userPassA) {
		this.userPassA = userPassA;
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


	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public Integer getThemeId() {
		return this.themeId;
	}

	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}

	public String getReplyBody() {
		return this.replyBody;
	}

	public void setReplyBody(String replyBody) {
		this.replyBody = replyBody;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}


	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", themeId=" + themeId + ", replyBody=" + replyBody + ", userId=" + userId
				+ ", userName=" + userName + ", replyTime=" + replyTime + ", userPwd=" + userPwd + ", state=" + state
				+ ", authMsg=" + authMsg + ", authId=" + authId + ", userPassQ=" + userPassQ + ", userPassA="
				+ userPassA + ", userSex=" + userSex + ", userBirth=" + userBirth + ", userClass=" + userClass
				+ ", userExp=" + userExp + ", userMoney=" + userMoney + ", userSpe=" + userSpe + ", userRegTime="
				+ userRegTime + ", userLastTime=" + userLastTime + ", authRange=" + authRange + ", userPicture="
				+ userPicture + "]";
	}

	
	
}