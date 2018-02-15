package cn.rojao.entity;

import com.alibaba.fastjson.JSON;

/**
 * i4接口请求插播广告请求返回实体类
 * @author Administrator
 *
 */
public class Attributes {
    //广告assetId
    private String id;
    //内容提供商ID
    private String author;
    //影片类型
    private String type;
    //广告位置
    private String adPosition;
    //影片子片段的开始
    private String clipBegin;
    //影片子片段的结束
    private String clipEnd;
    //不填写字段
    private String trickModeDisable;
    //广告详情URL地址
    private String pdetailURL;
    //不填字段
    private String psURL;
    //视频码率
    private String bitRate;
    
    public Attributes(Item item,InterCutEntity interCut){
        this.type = "ad";
        this.clipBegin = "0";
        this.trickModeDisable = "";
        this.psURL = "";
        this.id = item.getMaterialId();
        this.author = interCut.getProviderId();
        if("001".equals(item.getAdvSubType()) || "002".equals(item.getAdvSubType()) || "003".equals(item.getAdvSubType())){
            this.adPosition = "0";
        }else if("101".equals(item.getAdvSubType()) || "102".equals(item.getAdvSubType()) || "103".equals(item.getAdvSubType())){
            this.adPosition = "-1";
        }else if("000".equals(item.getAdvSubType())){
            if(item.getOffset()!=null){
                this.adPosition = item.getOffset().toString();
            }else{
                this.adPosition = "-1";
            }
        }  
        if(item.getDuration()!=null){
            this.clipEnd = item.getDuration().toString();
        }else{
            this.clipEnd = "";
        }
        
        this.pdetailURL = item.getHref();
        if(item.getBitrate() != null){
            this.bitRate = item.getBitrate().replace("kb/s", "").trim(); 
        }else{
            this.bitRate = "0";
        }
        
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getAdPosition() {
        return adPosition;
    }
    public void setAdPosition(String adPosition) {
        this.adPosition = adPosition;
    }
    public String getClipBegin() {
        return clipBegin;
    }
    public void setClipBegin(String clipBegin) {
        this.clipBegin = clipBegin;
    }
    public String getClipEnd() {
        return clipEnd;
    }
    public void setClipEnd(String clipEnd) {
        this.clipEnd = clipEnd;
    }
    public String getTrickModeDisable() {
        return trickModeDisable;
    }
    public void setTrickModeDisable(String trickModeDisable) {
        this.trickModeDisable = trickModeDisable;
    }
    public String getPdetailURL() {
        return pdetailURL;
    }
    public void setPdetailURL(String pdetailURL) {
        this.pdetailURL = pdetailURL;
    }
    public String getPsURL() {
        return psURL;
    }
    public void setPsURL(String psURL) {
        this.psURL = psURL;
    }
    public String getBitRate() {
        return bitRate;
    }
    public void setBitRate(String bitRate) {
        this.bitRate = bitRate;
    }
    @Override
    public String toString() {
        
        return JSON.toJSONString(this);
    }
    
}
