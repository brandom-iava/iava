package com.iava.thread;

public class IncreAnddecrThread {
	public int i=0;
	 class IncreThread extends Thread
	{
		 
		public void run()
		{
			while(true)
			{
				if(i==1000)
					break;
				i++;
				System.out.println(i);
			}
		}
	}
	 class DecreThread extends Thread
	{
		public void run()
		{
			while(true)
			{
				if(i==0)
					break;
				if(i>0)
					i--;
				System.out.println(i);
			}
		}
	}
public static void main(String[] args)
{
	IncreAnddecrThread increAnddecrThread=new IncreAnddecrThread();
	IncreThread incre=increAnddecrThread.new IncreThread();
	   incre.start();
	DecreThread decre=increAnddecrThread.new DecreThread();
	   decre.start();
}
}
