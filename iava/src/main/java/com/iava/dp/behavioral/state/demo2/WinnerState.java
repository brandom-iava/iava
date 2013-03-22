package com.iava.dp.behavioral.state.demo2;

//我们再来实现WinnerState类  
public class WinnerState implements State {  
    GumballMachine gumballMachine;  
    //下面都跟SoldState方法一样  
    public WinnerState(GumballMachine gumballMachine) {  
        this.gumballMachine = gumballMachine;  
    }  
    public void insertQuarter() {  
        System.out.println("Please wait, we're already giving you a Gumball");  
    }  
    public void ejectQuarter() {  
        System.out.println("Please wait, we're already giving you a Gumball");  
    }  
    public void turnCrank() {  
        System.out.println("Turning again doesn't get you another gumball!");  
    }  
    //我们在这里发放出2颗糖果,然后进入NoQuarterState或SoldState  
    public void dispense() {  
        System.out.println("YOU'RE A WINNER! You get two gumballs for your quarter");  
        gumballMachine.releaseBall();  
        if (gumballMachine.getCount() == 0) {  
            gumballMachine.setState(gumballMachine.getSoldOutState());  
        } else {  
            gumballMachine.releaseBall();  
            if (gumballMachine.getCount() > 0) {  
                gumballMachine.setState(gumballMachine.getNoQuarterState());  
            } else {  
                System.out.println("Oops, out of gumballs!");  
                gumballMachine.setState(gumballMachine.getSoldOutState());  
            }  
        }  
    }  
}  