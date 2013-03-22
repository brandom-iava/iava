package com.iava.dp.behavioral.state.demo2;

import java.util.Random;

 //现在我们来实现HasQuarterState(有25分钱)和SoldState(售出糖果)方法,糖果售完的方法自己写写,这里就不提供了  
 public class HasQuarterState implements State {  
     GumballMachine gumballMachine;  
     //增加一个随机数产生器,产生10%的机会  
     Random randomWinner = new Random(System.currentTimeMillis());  
     public HasQuarterState(GumballMachine gumballMachine) {  
         this.gumballMachine = gumballMachine;  
     }  
     public void insertQuarter() {   //这是一个对当前状态不恰当的动作  
         System.out.println("You can't insert another quarter");  
     }  
     public void ejectQuarter() {    //退钱并转换状态到NoQuarterState  
         System.out.println("Quarter returned");  
         gumballMachine.setState(gumballMachine.getNoQuarterState());  
     }  
     public void turnCrank() {  
         System.out.println("You turned...");  
         int winner = randomWinner.nextInt(10);  
         //决定这个顾客是否赢了  
         if ((winner == 0) && (gumballMachine.getCount() > 1)) {  
             gumballMachine.setState(gumballMachine.getWinnerState());  
         } else {  
             gumballMachine.setState(gumballMachine.getSoldState());  
         }  
     }  
     public void dispense() {    //这是一个对当前状态不恰当的动作  
         System.out.println("No gumball dispensed");  
     }  
 }  