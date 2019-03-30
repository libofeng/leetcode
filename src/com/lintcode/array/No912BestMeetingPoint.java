package com.lintcode.array;

public class No912BestMeetingPoint {
    /**
     * @param grid: a 2D grid
     * @return: the minimize travel distance
     */
    // Time: O(M^2 * N^2)
    public int minTotalDistance(int[][] grid) {
        final int m = grid.length, n = m == 0 ? 0 : grid[0].length;


        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) distance = Math.min(distance, findDistance(grid, i, j));
        }

        return distance;
    }

    private int findDistance(int[][] grid, int a, int b) {
        final int m = grid.length, n = grid[0].length;
        int distance = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) continue;
                distance += Math.abs(a - i) + Math.abs(b - j);
            }
        }
        return distance;
    }

    /*
    这道题让我们求最佳的开会地点，该地点需要到每个为1的点的曼哈顿距离之和最小，题目中给了我们提示，让我们先从一维的情况来分析，那么我们先看一维时有两个点A和B的情况,

    A_____P_______B_

    那么我们可以发现，只要开会为位置P在[A, B]区间内，不管在哪，距离之和都是A和B之间的距离，如果P不在[A, B]之间，那么距离之和就会大于A和B之间的距离，那么我们现在再加两个点C和D：

    C_____A_____P_______B______D

    我们通过分析可以得出，P点的最佳位置就是在[A, B]区间内，这样和四个点的距离之和为AB距离加上CD距离，在其他任意一点的距离都会大于这个距离，那么分析出来了上述规律，这题就变得很容易了，我们只要给位置排好序，然后用最后一个坐标减去第一个坐标，即CD距离，倒数第二个坐标减去第二个坐标，即AB距离，以此类推，直到最中间停止，那么一维的情况分析出来了，二维的情况就是两个一维相加即可

    ##thinking2
    二维的等于一维的相加, 一维的最小点必在median点(用反证法可以证明).


     */
}
