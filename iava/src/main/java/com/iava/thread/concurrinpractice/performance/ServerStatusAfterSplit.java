package com.iava.thread.concurrinpractice.performance;

import java.util.HashSet;
import java.util.Set;

import com.iava.thread.concurrinpractice.GuardedBy;
import com.iava.thread.concurrinpractice.ThreadSafe;

/**
 * ServerStatusAfterSplit
 * <p/>
 * ServerStatus refactored to use split locks
 * 采用了分离锁
 * @author Brian Goetz and Tim Peierls
 */
@ThreadSafe
public class ServerStatusAfterSplit {
    @GuardedBy("users") public final Set<String> users;
    @GuardedBy("queries") public final Set<String> queries;

    public ServerStatusAfterSplit() {
        users = new HashSet<String>();
        queries = new HashSet<String>();
    }

    public void addUser(String u) {
        synchronized (users) {
            users.add(u);
        }
    }

    public void addQuery(String q) {
        synchronized (queries) {
            queries.add(q);
        }
    }

    public void removeUser(String u) {
        synchronized (users) {
            users.remove(u);
        }
    }

    public void removeQuery(String q) {
        synchronized (users) {
            queries.remove(q);
        }
    }
}
