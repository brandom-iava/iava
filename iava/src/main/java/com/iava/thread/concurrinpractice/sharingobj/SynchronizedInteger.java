package com.iava.thread.concurrinpractice.sharingobj;

import com.iava.thread.concurrinpractice.GuardedBy;
import com.iava.thread.concurrinpractice.ThreadSafe;

/**
 * SynchronizedInteger
 * <p/>
 * Thread-safe mutable integer holder
 *
 * @author Brian Goetz and Tim Peierls
 */
@ThreadSafe
public class SynchronizedInteger {
    @GuardedBy("this") private int value;

    public synchronized int get() {
        return value;
    }

    public synchronized void set(int value) {
        this.value = value;
    }
}
