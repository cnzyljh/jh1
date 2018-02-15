/*
 * 
 */
package cn.rojao.entity;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * simple introduction
 *
 * <p>detailed comment
 * @author qing.ye  2016年12月12日
 * @see
 * @since 1.0
 */
public class AdvRESP
{
    private String resultCode;

    private String resultDesc;

    private Long resultCount;

    private String sessionId;

    private Long checkInterval;

    private List<Item> advItem;

    private Map<String, String> extInfos;
    
    public AdvRESP(){
    	
    }
    
    public AdvRESP(List<Item> advItem ,Long checkInterval,String sessionId){
    	this.resultCode = "000000";
    	this.resultDesc = "success";
    	this.advItem = advItem;
    	this.checkInterval = checkInterval;
    	this.sessionId = sessionId;
    	this.resultCount = Long.valueOf(advItem.size());
    }
    
    public AdvRESP(String resultCode){
    	if(resultCode.equals("100000")){
    		this.resultCode = resultCode;
    		this.resultDesc = "no Suitable adv";
    	}else if(resultCode.equals("100001")){
    	    this.resultCode = resultCode;
            this.resultDesc = "no find position";
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



    public List<Item> getAdvItem()
    {
        return advItem;
    }



    public void setAdvItem(List<Item> advItem)
    {
        this.advItem = advItem;
    }



    public Map<String, String> getExtInfos()
    {
        return extInfos;
    }



    public void setExtInfos(Map<String, String> extInfos)
    {
        this.extInfos = extInfos;
    }



    public String build()
    {
        if(this.advItem != null && this.advItem.size() > 0){
            for(Item item : advItem){
                item.setMaterialName(null);
                item.setMaterialId(null);
                item.setScheduleId(null);
            }
        }
        return JSON.toJSONString(this);
    }
}
