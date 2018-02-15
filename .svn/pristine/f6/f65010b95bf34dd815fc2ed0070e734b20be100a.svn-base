package cn.rojao.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.rojao.annotation.ServiceExporter;
import cn.rojao.netty.HttpNettyServer;
import cn.rojao.redis.pojo.PositionRedis;

@Service("ehcacheUtil")
public class EhcacheUtil {

	private static final Logger logger = LoggerFactory.getLogger(EhcacheUtil.class);

	
	@CacheEvict(value="schedule",key="'sc_'+#message")
    public String delExtendsPositionCache(String message){
		logger.debug("清除外部广告位["+message+"]的缓存！");
    	return null;
    }
	
	@CacheEvict(value="user",key="'us_'+#message")
	public String delUserCache(String message){
		logger.debug("清除用户["+message+"]的缓存！");
    	return null;
	}
	
	@CacheEvict(value="schedule",key="'type_'+#advType+#subAdvType")	
	public String delAdvTypeCache(String advType, String subAdvType){
		logger.debug("清除广告位类型["+advType+"]["+subAdvType+"]的缓存！");
    	return null;
	}
	
	@CacheEvict(value="positionType",key="'type_'+#advType+#subAdvType")	
	public String delPositionTypeCache(String advType, String subAdvType){
		logger.debug("清除广告位类型["+advType+"]["+subAdvType+"]的缓存！");
    	return null;
	}
	
	
	@CacheEvict(value="sonType",key="'sub_'+#advType+#subType")	
	public String delSonTypeCache(String advType, String subType){
		logger.debug("清除子类型["+advType+"]["+subType+"]的缓存！");
    	return null;
	}
	
	@CacheEvict(value="material",key="'ma_'+#materials")	
	public String dealMaterialCache(String materials){
		logger.debug("清除投放素材["+materials+"]的缓存！");
    	return null;
	}
	
	@CacheEvict(value="templet",key="'te_'+#templetCode")	
	public String dealTempletCache(String templetCode){
		logger.debug("清除模板["+templetCode+"]的缓存！");
    	return null;
	}
	
    @CacheEvict(value="network",key="'net_'+#message")
    public String delNetworkCache(String message){
        logger.debug("清除网络["+message+"]的缓存！");
        return null;
    }

    @CacheEvict(value="region",key="'reg_'+#message")
    public String delRegionCache(String message){
        logger.debug("清除区域["+message+"]的缓存！");
        return null;
    }

    @CacheEvict(value="sonRegion",key="'srg_'+#message")
    public String delSonRegionCache(String message){
        logger.debug("清除上下级区域["+message+"]的缓存！");
        return null;
    }

    @CacheEvict(value="userData",key="'uData_'+#id+'_'+#clientId")
    public String dealUserDataCache(String message){
        logger.debug("清除用户数据["+message+"]的缓存！");
        return null;
    }
	
    @CacheEvict(value="systemParameter",key="'sysPara_'+#message")
    public String dealSysParameterCache(String message){
        logger.debug("清除系统参数数据["+message+"]的缓存！");
        return null;
    }
    @CacheEvict(value="proList",key="'prolist_'+#message")
    public String dealProgramListCache(String message){
        logger.debug("清除epg节目["+message+"]的缓存！");
        return null;
    }
	
    @Cacheable(value="program",key="'program_'+#message")
    public String dealProgramCache(String message){
        logger.debug("清除内容["+message+"]的缓存！");
        return null;
    }

    @Cacheable(value="columnList",key="'columnList_'+#message")
    public String dealProgramColumnCache(String message){
        logger.debug("清除内容栏目["+message+"]的缓存！");
        return null;
    }
    
}
