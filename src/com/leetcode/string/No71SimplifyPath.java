package com.leetcode.string;

import java.util.Stack;

public class No71SimplifyPath {
    // pay attention to the edge cases:
    // 1. /a/b/./../../c
    // 2. /../
    // 3. /
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String p : paths) {
            if (p.length() == 0 || ".".equals(p)) {
            } else if ("..".equals(p)) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(p);
            }
        }

        StringBuilder builder = new StringBuilder();
        if (stack.isEmpty()) builder.append("/");
        else {
            for (String dir : stack) builder.append("/").append(dir);
        }

        return builder.toString();
    }
}
