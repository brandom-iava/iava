package com.iava.dp.behavioral.strategy.explain2;

//�仯�� quack() ��Ϊʵ����֮��
public class MuteQuack implements QuackBehavior {
 public void quack() {
     System.out.println("<< Slience >>");
 }
}