package com.iava.dp.behavioral.chain.demo2;

import java.io.IOException;

public class Application { 
	   public void run() throws Exception { 
	       System.out.print("Press any key then return: "); 
	       char c = (char) System.in.read(); 

	       IHandler handler = null; 
	       if (Character.isLetter(c)) {
	         handler = new CharacterHandler(); 
	       }
	       else if (Character.isDigit(c)) {
	          handler = new NumberHandler(); 
	       }
	       else {
	          handler = new SymbolHandler(); 
	       }

	       handler.handle(); 
	   } 

	   public static void main(String[] args) 
	                           throws IOException {
	          Application app = new Application();
	          try {
				app.run();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	   } 
	} 
