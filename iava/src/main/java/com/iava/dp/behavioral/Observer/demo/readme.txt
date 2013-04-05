1.����
observerģʽ���������һ�Զ��������ϵ,��һ�������״̬�����ı�ʱ, �������������Ķ��󶼵õ�֪ͨ�����Զ����¡�JDK���ṩ��observer���ģʽ��ʵ����java.util.Observable��
�� java.util.Observer�ӿ���ɡ��������Ͽ�������Ŀ���������Observer ���ģʽ�зֱ���ݵĽ�ɫ��Observer�ǹ۲��߽�ɫ��Observable�Ǳ��۲�Ŀ��(subject)��ɫ��
2.ʵ��
��ʵ��ģ������ˮ�Ĺ��̣��漰��������Heater(��ˮ��),Display����ʾ����,Alarm(������).
   ģ����̣�Ϊ�˱������У�ˮ�ĳ�ʼ���¶�Ϊ90���е�Ϊ95����ʾ��������ˮ����ʾ�¶ȣ���ʾ����ʾ�¶�Ϊ95ʱ����������ʼ���������Կ��Կ��� Heater��subject ,Display ������ Obsrver��
   ͬʱDisplay����suject����Ϊ��Ҫ���������۲죬����Alarm��Display��Observer.
   ʵ�ֹ��̣�
a.Heater.java
Java����

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
Java����

   1. import java.util.Observable;  
   2. import java.util.Observer;  
   3.   
   4. public class Display extends Observable implements Observer {  
   5.   
   6.     private String status = "δ��";  
   7.   
   8.     public void setStatus(String status) {  
   9.         this.status = status;  
  10.     }  
  11.     public void displayTemputer(int temperature) {  
  12.         if (temperature > 95) {  
  13.             this.setStatus("����");  
  14.             this.setChanged();  
  15.             this.notifyObservers();  
  16.         }  
  17.         System.out.println("״̬��" + status + " �����¶ȣ�" + temperature + "");  
  18.     }  
  19.     public void update(Observable o, Object arg) {  
  20.         displayTemputer(((Heater) o).getTemperature());//���ﲻ�Ǻܺ�  
  21.     }  
  22. }  

import java.util.Observable;
import java.util.Observer;

public class Display extends Observable implements Observer {

	private String status = "δ��";

	public void setStatus(String status) {
		this.status = status;
	}
	public void displayTemputer(int temperature) {
		if (temperature > 95) {
			this.setStatus("����");
			this.setChanged();
			this.notifyObservers();
		}
		System.out.println("״̬��" + status + " �����¶ȣ�" + temperature + "");
	}
	public void update(Observable o, Object arg) {
		displayTemputer(((Heater) o).getTemperature());//���ﲻ�Ǻܺ�
	}
}


c.Alarm.java
Java����

   1. import java.util.Observable;  
   2. import java.util.Observer;  
   3.   
   4. public class Alarm implements Observer {  
   5.   
   6.     public void makeAlarm() {  
   7.         System.out.println("������...ˮ�Ѿ��տ� ");  
   8.     }  
   9.     public void update(Observable o, Object arg) {  
  10.         makeAlarm();  
  11.     }  
  12. }  

import java.util.Observable;
import java.util.Observer;

public class Alarm implements Observer {

	public void makeAlarm() {
		System.out.println("������...ˮ�Ѿ��տ� ");
	}
	public void update(Observable o, Object arg) {
		makeAlarm();
	}
}


d.������testObserver.java
Java����

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


e.���н����
����
״̬��δ�� �����¶ȣ�90
״̬��δ�� �����¶ȣ�91
״̬��δ�� �����¶ȣ�92
״̬��δ�� �����¶ȣ�93
״̬��δ�� �����¶ȣ�94
״̬��δ�� �����¶ȣ�95
������...ˮ�Ѿ��տ�
״̬������ �����¶ȣ�96
������...ˮ�Ѿ��տ�
״̬������ �����¶ȣ�97
������...ˮ�Ѿ��տ�
״̬������ �����¶ȣ�98
������...ˮ�Ѿ��տ�
״̬������ �����¶ȣ�99

3.�ܽᣬ �۲���ģʽ��Ӧ�ó�����

1�� ��һ������״̬�ĸ��£���Ҫ��������ͬ�����£��������������������̬�ɱ䡣

2�� �������Ҫ���Լ��ĸ���֪ͨ���������������Ҫ֪�����������ϸ�ڡ�

�۲���ģʽ���ŵ㣺

1�� Subject��Observer֮������ż�ϵģ��ֱ���Ը��Զ����ı䡣

2�� Subject�ڷ��͹㲥֪ͨ��ʱ������ָ�������Observer��Observer�����Լ������Ƿ�Ҫ����Subject��֪ͨ��

3�� ���ش󲿷�GRASPԭ��ͳ������ԭ�򣬸��ھۡ���ż�ϡ�

�۲���ģʽ��ȱ�ݣ�

1�� ��ż�ϵ��´����ϵ�����ԣ���ʱ����������⡣(�ϻ�)

2�� ���һ��Subject������Observer���ĵĻ����ڹ㲥֪ͨ��ʱ����ܻ���Ч�����⡣���Ͼ�ֻ�Ǽ򵥵ı����� 