package com.leetcode.random;

public class No470ImplementRand10UsingRand7 {
    // https://www.cnblogs.com/liaohuiqiang/p/9857273.html
    // https://leetcode.com/problems/implement-rand10-using-rand7/discuss/151567/C%2B%2BJavaPython-Average-1.199-Call-rand7-Per-rand10
    public int rand10() {
        int n = rand49();
        while (n > 40) n = rand49();

        return (n - 1) % 10 + 1;
    }

    private int rand49() {
        return (rand7() - 1) * 7 + rand7();
    }

    private int rand7() {
        return 0;
    }
}
