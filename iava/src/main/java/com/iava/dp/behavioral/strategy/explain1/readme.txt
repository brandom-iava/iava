������������Java���﷨���������˽����������ķ�װ���̳С���̬�����ԣ������ǿ�����Swing��Servlet��JSP�������������Լ� WebӦ�ã�
����ζ�����ǿ���д���������ĳ��򣬲���ζ�����ǿ��Ժܺõ�ʵ�ִ��븴�ã�����ά��������ζ�����ǿ���ʵ����ά������չ�����ϵĴ��븴�á�
һ�ѵ�������ʹ���Ƶ������ζ��ڽ���������Ҳ����ֻ��һ�����ж�ʹ���в�ƽ����Java��������ѵ�����������ȡ������ʹ�õķ�ʽ��
�����������޾���ֹ�ظ���������ӣ�����������ǣһ������ȫ���ά������, ��Ӧ���������ģʽ������ж����š��������ľ��壬����ƽ����
��ʵҪ�������ʵ�����ܳɹ���������OOϵͳ�������������Ǳ�ǰ���Ѽ����ɲ����ԡ����ģʽ��֮��������Ӧ���ڱ����ж���ʼ��Я����������������
�����ǲ��������顱������֮�����й����֡���ʵ�ʰ�������ģʽ�����Ǵ����Ȼһ�µĸı䣺

 

���ģʽ���֮һ�� ����ģʽ

 

    1. ģʽ����
   
        �ѻ�仯������ȡ������װ�������Ա��Ժ�������׵ظĶ������䲿�֣�����Ӱ�첻��Ҫ�仯���������֣�

    2. ����Ե��

    ���漰������ά��ʱ��Ϊ�˸���Ŀ�Ķ�ʹ�ü̳У���ֲ����������Ը�����޸ģ���Ӱ�쵽�����͡��ڳ��������ӵķ������ᵼ���������и÷�����
    ��������Щ���þ߱��÷�����������Ҳ�޷������ʾ����һ��Ѽ�����ͣ�

    public abstract class Duck {
        //���е�Ѽ�Ӿ�����Լ���Ӿ�����Ը����д����ⲿ�ִ���
        public void quack() {
            System.out.println("Quack");
        }
       
        public void swim() {
            System.out.println("All ducks float, even decoys.");       
        }
       
        //��Ϊÿ��Ѽ�ӵ�����ǲ�ͬ�ģ����Ը����и÷����ǳ���ģ����������Լ���ɡ�
        public abstract void display();
    }

    public class MallardDuck extends Duck {
        //ҰѼ�����ʾΪ��ͷ
        public void display() {
            System.out.println("Green head.");
        }
    }

    public class RedHeadDuck extends Duck {
        //��ͷѼ��ʾΪ��ͷ
        public void display() {
            System.out.println("Red head.");
        }
    }

    public class RubberDuck extends Duck {
        //��ƤѼ����Ϊ֨֨�У�������д�����Ը�д��Ϊ
        public void quack() {
            System.out.println("Squeak");
        }

        //��ƤѼ��ʾΪ��ͷ
        public void display() {
            System.out.println("Yellow head.");
        }
    }

    �������룬��ʼʵ�ֵ÷ǳ��á��������������Duck.java�м���fly()�����Ļ�����ô���������о����˸÷������������ǿ����˻�ɵ���ƤѼ�ӣ�
    �㿴���𣿵�Ȼ�����ǿ�����������ͨ����ʵ����д�÷����Խ���÷������������͵�Ӱ�졣���Ǹ����������������ķ����أ�

    ͨ���̳��ڸ������ṩ��Ϊ���ᵼ������ȱ�㣺

    a. �����ڶ���������ظ�;
    b. ����ʱ����Ϊ�����׸ı䣻
    c. �ı��ǣһ����ȫ����ɲ��������Ͳ���Ҫ�ĸı䣻

    ���������Ǹղ�Ѽ�ӵ����ӣ���Ҳ���뵽ʹ�ýӿڣ����ɵ���Ϊ���е���Ϊ����Ϊ�ӿڣ�Ȼ����Duck�ĸ���������ʵ����Щ�ӿڡ���ʱ����������ڣ�

    public abstract class Duck {
        //���仯����Ϊ fly() �Լ�quake()��Duck���з����ȥ�����γɽӿڣ������������������ȥʵ��

        public void swim() {
            System.out.println("All ducks float, even decoys.");       
        }
       
        public abstract void display();
    }

    //�仯�� fly() ��Ϊ�����γɵĽӿ�
    public interface FlyBehavior {
        void fly();
    }

    //�仯�� quack() ��Ϊ�����γɵĽӿ�
    public interface QuackBehavior {
        void quack();
    }

    //ҰѼ�ӻ���Լ��У�����ʵ�ֽӿ�  FlyBehavior, QuackBehavior
    public class MallardDuck extends Duck implements FlyBehavior, QuackBehavior{
        public void display() {
            System.out.println("Green head.");
        }

        public void fly() {
            System.out.println("Fly.");               
        }

        public void quack() {
            System.out.println("Quack.");               
        }
    }

    //��ͷѼ�ӻ���Լ��У�����Ҳʵ�ֽӿ�  FlyBehavior, QuackBehavior
    public class RedHeadDuck extends Duck implements FlyBehavior, QuackBehavior{
        public void display() {
            System.out.println("Red head.");
        }   

        public void fly() {
            System.out.println("Fly.");               
        }

        public void quack() {
            System.out.println("Quack.");               
        }   
    }

    //��ƤѼ����ɣ�����֨֨�У�����ֻʵ�ֽӿ�QuackBehavior
    public class RubberDuck extends Duck implements QuackBehavior{
        //��ƤѼ����Ϊ֨֨��
        public void quack() {
            System.out.println("Squeak");
        }

        //��ƤѼ��ʾΪ��ͷ
        public void display() {
            System.out.println("Yellow head.");
        }
    }

    ����������Ȼ�����һ�������⣬�������Ϳ�����ѡ����ṩһЩ��Ϊ(���� fly() �����������������ƤѼ��).������Ҳ������
    ҰѼ��MallardDuck.java�ͺ�ͷѼ��RedHeadDuck.java��һЩ��ͬ��Ϊ���벻�ܵõ��ظ�ʹ�á��ܴ�̶������Ǵ�һ�����������һ����ӡ�

    ��һ�γ���֮�������Ǵ�ϸ��������������עһЩ�������⡣����ʹ��ʲô���ԣ�����ʲôӦ�ã�����������ϣ�һֱ�����ŵĲ���������ǣ�
    ��Ҫһֱ�ڱ仯�����ܵ��������Ƶö�ã�һ��ʱ��֮��������Ҫ�ɳ���ı䣬��������ͻ�������

    ����֪�����̳���ĳ�̶ֳ��Ͽ���ʵ�ִ������ã����Ǹ���(����Ѽ����Duck)����Ϊ�����������ǲ��ϱ仯�ģ������������Ͷ�����Щ��Ϊ�ǲ�ǡ���ġ����ǿ��Խ���Щ��Ϊ����Ϊ�ӿڣ�
    ��Duck�ĸ���������ȥʵ�֣����ӿڲ�����ʵ�ִ��룬����ʵ�ֽӿ��޷��ﵽ���븴�á�����ζ�ţ���������Ҫ�޸�ĳ����Ϊ����������׷�ٲ���ÿһ���������Ϊ�������޸�����һ��С�ģ�������µĴ���

    ���ԭ�򣺰�Ӧ���б仯�ĵط�������������Ҫ����Щ����Ҫ�仯�Ĵ������һ����������仯����Ĳ����������٣�ϵͳ��ø��е��ԡ�

    �����������ԭ��������������֮ǰ��Duck���롣

    1) �ֿ��仯�����ݺͲ��������

       Duck���е���Ϊ fly(), quack(), ÿ�������Ϳ������Լ����еı��֣��������ν�ı仯�����ݡ�
           Duck���е���Ϊ swim() ÿ�������͵ı��־���ͬ���������ν��������ݡ�

       ���ǽ��仯�����ݴ�Duck()���а���������������γɽӿ��Լ�һϵ�е�ʵ�����͡����仯�����ݶ����γɽӿڿ�ʵ�ֱ仯���ݺͲ������ݵİ��롣��ʵ�����Ϳ�ʵ�ֱ仯���ݵ����á�
       ��Щʵ���ಢ��Duck.java�������ͣ�����ר�ŵ�һ��ʵ���࣬��֮Ϊ"��Ϊ��"������Ϊ�������Duck.java����������ʵ�ֽӿڡ����������ܱ�֤�仯����Ϊ�����ڲ�������ݡ����������У�

       �仯�����ݣ�

       //�仯�� fly() ��Ϊ�����γɵĽӿ�
       public interface FlyBehavior {
        void fly();
       }
        
       //�仯�� fly() ��Ϊ��ʵ����֮һ
       public class FlyWithWings implements FlyBehavior {
        public void fly() {
            System.out.println("I'm flying.");
        }
       }

       //�仯�� fly() ��Ϊ��ʵ����֮��
       public class FlyNoWay implements FlyBehavior {
        public void fly() {
            System.out.println("I can't fly.");
        }
       }

           -----------------------------------------------------------------

       //�仯�� quack() ��Ϊ�����γɵĽӿ�
       public interface QuackBehavior {
        void quack();
       }

       //�仯�� quack() ��Ϊʵ����֮һ
       public class Quack implements QuackBehavior {
        public void quack() {
            System.out.println("Quack");
        }
       }

       //�仯�� quack() ��Ϊʵ����֮��
       public class Squeak implements QuackBehavior {
        public void quack() {
            System.out.println("Squeak.");
        }
       }

       //�仯�� quack() ��Ϊʵ����֮��
       public class MuteQuack implements QuackBehavior {
        public void quack() {
            System.out.println("<< Slience >>");
        }
       }

       ͨ��������ƣ�fly()��Ϊ�Լ�quack()��Ϊ�Ѿ���Duck.javaû��ʲô��ϵ�����Գ�ֵõ����á��������Ǻ����������µ���Ϊ, �Ȳ�Ӱ�����е���Ϊ��Ҳ��Ӱ��Duck.java�����ǣ���ҿ����и����ʣ�
       �����������������Ϊ��������Ϊ������Ϊʲô���ڱ������γ���(���� Squeak.java)����OO�У�������"����"һ���Ǽ���״̬(ʵ�����������з�����ֻ���ڱ���������"����"�Ǹ���Ϊ����ʹ����Ϊ��
       Ҳ�����Լ����������������Ϊ��Ҳ��ҪһЩ���Լ�¼���е�״̬������и߶ȡ��ٶȵȡ�

    2) ���ϱ仯�����ݺͲ��������

       Duck.java�� fly()�Լ�quack()����Ϊί�ϸ���Ϊ�ദ��

       ��������ݣ�

       public abstract class Duck {
            //����Ϊ������Ϊ�ӿ����ͣ����Ͷ���Ϊʵ�����͵�����
        FlyBehavior flyBehavior;
        QuackBehavior quackBehavior;

        public void performFly() {
            //�����д���fly()��Ϊ������ί�ϸ�����flyBehavior��ָ�����Ϊ����
            flyBehavior.fly();
        }

        public void performQuack() {
            quackBehavior.quack();
        }

        public void swim() {
            System.out.println("All ducks float, even decoys.");       
        }
       
        public abstract void display();
       }

       Duck.java��������ν��� fly()�Լ�quack(), ��Щϸ�ڽ��ɾ������Ϊ����ɡ�
      
       public class MallardDuck extends Duck{
        public MallardDuck() {
            flyBehavior=new FlyWithWings();
            quackBehavior=new Quack();       
        }
       
        public void display() {
            System.out.println("Green head.");
        }
       }

           �����ࣺ

       public class DuckTest {
        public static void main(String[] args) {
            Duck duck=new MallardDuck();
            duck.performFly();
            duck.performQuack();       
        }
       }

       ��Duck.java������MallardDuck.java�Ĺ��췽���У�ֱ��ʵ������Ϊ���ͣ��ڱ����ʱ���ָ��������Ϊ���͡���Ȼ�����ǿ��ԣ�
      
       1) ���ǿ���ͨ������ģʽ������ģʽ��һ����ź(�ɲο�����ģʽ����);
       2) ������������ʱ��̬�ظı���Ϊ��

    3) ��̬�趨��Ϊ

       �ڸ���Duck.java�������趨��Ϊ���͵�setter������������Ϊ���Ͷ���Ĳ������롣Ϊ�˽�ź����Ϊ����������Ϊ�ӿ����͡��������ȱ�������ʱ��Ҳ����ͨ����������������Ըı���Ϊ��

       public abstract class Duck {
        //�ڸղ�Duck.java�м������¶���������
        public void setFlyBehavior(FlyBehavior flyBehavior) {
            this.flyBehavior=flyBehavior;
        }
       
        public void setQuackBehavior(QuackBehavior quackBehavior) {
            this.quackBehavior=quackBehavior;
        }

        //��������ͬ��ʡ��...
       }

           �����ࣺ

       public class DuckTest {
        public static void main(String[] args) {
            Duck duck=new MallardDuck();
            duck.performFly();
            duck.performQuack();
            duck.setFlyBehavior(new FlyNoWay());
            duck.performFly();
        }
       }

       ���������Ҫ���ϻ�������ķ�����Ϊ��ֻ�����½�FlyBehavior.java�ӿڵ�ʵ�����͡��������Ϳ�ͨ������setQuackBehavior(...)������̬�ı䡣���ˣ�
       ��Duck.java�����µ���Ϊ�����Ǵ����������������Ѳ������ڡ�

    �����ܽ��ʱ���ˣ������ǴӴ����ˮ�и���������һֻ��ˮ���������ζ���Ѽ�Ӱ�:

    3.  �������

        MallardDuck �̳�  Duck�����ࣻ          -> ���������
        FlyWithWings ʵ�� FlyBehavior�ӿڣ�     -> �仯������,��Ϊ���㷨
    ��Duck.java�ṩsetter������װ���ϵ��    -> ��̬�趨��Ϊ

    ���Ͼ��ǲ���ģʽ��ʵ������������������������͸�����迴����:
   
    1) ��ʼ������ͨ���̳�ʵ����Ϊ�����ã������˴����ά�����⡣          -> �̳�, is a
    2) ���ţ����ǽ���Ϊ����ɵ��������Ͳ�����Ϊ�������ݵ�ʵ��������ͨ��  -> ���, has a
       setter������װ���ϵ��

        �̳У�����ʵ�־�̬����ĸ��ã���ϣ�����ʵ�ִ���ĵ���ά����ʹ����ϴ���̳У�����ʹ������õ���Ӧ���������������仯��

    ����ģʽ�ı��ʣ����ü̳У��������