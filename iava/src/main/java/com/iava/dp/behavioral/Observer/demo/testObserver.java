package com.iava.dp.behavioral.Observer.demo;

public class testObserver {

	public static void main(String[] args) {
		Heater header = new Heater();
		Display display = new Display();
		Alarm alarm = new Alarm();
		header.addObserver(display);
		display.addObserver(alarm);
		header.boilWater();
	}
}