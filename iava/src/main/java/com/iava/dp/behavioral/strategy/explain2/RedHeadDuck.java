package com.iava.dp.behavioral.strategy.explain2;

//红头鸭子会飞以及叫，所以也实现接口  FlyBehavior, QuackBehavior
public class RedHeadDuck extends Duck implements FlyBehavior, QuackBehavior{
    public void display() {
        System.out.println("Red head.");
    }   

    public void fly() {
        System.out.println("Fly.");               
    }

    public void quack() {
        System.out.println("Quack.");               
    }   
}

