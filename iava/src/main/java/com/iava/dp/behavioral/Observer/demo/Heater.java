package com.iava.dp.behavioral.Observer.demo;
import java.util.Observable;

public class Heater extends Observable {

	private int temperature;

	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public void boilWater() {
		for (int i = 90; i < 100; i++) {
			temperature = i;
			this.setChanged();
			this.notifyObservers();
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
