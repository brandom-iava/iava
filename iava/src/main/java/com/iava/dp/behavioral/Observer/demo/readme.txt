1.概念
observer模式定义对象间的一对多的依赖关系,当一个对象的状态发生改变时, 所有依赖于它的对象都得到通知并被自动更新。JDK里提供的observer设计模式的实现由java.util.Observable类
和 java.util.Observer接口组成。从名字上可以清楚的看出两者在Observer 设计模式中分别扮演的角色：Observer是观察者角色，Observable是被观察目标(subject)角色。
2.实例
该实例模拟了烧水的过程，涉及三个对象，Heater(热水器),Display（显示器）,Alarm(报警器).
   模拟过程：为了便于运行，水的初始化温度为90，沸点为95，显示器依据热水器显示温度，显示器显示温度为95时，报警器开始报警。明显可以看出 Heater是subject ,Display 是它的 Obsrver，
   同时Display亦是suject，因为它要被报警器观察，所以Alarm是Display的Observer.
   实现过程：
a.Heater.java
Java代码

   1. import java.util.Observable;  
   2.   
   3. public class Heater extends Observable {  
   4.   
   5.     private int temperature;  
   6.   
   7.     public int getTemperature() {  
   8.         return temperature;  
   9.     }  
  10.     public void setTemperature(int temperature) {  
  11.         this.temperature = temperature;  
  12.     }  
  13.     public void boilWater() {  
  14.         for (int i = 90; i < 100; i++) {  
  15.             temperature = i;  
  16.             this.setChanged();  
  17.             this.notifyObservers();  
  18.         }  
  19.     }  
  20. }  

import java.util.Observable;

public class Heater extends Observable {

	private int temperature;

	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public void boilWater() {
		for (int i = 90; i < 100; i++) {
			temperature = i;
			this.setChanged();
			this.notifyObservers();
		}
	}
}


b.Display.java
Java代码

   1. import java.util.Observable;  
   2. import java.util.Observer;  
   3.   
   4. public class Display extends Observable implements Observer {  
   5.   
   6.     private String status = "未开";  
   7.   
   8.     public void setStatus(String status) {  
   9.         this.status = status;  
  10.     }  
  11.     public void displayTemputer(int temperature) {  
  12.         if (temperature > 95) {  
  13.             this.setStatus("沸腾");  
  14.             this.setChanged();  
  15.             this.notifyObservers();  
  16.         }  
  17.         System.out.println("状态：" + status + " 现在温度：" + temperature + "");  
  18.     }  
  19.     public void update(Observable o, Object arg) {  
  20.         displayTemputer(((Heater) o).getTemperature());//这里不是很好  
  21.     }  
  22. }  

import java.util.Observable;
import java.util.Observer;

public class Display extends Observable implements Observer {

	private String status = "未开";

	public void setStatus(String status) {
		this.status = status;
	}
	public void displayTemputer(int temperature) {
		if (temperature > 95) {
			this.setStatus("沸腾");
			this.setChanged();
			this.notifyObservers();
		}
		System.out.println("状态：" + status + " 现在温度：" + temperature + "");
	}
	public void update(Observable o, Object arg) {
		displayTemputer(((Heater) o).getTemperature());//这里不是很好
	}
}


c.Alarm.java
Java代码

   1. import java.util.Observable;  
   2. import java.util.Observer;  
   3.   
   4. public class Alarm implements Observer {  
   5.   
   6.     public void makeAlarm() {  
   7.         System.out.println("嘀嘀嘀...水已经烧开 ");  
   8.     }  
   9.     public void update(Observable o, Object arg) {  
  10.         makeAlarm();  
  11.     }  
  12. }  

import java.util.Observable;
import java.util.Observer;

public class Alarm implements Observer {

	public void makeAlarm() {
		System.out.println("嘀嘀嘀...水已经烧开 ");
	}
	public void update(Observable o, Object arg) {
		makeAlarm();
	}
}


d.测试类testObserver.java
Java代码

   1. public class testObserver {  
   2.   
   3.     public static void main(String[] args) {  
   4.         Heater header = new Heater();  
   5.         Display display = new Display();  
   6.         Alarm alarm = new Alarm();  
   7.         header.addObserver(display);  
   8.         display.addObserver(alarm);  
   9.         header.boilWater();  
  10.     }  
  11. }  

public class testObserver {

	public static void main(String[] args) {
		Heater header = new Heater();
		Display display = new Display();
		Alarm alarm = new Alarm();
		header.addObserver(display);
		display.addObserver(alarm);
		header.boilWater();
	}
}


e.运行结果：
引用
状态：未开 现在温度：90
状态：未开 现在温度：91
状态：未开 现在温度：92
状态：未开 现在温度：93
状态：未开 现在温度：94
状态：未开 现在温度：95
嘀嘀嘀...水已经烧开
状态：沸腾 现在温度：96
嘀嘀嘀...水已经烧开
状态：沸腾 现在温度：97
嘀嘀嘀...水已经烧开
状态：沸腾 现在温度：98
嘀嘀嘀...水已经烧开
状态：沸腾 现在温度：99

3.总结， 观察者模式的应用场景：

1、 对一个对象状态的更新，需要其他对象同步更新，而且其他对象的数量动态可变。

2、 对象仅需要将自己的更新通知给其他对象而不需要知道其他对象的细节。

观察者模式的优点：

1、 Subject和Observer之间是松偶合的，分别可以各自独立改变。

2、 Subject在发送广播通知的时候，无须指定具体的Observer，Observer可以自己决定是否要订阅Subject的通知。

3、 遵守大部分GRASP原则和常用设计原则，高内聚、低偶合。

观察者模式的缺陷：

1、 松偶合导致代码关系不明显，有时可能难以理解。(废话)

2、 如果一个Subject被大量Observer订阅的话，在广播通知的时候可能会有效率问题。（毕竟只是简单的遍历） 