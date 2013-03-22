package com.iava.dp.behavioral.state.demo2;

 //�������ǹ�����  
 public class GumballMachine {  
     //���е�״̬��������  
     State soldOutState;  
     State noQuarterState;  
     State hasQuarterState;  
     State soldState;  
     State winnerState;//ʮ�γ���һ�ε���Ϸ,�µ�״̬  
     //�Լ�ʵ������state  
     State state = soldOutState;  
     int count = 0;//��¼�ǹ�����  
     public GumballMachine(int numberGumballs) {       
         soldOutState = new SoldState(this);  //ÿһ��״̬Ҳ������һ��״̬ʵ��  
         noQuarterState = new NoQuarterState(this);  
         hasQuarterState = new HasQuarterState(this);  
         soldState = new SoldState(this);  
         this.count = numberGumballs;  
         if (numberGumballs > 0) {    //�������0���ǹ�,״̬��ΪnoQuarterState  
             state = noQuarterState;  
         }   
     }  
     //ί�и���ǰ״̬  
     public void insertQuarter() {  
         state.insertQuarter();  
     }  
     public void ejectQuarter() {  
         state.ejectQuarter();  
     }  
     //dispense()��һ���ڲ���������,�û�������ֱ��Ҫ����������ǹ�  
     public void turnCrank() {  
         state.turnCrank();  
         state.dispense();  
     }  
     //���������Ķ��󽫻���״̬ת������ͬ��״̬  
     void setState(State state) {  
         this.state = state;  
     }  
     //���������ͷų��ǹ�,����countʵ������ֵ��1  
     void releaseBall() {  
         System.out.println("A gumball comes rolling out the slot...");  
         if (count != 0) {  
             count = count - 1;  
         }  
     }  
     int getCount() {  
         return count;  
     }  
     void refill(int count) {  
         this.count = count;  
         state = noQuarterState;  
     }  
     public State getState() {return state;}  
     public State getSoldOutState() {return soldOutState;}  
     public State getNoQuarterState() {return noQuarterState;}  
     public State getHasQuarterState() {return hasQuarterState;}  
     public State getSoldState() {return soldState;}  
     public State getWinnerState() {return winnerState;}  
 } 
