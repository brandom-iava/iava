package com.iava.dp.behavioral.Command;

public class LightOffCommand implements Command{
	private Light light;
	
	public LightOffCommand(Light light){
		this.light = light;
	}
	
	public void execute() {
		light.off();
	}
}
