package com.leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

public class No17LetterCombinationsOfAPhoneNumber {
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
}
