发现问题：
大家在Coding的时候，有没有用到很多的选择语句？像这样：
Java代码

   1. if(…)  
   2. {  
   3.        …  
   4. }  
   5. else if(…)  
   6. {  
   7.        …  
   8. }  
   9. else if(…)  
  10. {  
  11.        …  
  12. }  
  13. else  
  14. {  
  15.        …  
  16. }  

if(…)
{
       …
}
else if(…)
{
       …
}
else if(…)
{
       …
}
else
{
       …
}



我是经常碰到，最经常见到的地方就是在struts的业务逻辑――Action的实现的类里， 以前的程序员很牛B，Coding从来都已“just can run ”为最终标准。

下面这个函数:
Java代码

   1. public ActionForward execute(ActionMapping mapping, ActionForm form,  
   2. HttpServletRequest request, HttpServletResponse response)   
   3.          throws java.lang.Exception  

public ActionForward execute(ActionMapping mapping, ActionForm form,
HttpServletRequest request, HttpServletResponse response) 
         throws java.lang.Exception


的实现，一般都是一个函数里边写2000－3000行代码，从来不关心结构的问题。

       “标准示范”就是刚刚上边列出来的if…else if…else…语句，这样的语句大多被用来判断提交了什么动作，然后处理的。当然，需求是在不断变化中的，每当新加了一个业务的提交处理的时候，怎么办呢？绝大多数人的选择都是在最后一个else if的后面，else的前面，添加一个else if…，^_^，如此处理。长此以往，一段程序或许本来就有n个else if，然后维护又加了n个，本来2000行的函数，搞成了三千行。哈哈，一个函数体三千行！何其壮观也！！！
       因此，我觉得，程序员在写判断语句的时候，用了多个else if就应该小心一点了，这个语句像某位大师所说的，是在代码中加入了“坏味道”，会引起程序变质，成为“腐坏代码”的。

提出问题：
那么，在出现要使用多个判断，并且判断逻辑经常改变的时候的时候，我们如何才能防止代码腐坏呢？
――使用state模式就是一个比较好的方法

State模式介绍：
tate模式属于对象行为型模式，

意图：允许一个对象在其内部状态改变时改变它的行为

适用场景：
1.一个对象的行为取决于它的状态，并且它必须在运行时刻根据状态改变它的行为。
2.一个操作中含有庞大的多分支结构，并且这些分支决定于对象的状态。

以上是出自GoF的DesignPatterns的官方解释，但是归结到平常使用中，我认为最多的适用场景还是替代if…if else…else多分支，实现更灵活的设计，防止代码腐坏。
可以看出：上面提到的“经典示例”就是个典型的第2个场景

State模式示例：

一开始我们有这么个Context类，这个类有个state成员，当state改变时，我们需要把它的改变打印出来。（当然，我们得假设各个打印的实现逻辑是彼此不同的）。

先看一下
常规的实现：
Java代码

   1. public class ContextOriginal  
   2. {  
   3.      private String state;  
   4.    
   5.      public String getState()  
   6.      {  
   7.          return state;  
   8.      }  
   9.    
  10.      public void setState(String state)  
  11.      {  
  12.          this.state = state;  
  13.      }  
  14.    
  15.      public void print(String msg)  
  16.      {  
  17.          System.out.println(msg);  
  18.      }  
  19.    
  20.      public void printImplFirst()  
  21.      {  
  22.          this.print("printImplFirst: " + this.state);  
  23.      }  
  24.    
  25.      public void printImplSecond()  
  26.      {  
  27.          this.print("printImplSecond: " + this.state);  
  28.      }  
  29.    
  30.      public void printImplThird()  
  31.      {  
  32.          this.print("printImplFinal: " + this.state);  
  33.      }  
  34.    
  35.      public void execute()  
  36.      {  
  37.          if(this.state != null)  
  38.          {  
  39.              if(this.state.equals("first"))  
  40.              {  
  41.                  this.printImplFirst();  
  42.              }  
  43.              else if(this.state.equals("second"))  
  44.              {  
  45.                  this.printImplSecond();  
  46.              }  
  47.              else if(this.state.equals("third"))  
  48.              {  
  49.                  this.printImplThird();  
  50.              }  
  51.              else  
  52.              {  
  53.                  throw new IllegalArgumentException(  
  54.                          "illegalArgumentException: this.state = " + this.state);  
  55.              }  
  56.          }  
  57.          else  
  58.          {  
  59.              throw new NullPointerException("this.state is null");  
  60.          }  
  61.      }  
  62.  }   


这样的实现方法的弊端刚开始已经分析的很清楚了，如果我们需要再加一个状态“ fourth”，则需要再加一个实现“printImplFourth()”，然后在“最后一个else if的后面，else的前面，添加一个else if…”，典型的使代码变质的方法。



那么我们使用State模式来实现吧：

我们首先声明一个抽象类State，以后所有的实现都继承这个类来实现它的handle方法。

我们在Context中加入成员State，表示Context的当前状态,

然后把所有对Context的state的处理都通过继承State抽象类来实现。

下面是类图描述：（从类图上来看，state模式和strategy模式的类图是非常相似的）

(见附件)
State抽象类的代码：
Java代码 

package patterns.state;
import patterns.state.impl.Context;

public abstract class State {
    public abstract void handle(Context context);
    public abstract void changeState(Context context);
}

 
State的几个实现代码：（只写出了一个，其它实现与之类似)
Java代码

   1.    
   2. package patterns.state.impl;  
   3.   
   4. import patterns.state.State;  
   5.   
   6. public class FirstState extends State {  
   7.   
   8.     @Override  
   9.     public void handle(Context context) {  
  10.     System.out.println("Current State is : "  
  11.         + context.getSteate().toString());  
  12.     this.changeState(context);  
  13.     }  
  14.   
  15.     @Override  
  16.     public void changeState(Context context) {  
  17.     context.setState(new SecondState());  
  18.   
  19.     }  
  20.   
  21.     public String toString() {  
  22.     return this.getClass().getSimpleName();  
  23.     }  
  24.   
  25. }  
Java代码

   1. package patterns.state.impl;  
   2.   
   3. import patterns.state.State;  
   4.   
   5. public class SecondState extends State {  
   6.   
   7.     @Override  
   8.     public void handle(Context context) {  
   9.     System.out.println("Current State is : "  
  10.         + context.getSteate().toString());  
  11.     this.changeState(context);  
  12.     }  
  13.   
  14.     @Override  
  15.     public void changeState(Context context) {  
  16.     context.setState(new FirstState());  
  17.     }  
  18.   
  19.     public String toString() {  
  20.     return this.getClass().getSimpleName();  
  21.     }  
  22. }  
  
Context类的实现代码：
Java代码

   1. package patterns.state.impl;  
   2.   
   3. import patterns.state.State;  
   4.   
   5. public class Context {  
   6.     // context的当前状态  
   7.     private State state;  
   8.   
   9.     public Context() {  
  10.     this.state = new FirstState();  
  11.     }  
  12.   
  13.     public State getSteate() {  
  14.     return state;  
  15.     }  
  16.   
  17.     public void setState(State state) {  
  18.     this.state = state;  
  19.     }  
  20.   
  21.     public void execute() {  
  22.     this.state.handle(this);  
  23.     }  
  24. }  

好了，现在State模式的实现写完了。
现在我们什么时候想处理state为first的时候，只需要

Java代码

   1. package patterns.state.test;  
   2.   
   3. import patterns.state.impl.Context;  
   4. import patterns.state.impl.FirstState;  
   5.   
   6. public class Test {  
   7.   
   8.     public Test() {  
   9.     Context context = new Context();  
  10.     context.execute();  
  11.     context.setState(new FirstState());  
  12.     context.execute();  
  13.     context.execute();  
  14.     context.execute();  
  15.     context.execute();  
  16.     }  
  17.   
  18.     public static void main(String[] args) {  
  19.     new Test();  
  20.     }  
  21.   
  22. }  


通过使用了State模式，不管Context的状态改变多少次，添加了多少个状态，我们都不需要修改它的源代码，而只是通过添加新的实现方法就可以搞定了，这样达到了防止“代码腐坏”的目的。

State模式的特点：

State模式允许一个对象基于内部状态而拥有不同的行为

State模式允许使用类代表状态

Context会将行为委托给当前对象

通过将每个状态封装进一个类，我们把以后需要做的任何更改局部化了

状态（state）的转换可以由StateHandler类或者context类来控制

状态处理类（StateHandler）可以被多个Context实例共享。

使用状态模式将会导致设计中类的数目大量增加



需要注意的地方:
1. state之间的转换. State的转换可以在State类内部完成, 但是这样会带来的问题是各个State之间出现了关联, 那么如果一个State本身改变(减少, 增加) 会带来很大影响, 你就有可能看看当前发生改变的state是否也影响到了其它的state的执行. 不过经过跟同事的讨论发现也是在所难免的. 另外一个, state的转换也可以由其它类调用Context的setState()来完成, 感觉这种情况更不可靠, 因为这样的话其他类就必须知道context的特定state, 带来了不必要的耦合, 因此建议对setState()的调用尽量放在Context和State这两处.


2. State的创建和销毁. 两个方法: 1.在context内部创建所有state, 一直维护从不销毁.2.在状态转换的时候才创建, 然后上一个state由JVM自动回收. 主要原则需要看实际情况是Context的State的变化是否频繁, 如果不频繁, 建议用第二种,比较优雅.




总结：

1.尽量不要使用太多分支的语句。
2.如果函数超过一屏，你就需要考虑是否需要把功能分割了。如果你写了个3000行的“超长”的函数，以后维护的人会很不爽，也会遭到bs的。
3.如果不幸遇到必须使用太多分支且分支与类的某一个状态有关且经常改变，那可以考虑使用state模式，防止“腐坏”。
4.牢记OO设计原则：“找出应用中需要变化之处，把它们独立出来，不要和那些不需要变化的代码混在一起”。 
請問..Conext設置狀態以及根據狀態設置對應該狀態的行為子類不也要用if else語句麼？
還是脫不開啊. 


使用state模式的意图不是在于让if...else...语句消失，
而是取决于下面两个场景：

1.一个对象的行为取决于它的状态，并且它必须在运行时刻根据状态改变它的行为。
2.一个操作中含有庞大的多分支结构，并且这些分支决定于对象的状态。

当你在解决问题时，碰到了这样的场景的时候，才有必要考虑使用state模式。


另外，应该在OOD的合适时机，合适的场景下使用“设计模式”，
如果仅仅为了使用某个模式，才去设计，就本末倒置了。
所以学习设计模式的时候，明确这个设计模式的使用的“意图”，也是很重要。


