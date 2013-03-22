package com.iava.rpc.rmi;

import java.rmi.RemoteException;
public class AnimalServiceImp implements IAnimalService {
    public AnimalServiceImp() {
    }

    @Override
    public String getMonkeyName() throws RemoteException {
        return "I'm Jacky";
    }
}