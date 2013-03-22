package com.iava.dp.behavioral.strategy.explain2;

public abstract class StrategyDuck {
    //����Ϊ������Ϊ�ӿ����ͣ����Ͷ���Ϊʵ�����͵�����
FlyBehavior flyBehavior;
QuackBehavior quackBehavior;

public void performFly() {
    //�����д���fly()��Ϊ������ί�ϸ�����flyBehavior��ָ�����Ϊ����
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