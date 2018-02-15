package cn.rojao.redis;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import cn.rojao.entity.ProgramlistRedis;
import cn.rojao.redis.pojo.MaterialRedis;
import cn.rojao.redis.pojo.ProgramRedis;
import cn.rojao.redis.pojo.ScheduleRedis;
import cn.rojao.redis.pojo.UserRedis;
import cn.rojao.redis.service.RedisService;
import cn.rojao.util.AESSecurityUtil;
import cn.rojao.util.HashKey;
import cn.rojao.util.StringUtils;

@Component("redisUtil")
public class RedisUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(RedisUtil.class);
	
	/**用户key前缀**/
	private static final String USER_PREFIX = "u:";
	/**内容key前缀**/
	private static final String CONTENT_PREFIX = "c:";	
	/**广告位key内容前缀**/
	private static final String POSITION_PREFIX = "p:";
	
	private static final String SCHEDULE_PREFIX = "sc:";
	
	private static final String MATERIAL_PREFIX = "material";
	
	private static final String COMPANY_PREFIX = "cpy:";
	
	private static final String INDEX_PREFIX = "ind:";
	
	private static final String TIMES_PREFIX = "times:";
	
	private static final String ADD = "add";
	
	private static final String DEL = "del";
	
    public static final String SET = "set";
	
	public static final String GET = "get";

	private static final String POSITIONTYPE_SCHEDULE = "pt_s:";
	
	private static final String POSITIONTYPE_PARSESTR = "pt_p";
	
	private static final String EXTENDSPOSITION_SCHEDULE = "ep_s:";
	
	private static final String USERDATA = "userData:";
	
	private static final String REGION_PREFIX = "reg_";
	
	private static final String SYSTEM_PREFIX = "s_parer";

	private static final String TEMPLET_PREFIX = "templet:";

	private static final String PROLIST_PREFIX = "prolist:";
	
	private static final String MATERIAL_TIMES_PREFIX = "mTimes:";
	
	private static final String SYSTEM_ADS = "systemAds:";
	
	private static final String PROGRAM_COLUMN = "pg_c:";
	@Autowired
	private RedisService redisService;
	
    /**
     * 获取redis中的系统参数
     * @param paraKey
     * @param paraValue
     */
	@Cacheable(value="systemParameter",key="'sysPara_'+#paraKey")
    public String getSysParameter(String paraKey){
        String paraValue = "";
        String password = "rojao.cn";
        paraValue = (String)redisService.hmGet(SYSTEM_PREFIX, paraKey);
        paraValue = AESSecurityUtil.decrypt(paraValue, password);
        return paraValue;
    }
	
	/**
	 * 根据类型查找符合的投放
	 * @param advType
	 * @param advSubType
	 * @return
	 */
	@Cacheable(value="schedule",key="'type_'+#advType+#advSubType")	
	public List<ScheduleRedis>  getSchedules(String advType, String advSubType){
		String schedules = "";
		List<String> list = new ArrayList<String>();
		String key = POSITIONTYPE_SCHEDULE + advType;
		if(StringUtils.isNotEmpty(advSubType)){
			schedules = (String)redisService.hmGet(key, advSubType);
		}else{
			Set<Object> set = redisService.hmKeySet(key);
			List<Object> oList = redisService.hmultiGet(key, set);
			for(Object object : oList){
				schedules += (String)object;
			}
		}
		if(schedules != null){
			String[] scheduelArray = schedules.split("\\|");
			list = Arrays.asList(scheduelArray);
		}
		List<Object> objectList = findSchedule(list);
		List<ScheduleRedis> scheduleList = new ArrayList<ScheduleRedis>();
		if(objectList != null){
			for(Object object : objectList){
				if(object != null){
					ScheduleRedis redis = JSON.parseObject((String)object,ScheduleRedis.class);
					scheduleList.add(redis);
				}
			}
			
		}
		return scheduleList;	
	}
	
	/**
	 * 根据广告类型查找符合的广告外部编码
	 * @param advType
	 * @param advSubType
	 * @return
	 */
	@Cacheable(value="positionType",key="'type_'+#advType+#advSubType")	
	public Set<String>  getParsestr(String advType , String advSubType){
		String parsestr = "";
		List<String> list = new ArrayList<String>();
		String key = POSITIONTYPE_PARSESTR + advType;
		if(StringUtils.isNotEmpty(advSubType)){
			parsestr = (String)redisService.hmGet(key, advSubType);
		}else{
			Set<Object> set = redisService.hmKeySet(key);
			List<Object> oList = redisService.hmultiGet(key, set);
			for(Object object : oList){
				parsestr += (String)object;
			}
		}
		Set<String> set = new HashSet<String>();
		if(parsestr != null){
			String[] scheduelArray = parsestr.split("\\|");
			list = Arrays.asList(scheduelArray);		
			set.addAll(list);
			set.remove("");
		}
		return set;
		
	}
	
	/**
	 * 获取所有子类型
	 * @param advType
	 * @param advSubType
	 * @return
	 */
	@Cacheable(value="sonType",key="'sub_'+#advType+#subType")	
	public List<Object> subAdvTypes(String advType, String subType){
		List<Object> subAdvType = new ArrayList<Object>();
		String key = POSITIONTYPE_SCHEDULE + advType;
		if(StringUtils.isNotEmpty(subType)){
			subAdvType.add(subType);
		}else{
			Set<Object> set = redisService.hmKeySet(key);
			subAdvType.addAll(set);
		}
		return subAdvType;
	}
	
	/**
	 * 根据广告位外部编码查询广告位
	 * @param extendsPosition
	 * @return
	 */
	@Cacheable(value="schedule",key="'sc_'+#extendsPosition")	
	public List<ScheduleRedis> getSchedules(String extendsPosition){
		String schedules = "";
		List<String> list = new ArrayList<String>();
		String key = EXTENDSPOSITION_SCHEDULE + extendsPosition;
		schedules = (String)redisService.get(key);
		if(schedules != null){
			String[] scheduelArray = schedules.split("\\|");
			list = Arrays.asList(scheduelArray);
		}
		List<Object> objectList = findSchedule(list);
		List<ScheduleRedis> scheduleList = new ArrayList<ScheduleRedis>();
		if(objectList != null){
			for(Object object : objectList){
				if(object != null){
					ScheduleRedis redis = JSON.parseObject((String)object,ScheduleRedis.class);
					scheduleList.add(redis);
				}
			}
			
		}
		return scheduleList;
	}
	
	/**
	 * 获取排期
	 * @param list
	 * @return
	 */
	public List<Object> findSchedule(List<String> list){
		Set<Object> set = new HashSet<Object>();
		set.addAll(list);
		set.remove("");
		return redisService.hmultiGet(SCHEDULE_PREFIX, set);
	}
	
	/**
	 * 根据用户编码查询用户属性
	 * @param clientId
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	@Cacheable(value="user",key="'us_'+#clientId")
	public UserRedis findUser(String clientId){
		if(StringUtils.isNotEmpty(clientId)){
			String key = "";
			try {
				key = USER_PREFIX + HashKey.getBucketId14(clientId);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			Object user = redisService.hmGet(key, clientId);
			if(user != null){
				return JSON.parseObject((String)user, UserRedis.class);
			}
		}
		return null;
	}
	
	/**
	 * 查询素材内容
	 * @param schedule
	 * @return
	 */
	@Cacheable(value="material",key="'ma_'+#schedule.materials")
	public List<MaterialRedis> findMaterialsRedis(ScheduleRedis schedule){
		List<MaterialRedis> materialList = new ArrayList<MaterialRedis>();
		String key = MATERIAL_PREFIX;
		String materialIds = schedule.getMaterials();
		if(StringUtils.isNotEmpty(materialIds)){
			String[] ids = materialIds.split(",");
			List<String> list = Arrays.asList(ids);
			Set<Object> set = new HashSet<Object>();
			set.addAll(list);
			set.remove("");
			List<Object> objectList = redisService.hmultiGet(key, set);
			if(objectList != null){
				for(Object object : objectList){
					String objectStr = (String)object;
					if(StringUtils.isNotEmpty(objectStr)){
						MaterialRedis material = JSON.parseObject(objectStr, MaterialRedis.class);
						materialList.add(material);
					}
				}
			}
		}
		return materialList;
	}
	
	/**
	 * 通过模板编码查询广告位类型
	 * @param templetCode
	 * @return
	 */
	@Cacheable(value="templet",key="'te_'+#templetCode")
	public String findTempletRedis(String templetCode){
		String key = TEMPLET_PREFIX;
		Object object = redisService.hmGet(key, templetCode);
		return (String)object;

		
	}
	
	/**
	 * 查询素材内容
	 * @param schedule
	 * @return
	 */
	public MaterialRedis findMatalRedis(String scheduleIds){
		//MaterialRedis materialList = new MaterialRedis();
		MaterialRedis material = new MaterialRedis();
		String key = MATERIAL_PREFIX;
		if(StringUtils.isNotEmpty(scheduleIds)){
			String[] ids = scheduleIds.split(",");
			List<String> list = Arrays.asList(ids);
			Set<Object> set = new HashSet<Object>();
			set.addAll(list);
			set.remove("");
			List<Object> objectList = redisService.hmultiGet(key, set);
			if(objectList != null){
				for(Object object : objectList){
					String objectStr = (String)object;
					if(StringUtils.isNotEmpty(objectStr)){
						 material = JSON.parseObject(objectStr, MaterialRedis.class);
						//materialList.add(material);
					}
				}
			}
		}
		return material;
	}
	
	
	/**
	 * 顺序播放时，获取当时用户的播放序列
	 * @return
	 */
	public int getMaterialIndex(String scheduleId, String clientId){
		try{
			String key = INDEX_PREFIX + scheduleId;
			String hashKey = clientId;
			Object object =  redisService.hmGet(key, hashKey);
			if(object != null){
				return Integer.parseInt((String)object);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 顺序播放时，设置当时用户的播放序列
	 * @return
	 */
	public void setMaterialIndex(String scheduleId, String clientId,int index){
		try{
			String key = INDEX_PREFIX + scheduleId;
			String hashKey = clientId;
			redisService.hmSet(key, hashKey, String.valueOf(index));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 创建hashkey
	 * @param timesType
	 * @param clientId
	 * @return
	 */
	public  String createHashKey(Long timesType,String clientId){
		 Calendar ca = Calendar.getInstance();//创建一个日期实例
		 ca.setTime(new Date());//实例化一个日期
		 if(timesType == 0){
			 return "total";
		 }else if(timesType == 1){
			 return "date:"+ca.get(Calendar.DAY_OF_YEAR);
		 }else if(timesType == 2){
			 return "week:"+ca.get(Calendar.WEEK_OF_YEAR);
		 }else if(timesType == 3){
			 return "month:"+ca.get(Calendar.MONTH);
		 }else if(timesType == 4){
			 return clientId;
		 }
		 return null;
	 }
	
	/**
	 * 检查投放次数有效
	 * @param sc
	 * @param clientId
	 */
	public int getCheckTimes(ScheduleRedis sc,String clientId, String opId){
		int times = 0;
		if(sc.getFreqType() != null && sc.getFreqType().longValue() != 0l
				&& sc.getFreqType().longValue() != 4l){
			try{
				synchronized (sc.getTaskId().intern()){
					String key = TIMES_PREFIX + sc.getTaskId();
					String hashKey = createHashKey(sc.getFreqType(), clientId);
					Object object = redisService.hmGet(key, hashKey);
					if(object != null){
						times = Integer.parseInt((String)object);
					}
					if(SET.equals(opId)){
						redisService.hmSet(key, hashKey, String.valueOf(times+1));
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return times;
	 }
	
	/**
	 * 创建针对素材hashkey
	 * @param timesType
	 * @param clientId
	 * @return
	 */
	public  String getHashKey(Long timesType,String clientId, String materialId){
		 Calendar ca = Calendar.getInstance();//创建一个日期实例
		 ca.setTime(new Date());//实例化一个日期
		 if(timesType == 0){
			 return "total_" + materialId;
		 }else if(timesType == 1){
			 return "date:"+ca.get(Calendar.DAY_OF_YEAR) + "_" + materialId;
		 }else if(timesType == 2){
			 return "week:"+ca.get(Calendar.WEEK_OF_YEAR) + "_" + materialId;
		 }else if(timesType == 3){
			 return "month:"+ca.get(Calendar.MONTH) + "_" + materialId;
		 }else if(timesType == 4){
			 return clientId + "_" + materialId;
		 }
		 return null;
	 }
	
   	/**
	 * 针对素材检查按总投放次数以及按用户投放次数
	 * @param sc
	 * @param clientId
	 */
	public int getMaterialCheckTimes(String materialId,String clientId, String opId,ScheduleRedis sc){
		int times = 0;
		try{
			synchronized (materialId.intern()){
				String key = MATERIAL_TIMES_PREFIX + sc.getTaskId();
				//获取相对应频率类型的数据hashKey值
				String hashKey = getHashKey(sc.getFreqType(), clientId, materialId);
				Object object = redisService.hmGet(key, hashKey);
				if(object != null){
					times = Integer.parseInt((String)object);
				}
				if(SET.equals(opId)){
					redisService.hmSet(key, hashKey, String.valueOf(times+1));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return times;
	 }
	
	/**
	 * 获取运营商的区域码
	 * @return
	 */
	public String getCompanyRegion(String companyId){
		String region = "";
		try{
			String key = COMPANY_PREFIX + companyId;
			String hashKey = "regionCode";
			return (String)redisService.hmGet(key, hashKey);
		}catch(Exception e){
			e.printStackTrace();
		}
		return region;
	}
	
	/**
	 * 获取运营商的子区域
	 * @param companyId
	 * @return
	 */
	@Cacheable(value="region",key="'reg_'+#companyId")
	public List<String> getRegionByScheudle(String companyId){	
		try{
			List<String> list = new ArrayList<String>();
			String key = COMPANY_PREFIX + companyId;
			String hashKey = "sonRegion";
			String networkKey = "netWorkId";
			Object network = redisService.hmGet(key, networkKey);
		    Object object = redisService.hmGet(key, hashKey);
		    if(object != null){
		        list.addAll(JSON.parseArray(((String)object), String.class));
		    }
		    Object regionCode = redisService.hmGet(key, "regionCode");
		    if(regionCode != null){
		        list.add((String)regionCode);
		    }			    
			return list;
		}catch(Exception e){
		    e.printStackTrace();
		}
		return null;
	}
    /**
     * 获取运营商的网络ID
     * @param companyId
     * @return
     */
	@Cacheable(value="network",key="'net_'+#companyId")
    public List<String> getNetworkByScheudle(String companyId){  
        try{
            List<String> list = new ArrayList<String>();
            String key = COMPANY_PREFIX + companyId;
            String networkKey = "netWorkId";
            Object network = redisService.hmGet(key, networkKey);
            if(network != null){
                list.add((String)network);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
	
	/**
	 * 根据资产ID获取资产信息
	 * @param assetId
	 * @return
	 */
	@Cacheable(value="program",key="'program_'+#assetId")
	public ProgramRedis getProgram(String assetId){
		try{
			String key = CONTENT_PREFIX + HashKey.getBucketId14(assetId);
			String hashKey= assetId;
			Object object = redisService.hmGet(key, hashKey);
			if(object != null){
				ProgramRedis program = JSON.parseObject((String)object, ProgramRedis.class);
				return program;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据ID获取用户数据内容
	 * @return
	 */
	@Cacheable(value="userData",key="'uData_'+#id+'_'+#clientId")
	public String getUserData(String id,String clientId){
	    String userData = "";
	    String key = USERDATA + id;
	    Object object = redisService.hmGet(key, clientId);
	    if(object != null){
	        userData=object.toString();
	    }
	    return userData;
	}
	
    /**
     * 获取区域的子区域
     * @param companyId
     * @return
     */
	@Cacheable(value="sonRegion",key="'srg_'+#regionCode")
    public List<String> getSonRegion(String regionCode){  
        try{
            List<String> list = new ArrayList<String>();
            String key = REGION_PREFIX + regionCode;
            if(redisService.get(key)!=null){
                String sonRegion = (String)redisService.get(key);
                String[] sonRegions = sonRegion.split("\\|");
                List<String> sonRegionList = new ArrayList<>();
                for(String son : sonRegions){
                    if(StringUtils.isNotEmpty(son)){
                        sonRegionList.add(son);
                    }
                }
                list.addAll(sonRegionList);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取epg节目redis
     * @param programId
     * 
     */
	@Cacheable(value="proList",key="'prolist_'+#contentId")
    public ProgramlistRedis getProList(String contentId){
        try{
            String key = PROLIST_PREFIX;
            String hashKey = String.valueOf(contentId);
            Object object = redisService.hmGet(key, hashKey);
            if(object != null){
                ProgramlistRedis programlistRedis = JSON.parseObject((String)object, ProgramlistRedis.class);
                return programlistRedis;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
	
	/**
	 * 获取redis中的授权分发地址
	 * @return
	 */
	public String getAuthoAds(){
		String key = SYSTEM_ADS;
		Object obj = redisService.get(key);
		if(obj != null){
			return obj.toString();
		}
		return "";
	}
	
	/**
	 * 设置redis中的授权分发地址
	 * @return
	 */
	public void setAuthoAds(String urls){
		String key = SYSTEM_ADS;
		redisService.set(key, urls);
	}
	
	/**
	 * 获取内容与栏目的关联关系
	 * @param assetId
	 * @param entity
	 * @param opId
	 */
	@Cacheable(value="columnList",key="'columnList_'+#vodId")
	public Set<String> getProgramColumn(String vodId){
		Set<String> columnIdSet = new HashSet<String>();
		try{
			String key = PROGRAM_COLUMN;
			Object columnsObj = redisService.hmGet(key, vodId);
			if(columnsObj != null){
				String columnIdsStr = "";
				columnIdsStr = (String)columnsObj;
				String[] columnIds = columnIdsStr.split("\\|");
				for(String columnId : columnIds){
					columnIdSet.add(columnId);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return columnIdSet;
	}
	
}
