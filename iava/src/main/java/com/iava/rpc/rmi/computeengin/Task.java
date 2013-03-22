package com.iava.rpc.rmi.computeengin;

public interface Task<T> {
    T execute();
}