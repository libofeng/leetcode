package com.leetcode.dfs;

import java.util.*;

public class No711NumberOfDistinctIslandsII {
    /*
    这个题目实际上就是[LeetCode] 694. Number of Distinct Islands 的变形, 我们实际上还是用那个题目的updated的做法,
    用DFS去记录它的相对local 位置, 然后针对翻转和对称能够改变的加上original 位置, 总共有8 种情况, 如果original的每个坐标为(x,y),
    那么其他的情况分别为(-x, y), (x,-y), (-x, -y), (y,x), (-y, x), (y, -x), (-y, -x), 只不过因为我们要的是相对位置,
    那么每次在改变符号的时候要加上 Xmax or Ymax(注意的是变为local的坐标之后的max),
    然后每次判断产生的local 位置在不在我们的shapes这个set里面, 如果不在的话, ans += 1, 并且将8种情况都加入到shapes 的set里面,
    最后返回ans即可, 其实相对于694的题目, 只是加入了一个addIsland函数来判断是否可以翻转或者对称来跟已经有的local位置去进行比较.
     */

    /*
    基础是number of island 1, https://leetcode.com/problemset/algorithms/
    难点是如何如何把一个map 进行canonical/normalize.
    一共有8 个pair, 我们找到8个rotation当中算key值最小的那个。在标准化的过程中， 用最小的x, y 作为(0,0) 点。
    这题好难！
     */
    // Time Complexity: O(M*N *(M*N)*log (M*N)), Space Complexity: O(M *N)
    //(M*N) log (M*N) -> time for sorting


    /**
     * @param grid: the 2D grid
     * @return: the number of distinct islands
     */
    /**
     * @param grid: the 2D grid
     * @return: the number of distinct islands
     */
    public int numDistinctIslands2(int[][] grid) {
        final int m = grid.length, n = m == 0 ? 0 : grid[0].length;

        final Set<String> visited = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                List<Point> list = new ArrayList<>();
                dfs(grid, i, j, list);

                visited.add(normalized(list));
            }
        }

        return visited.size();
    }

    private int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    private void dfs(int[][] grid, int x, int y, List<Point> list) {
        final int m = grid.length, n = grid[0].length;
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0) return;

        grid[x][y] = 0;
        list.add(new Point(x, y));
        for (int[] dir : dirs) dfs(grid, x + dir[0], y + dir[1], list);
    }

    private int[][] transform = new int[][]{{1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

    private String normalized(List<Point> list) {
        final List<List<Point>> islands = new ArrayList<>();
        for (int[] t : transform) {
            List<Point> t1 = new ArrayList<>(), t2 = new ArrayList<>();
            for (Point p : list) {
                t1.add(new Point(p.x * t[0], p.y * t[1]));
                t2.add(new Point(p.y * t[1], p.x * t[0]));
            }
            islands.add(t1);
            islands.add(t2);
        }

        for (List<Point> island : islands) Collections.sort(island);

        List<String> normalizedIslands = new ArrayList<>();
        for (List<Point> island : islands) {
            StringBuilder sb = new StringBuilder();
            int x = island.get(0).x, y = island.get(0).y;
            for (Point p : island) {
                sb.append(p.x - x);
                sb.append(",");
                sb.append(p.y - y);
                sb.append("!");
            }
            normalizedIslands.add(sb.toString());
        }

        Collections.sort(normalizedIslands);
        return normalizedIslands.get(0);
    }

    class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point that) {
            return this.x == that.x ? (this.y - that.y) : (this.x - that.x);
        }
    }
}
