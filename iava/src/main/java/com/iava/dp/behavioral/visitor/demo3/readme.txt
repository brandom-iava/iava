在Java中所有的物件都繼承自Object物件，這樣作的優點之一，就是使得一些集合物件的資料結構容易管理，例如您可以將任何型態的物件放入Vector中。

然而現在有個問題是，如果您的集合（connection）物件中不僅儲存一種型態的物件，如果想要對這些物件作出一些個別化的操作，首要條件就是要知道該物件的型態，使用 instanceof 似乎是個不錯的方式，在程式簡單的情況下，也許您會這麼作：

public class ElementA {
    // some implementing
}
 
public class ElementB {
    // some implementing
}
 
public class ElementC {
    // some implementing
}
 
// ......
 
          Iterator iterator = arrayList.iterator()
              while (iterator.hasNext()) {
         　　 if (o instanceof ElementA)
　　 　　     (ElementA) o.operationA();
        　　 else if (o instanceof ElementB)
　　 　　     (ElementB) o.operationB();
　　         else if (o instanceof ElementC)
　　 　　     (ElementC) o.operationC();
　　         else
　　 　　     System.out.println("Sorry! I don't know who you are! " + o.toString());
//....



這麼作並不是不可以，只是在對物件進行操作的同時，還必須在程式中進行型態判斷，將會使得程式碼顯示雜亂，且將來的擴充性不大，如果今天您想要增加一個狀況，使得對ElementA、B、C三者都多出一種對應的操作流程，您的程式勢必面對很大的修改。

讓我們從物件自身的角度來想好了，物件在一個個的房子中，物件說：「不要在房子外費盡心思判斷了，即然您不知道我是誰，那麼您就進來訪問我好了，我告訴您我是誰，這麼一來您就知道如何操作我了！」

我們用程式來實現上面這個描述：

public interface Element {
    public void accept(Visitor visitor);
}
 
public class ElementA implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
                                                                                
    public void operationA() {
        System.out.println("do A's job....such-and-such....");
    }
}
 
public class ElementB implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
                                                                                
    public void operationB() {
        System.out.println("do B's job....such-and-such....");
    }
}
 
public class ElementC implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
                                                                                
    public void operationC() {
        System.out.println("do C's job....such-and-such....");
    }
}
 
public interface Visitor {
    public void visit(ElementA element);
    public void visit(ElementB element);
    public void visit(ElementC element);
}
 
public class VisitorA implements Visitor {
    public void visit(ElementA element) {
        element.operationA();
    }
                                                                                
    public void visit(ElementB element) {
        element.operationB();
    }
                                                                                
    public void visit(ElementC element) {
        element.operationC();
    }
}
 
public class Main {
    public static void main(String[] args) {
         // know nothing about their type after storing them into Element array
        Element[] list = {new ElementA(), new ElementB(), new ElementC()};
 
        Visitor visitor = new VisitorA();
                                                                                
        for (int i=0; i < list.length; i++)
            list[i].accept(visitor);
    }
}



對於每一個實現Element的物件來說，它接受Visitor來訪問它，在accept()方法中， Visitor使用正確的方法來訪問Element（顯然的，這麼部份可以靠不同的函式名稱，或是多載overload來達成），並在visit()中對 Element作出對應的操作，我們看看執行的結果會是如何：


do A's job....such-and-such....
do B's job....such-and-such....
do C's job....such-and-such....



這個模式並不只有幫您作節省if...else的麻煩而已。

假設VisitorA只是個懶惰的推銷員好了，今天有一個比較勤快的推銷員VisitorB，在訪問過Element之後，會對Element作出更多的操作，要在程式中實現VisitorB，我們只要增加一個VisitorB類別就可以了：

public class VisitorB implements Visitor {
    public void visit(ElementA element) {
        System.out.println("VisitorB is a hard worker....");
        element.operationA();
        System.out.println("I want to do some extra work on A....");
    }
                                                                                
    public void visit(ElementB element) {
        System.out.println("VisitorB is a hard worker....");
        element.operationB();
        System.out.println("I want to do some extra work on B....");
    }
                                                                                
    public void visit(ElementC element) {
        System.out.println("VisitorB is a hard worker....");
        element.operationC();
        System.out.println("I want to do some extra work on C....");
    }
}



我們改一下Main來示範，看兩個Visitor分別對物件的行為會是如何：

public class Main {
    public static void main(String[] args) {
        Element[] list = {new ElementA(), new ElementB(), new ElementC()};
                                                                                
        System.out.println("visitorA is coming.......");
        Visitor visitorA = new VisitorA();
        for (int i=0; i < list.length; i++)
            list[i].accept(visitorA);
                                                                                
        System.out.println("\nvisitorB is coming.......");
        Visitor visitorB = new VisitorB();
        for (int i=0; i < list.length; i++)
            list[i].accept(visitorB);
    }
}



執行結果：

visitorA is coming.......
do A's job....such-and-such....
do B's job....such-and-such....
do C's job....such-and-such....
 
visitorB is coming.......
VisitorB is a hard worker....
do A's job....such-and-such....
I want to do some extra work on A....
VisitorB is a hard worker....
do B's job....such-and-such....
I want to do some extra work on B....
VisitorB is a hard worker....
do C's job....such-and-such....
I want to do some extra work on C....



在範例中的System.out.println();只是個示意，它也可能是您對Element的額外方法的直接調用。

訪問者模式的UML結構類圖如下：


在Java World中有一篇文章，提到可以利用reflection來改進使用訪問者模式時的彈性，有興趣的可以進一步參考一下：
http://www.javaworld.com/javaworld/javatips/jw-javatip98.html

PS. 在Gof中有提供single-dispatch與double-dispatch的概念，雖然我大致上瞭解文中的意思，但沒有實際接觸過double-dispatch的語言，不便在此作出比較，有興趣的可以自行參考Gof的書籍。 