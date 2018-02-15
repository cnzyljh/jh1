/*
 * 
 */
package cn.rojao.entity;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 *
 * @author administrator  
 * @see
 * @since 1.0
 */
public class InfoRESP
{
    private String resultCode;

    private String resultDesc;

    private Long resultCount;

    private String sessionId;

    private Long checkInterval;

    private List<InfoItem> infoItem;

    public InfoRESP(){
    	
    }
    
    public InfoRESP(List<InfoItem> infoItem ,Long checkInterval,String sessionId){
    	this.resultCode = "000000";
    	this.resultDesc = "success";
    	this.infoItem = infoItem;
    	this.checkInterval = checkInterval;
    	this.sessionId = sessionId;
    	this.resultCount = Long.valueOf(infoItem.size());
    }
    
    public InfoRESP(String resultCode,String sessionId){
    	this.resultCount = 0l;
    	this.sessionId = sessionId;
    	if(resultCode.equals("100000")){
    		this.resultCode = resultCode;
    		this.resultDesc = "no Suitable information";
    	}else if(resultCode.equals("100001")){
    	    this.resultCode = resultCode;
            this.resultDesc = "no find information position";
    	}else if(resultCode.equals("100002")){
    	    this.resultCode = resultCode;
            this.resultDesc = "the wrong parameter";
    	}else if(resultCode.equals("100003")){
    	    this.resultCode = resultCode;
            this.resultDesc = "the clientId in blackList";
        }else if(resultCode.equals("999999")){
    	    this.resultCode = resultCode;
            this.resultDesc = "System inner error";
    	}else if(resultCode.equals("111111")){
    	    this.resultCode = resultCode;
            this.resultDesc = "The system is not authorized";
    	}else if(resultCode.equals("000003")){
    		this.resultCode = resultCode;
            this.resultDesc = "Json parse error!";
    	}
    }
    
    public String getResultCode()
    {
        return resultCode;
    }



    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }



    public String getResultDesc()
    {
        return resultDesc;
    }



    public void setResultDesc(String resultDesc)
    {
        this.resultDesc = resultDesc;
    }



    public Long getResultCount()
    {
        return resultCount;
    }



    public void setResultCount(Long resultCount)
    {
        this.resultCount = resultCount;
    }



    public String getSessionId()
    {
        return sessionId;
    }



    public void setSessionId(String sessionId)
    {
        this.sessionId = sessionId;
    }



    public Long getCheckInterval()
    {
        return checkInterval;
    }



    public void setCheckInterval(Long checkInterval)
    {
        this.checkInterval = checkInterval;
    }



    public List<InfoItem> getInfoItem()
    {
        return infoItem;
    }


    public void setInfoItem(List<InfoItem> infoItem)
    {
        this.infoItem = infoItem;
    }


    public String build()
    {
        return JSON.toJSONString(this);
    }
}
