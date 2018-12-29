package com.leetcode.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No829ConsecutiveNumbersSum {
    // N = (k+1) + (k+2) + ... + (k+i) = (2k + 1 + i) * i/2
    // ki = N - i*(1 + i) /2 ;
    public int consecutiveNumbersSum(int N) {
        int count = 1;
        for (int i = 2; i * (i + 1) / 2 <= N; i++) if ((N - i * (i + 1) / 2) % i == 0) count++;
        return count;
    }

    // https://leetcode.com/problems/consecutive-numbers-sum/discuss/128959/5-line-O(N-0.5)-Java-code-Math-method
    // https://www.youtube.com/watch?v=oKOCYZd4m7E&feature=youtu.be

    public List<List<Integer>> consecutiveNumbersSums(int N) {
        List<List<Integer>> numbers = new ArrayList<>();
        numbers.add(Collections.singletonList(N));

        for (int i = 2; i * (i + 1) / 2 <= N; i++) {
            if ((N - i * (i + 1) / 2) % i == 0) {
                int k = (N - i * (i + 1) / 2) / i;
                List<Integer> list = new ArrayList<>();
                for (int j = 1; j <= i; j++) list.add(k + j);
                numbers.add(list);
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        No829ConsecutiveNumbersSum solution = new No829ConsecutiveNumbersSum();
        List<List<Integer>> numbers = solution.consecutiveNumbersSums(10000);

        for (List<Integer> number : numbers) System.out.println(number);
    }
}
