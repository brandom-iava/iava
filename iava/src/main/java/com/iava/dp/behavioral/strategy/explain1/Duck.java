package com.iava.dp.behavioral.strategy.explain1;

public abstract class Duck {
    //所有的鸭子均会叫以及游泳，所以父类中处理这部分代码
    public void quack() {
        System.out.println("Quack");
    }
   
    public void swim() {
        System.out.println("All ducks float, even decoys.");       
    }
    //因为每种鸭子的外观是不同的，所以父类中该方法是抽象的，由子类型自己完成。
    public abstract void display();
}