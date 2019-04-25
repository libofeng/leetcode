package com.leetcode.tree;

public class No428SerializeAndDeserializeNaryTree {
    // https://www.jianshu.com/p/5015b1338583
    public NaryNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        int[] p = new int[1];

        return build(data.split(","), p);
    }

    private NaryNode build(String[] data, int[] p) {
        if (p[0] >= data.length) return null;
        String token = data[p[0]++];
        if ("#".equals(token)) return null;

        NaryNode root = new NaryNode(Integer.parseInt(token));
        NaryNode child = build(data, p);
        while (child != null) {
            root.children.add(child);
            child = build(data, p);
        }
        return root;
    }

    public String serialize(NaryNode root) {
        if (root == null) return "";
        final StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        for (NaryNode n : root.children) sb.append(",").append(serialize(n));
        sb.append(",").append("#");
        return sb.toString();
    }

    public static void main(String[] args) {
        NaryNode root = new NaryNode(1);
        NaryNode a = new NaryNode(2);
        NaryNode b = new NaryNode(3);
        NaryNode c = new NaryNode(4);
        a.children.add(new NaryNode(5));
        a.children.add(new NaryNode(6));
        b.children.add(new NaryNode(7));
        c.children.add(new NaryNode(8));
        c.children.add(new NaryNode(9));
        c.children.add(new NaryNode(10));
        root.children.add(a);
        root.children.add(b);
        root.children.add(c);

        No428SerializeAndDeserializeNaryTree solution = new No428SerializeAndDeserializeNaryTree();

        String data = solution.serialize(root);
        System.out.println("data = " + data);

        NaryNode newRoot = solution.deserialize(data);
        System.out.println("newRoot = " + newRoot);
    }
}
