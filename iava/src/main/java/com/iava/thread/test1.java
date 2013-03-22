package com.iava.thread;

/**
 * 写出magic方法 让整个程序只打印出step1,step2 不打印step3  
 * @author wubp
 */
public class test1 { 

	public static void enter(Object obj) {
		System.out.println("Step 1");
		try {
			magic1(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Step 2");
		synchronized (obj) {
			System.out.println("Step 3 (never reached here)");
		}
	}

	static void magic1(final Object obj) throws Exception {
		final Thread t = new Thread() {
			public void run() {
				synchronized (this) {
					System.out.println("1");
					synchronized (obj) {
						System.out.println("3");
						try {
							notify();
							join();
							System.out.println("4");
						} catch (InterruptedException e) {
						}
					}

				}

			}
		};
		synchronized (t) {
			System.out.println("2");
			t.start();
			t.wait();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		enter(new Object());
	}

}
