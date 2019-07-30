package com.algorithm.graph;

public class DijkstraMatrixShortestPath {
    private static int N = 1000;
    private static int[][] graph = {
            {0, 1, 5, N, N, N, N, N, N},
            {1, 0, 3, 7, 5, N, N, N, N},
            {5, 3, 0, N, 1, 7, N, N, N},
            {N, 7, N, 0, 2, N, 3, N, N},
            {N, 5, 1, 2, 0, 3, 6, 9, N},
            {N, N, 7, N, 3, 0, N, 5, N},
            {N, N, N, 3, 6, N, 0, 2, 7},
            {N, N, N, N, 9, 5, 2, 0, 4},
            {N, N, N, N, N, N, 7, 4, 0}};

    public int[] dijkstraDistance(int start, int[][] graph) {
        final int n = graph.length;
        int[] distance = new int[n], preV = new int[n];
        String[] pathV = new String[n];
        boolean[] visited = new boolean[n];
        for (int v = 0; v < n; v++) {
            preV[v] = start;
            pathV[v] = "";
            distance[v] = graph[start][v];
        }

        visited[start] = true;
        pathV[start] = start + "";

        int nextV = 0;
        for (int i = 1; i < n; i++) {
            int min = N;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && distance[v] < min) {
                    min = distance[v];
                    nextV = v;
                }
            }
            pathV[nextV] = pathV[preV[nextV]] + "->" + nextV;
            visited[nextV] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && (min + graph[nextV][v] < distance[v])) {
                    distance[v] = min + graph[nextV][v];
                    preV[v] = nextV;
                    pathV[v] = pathV[preV[v]] + "->" + v;

                }
            }
        }

        for (int v = 0; v < n; v++) {
            System.out.println(v + "(distance=" + distance[v] + "), path:" + pathV[v]);
        }

        return distance;
    }

    public static void main(String[] args) {
        DijkstraMatrixShortestPath solution = new DijkstraMatrixShortestPath();
        solution.dijkstraDistance(0, graph);

        /* Expected
        v0...v0->v0, s=0
        v0...v1->v1, s=1
        v0...v1->v2, s=4
        v0...v4->v3, s=7
        v0...v2->v4, s=5
        v0...v4->v5, s=8
        v0...v3->v6, s=10
        v0...v6->v7, s=12
        v0...v7->v8, s=16*/
    }
}
