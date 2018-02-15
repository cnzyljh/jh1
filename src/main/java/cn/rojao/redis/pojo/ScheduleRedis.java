package cn.rojao.redis.pojo;

import java.util.List;

import com.alibaba.fastjson.JSON;

import cn.rojao.entity.AdsFlag;

public class ScheduleRedis  implements Comparable{
	
	/**排期id**/
	private String taskId;
	/**排期名称**/
	private String taskName;
	/**关联广告位**/
	private String advId;
	/**排期优先级**/
	private Integer priority;
	/**排期状态**/
	private String status;
	/**排期开始时间**/
	private String starttime;
	/**排期结束时间**/
	private String endtime;
	/**排期投放时间段**/
	private String timescope;
	/**素材投放次数**/
	private Integer exposureTimes;
	/**排期关联用户组**/
	private List<String> userGroups;
	/**排期关联区域**/
	private List<String> areas;
	/**排期关联用户级别**/
	private String levels;
	/**排期关联用户特征**/
	private List<String> features;
	/**排期关联内容**/
	private List<String> contents;
	/**排期关联分类**/
	private List<String> genres;
	/**排期关联栏目**/
	private List<String> catagorys;
	/**排期关联终端类型**/
	private List<String> terminals;
	/**排期关联内容提供商**/
	private List<String> provides;
	/**排期关联关键字**/
	private String keys;
	/**排期关联频道**/
	private List<String> channels;
	/**排期关联素材id**/
	private String materials;
	/**排期素材的显示时间**/
	private Long duration;
	/**排期素材的显示开始时间**/
	private String showBegintime;
	/**排期素材的显示间隔时间**/
	private Long interval;
	/**排期素材的显示次数**/
	private Long times;
	/**排期素材的显示透明度**/
	private Integer transparent;
	/**排期素材是否可以跳过**/
	private Integer skip;
	/**视频素材显示方式**/
	private Long videoPlaytype;
	/**素材的轮询方式**/
	private String style;
	/**显示位置**/
	private String coordinate;
	
    private Integer xPosition;
	
	private Integer yPosition;
	/**显示区域大小**/
	private String domain;
	/**背景色**/
	private String bgcolor;
	/**动画效果**/
	private Integer animation;
	/**动画速率**/
	private Long speed;
	/**动画方向**/
	private Long direction;
	/**轮转时间（秒）**/
	private Integer turnTime;
	/**频率类型**/
	private Long freqType;
	/**投放码值**/
	private Long scheduleCoding;
	/**广告位最大显示时长**/
	private Integer maxShowtime;
	/**广告位请求间隔时间**/
	private Integer requestInterval;
	/**广告位类型**/
	private String advType;
	/**广告位子类型**/
	private String advSonType;
	/**排期时间**/
	private List<Timescope> timeList;
	/**时间集合**/
	private List<Long> scopeList;
	/**运营商id**/
	private String companyId;
	/**权重排序**/
	private int sortValue;
	/**排期关联网络**/
	private List<String> networks;
	/**排期关联用户数据**/
    private List<String> userDataUrls;
    
	/**判断投放条件吻合**/
	private AdsFlag adsFlag;
	
	/**条件匹配时最高级别**/
	private int higherLevel;
	
	/**排期关联父集内容**/
    private List<String> folderContents;
    
    /**相对时间，绝对时间**/
    private Long offsetType;
    
    /**片偏移**/
    private Long offset;
    
    /**排期关联关键字**/
    private List<String> keyWords;

    /**素材视频高标清**/
    private List<String> formats;
    
    /**广告位外部编码**/
    private String parsestr; 
    
    /**广告位创建时间**/
    private String positionCreateTime; 
    
    /**是否上报0上报1不上报**/
    private Long needreport;

    /**创意ID**/
    private Long creativeId;
    
    /**策略Id**/
    private Long strategyId;
    
    /**订单Id**/
    private Long orderId;
    
    public Long getStrategyId() {
		return strategyId;
	}

	public void setStrategyId(Long strategyId) {
		this.strategyId = strategyId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCreativeId() {
		return creativeId;
	}

	public void setCreativeId(Long creativeId) {
		this.creativeId = creativeId;
	}

	public Long getNeedreport() {
		return needreport;
	}

	public void setNeedreport(Long needreport) {
		this.needreport = needreport;
	}

	public List<String> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(List<String> keyWords) {
        this.keyWords = keyWords;
    }

    public Long getOffsetType() {
        return offsetType;
    }

    public void setOffsetType(Long offsetType) {
        this.offsetType = offsetType;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public List<String> getFolderContents() {
        return folderContents;
    }

    public void setFolderContents(List<String> folderContents) {
        this.folderContents = folderContents;
    }

    public int getHigherLevel() {
        return higherLevel;
    }

    public void setHigherLevel(int higherLevel) {
        this.higherLevel = higherLevel;
    }

    public AdsFlag getAdsFlag() {
        return adsFlag;
    }

    public void setAdsFlag(AdsFlag adsFlag) {
        this.adsFlag = adsFlag;
    }

    public ScheduleRedis(){
		
	}
	
    public List<String> getNetworks() {
        return networks;
    }

    public void setNetworks(List<String> networks) {
        this.networks = networks;
    }

    public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getAdvId() {
		return advId;
	}

	public void setAdvId(String advId) {
		this.advId = advId;
	}
	
	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getTimescope() {
		return timescope;
	}

	public void setTimescope(String timescope) {
		this.timescope = timescope;
	}

	public Integer getExposureTimes() {
		return exposureTimes;
	}

	public void setExposureTimes(Integer exposureTimes) {
		this.exposureTimes = exposureTimes;
	}
	
	public List<String> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(List<String> userGroups) {
		this.userGroups = userGroups;
	}

	public String getLevels() {
		return levels;
	}

	public void setLevels(String levels) {
		this.levels = levels;
	}

	public List<String> getFeatures() {
		return features;
	}

	public void setFeatures(List<String> features) {
		this.features = features;
	}

	public List<String> getContents() {
		return contents;
	}

	public void setContents(List<String> contents) {
		this.contents = contents;
	}
	
	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public List<String> getCatagorys() {
		return catagorys;
	}

	public void setCatagorys(List<String> catagorys) {
		this.catagorys = catagorys;
	}

	public List<String> getTerminals() {
		return terminals;
	}

	public void setTerminals(List<String> terminals) {
		this.terminals = terminals;
	}

	public List<String> getProvides() {
		return provides;
	}

	public void setProvides(List<String> provides) {
		this.provides = provides;
	}

	public String getKeys() {
		return keys;
	}

	public void setKeys(String keys) {
		this.keys = keys;
	}

	public List<String> getAreas() {
		return areas;
	}

	public void setAreas(List<String> areas) {
		this.areas = areas;
	}

	public List<String> getChannels() {
		return channels;
	}

	public void setChannels(List<String> channels) {
		this.channels = channels;
	}

	public String getMaterials() {
		return materials;
	}

	public void setMaterials(String materials) {
		this.materials = materials;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public String getShowBegintime() {
		return showBegintime;
	}

	public void setShowBegintime(String showBegintime) {
		this.showBegintime = showBegintime;
	}

	public Long getInterval() {
		return interval;
	}

	public void setInterval(Long interval) {
		this.interval = interval;
	}

	public Long getTimes() {
		return times;
	}

	public void setTimes(Long times) {
		this.times = times;
	}

	public Integer getTransparent() {
		return transparent;
	}

	public void setTransparent(Integer transparent) {
		this.transparent = transparent;
	}

	public Integer getSkip() {
		return skip;
	}

	public void setSkip(Integer skip) {
		this.skip = skip;
	}

	public Long getVideoPlaytype() {
		return videoPlaytype;
	}

	public void setVideoPlaytype(Long videoPlaytype) {
		this.videoPlaytype = videoPlaytype;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getBgcolor() {
		return bgcolor;
	}

	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}

	public Integer getAnimation() {
		return animation;
	}

	public void setAnimation(Integer animation) {
		this.animation = animation;
	}

	public Long getSpeed() {
		return speed;
	}

	public void setSpeed(Long speed) {
		this.speed = speed;
	}

	public Long getDirection() {
		return direction;
	}

	public void setDirection(Long direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
	public Long getScheduleCoding() {
		return scheduleCoding;
	}

	public void setScheduleCoding(Long scheduleCoding) {
		this.scheduleCoding = scheduleCoding;
	}

	public Integer getTurnTime() {
		return turnTime;
	}

	public void setTurnTime(Integer turnTime) {
		this.turnTime = turnTime;
	}
	
	public Long getFreqType() {
		return freqType;
	}

	public void setFreqType(Long freqType) {
		this.freqType = freqType;
	}
	
	public Integer getMaxShowtime() {
		return maxShowtime;
	}

	public void setMaxShowtime(Integer maxShowtime) {
		this.maxShowtime = maxShowtime;
	}

	public Integer getRequestInterval() {
		return requestInterval;
	}

	public void setRequestInterval(Integer requestInterval) {
		this.requestInterval = requestInterval;
	}

	public String getAdvType() {
		return advType;
	}

	public void setAdvType(String advType) {
		this.advType = advType;
	}

	public String getAdvSonType() {
		return advSonType;
	}

	public void setAdvSonType(String advSonType) {
		this.advSonType = advSonType;
	}

	public List<Timescope> getTimeList() {
		return timeList;
	}

	public void setTimeList(List<Timescope> timeList) {
		this.timeList = timeList;
	}
	
	public List<Long> getScopeList() {
		return scopeList;
	}

	public void setScopeList(List<Long> scopeList) {
		this.scopeList = scopeList;
	}
	
	public Integer getXPosition() {
		return xPosition;
	}

	public void setXPosition(Integer xPosition) {
		this.xPosition = xPosition;
	}

	public Integer getYPosition() {
		return yPosition;
	}

	public void setYPosition(Integer yPosition) {
		this.yPosition = yPosition;
	}
	
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	public int getSortValue() {
		return sortValue;
	}

	public void setSortValue(int sortValue) {
		this.sortValue = sortValue;
	}

	public List<String> getUserDataUrls() {
        return userDataUrls;
    }

    public void setUserDataUrls(List<String> userDataUrls) {
        this.userDataUrls = userDataUrls;
    }

    public List<String> getFormats() {
        return formats;
    }

    public void setFormats(List<String> formats) {
        this.formats = formats;
    }
    

    public String getParsestr() {
		return parsestr;
	}

	public void setParsestr(String parsestr) {
		this.parsestr = parsestr;
	}

	public String getPositionCreateTime() {
		return positionCreateTime;
	}

	public void setPositionCreateTime(String positionCreateTime) {
		this.positionCreateTime = positionCreateTime;
	}

	@Override
	public int compareTo(Object arg0) {
		ScheduleRedis schedule = (ScheduleRedis) arg0;
		if(this.sortValue>schedule.getSortValue()){
			return -1;
		}else if(this.sortValue == schedule.getSortValue()){
		    if(this.higherLevel > schedule.getHigherLevel()){
		        return -1;
		    }else if(this.higherLevel == schedule.getHigherLevel() && 
		            Long.parseLong(this.taskId)> Long.parseLong(schedule.getTaskId())){
		        return -1;
		    }
		}
		return 1;
	}
	
	
	
	

}
