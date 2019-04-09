package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class No784LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        final List<String> result = new ArrayList<>();

        result.add(S);
        dfs(S, 0, result);
        return result;
    }

    private void dfs(String s, int index, List<String> result) {
        while (index < s.length() && !Character.isLetter(s.charAt(index))) index++;
        if (index < s.length()) {
            dfs(s, index + 1, result);

            s = generateNewString(s, index);
            result.add(s);
            dfs(s, index + 1, result);
        }
    }

    private String generateNewString(String s, int i) {
        char[] chars = s.toCharArray();
        char c = chars[i];
        c = Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c);
        chars[i] = c;
        return new String(chars);
    }
}
