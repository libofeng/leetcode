package com.leetcode.queue;

import java.util.*;

public class No359LoggerRateLimiter2 {
    private HashMap<String, Integer> ok = new HashMap<String, Integer>();
    /**
     * Initialize your data structure here.
     */
    private Map<String, Integer> map = new HashMap<>();

    public No359LoggerRateLimiter2() {

    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.getOrDefault(message, 0) > timestamp) return false;
        map.put(message, timestamp + 10);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
