package cn.rojao.entity;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.rojao.util.StringUtils;

/**
 * 页面广告请求参数接收实体类
 * @author Administrator
 *
 */
public class AdWebREQT {
    private static final Logger logger = LoggerFactory
            .getLogger(AdWebREQT.class);
    //用户卡号
    private String userID;
    //区域码： CA卡的区域编码|网络ID|TSID
    private String areaID;
    //提供商ID
    private String providerID;
    //广告位ID：广告位外部编码，多个用|分隔开
    private String positionID;
    //关联ID
    private String relationID;
    //观看类型（0:直播,1:点播,2:回看,3:时移,4:网页）
    private String serviceType;
    //媒资ID（1.点播情况，此字段为媒资ID。2.回看情况，此字段是节目单ID。3.时移情况，此字段是频道ID。）
    private String assetID;
    //平台类型（1：DVB平台，2：IP视频平台，默认1DVB平台。）
    private String platformCode;
    //客户端类型(客户端类型：1：机顶盒，2：网关3：手机，4：电脑，5：平板电脑，默认为1机顶盒。)
    private String clientType;
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getAreaID() {
        return areaID;
    }
    public void setAreaID(String areaID) {
        this.areaID = areaID;
    }
    public String getProviderID() {
        return providerID;
    }
    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }
    public String getPositionID() {
        return positionID;
    }
    public void setPositionID(String positionID) {
        this.positionID = positionID;
    }
    public String getRelationID() {
        return relationID;
    }
    public void setRelationID(String relationID) {
        this.relationID = relationID;
    }
    public String getServiceType() {
        return serviceType;
    }
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public String getAssetID() {
        return assetID;
    }
    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }
    public String getPlatformCode() {
        return platformCode;
    }
    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }
    public String getClientType() {
        return clientType;
    }
    public void setClientType(String clientType) {
        this.clientType = clientType;
    }
    public String checkRequest(){
        String resultCode = "0";
        if(StringUtils.isEmpty(this.userID)){
            resultCode = "700";
            logger.debug("请求参数错误:userID为空");
            return resultCode;
        }else{
            if(this.userID.length() > 120){
                resultCode = "701";
                logger.debug("请求参数错误:userID长度超过120");
                return resultCode;
            }
        }
        if(StringUtils.isEmpty(this.areaID)){
            resultCode = "700";
            logger.debug("请求参数错误:areaID为空");
            return resultCode;
        }else{
            if(this.areaID.equals("-1") || this.areaID.indexOf("|") == this.areaID.lastIndexOf("|") || this.areaID.length() > 250){
                resultCode = "701";
                logger.debug("请求参数错误:areaID格式错误或长度超过250");
                return resultCode;
            }
        }
        if(StringUtils.isEmpty(this.positionID)){
            resultCode = "700";
            logger.debug("请求参数错误:positionID为空");
            return resultCode;
        }else{
            if(this.positionID.length() > 250){
                resultCode = "701";
                logger.debug("请求参数错误:positionID长度超过250");
                return resultCode;
            }
        }
        if(this.serviceType == null || "".equals(this.serviceType)){
            resultCode = "700";
            logger.debug("请求参数错误:serviceType为空");
            return resultCode;
        }else{
            String[] arr = {"0","1","2","3","4"};
            int result = Arrays.binarySearch(arr, this.serviceType);
            if(result < 0){
                resultCode = "701";
                logger.debug("请求参数错误:serviceType不在规定值中");
                return resultCode;
            }
        }
        if(this.providerID != null && this.providerID.length() > 60){
            resultCode = "701";
            logger.debug("请求参数错误:provider长度超过60");
            return resultCode;
        }
        if(this.assetID != null && this.assetID.length() > 60){
            resultCode = "701";
            logger.debug("请求参数错误:assetID长度超过60");
            return resultCode;
        }
        if(this.platformCode != null && !"".equals(this.platformCode)){
            String[] arr = {"1","2"};
            int result = Arrays.binarySearch(arr, this.platformCode);
            if(result < 0){
                resultCode = "701";
                logger.debug("请求参数错误:platformCode不在规定值中");
                return resultCode;
            }
        }
        if(this.clientType != null && !"".equals(this.clientType)){
            String[] arr = {"1","2","3","4","5"};
            int result = Arrays.binarySearch(arr, this.clientType);
            if(result < 0){
                resultCode = "701";
                logger.debug("请求参数错误:clientType不在规定值中");
                return resultCode;
            }
        }
        return resultCode;
    }
    
}
