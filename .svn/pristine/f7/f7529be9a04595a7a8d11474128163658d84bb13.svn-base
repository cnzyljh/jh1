/*
 * 
 */
package cn.rojao.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.rojao.util.StringUtils;

/**
 * 营销平台请求参数实体
 *
 * @author administrator  2017年11月20日
 * @see
 * @since 1.0
 */
public class InfoREQT
{
    private String sessionId;
    private String infoId;
    private String providerId;
    private String contentId;
    private String format;
    private String folderContentId;
    private String catagoryId;
    private String channelId;
    private String clientId;
    private String deviceType;
    private String regionCode;
    private String systemId;
    private Long reqNum;
    private String offset;
    
    
    //添加屏保请求参数
    private String url;
    
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFolderContentId() {
        return folderContentId;
    }

    public void setFolderContentId(String folderContentId) {
        this.folderContentId = folderContentId;
    }

    public String getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(String catagoryId) {
        this.catagoryId = catagoryId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public Long getReqNum() {
        return reqNum;
    }

    public void setReqNum(Long reqNum) {
        this.reqNum = reqNum;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

	public InfoRESP check(String aseKey){
        InfoRESP infoRESP = new InfoRESP();
        infoRESP.setResultCode("000000");
        infoRESP.setResultDesc("Success");
        infoRESP.setSessionId(sessionId);
        infoRESP.setResultCount(0L);
        
        
	    if(StringUtils.isEmpty(sessionId)){
	        infoRESP.setResultCode("100002");
	        infoRESP.setResultDesc("Parameters [sessionId] can not be empty!");
	    }else if(StringUtils.isEmpty(infoId)){
	        infoRESP.setResultCode("100002");
	        infoRESP.setResultDesc("Parameters [infoId] can not be empty!");
	    }else if(StringUtils.isEmpty(clientId)){
	        infoRESP.setResultCode("100002");
	        infoRESP.setResultDesc("Parameters [clientId] can not be empty!");
	    }else if(reqNum == null){
	        infoRESP.setResultCode("100002");
	        infoRESP.setResultDesc("Parameters [reqNum] can not be empty!");
	    }else if(StringUtils.isEmpty(offset) || offset.length() != 16){
	    	infoRESP.setResultCode("100002");
	        infoRESP.setResultDesc("Parameters [offset] is wrong!");
	    }else{
	    	if(StringUtils.isNotEmpty(offset)){
	    		Pattern pattern = Pattern.compile("^[A-Fa-f0-9]{16}$");
	    		Matcher matcher = pattern.matcher(offset);
	    		if(!matcher.matches()){
	    	    	infoRESP.setResultCode("100002");
	    	        infoRESP.setResultDesc("Parameters [offset] is wrong!");
	    		}
	    	}
	    }
	    
    	if(StringUtils.isNotEmpty(aseKey)){
			Pattern pattern = Pattern.compile("^[A-Fa-f0-9]{16}$");
			Matcher aseKeyMatcher = pattern.matcher(aseKey);
			if(!aseKeyMatcher.matches()){
    	    	infoRESP.setResultCode("100002");
    	        infoRESP.setResultDesc("System parameters [aseKey] is wrong!");
			}
		}else{
	        infoRESP.setResultCode("100002");
	        infoRESP.setResultDesc("System parameters [aseKey] can not be empty!");
		}
	    
	    
	    return infoRESP;
	}
	
}
