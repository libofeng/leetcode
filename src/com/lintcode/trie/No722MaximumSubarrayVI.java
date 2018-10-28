package com.lintcode.trie;

public class No722MaximumSubarrayVI {
    class TrieNode {
        int value;
        TrieNode[] children = new TrieNode[2];
    }

    class TrieTree {
        private static final int INT_LEN = 32;
        private TrieNode root;

        TrieTree() {
            root = new TrieNode();
        }

        public void insert(int preXor) {

            TrieNode current = root;
            for (int i = INT_LEN - 1; i >= 0; i--) {
                int bit = (preXor & (1 << i)) > 0 ? 1 : 0;
                if (current.children[bit] == null) current.children[bit] = new TrieNode();
                current = current.children[bit];
            }
            current.value = preXor;
        }

        public int search(int preXor) {
            TrieNode current = root;
            for (int i = INT_LEN - 1; i >= 0; i--) {
                int bit = (preXor & (1 << i)) > 0 ? 1 : 0;

                if (current.children[1 - bit] != null) current = current.children[1 - bit];
                else if (current.children[bit] != null) current = current.children[bit];
            }

            return preXor ^ current.value;
        }
    }

    /**
     * @param nums: the array
     * @return: the max xor sum of the subarray in a given array
     */
    public int maxXorSubarray(int[] nums) {
        final TrieTree tree = new TrieTree();
        int preXor = 0;
        tree.insert(preXor);

        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            preXor = preXor ^ n;
            tree.insert(preXor);
            max = Math.max(max, tree.search(preXor));
        }

        return max;
    }


    /**
     * @param nums: the array
     * @return: the max xor sum of the subarray in a given array
     */
    public int maxXorSubarray2(int[] nums) {
        if (nums.length == 0) return 0;
        int[] xors = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) xors[i + 1] = xors[i] ^ nums[i];

        int max = 0;
        for (int i = 0; i < xors.length; i++) {
            for (int j = i + 1; j < xors.length; j++) {
                max = Math.max(max, xors[i] ^ xors[j]);
            }
        }

        return max;
    }
}
