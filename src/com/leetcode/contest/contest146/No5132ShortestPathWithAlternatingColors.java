package com.leetcode.contest.contest146;

import java.util.*;

public class No5132ShortestPathWithAlternatingColors {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        final List<List<Integer>> reds = new ArrayList<>(), blues = new ArrayList<>();
        for(int i = 0;i<n;i++){
            reds.add(new ArrayList<>());
            blues.add(new ArrayList<>());
        }
        for(int[] red : red_edges) reds.get(red[0]).add(red[1]);
        for(int[] blue : blue_edges) blues.get(blue[0]).add(blue[1]);

        final int[] result = new int[n];
        Arrays.fill(result, -1);

        final Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        final Set<String> visited = new HashSet<>();
        visited.add("0-0");

        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size -- > 0){
                int i = q.peek()[0], color = q.poll()[1];

                if(result[i] == -1) result[i] = steps;
                if(color != 1){
                    for(int next : reds.get(i)){
                        if(visited.add(next + "-" + 1)) q.offer(new int[]{next, 1});
                    }
                }

                if(color != 2){
                    for(int next : blues.get(i)){
                        if(visited.add(next + "-" + 2)) q.offer(new int[]{next, 2});
                    }
                }
            }

            steps++;
        }

        return result;
    }
}
