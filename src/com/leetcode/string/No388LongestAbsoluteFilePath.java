package com.leetcode.string;

import java.util.Stack;

public class No388LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        final Stack<String> stack = new Stack<>();

        String[] token = input.split("\\n");
        int folderLen = 0, maxLen = 0;
        for (String t : token) {
            String name = t.replaceAll("\t", "");
            int level = (t.length() - name.length());

            while (!stack.isEmpty() && stack.size() > level) folderLen -= stack.pop().length() + 1;

            int dotIndex = name.indexOf(".");
            boolean isFile = dotIndex > 0 && dotIndex < name.length() - 1;
            if (isFile) maxLen = Math.max(maxLen, folderLen + name.length());
            else {
                stack.push(name);
                folderLen += name.length() + 1;
            }
        }

        return maxLen;
    }

    //NO use regular expression, more faster
    public int lengthLongestPath2(String input) {
        final Stack<String> stack = new Stack<>();

        int folderLen = 0, maxLen = 0, start = 0;
        while (start < input.length()) {
            int[] next = nextToken(input, start);
            int level = next[1];
            boolean isFile = next[2] > start && next[2] < next[0] - 1;

            String name = input.substring(start + level, next[0]);
            start = next[0] + 1;

            while (!stack.isEmpty() && stack.size() > level) folderLen -= stack.pop().length() + 1;
            if (isFile) maxLen = Math.max(maxLen, folderLen + name.length());
            else {
                stack.push(name);
                folderLen += name.length() + 1;
            }
        }

        return maxLen;
    }

    private int[] nextToken(String input, int start) {
        int i = start, level = 0, file = 0;
        while (i < input.length()) {
            if (input.charAt(i) == '\n') break;
            else if (input.charAt(i) == '\t') level++;
            else if (input.charAt(i) == '.') file = i;

            i++;
        }

        return new int[]{i, level, file};
    }
}
