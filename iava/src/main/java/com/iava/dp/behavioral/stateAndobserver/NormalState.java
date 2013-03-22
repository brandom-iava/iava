package com.iava.dp.behavioral.stateAndobserver;

public class NormalState extends SaiyaState {

	/**
	 * @param saiya
	 */
	public NormalState(Saiya saiya) {
		super(saiya);
		
	}

	/*星矢在普通状态下被打 会变成瀕死状态
	 * @see com.dragonsoft.beralee.state.SaiyaState#hit()
	 */
	public void hit() {
		saiya.setState(saiya.DYING);
	}

}
