package com.iava.dp.creation.abstractfactory;

public interface AbstractFactory {

	  /**
     *  Creates abstract product
     */
    AbstractProductA createProductA();

    /**
     *  Creates abstract product
     */
    AbstractProductB createProductB();
}
