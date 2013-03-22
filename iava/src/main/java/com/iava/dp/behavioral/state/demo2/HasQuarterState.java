package com.iava.dp.behavioral.state.demo2;

import java.util.Random;

 //����������ʵ��HasQuarterState(��25��Ǯ)��SoldState(�۳��ǹ�)����,�ǹ�����ķ����Լ�дд,����Ͳ��ṩ��  
 public class HasQuarterState implements State {  
     GumballMachine gumballMachine;  
     //����һ�������������,����10%�Ļ���  
     Random randomWinner = new Random(System.currentTimeMillis());  
     public HasQuarterState(GumballMachine gumballMachine) {  
         this.gumballMachine = gumballMachine;  
     }  
     public void insertQuarter() {   //����һ���Ե�ǰ״̬��ǡ���Ķ���  
         System.out.println("You can't insert another quarter");  
     }  
     public void ejectQuarter() {    //��Ǯ��ת��״̬��NoQuarterState  
         System.out.println("Quarter returned");  
         gumballMachine.setState(gumballMachine.getNoQuarterState());  
     }  
     public void turnCrank() {  
         System.out.println("You turned...");  
         int winner = randomWinner.nextInt(10);  
         //��������˿��Ƿ�Ӯ��  
         if ((winner == 0) && (gumballMachine.getCount() > 1)) {  
             gumballMachine.setState(gumballMachine.getWinnerState());  
         } else {  
             gumballMachine.setState(gumballMachine.getSoldState());  
         }  
     }  
     public void dispense() {    //����һ���Ե�ǰ״̬��ǡ���Ķ���  
         System.out.println("No gumball dispensed");  
     }  
 }  