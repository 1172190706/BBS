package org.sykj.bbs.pojo;

public class Resource {
	/*
	 * --资源
create table resource(
resourceId int primary key identity(1000,1),--主键 ID
resourceTypeId int ,--分类ID
resourceName varchar(40),--名称
resourceMsg varchar(max),--信息
resourceUrl varchar(max),--资源URL
resourceSize float,--大小
resourceVersion varchar(20),--版本
resourceOs varchar(20),--系统
resourceOsBit int,--系统位数
resourceTime datetime,--更新时间
resourceCopyright varchar,--授权
resourceCondition int--状态 0未审核 1已审核
)
	 * */
	private Integer resourceId;  //主键
	private Integer resourceTypeId;//分类id
	private String resourceName;//名称
	private String resourceMsg;//说明
	private String resourceUrl;//url地址
	private Float resourceSize;//大小
	private String resourceVersion;//
	private String resourceOs;//运行环境系统位数
	private String resourceOsBit;//
	private String resourceTime;//上传时间
	private String resourceCopyright;//授权状态
	private Integer resourceCondition;//状态   0未审核 1已审核 
	private String resourceTypeName;//
	private Integer userId;//
	private String userName;//
	
	
	public Resource() {
		super();
		// TODO 自动生成的构造函数存根
	}
/**所有字段*/
	public Resource(Integer resourceId, Integer resourceTypeId,
			String resourceName, String resourceMsg, String resourceUrl,
			Float resourceSize, String resourceVersion, String resourceOs,
			String resourceOsBit, String resourceTime,
			String resourceCopyright, Integer resourceCondition,Integer userId) {
		super();
		this.resourceId = resourceId;
		this.resourceTypeId = resourceTypeId;
		this.resourceName = resourceName;
		this.resourceMsg = resourceMsg;
		this.resourceUrl = resourceUrl;
		this.resourceSize = resourceSize;
		this.resourceVersion = resourceVersion;
		this.resourceOs = resourceOs;
		this.resourceOsBit = resourceOsBit;
		this.resourceTime = resourceTime;
		this.resourceCopyright = resourceCopyright;
		this.resourceCondition = resourceCondition;
		this.userId=userId;
	}
	
	public Resource(Integer resourceId, String resourceName,
			String resourceMsg, String resourceUrl, Float resourceSize,
			String resourceVersion, String resourceOs, String resourceOsBit,
			String resourceTime, String resourceCopyright,
			Integer resourceCondition, String resourceTypeName) {
		super();
		this.resourceId = resourceId;
		this.resourceName = resourceName;
		this.resourceMsg = resourceMsg;
		this.resourceUrl = resourceUrl;
		this.resourceSize = resourceSize;
		this.resourceVersion = resourceVersion;
		this.resourceOs = resourceOs;
		this.resourceOsBit = resourceOsBit;
		this.resourceTime = resourceTime;
		this.resourceCopyright = resourceCopyright;
		this.resourceCondition = resourceCondition;
		this.resourceTypeName = resourceTypeName;
	}

	public Resource(Integer resourceTypeId, String resourceName,
			String resourceMsg, String resourceUrl, Float resourceSize,
			String resourceVersion, String resourceOs, String resourceOsBit,
			String resourceTime, String resourceCopyright,
			Integer resourceCondition, Integer userId) {
		super();
		this.resourceTypeId = resourceTypeId;
		this.resourceName = resourceName;
		this.resourceMsg = resourceMsg;
		this.resourceUrl = resourceUrl;
		this.resourceSize = resourceSize;
		this.resourceVersion = resourceVersion;
		this.resourceOs = resourceOs;
		this.resourceOsBit = resourceOsBit;
		this.resourceTime = resourceTime;
		this.resourceCopyright = resourceCopyright;
		this.resourceCondition = resourceCondition;
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public Integer getResourceTypeId() {
		return resourceTypeId;
	}

	public void setResourceTypeId(Integer resourceTypeId) {
		this.resourceTypeId = resourceTypeId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceMsg() {
		return resourceMsg;
	}

	public void setResourceMsg(String resourceMsg) {
		this.resourceMsg = resourceMsg;
	}

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	public Float getResourceSize() {
		return resourceSize;
	}

	public void setResourceSize(Float resourceSize) {
		this.resourceSize = resourceSize;
	}

	public String getResourceVersion() {
		return resourceVersion;
	}

	public void setResourceVersion(String resourceVersion) {
		this.resourceVersion = resourceVersion;
	}

	public String getResourceOs() {
		return resourceOs;
	}

	public void setResourceOs(String resourceOs) {
		this.resourceOs = resourceOs;
	}

	public String getResourceOsBit() {
		return resourceOsBit;
	}

	public void setResourceOsBit(String resourceOsBit) {
		this.resourceOsBit = resourceOsBit;
	}

	public String getResourceTime() {
		return resourceTime;
	}

	public void setResourceTime(String resourceTime) {
		this.resourceTime = resourceTime;
	}

	public String getResourceCopyright() {
		return resourceCopyright;
	}

	public void setResourceCopyright(String resourceCopyright) {
		this.resourceCopyright = resourceCopyright;
	}

	public Integer getResourceCondition() {
		return resourceCondition;
	}

	public void setResourceCondition(Integer resourceCondition) {
		this.resourceCondition = resourceCondition;
	}

	public String getResourceTypeName() {
		return resourceTypeName;
	}

	public void setResourceTypeName(String resourceTypeName) {
		this.resourceTypeName = resourceTypeName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Resource [resourceId=" + resourceId + ", resourceTypeId=" + resourceTypeId + ", resourceName="
				+ resourceName + ", resourceMsg=" + resourceMsg + ", resourceUrl=" + resourceUrl + ", resourceSize="
				+ resourceSize + ", resourceVersion=" + resourceVersion + ", resourceOs=" + resourceOs
				+ ", resourceOsBit=" + resourceOsBit + ", resourceTime=" + resourceTime + ", resourceCopyright="
				+ resourceCopyright + ", resourceCondition=" + resourceCondition + ", resourceTypeName="
				+ resourceTypeName + ", userId=" + userId + ", userName=" + userName + "]";
	}

	
}
