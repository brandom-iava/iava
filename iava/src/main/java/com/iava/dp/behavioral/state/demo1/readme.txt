�������⣺
�����Coding��ʱ����û���õ��ܶ��ѡ����䣿��������
Java����

   1. if(��)  
   2. {  
   3.        ��  
   4. }  
   5. else if(��)  
   6. {  
   7.        ��  
   8. }  
   9. else if(��)  
  10. {  
  11.        ��  
  12. }  
  13. else  
  14. {  
  15.        ��  
  16. }  

if(��)
{
       ��
}
else if(��)
{
       ��
}
else if(��)
{
       ��
}
else
{
       ��
}



���Ǿ�����������������ĵط�������struts��ҵ���߼��D�DAction��ʵ�ֵ���� ��ǰ�ĳ���Ա��ţB��Coding�������ѡ�just can run ��Ϊ���ձ�׼��

�����������:
Java����

   1. public ActionForward execute(ActionMapping mapping, ActionForm form,  
   2. HttpServletRequest request, HttpServletResponse response)   
   3.          throws java.lang.Exception  

public ActionForward execute(ActionMapping mapping, ActionForm form,
HttpServletRequest request, HttpServletResponse response) 
         throws java.lang.Exception


��ʵ�֣�һ�㶼��һ���������д2000��3000�д��룬���������Ľṹ�����⡣

       ����׼ʾ�������Ǹո��ϱ��г�����if��else if��else����䣬����������౻�����ж��ύ��ʲô������Ȼ����ġ���Ȼ���������ڲ��ϱ仯�еģ�ÿ���¼���һ��ҵ����ύ�����ʱ����ô���أ���������˵�ѡ���������һ��else if�ĺ��棬else��ǰ�棬���һ��else if����^_^����˴�������������һ�γ������������n��else if��Ȼ��ά���ּ���n��������2000�еĺ������������ǧ�С�������һ����������ǧ�У�����׳��Ҳ������
       ��ˣ��Ҿ��ã�����Ա��д�ж�����ʱ�����˶��else if��Ӧ��С��һ���ˣ���������ĳλ��ʦ��˵�ģ����ڴ����м����ˡ���ζ�����������������ʣ���Ϊ���������롱�ġ�

������⣺
��ô���ڳ���Ҫʹ�ö���жϣ������ж��߼������ı��ʱ���ʱ��������β��ܷ�ֹ���븯���أ�
�D�Dʹ��stateģʽ����һ���ȽϺõķ���

Stateģʽ���ܣ�
tateģʽ���ڶ�����Ϊ��ģʽ��

��ͼ������һ�����������ڲ�״̬�ı�ʱ�ı�������Ϊ

���ó�����
1.һ���������Ϊȡ��������״̬������������������ʱ�̸���״̬�ı�������Ϊ��
2.һ�������к����Ӵ�Ķ��֧�ṹ��������Щ��֧�����ڶ����״̬��

�����ǳ���GoF��DesignPatterns�Ĺٷ����ͣ����ǹ�ᵽƽ��ʹ���У�����Ϊ�������ó����������if��if else��else���֧��ʵ�ָ�������ƣ���ֹ���븯����
���Կ����������ᵽ�ġ�����ʾ�������Ǹ����͵ĵ�2������

Stateģʽʾ����

һ��ʼ��������ô��Context�࣬������и�state��Ա����state�ı�ʱ��������Ҫ�����ĸı��ӡ����������Ȼ�����ǵü��������ӡ��ʵ���߼��Ǳ˴˲�ͬ�ģ���

�ȿ�һ��
�����ʵ�֣�
Java����

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


������ʵ�ַ����ı׶˸տ�ʼ�Ѿ������ĺ�����ˣ����������Ҫ�ټ�һ��״̬�� fourth��������Ҫ�ټ�һ��ʵ�֡�printImplFourth()����Ȼ���ڡ����һ��else if�ĺ��棬else��ǰ�棬���һ��else if���������͵�ʹ������ʵķ�����



��ô����ʹ��Stateģʽ��ʵ�ְɣ�

������������һ��������State���Ժ����е�ʵ�ֶ��̳��������ʵ������handle������

������Context�м����ԱState����ʾContext�ĵ�ǰ״̬,

Ȼ������ж�Context��state�Ĵ���ͨ���̳�State��������ʵ�֡�

��������ͼ������������ͼ��������stateģʽ��strategyģʽ����ͼ�Ƿǳ����Ƶģ�

(������)
State������Ĵ��룺
Java���� 

package patterns.state;
import patterns.state.impl.Context;

public abstract class State {
    public abstract void handle(Context context);
    public abstract void changeState(Context context);
}

 
State�ļ���ʵ�ִ��룺��ֻд����һ��������ʵ����֮����)
Java����

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
Java����

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
  
Context���ʵ�ִ��룺
Java����

   1. package patterns.state.impl;  
   2.   
   3. import patterns.state.State;  
   4.   
   5. public class Context {  
   6.     // context�ĵ�ǰ״̬  
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

���ˣ�����Stateģʽ��ʵ��д���ˡ�
��������ʲôʱ���봦��stateΪfirst��ʱ��ֻ��Ҫ

Java����

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


ͨ��ʹ����Stateģʽ������Context��״̬�ı���ٴΣ�����˶��ٸ�״̬�����Ƕ�����Ҫ�޸�����Դ���룬��ֻ��ͨ������µ�ʵ�ַ����Ϳ��Ը㶨�ˣ������ﵽ�˷�ֹ�����븯������Ŀ�ġ�

Stateģʽ���ص㣺

Stateģʽ����һ����������ڲ�״̬��ӵ�в�ͬ����Ϊ

Stateģʽ����ʹ�������״̬

Context�Ὣ��Ϊί�и���ǰ����

ͨ����ÿ��״̬��װ��һ���࣬���ǰ��Ժ���Ҫ�����κθ��ľֲ�����

״̬��state����ת��������StateHandler�����context��������

״̬�����ࣨStateHandler�����Ա����Contextʵ������

ʹ��״̬ģʽ���ᵼ������������Ŀ��������



��Ҫע��ĵط�:
1. state֮���ת��. State��ת��������State���ڲ����, ��������������������Ǹ���State֮������˹���, ��ô���һ��State����ı�(����, ����) ������ܴ�Ӱ��, ����п��ܿ�����ǰ�����ı��state�Ƿ�ҲӰ�쵽��������state��ִ��. ����������ͬ�µ����۷���Ҳ�����������. ����һ��, state��ת��Ҳ���������������Context��setState()�����, �о�������������ɿ�, ��Ϊ�����Ļ�������ͱ���֪��context���ض�state, �����˲���Ҫ�����, ��˽����setState()�ĵ��þ�������Context��State������.


2. State�Ĵ���������. ��������: 1.��context�ڲ���������state, һֱά���Ӳ�����.2.��״̬ת����ʱ��Ŵ���, Ȼ����һ��state��JVM�Զ�����. ��Ҫԭ����Ҫ��ʵ�������Context��State�ı仯�Ƿ�Ƶ��, �����Ƶ��, �����õڶ���,�Ƚ�����.




�ܽ᣺

1.������Ҫʹ��̫���֧����䡣
2.�����������һ���������Ҫ�����Ƿ���Ҫ�ѹ��ָܷ��ˡ������д�˸�3000�еġ��������ĺ������Ժ�ά�����˻�ܲ�ˬ��Ҳ���⵽bs�ġ�
3.���������������ʹ��̫���֧�ҷ�֧�����ĳһ��״̬�й��Ҿ����ı䣬�ǿ��Կ���ʹ��stateģʽ����ֹ����������
4.�μ�OO���ԭ�򣺡��ҳ�Ӧ������Ҫ�仯֮���������Ƕ�����������Ҫ����Щ����Ҫ�仯�Ĵ������һ�𡱡� 
Ո��..Conext�O�à�B�Լ�������B�O�Ì���ԓ��B���О����ҲҪ��if else�Z���N��
߀��Ó���_��. 


ʹ��stateģʽ����ͼ����������if...else...�����ʧ��
����ȡ������������������

1.һ���������Ϊȡ��������״̬������������������ʱ�̸���״̬�ı�������Ϊ��
2.һ�������к����Ӵ�Ķ��֧�ṹ��������Щ��֧�����ڶ����״̬��

�����ڽ������ʱ�������������ĳ�����ʱ�򣬲��б�Ҫ����ʹ��stateģʽ��


���⣬Ӧ����OOD�ĺ���ʱ�������ʵĳ�����ʹ�á����ģʽ����
�������Ϊ��ʹ��ĳ��ģʽ����ȥ��ƣ��ͱ�ĩ�����ˡ�
����ѧϰ���ģʽ��ʱ����ȷ������ģʽ��ʹ�õġ���ͼ����Ҳ�Ǻ���Ҫ��


