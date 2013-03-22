package com.iava.dp.behavioral.stateAndobserver;

public class DyingState extends SaiyaState {

	/**
	 * @param saiya
	 */
	public DyingState(Saiya saiya) {
		super(saiya);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dragonsoft.beralee.state.SaiyaState#hit()
	 */
	public void hit() {
		// 是普通状态下被打成瀕死状态时 会变成小宇宙爆发状态
		if (saiya.getlastStatus().equals("NormalState")) {
			saiya.setState(saiya.UNIVERSE);
			// 是小宇宙爆发状态下被打成瀕死状态时 会变成女神副体状态
		} else if (saiya.getlastStatus().equals("UniverseState")) {
			saiya.setState(saiya.GODDESS);
		}

	}

}
