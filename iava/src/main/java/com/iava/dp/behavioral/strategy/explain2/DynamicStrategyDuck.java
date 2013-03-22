package com.iava.dp.behavioral.strategy.explain2;

public abstract class DynamicStrategyDuck {
    //将行为类声明为接口类型，降低对行为实现类型的依赖
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
//	在刚才Duck.java中加入以下二个方法。
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior=flyBehavior;
    }
   
    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior=quackBehavior;
    }
    
    public void performFly() {
        //不自行处理fly()行为，而是委拖给引用flyBehavior所指向的行为对象
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks float, even decoys.");       
    }

    public abstract void display();
}
