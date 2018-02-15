package cn.rojao.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;

import cn.rojao.redis.pojo.ScheduleRedis;

/**
 * 上报数据实体类
 * @author lenovo
 *
 */
public class ReportEntity {
	//客户端随机生成对当前请求的唯一标识
	private String sessionId;
	//客户所在区域
	private String areaId;
	//用户帐号
	private String userId;
	//信息呈现上报列表
	private List<ReportItem> reportItem;
	
	public ReportEntity(){
		
	}
	
	public ReportEntity(ScheduleRedis schedule,List<Item> items ,AdvREQT advReqt){
		this.sessionId = advReqt.getSessionId();
		this.userId = advReqt.getClientId();
		this.areaId = advReqt.getRegionCode();
		List<ReportItem> reportItems = new ArrayList<ReportItem>();
		for(Item item:items){
			ReportItem report = new ReportItem();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
			String time = sdf.format(new Date());			
			report.setDisplayTime(time);
			report.setDetailShowTime(null);
			report.setDisplayDuration(item.getDuration());
			report.setInfoContentKey(item.getAdvContentKey());
			report.setIsClick(null);
			reportItems.add(report);
		}
		this.reportItem = reportItems;
	}
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<ReportItem> getReportItem() {
		return reportItem;
	}
	public void setReportItem(List<ReportItem> reportItem) {
		this.reportItem = reportItem;
	}
	
    public String build()
    {
        return JSON.toJSONString(this);
    }
	
}
