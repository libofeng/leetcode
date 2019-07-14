package com.leetcode.array;

public class No517SuperWashingMachines {
    // https://www.cnblogs.com/f91og/p/9724066.html
    public int findMinMoves(int[] machines) {
        int len = machines.length;
        int[] sum = new int[machines.length + 1];
        for (int i = 0; i < len; i++)
            sum[i + 1] = sum[i] + machines[i];

        if (sum[len] % len != 0) return -1;

        int avg = sum[len] / len;
        int res = 0;
        for (int i = 0; i < len; ++i) {
            int l = i * avg - sum[i];
            int r = (len - i - 1) * avg - (sum[len] - sum[i + 1]);
            if (l > 0 && r > 0)
                res = Math.max(res, Math.abs(l) + Math.abs(r));
            else {
                res = Math.max(res, Math.max(l, r));
            }
        }
        return res;
    }


    // https://www.cnblogs.com/grandyang/p/6648557.html
    public int findMinMoves2(int[] machines) {
        final int n = machines.length;
        int sum = 0;
        for (int d : machines) sum += d;
        if (sum % n != 0) return -1;

        int avg = sum / n, moves = 0, result = 0;
        for (int m : machines) {
            moves += m - avg;
            result = Math.max(result, Math.max(Math.abs(moves), m - avg));
        }

        return result;
    }
}
