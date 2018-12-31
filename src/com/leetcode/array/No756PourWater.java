package com.leetcode.array;

public class No756PourWater {
    public void pourWater(int[] heights, int V, int K) {
        while(V-- > 0){
            int leftMinIdx = findLeftMinIndex(heights, K);
            int rightMinIdx = findRightMinIndex(heights, K);
            if(heights[leftMinIdx]<heights[K]) heights[leftMinIdx]++;
            else heights[rightMinIdx]++;
        }
    }

    private int findRightMinIndex(int[] heights, int K) {
        int minIndex = K;
        for(int i = K-1;i>=0;i--) {
            if(heights[i]<heights[minIndex]) minIndex = i;
            else if(heights[i]>heights[minIndex]) break;
        }
        return minIndex;
    }

    private int findLeftMinIndex(int[] heights, int K) {
        int minIndex = K;
        for(int i = K+1;i<heights.length;i++) {
            if(heights[i]<heights[minIndex]) minIndex = i;
            else if(heights[i]>heights[minIndex]) break;
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 1, 2, 1, 2, 2};
        No756PourWater solution = new No756PourWater();
        solution.pourWater(heights, 4, 3);

        for (int height : heights) System.out.print(height + " ");
        // expected: [2,2,2,3,2,2,2]
    }
}