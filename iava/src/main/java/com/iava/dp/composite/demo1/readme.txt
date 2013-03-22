组合模式，一般就是“整体，部分”的概念，在java与模式中举了一个大家经常听过的故事，很形象，从前有座山，山里有座庙，庙里有个老和尚给小和尚讲故事，讲的内容是：从前有座山......一直这样下去。从这里看出，整体是这个故事，故事里面的故事则是部分。这也是一个简单的组合模式。

      组合模式把整体和部分的关系用树结果表示出来，使得客户端把一个单独的成分对象和复合对象同等对待。

      组合模式分为安全式和透明式，

     首先看看安全式：

     定义接口
Java代码

   1. public interface Component {  
   2.      public void sampleOperation();  
   3. }  

public interface Component {
	 public void sampleOperation();
}

 

树枝构建角色是具体的实现类
Java代码

   1. public class Composite implements Component {  
   2.   
   3.     private Vector componentVector = new Vector();  
   4.       
   5. /** 
   6.  * 谋个业务方法 
   7.  * */  
   8.     public void sampleOperation() {  
   9.         Enumeration enumeration = components();  
  10.         while (enumeration.hasMoreElements()){  
  11.             ((Component)(enumeration.nextElement())).sampleOperation();  
  12.         }  
  13.     }  
  14.     /** 
  15.      * 聚集管理方法，增加一个子构建对象 
  16.      * */  
  17.     public void add(Component component){  
  18.         componentVector.add(component);  
  19. //      System.out.println("++++++++++"+componentVector.size());  
  20.     }  
  21.     /** 
  22.      * 聚集管理方法，删除一个子构建对象 
  23.      * */  
  24.     public void remove(Component component){  
  25.         componentVector.remove(component);  
  26. //      System.out.println("----------"+componentVector.size());  
  27.     }  
  28.     /** 
  29.      * 聚集管理方法，返回聚集的Enumeration对象 
  30.      * */  
  31.     public Enumeration components(){  
  32.         System.out.println("**********"+componentVector.size());  
  33.         return componentVector.elements();  
  34.     }  
  35. }  

public class Composite implements Component {

	private Vector componentVector = new Vector();
	
/**
 * 谋个业务方法
 * */
	public void sampleOperation() {
		Enumeration enumeration = components();
		while (enumeration.hasMoreElements()){
			((Component)(enumeration.nextElement())).sampleOperation();
		}
	}
	/**
	 * 聚集管理方法，增加一个子构建对象
	 * */
	public void add(Component component){
		componentVector.add(component);
//		System.out.println("++++++++++"+componentVector.size());
	}
	/**
	 * 聚集管理方法，删除一个子构建对象
	 * */
	public void remove(Component component){
		componentVector.remove(component);
//		System.out.println("----------"+componentVector.size());
	}
	/**
	 * 聚集管理方法，返回聚集的Enumeration对象
	 * */
	public Enumeration components(){
		System.out.println("**********"+componentVector.size());
		return componentVector.elements();
	}
}

 

这里除基本业务方法外，它增加了，add，与remov方法。此方法可以对子构建进行增加与删除。

树叶构建角色也实现抽象构建角色。
Java代码

   1. public class Leaf implements Component {  
   2.   
   3.     public void sampleOperation() {  
   4.         System.out.println("增加叶子");  
   5.     }  
   6.   
   7. }  

public class Leaf implements Component {

	public void sampleOperation() {
		System.out.println("增加叶子");
	}

}

 

最后通过测试看下
Java代码

   1. public class Client {  
   2.   
   3.     /** 
   4.      * @param args 
   5.      */  
   6.     public static void main(String[] args) {  
   7.         //操作单一方法  
   8.         Leaf l= new Leaf();  
   9.         l.sampleOperation();  
  10.   
  11.         //构造根枝  
  12.         Composite allc = new Composite();  
  13.         //构造次枝  
  14.         Composite c1 = new Composite();  
  15.         ((Composite)allc).add(c1);  
  16.         //构造叶子  
  17.         ((Composite)c1).add(new Leaf());  
  18.         ((Composite)c1).add(new Leaf());  
  19.         ((Composite)c1).remove(new Leaf());  
  20.   
  21.         allc.sampleOperation();  
  22.     }  
  23.   
  24. }  

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//操作单一方法
		Leaf l= new Leaf();
		l.sampleOperation();

		//构造根枝
		Composite allc = new Composite();
		//构造次枝
		Composite c1 = new Composite();
		((Composite)allc).add(c1);
		//构造叶子
		((Composite)c1).add(new Leaf());
		((Composite)c1).add(new Leaf());
		((Composite)c1).remove(new Leaf());

		allc.sampleOperation();
	}

}

 

从这个测试看出，在枝节上可以构造枝节，在枝节上可以构造叶子 ，并且可以通过remove方法，去掉枝叶。这个也可以再次创建下一级的枝叶。

 

下来说下几个名词：

抽象构件角色(Component)：这是个抽象类，一般就是个接口，它定义出公共接口，安全模式里，构件角色并不定义管理子对象的方法

树叶构件角色(Leaf)：树叶对象没有下级，只定义原始对象。

树枝构件角色(Composite)：代表参加组合的下级子对象的对象，还定义出了管理方法：add，remove

 

透明式：则是将原来写在composite中的管理方法，写在接口当中，这样实现他时就必须实现这两个管理方法，包括叶子，这样就是说叶子并不能管理树枝，而也有着两个方法，并且客户端可以调用。

 

 

 
声明：JavaEye文章版权属于作者，受法律保护。没有作者书面许可不得转载。
推荐链接

    * 下载免费的 IBM DB2 Express-C 数据库
    * 在繁琐中挣扎还是简化自主管理？
    * IBM Rational软件开发高峰论坛9月揭幕

返回顶楼 	
        最后修改：2008-12-05

    * hanjs
    * 等级: 初级会员
    * 用户头像
    * 文章: 111
    * 积分: 0
    * 来自: 大连
    *

	
发表时间：2008-12-04
引用 收藏
((Composite)allc).add(c1);  
        //构造叶子  
        ((Composite)c1).add(new Leaf());  
        ((Composite)c1).add(new Leaf());  
        ((Composite)c1).remove(new Leaf()); 

不知道我为何需要进行强制类型转换？都已经是这个类型了 