package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class NaryNode {
    int val;
    List<NaryNode> children = new ArrayList<>();

    public NaryNode(int val) {
        this.val = val;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        sb.append("[");
        for (NaryNode c : children) sb.append(c);
        sb.append("]");
        sb.append(",");

        return sb.toString();
    }
}
