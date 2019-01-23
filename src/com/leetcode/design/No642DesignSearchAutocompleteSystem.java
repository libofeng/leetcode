package com.leetcode.design;

import java.util.*;

public class No642DesignSearchAutocompleteSystem {
    // https://blog.csdn.net/sc19951007/article/details/83949647
    class TrieNode {
        TrieNode[] children = new TrieNode[128];
        Set<Integer> ids = new HashSet<>();
    }

    class Suggestion {
        String sentence;
        int times;

        Suggestion(String s, int t) {
            sentence = s;
            times = t;
        }
    }

    private TrieNode root = new TrieNode();
    private List<String> sentences = new ArrayList<>();
    private Map<Integer, Integer> frequency = new HashMap<>();
    private StringBuilder sb = new StringBuilder();
    private final int N = 3;

    public No642DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            addSentence(sentences[i], times[i]);
        }
    }

    private void addSentence(String sentence, int time) {
        insert(sentence, this.sentences.size());
        frequency.put(this.sentences.size(), time);
        this.sentences.add(sentence);
    }

    private void insert(String sentence, int id) {
        TrieNode current = root;
        for (char c : sentence.toCharArray()) {
            if (current.children[c] == null) current.children[c] = new TrieNode();
            current = current.children[c];
            current.ids.add(id);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            String sentence = sb.toString();
            List<String> result = search(sentence);

            addSentence(sentence, 1);
            sb.setLength(0);
            return result;
        } else {
            sb.append(c);
            return search(sb.toString());
        }
    }

    private List<String> search(String s) {
        TrieNode current = root;
        for (char c : s.toCharArray()) {
            current = current.children[c];
            if (current == null) return new ArrayList<>();
        }

        Comparator<Suggestion> comparator = new Comparator<Suggestion>() {
            @Override
            public int compare(Suggestion a, Suggestion b) {
                if (a.times == b.times) return a.sentence.compareTo(b.sentence);
                else return b.times - a.times;
            }
        };

        final Queue<Suggestion> pq = new PriorityQueue<>(comparator);
        for (int id : current.ids) pq.offer(new Suggestion(sentences.get(id), frequency.get(id)));

        List<String> result = new ArrayList<>();
        while (result.size() < N && !pq.isEmpty()) result.add(pq.poll().sentence);
        return result;
    }

    public static void main(String[] args) {
        String[] sentences = {"i love you", "island", "ironman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};
        No642DesignSearchAutocompleteSystem solution = new No642DesignSearchAutocompleteSystem(sentences, times);

        List<String> list = solution.input('i');
        System.out.println("list = " + list);

        list = solution.input(' ');
        System.out.println("list = " + list);

        list = solution.input('a');
        System.out.println("list = " + list);

        list = solution.input('#');
        System.out.println("list = " + list);
    }
}
