package com.leetcode.contest.contest147;

public class No1138AlphabetBoardPath {
    public String alphabetBoardPath(String target) {
        final StringBuilder sb = new StringBuilder();

        int x = 0, y = 0;
        for (char c : target.toCharArray()) {
            int index = c - 'a', row = index / 5, col = index % 5;
            move(sb, x, y, row, col);

            x = row;
            y = col;
        }

        return sb.toString();
    }

    private void move(StringBuilder sb, int x, int y, int tx, int ty) {
        if (x == 5) {
            for (int i = 0; i < Math.abs(tx - x); i++) sb.append(tx > x ? "D" : "U");
            for (int i = 0; i < Math.abs(ty - y); i++) sb.append(ty > y ? "R" : "L");
        } else {
            for (int i = 0; i < Math.abs(ty - y); i++) sb.append(ty > y ? "R" : "L");
            for (int i = 0; i < Math.abs(tx - x); i++) sb.append(tx > x ? "D" : "U");
        }

        sb.append("!");
    }
}
