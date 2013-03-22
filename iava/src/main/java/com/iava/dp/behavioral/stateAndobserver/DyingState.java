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
		// ����ͨ״̬�±���ɞl��״̬ʱ ����С���汬��״̬
		if (saiya.getlastStatus().equals("NormalState")) {
			saiya.setState(saiya.UNIVERSE);
			// ��С���汬��״̬�±���ɞl��״̬ʱ ����Ů����״̬
		} else if (saiya.getlastStatus().equals("UniverseState")) {
			saiya.setState(saiya.GODDESS);
		}

	}

}
