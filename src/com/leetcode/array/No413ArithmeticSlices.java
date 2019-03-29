package com.leetcode.array;

public class No413ArithmeticSlices {
    /*
    love the "curr += 1; sum += curr;" very much, that is amazing!!
    For those guys who are confused about these two line:
    "curr" the number of different "Arithmetic Slices" ends at index = i
    a small example :
    we have :[1, 2, 3, 4]
    index = 2, we have curr = 1, sum = 1, which is [1,2,3];
    index = 3, curr = 2, sum = 2 + 1 = 3; because we look back from index = 3 which is 4 ,
    we will have two "Arithmetic Slices", which is [2,3,4] and [1,2,3,4]...
     */
    public int numberOfArithmeticSlices(int[] A) {
        int curr = 0, sum = 0;
        for (int i = 2; i < A.length; i++)
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                curr += 1;
                sum += curr;
            } else {
                curr = 0;
            }
        return sum;
    }

    // DP, it's the same as the previous solution
    // https://leetcode.com/problems/arithmetic-slices/discuss/90093/3ms-C%2B%2B-Standard-DP-Solution-with-Very-Detailed-Explanation
    public int numberOfArithmeticSlices2(int[] A) {
        final int n = A.length;
        if (n < 3) return 0;
        final int[] dp = new int[n];
        if (A[2] - A[1] == A[1] - A[0]) dp[2] = 1;

        int sum = dp[2];
        for (int i = 3; i < n; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) dp[i] = dp[i - 1] + 1;
            sum += dp[i];
        }

        return sum;
    }
}
