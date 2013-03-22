package com.iava.dp.behavioral.strategy.explain2;

//橡皮鸭不会飞，但会吱吱叫，所以只实现接口QuackBehavior
public class RubberDuck extends Duck implements QuackBehavior{
    //橡皮鸭叫声为吱吱叫
    public void quack() {
        System.out.println("Squeak");
    }

    //橡皮鸭显示为黄头
    public void display() {
        System.out.println("Yellow head.");
    }
}
