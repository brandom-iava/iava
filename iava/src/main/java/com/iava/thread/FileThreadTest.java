package com.iava.thread;

public class FileThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileWriteThread write = new FileWriteThread();
		FileReaderThread reader = new FileReaderThread();
		
		write.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		reader.start();

	}
}
