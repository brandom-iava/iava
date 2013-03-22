package com.iava.thread.concurrinpractice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
public @interface GuardedBy {
	 /**
     * The value of the class or field value
     */
    public String value();
}
