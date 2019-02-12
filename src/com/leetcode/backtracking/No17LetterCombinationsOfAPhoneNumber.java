package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No17LetterCombinationsOfAPhoneNumber {
    // Time: 4^N, Space: 4^N
    public List<String> letterCombinations(String digits) {
        final String[] buttons = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new LinkedList<>();
        if (digits == null || digits.length() == 0) return list;

        list.add("");
        for (char c : digits.toCharArray()) {
            List<String> l = new LinkedList<>();
            for (char bc : buttons[c - '0'].toCharArray()) for (String s : list) l.add(s + bc);
            list = l;
        }
        return list;
    }


    public List<String> letterCombinations2(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return combinations;

        String[] buttons = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> q = new LinkedList<>();
        q.offer("");

        for (int i = 0; i < digits.length(); i++) {
            String button = buttons[digits.charAt(i) - '0'];

            int size = q.size();
            while (size-- > 0) {
                String comb = q.poll();

                for (int j = 0; j < button.length(); j++) {
                    q.offer(comb + button.charAt(j));
                }
            }
        }

        combinations.addAll(q);
        return combinations;
    }
}
