package com.leetcode.contest.contest135;

import java.util.Arrays;

public class No5051ValidBoomerang {
    /*
        A boomerang is a set of 3 points that are all distinct and not in a straight line.

        Given a list of three points in the plane, return whether these points are a boomerang.



        Example 1:

        Input: [[1,1],[2,3],[3,2]]
        Output: true
        Example 2:

        Input: [[1,1],[2,2],[3,3]]
        Output: false
     */

    public boolean isBoomerang(int[][] points) {
        return !inSameLine(points);
    }


    private boolean inSameLine(int[][] points) {
        long dx1 = points[0][0] - points[1][0], dx2 = points[1][0] - points[2][0];
        long dy1 = points[0][1] - points[1][1], dy2 = points[1][1] - points[2][1];
        return dx2 * dy1 == dx1 * dy2;
    }
}
