package com.iava.dp.creation.factorymethod;

public class FactoryMethod {
	public static final int icon=0x7f020000;
	 public static final int main=0x7f030000;
	 public static final int app_name=0x7f040001;
    public static final int hello=0x7f040000;//2130968576
    public static final int test = 2130968576;
	public static void main(String[] args){
		ShapeFactory sf1 = new SquareFactory(); 
		ShapeFactory sf2 = new CircleFactory();
		sf1.anOperation("Shape one");
		sf2.anOperation("Shape two");
		
		System.out.printf("icon:%s,main:%s,app_name:%s,hello:%s\n", icon,main,app_name,hello);
		System.out.println(hello == test);
		}
}
