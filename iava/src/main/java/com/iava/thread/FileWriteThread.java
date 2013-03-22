package com.iava.thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileWriteThread extends Thread{
	@Override
	public void run(){
		File file = new File("E:\\tmp\\test.txt");
		try {
			FileOutputStream fileOutput = new FileOutputStream(file);
			BufferedWriter bufWrite = new BufferedWriter(new OutputStreamWriter(fileOutput));
			for(int i=0; i<100;i++){
				System.out.println("start write ...");
				bufWrite.write("fsfsfsdf");
				bufWrite.newLine();
				Thread.sleep(10000);
			}
			bufWrite.close();
			fileOutput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
