package com.leetcode.math;

import java.util.ArrayDeque;
import java.util.Deque;

public class No1006ClumsyFactorial {
    public int clumsy(int N) {
        final char[] ops = new char[]{'*', '/', '+', '-'};
        int index = 0;

        final Deque<Integer> stack = new ArrayDeque<>();
        stack.push(N--);

        while (N > 0) {
            char op = ops[index++];
            switch (op) {
                case '*':
                    stack.push(stack.pop() * N--);
                    break;
                case '/':
                    stack.push(stack.pop() / N--);
                    break;
                case '+':
                    stack.push(N--);
                    break;
                case '-':
                    stack.push(-N--);
                    break;
            }

            index %= 4;
        }

        int sum = 0;
        while (!stack.isEmpty()) sum += stack.pop();
        return sum;
    }

    // https://leetcode.com/problems/clumsy-factorial/discuss/252279/You-never-think-of-this-amazing-O(1)-solution
    public int clumsy2(int N) {
        if (N <= 2) return N;
        if (N <= 4) return N + 3;

        int mod = (N - 4) % 4;
        if (mod == 0) return N + 1;
        else if (mod <= 2) return N + 2;

        return N - 1;
    }
}
