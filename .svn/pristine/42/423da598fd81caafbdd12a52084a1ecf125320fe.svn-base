package cn.rojao.entity;

import cn.rojao.util.StringUtils;

/**
 * i4接口请求插播广告请求参数实体类
 * @author Administrator
 *
 */
public class InterCutEntity {
    //媒资ID
    private String assetId;
    
    //内容提供商ID
    private String providerId;
    
    //智能卡号
    private String sno;
    
    //栏目ID：当 businessType为0点播时catalogId为栏目ID；
    //当businessType为1回看时此值必填，传递的是节目单所属频道ID
    private String catalogId;
    
    //区域编码
    private String areaCode;
    
    //业务类型 0：点播 1：回看
    private String businessType;
    
    //码率类型 0：高清 1：标清 2：超清
    private String streamRate;
    
    //客户端类型 1：机顶盒 2：网关 3：手机 4：电脑 5：平板电脑
    private String clientType;
    
    public String getAssetId() {
        return assetId;
    }
    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }
    public String getProviderId() {
        return providerId;
    }
    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
    public String getSno() {
        return sno;
    }
    public void setSno(String sno) {
        this.sno = sno;
    }
    public String getCatalogId() {
        return catalogId;
    }
    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }
    public String getAreaCode() {
        return areaCode;
    }
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
    public String getBusinessType() {
        return businessType;
    }
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
    public String getStreamRate() {
        return streamRate;
    }
    public void setStreamRate(String streamRate) {
        this.streamRate = streamRate;
    }
    public String getClientType() {
        return clientType;
    }
    public void setClientType(String clientType) {
        this.clientType = clientType;
    }
    
    public String check(){
        String desc = "";
        if(StringUtils.isEmpty(providerId)){
            desc = "Parameters [providerId] can not be empty!";
        }
        if(StringUtils.isEmpty(sno)){
            desc = "Parameters [sno] can not be empty!";
        }
        if(StringUtils.isEmpty(areaCode)){
            desc = "Parameters [areaCode] can not be empty!";
        }
        if(StringUtils.isEmpty(businessType)){
            desc = "Parameters [businessType] can not be empty!";
        }
        if(StringUtils.isEmpty(streamRate)){
            desc = "Parameters [streamRate] can not be empty!";
        }
        if(StringUtils.isEmpty(areaCode)){
            desc = "Parameters [areaCode] can not be empty!";
        }else{
            if(areaCode.equals("-1") || areaCode.indexOf("|") == areaCode.lastIndexOf("|")){
                desc = "Parameters [areaCode] is invalied!";
            }
        }
        return desc;
    }
}
