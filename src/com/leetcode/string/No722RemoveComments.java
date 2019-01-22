package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class No722RemoveComments {
    public List<String> removeComments(String[] source) {
        final List<String> list = new ArrayList<>();
        if (source.length == 0) return list;

        boolean commentStarted = false;
        StringBuilder sb = new StringBuilder();
        for (String line : source) {

            int i = 0;
            while (i < line.length()) {
                char c = line.charAt(i++);

                if (commentStarted) {
                    if (c == '*' && i < line.length()) {
                        char next = line.charAt(i);
                        if (next == '/') {
                            commentStarted = false;
                            i++;
                        }
                    }
                } else {
                    if (c == '/' && i < line.length()) {
                        char next = line.charAt(i);

                        if (next == '/') break;
                        if (next == '*') {
                            commentStarted = true;
                            i++;
                        } else sb.append(c);
                    } else sb.append(c);
                }
            }

            if (!commentStarted && sb.length() > 0) {
                list.add(sb.toString());
                sb = new StringBuilder();
            }
        }

        return list;
    }
}
