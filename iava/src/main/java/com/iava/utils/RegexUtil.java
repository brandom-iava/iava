package com.iava.utils;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 正则表达式工具
 * 
 * @author wubp
 * 
 */
public final class RegexUtil {

	private static final Log log = LogFactory.getLog(RegexUtil.class);
	
	private static final int DEFAULT_PATTERN = 0;

	/** 匹配 */
	private static final int CHECK_CMD = 1;

	/** 查找 */
	private static final int FIND_CMD = 2;

	/**
	 * 全匹配则返回true，否则返回false
	 * 
	 * @param matcher
	 *            匹配规则
	 * @param text
	 *            要比较的字符串
	 * @return 匹配为true，否则为false
	 */
	public static boolean check(String matcher, String text) {
		return cover(matcher, text, CHECK_CMD, DEFAULT_PATTERN);
	}
	
	/**
	 * 在text中查找是否有符合规则的字符,区别大小写
	 * 
	 * @param matcher
	 *            匹配规则
	 * @param text
	 *            要比较的字符串
	 * @return 找到为true,否则为false
	 */
	public static boolean find(String matcher, String text) {
		return cover(matcher, text, FIND_CMD, DEFAULT_PATTERN);
	}

	/**
	 * 在text中查找是否有符合规则的字符,不区别大小写
	 * 
	 * @param matcher
	 *            匹配规则
	 * @param text
	 *            要比较的字符串
	 * @return 找到为true,否则为false
	 */
	public static boolean findIgnoreCase(String matcher, String text) {
		return cover(matcher, text, FIND_CMD, Pattern.CASE_INSENSITIVE);
	}

	/**
	 * 
	 * @param matcher
	 *            规则
	 * @param text
	 *            要检验的字串
	 * @param cmd
	 *            命令，1为全匹配 2为查找
	 * @param flags
	 *            Match flags, a bit mask that may include CASE_INSENSITIVE,
	 *            MULTILINE, DOTALL, UNICODE_CASE, CANON_EQ, UNIX_LINES, LITERAL
	 *            and COMMENTS
	 * @return 匹配或找到返回true,否则返回false
	 */
	private static boolean cover(String matcher, String text, int cmd, int flags) {
		boolean flag = false;
		if (NullUtil.isNull(matcher, text)) {
			return flag;
		}
		Pattern p = Pattern.compile(matcher, flags);
		Matcher m = p.matcher(text);
		switch (cmd) {
		case 1:
			flag = m.matches();break;
		case 2:
			flag = m.find();break;
		}

		if (log.isDebugEnabled()) {
			log.debug("RegexUtil#"+(cmd==1?"check":"find")+"().matcher:[" + matcher + "] text:["
					+ text + "] flag:[" + flag + "]");
		}
		return flag;
	}
	
	/**
	 * 在text中查找是否有符合规则的字符,区别大小写
	 * 
	 * @param matcher
	 *            匹配规则
	 * @param text
	 *            要比较的字符串
	 * @return 找到为true,否则为false
	 */
	public static String get(String matcher, String text) {
		return get(matcher, text, FIND_CMD, DEFAULT_PATTERN);
	}

	/**
	 * 
	 * @param matcher
	 *            规则
	 * @param text
	 *            要检验的字串
	 * @param cmd
	 *            命令，1为全匹配 2为查找
	 * @param flags
	 *            Match flags, a bit mask that may include CASE_INSENSITIVE,
	 *            MULTILINE, DOTALL, UNICODE_CASE, CANON_EQ, UNIX_LINES, LITERAL
	 *            and COMMENTS
	 * @return 匹配或找到返回true,否则返回false
	 */
	private static boolean find(String matcher, String text, int cmd, int flags) {
		boolean flag = false;
		if (NullUtil.isNull(matcher, text)) {
			return flag;
		}
		Pattern p = Pattern.compile(matcher, flags);
		Matcher m = p.matcher(text);
		switch (cmd) {
		case 1:
			flag = m.matches();break;
		case 2:
			flag = m.find();break;
		}

		if (log.isDebugEnabled()) {
			log.debug("RegexUtil#"+(cmd==1?"check":"find")+"().matcher:[" + matcher + "] text:["
					+ text + "] flag:[" + flag + "]");
		}
		return flag;
	}
	
	/**
	 * 
	 * @param matcher
	 *            规则
	 * @param text
	 *            要检验的字串
	 * @param cmd
	 *            命令，1为全匹配 2为查找
	 * @param flags
	 *            Match flags, a bit mask that may include CASE_INSENSITIVE,
	 *            MULTILINE, DOTALL, UNICODE_CASE, CANON_EQ, UNIX_LINES, LITERAL
	 *            and COMMENTS
	 * @return 找到的字符串
	 */
	private static String get(String matcher, String text, int cmd, int flags) {
		String result = null;
		boolean flag = false;
		if (NullUtil.isNull(matcher, text)) {
			return result;
		}
		Pattern p = Pattern.compile(matcher, flags);
		Matcher m = p.matcher(text);
		switch (cmd) {
		case 1:
			flag = m.matches();break;
		case 2:
			flag = m.find();break;
		}

		if (log.isDebugEnabled()) {
			log.debug("RegexUtil#"+(cmd==1?"check":"find")+"().matcher:[" + matcher + "] text:["
					+ text + "] flag:[" + flag + "]");
		}
		
		if(flag){
			result = text.substring(m.start(),m.end());
		}
		return result;
	}
	
	public static void main(String args[]){
		System.out.println(get("[\\w-]+\\.(com|net|org|gov|cc|biz|info|cn|co)(\\.(cn|hk|uk))*","www.sina.com.cn"));
	}
}