package com.iava.dp.behavioral.strategy.explain2;

public abstract class Duck {
    //���仯����Ϊ fly() �Լ�quake()��Duck���з����ȥ�����γɽӿڣ������������������ȥʵ��

    public void swim() {
        System.out.println("All ducks float, even decoys.");       
    }
   
    public abstract void display();
}

