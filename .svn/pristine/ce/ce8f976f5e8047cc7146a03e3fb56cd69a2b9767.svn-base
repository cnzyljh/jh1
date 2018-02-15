package cn.rojao.entity;

import java.util.List;

import com.alibaba.fastjson.JSON;

public class ZyWebRESP {
	private String contentVer;
	private String tempCode;
	private List<Contents> contents;
	private String errorString;

	public void setContentVer(String contentVer) {
		this.contentVer = contentVer;
	}

	public String getContentVer() {
		return contentVer;
	}

	public void setTempCode(String tempCode) {
		this.tempCode = tempCode;
	}

	public String getTempCode() {
		return tempCode;
	}

	public void setContents(List<Contents> contents) {
		this.contents = contents;
	}

	public List<Contents> getContents() {
		return contents;
	}
	
	
	
    public String getErrorString() {
		return errorString;
	}

	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}

	@Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
