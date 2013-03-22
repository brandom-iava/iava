package com.iava.dp.behavioral.visitor.demo1;

public class Client {
    public static void main(String[] args) {
		ObjectStructure o = new ObjectStructure();  //依赖于ObjectStructure
		//实例化具体元素
		o.attach(new Man());  
		o.attach(new Woman());
		
		//当成功时不同元素的不同反映
		Visitor success = new Success();           //依赖于抽象的Visitor接口
		o.display(success);
		
		//当恋爱时的不同反映
		Visitor amativeness = new Love();          //依赖于抽象的Visitor接口
		o.display(amativeness);
		
	}
}


