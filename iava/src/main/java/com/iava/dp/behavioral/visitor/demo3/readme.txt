��Java�����е�������^����Object������@�����ă��c֮һ������ʹ��һЩ����������Y�ϽY�����׹������������Ԍ��κ��͑B���������Vector�С�

Ȼ���F���Ђ����}�ǣ�������ļ��ϣ�connection������в��H����һ�N�͑B������������Ҫ���@Щ�������һЩ���e���Ĳ�������Ҫ�l������Ҫ֪��ԓ������͑B��ʹ�� instanceof �ƺ��ǂ����e�ķ�ʽ���ڳ�ʽ���ε���r�£�Ҳ�S�����@�N����

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
         ���� if (o instanceof ElementA)
���� ����     (ElementA) o.operationA();
        ���� else if (o instanceof ElementB)
���� ����     (ElementB) o.operationB();
����         else if (o instanceof ElementC)
���� ����     (ElementC) o.operationC();
����         else
���� ����     System.out.println("Sorry! I don't know who you are! " + o.toString());
//....



�@�N���K���ǲ����ԣ�ֻ���ڌ�����M�в�����ͬ�r��߀����ڳ�ʽ���M���͑B�Д࣬����ʹ�ó�ʽ�a�@ʾ�s�y���Ҍ���ĔU���Բ��������������Ҫ����һ����r��ʹ�Ì�ElementA��B��C���߶����һ�N�����Ĳ������̣����ĳ�ʽ�ݱ��挦�ܴ���޸ġ�

׌�҂����������ĽǶȁ�����ˣ������һ�����ķ����У�����f������Ҫ�ڷ������M�M��˼�Д��ˣ���Ȼ����֪�������l�����N�����M���L���Һ��ˣ��Ҹ��V�������l���@�Nһ������֪����β������ˣ���

�҂��ó�ʽ�팍�F�����@��������

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



���ÿһ�����FElement��������f��������Visitor���L��������accept()�����У� Visitorʹ�����_�ķ������L��Element���@Ȼ�ģ��@�N���ݿ��Կ���ͬ�ĺ�ʽ���Q�����Ƕ��doverload���_�ɣ����K��visit()�Ќ� Element���������Ĳ������҂��������еĽY��������Σ�


do A's job....such-and-such....
do B's job....such-and-such....
do C's job....such-and-such....



�@��ģʽ�K��ֻ�Ў�������ʡif...else���韩���ѡ�

���OVisitorAֻ�ǂ��ж�����N�T���ˣ�������һ�����^�ڿ�����N�TVisitorB�����L���^Element֮�ᣬ����Element��������Ĳ�����Ҫ�ڳ�ʽ�Ќ��FVisitorB���҂�ֻҪ����һ��VisitorBe�Ϳ����ˣ�

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



�҂���һ��Main��ʾ�������ɂ�Visitor�քe��������О������Σ�

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



���нY����

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



�ڹ����е�System.out.println();ֻ�ǂ�ʾ�⣬��Ҳ����������Element���~�ⷽ����ֱ���{�á�

�L����ģʽ��UML�Y��D���£�


��Java World����һƪ���£��ᵽ��������reflection����Mʹ���L����ģʽ�r�ď��ԣ����dȤ�Ŀ����Mһ������һ�£�
http://www.javaworld.com/javaworld/javatips/jw-javatip98.html

PS. ��Gof�����ṩsingle-dispatch�cdouble-dispatch�ĸ���mȻ�Ҵ����ϲt�����е���˼�����]�Ќ��H���|�^double-dispatch���Z�ԣ������ڴ��������^�����dȤ�Ŀ������Ѕ���Gof�ĕ����� 