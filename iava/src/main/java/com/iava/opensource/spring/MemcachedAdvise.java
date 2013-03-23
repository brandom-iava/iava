package com.iava.opensource.spring;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MemcachedAdvise {

	private static final Log logger = LogFactory
			.getLog(MemcachedAdvise.class);

	//private CacheHandler cacheHandler;

	private  long expireTime = 60000 *5;//默认缓存5分钟
	/*public CacheHandler getCacheHandler() {
		return cacheHandler;
	}

	public void setCacheHandler(CacheHandler cacheHandler) {
		this.cacheHandler = cacheHandler;
	}*/
	
	@Pointcut("@annotation(com.iava.cache.Memcached)")
	public void memcacheGet(){
		
	}
	
	@Around("memcacheGet()")
	public Object memcacheGetQuery(ProceedingJoinPoint pjp) throws Throwable{
		pjp.proceed();
		
		pjp.getTarget();
		MethodInvocation invocation = null;
		String targetName = invocation.getThis().getClass().getName();
		String methodName = invocation.getMethod().getName();
		Object[] arguments = invocation.getArguments();
		
		String cacheKey = getCacheKey(targetName, methodName, arguments);
		Object element = /*getCacheHandler().get(cacheKey)*/null;
		if(logger.isDebugEnabled()){
			logger.debug("++++++++++++ interceptor method:"+methodName);
		}
		if (element == null) {/*
			Object result = invocation.proceed();
			element = result;
			if(!NullUtil.isNull(result)){
				long expireTime ;
				if( this.getExpireTime() != 0 ){
					expireTime = 	this.getExpireTime();
				}else{
					expireTime = getCacheHandler().getExpireTime();
				}
				
				
				boolean f = getCacheHandler().set(cacheKey, result,expireTime);
				if(logger.isDebugEnabled()){
					logger.debug("set the obj["+element+"] to the memcached with key:"+cacheKey+".set state:"+f);
					logger.debug("expireTime:"+expireTime);
				}
			}
		*/}else{
			if(logger.isDebugEnabled()){
				logger.debug("Get the obj["+element+"] from the memcached with key:"+cacheKey);
			}
		}

		return element;
	}
	
	/**
	 * 获得cache key的方法，cache key是Cache中一个Element的唯一标识 cache key包括
	 * 包名+类名+方法名，如com.co.cache.service.UserServiceImpl.getAllUser
	 */
	private String getCacheKey(String targetName, String methodName,
			Object[] arguments) {/*
		StringBuffer sb = new StringBuffer();
		sb.append(targetName).append(".").append(methodName);
		if ((arguments != null) && (arguments.length != 0)) {
			for (int i = 0; i < arguments.length; i++) {
				sb.append(".").append(arguments[i].toString());//把对象的toString作为该参数的标识
			}
		}
		if(logger.isDebugEnabled()){
			logger.debug("cache key:"+sb.toString());
		}
		
		return MD5.hash(sb.toString());
	*/return null;}

	public long getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(long expireTime) {
		this.expireTime = expireTime;
	}
	
}
