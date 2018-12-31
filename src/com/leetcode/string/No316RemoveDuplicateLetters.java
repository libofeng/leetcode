package com.leetcode.string;

import java.util.Arrays;
import java.util.Stack;

public class No316RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0)
                break; //保证字符是全的，例如"bcabc",到a位置就终止了，也保证了最小字符前面的可以删，因为包括当前操作的位置，往后至少所有所有字符还会有一份
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));//当前位置的字符+迭代删除以后的字符中去掉当前字符
    }


    int[] counter = new int[26];

    public String removeDuplicateLetters2(String s) {
        Arrays.fill(counter, 0);
        for (int i = 0; i < s.length(); i++) counter[s.charAt(i) - 'a']++;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(index)) index = i;
            if (counter[s.charAt(i) - 'a']-- == 1) break;
        }
        char c = s.charAt(index);
        return c + removeDuplicateLetters2(s.substring(index + 1).replaceAll(c + "", ""));
    }

    public String removeDuplicateLetters3(String s) {
        if (s.length() <= 1) return s;

        int[] counter = new int[26];
        for (char c : s.toCharArray()) counter[c - 'a']++;

        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            counter[c - 'a']--;
            if (visited[c - 'a']) continue;

            while (!stack.isEmpty() && stack.peek() > c && counter[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }

            visited[c - 'a'] = true;
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {
        No316RemoveDuplicateLetters solution = new No316RemoveDuplicateLetters();
        String s = solution.removeDuplicateLetters3("bbcaac");
        System.out.println("s = " + s);
    }
}
