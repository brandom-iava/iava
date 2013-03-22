package com.iava.dp.behavioral.stateAndobserver;

public abstract class SaiyaState {
	protected Saiya saiya;

	public SaiyaState(Saiya saiya) {
		this.saiya = saiya;
	}
	
	public String status(){
		String name=getClass().getName();
		return name.substring(name.lastIndexOf(".")+1);
	}
	//–« ∏±ª¥Ú¡À
	public abstract void hit();
}

