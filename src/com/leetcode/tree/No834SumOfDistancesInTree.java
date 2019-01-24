package com.leetcode.tree;

import java.util.*;

public class No834SumOfDistancesInTree {
    // https://blog.csdn.net/m0_37889928/article/details/80389961

    private boolean[] visited;
    private int[] numOfChild;
    private Map<Integer, List<Integer>> connected;
    private int sum;
    private int[] res;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        if (N < 2) return new int[N];
        visited = new boolean[N];
        numOfChild = new int[N];
        Arrays.fill(numOfChild, -1);
        connected = new HashMap<>();
        for (int[] it : edges) {
            if (!connected.containsKey(it[0]))
                connected.put(it[0], new ArrayList<>());
            connected.get(it[0]).add(it[1]);
            if (!connected.containsKey(it[1]))
                connected.put(it[1], new ArrayList<>());
            connected.get(it[1]).add(it[0]);
        }
        sum = 0;
        BFS(0, 0);
        //剩下的只需要遍历整棵树就可以
        Arrays.fill(visited, false);
        res = new int[N];
        res[0] = sum;
        helper(0, N);
        return res;
    }

    public int BFS(int root, int layer) {
        sum += layer;
        if (numOfChild[root] != -1)
            return numOfChild[root];
        visited[root] = true;
        int num = 0;
        for (int child : connected.get(root)) {
            if (visited[child])//如果是上层节点，就不访问
                continue;
            num += BFS(child, layer + 1) + 1;
        }
        numOfChild[root] = num;
        return num;
    }

    public void helper(int root, int N) {
        visited[root] = true;
        for (int child : connected.get(root)) {
            if (visited[child])//如果是上层节点，就不访问
                continue;
            int temp = res[root] - 2 * numOfChild[child] + N - 2;
            res[child] = temp;
            helper(child, N);
        }
    }
}
