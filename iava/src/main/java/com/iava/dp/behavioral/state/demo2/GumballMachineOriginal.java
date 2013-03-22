package com.iava.dp.behavioral.state.demo2;

public class GumballMachineOriginal {
	//�������4��״̬,ÿ��״̬����һ����ͬ����������,���Ƿ���״̬ͼ
	final static int SOLD_OUT = 0;		//�ǹ�����
	final static int NO_QUARTER = 1;	//û��25��Ǯ
	final static int HAS_QUARTER = 2;	//��25��Ǯ
	final static int SOLD = 3;		//�۳��ǹ�
	//���ʵ���������ٵ�ǰ״̬,һ��ʼ����Ϊ"�ǹ�����",��Ϊ�ǹ�����װʱ��û��װ�ǹ���
	int state = SOLD_OUT;
	int count = 0;	//�����������׷�ٻ����ڵ��ǹ���Ŀ
	//��������ʼ�ǹ��������������,�����治Ϊ0�Ļ�,�����ͽ���"û��25��Ǯ"��״̬,������Ͷ��25��Ǯ
	public GumballMachineOriginal(int count) {
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
