package org.sykj.bbs.pojo;

public class ResourceType {
	private Integer resourceTypeId;
	private String resourceTypeName;
	private Integer resourceCount;
	public ResourceType(Integer resourceTypeId, String resourceTypeName) {
		super();
		this.resourceTypeId = resourceTypeId;
		this.resourceTypeName = resourceTypeName;
	}
	public Integer getResourceTypeId() {
		return resourceTypeId;
	}
	public void setResourceTypeId(Integer resourceTypeId) {
		this.resourceTypeId = resourceTypeId;
	}
	public String getResourceTypeName() {
		return resourceTypeName;
	}
	public void setResourceTypeName(String resourceTypeName) {
		this.resourceTypeName = resourceTypeName;
	}
	public Integer getResourceCount() {
		return resourceCount;
	}
	public void setResourceCount(Integer resourceCount) {
		this.resourceCount = resourceCount;
	}
	@Override
	public String toString() {
		return "ResourceType [resourceTypeId=" + resourceTypeId + ", resourceTypeName=" + resourceTypeName
				+ ", resourceCount=" + resourceCount + "]";
	}
	

}
