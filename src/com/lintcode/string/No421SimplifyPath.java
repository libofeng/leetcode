package com.lintcode.string;

import java.util.Stack;

public class No421SimplifyPath {
    /**
     * @param path: the original path
     * @return: the simplified path
     */
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;

        final Stack<String> stack = new Stack<>();
        String[] items = path.split("/");
        for (String item : items) {
            if (item.length() == 0 || ".".equals(item)) continue;
            else if ("..".equals(item)) {
                if (!stack.isEmpty()) stack.pop();
            } else stack.push(item);
        }

        if (stack.isEmpty()) return "/";
        final StringBuilder builder = new StringBuilder();
        for (String item : stack) builder.append("/").append(item);

        return builder.toString();
    }
}
