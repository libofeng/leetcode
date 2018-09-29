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
        int totalLeft = 0, sum = 0, index = -1;
        for (int i = 0; i < gas.length; i++) {
            totalLeft += gas[i] - cost[i];
            sum += gas[i] - cost[i];

            if (sum < 0) {
                sum = 0;
                index = i;
            }

        }

        return totalLeft >= 0 ? (index + 1) % gas.length : -1;
    }
}
