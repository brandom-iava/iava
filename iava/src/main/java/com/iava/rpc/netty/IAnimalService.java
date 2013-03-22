package com.iava.rpc.netty;

import java.io.Serializable;

public interface IAnimalService extends Serializable {
    public String getMonkeyName();
}