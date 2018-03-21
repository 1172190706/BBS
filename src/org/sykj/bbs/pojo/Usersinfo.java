package org.sykj.bbs.pojo;

public class Usersinfo {
	private Integer userInfoId;
	private Integer userId;
	private String userPicture;
	private String userPassQ;
	private String userPassA;
	private String userEmail;
	private String userPhone;
	private String userSex;
	private String usesrBirth;
	private String userExp;
	private String userMoney;
	private String userSpe;
	private String userRegTime;
	
	public Usersinfo() {
		// TODO Auto-generated constructor stub
	}

	public Usersinfo(Integer userInfoId, Integer userId, String userPicture, String userPassQ, String userPassA,
			String userEmail, String userPhone, String userSex, String usesrBirth, String userExp, String userMoney,
			String userSpe, String userRegTime) {
		super();
		this.userInfoId = userInfoId;
		this.userId = userId;
		this.userPicture = userPicture;
		this.userPassQ = userPassQ;
		this.userPassA = userPassA;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userSex = userSex;
		this.usesrBirth = usesrBirth;
		this.userExp = userExp;
		this.userMoney = userMoney;
		this.userSpe = userSpe;
		this.userRegTime = userRegTime;
	}

	@Override
	public String toString() {
		return "Usersinfo [userInfoId=" + userInfoId + ", userId=" + userId + ", userPicture=" + userPicture
				+ ", userPassQ=" + userPassQ + ", userPassA=" + userPassA + ", userEmail=" + userEmail + ", userPhone="
				+ userPhone + ", userSex=" + userSex + ", usesrBirth=" + usesrBirth + ", userExp=" + userExp
				+ ", userMoney=" + userMoney + ", userSpe=" + userSpe + ", userRegTime=" + userRegTime + "]";
	}

	public Integer getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(Integer userInfoId) {
		this.userInfoId = userInfoId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserPicture() {
		return userPicture;
	}

	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUsesrBirth() {
		return usesrBirth;
	}

	public void setUsesrBirth(String usesrBirth) {
		this.usesrBirth = usesrBirth;
	}

	public String getUserExp() {
		return userExp;
	}

	public void setUserExp(String userExp) {
		this.userExp = userExp;
	}

	public String getUserMoney() {
		return userMoney;
	}

	public void setUserMoney(String userMoney) {
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
	
	
}
