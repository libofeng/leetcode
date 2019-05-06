package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;

public class No465OptimalAccountBalancing {
    int res = Integer.MAX_VALUE;

    // Time: O(N!), Space: O(N)
    public int minTransfers(int[][] transactions) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] transaction : transactions) {
            map.put(transaction[0], map.getOrDefault(transaction[0], 0) - transaction[2]);
            map.put(transaction[1], map.getOrDefault(transaction[1], 0) + transaction[2]);
        }

        ArrayList<Integer> debts = new ArrayList<>();
        for (int dept : map.values()) {
            if (dept != 0) debts.add(dept);
        }

        helper(debts, 0, 0);
        return res;
    }

    public void helper(ArrayList<Integer> depts, int start, int count) {
        while (start < depts.size() && depts.get(start) == 0) start++;
        if (start == depts.size()) {
            res = Math.min(res, count);
            return;
        }

        for (int i = start + 1; i < depts.size(); i++) {
            if (depts.get(start) < 0 && depts.get(i) > 0 || depts.get(start) > 0 && depts.get(i) < 0) {
                depts.set(i, depts.get(i) + depts.get(start));
                helper(depts, start + 1, count + 1);
                depts.set(i, depts.get(i) - depts.get(start));
            }
        }
    }
}
