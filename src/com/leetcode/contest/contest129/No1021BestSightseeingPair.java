package com.leetcode.contest.contest129;

public class No1021BestSightseeingPair {
    /*
    Given an array A of positive integers, A[i] represents the value of the i-th sightseeing spot, and two sightseeing spots i and j have distance j - i between them.

    The score of a pair (i < j) of sightseeing spots is (A[i] + A[j] + i - j) : the sum of the values of the sightseeing spots, minus the distance between them.

    Return the maximum score of a pair of sightseeing spots.



    Example 1:

    Input: [8,1,5,2,6]
    Output: 11
    Explanation: i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11


    Note:

    2 <= A.length <= 50000
    1 <= A[i] <= 1000

     */


    public int maxScoreSightseeingPair(int[] A) {
        int maxScore = Integer.MIN_VALUE, index = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                maxScore = Math.max(maxScore, A[i] + A[j] + i - j);
            }
        }

        return maxScore;
    }

    public int maxScoreSightseeingPair2(int[] A) {
        int maxScore = Integer.MIN_VALUE, maxValue = A[0];
        for (int i = 1; i < A.length; i++) {
            maxScore = Math.max(maxScore, maxValue + A[i] - i);
            maxValue = Math.max(maxValue, A[i] + i);
        }

        return maxScore;
    }
}
