package com.iava.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD})
public @interface Memcached {

	/**
	 * 缓存过期时间 默认5分钟
	 * @return
	 */
	public long expireTime() default 300000 ;
}
