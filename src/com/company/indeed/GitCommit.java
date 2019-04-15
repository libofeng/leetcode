package com.company.indeed;

import java.util.*;

public class GitCommit {
    class Node {
        int id;
        List<Node> parents;

        public Node(int id) {
            this.id = id;
            this.parents = new ArrayList<>();
        }
    }

    public List<Node> getAllParents(Node root) {
        List<Node> res = new ArrayList<>();
        if (root == null || root.parents.size() == 0) return res;

        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        q.add(root);
        visited.add(root);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node each : cur.parents) {
                if (!visited.contains(each)) {
                    q.add(each);
                    visited.add(each);
                    res.add(each);
                }
            }
        }
        return res;
    }

    public Node getLCA(Node n1, Node n2) {
        if (n1 == null || n2 == null || n1 == n2)
            return null;

        Set<Node> visited1 = new HashSet<>();
        Queue<Node> q1 = new LinkedList<>();
        q1.add(n1);
        visited1.add(n1);

        Set<Node> visited2 = new HashSet<>();
        Queue<Node> q2 = new LinkedList<>();
        q2.add(n2);
        visited2.add(n2);

        while (!q1.isEmpty() || !q2.isEmpty()) {
            int size1 = q1.size();  // traverse by level
            for (int i = 0; i < size1; i++) {
                Node cur1 = q1.remove();
                for (Node each : cur1.parents) {
                    if (visited2.contains(each))
                        return each;

                    if (!visited1.contains(each)) {
                        visited1.add(each);
                        q1.add(each);
                    }
                }
            }

            int size2 = q2.size();
            for (int i = 0; i < size2; i++) {
                Node cur2 = q2.remove();
                for (Node each : cur2.parents) {
                    if (visited1.contains(each))
                        return each;

                    if (!visited2.contains(each)) {
                        visited2.add(each);
                        q2.add(each);
                    }
                }
            }
        }
        return null;
    }
}
