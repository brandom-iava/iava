package com.iava.dp.behavioral.strategy.explain2;


public class StrategyMallardDuck extends StrategyDuck{
    public StrategyMallardDuck() {
        flyBehavior=new FlyWithWings();
        quackBehavior=new Quack();       
    }
   
    public void display() {
        System.out.println("Green head.");
    }
   }
