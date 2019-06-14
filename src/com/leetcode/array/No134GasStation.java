package com.leetcode.array;

public class No134GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int start = 0; start < gas.length; start++) {
            int tank = 0;
            for (int i = 0; i < gas.length; i++) {
                int index = (start + i) % gas.length;
                tank += gas[index] - cost[index];
                if (tank < 0) break;
            }

            if (tank >= 0) return start;
        }

        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int totalLeft = 0, left = 0, candidate = 0;
        for (int i = 0; i < gas.length; i++) {
            totalLeft += gas[i] - cost[i];
            left += gas[i] - cost[i];

            // 局部条件，left<0则表示在[candidate, i]这个区间不可能有合法后选者
            if (left < 0) {
                left = 0;
                candidate = i + 1;
            }
        }

        return totalLeft < 0 ? -1 : candidate;
    }
}
