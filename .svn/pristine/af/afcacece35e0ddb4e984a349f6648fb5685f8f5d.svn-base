package cn.rojao.redis.msg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rojao.redis.EhcacheUtil;
import cn.rojao.util.StringUtils;

@Service("receiver")
public class Receiver {
	
	@Autowired
	public EhcacheUtil ehcacheUtil;
	
    /**
     * 清除外部广告位本地缓存
     * @param message
     */
    public  void dealExtendsPositionCache(String message){
    	if(StringUtils.isNotEmpty(message)&&message.length()>2){
    		message = message.substring(1,message.length()-1);
    		ehcacheUtil.delExtendsPositionCache(message);
    	}
    }
    
    /**
     * 清除广告位类型本地缓存
     * @param message
     */
    public void dealAdvTypeCache(String message){
    	if(StringUtils.isNotEmpty(message)&&message.length()>2){
    		message = message.substring(1,message.length()-1);
    		String[] types = message.split("_");
    		ehcacheUtil.delAdvTypeCache(types[0],types[1]);
    		ehcacheUtil.delAdvTypeCache(types[0],null);
    		ehcacheUtil.delSonTypeCache(types[0],types[1]);
    		ehcacheUtil.delSonTypeCache(types[0],null);
    	}
    }
    
    /**
     * 清除广告位类型本地缓存
     * @param message
     */
    public void dealPositionTypeCache(String message){
    	if(StringUtils.isNotEmpty(message)&&message.length()>2){
    		message = message.substring(1,message.length()-1);
    		String[] types = message.split("_");
    		ehcacheUtil.delPositionTypeCache(types[0],types[1]);
    		ehcacheUtil.delPositionTypeCache(types[0],null);
    		ehcacheUtil.delSonTypeCache(types[0],types[1]);
    		ehcacheUtil.delSonTypeCache(types[0],null);
    	}
    }
    
    /**
     * 清除用户本地缓存
     * @param message
     */
    public void dealUserCache(String message){
    	if(StringUtils.isNotEmpty(message)&&message.length()>2){
    		message = message.substring(1,message.length()-1);
    		ehcacheUtil.delUserCache(message);
    	}
    }
    
    /**
     * 清除投放素材本地缓存
     * @param message
     */
    public void dealMaterialCache(String message){
    	if(StringUtils.isNotEmpty(message)&&message.length()>2){
    		message = message.substring(1,message.length()-1);
    		ehcacheUtil.dealMaterialCache(message);
    	}
    }
    
    /**
     * 清除模板本地缓存
     * @param message
     */
    public void dealTempletCache(String message){
    	if(StringUtils.isNotEmpty(message)&&message.length()>2){
    		message = message.substring(1,message.length()-1);
    		ehcacheUtil.dealTempletCache(message);
    	}
    }
    
    /**
     * 清除网络本地缓存
     * @param message
     */
    public void dealNetworkCache(String message){
        if(StringUtils.isNotEmpty(message)&&message.length()>2){
            message = message.substring(1,message.length()-1);
            ehcacheUtil.delNetworkCache(message);
        }
    }

    /**
     * 清除区域本地缓存
     * @param message
     */
    public void dealRegionCache(String message){
        if(StringUtils.isNotEmpty(message)&&message.length()>2){
            message = message.substring(1,message.length()-1);
            ehcacheUtil.delRegionCache(message);
        }
    }

    /**
     * 清除上下级区域本地缓存
     * @param message
     */
    public void dealSonRegionCache(String message){
        if(StringUtils.isNotEmpty(message)&&message.length()>2){
            message = message.substring(1,message.length()-1);
            ehcacheUtil.delSonRegionCache(message);
        }
    }

    /**
     * 清除用户数据本地缓存
     * @param message
     */
    public void dealUserDataCache(String message){
        if(StringUtils.isNotEmpty(message)&&message.length()>2){
            message = message.substring(1,message.length()-1);
            ehcacheUtil.dealUserDataCache(message);
        }
    }
	
    /**
     * 清除系统参数本地缓存
     * @param message
     */
    public void dealSysParameterCache(String message){
        if(StringUtils.isNotEmpty(message)&&message.length()>2){
            message = message.substring(1,message.length()-1);
            ehcacheUtil.dealSysParameterCache(message);
        }
    }   
    /**
     * 清除epg节目本地缓存
     * @param message
     */
    public void dealProgramListCache(String message){
        if(StringUtils.isNotEmpty(message)&&message.length()>2){
            message = message.substring(1,message.length()-1);
            ehcacheUtil.dealProgramListCache(message);
        }
    }

    
    /**
     * 清除内容本地缓存
     * @param message
     */
    public void dealProgramCache(String message){
        if(StringUtils.isNotEmpty(message)&&message.length()>2){
            message = message.substring(1,message.length()-1);
            ehcacheUtil.dealProgramCache(message);
        }
    }
    
    /**
     * 清除内容栏目本地缓存
     * @param message
     */
    public void dealProgramColumnCache(String message){
        if(StringUtils.isNotEmpty(message)&&message.length()>2){
            message = message.substring(1,message.length()-1);
            ehcacheUtil.dealProgramColumnCache(message);
        }
    }

}
