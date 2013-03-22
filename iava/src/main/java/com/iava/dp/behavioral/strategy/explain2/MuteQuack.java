package com.iava.dp.behavioral.strategy.explain2;

//变化的 quack() 行为实现类之三
public class MuteQuack implements QuackBehavior {
 public void quack() {
     System.out.println("<< Slience >>");
 }
}