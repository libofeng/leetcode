package com.leetcode.contest.contest151;

import java.util.*;

public class No1169InvalidTransactions {
    public List<String> invalidTransactions(String[] transactions) {
        final int n = transactions.length;

        final Map<String, List<Trans>> map = new HashMap<>();
        final Set<String> result = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] data = transactions[i].split(",");
            Trans trans = new Trans();
            trans.name = data[0];
            trans.time = Integer.parseInt(data[1]);
            trans.amount = Integer.parseInt(data[2]);
            trans.city = data[3];

            if (trans.amount > 1000) addResult(result, trans);

            map.putIfAbsent(trans.name, new ArrayList<>());
            for (Trans t : map.get(trans.name)) {
                if (!t.city.equals(trans.city) && Math.abs(trans.time - t.time) <= 60) {
                    addResult(result, trans);
                    addResult(result, t);
                }
            }
            map.get(trans.name).add(trans);
        }

        return new ArrayList<>(result);
    }

    private void addResult(Set<String> list, Trans trans) {
        list.add(trans.name + "," + trans.time + "," + trans.amount + "," + trans.city);
    }

    class Trans {
        String name;
        int time;
        int amount;
        String city;
    }
}
