package com.iava.rpc.netty;

public class AnimalServiceImp implements IAnimalService {
	
	private static final long serialVersionUID = 4010074003316100546L;

	@Override
    public String getMonkeyName() {
        return "I'm Jacky";
    }

}
