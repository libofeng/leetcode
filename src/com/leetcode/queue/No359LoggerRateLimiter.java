package com.leetcode.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class No359LoggerRateLimiter {

    /**
     * Initialize your data structure here.
     */
    private Queue<Log> q = new LinkedList<>();
    private Set<String> printed = new HashSet<>();

    public No359LoggerRateLimiter() {

    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        removeTimeout(timestamp);
        if (printed.contains(message)) return false;

        printed.add(message);
        q.offer(new Log(timestamp, message));
        return true;
    }

    private void removeTimeout(int timestamp) {
        int start = timestamp - 10;
        while (!q.isEmpty() && q.peek().timestamp <= start) printed.remove(q.poll().message);
    }

    class Log {
        int timestamp;
        String message;

        Log(int timestamp, String message) {
            this.timestamp = timestamp;
            this.message = message;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
