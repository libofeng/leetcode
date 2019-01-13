package com.leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class No254FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(n, 2, result, new ArrayList<>());
        return result;
    }

    private void helper(int n, int start, List<List<Integer>> result, List<Integer> list) {
        if (n == 1) {
            if (list.size() > 1) result.add(new ArrayList<>(list));
            return;
        }

        int sqrt = (int) Math.sqrt(n);
        for (int i = start; i <= sqrt; i++) {
            if (n % i == 0) {
                list.add(i);
                helper(n / i, i, result, list);
                list.remove(list.size() - 1);
            }
        }

        list.add(n);
        helper(1, n, result, list);
        list.remove(list.size() - 1);
    }

    private void helper2(int n, int start, List<List<Integer>> result, List<Integer> list) {
        if (n == 1) {
            if (list.size() > 1) result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                helper2(n / i, i, result, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        No254FactorCombinations solution = new No254FactorCombinations();
        List<List<Integer>> list = solution.getFactors(12);
        System.out.println("list = " + list);
    }

}
