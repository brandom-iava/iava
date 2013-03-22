package com.iava.dp.behavioral.stateAndobserver;

public class GoddessState extends SaiyaState {

	/**
	 * @param saiya
	 */
	public GoddessState(Saiya saiya) {
		super(saiya);

	}

	/* 小宇宙爆发后被打瀕死再被打进入女神护体状态
	 * @see com.dragonsoft.beralee.state.SaiyaState#hit()
	 */
	public void hit() {
		saiya.setState(saiya.NORMAL);
	}

}
