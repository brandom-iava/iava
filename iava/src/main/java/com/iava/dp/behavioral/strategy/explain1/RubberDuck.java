package com.iava.dp.behavioral.strategy.explain1;

public class RubberDuck extends Duck {
    //��ƤѼ����Ϊ֨֨�У�������д�����Ը�д��Ϊ
    public void quack() {
        System.out.println("Squeak");
    }

    //��ƤѼ��ʾΪ��ͷ
    public void display() {
        System.out.println("Yellow head.");
    }
}