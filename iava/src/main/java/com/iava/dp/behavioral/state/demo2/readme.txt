策略模式和状态模式是双胞胎,策略模式是围绕可以互换的算法来创建成功业务的,然而状态模式是通过改变对象内部的状态来帮助对象控制自己的行为.
看到下面附件里的那个图了没,我自己画着玩的,看不明白没关系(我明白就行了,呵呵),你就看成是糖果机的状态图好了:
我们如何从状态图得到真正的代码呢?首先我们找出所有的状态:
没有25分钱//有25分钱//售出糖果//糖果售完--------------这就是状态,共有4个
接下来我们来实现糖果机:
Java代码

   1. public class GumballMachine {  
   2.     //这就是那4个状态,每个状态都用一个不同的整数代表,他们符合状态图  
   3.     final static int SOLD_OUT = 0;      //糖果售完  
   4.     final static int NO_QUARTER = 1;    //没有25分钱  
   5.     final static int HAS_QUARTER = 2;   //有25分钱  
   6.     final static int SOLD = 3;      //售出糖果  
   7.     //这个实例变量跟踪当前状态,一开始被设为"糖果售完",因为糖果机安装时是没有装糖果的  
   8.     int state = SOLD_OUT;  
   9.     int count = 0;  //这个变量用来追踪机器内的糖果数目  
  10.     //构造器初始糖果库存量当做参数,如果库存不为0的话,机器就进入"没有25分钱"的状态,等着你投入25分钱  
  11.     public GumballMachine(int count) {  
  12.         this.count = count;  
  13.         if (count > 0) {  
  14.             state = NO_QUARTER;  
  15.         }  
  16.     }  
  17.     //当有25分钱投入进来,就会执行这里  
  18.     public void insertQuarter() {  
  19.         if (state == HAS_QUARTER) {  
  20.             //如果已投入25分钱,通知顾客  
  21.             System.out.println("You can't insert another quarter");  
  22.         } else if (state == NO_QUARTER) {  
  23.             //如果是在"没有25分钱"的状态下,我们就接受25分钱,并将状态转换到"有25分钱"  
  24.             state = HAS_QUARTER;  
  25.             System.out.println("You inserted a quarter");  
  26.         } else if (state == SOLD_OUT) {  
  27.             //如果糖果售完,就拒绝收钱  
  28.             System.out.println("You can't insert a quarter, the machine is sold out");  
  29.         } else if (state == SOLD) {  
  30.             //如果顾客买到糖果,就需要稍等下,好让状态转换完毕,恢复到"没有25分钱"的状态  
  31.                 System.out.println("Please wait, we're already giving you a gumball");  
  32.         }  
  33.     }  
  34.     //现在,如果顾客试着退回25分钱...  
  35.     public void ejectQuarter() {  
  36.         if (state == HAS_QUARTER) {  
  37.             //如果有25分钱,就退钱,回到"没有25分钱"的状态  
  38.             System.out.println("Quarter returned");  
  39.             state = NO_QUARTER;  
  40.         } else if (state == NO_QUARTER) {  
  41.             //如果没有25分钱,当然不能退回  
  42.             System.out.println("You haven't inserted a quarter");  
  43.         } else if (state == SOLD) {  
  44.             //如果顾客已经转动手柄,就不能退钱了,他已经拿到糖果了  
  45.             System.out.println("Sorry, you already turned the crank");  
  46.         } else if (state == SOLD_OUT) {  
  47.             //如果糖果售完,就不可能接受25分钱,当然也不可能退钱  
  48.                 System.out.println("You can't eject, you haven't inserted a quarter yet");  
  49.         }  
  50.     }  
  51.     //顾客试着转动手柄...  
  52.     public void turnCrank() {  
  53.         if (state == SOLD) {  
  54.             //别想骗过机器拿2次糖果  
  55.             System.out.println("Turning twice doesn't get you another gumball!");  
  56.         } else if (state == NO_QUARTER) {  
  57.             //我们需要先投入25分钱  
  58.             System.out.println("You turned but there's no quarter");  
  59.         } else if (state == SOLD_OUT) {  
  60.             //没有糖果了  
  61.             System.out.println("You turned, but there are no gumballs");  
  62.         } else if (state == HAS_QUARTER) {  
  63.             //成功!他拿到糖果了.改变状态到"售出糖果",然后调用机器的dispense()方法  
  64.             System.out.println("You turned...");  
  65.             state = SOLD;  
  66.             dispense();  
  67.         }  
  68.     }  
  69.     //发放糖果  
  70.     public void dispense() {  
  71.         if (state == SOLD) {  
  72.             //我们正在"售出糖果"状态  
  73.             System.out.println("A gumball comes rolling out the slot");  
  74.             count = count - 1;  
  75.             //我们在这里处理"糖果售完"的情况  
  76.             if (count == 0) {//最后一颗,将机器设置到"糖果售完"状态  
  77.                 System.out.println("Oops, out of gumballs!");  
  78.                 state = SOLD_OUT;  
  79.             } else {    //否则回到"没有25分钱"的状态  
  80.                 state = NO_QUARTER;  
  81.             }  
  82.         } else if (state == NO_QUARTER) {   //以下都不应该发生,但如果顾客这么做了,得到的应该是错误消息而不是糖果  
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
	//这就是那4个状态,每个状态都用一个不同的整数代表,他们符合状态图
	final static int SOLD_OUT = 0;		//糖果售完
	final static int NO_QUARTER = 1;	//没有25分钱
	final static int HAS_QUARTER = 2;	//有25分钱
	final static int SOLD = 3;		//售出糖果
	//这个实例变量跟踪当前状态,一开始被设为"糖果售完",因为糖果机安装时是没有装糖果的
	int state = SOLD_OUT;
	int count = 0;	//这个变量用来追踪机器内的糖果数目
	//构造器初始糖果库存量当做参数,如果库存不为0的话,机器就进入"没有25分钱"的状态,等着你投入25分钱
	public GumballMachine(int count) {
		this.count = count;
		if (count > 0) {
			state = NO_QUARTER;
		}
	}
	//当有25分钱投入进来,就会执行这里
	public void insertQuarter() {
		if (state == HAS_QUARTER) {
			//如果已投入25分钱,通知顾客
			System.out.println("You can't insert another quarter");
		} else if (state == NO_QUARTER) {
			//如果是在"没有25分钱"的状态下,我们就接受25分钱,并将状态转换到"有25分钱"
			state = HAS_QUARTER;
			System.out.println("You inserted a quarter");
		} else if (state == SOLD_OUT) {
			//如果糖果售完,就拒绝收钱
			System.out.println("You can't insert a quarter, the machine is sold out");
		} else if (state == SOLD) {
			//如果顾客买到糖果,就需要稍等下,好让状态转换完毕,恢复到"没有25分钱"的状态
        		System.out.println("Please wait, we're already giving you a gumball");
		}
	}
	//现在,如果顾客试着退回25分钱...
	public void ejectQuarter() {
		if (state == HAS_QUARTER) {
			//如果有25分钱,就退钱,回到"没有25分钱"的状态
			System.out.println("Quarter returned");
			state = NO_QUARTER;
		} else if (state == NO_QUARTER) {
			//如果没有25分钱,当然不能退回
			System.out.println("You haven't inserted a quarter");
		} else if (state == SOLD) {
			//如果顾客已经转动手柄,就不能退钱了,他已经拿到糖果了
			System.out.println("Sorry, you already turned the crank");
		} else if (state == SOLD_OUT) {
			//如果糖果售完,就不可能接受25分钱,当然也不可能退钱
        		System.out.println("You can't eject, you haven't inserted a quarter yet");
		}
	}
	//顾客试着转动手柄...
	public void turnCrank() {
		if (state == SOLD) {
			//别想骗过机器拿2次糖果
			System.out.println("Turning twice doesn't get you another gumball!");
		} else if (state == NO_QUARTER) {
			//我们需要先投入25分钱
			System.out.println("You turned but there's no quarter");
		} else if (state == SOLD_OUT) {
			//没有糖果了
			System.out.println("You turned, but there are no gumballs");
		} else if (state == HAS_QUARTER) {
			//成功!他拿到糖果了.改变状态到"售出糖果",然后调用机器的dispense()方法
			System.out.println("You turned...");
			state = SOLD;
			dispense();
		}
	}
	//发放糖果
	public void dispense() {
		if (state == SOLD) {
			//我们正在"售出糖果"状态
			System.out.println("A gumball comes rolling out the slot");
			count = count - 1;
			//我们在这里处理"糖果售完"的情况
			if (count == 0) {//最后一颗,将机器设置到"糖果售完"状态
				System.out.println("Oops, out of gumballs!");
				state = SOLD_OUT;
			} else {	//否则回到"没有25分钱"的状态
				state = NO_QUARTER;
			}
		} else if (state == NO_QUARTER) {	//以下都不应该发生,但如果顾客这么做了,得到的应该是错误消息而不是糖果
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

感觉它像是使用思虑周密的方法学构造的设计,你不觉得吗?自己写个测试程序试试
这时要搞点活动:当手柄被转动时,有10%的几率掉下来的是两颗糖果(多送你一个),也就是说10人中有1人可以得到免费的糖果.考虑要如何修改上面的代码,首先必须要加上一个新的状态,称为"赢家",然后你必须在每个方法中加入一个新的条件来处理"赢家"状态,转动手柄turnCrank()方法尤其变得一团糟......简直就是一个混乱的状态.这样子很不妙,随着新的需求出现,程序中的bug的几率增大可能会给我们带来麻烦,看来我们需要重构这份代码了,我们应该试着局部化每个状态的行为,这样一来,如果我们针对某个状态做了改变,就不会把其他的代码搞乱了,遵守"封装变化"原则:
Java代码

   1. //我们先创建一个State接口,所有的状态都必须实现这个接口  
   2. public interface State {  
   3.     public void insertQuarter();  
   4.     public void ejectQuarter();  
   5.     public void turnCrank();  
   6.     public void dispense();  
   7. }  
   8. //实现我们的状态类  
   9. public class NoQuarterState implements State {  //先实现State接口  
  10.     GumballMachine gumballMachine;  
  11.     //通过构造器得到糖果机的引用  
  12.     public NoQuarterState(GumballMachine gumballMachine) {  
  13.     this.gumballMachine = gumballMachine;  
  14.     }  
  15.     //还是那几个方法  
  16.     public void insertQuarter() {  
  17.         System.out.println("You inserted a quarter");  
  18.         //你马上会看到这里如何工作的  
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
  34. //完整的糖果机类  
  35. public class GumballMachine {  
  36.     //所有的状态都在这里  
  37.     State soldOutState;  
  38.     State noQuarterState;  
  39.     State hasQuarterState;  
  40.     State soldState;  
  41.     State winnerState;//十次抽中一次的游戏,新的状态  
  42.     //以及实例变量state  
  43.     State state = soldOutState;  
  44.     int count = 0;//记录糖果数量  
  45.     public GumballMachine(int numberGumballs) {       
  46.         soldOutState = new SoldOutState(this);  //每一种状态也都创建一个状态实例  
  47.         noQuarterState = new NoQuarterState(this);  
  48.         hasQuarterState = new HasQuarterState(this);  
  49.         soldState = new SoldState(this);  
  50.         this.count = numberGumballs;  
  51.         if (numberGumballs > 0) {    //如果超过0颗糖果,状态设为noQuarterState  
  52.             state = noQuarterState;  
  53.         }   
  54.     }  
  55.     //委托给当前状态  
  56.     public void insertQuarter() {  
  57.         state.insertQuarter();  
  58.     }  
  59.     public void ejectQuarter() {  
  60.         state.ejectQuarter();  
  61.     }  
  62.     //dispense()是一个内部动作方法,用户不可以直接要求机器发放糖果  
  63.     public void turnCrank() {  
  64.         state.turnCrank();  
  65.         state.dispense();  
  66.     }  
  67.     //允许其他的对象将机器状态转换到不同的状态  
  68.     void setState(State state) {  
  69.         this.state = state;  
  70.     }  
  71.     //辅助方法释放出糖果,并将count实例变量值减1  
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
  92. //现在我们来实现HasQuarterState(有25分钱)和SoldState(售出糖果)方法,糖果售完的方法自己写写,这里就不提供了  
  93. public class HasQuarterState implements State {  
  94.     GumballMachine gumballMachine;  
  95.     //增加一个随机数产生器,产生10%的机会  
  96.     Random randomWinner = new Random(System.currentTimeMillis());  
  97.     public HasQuarterState(GumballMachine gumballMachine) {  
  98.         this.gumballMachine = gumballMachine;  
  99.     }  
 100.     public void insertQuarter() {   //这是一个对当前状态不恰当的动作  
 101.         System.out.println("You can't insert another quarter");  
 102.     }  
 103.     public void ejectQuarter() {    //退钱并转换状态到NoQuarterState  
 104.         System.out.println("Quarter returned");  
 105.         gumballMachine.setState(gumballMachine.getNoQuarterState());  
 106.     }  
 107.     public void turnCrank() {  
 108.         System.out.println("You turned...");  
 109.         int winner = randomWinner.nextInt(10);  
 110.         //决定这个顾客是否赢了  
 111.         if ((winner == 0) && (gumballMachine.getCount() > 1)) {  
 112.             gumballMachine.setState(gumballMachine.getWinnerState());  
 113.         } else {  
 114.             gumballMachine.setState(gumballMachine.getSoldState());  
 115.         }  
 116.     }  
 117.     public void dispense() {    //这是一个对当前状态不恰当的动作  
 118.         System.out.println("No gumball dispensed");  
 119.     }  
 120. }  
 121. public class SoldState implements State {  
 122.     GumballMachine gumballMachine;  
 123.     public SoldState(GumballMachine gumballMachine) {  
 124.         this.gumballMachine = gumballMachine;  
 125.     }      
 126.     //以下3个方法对此状态来说都是不恰当的  
 127.     public void insertQuarter() {  
 128.         System.out.println("Please wait, we're already giving you a gumball");  
 129.     }  
 130.     public void ejectQuarter() {  
 131.         System.out.println("Sorry, you already turned the crank");  
 132.     }  
 133.     public void turnCrank() {  
 134.         System.out.println("Turning twice doesn't get you another gumball!");  
 135.     }  
 136.     //首先让机器发放糖果  
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
 147. //我们再来实现WinnerState类  
 148. public class WinnerState implements State {  
 149.     GumballMachine gumballMachine;  
 150.     //下面都跟SoldState方法一样  
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
 163.     //我们在这里发放出2颗糖果,然后进入NoQuarterState或SoldState  
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

//我们先创建一个State接口,所有的状态都必须实现这个接口
public interface State {
	public void insertQuarter();
	public void ejectQuarter();
	public void turnCrank();
	public void dispense();
}
//实现我们的状态类
public class NoQuarterState implements State {	//先实现State接口
	GumballMachine gumballMachine;
	//通过构造器得到糖果机的引用
	public NoQuarterState(GumballMachine gumballMachine) {
	this.gumballMachine = gumballMachine;
	}
	//还是那几个方法
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		//你马上会看到这里如何工作的
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
//完整的糖果机类
public class GumballMachine {
	//所有的状态都在这里
	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	State winnerState;//十次抽中一次的游戏,新的状态
	//以及实例变量state
	State state = soldOutState;
	int count = 0;//记录糖果数量
	public GumballMachine(int numberGumballs) {		
		soldOutState = new SoldOutState(this);	//每一种状态也都创建一个状态实例
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		this.count = numberGumballs;
 		if (numberGumballs > 0) {	//如果超过0颗糖果,状态设为noQuarterState
			state = noQuarterState;
		} 
	}
	//委托给当前状态
	public void insertQuarter() {
		state.insertQuarter();
	}
	public void ejectQuarter() {
		state.ejectQuarter();
	}
	//dispense()是一个内部动作方法,用户不可以直接要求机器发放糖果
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}
	//允许其他的对象将机器状态转换到不同的状态
	void setState(State state) {
		this.state = state;
	}
	//辅助方法释放出糖果,并将count实例变量值减1
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
//现在我们来实现HasQuarterState(有25分钱)和SoldState(售出糖果)方法,糖果售完的方法自己写写,这里就不提供了
public class HasQuarterState implements State {
	GumballMachine gumballMachine;
	//增加一个随机数产生器,产生10%的机会
	Random randomWinner = new Random(System.currentTimeMillis());
	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	public void insertQuarter() {	//这是一个对当前状态不恰当的动作
		System.out.println("You can't insert another quarter");
	}
	public void ejectQuarter() {	//退钱并转换状态到NoQuarterState
		System.out.println("Quarter returned");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}
	public void turnCrank() {
		System.out.println("You turned...");
		int winner = randomWinner.nextInt(10);
		//决定这个顾客是否赢了
		if ((winner == 0) && (gumballMachine.getCount() > 1)) {
			gumballMachine.setState(gumballMachine.getWinnerState());
		} else {
			gumballMachine.setState(gumballMachine.getSoldState());
		}
	}
	public void dispense() {	//这是一个对当前状态不恰当的动作
		System.out.println("No gumball dispensed");
	}
}
public class SoldState implements State {
	GumballMachine gumballMachine;
	public SoldState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}    
	//以下3个方法对此状态来说都是不恰当的
	public void insertQuarter() {
		System.out.println("Please wait, we're already giving you a gumball");
	}
	public void ejectQuarter() {
		System.out.println("Sorry, you already turned the crank");
	}
	public void turnCrank() {
		System.out.println("Turning twice doesn't get you another gumball!");
	}
	//首先让机器发放糖果
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
//我们再来实现WinnerState类
public class WinnerState implements State {
	GumballMachine gumballMachine;
	//下面都跟SoldState方法一样
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
	//我们在这里发放出2颗糖果,然后进入NoQuarterState或SoldState
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

噢噢,我们刚实现了状态模式.状态模式允许对象的内部状态改变时改变它的行为,对象看起来好像修改了它的类.
现在想明白策略模式和状态模式有什么区别了吗?
以状态模式而言,我们将一群行为封装在状态对象中,context的行为随时可委托到那些状态对象中的一个.随着时间流逝,当前状态在状态对象集合中游走改变,以反应出context内部的状态,因此,context的行为也会跟着改变,但是context的客户对应状态对象了解不多,甚至根本不知道.
而以策略模式而言,客户通常主动指定context所要组合的策略对象是哪一个.现在固然策略模式让我们具有弹性,能够在运行时改变策略,但对于某个context来说,通常都只有一个最适当的策略对象. 