package com.iava.thread;

public class ThreadSynTest {

	public static void main(String args[]){
		final Object obj = new Object();
		
		Thread t1 =new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("t1 runing start!");
				synchronized (obj) {
					
					try {
						Thread.sleep(10*1000);
					} catch (InterruptedException e) {
					}
					
				}
				System.out.println("t1 runing end!");
			}
			
		});
		
		
		Thread t2 =new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("t2 runing start!");
				synchronized (obj) {
					try {
						Thread.sleep(10*1000);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("t2 runing end!");
			}
			
		});
		
		t1.start();
		t2.start();
	}
}
