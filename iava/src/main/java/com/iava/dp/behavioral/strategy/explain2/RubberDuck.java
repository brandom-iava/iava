package com.iava.dp.behavioral.strategy.explain2;

//��ƤѼ����ɣ�����֨֨�У�����ֻʵ�ֽӿ�QuackBehavior
public class RubberDuck extends Duck implements QuackBehavior{
    //��ƤѼ����Ϊ֨֨��
    public void quack() {
        System.out.println("Squeak");
    }

    //��ƤѼ��ʾΪ��ͷ
    public void display() {
        System.out.println("Yellow head.");
    }
}
