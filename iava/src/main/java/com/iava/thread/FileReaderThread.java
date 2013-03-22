package com.iava.thread;

import java.util.Calendar;
import java.util.Date;

public class FileReaderThread extends Thread{

	@Override
	public void run(){
		/*File file = new File("E:\\tmp\\test.txt");
		try {
			FileInputStream fileInput = new FileInputStream(file);
			BufferedReader bufReader = new BufferedReader(new InputStreamReader(fileInput));
			String tmp = null;
			System.out.println("enter reader ...");
			int i=0;
			while((tmp = bufReader.readLine()) != null || i<50){
				System.out.println(tmp);
				Thread.sleep(1000);
				i++;
			}
			bufReader.close();
			fileInput.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		Date now = new Date();
		Calendar calend = Calendar.getInstance();
		calend.set(Calendar.MONTH, -2);
		calend.set(Calendar.DAY_OF_MONTH, 1);
		
		System.out.println(calend.getTime());
	}
}
