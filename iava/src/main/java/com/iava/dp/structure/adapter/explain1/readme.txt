����һ����ˣ�ֽ�ϵıʼ�д�˲��٣���һֱû�л�������������ְ�ˣ��������ʱ������һ���Լ��ıʼǣ�Ҳ˳��ḻһ���Լ��Ĳ��Ͱɣ�Ҫ��Ҳ��ĶԲ���������Ǳˮ�����ʱ�䡣

������:�������������ṩ�ķ�����ͻ��ṩ�ӿڣ�������ͻ�������

                                                        ��Java���ģʽ��

��������
�ͻ��Ŀ�����Ա������һ���ӿڣ�����������ӿ��������������Ͳ������ӿڶ������£�
Java����

   1. public interface Operation{  
   2.       public int add(int a,int b);  
   3. }  

public interface Operation{
      public int add(int a,int b);
}


������Ա���˽�����ӿڵĶ���󣬷���һ���������࣬������һ��������ʵ�����������Ĺ��ܣ���������£�
Java����

   1. public class OtherOperation{  
   2.       public int otherAdd(int a,int b){  
   3.            return a + b;  
   4.       }  
   5. }  

public class OtherOperation{
      public int otherAdd(int a,int b){
           return a + b;
      }
}


���ϵ�������OtherOperation�ķ���public int otherAdd(int a,int b)���ṩ�Ĺ��ܣ���ȫ�ܷ��Ͽͻ�������������ֻ��Ҫ��취��OtherOperation��otherAdd(int a,int b)�Ϳͻ���Operation�ӿ���ϵ���������������������Ϊ�ͻ��ṩ���������ķ�������ˣ������ͱ����˿�����Ա�ٶ�ȥ�о�����OtherOperation��otherAdd(int a,int b)������ʵ�֣��������е����ӣ������ظ����������ⷽ��֮һ��������������ģʽ��
Java����

   1. public class AdapterOperation extends OtherOperation implements Operation{  
   2.       public int add(int a,int b){  
   3.            return otherAdd(a,b);  
   4.       }  
   5. }  

public class AdapterOperation extends OtherOperation implements Operation{
      public int add(int a,int b){
           return otherAdd(a,b);
      }
}


���Ͼ�����������ʵ�ַ���֮һ������������������ʵ���д��������н�ɫ�ֱ��ǣ�
1������Ŀ���ɫ��Operation��
2�������ࣨԭ����ɫ��OtherOperation��
3����������ɫ��AdapterOperation��
������������ɫ��������ģʽ�ĺ��ġ�
����������Ҫ��������ͨ����װ���еĹ��ܣ�ʹ��������Ҫ�Ľӿڡ�

����������
��������������һ�������
����ͻ��ӿ������Ĺ��ܲ�ֹһ�������Ƕ����
Java����

   1. public interface Operation{  
   2.       public int add(int a,int b);  
   3.       public int minus(int a,int b);  
   4.       public int multiplied(int a,int b);  
   5. }  

public interface Operation{
      public int add(int a,int b);
      public int minus(int a,int b);
      public int multiplied(int a,int b);
}


�����ṩ��Щʵ�ֵ�ԭ���ܲ�ֹһ����
Java����

   1. public class OtherAdd{  
   2.       public int otherAdd(int a,int b){  
   3.            return a + b;  
   4.       }  
   5. }  
   6.   
   7. public class OtherMinus{  
   8.       public int minus(int a,int b){  
   9.            return a - b;  
  10.       }  
  11. }  
  12.   
  13. public class OtherMultiplied{  
  14.       public int multiplied(int a,int b){  
  15.            return a * b;  
  16.       }  
  17. }  

public class OtherAdd{
      public int otherAdd(int a,int b){
           return a + b;
      }
}

public class OtherMinus{
      public int minus(int a,int b){
           return a - b;
      }
}

public class OtherMultiplied{
      public int multiplied(int a,int b){
           return a * b;
      }
}


����java�ǲ���ʵ�ֶ�̳еģ��������ǲ���ͨ������һ�����������������̳�����ԭ��������ǵ���������ʱ����ô����?ֻ��������������һ��ʵ��--������������
Java����

   1. public class AdapterOperation implements Operation{  
   2.       private OtherAdd add;  
   3.       private OtherMinus minus;  
   4.       private OtherMultiplied multiplied;  
   5.   
   6.       public void setAdd(OtherAdd add){  
   7.             this.add = add;  
   8.       }  
   9.   
  10.       public void setMinus(OtherMinus minus){  
  11.             this.minus = minus;  
  12.       }  
  13.   
  14.       public void setMultiplied(OtherMultiplied multiplied){  
  15.             this.multiplied = multiplied;  
  16.       }  
  17.   
  18.       //����ӷ�����  
  19.       public int add(int a,int b){  
  20.            return add.otherAdd(a,b);  
  21.       }  
  22.   
  23.       //�����������  
  24.       public int minus(int a,int b){  
  25.           return minus.minus(a,b);  
  26.       }  
  27.   
  28.       //����˷�����  
  29.       public int multiplied(int a,int b){  
  30.          return multiplied.multiplied(a,b);  
  31.       }  
  32. }  

public class AdapterOperation implements Operation{
      private OtherAdd add;
      private OtherMinus minus;
      private OtherMultiplied multiplied;

      public void setAdd(OtherAdd add){
            this.add = add;
      }

      public void setMinus(OtherMinus minus){
            this.minus = minus;
      }

      public void setMultiplied(OtherMultiplied multiplied){
            this.multiplied = multiplied;
      }

      //����ӷ�����
      public int add(int a,int b){
           return add.otherAdd(a,b);
      }

      //�����������
      public int minus(int a,int b){
          return minus.minus(a,b);
      }

      //����˷�����
      public int multiplied(int a,int b){
         return multiplied.multiplied(a,b);
      }
}


�����������ԣ�������������ͨ���̳�����ȡ�����ࣨԭ���Ĺ��ܵģ�����ͨ��������Ķ�������ȡ�ģ���ͽ����java���ܶ�̳��������Ĳ����ˡ���Ҳ��java�ᳫ�ı��˼��֮һ��������ʹ�þۺϲ�Ҫʹ�ü̳С�
����һ���������Ҫʹ�ö����������ġ�������������
�����ǵĿͻ��ṩ�����󲢲���һ����ȷ�Ľӿڣ�����һ���࣬��û�ж��������ķ���������
Java����

   1. public class A{  
   2.    public int add(int a,int b){  
   3.       return a + b;  
   4.    }  
   5. }  

public class A{
   public int add(int a,int b){
      return a + b;
   }
}


���ڿͻ�Ҫһ������B��Ҫ�����ڱ�����A���ܵ����������һ����������Ĺ��ܣ���Ҫ��B����ʱ�滻��A�����ܶ�����ϵͳ���Ӱ�졣��������ֻ���½�һ����B������B�̳�A��
Java����

   1. public class B extends A{  
   2.     b(){  
   3.       super();  
   4.     }  
   5.   
   6.     public int minus(int a,int b){  
   7.            //��ʵ�ֵļ������㺯��..  
   8.     }  
   9. }  

public class B extends A{
    b(){
      super();
    }

    public int minus(int a,int b){
           //��ʵ�ֵļ������㺯��..
    }
}


��ʱ�����Ƿ�����C�Ѿ��ṩ��ʵ�ּ����ĺ�����
Java����

   1. public class C{  
   2.     public int minus(int a,int b){  
   3.            return a - b;  
   4.     }  
   5. }  

public class C{
    public int minus(int a,int b){
           return a - b;
    }
}


Ϊ�˱����ظ�ȥ��Ƹú��������Ǿ�������C�࣬ͨ������C�����ﵽ���ǵ���������������A��C����һ�������࣬�����޷���Bͬʱ�̳���������࣬��B�̳�A���Ǳ���ģ���������ֻ�ܿ��ǰ�C���ھ۵�B�ڲ��������������ֵ������ó��ˡ�
Java����

   1. public class B extends A{  
   2.   
   3.     private C c;  
   4.   
   5.     B(){  
   6.       super();  
   7.     }  
   8.   
   9.     public void setMinus(C c){  
  10.          this.c= c;  
  11.     }  
  12.   
  13.     public int minus(int a,int b){  
  14.            return c.minus(a,b);  
  15.     }  
  16. }  

public class B extends A{

    private C c;

    B(){
      super();
    }

    public void setMinus(C c){
         this.c= c;
    }

    public int minus(int a,int b){
           return c.minus(a,b);
    }
}


����������ҪA��ĵط�������B�������棬ͬʱ�ֱ�֤���µĹ��ܵ����롣

������ʵ��--����Ŀ��ӿڵĳ���������

��java ����Ӧ�õĶ�֪��WindowListener�ӿڣ�
Java����

   1. public interface WindowListener extends EventListener{  
   2.  public void windowActivated(WindowEvent e)��  
   3.  public void windowClosed(WindowEvent e)��  
   4.  public void windowClosing(WindowEvent e)��  
   5.  public void windowDeactivated(WindowEvent e)��  
   6.  public void windowDeiconified(WindowEvent e)��  
   7.  public void windowIconified(WindowEvent e)��  
   8.  public void windowOpened(WindowEvent e)��  
   9. }  

public interface WindowListener extends EventListener{
 public void windowActivated(WindowEvent e)��
 public void windowClosed(WindowEvent e)��
 public void windowClosing(WindowEvent e)��
 public void windowDeactivated(WindowEvent e)��
 public void windowDeiconified(WindowEvent e)��
 public void windowIconified(WindowEvent e)��
 public void windowOpened(WindowEvent e)��
}


Ҫʵ������ӿڣ����Ǿͱ���ʵ��������������з���������ʵ���ϣ����Ǻ�����Ҫͬʱ�õ����еķ���������Ҫ��ֻ�����е���������Ϊ�˲�ʹ����ʵ�ֶ���ķ�����
jdk WindowListener�ṩ��һ��WindowListener��Ĭ��ʵ����WindowAdapter�࣬����һ�������࣬
Java����

   1. public abstract class WindowAdapter implements WindowListener{  
   2.  public void windowActivated(WindowEvent e){}  
   3.  public void windowClosed(WindowEvent e){}  
   4.  public void windowClosing(WindowEvent e){}  
   5.  public void windowDeactivated(WindowEvent e){}  
   6.  public void windowDeiconified(WindowEvent e){}  
   7.  public void windowIconified(WindowEvent e){}  
   8.  public void windowOpened(WindowEvent e){}  
   9. }  

public abstract class WindowAdapter implements WindowListener{
 public void windowActivated(WindowEvent e){}
 public void windowClosed(WindowEvent e){}
 public void windowClosing(WindowEvent e){}
 public void windowDeactivated(WindowEvent e){}
 public void windowDeiconified(WindowEvent e){}
 public void windowIconified(WindowEvent e){}
 public void windowOpened(WindowEvent e){}
}


WindowAdapter���WindowListener�ӿڵ������з������ṩ�˿�ʵ�֣�
����WindowAdapter�࣬����ֻ��Ҫȥ�̳�WindowAdapter��Ȼ��ѡ�����������ĵķ�����ʵ�־����ˣ������ͱ�����ֱ��ȥʵ��WindowListener�ӿڡ� 