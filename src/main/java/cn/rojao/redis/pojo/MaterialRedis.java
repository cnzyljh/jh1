package cn.rojao.redis.pojo;

import com.alibaba.fastjson.JSON;

public class MaterialRedis {
	
	/**素材编号（资产id）**/
	public String materialId;
	/**素材名称**/
	public String materialName;
	/**素材类型**/
	public String type;
	/**视频素材高标清**/
	public String format;
	/**校验方式**/
	public String checkType;
	/**素材下载路径**/
	public String url;
	/**详情广告链接地址**/
	public String hyper;
	/**素材文字信息**/
	public String content;
	/**素材所属类型**/
	public String classify;
	/**素材视频码率**/
    public String bitrate;
    /**checkCode**/
    public String checkCode;
    /**视频时长**/
    public Integer duration;
    /**m3u8地址*/
    public String m3u8Path;
    /**1.支持切片 2.不支持切片*/
    private Integer hlsCut;
    /**应用跳转key**/
    public String sourceKey;
    /**跳转包名**/
    public String packageName;
    /**跳转类名**/
    public String className;

	public String getMaterialId() {
		return materialId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getCheckType() {
		return checkType;
	}
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHyper() {
		return hyper;
	}
	public void setHyper(String hyper) {
		this.hyper = hyper;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getBitrate() {
        return bitrate;
    }
    public void setBitrate(String bitrate) {
        this.bitrate = bitrate;
    }
    public String getCheckCode() {
        return checkCode;
    }
    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    public String getM3u8Path() {
        return m3u8Path;
    }
    public void setM3u8Path(String m3u8Path) {
        this.m3u8Path = m3u8Path;
    }
    public Integer getHlsCut() {
        return hlsCut;
    }
    public void setHlsCut(Integer hlsCut) {
        this.hlsCut = hlsCut;
    }
    public String getSourceKey() {
		return sourceKey;
	}
	public void setSourceKey(String sourceKey) {
		this.sourceKey = sourceKey;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
	
	

}
