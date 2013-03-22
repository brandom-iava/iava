package com.iava.thread.concurrinpractice.sharingobj;

/**
 * NoVisibility
 * <p/>
 * Sharing variables without synchronization
 *
 * @author Brian Goetz and Tim Peierls
 */

public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
      /*  int i=0;
        while(i<10){
        	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	i++;
        	System.out.println("i="+i);
        }*/
        ready = true;
    }
}
