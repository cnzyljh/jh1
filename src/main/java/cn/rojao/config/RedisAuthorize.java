package cn.rojao.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.rojao.netty.HttpNettyHandler;
import cn.rojao.redis.RedisUtil;
import cn.rojao.util.AESSecurityUtil;
import cn.rojao.util.StringUtils;

/**
 * 分发启动时判断redis是否含有该服务器地址
 * @author Administrator
 *
 */
@Component
public class RedisAuthorize {
	static Logger logger = LoggerFactory.getLogger(RedisAuthorize.class);
	
	@Autowired
	RedisUtil redisUtil;
	
	@Scheduled(fixedDelay = 300000)
	public void checkAddress(){
		try {
			String passKey = "rojao.cn";
			
			InetAddress address = InetAddress.getLocalHost();
			String ip = address.getHostAddress();
			String adsAddress = redisUtil.getAuthoAds();
			boolean notAuthorize = true;
			if(StringUtils.isNotEmpty(adsAddress)){
				adsAddress = AESSecurityUtil.decrypt(adsAddress, passKey);
				String[] addrs = adsAddress.split(",");
				
				for(String addr : addrs){
					if(ip.equals(addr)){
						notAuthorize = false;
						break;
					}
				}
			}
			if(notAuthorize){
				logger.info("没有授权的服务器地址：" + ip);
				logger.info("启动失败，请联系如加网络技术工程师");
				//System.exit(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
