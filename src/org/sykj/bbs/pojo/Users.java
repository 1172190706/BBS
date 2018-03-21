package org.sykj.bbs.pojo;
/**22
 * 用户表实体类
 */

public class Users{

	private Integer userId;
	private String userName;
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
	private String userPhone;//电话
	private String userEmail;//email

	public Users() {
		super();
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", state=" + state
				+ ", authMsg=" + authMsg + ", authId=" + authId + ", userPassQ=" + userPassQ + ", userPassA="
				+ userPassA + ", userSex=" + userSex + ", userBirth=" + userBirth + ", userClass=" + userClass
				+ ", userExp=" + userExp + ", userMoney=" + userMoney + ", userSpe=" + userSpe + ", userRegTime="
				+ userRegTime + ", userLastTime=" + userLastTime + ", authRange=" + authRange + ", userPicture="
				+ userPicture + ", userPhone=" + userPhone + ", userEmail=" + userEmail + "]";
	}

	public Users(Integer userId, String userName, String userPwd, String state, String authMsg, String authId,
			String userPassQ, String userPassA, String userSex, String userBirth, String userClass, Integer userExp,
			Integer userMoney, String userSpe, String userRegTime, String userLastTime, Integer authRange,
			String userPicture, String userPhone, String userEmail) {
		super();
		this.userId = userId;
		this.userName = userName;
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
		this.userPhone = userPhone;
		this.userEmail = userEmail;
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

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}