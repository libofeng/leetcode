package com.company.facebook;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfKSortedArrays {
    // https://techpuzzl.wordpress.com/2009/08/12/intersection-of-k-sorted-arrays/
    // Time: O(NK), Space: O(N);
    public List<Integer> findCommons1(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        for (int n : grid[0]) result.add(n);

        for (int i = 1; i < grid.length; i++) result = find(grid[i], result);
        return result;
    }

    // Time: O(N), Space: O(N);
    private List<Integer> find(int[] nums, List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0, j = 0; i < nums.length && j < list.size(); ) {
            if (nums[i] < list.get(j)) i++;
            else if (list.get(j) < nums[i]) j++;
            else {
                if (result.isEmpty() || result.get(result.size() - 1) != nums[i]) result.add(nums[i]);
                i++;
                j++;
            }
        }
        return result;
    }

    // Time: O(NK), Space: O(K);
    public List<Integer> findCommons2(int[][] grid) {
        final int k = grid.length, n = grid[0].length;
        final int[] index = new int[k];

        final List<Integer> result = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        for (int[] nums : grid) max = Math.max(max, nums[0]);

        while (true) {
            int count = 0;
            for (int i = 0; i < k; i++) {
                while (index[i] < n && grid[i][index[i]] < max) index[i]++;
                if (index[i] == n) return result;

                if (grid[i][index[i]] == max) count++;
                else {
                    max = grid[i][index[i]];
                    break;
                }
            }
            if (count == k) {
                result.add(grid[0][index[0]]);
                index[0]++;
                if (index[0] < n) max = grid[0][index[0]];
                else return result;
            }
        }
    }

    public static void main(String[] args) {
        IntersectionOfKSortedArrays solution = new IntersectionOfKSortedArrays();
        int[][] grid = {{1, 3, 5, 6, 8}, {1, 3, 4, 6, 8}, {3, 6, 8, 9, 10}};
        List<Integer> result = solution.findCommons2(grid);
        System.out.println("result = " + result);
    }
}
