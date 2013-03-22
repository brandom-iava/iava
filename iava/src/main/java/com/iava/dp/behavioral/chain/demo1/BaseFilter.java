package com.iava.dp.behavioral.chain.demo1;

/**
 * @author ���ٻ�(ahuaxuan)
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
	 * �÷�������ע����һ��filter
	 * @param nextFilter
	 */
	public void setNextFilter(Filter nextFilter) {
		this.nextFilter = nextFilter;
	}
}
