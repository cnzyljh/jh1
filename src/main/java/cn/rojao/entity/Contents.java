package cn.rojao.entity;

import java.util.List;


public class Contents {

   private String postion;
   private String sourceTime;
   private String contentVer;
   private List<Sources> sources;
   public void setPostion(String postion) {
        this.postion = postion;
    }
    public String getPostion() {
        return postion;
    }

   public void setSourceTime(String sourceTime) {
        this.sourceTime = sourceTime;
    }
    public String getSourceTime() {
        return sourceTime;
    }

   public void setContentVer(String contentVer) {
        this.contentVer = contentVer;
    }
    public String getContentVer() {
        return contentVer;
    }

   public void setSources(List<Sources> sources) {
        this.sources = sources;
    }
    public List<Sources> getSources() {
        return sources;
    }

}
