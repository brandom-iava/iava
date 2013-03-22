package com.iava.dp.behavioral.chain.demo1;

/**
 * @author ’≈»Ÿª™(ahuaxuan)
 * {@link http://ahuaxuan.javaeye.com}
 * @version $Id$
 */
public class OtherFilter extends BaseFilter {

	public void executeFilter(){
		System.out.println("1---------------do other things in this filter");
		doNextFilter();
		System.out.println("2---------------do other things in this filter");
	}
}
