package com.iava.dp.behavioral.stateAndobserver;

public class UniverseState extends SaiyaState {

	/**
	 * @param saiya
	 */
	public UniverseState(Saiya saiya) {
		super(saiya);

	}

	/* С���汬��״̬�������l��״̬
	 * 
	 */

	public void hit() {
		saiya.setState( saiya.DYING);

	}

}
