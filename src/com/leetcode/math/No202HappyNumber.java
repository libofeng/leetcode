package com.leetcode.math;

import java.util.HashSet;
import java.util.Set;

public class No202HappyNumber {

    public boolean isHappy(int n) {
        if (n == 0) return false;

        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (!set.add(n)) return false;
            n = next(n);
        }

        return true;
    }


    /*
     Floyd’s Cycle-Finding Algorithm:
     This is the fastest method. Traverse linked list using two pointers.  Move one pointer by one and other pointer by two.  If these pointers meet at same node then there is a loop.  If pointers do not meet then linked list doesn’t have loop.
     */
    public boolean isHappy2(int n) {
        if (n == 0) return false;

        int slow = n, fast = n;
        while (slow != 1) {
            slow = next(slow);
            fast = next(next(fast));

            if (fast == 1) return true;
            else if (slow == fast) return false;
        }

        return true;
    }

    private int next(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }

        return sum;
    }
}
