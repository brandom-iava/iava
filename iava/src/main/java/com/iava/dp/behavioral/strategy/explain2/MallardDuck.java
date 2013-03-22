package com.iava.dp.behavioral.strategy.explain2;

//ҰѼ�ӻ���Լ��У�����ʵ�ֽӿ�  FlyBehavior, QuackBehavior
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