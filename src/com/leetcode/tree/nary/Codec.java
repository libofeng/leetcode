package com.leetcode.tree.nary;

import java.util.ArrayList;

class Codec {

    private int p = 0;

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null) return "#";
        final StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if(root.children!=null) for(Node child : root.children) sb.append(",").append(serialize(child));

        sb.append(",").append("#");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        return build(data.split(","));
    }

    private Node build(String[] data){
        if(p>=data.length) return null;

        String val = data[p++];
        if("#".equals(val)) return null;

        Node node = new Node(Integer.parseInt(val), new ArrayList<>());
        node.children = new ArrayList<>();

        Node child = build(data);
        while(child!=null){
            node.children.add(child);
            child = build(data);
        }

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
