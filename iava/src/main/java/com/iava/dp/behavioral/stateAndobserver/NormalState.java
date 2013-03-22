package com.iava.dp.behavioral.stateAndobserver;

public class NormalState extends SaiyaState {

	/**
	 * @param saiya
	 */
	public NormalState(Saiya saiya) {
		super(saiya);
		
	}

	/*��ʸ����ͨ״̬�±��� ���ɞl��״̬
	 * @see com.dragonsoft.beralee.state.SaiyaState#hit()
	 */
	public void hit() {
		saiya.setState(saiya.DYING);
	}

}
