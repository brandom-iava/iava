package com.iava.dp.behavioral.stateAndobserver;

public class GoddessState extends SaiyaState {

	/**
	 * @param saiya
	 */
	public GoddessState(Saiya saiya) {
		super(saiya);

	}

	/* С���汬���󱻴�l���ٱ������Ů����״̬
	 * @see com.dragonsoft.beralee.state.SaiyaState#hit()
	 */
	public void hit() {
		saiya.setState(saiya.NORMAL);
	}

}
