package cn.rojao.annotation;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.rojao.service.ScheduleUtil;


/**
 * 删除数据前，判断是否被关联
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017年3月8日 上午11:07:35
 */
@Aspect
@Component
public class CheckTimeAspect {
	private static final Logger logger = LoggerFactory.getLogger(ScheduleUtil.class);
	
	@Pointcut("@annotation(cn.rojao.annotation.CheckTime)")
	public void logPointCut() { 
		
	}

	@Around("logPointCut()")
	public Object  checkTime(ProceedingJoinPoint  joinPoint) throws Throwable {
		/*	long begin = System.nanoTime();
        long end = System.nanoTime(); 
        logger.error("--"+String.valueOf((end-begin)/1000));*/
		long begin = System.nanoTime();  
        Object o = joinPoint.proceed();    
        long end = System.nanoTime(); 
        logger.error("{}:{}",joinPoint.getSignature().getName(),(end-begin)/1000+"μs");  
        return o;
	}
}


