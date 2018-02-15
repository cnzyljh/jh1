package cn.rojao.entity;

import com.alibaba.fastjson.JSON;

/**
 * 页面广告请求广告素材实体类
 * @author Administrator
 *
 */
public class AdWebEntity implements Comparable{
    
    //广告ID(必选)
    private String adID;
    //广告类型(必选)
    private Integer adType;
    //广告图片地址
    private String picURL;
    //图片格式说明
    private String picType;
    //视频格式说明
    private String videoType;
    //视频码率
    private String streamRate;
    //广告统计地址
    private String pSURL;
    //广告详情URL地址
    private String pDetailURL;
    //广告详情展示方法
    private Integer pShowMode;
    //弹出广告详情的X坐标
    private Long pX;
    //Y坐标
    private Long pY;
    //宽度
    private Long pW;
    //高度
    private Long pH;
    //弹出广告详情显示时长
    private Integer pSt;
    //广告素材名称
    private String tTitle;
    //文字字体大小
    private String tSize;
    //文字字体型号
    private String tStyle;
    //文字广告描述
    private String tDescription;
    //文字字体颜色
    private String tFontColor;
    //文字广告内容颜色
    private String tContentColor;
    //文字广告背景颜色
    private String tBackColor;
    //文字广告透明度
    private String tPellucidity;
    //文字是否为跑马灯
    private Integer isMarquee;
    //跑马灯滚动方向
    private Long mDir;
    //跑马灯背景是否透明
    private Integer mBack;
    //跑马灯背景颜色
    private String mBackColor;
    //跑马灯速度
    private String mSpeed;
    //广告影片媒资ID
    private String assetID;
    //广告播放时长
    private Long duration;
    //广告播放排序号(必选)
    private Integer sequence;
    //素材ID(必选)
    private String contentID;
    //MD5
    private String md5;
    
    public AdWebEntity(){
        
    }
    
    public AdWebEntity(Item item){
        //广告ID(必选)
        this.adID=item.getAdvContentKey();
        //广告类型(必选)
        //素材ID(必选)
        this.contentID = item.getMaterialId();
        //广告素材名称
        this.tTitle = item.getMaterialName();
        if(item.getAssetType()!= null){
            //广告图片地址
            this.picURL = item.getAdvURL();
            if(item.getAssetType().longValue() == 1l){
                this.adType=0;
            }else if(item.getAssetType().longValue() == 7l){
                this.adType=2;
                this.contentID = item.getAdvURL().replace("VOD://", "");
            }else if(item.getAssetType().longValue() == 3l){
                this.adType=2;
            }
        }
        //广告影片媒资ID
        //this.assetID;
        //图片格式说明
        //this.picType;
        //视频格式说明
        //this.videoType;
        //视频码率
        //this.streamRate;
        //广告统计地址
        //this.pSURL;
        //广告详情URL地址
        this.pDetailURL = item.getHref();
        //广告详情展示方法
        //this.pShowMode = 1;
        //弹出广告详情的X坐标
        //this.pX = item.getXPosition() == null ? null : Long.valueOf(item.getXPosition());
        //Y坐标
        //this.pY = item.getYPosition() == null ? null : Long.valueOf(item.getYPosition());
        //宽度
        this.pW = item.getMWidth();
        //高度
        this.pH = item.getMHeight();
        //弹出广告详情显示时长
        //this.pSt;
        //文字广告透明度
        //this.tPellucidity = item.getTransparent() == null ? null : item.getTransparent().toString();
        //文字字体大小
        //this.tSize;
        //文字字体型号
        //this.tStyle;
        //文字广告描述
        //this.tDescription = item.getContext();
        //文字字体颜色
        //this.tFontColor;
        //文字广告内容颜色
        //this.tContentColor;
        //文字广告背景颜色
        //this.tBackColor = item.getBackgroudColor();
        //文字是否为跑马灯
        //this.isMarquee;
        //跑马灯滚动方向
        //this.mDir = item.getDirect();
        //跑马灯背景是否透明
        //this.mBack;
        //跑马灯背景颜色
        //this.mBackColor;
        //跑马灯速度
        //if(item.getSpeed() != null){
        //    this.mSpeed = item.getSpeed().toString();
        //}
        //广告播放时长
        if(item.getDuration() != null && item.getDuration().longValue() != -1l){
            this.duration = item.getDuration();
        }
        //广告播放排序号(必选)
        //this.sequence;
        //md5
        this.md5 = item.getmD5();
    }
    
    public String getAdID() {
        return adID;
    }
    public void setAdID(String adID) {
        this.adID = adID;
    }
    public Integer getAdType() {
        return adType;
    }
    public void setAdType(Integer adType) {
        this.adType = adType;
    }
    public String getPicURL() {
        return picURL;
    }
    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }
    public String getPicType() {
        return picType;
    }
    public void setPicType(String picType) {
        this.picType = picType;
    }
    public String getVideoType() {
        return videoType;
    }
    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }
    public String getStreamRate() {
        return streamRate;
    }
    public void setStreamRate(String streamRate) {
        this.streamRate = streamRate;
    }
    public String getPSURL() {
        return pSURL;
    }
    public void setPSURL(String pSURL) {
        this.pSURL = pSURL;
    }
    public String getPDetailURL() {
        return pDetailURL;
    }
    public void setPDetailURL(String pDetailURL) {
        this.pDetailURL = pDetailURL;
    }
    public Integer getPShowMode() {
        return pShowMode;
    }
    public void setPShowMode(Integer pShowMode) {
        this.pShowMode = pShowMode;
    }
    public Long getPX() {
        return pX;
    }
    public void setPX(Long pX) {
        this.pX = pX;
    }
    public Long getPY() {
        return pY;
    }
    public void setPY(Long pY) {
        this.pY = pY;
    }
    public Long getPW() {
        return pW;
    }
    public void setPW(Long pW) {
        this.pW = pW;
    }
    public Long getPH() {
        return pH;
    }
    public void setPH(Long pH) {
        this.pH = pH;
    }
    public Integer getPSt() {
        return pSt;
    }
    public void setPSt(Integer pSt) {
        this.pSt = pSt;
    }
    public String getTTitle() {
        return tTitle;
    }
    public void setTTitle(String tTitle) {
        this.tTitle = tTitle;
    }
    public String getTSize() {
        return tSize;
    }
    public void setTSize(String tSize) {
        this.tSize = tSize;
    }
    public String getTStyle() {
        return tStyle;
    }
    public void setTStyle(String tStyle) {
        this.tStyle = tStyle;
    }
    public String getTDescription() {
        return tDescription;
    }
    public void setTDescription(String tDescription) {
        this.tDescription = tDescription;
    }
    public String getTFontColor() {
        return tFontColor;
    }
    public void setTFontColor(String tFontColor) {
        this.tFontColor = tFontColor;
    }
    public String getTContentColor() {
        return tContentColor;
    }
    public void setTContentColor(String tContentColor) {
        this.tContentColor = tContentColor;
    }
    public String getTBackColor() {
        return tBackColor;
    }
    public void setTBackColor(String tBackColor) {
        this.tBackColor = tBackColor;
    }
    public String getTPellucidity() {
        return tPellucidity;
    }
    public void setTPellucidity(String tPellucidity) {
        this.tPellucidity = tPellucidity;
    }
    public Integer getIsMarquee() {
        return isMarquee;
    }
    public void setIsMarquee(Integer isMarquee) {
        this.isMarquee = isMarquee;
    }
    public Long getMDir() {
        return mDir;
    }
    public void setMDir(Long mDir) {
        this.mDir = mDir;
    }
    public Integer getMBack() {
        return mBack;
    }
    public void setMBack(Integer mBack) {
        this.mBack = mBack;
    }
    public String getMBackColor() {
        return mBackColor;
    }
    public void setMBackColor(String mBackColor) {
        this.mBackColor = mBackColor;
    }
    public String getMSpeed() {
        return mSpeed;
    }
    public void setMSpeed(String mSpeed) {
        this.mSpeed = mSpeed;
    }
    public String getAssetID() {
        return assetID;
    }
    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }
    public Long getDuration() {
        return duration;
    }
    public void setDuration(Long duration) {
        this.duration = duration;
    }
    public Integer getSequence() {
        return sequence;
    }
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
    public String getContentID() {
        return contentID;
    }
    public void setContentID(String contentID) {
        this.contentID = contentID;
    }
    public String getMd5() {
        return md5;
    }
    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Override
    public String toString() {
        
        return JSON.toJSONString(this);
    }

    @Override
    public int compareTo(Object o) {
        AdWebEntity entity = (AdWebEntity) o;
        if(this.adType>entity.getAdType()){
            return -1;
        }
        return 0;
    }
        
}
    
