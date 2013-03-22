package com.iava.dp.behavioral.state.demo2;

//售出糖果
 public class SoldState implements State {  
	     GumballMachine gumballMachine;  
	     public SoldState(GumballMachine gumballMachine) {  
	         this.gumballMachine = gumballMachine;  
	     }      
	     //以下3个方法对此状态来说都是不恰当的  
	     public void insertQuarter() {  
	         System.out.println("Please wait, we're already giving you a gumball");  
	     }  
	     public void ejectQuarter() {  
	         System.out.println("Sorry, you already turned the crank");  
	     }  
	     public void turnCrank() {  
	         System.out.println("Turning twice doesn't get you another gumball!");  
	     }  
	     //首先让机器发放糖果  
	     public void dispense() {  
	         gumballMachine.releaseBall();  
	         if (gumballMachine.getCount() > 0) {  
	             gumballMachine.setState(gumballMachine.getNoQuarterState());  
	         } else {  
	             System.out.println("Oops, out of gumballs!");  
	             gumballMachine.setState(gumballMachine.getSoldOutState());  
	         }  
	     }  
	 }
