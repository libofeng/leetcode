package com.company.airbnb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindingOcean {
    // also see:
    // Leetocde #200 Number of Islands
    // Leetocde #305 Number of Islands II
    // Leetocde #694 Number of Distinct Islands
    // Leetocde #711 Number of Distinct Islands
    // Leetocde #695 Max area of Islands
    // Leetcode #463 Island Perimeter

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        FindingOcean solution = new FindingOcean();
        List<String> testData = new ArrayList<String>() {{
            add("WWWLLLW");
            add("WWLLLWW");
            add("WLLLLWW");
        }};
        char[][] map = new char[testData.size()][testData.get(0).length()];
        for (int i = 0; i < testData.size(); i++)
            for (int j = 0; j < testData.get(i).length(); j++)
                map[i][j] = testData.get(i).charAt(j);

        solution.floodFill(map, 0, 0, 'W', 'O');
        assert ('O' == map[0][0]);


        testData = new ArrayList<String>() {{
            add("LLLLLLLLLLLLLLLLLLLL");
            add("LLLLLLLLLLLLLLLLLLLL");
            add("LLLLLLLLLLLLLLWLLLLL");
            add("LLWWLLLLLLLLLLLLLLLL");
            add("LLWWLLLLLLLLLLLLLLLL");
            add("LLLLLLLLLLLLLLLLLLLL");
            add("LLLLLLLWWLLLLLLLLLLL");
            add("LLLLLLLLWWLLLLLLLLLL");
            add("LLLLLLLLLWWWLLLLLLLL");
            add("LLLLLLLLLLWWWWWWLLLL");
            add("LLLLLLLLLLWWWWWWLLLL");
            add("LLLLLLLLLLWWWWWWLLLL");
            add("LLLLWWLLLLWWWWWWLLLL");
            add("LLLLWWWLLLWWWWWWWWWW");
            add("LLLLLWWWWWWWWWWWLLLL");
            add("LLLLLLLLLLLLLLWWWWLL");
            add("LLLLLLLLLLLLLLWLLLLL");
            add("LLLLWLLLLLLLLLLLLWLL");
            add("LLLLLLLLLLLLLLLLLLWL");
        }};

        map = new char[testData.size()][testData.get(0).length()];
        for (int i = 0; i < testData.size(); i++)
            for (int j = 0; j < testData.get(i).length(); j++)
                map[i][j] = testData.get(i).charAt(j);
        solution.floodFill(map, 9, 12, 'W', 'O');
        assert ('O' == map[9][11]);
    }

    private void floodFill(char[][] map, int i, int j, char w, char o) {
        final int m = map.length, n = map[0].length;
        final Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        map[i][j] = o;

        while (!q.isEmpty()) {
            int px = q.peek()[0], py = q.poll()[1];
            for (int[] dir : dirs) {
                int x = px + dir[0], y = py + dir[1];
                if (x < 0 || y < 0 || x >= m || y >= m || map[x][y] != 'W') continue;

                map[px][py] = o;
                q.offer(new int[]{x, y});
            }
        }
    }
}
