package com.lintcode.union;

import java.util.*;

public class No1070AccountsMerge {
    /**
     * @param accounts: List[List[str]]
     * @return: return a List[List[str]]
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        final UnionFind uf = new UnionFind(accounts.size());
        final Map<String, Integer> group = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            List<String> list = accounts.get(i);
            for (int j = 1; j < list.size(); j++) {
                String email = list.get(j);
                if (group.containsKey(email)) {
                    int g = group.get(email);
                    uf.union(g, i);
                } else group.put(email, i);
            }
        }

        Map<Integer, Set<String>> users = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> list = accounts.get(i);
            int gid = uf.find(i);
            users.putIfAbsent(gid, new TreeSet<>());
            users.get(gid).addAll(list.subList(1, list.size()));
        }

        List<List<String>> R = new LinkedList<>();
        for (Integer key : users.keySet()) {
            List<String> list = new LinkedList<>();
            list.add(accounts.get(key).get(0));
            list.addAll(users.get(key));
            R.add(list);
        }

        return R;
    }
}
