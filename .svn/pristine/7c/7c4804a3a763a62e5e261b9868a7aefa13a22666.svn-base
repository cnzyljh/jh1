/*
 * 
 */
package cn.rojao.entity;

import java.util.List;
import java.util.Map;

import cn.rojao.redis.ScheduleCoding;
import cn.rojao.util.StringUtils;

/**
 * 广电请求广告参数实体
 *
 * <p>对应接口文档《广电平台广告集成广告服务接口定义》，修订日期为2016.11.10
 * @author qing.ye  2016年12月12日
 * @see
 * @since 1.0
 */
public class AdvREQT
{
    private String sessionId;
    private String advType;
    private String advSubType;
    private String advId;
    private String providerId;
    private String contentId;
    private String format;
    private String folderContentId;
    private String catagoryId;
    private String channelId;
    private String clientId;
    private String deviceType;
    private String deviceCode;
    private Long reqNum;
    private String systemId;
    
    private Map<String,String> extInfos;
    
    private String features;
    
    private String assetkeys;
    
    private String assetClass;
    
    private String userGroups;

    private String areaId;
    
    private String tsId;
    
    private String serviceId;
    
    private String regionCode;
    
    private String networkId;
    
    //主菜单广告接口请求参数
    private String posId;
    //主菜单 广告接口存放广告子类型参数
    private List<String> subTypes;

    public AdvREQT(){
        
    }
    
    public AdvREQT(InfoREQT infoREQT,String infoId){
        this.sessionId = infoREQT.getSessionId();
        this.advId = infoId;
        this.providerId = infoREQT.getProviderId();
        this.contentId = infoREQT.getContentId();
        this.format = infoREQT.getFormat();
        this.folderContentId = infoREQT.getFolderContentId();
        this.catagoryId = infoREQT.getCatagoryId();
        this.channelId = infoREQT.getChannelId();
        this.clientId = infoREQT.getClientId();
        this.deviceType = infoREQT.getDeviceType();
        this.regionCode = infoREQT.getRegionCode();
        this.systemId = infoREQT.getSystemId();
        this.reqNum = infoREQT.getReqNum();        
    }
    
    public List<String> getSubTypes() {
        return subTypes;
    }
    public void setSubTypes(List<String> subTypes) {
        this.subTypes = subTypes;
    }
    public String getPosId() {
        return posId;
    }
    public void setPosId(String posId) {
        this.posId = posId;
    }
    public String getSessionId()
    {
        return sessionId;
    }
    public void setSessionId(String sessionId)
    {
        this.sessionId = sessionId;
    }
    public String getAdvType()
    {
        return advType;
    }
    public void setAdvType(String advType)
    {
        this.advType = advType;
    }
    public String getAdvSubType()
    {
        return advSubType;
    }
    public void setAdvSubType(String advSubType)
    {
        this.advSubType = advSubType;
    }
    public String getAdvId() {
		return advId;
	}
	public void setAdvId(String advId) {
		this.advId = advId;
	}
	public String getProviderId()
    {
        return providerId;
    }
    public void setProviderId(String providerId)
    {
        this.providerId = providerId;
    }
    public String getContentId()
    {
        return contentId;
    }
    public void setContentId(String contentId)
    {
        this.contentId = contentId;
    }
    public String getFormat()
    {
        return format;
    }
    public void setFormat(String format)
    {
        this.format = format;
    }
    public String getFolderContentId()
    {
        return folderContentId;
    }
    public void setFolderContentId(String folderContentId)
    {
        this.folderContentId = folderContentId;
    }
    public String getCatagoryId()
    {
        return catagoryId;
    }
    public void setCatagoryId(String catagoryId)
    {
        this.catagoryId = catagoryId;
    }
    public String getChannelId()
    {
        return channelId;
    }
    public void setChannelId(String channelId)
    {
        this.channelId = channelId;
    }
    public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getDeviceType()
    {
        return deviceType;
    }
    public void setDeviceType(String deviceType)
    {
        this.deviceType = deviceType;
    }
    public String getDeviceCode()
    {
        return deviceCode;
    }
    public void setDeviceCode(String deviceCode)
    {
        this.deviceCode = deviceCode;
    }
    public Long getReqNum()
    {
        return reqNum;
    }
    public void setReqNum(Long reqNum)
    {
        this.reqNum = reqNum;
    }
    public String getSystemId()
    {
        return systemId;
    }
    public void setSystemId(String systemId)
    {
        this.systemId = systemId;
    }
    public Map<String, String> getExtInfos()
    {
        return extInfos;
    }
    public void setExtInfos(Map<String, String> extInfos)
    {
        this.extInfos = extInfos;
    }
    
    public String getFeatures()
    {
        return features;
    }
    public void setFeatures(String features)
    {
        this.features = features;
    }
    public String getAssetkeys()
    {
        return assetkeys;
    }
    public void setAssetkeys(String assetkeys)
    {
        this.assetkeys = assetkeys;
    }
    public String getAssetClass()
    {
        return assetClass;
    }
    public void setAssetClass(String assetClass)
    {
        this.assetClass = assetClass;
    }
    public String getUserGroups()
    {
        return userGroups;
    }
    public void setUserGroups(String userGroups)
    {
        this.userGroups = userGroups;
    }
    public String getAreaId()
    {
        return areaId;
    }
    public void setAreaId(String areaId)
    {
        this.areaId = areaId;
    }
    
    public String getTsId() {
		return tsId;
	}
	public void setTsId(String tsId) {
		this.tsId = tsId;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	
	public Long getAdvReqtCoding(){
		return ScheduleCoding.getAdvREQTCode(this);
	}
	
	public String getNetworkId() {
		return networkId;
	}
	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}
	
	public AdvRESP check(){
	    AdvRESP advRESP = new AdvRESP();
	    advRESP.setResultCode("000000");
	    advRESP.setResultDesc("Success");
	    advRESP.setSessionId(sessionId);
	    advRESP.setResultCount(0L);
	    if(StringUtils.isEmpty(sessionId)){
	        advRESP.setResultCode("100002");
	        advRESP.setResultDesc("Parameters [sessionId] can not be empty!");
	    }
	    if(StringUtils.isEmpty(advId)){
	        advRESP.setResultCode("100002");
	        advRESP.setResultDesc("Parameters [advId] can not be empty!");
	    }
	    if(StringUtils.isEmpty(clientId)){
	        advRESP.setResultCode("100002");
	        advRESP.setResultDesc("Parameters [clientId] can not be empty!");
	    }
	    if(reqNum == null){
	        advRESP.setResultCode("100002");
	        advRESP.setResultDesc("Parameters [reqNum] can not be empty!");
	    }
	    return advRESP;
	}
	
}
