package com.lintcode.tree;

import java.util.LinkedList;
import java.util.List;

public class No69BinaryTreeLevelOrderTraversal {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> R = new LinkedList<>();
        List<TreeNode> last = new LinkedList<>();
        if (root != null) last.add(root);

        while (!last.isEmpty()) {
            final List<Integer> r = new LinkedList<>();
            final List<TreeNode> current = new LinkedList<>();
            for (TreeNode node : last) {
                r.add(node.val);

                if (node.left != null) current.add(node.left);
                if (node.right != null) current.add(node.right);
            }
            R.add(r);
            last = current;
        }

        return R;
    }
}
