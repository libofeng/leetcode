package com.leetcode.contest.contest123;

import java.util.LinkedList;
import java.util.List;

public class No989AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new LinkedList<>();

        int i = A.length - 1, carry = 0;
        while (i >= 0 || K > 0) {
            int a = i >= 0 ? A[i--] : 0, b = K % 10;
            if (K > 0) K /= 10;

            int n = a + b + carry;
            carry = n / 10;
            list.add(0, n % 10);
        }
        if (carry > 0) list.add(0, carry);

        return list;
    }
}
