package cn.rojao.redis.pojo;

import java.util.List;

import com.alibaba.fastjson.JSON;

public class UserRedis {
	/**用户号（或卡号）**/
	public String userId;
	/**用户级别**/
	public String userLevel;
	/**用户分组**/
	public List<String> userGroup;
	/**所属区域**/
	public String areaId;
	/**所属运营商**/
	public String companyId;
	/**用户特征（特征分类:特征值，比如sex：M**/
	public List<String> userFeature;
	/**黑名单描述（压入禁用的外部广告位）**/
	public String blackList;
	
	public UserRedis(){
		
	}
	
	public UserRedis(String userId){
		this.userId = userId;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	public List<String> getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(List<String> userGroup) {
		this.userGroup = userGroup;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public List<String> getUserFeature() {
		return userFeature;
	}
	public void setUserFeature(List<String> userFeature) {
		this.userFeature = userFeature;
	}
	public String getBlackList() {
		return blackList;
	}
	public void setBlackList(String blackList) {
		this.blackList = blackList;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
	
	
	
	
	
	

}
