package com.iava.rpc.ejb;

import javax.ejb.Remote;

@Remote
public interface AnimalBeanLocal {
    String getMonkeyName();
}