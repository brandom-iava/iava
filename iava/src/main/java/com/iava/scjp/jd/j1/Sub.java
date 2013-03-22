package com.iava.scjp.jd.j1;
class Super { 
public int i = 0; 
 
public Super(String text) { 
i = 1; 
} 
} 
 
public class Sub extends Super { 
 public Sub(String text) { 
	super(text);
 i = 2; 
 } 
  
 public static void main(String args[]) { 
 Sub sub = new Sub("Hello"); 
 System.out.println(sub.i); 
 } 
 }  