package com.iava.dp.behavioral.state.demo2;

public class GumballMachineOriginal {
	//这就是那4个状态,每个状态都用一个不同的整数代表,他们符合状态图
	final static int SOLD_OUT = 0;		//糖果售完
	final static int NO_QUARTER = 1;	//没有25分钱
	final static int HAS_QUARTER = 2;	//有25分钱
	final static int SOLD = 3;		//售出糖果
	//这个实例变量跟踪当前状态,一开始被设为"糖果售完",因为糖果机安装时是没有装糖果的
	int state = SOLD_OUT;
	int count = 0;	//这个变量用来追踪机器内的糖果数目
	//构造器初始糖果库存量当做参数,如果库存不为0的话,机器就进入"没有25分钱"的状态,等着你投入25分钱
	public GumballMachineOriginal(int count) {
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
