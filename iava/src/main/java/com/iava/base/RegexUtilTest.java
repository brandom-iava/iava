package com.iava.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtilTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "{\"serviceNbr\":\"18923768\"}";
		
		String matcher = "\\{\"s.*br\":\"18923768\"\\}";
		String matcher1 = "\"serviceNbr\":\"18923768\"";
		System.out.println(find(matcher1,test));
		System.out.println(check(matcher,test));
	}

	/**
	 * 全局匹配则返回true，否则返回false
	 * 
	 * @param Matcher
	 *            匹配规则 text 要比较的字符串
	 */
	public static boolean check(String matcher, String text) {
	    if(matcher==null || text==null){
	        return false;
	    }
	    //匹配规则
		Pattern p = Pattern.compile(matcher);
		Matcher m = p.matcher(text);
		return m.matches();
	}
	
	/**
	 * 
	 * @param Matcher
	 *            匹配规则 text 要比较的字符串
	 */
	public static boolean find(String matcher, String text) {
	    if(matcher==null || text==null){
	        return false;
	    }
		//匹配规则
		Pattern p = Pattern.compile(matcher);
		Matcher m = p.matcher(text);
		return m.find();
	}
}
