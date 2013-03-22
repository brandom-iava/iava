package com.iava.dp.behavioral.strategy.explain1;

public abstract class Duck {
    //���е�Ѽ�Ӿ�����Լ���Ӿ�����Ը����д����ⲿ�ִ���
    public void quack() {
        System.out.println("Quack");
    }
   
    public void swim() {
        System.out.println("All ducks float, even decoys.");       
    }
    //��Ϊÿ��Ѽ�ӵ�����ǲ�ͬ�ģ����Ը����и÷����ǳ���ģ����������Լ���ɡ�
    public abstract void display();
}