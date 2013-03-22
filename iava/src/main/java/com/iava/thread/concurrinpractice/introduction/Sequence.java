package com.iava.thread.concurrinpractice.introduction;

import com.iava.thread.concurrinpractice.GuardedBy;
import com.iava.thread.concurrinpractice.ThreadSafe;

/**
 * Sequence
 *
 * @author Brian Goetz and Tim Peierls
 */

@ThreadSafe
public class Sequence {
    @GuardedBy("this") private int nextValue;

    public synchronized int getNext() {
        return nextValue++;
    }
}
