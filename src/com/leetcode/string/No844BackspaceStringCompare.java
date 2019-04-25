package com.leetcode.string;

import java.util.Stack;

public class No844BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        final Stack<Character> a = new Stack<>(), b = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!a.isEmpty()) a.pop();
                ;
            } else a.push(S.charAt(i));
        }

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (!b.isEmpty()) b.pop();
                ;
            } else b.push(T.charAt(i));
        }

        while (!a.isEmpty() && !b.isEmpty()) {
            if (a.pop() != b.pop()) return false;
        }

        return a.isEmpty() && b.isEmpty();
    }

    public boolean backspaceCompare2(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;

        while (i >= 0 || j >= 0) {
            if (i > 0 && S.charAt(i) == '#') i = move(S, i);
            if (j >= 0 && T.charAt(j) == '#') j = move(T, j);

            if (i >= 0 && j >= 0) {
                if (S.charAt(i--) != T.charAt(j--)) return false;
            } else if (i >= 0 || j >= 0) return false;
        }

        return true;
    }

    private int move(String s, int i) {
        int a = 0;
        while (i >= 0 && (s.charAt(i) == '#' || a > 0)) {
            if (s.charAt(i--) == '#') a++;
            else a--;
        }

        return i;
    }
}
