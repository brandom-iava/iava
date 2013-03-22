package com.iava.dp.behavioral.strategy.explain2;

//变化的 fly() 行为的实现类之二
public class FlyNoWay implements FlyBehavior {
 public void fly() {
     System.out.println("I can't fly.");
 }
}