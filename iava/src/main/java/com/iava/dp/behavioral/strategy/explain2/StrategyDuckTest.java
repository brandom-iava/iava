package com.iava.dp.behavioral.strategy.explain2;

public class StrategyDuckTest {

	public static void main(String[] args) {
        StrategyDuck duck=new StrategyMallardDuck();
        duck.performFly();
        duck.performQuack();       
    }
}
