package com.iava.dp.behavioral.Command;

public class Telecontrol {
	Command slit;
	
	public void setCommand(Command command){
		this.slit = command;
	}
	
	public void buttonPressed(){
		slit.execute();
	}
}

