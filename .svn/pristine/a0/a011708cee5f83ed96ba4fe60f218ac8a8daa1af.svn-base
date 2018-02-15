package cn.rojao.entity;

import com.alibaba.fastjson.JSON;

public class ScreenInfo {
	
	private String sessionId;
	
	private String screenTime;
	
	private String pageUrl;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getScreenTime() {
		return screenTime;
	}

	public void setScreenTime(String screenTime) {
		this.screenTime = screenTime;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	
    public String build()
    {
        return JSON.toJSONString(this);
    }
	
}
