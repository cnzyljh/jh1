package cn.rojao.redis;

import org.apache.commons.lang.StringUtils;

import cn.rojao.entity.AdvREQT;
import cn.rojao.entity.InfoREQT;
import cn.rojao.redis.pojo.ScheduleRedis;

	
public class ScheduleCoding {
	private static Long companyCode = 1L;
	private static Long regionCode = 1L<<1;
	private static Long systemIdCode = 1L<<2;
	private static Long channelCode = 1L<<3;
	private static Long providerCode = 1L<<4;
	private static Long programTypeCode = 1L<<5;
	private static Long columnCode = 1L<<6;
	private static Long resolutionCode = 1L<<7;//分辨率
	private static Long keyWordsCode = 1L<<8;
	private static Long deviceCode = 1L<<9;
	private static Long terminalsCode = 1L<<10;
	private static Long FeatureCode = 1L<<11;//
	private static Long userGroupCode = 1L<<12;
	private static Long parentAssetIdCode = 1L<<13;//父资产
	private static Long assetIdCode = 1L<<14;
	
	/**
	 * 计算排期的编码值
	 * @param scheduleRedis
	 * @return
	 */
	public static Long getScheduleCode(ScheduleRedis scheduleRedis){
		Long code = 0L;
		if(scheduleRedis.getAreas()!= null){
			code += regionCode;
		}
		if(scheduleRedis.getChannels() != null){
			code += channelCode;
		}
		if(scheduleRedis.getProvides() != null){
			code += providerCode;
		}
		if(scheduleRedis.getGenres() != null){//排期关联分类
			code += programTypeCode;
		}
		if(scheduleRedis.getCatagorys() != null){
			code += columnCode;
		}
		if(StringUtils.isNotEmpty(scheduleRedis.getKeys())){
			code += keyWordsCode;
		}
		if(scheduleRedis.getTerminals()!= null){
			code += deviceCode;
		}
		if(scheduleRedis.getFeatures() != null){
			code += FeatureCode;
		}
		if(scheduleRedis.getUserGroups()!=null){
			code += userGroupCode;
		}
		return code;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Long getAdvREQTCode(AdvREQT advReqt){
		Long code = 0L;
		if(advReqt.getClientId() != null){
			code += regionCode;
			code += userGroupCode;
			code += FeatureCode;
		}
		if(advReqt.getProviderId()!=null){
			code += providerCode;
		}
		if(advReqt.getContentId()!=null){
			code += assetIdCode;
			code += programTypeCode;
			code += keyWordsCode;
		}
		if(advReqt.getChannelId()!=null){
			code += channelCode;
		}else{
			if(advReqt.getContentId()!=null){
				code += channelCode;
			}
		}
		if(advReqt.getCatagoryId()!=null){
			code += columnCode;
		}else{
			if(advReqt.getContentId()!=null){
				code += columnCode;
			}
		}
		if(advReqt.getDeviceType()!= null){
		    code += deviceCode;
		}
		return code;
	}
			
	
    /**
     * 
     * @return
     */
    public static Long getInfoREQTCode(InfoREQT infoReqt){
        Long code = 0L;
        if(infoReqt.getClientId() != null){
            code += regionCode;
            code += userGroupCode;
            code += FeatureCode;
        }
        if(infoReqt.getProviderId()!=null){
            code += providerCode;
        }
        if(infoReqt.getContentId()!=null){
            code += assetIdCode;
            code += programTypeCode;
        }
        if(infoReqt.getChannelId()!=null){
            code += channelCode;
        }
        if(infoReqt.getCatagoryId()!=null){
            code += columnCode;
        }
        if(infoReqt.getDeviceType()!= null){
            code += deviceCode;
        }
        return code;
    }

}
