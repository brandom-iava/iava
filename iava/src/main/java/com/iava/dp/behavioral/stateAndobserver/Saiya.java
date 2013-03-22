package com.iava.dp.behavioral.stateAndobserver;

import java.util.Observable;

public class Saiya extends Observable {
	//������ʸ������״̬
	public final SaiyaState NORMAL = new NormalState(this);

	public final SaiyaState DYING = new DyingState(this);

	public final SaiyaState GODDESS = new GoddessState(this);

	public final SaiyaState UNIVERSE = new UniverseState(this);
	
	private SaiyaState state=NORMAL;
	
	private SaiyaState laststate=null;
	
	public void hit(){
		//���õ�ǰ״̬�ı��򷽷� �������ı��Լ���״̬
		state.hit();
	}
	public String status(){
		//��ǰ״̬��
		return state.status();
	}
	
	protected void setState(SaiyaState state){
		laststate=this.state;
		this.state=state;
		//�۲���ģʽ
		setChanged();
		notifyObservers("��ʸ״̬�仯");
	}
	
	public String getlastStatus(){
		return laststate.status();
	}
}
