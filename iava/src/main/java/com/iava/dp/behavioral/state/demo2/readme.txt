����ģʽ��״̬ģʽ��˫��̥,����ģʽ��Χ�ƿ��Ի������㷨�������ɹ�ҵ���,Ȼ��״̬ģʽ��ͨ���ı�����ڲ���״̬��������������Լ�����Ϊ.
�������渽������Ǹ�ͼ��û,���Լ��������,��������û��ϵ(�����׾�����,�Ǻ�),��Ϳ������ǹ�����״̬ͼ����:
������δ�״̬ͼ�õ������Ĵ�����?���������ҳ����е�״̬:
û��25��Ǯ//��25��Ǯ//�۳��ǹ�//�ǹ�����--------------�����״̬,����4��
������������ʵ���ǹ���:
Java����

   1. public class GumballMachine {  
   2.     //�������4��״̬,ÿ��״̬����һ����ͬ����������,���Ƿ���״̬ͼ  
   3.     final static int SOLD_OUT = 0;      //�ǹ�����  
   4.     final static int NO_QUARTER = 1;    //û��25��Ǯ  
   5.     final static int HAS_QUARTER = 2;   //��25��Ǯ  
   6.     final static int SOLD = 3;      //�۳��ǹ�  
   7.     //���ʵ���������ٵ�ǰ״̬,һ��ʼ����Ϊ"�ǹ�����",��Ϊ�ǹ�����װʱ��û��װ�ǹ���  
   8.     int state = SOLD_OUT;  
   9.     int count = 0;  //�����������׷�ٻ����ڵ��ǹ���Ŀ  
  10.     //��������ʼ�ǹ��������������,�����治Ϊ0�Ļ�,�����ͽ���"û��25��Ǯ"��״̬,������Ͷ��25��Ǯ  
  11.     public GumballMachine(int count) {  
  12.         this.count = count;  
  13.         if (count > 0) {  
  14.             state = NO_QUARTER;  
  15.         }  
  16.     }  
  17.     //����25��ǮͶ�����,�ͻ�ִ������  
  18.     public void insertQuarter() {  
  19.         if (state == HAS_QUARTER) {  
  20.             //�����Ͷ��25��Ǯ,֪ͨ�˿�  
  21.             System.out.println("You can't insert another quarter");  
  22.         } else if (state == NO_QUARTER) {  
  23.             //�������"û��25��Ǯ"��״̬��,���Ǿͽ���25��Ǯ,����״̬ת����"��25��Ǯ"  
  24.             state = HAS_QUARTER;  
  25.             System.out.println("You inserted a quarter");  
  26.         } else if (state == SOLD_OUT) {  
  27.             //����ǹ�����,�;ܾ���Ǯ  
  28.             System.out.println("You can't insert a quarter, the machine is sold out");  
  29.         } else if (state == SOLD) {  
  30.             //����˿����ǹ�,����Ҫ�Ե���,����״̬ת�����,�ָ���"û��25��Ǯ"��״̬  
  31.                 System.out.println("Please wait, we're already giving you a gumball");  
  32.         }  
  33.     }  
  34.     //����,����˿������˻�25��Ǯ...  
  35.     public void ejectQuarter() {  
  36.         if (state == HAS_QUARTER) {  
  37.             //�����25��Ǯ,����Ǯ,�ص�"û��25��Ǯ"��״̬  
  38.             System.out.println("Quarter returned");  
  39.             state = NO_QUARTER;  
  40.         } else if (state == NO_QUARTER) {  
  41.             //���û��25��Ǯ,��Ȼ�����˻�  
  42.             System.out.println("You haven't inserted a quarter");  
  43.         } else if (state == SOLD) {  
  44.             //����˿��Ѿ�ת���ֱ�,�Ͳ�����Ǯ��,���Ѿ��õ��ǹ���  
  45.             System.out.println("Sorry, you already turned the crank");  
  46.         } else if (state == SOLD_OUT) {  
  47.             //����ǹ�����,�Ͳ����ܽ���25��Ǯ,��ȻҲ��������Ǯ  
  48.                 System.out.println("You can't eject, you haven't inserted a quarter yet");  
  49.         }  
  50.     }  
  51.     //�˿�����ת���ֱ�...  
  52.     public void turnCrank() {  
  53.         if (state == SOLD) {  
  54.             //����ƭ��������2���ǹ�  
  55.             System.out.println("Turning twice doesn't get you another gumball!");  
  56.         } else if (state == NO_QUARTER) {  
  57.             //������Ҫ��Ͷ��25��Ǯ  
  58.             System.out.println("You turned but there's no quarter");  
  59.         } else if (state == SOLD_OUT) {  
  60.             //û���ǹ���  
  61.             System.out.println("You turned, but there are no gumballs");  
  62.         } else if (state == HAS_QUARTER) {  
  63.             //�ɹ�!���õ��ǹ���.�ı�״̬��"�۳��ǹ�",Ȼ����û�����dispense()����  
  64.             System.out.println("You turned...");  
  65.             state = SOLD;  
  66.             dispense();  
  67.         }  
  68.     }  
  69.     //�����ǹ�  
  70.     public void dispense() {  
  71.         if (state == SOLD) {  
  72.             //��������"�۳��ǹ�"״̬  
  73.             System.out.println("A gumball comes rolling out the slot");  
  74.             count = count - 1;  
  75.             //���������ﴦ��"�ǹ�����"�����  
  76.             if (count == 0) {//���һ��,���������õ�"�ǹ�����"״̬  
  77.                 System.out.println("Oops, out of gumballs!");  
  78.                 state = SOLD_OUT;  
  79.             } else {    //����ص�"û��25��Ǯ"��״̬  
  80.                 state = NO_QUARTER;  
  81.             }  
  82.         } else if (state == NO_QUARTER) {   //���¶���Ӧ�÷���,������˿���ô����,�õ���Ӧ���Ǵ�����Ϣ�������ǹ�  
  83.             System.out.println("You need to pay first");  
  84.         } else if (state == SOLD_OUT) {  
  85.             System.out.println("No gumball dispensed");  
  86.         } else if (state == HAS_QUARTER) {  
  87.             System.out.println("No gumball dispensed");  
  88.         }  
  89.     }  
  90.     public void refill(int numGumBalls) {  
  91.         this.count = numGumBalls;  
  92.         state = NO_QUARTER;  
  93.     }  
  94. }  

public class GumballMachine {
	//�������4��״̬,ÿ��״̬����һ����ͬ����������,���Ƿ���״̬ͼ
	final static int SOLD_OUT = 0;		//�ǹ�����
	final static int NO_QUARTER = 1;	//û��25��Ǯ
	final static int HAS_QUARTER = 2;	//��25��Ǯ
	final static int SOLD = 3;		//�۳��ǹ�
	//���ʵ���������ٵ�ǰ״̬,һ��ʼ����Ϊ"�ǹ�����",��Ϊ�ǹ�����װʱ��û��װ�ǹ���
	int state = SOLD_OUT;
	int count = 0;	//�����������׷�ٻ����ڵ��ǹ���Ŀ
	//��������ʼ�ǹ��������������,�����治Ϊ0�Ļ�,�����ͽ���"û��25��Ǯ"��״̬,������Ͷ��25��Ǯ
	public GumballMachine(int count) {
		this.count = count;
		if (count > 0) {
			state = NO_QUARTER;
		}
	}
	//����25��ǮͶ�����,�ͻ�ִ������
	public void insertQuarter() {
		if (state == HAS_QUARTER) {
			//�����Ͷ��25��Ǯ,֪ͨ�˿�
			System.out.println("You can't insert another quarter");
		} else if (state == NO_QUARTER) {
			//�������"û��25��Ǯ"��״̬��,���Ǿͽ���25��Ǯ,����״̬ת����"��25��Ǯ"
			state = HAS_QUARTER;
			System.out.println("You inserted a quarter");
		} else if (state == SOLD_OUT) {
			//����ǹ�����,�;ܾ���Ǯ
			System.out.println("You can't insert a quarter, the machine is sold out");
		} else if (state == SOLD) {
			//����˿����ǹ�,����Ҫ�Ե���,����״̬ת�����,�ָ���"û��25��Ǯ"��״̬
        		System.out.println("Please wait, we're already giving you a gumball");
		}
	}
	//����,����˿������˻�25��Ǯ...
	public void ejectQuarter() {
		if (state == HAS_QUARTER) {
			//�����25��Ǯ,����Ǯ,�ص�"û��25��Ǯ"��״̬
			System.out.println("Quarter returned");
			state = NO_QUARTER;
		} else if (state == NO_QUARTER) {
			//���û��25��Ǯ,��Ȼ�����˻�
			System.out.println("You haven't inserted a quarter");
		} else if (state == SOLD) {
			//����˿��Ѿ�ת���ֱ�,�Ͳ�����Ǯ��,���Ѿ��õ��ǹ���
			System.out.println("Sorry, you already turned the crank");
		} else if (state == SOLD_OUT) {
			//����ǹ�����,�Ͳ����ܽ���25��Ǯ,��ȻҲ��������Ǯ
        		System.out.println("You can't eject, you haven't inserted a quarter yet");
		}
	}
	//�˿�����ת���ֱ�...
	public void turnCrank() {
		if (state == SOLD) {
			//����ƭ��������2���ǹ�
			System.out.println("Turning twice doesn't get you another gumball!");
		} else if (state == NO_QUARTER) {
			//������Ҫ��Ͷ��25��Ǯ
			System.out.println("You turned but there's no quarter");
		} else if (state == SOLD_OUT) {
			//û���ǹ���
			System.out.println("You turned, but there are no gumballs");
		} else if (state == HAS_QUARTER) {
			//�ɹ�!���õ��ǹ���.�ı�״̬��"�۳��ǹ�",Ȼ����û�����dispense()����
			System.out.println("You turned...");
			state = SOLD;
			dispense();
		}
	}
	//�����ǹ�
	public void dispense() {
		if (state == SOLD) {
			//��������"�۳��ǹ�"״̬
			System.out.println("A gumball comes rolling out the slot");
			count = count - 1;
			//���������ﴦ��"�ǹ�����"�����
			if (count == 0) {//���һ��,���������õ�"�ǹ�����"״̬
				System.out.println("Oops, out of gumballs!");
				state = SOLD_OUT;
			} else {	//����ص�"û��25��Ǯ"��״̬
				state = NO_QUARTER;
			}
		} else if (state == NO_QUARTER) {	//���¶���Ӧ�÷���,������˿���ô����,�õ���Ӧ���Ǵ�����Ϣ�������ǹ�
			System.out.println("You need to pay first");
		} else if (state == SOLD_OUT) {
			System.out.println("No gumball dispensed");
		} else if (state == HAS_QUARTER) {
			System.out.println("No gumball dispensed");
		}
	}
	public void refill(int numGumBalls) {
		this.count = numGumBalls;
		state = NO_QUARTER;
	}
}

�о�������ʹ��˼�����ܵķ���ѧ��������,�㲻������?�Լ�д�����Գ�������
��ʱҪ���:���ֱ���ת��ʱ,��10%�ļ��ʵ��������������ǹ�(������һ��),Ҳ����˵10������1�˿��Եõ���ѵ��ǹ�.����Ҫ����޸�����Ĵ���,���ȱ���Ҫ����һ���µ�״̬,��Ϊ"Ӯ��",Ȼ���������ÿ�������м���һ���µ�����������"Ӯ��"״̬,ת���ֱ�turnCrank()����������һ����......��ֱ����һ�����ҵ�״̬.�����Ӻܲ���,�����µ��������,�����е�bug�ļ���������ܻ�����Ǵ����鷳,����������Ҫ�ع���ݴ�����,����Ӧ�����žֲ���ÿ��״̬����Ϊ,����һ��,����������ĳ��״̬���˸ı�,�Ͳ���������Ĵ��������,����"��װ�仯"ԭ��:
Java����

   1. //�����ȴ���һ��State�ӿ�,���е�״̬������ʵ������ӿ�  
   2. public interface State {  
   3.     public void insertQuarter();  
   4.     public void ejectQuarter();  
   5.     public void turnCrank();  
   6.     public void dispense();  
   7. }  
   8. //ʵ�����ǵ�״̬��  
   9. public class NoQuarterState implements State {  //��ʵ��State�ӿ�  
  10.     GumballMachine gumballMachine;  
  11.     //ͨ���������õ��ǹ���������  
  12.     public NoQuarterState(GumballMachine gumballMachine) {  
  13.     this.gumballMachine = gumballMachine;  
  14.     }  
  15.     //�����Ǽ�������  
  16.     public void insertQuarter() {  
  17.         System.out.println("You inserted a quarter");  
  18.         //�����ϻῴ��������ι�����  
  19.         gumballMachine.setState(gumballMachine.getHasQuarterState());  
  20.     }  
  21.     public void ejectQuarter() {  
  22.         System.out.println("You haven't inserted a quarter");  
  23.     }  
  24.     public void turnCrank() {  
  25.         System.out.println("You turned, but there's no quarter");  
  26.      }  
  27.     public void dispense() {  
  28.         System.out.println("You need to pay first");  
  29.     }   
  30.     public String toString() {  
  31.         return "waiting for quarter";  
  32.     }  
  33. }  
  34. //�������ǹ�����  
  35. public class GumballMachine {  
  36.     //���е�״̬��������  
  37.     State soldOutState;  
  38.     State noQuarterState;  
  39.     State hasQuarterState;  
  40.     State soldState;  
  41.     State winnerState;//ʮ�γ���һ�ε���Ϸ,�µ�״̬  
  42.     //�Լ�ʵ������state  
  43.     State state = soldOutState;  
  44.     int count = 0;//��¼�ǹ�����  
  45.     public GumballMachine(int numberGumballs) {       
  46.         soldOutState = new SoldOutState(this);  //ÿһ��״̬Ҳ������һ��״̬ʵ��  
  47.         noQuarterState = new NoQuarterState(this);  
  48.         hasQuarterState = new HasQuarterState(this);  
  49.         soldState = new SoldState(this);  
  50.         this.count = numberGumballs;  
  51.         if (numberGumballs > 0) {    //�������0���ǹ�,״̬��ΪnoQuarterState  
  52.             state = noQuarterState;  
  53.         }   
  54.     }  
  55.     //ί�и���ǰ״̬  
  56.     public void insertQuarter() {  
  57.         state.insertQuarter();  
  58.     }  
  59.     public void ejectQuarter() {  
  60.         state.ejectQuarter();  
  61.     }  
  62.     //dispense()��һ���ڲ���������,�û�������ֱ��Ҫ����������ǹ�  
  63.     public void turnCrank() {  
  64.         state.turnCrank();  
  65.         state.dispense();  
  66.     }  
  67.     //���������Ķ��󽫻���״̬ת������ͬ��״̬  
  68.     void setState(State state) {  
  69.         this.state = state;  
  70.     }  
  71.     //���������ͷų��ǹ�,����countʵ������ֵ��1  
  72.     void releaseBall() {  
  73.         System.out.println("A gumball comes rolling out the slot...");  
  74.         if (count != 0) {  
  75.             count = count - 1;  
  76.         }  
  77.     }  
  78.     int getCount() {  
  79.         return count;  
  80.     }  
  81.     void refill(int count) {  
  82.         this.count = count;  
  83.         state = noQuarterState;  
  84.     }  
  85.     public State getState() {return state;}  
  86.     public State getSoldOutState() {return soldOutState;}  
  87.     public State getNoQuarterState() {return noQuarterState;}  
  88.     public State getHasQuarterState() {return hasQuarterState;}  
  89.     public State getSoldState() {return soldState;}  
  90.     public State getWinnerState() {return winnerState;}  
  91. }  
  92. //����������ʵ��HasQuarterState(��25��Ǯ)��SoldState(�۳��ǹ�)����,�ǹ�����ķ����Լ�дд,����Ͳ��ṩ��  
  93. public class HasQuarterState implements State {  
  94.     GumballMachine gumballMachine;  
  95.     //����һ�������������,����10%�Ļ���  
  96.     Random randomWinner = new Random(System.currentTimeMillis());  
  97.     public HasQuarterState(GumballMachine gumballMachine) {  
  98.         this.gumballMachine = gumballMachine;  
  99.     }  
 100.     public void insertQuarter() {   //����һ���Ե�ǰ״̬��ǡ���Ķ���  
 101.         System.out.println("You can't insert another quarter");  
 102.     }  
 103.     public void ejectQuarter() {    //��Ǯ��ת��״̬��NoQuarterState  
 104.         System.out.println("Quarter returned");  
 105.         gumballMachine.setState(gumballMachine.getNoQuarterState());  
 106.     }  
 107.     public void turnCrank() {  
 108.         System.out.println("You turned...");  
 109.         int winner = randomWinner.nextInt(10);  
 110.         //��������˿��Ƿ�Ӯ��  
 111.         if ((winner == 0) && (gumballMachine.getCount() > 1)) {  
 112.             gumballMachine.setState(gumballMachine.getWinnerState());  
 113.         } else {  
 114.             gumballMachine.setState(gumballMachine.getSoldState());  
 115.         }  
 116.     }  
 117.     public void dispense() {    //����һ���Ե�ǰ״̬��ǡ���Ķ���  
 118.         System.out.println("No gumball dispensed");  
 119.     }  
 120. }  
 121. public class SoldState implements State {  
 122.     GumballMachine gumballMachine;  
 123.     public SoldState(GumballMachine gumballMachine) {  
 124.         this.gumballMachine = gumballMachine;  
 125.     }      
 126.     //����3�������Դ�״̬��˵���ǲ�ǡ����  
 127.     public void insertQuarter() {  
 128.         System.out.println("Please wait, we're already giving you a gumball");  
 129.     }  
 130.     public void ejectQuarter() {  
 131.         System.out.println("Sorry, you already turned the crank");  
 132.     }  
 133.     public void turnCrank() {  
 134.         System.out.println("Turning twice doesn't get you another gumball!");  
 135.     }  
 136.     //�����û��������ǹ�  
 137.     public void dispense() {  
 138.         gumballMachine.releaseBall();  
 139.         if (gumballMachine.getCount() > 0) {  
 140.             gumballMachine.setState(gumballMachine.getNoQuarterState());  
 141.         } else {  
 142.             System.out.println("Oops, out of gumballs!");  
 143.             gumballMachine.setState(gumballMachine.getSoldOutState());  
 144.         }  
 145.     }  
 146. }  
 147. //��������ʵ��WinnerState��  
 148. public class WinnerState implements State {  
 149.     GumballMachine gumballMachine;  
 150.     //���涼��SoldState����һ��  
 151.     public WinnerState(GumballMachine gumballMachine) {  
 152.         this.gumballMachine = gumballMachine;  
 153.     }  
 154.     public void insertQuarter() {  
 155.         System.out.println("Please wait, we're already giving you a Gumball");  
 156.     }  
 157.     public void ejectQuarter() {  
 158.         System.out.println("Please wait, we're already giving you a Gumball");  
 159.     }  
 160.     public void turnCrank() {  
 161.         System.out.println("Turning again doesn't get you another gumball!");  
 162.     }  
 163.     //���������﷢�ų�2���ǹ�,Ȼ�����NoQuarterState��SoldState  
 164.     public void dispense() {  
 165.         System.out.println("YOU'RE A WINNER! You get two gumballs for your quarter");  
 166.         gumballMachine.releaseBall();  
 167.         if (gumballMachine.getCount() == 0) {  
 168.             gumballMachine.setState(gumballMachine.getSoldOutState());  
 169.         } else {  
 170.             gumballMachine.releaseBall();  
 171.             if (gumballMachine.getCount() > 0) {  
 172.                 gumballMachine.setState(gumballMachine.getNoQuarterState());  
 173.             } else {  
 174.                 System.out.println("Oops, out of gumballs!");  
 175.                 gumballMachine.setState(gumballMachine.getSoldOutState());  
 176.             }  
 177.         }  
 178.     }  
 179. }  

//�����ȴ���һ��State�ӿ�,���е�״̬������ʵ������ӿ�
public interface State {
	public void insertQuarter();
	public void ejectQuarter();
	public void turnCrank();
	public void dispense();
}
//ʵ�����ǵ�״̬��
public class NoQuarterState implements State {	//��ʵ��State�ӿ�
	GumballMachine gumballMachine;
	//ͨ���������õ��ǹ���������
	public NoQuarterState(GumballMachine gumballMachine) {
	this.gumballMachine = gumballMachine;
	}
	//�����Ǽ�������
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		//�����ϻῴ��������ι�����
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}
	public void ejectQuarter() {
		System.out.println("You haven't inserted a quarter");
	}
	public void turnCrank() {
		System.out.println("You turned, but there's no quarter");
	 }
	public void dispense() {
		System.out.println("You need to pay first");
	} 
	public String toString() {
		return "waiting for quarter";
	}
}
//�������ǹ�����
public class GumballMachine {
	//���е�״̬��������
	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	State winnerState;//ʮ�γ���һ�ε���Ϸ,�µ�״̬
	//�Լ�ʵ������state
	State state = soldOutState;
	int count = 0;//��¼�ǹ�����
	public GumballMachine(int numberGumballs) {		
		soldOutState = new SoldOutState(this);	//ÿһ��״̬Ҳ������һ��״̬ʵ��
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		this.count = numberGumballs;
 		if (numberGumballs > 0) {	//�������0���ǹ�,״̬��ΪnoQuarterState
			state = noQuarterState;
		} 
	}
	//ί�и���ǰ״̬
	public void insertQuarter() {
		state.insertQuarter();
	}
	public void ejectQuarter() {
		state.ejectQuarter();
	}
	//dispense()��һ���ڲ���������,�û�������ֱ��Ҫ����������ǹ�
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}
	//���������Ķ��󽫻���״̬ת������ͬ��״̬
	void setState(State state) {
		this.state = state;
	}
	//���������ͷų��ǹ�,����countʵ������ֵ��1
	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0) {
			count = count - 1;
		}
	}
	int getCount() {
		return count;
	}
	void refill(int count) {
		this.count = count;
		state = noQuarterState;
	}
	public State getState() {return state;}
	public State getSoldOutState() {return soldOutState;}
	public State getNoQuarterState() {return noQuarterState;}
	public State getHasQuarterState() {return hasQuarterState;}
	public State getSoldState() {return soldState;}
	public State getWinnerState() {return winnerState;}
}
//����������ʵ��HasQuarterState(��25��Ǯ)��SoldState(�۳��ǹ�)����,�ǹ�����ķ����Լ�дд,����Ͳ��ṩ��
public class HasQuarterState implements State {
	GumballMachine gumballMachine;
	//����һ�������������,����10%�Ļ���
	Random randomWinner = new Random(System.currentTimeMillis());
	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	public void insertQuarter() {	//����һ���Ե�ǰ״̬��ǡ���Ķ���
		System.out.println("You can't insert another quarter");
	}
	public void ejectQuarter() {	//��Ǯ��ת��״̬��NoQuarterState
		System.out.println("Quarter returned");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}
	public void turnCrank() {
		System.out.println("You turned...");
		int winner = randomWinner.nextInt(10);
		//��������˿��Ƿ�Ӯ��
		if ((winner == 0) && (gumballMachine.getCount() > 1)) {
			gumballMachine.setState(gumballMachine.getWinnerState());
		} else {
			gumballMachine.setState(gumballMachine.getSoldState());
		}
	}
	public void dispense() {	//����һ���Ե�ǰ״̬��ǡ���Ķ���
		System.out.println("No gumball dispensed");
	}
}
public class SoldState implements State {
	GumballMachine gumballMachine;
	public SoldState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}    
	//����3�������Դ�״̬��˵���ǲ�ǡ����
	public void insertQuarter() {
		System.out.println("Please wait, we're already giving you a gumball");
	}
	public void ejectQuarter() {
		System.out.println("Sorry, you already turned the crank");
	}
	public void turnCrank() {
		System.out.println("Turning twice doesn't get you another gumball!");
	}
	//�����û��������ǹ�
	public void dispense() {
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() > 0) {
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		} else {
			System.out.println("Oops, out of gumballs!");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}
}
//��������ʵ��WinnerState��
public class WinnerState implements State {
	GumballMachine gumballMachine;
	//���涼��SoldState����һ��
	public WinnerState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	public void insertQuarter() {
		System.out.println("Please wait, we're already giving you a Gumball");
	}
	public void ejectQuarter() {
		System.out.println("Please wait, we're already giving you a Gumball");
	}
	public void turnCrank() {
		System.out.println("Turning again doesn't get you another gumball!");
	}
	//���������﷢�ų�2���ǹ�,Ȼ�����NoQuarterState��SoldState
	public void dispense() {
		System.out.println("YOU'RE A WINNER! You get two gumballs for your quarter");
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() == 0) {
			gumballMachine.setState(gumballMachine.getSoldOutState());
		} else {
			gumballMachine.releaseBall();
			if (gumballMachine.getCount() > 0) {
				gumballMachine.setState(gumballMachine.getNoQuarterState());
			} else {
            	System.out.println("Oops, out of gumballs!");
				gumballMachine.setState(gumballMachine.getSoldOutState());
			}
		}
	}
}

����,���Ǹ�ʵ����״̬ģʽ.״̬ģʽ���������ڲ�״̬�ı�ʱ�ı�������Ϊ,�������������޸���������.
���������ײ���ģʽ��״̬ģʽ��ʲô��������?
��״̬ģʽ����,���ǽ�һȺ��Ϊ��װ��״̬������,context����Ϊ��ʱ��ί�е���Щ״̬�����е�һ��.����ʱ������,��ǰ״̬��״̬���󼯺������߸ı�,�Է�Ӧ��context�ڲ���״̬,���,context����ΪҲ����Ÿı�,����context�Ŀͻ���Ӧ״̬�����˽ⲻ��,����������֪��.
���Բ���ģʽ����,�ͻ�ͨ������ָ��context��Ҫ��ϵĲ��Զ�������һ��.���ڹ�Ȼ����ģʽ�����Ǿ��е���,�ܹ�������ʱ�ı����,������ĳ��context��˵,ͨ����ֻ��һ�����ʵ��Ĳ��Զ���. 