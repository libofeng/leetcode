package com.leetcode.bfs;

import java.util.ArrayList;
import java.util.List;

public class No296BestMeetingPoint {
    /*
    A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

    Example:

    Input:

    1 - 0 - 0 - 0 - 1
    |   |   |   |   |
    0 - 0 - 0 - 0 - 0
    |   |   |   |   |
    0 - 0 - 1 - 0 - 0

    Output: 6

    Explanation: Given three people living at (0,0), (0,4), and (2,2):
                 The point (0,2) is an ideal meeting point, as the total travel distance
                 of 2+2+2=6 is minimal. So return 6.
     */

    public int minTotalDistance(int[][] grid) {
        final int m = grid.length, n = m == 0 ? 0 : grid[0].length;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) minDistance = Math.min(minDistance, findDistance(grid, i, j));
        }

        return minDistance;
    }

    private int findDistance(int[][] grid, int x, int y) {
        final int m = grid.length, n = grid[0].length;

        int d = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) continue;
                d += Math.abs(x - i) + Math.abs(y - j);
            }
        }

        return d;
    }

    // https://www.cnblogs.com/shanelau/p/7125467.html
    /*

原题的提示是将二维问题在一维先解决，再应用到二维上，意思就是先思考如何解决一条线上的点，求最短距离之和
1、一条线上有2个点
最短距离的点一定是这两个点的中点，则最短距离是两个点的直线距离
2、一条线上有3个点
最短距离是所有点到中间那个点的距离，还是最远的两个点的直线距离
3、一条线上有4个点
最短距离的点一定在最远的两个点之间，最远的两个点的距离就是固定的直线距离，那若要让中间两个点的距离最短，则最短距离点应该是中间两个点的中点，所以四个点的最短距离就是外部两点直线距离+内部两点直线距离
以此类推，一条线上的点，要求最短距离点，一定是中间两点的中点（偶数个点），或最中间的一个点（奇数个点），最短距离算法就是，最外侧两点距离+次外层两点距离+...+最内侧两点距离的和（若有中点，距离为0可以省略）

现在将问题扩展到二维，因为求的是曼哈顿距离，所以二维的最短距离也是在水平和垂直两个方向上的，所以只要求出水平的最短距离和垂直的最短距离，求和即可
     */

    public int minTotalDistance2(int[][] grid) {
        final List<Integer> row = new ArrayList<>(), col = new ArrayList<>();
        final int m = grid.length, n = m == 0 ? 0 : grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        return findMin(row) + findMin(col);
    }

    private int findMin(List<Integer> list) {
        int d = 0;
        list.sort((a, b) -> a - b);

        int i = 0, j = list.size() - 1;
        while (i < j) d += (list.get(j--) - list.get(i++));

        return d;
    }
}
