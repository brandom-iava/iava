package com.iava.dp.behavioral.strategy.explain2;

public abstract class DynamicStrategyDuck {
    //����Ϊ������Ϊ�ӿ����ͣ����Ͷ���Ϊʵ�����͵�����
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
//	�ڸղ�Duck.java�м������¶���������
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior=flyBehavior;
    }
   
    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior=quackBehavior;
    }
    
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
