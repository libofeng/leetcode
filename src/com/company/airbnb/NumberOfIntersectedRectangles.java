package com.company.airbnb;

public class NumberOfIntersectedRectangles {
    // see also:
    // 323. Number of Connected Components in an Undirected Graph
    public static void main(String[] args) {
        NumberOfIntersectedRectangles solution = new NumberOfIntersectedRectangles();
        int[][][] rectangles = {
                {{-3, -2}, {2, 1}},
                {{10, 8}, {15, 10}},
                {{1, 0}, {7, 4}},
                {{12, 9}, {16, 12}},
                {{-2, -1}, {5, 3}}
        };
        assert (2 == solution.countIntersection(rectangles));
    }

    public int countIntersection(int[][][] rectangles) {
        final int n = rectangles.length;
        final int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int k = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isIntersected(rectangles[i], rectangles[j])) {
                    int p = find(parent, i), q = find(parent, j);

                    if (p != q) {
                        parent[p] = q;
                        k--;
                    }
                }
            }
        }

        return k;
    }

    private int find(int[] parent, int i) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }

        return i;
    }

    private boolean isIntersected(int[][] a, int[][] b) {
        return (a[0][0] < b[0][0] && a[0][1] < b[0][1] && a[1][0] > b[0][0] && a[1][1] > b[0][1])
                || (a[0][0] < b[1][0] && a[0][1] < b[1][1] && a[1][0] > b[1][0] && a[1][1] > b[1][1]);
    }
}
