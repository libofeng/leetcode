package com.lintcode.string;

import java.util.LinkedList;
import java.util.List;

public class No425LetterCombinationsOfAPhoneNumber {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        String[] buttons = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> R = new LinkedList<>();
        if (digits == null || digits.length() == 0) return R;

        R.add("");
        for (char c : digits.toCharArray()) {
            List<String> list = new LinkedList<>();
            for (String s : R) {
                for (char bc : buttons[c - '0'].toCharArray()) list.add(s + bc);
            }

            R = list;
        }

        return R;
    }
}
