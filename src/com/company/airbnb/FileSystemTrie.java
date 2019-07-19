package com.company.airbnb;

import java.util.ArrayList;
import java.util.List;

public class FileSystemTrie {

    private TrieNode root = new TrieNode();

    public static void main(String[] args) {
        FileSystemTrie solution = new FileSystemTrie();
        assert (solution.create("/a", 1));
        assert (1 == solution.get("/a"));
        assert (solution.create("/a/b", 2));
        assert (2 == solution.get("/a/b"));
        assert (solution.set("/a/b", 3));
        assert (3 == solution.get("/a/b"));
        assert (!solution.create("/c/d", 4));
        assert (!solution.set("/c/d", 4));
    }

    private boolean create(String path, int val) {
        TrieNode current = root;
        for (int i = 1; i < path.length(); i += 2) {
            char c = path.charAt(i);
            if (current.children[c] == null) {
                if (i < path.length() - 1) return false;
                else current.children[c] = new TrieNode();
            }

            current = current.children[c];
        }


        current.val = val;
        triggerWatch(path);
        return true;
    }

    private boolean set(String path, int val) {
        TrieNode current = root;

        for (int i = 1; i < path.length(); i += 2) {
            char c = path.charAt(i);
            current = current.children[c];
            if (current == null) return false;
        }

        current.val = val;
        triggerWatch(path);
        return true;
    }

    private Integer get(String path) {
        TrieNode current = root;

        for (int i = 1; i < path.length(); i += 2) {
            char c = path.charAt(i);
            current = current.children[c];
            if (current == null) return null;
        }

        triggerWatch(path);
        return current.val;
    }

    void watch(String path, Runnable runnable) {
        if ("/".equals(path)) {
            root.callbacks.add(runnable);
            return;
        }

        TrieNode current = root;

        for (int i = 1; i < path.length(); i += 2) {
            char c = path.charAt(i);
            current = current.children[c];
        }
        current.callbacks.add(runnable);
    }

    private void triggerWatch(String path) {
        execCallback(root.callbacks);

        TrieNode current = root;
        for (int i = 1; i < path.length(); i += 2) {
            char c = path.charAt(i);
            current = current.children[c];
            execCallback(current.callbacks);
        }
    }

    private void execCallback(List<Runnable> list) {
        for (Runnable runnable : list) runnable.run();
    }

    class TrieNode {
        int val;
        List<Runnable> callbacks = new ArrayList<>();
        TrieNode[] children = new TrieNode[128];
    }
}
