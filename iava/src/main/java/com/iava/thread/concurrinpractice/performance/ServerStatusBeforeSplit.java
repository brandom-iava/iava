package com.iava.thread.concurrinpractice.performance;

import java.util.HashSet;
import java.util.Set;

import com.iava.thread.concurrinpractice.GuardedBy;
import com.iava.thread.concurrinpractice.ThreadSafe;

/**
 * ServerStatusBeforeSplit
 * <p/>
 * Candidate for lock splitting
 * 没有采用分离锁
 * @author Brian Goetz and Tim Peierls
 */
@ThreadSafe
public class ServerStatusBeforeSplit {
    @GuardedBy("this") public final Set<String> users;
    @GuardedBy("this") public final Set<String> queries;

    public ServerStatusBeforeSplit() {
        users = new HashSet<String>();
        queries = new HashSet<String>();
    }

    public synchronized void addUser(String u) {
        users.add(u);
    }

    public synchronized void addQuery(String q) {
        queries.add(q);
    }

    public synchronized void removeUser(String u) {
        users.remove(u);
    }

    public synchronized void removeQuery(String q) {
        queries.remove(q);
    }
}
