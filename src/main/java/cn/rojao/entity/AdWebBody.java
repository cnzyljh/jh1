package cn.rojao.entity;

import java.util.List;

import com.alibaba.fastjson.JSON;
/**
 * 页面广告请求广告主体实体类
 * @author Administrator
 *
 */
public class AdWebBody {
    //广告位ID(必选)
    private String adpID;
    //广告排期ID
    private String scheduleId;
    //返回码(必选)
    private String resultCode;
    //返回广告素材列表
    private List<AdWebEntity> adWebList;
    public String getAdpID() {
        return adpID;
    }
    public void setAdpID(String adpID) {
        this.adpID = adpID;
    }
    public String getScheduleId() {
        return scheduleId;
    }
    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }
    public String getResultCode() {
        return resultCode;
    }
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
    public List<AdWebEntity> getAdWebList() {
        return adWebList;
    }
    public void setAdWebList(List<AdWebEntity> adWebList) {
        this.adWebList = adWebList;
    }
    @Override
    public String toString() {
        
        return JSON.toJSONString(this);
    }
    
}
