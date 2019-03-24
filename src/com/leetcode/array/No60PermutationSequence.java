package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class No60PermutationSequence {
    // https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n)
    public String getPermutation(int n, int k) {

        // create an array of factorial lookup
        // factorial[] = {1, 1, 2, 6, 24, ... , n!};
        final int[] factorial = new int[n + 1];
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }

        // create a list of numbers to get indices
        // numbers = {1, 2, 3, 4}
        final List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) numbers.add(i);

        k--;
        final StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        No60PermutationSequence solution = new No60PermutationSequence();
        String permutation = solution.getPermutation(3, 3);
        System.out.println("permutation = " + permutation);
    }
}
