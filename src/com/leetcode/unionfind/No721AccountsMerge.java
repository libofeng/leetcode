package com.leetcode.unionfind;

import java.util.*;

public class No721AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        final int n = accounts.size();
        final int[] uf = new int[n];
        for (int i = 0; i < n; i++) uf[i] = i;
        final Map<String, Integer> groups = new HashMap<>();

        // link the account have common emails
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (groups.containsKey(email)) union(uf, groups.get(email), i);
                else groups.put(email, i);
            }
        }

        final Map<Integer, Set<String>> users = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            int gid = find(uf, i);
            users.computeIfAbsent(gid, k -> new TreeSet<>()).addAll(account.subList(1, account.size()));
        }

        final List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> e : users.entrySet()) {
            String name = accounts.get(e.getKey()).iterator().next();
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(e.getValue());
            result.add(account);
        }

        return result;
    }

    private void union(int[] uf, int i, int j) {
        int p = find(uf, i), q = find(uf, j);
        if (p == q) return;

        uf[p] = q;
    }

    private int find(int[] uf, int i) {
        while (uf[i] != i) {
            uf[i] = uf[uf[i]];
            i = uf[i];
        }

        return i;
    }
}
