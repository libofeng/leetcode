package com.facebook;

import java.util.ArrayList;
import java.util.List;

public class MutilTreeNode {
    int val;
    List<MutilTreeNode> children = new ArrayList<>();

    public MutilTreeNode(int val) {
        this.val = val;
    }
}
