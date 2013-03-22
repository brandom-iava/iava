package com.iava.thread;

public class ThreadTest extends Thread{

	@Override
	public void run() {
		System.out.println("runing thread!");
	}

	public static void main(String args[]){
		Thread t = new ThreadTest();
		t.run();
		t.run();
		t.start();
	}
}
