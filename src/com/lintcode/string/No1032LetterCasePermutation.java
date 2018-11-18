package com.lintcode.string;

import java.util.LinkedList;
import java.util.List;

public class No1032LetterCasePermutation {
    /**
     * @param S: a string
     * @return: return a list of strings
     */
    public List<String> letterCasePermutation(String S) {
        final List<String> R = new LinkedList<>();

        R.add(S);
        dfs(S.toCharArray(), R, 0);
        return R;
    }

    private void dfs(char[] chars, List<String> R, int i) {
        if (i == chars.length) return;

        if (Character.isLetter(chars[i])) {
            dfs(chars, R, i + 1);

            char c = chars[i];
            if (Character.isLowerCase(c)) chars[i] = Character.toUpperCase(c);
            else chars[i] = Character.toLowerCase(c);

            R.add(new String(chars));
            dfs(chars, R, i + 1);
            chars[i] = c;

        } else dfs(chars, R, i + 1);
    }


    public List<String> letterCasePermutation2(String S) {
        final List<String> R = new LinkedList<>();
        dfs2(S.toCharArray(), R, 0);
        return R;
    }

    private void dfs2(char[] chars, List<String> R, int start) {
        R.add(new String(chars));
        if (start == chars.length) return;

        for (int i = start; i < chars.length; i++) {
            char c = chars[i];
            if (!Character.isLetter(c)) continue;

            if (Character.isLowerCase(c)) chars[i] = Character.toUpperCase(c);
            else chars[i] = Character.toLowerCase(c);
            dfs2(chars, R, i + 1);
            chars[i] = c;
        }
    }
}
