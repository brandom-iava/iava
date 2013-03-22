package com.iava.dp.behavioral.chain.demo1;

/**
 * @author 张荣华(ahuaxuan)
 * {@link http://ahuaxuan.javaeye.com}
 * @version $Id$
 */
public abstract class BaseFilter implements Filter {
	
	private Filter nextFilter;

	public void doNextFilter(){
		if (nextFilter != null) {
			nextFilter.executeFilter();
		} else {
			// do something you need here!
			System.out.println("there is no filter in the chain!!!!!!!!");
		}
	}

	/**
	 * 该方法用来注入下一个filter
	 * @param nextFilter
	 */
	public void setNextFilter(Filter nextFilter) {
		this.nextFilter = nextFilter;
	}
}
