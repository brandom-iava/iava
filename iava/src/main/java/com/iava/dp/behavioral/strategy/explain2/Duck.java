package com.iava.dp.behavioral.strategy.explain2;

public abstract class Duck {
    //将变化的行为 fly() 以及quake()从Duck类中分离出去定义形成接口，有需求的子类中自行去实现

    public void swim() {
        System.out.println("All ducks float, even decoys.");       
    }
   
    public abstract void display();
}

