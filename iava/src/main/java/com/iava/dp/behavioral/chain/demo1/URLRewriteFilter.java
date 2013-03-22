package com.iava.dp.behavioral.chain.demo1;

/**
 * @author ’≈»Ÿª™(ahuaxuan)
 * {@link http://ahuaxuan.javaeye.com}
 * @version $Id$
 */
public class URLRewriteFilter extends BaseFilter {

	public void executeFilter(){
		System.out.println("1------------do url rewrite in this filter");
		doNextFilter();
		System.out.println("2------------do url rewrite in this filter");
	}
}
