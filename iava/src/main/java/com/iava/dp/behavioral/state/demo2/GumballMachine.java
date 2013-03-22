package com.iava.dp.behavioral.state.demo2;

 //完整的糖果机类  
 public class GumballMachine {  
     //所有的状态都在这里  
     State soldOutState;  
     State noQuarterState;  
     State hasQuarterState;  
     State soldState;  
     State winnerState;//十次抽中一次的游戏,新的状态  
     //以及实例变量state  
     State state = soldOutState;  
     int count = 0;//记录糖果数量  
     public GumballMachine(int numberGumballs) {       
         soldOutState = new SoldState(this);  //每一种状态也都创建一个状态实例  
         noQuarterState = new NoQuarterState(this);  
         hasQuarterState = new HasQuarterState(this);  
         soldState = new SoldState(this);  
         this.count = numberGumballs;  
         if (numberGumballs > 0) {    //如果超过0颗糖果,状态设为noQuarterState  
             state = noQuarterState;  
         }   
     }  
     //委托给当前状态  
     public void insertQuarter() {  
         state.insertQuarter();  
     }  
     public void ejectQuarter() {  
         state.ejectQuarter();  
     }  
     //dispense()是一个内部动作方法,用户不可以直接要求机器发放糖果  
     public void turnCrank() {  
         state.turnCrank();  
         state.dispense();  
     }  
     //允许其他的对象将机器状态转换到不同的状态  
     void setState(State state) {  
         this.state = state;  
     }  
     //辅助方法释放出糖果,并将count实例变量值减1  
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
