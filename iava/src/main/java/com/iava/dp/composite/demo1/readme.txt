���ģʽ��һ����ǡ����壬���֡��ĸ����java��ģʽ�о���һ����Ҿ��������Ĺ��£������󣬴�ǰ����ɽ��ɽ�������������и��Ϻ��и�С���н����£����������ǣ���ǰ����ɽ......һֱ������ȥ�������￴����������������£���������Ĺ������ǲ��֡���Ҳ��һ���򵥵����ģʽ��

      ���ģʽ������Ͳ��ֵĹ�ϵ���������ʾ������ʹ�ÿͻ��˰�һ�������ĳɷֶ���͸��϶���ͬ�ȶԴ���

      ���ģʽ��Ϊ��ȫʽ��͸��ʽ��

     ���ȿ�����ȫʽ��

     ����ӿ�
Java����

   1. public interface Component {  
   2.      public void sampleOperation();  
   3. }  

public interface Component {
	 public void sampleOperation();
}

 

��֦������ɫ�Ǿ����ʵ����
Java����

   1. public class Composite implements Component {  
   2.   
   3.     private Vector componentVector = new Vector();  
   4.       
   5. /** 
   6.  * ı��ҵ�񷽷� 
   7.  * */  
   8.     public void sampleOperation() {  
   9.         Enumeration enumeration = components();  
  10.         while (enumeration.hasMoreElements()){  
  11.             ((Component)(enumeration.nextElement())).sampleOperation();  
  12.         }  
  13.     }  
  14.     /** 
  15.      * �ۼ�������������һ���ӹ������� 
  16.      * */  
  17.     public void add(Component component){  
  18.         componentVector.add(component);  
  19. //      System.out.println("++++++++++"+componentVector.size());  
  20.     }  
  21.     /** 
  22.      * �ۼ���������ɾ��һ���ӹ������� 
  23.      * */  
  24.     public void remove(Component component){  
  25.         componentVector.remove(component);  
  26. //      System.out.println("----------"+componentVector.size());  
  27.     }  
  28.     /** 
  29.      * �ۼ������������ؾۼ���Enumeration���� 
  30.      * */  
  31.     public Enumeration components(){  
  32.         System.out.println("**********"+componentVector.size());  
  33.         return componentVector.elements();  
  34.     }  
  35. }  

public class Composite implements Component {

	private Vector componentVector = new Vector();
	
/**
 * ı��ҵ�񷽷�
 * */
	public void sampleOperation() {
		Enumeration enumeration = components();
		while (enumeration.hasMoreElements()){
			((Component)(enumeration.nextElement())).sampleOperation();
		}
	}
	/**
	 * �ۼ�������������һ���ӹ�������
	 * */
	public void add(Component component){
		componentVector.add(component);
//		System.out.println("++++++++++"+componentVector.size());
	}
	/**
	 * �ۼ���������ɾ��һ���ӹ�������
	 * */
	public void remove(Component component){
		componentVector.remove(component);
//		System.out.println("----------"+componentVector.size());
	}
	/**
	 * �ۼ������������ؾۼ���Enumeration����
	 * */
	public Enumeration components(){
		System.out.println("**********"+componentVector.size());
		return componentVector.elements();
	}
}

 

���������ҵ�񷽷��⣬�������ˣ�add����remov�������˷������Զ��ӹ�������������ɾ����

��Ҷ������ɫҲʵ�ֳ��󹹽���ɫ��
Java����

   1. public class Leaf implements Component {  
   2.   
   3.     public void sampleOperation() {  
   4.         System.out.println("����Ҷ��");  
   5.     }  
   6.   
   7. }  

public class Leaf implements Component {

	public void sampleOperation() {
		System.out.println("����Ҷ��");
	}

}

 

���ͨ�����Կ���
Java����

   1. public class Client {  
   2.   
   3.     /** 
   4.      * @param args 
   5.      */  
   6.     public static void main(String[] args) {  
   7.         //������һ����  
   8.         Leaf l= new Leaf();  
   9.         l.sampleOperation();  
  10.   
  11.         //�����֦  
  12.         Composite allc = new Composite();  
  13.         //�����֦  
  14.         Composite c1 = new Composite();  
  15.         ((Composite)allc).add(c1);  
  16.         //����Ҷ��  
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
		//������һ����
		Leaf l= new Leaf();
		l.sampleOperation();

		//�����֦
		Composite allc = new Composite();
		//�����֦
		Composite c1 = new Composite();
		((Composite)allc).add(c1);
		//����Ҷ��
		((Composite)c1).add(new Leaf());
		((Composite)c1).add(new Leaf());
		((Composite)c1).remove(new Leaf());

		allc.sampleOperation();
	}

}

 

��������Կ�������֦���Ͽ��Թ���֦�ڣ���֦���Ͽ��Թ���Ҷ�� �����ҿ���ͨ��remove������ȥ��֦Ҷ�����Ҳ�����ٴδ�����һ����֦Ҷ��

 

����˵�¼������ʣ�

���󹹼���ɫ(Component)�����Ǹ������࣬һ����Ǹ��ӿڣ�������������ӿڣ���ȫģʽ�������ɫ������������Ӷ���ķ���

��Ҷ������ɫ(Leaf)����Ҷ����û���¼���ֻ����ԭʼ����

��֦������ɫ(Composite)������μ���ϵ��¼��Ӷ���Ķ��󣬻�������˹�������add��remove

 

͸��ʽ�����ǽ�ԭ��д��composite�еĹ�������д�ڽӿڵ��У�����ʵ����ʱ�ͱ���ʵ��������������������Ҷ�ӣ���������˵Ҷ�Ӳ����ܹ�����֦����Ҳ�����������������ҿͻ��˿��Ե��á�

 

 

 
������JavaEye���°�Ȩ�������ߣ��ܷ��ɱ�����û������������ɲ���ת�ء�
�Ƽ�����

    * ������ѵ� IBM DB2 Express-C ���ݿ�
    * �ڷ������������Ǽ���������
    * IBM Rational��������߷���̳9�½�Ļ

���ض�¥ 	
        ����޸ģ�2008-12-05

    * hanjs
    * �ȼ�: ������Ա
    * �û�ͷ��
    * ����: 111
    * ����: 0
    * ����: ����
    *

	
����ʱ�䣺2008-12-04
���� �ղ�
((Composite)allc).add(c1);  
        //����Ҷ��  
        ((Composite)c1).add(new Leaf());  
        ((Composite)c1).add(new Leaf());  
        ((Composite)c1).remove(new Leaf()); 

��֪����Ϊ����Ҫ����ǿ������ת�������Ѿ������������ 