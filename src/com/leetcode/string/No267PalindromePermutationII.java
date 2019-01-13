package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class No267PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        final List<String> result = new ArrayList<>();
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;

        int odd = 0, index = 0;
        String single = "";
        char[] half = new char[s.length() / 2];
        boolean[] used = new boolean[s.length() / 2];
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 == 1) {
                odd++;
                single += (char) (i + 'a');
            }
            if (odd > 1) return result;

            for (int j = 0; j < count[i] / 2; j++) half[index++] = (char) (i + 'a');
        }

        helper(result, half, single, new StringBuilder(), used);

        return result;
    }

    private void helper(List<String> result, char[] half, String single, StringBuilder sb, boolean[] used) {
        if (sb.length() == half.length) {
            result.add(sb.toString() + single + sb.reverse().toString());
            return;
        }

        for (int i = 0; i < half.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            sb.append(half[i]);
            helper(result, half, single, sb, used);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        No267PalindromePermutationII solution = new No267PalindromePermutationII();
        List<String> palindromes = solution.generatePalindromes("aaaabbccccccddeeo");
        for (String palindrome : palindromes) System.out.println(palindrome);
    }
}
