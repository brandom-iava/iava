package com.iava.dp.behavioral.chain.demo1;

/**
 * @author ÕÅÈÙ»ª(ahuaxuan)
 * {@link http://ahuaxuan.javaeye.com}
 * @version $Id$
 */
public class AuthFilter extends BaseFilter {

	public void executeFilter(){
		System.out.println("1------------check the user in this filter!");
		doNextFilter();
		System.out.println("2------------check the user in this filter!");
	}
}
