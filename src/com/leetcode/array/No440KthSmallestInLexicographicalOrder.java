package com.leetcode.array;

public class No440KthSmallestInLexicographicalOrder {
    // https://blog.csdn.net/wdlsjdl2/article/details/53106659
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k = k - 1;
        while (k > 0) {
            int steps = calSteps(n, curr, curr + 1);
            if (steps <= k) {
                curr += 1;
                k -= steps;
            } else {
                curr *= 10;
                k -= 1;
            }
        }
        return curr;
    }

    //use long in case of overflow
    private int calSteps(int n, long n1, long n2) {
        int steps = 0;
        while (n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;

    }

    // https://blog.csdn.net/sinat_17451213/article/details/53738327
    public int findKthNumber2(int n, int k) {
        int num = 1;
        for (k--; k > 0; ) {
            int count = 0;
            for (long n1 = num, n2 = n1 + 1; n1 <= n; n1 *= 10, n2 *= 10) count += Math.min(n + 1, n2) - n1;

            if(count<=k){
                k -= count;
                num++;
            }else{
                num *= 10;
                k--;// minus 1 by use the current node(prefix) and  go to the next level
            }
        }

        return num;
    }
}
