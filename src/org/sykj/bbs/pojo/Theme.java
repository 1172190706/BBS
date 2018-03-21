package org.sykj.bbs.pojo;
import java.sql.Timestamp;
import java.util.Date;
/**
 * 主题（主帖）表
 */

/**
 * @author Administrator
 *
 */
public class Theme {

	// Fields

	private Integer themeId;//主题ID
	private Integer userId;//发帖人id
	private Integer classId;//栏目id
	private Integer themeClassId;//主题类别(求助、转载、新闻、资料等) id
	private String themeClass;//主题分类
	private String themeTitle;//主题标题
	private String themeBody;//主题内容
	private String themeTime;//发帖时间
	private Integer themeViewCount;//浏览量
	private Integer themeSign;//主题标记(普通?精华等)int(0,1)
	private Integer themeIsTop;//是否置顶（0，1）
	private String themeUpTime;//发帖更新时间
	private String userName;//发帖人姓名
	private String className;//板块名称
	private Reply reply;//该帖子的回帖
	private Integer themeReplyCount;//回复数量
	private String themeClassName;//帖子类别-themeClass
	

	// Constructor

	
	/** default constructor */
	public Theme() {
		super();
	}
	



	











	/**
	 * @param themeId
	 * @param userId
	 * @param classId
	 * @param themeClassId
	 * @param themeClass
	 * @param themeTitle
	 * @param themeBody
	 * @param themeTime
	 * @param themeViewCount
	 * @param themeSign
	 * @param themeIsTop
	 * @param themeUpTime
	 * @param userName
	 * @param className
	 * @param reply
	 * @param themeReplyCount
	 * @param themeClassName
	 */
	public Theme(Integer themeId, Integer userId, Integer classId, Integer themeClassId, String themeClass,
			String themeTitle, String themeBody, String themeTime, Integer themeViewCount, Integer themeSign,
			Integer themeIsTop, String themeUpTime, String userName, String className, Reply reply,
			Integer themeReplyCount, String themeClassName) {
		super();
		this.themeId = themeId;
		this.userId = userId;
		this.classId = classId;
		this.themeClassId = themeClassId;
		this.themeClass = themeClass;
		this.themeTitle = themeTitle;
		this.themeBody = themeBody;
		this.themeTime = themeTime;
		this.themeViewCount = themeViewCount;
		this.themeSign = themeSign;
		this.themeIsTop = themeIsTop;
		this.themeUpTime = themeUpTime;
		this.userName = userName;
		this.className = className;
		this.reply = reply;
		this.themeReplyCount = themeReplyCount;
		this.themeClassName = themeClassName;
	}
















	public String getThemeClassName() {
		return themeClassName;
	}
















	public void setThemeClassName(String themeClassName) {
		this.themeClassName = themeClassName;
	}
















	public Integer getThemeReplyCount() {
		return themeReplyCount;
	}





	public void setThemeReplyCount(Integer themeReplyCount) {
		this.themeReplyCount = themeReplyCount;
	}





	public Reply getReply() {
		return reply;
	}


	public void setReply(Reply reply) {
		this.reply = reply;
	}


	public Theme(Integer classId) {
		super();
		this.classId = classId;
	}





	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	/** full constructor */
	
	
	// Property accessors

	public Integer getThemeId() {
		return this.themeId;
	}

	public Theme(Integer themeId, Integer userId, Integer classId,
			Integer themeClassId, String themeTitle, String themeTime,
			Integer themeViewCount, Integer themeSign, Integer themeIsTop) {
		super();
		this.themeId = themeId;
		this.userId = userId;
		this.classId = classId;
		this.themeClassId = themeClassId;
		this.themeTitle = themeTitle;
		this.themeTime = themeTime;
		this.themeViewCount = themeViewCount;
		this.themeSign = themeSign;
		this.themeIsTop = themeIsTop;
	}


	public Theme(Integer themeId, Integer userId, Integer classId,
			Integer themeClassId, String themeTitle, String themeBody,
			String themeTime, Integer themeViewCount, Integer themeSign,
			Integer themeIsTop) {
		super();
		this.themeId = themeId;
		this.userId = userId;
		this.classId = classId;
		this.themeClassId = themeClassId;
		this.themeTitle = themeTitle;
		this.themeBody = themeBody;
		this.themeTime = themeTime;
		this.themeViewCount = themeViewCount;
		this.themeSign = themeSign;
		this.themeIsTop = themeIsTop;
	}


	/**
	 * @param themeId
	 * @param userId
	 * @param classId
	 * @param themeClassId
	 * @param themeClass
	 * @param themeTitle
	 * @param themeBody
	 * @param themeTime
	 * @param themeViewCount
	 * @param themeSign
	 * @param themeIsTop
	 * @param themeUpTime
	 * @param userName
	 * @param className
	 * @param reply
	 */
	public Theme(Integer themeId, Integer userId, Integer classId, Integer themeClassId, String themeClass,
			String themeTitle, String themeBody, String themeTime, Integer themeViewCount, Integer themeSign,
			Integer themeIsTop, String themeUpTime, String userName, String className, Reply reply) {
		super();
		this.themeId = themeId;
		this.userId = userId;
		this.classId = classId;
		this.themeClassId = themeClassId;
		this.themeClass = themeClass;
		this.themeTitle = themeTitle;
		this.themeBody = themeBody;
		this.themeTime = themeTime;
		this.themeViewCount = themeViewCount;
		this.themeSign = themeSign;
		this.themeIsTop = themeIsTop;
		this.themeUpTime = themeUpTime;
		this.userName = userName;
		this.className = className;
		this.reply = reply;
	}

	
	

	public String getThemeClass() {
		return themeClass;
	}


	public void setThemeClass(String themeClass) {
		this.themeClass = themeClass;
	}


	public String getThemeUpTime() {
		return themeUpTime;
	}


	public void setThemeUpTime(String themeUpTime) {
		this.themeUpTime = themeUpTime;
	}


	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
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

	public Integer getThemeClassId() {
		return this.themeClassId;
	}

	public void setThemeClassId(Integer themeClassId) {
		this.themeClassId = themeClassId;
	}

	public String getThemeTitle() {
		return this.themeTitle;
	}

	public void setThemeTitle(String themeTitle) {
		this.themeTitle = themeTitle;
	}

	public String getThemeBody() {
		return this.themeBody;
	}

	public void setThemeBody(String themeBody) {
		this.themeBody = themeBody;
	}

	public String getThemeTime() {
		return this.themeTime;
	}

	public void setThemeTime(String themeTime) {
		this.themeTime = themeTime;
	}

	public Integer getThemeViewCount() {
		return this.themeViewCount;
	}

	public void setThemeViewCount(Integer themeViewCount) {
		this.themeViewCount = themeViewCount;
	}

	public Integer getThemeSign() {
		return this.themeSign;
	}

	public void setThemeSign(Integer themeSign) {
		this.themeSign = themeSign;
	}

	public Integer getThemeIsTop() {
		return this.themeIsTop;
	}

	public void setThemeIsTop(Integer themeIsTop) {
		this.themeIsTop = themeIsTop;
	}


	@Override
	public String toString() {
		return "Theme [themeId=" + themeId + ", userId=" + userId + ", classId=" + classId + ", themeClassId="
				+ themeClassId + ", themeClass=" + themeClass + ", themeTitle=" + themeTitle + ", themeBody="
				+ themeBody + ", themeTime=" + themeTime + ", themeViewCount=" + themeViewCount + ", themeSign="
				+ themeSign + ", themeIsTop=" + themeIsTop + ", themeUpTime=" + themeUpTime + ", userName=" + userName
				+ ", className=" + className + ", reply=" + reply + ", themeReplyCount=" + themeReplyCount
				+ ", themeClassName=" + themeClassName + "]";
	}



	

}