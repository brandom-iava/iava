package com.iava.rpc.ejb;

import javax.ejb.Stateless;

/**
* Session Bean implementation class AnimalBean
*/
@Stateless
public class AnimalBean implements AnimalBeanLocal {
    /**
    * Default constructor.
    */
    public AnimalBean() {
    }
    public String getMonkeyName() {
        return "I'm Jacky";
    }
}
