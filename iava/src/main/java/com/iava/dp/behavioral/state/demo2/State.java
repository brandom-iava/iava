package com.iava.dp.behavioral.state.demo2;

//�����ȴ���һ��State�ӿ�,���е�״̬������ʵ������ӿ�
public interface State {
	public void insertQuarter();
	public void ejectQuarter();
	public void turnCrank();
	public void dispense();
}

