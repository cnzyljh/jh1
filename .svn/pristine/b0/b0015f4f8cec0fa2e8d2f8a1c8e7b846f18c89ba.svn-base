package cn.rojao.config;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.rojao.netty.HttpNettyHandler;
import cn.rojao.util.authorize.PjAuthorizeUtil;

/**
 * 
 * @author Administrator
 *
 */
@Component
public class ScheduleCheck {

    private static Logger log = LoggerFactory.getLogger(ScheduleCheck.class);    
    
    public static Long requestCount = 0l;

    public static AtomicInteger reqCount= new AtomicInteger(0);
    
    @Scheduled(fixedDelay = 60000)
    public void scheduleTask(){
        log.info("分发一分钟请求数为：" + reqCount);
        reqCount = new AtomicInteger(0);
    }

}
