package com.iava.dp.behavioral.strategy.explain2;

//野鸭子会飞以及叫，所以实现接口  FlyBehavior, QuackBehavior
public class MallardDuck extends Duck implements FlyBehavior, QuackBehavior{
    public void display() {
        System.out.println("Green head.");
    }

    public void fly() {
        System.out.println("Fly.");               
    }

    public void quack() {
        System.out.println("Quack.");               
    }
}