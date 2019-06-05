package com.leetcode.dfs;

import java.util.*;

public class No582KillProcess {
    // Time: O(N), Space: O(N)
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        final List<Integer> result = new ArrayList<>();
        final Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            map.computeIfAbsent(ppid.get(i), k -> new ArrayList<>()).add(pid.get(i));
        }

        kill(map, kill, result, new HashSet<>());
        return result;
    }

    private void kill(Map<Integer, List<Integer>> map, int kill, List<Integer> result, Set<Integer> killed) {
        if (!killed.add(kill)) return;

        if (map.containsKey(kill)) for (int cid : map.get(kill)) kill(map, cid, result, killed);
        result.add(kill);
    }

    // Time: O(N), Space: O(N)
    public List<Integer> killProcess2(List<Integer> pid, List<Integer> ppid, int kill) {
        final Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            map.computeIfAbsent(ppid.get(i), k -> new ArrayList<>()).add(pid.get(i));
        }

        final List<Integer> result = new ArrayList<>();
        final Queue<Integer> q = new LinkedList<>();
        q.add(kill);
        while (!q.isEmpty()) {
            int id = q.poll();
            result.add(id);

            if (map.containsKey(id)) for (int cid : map.get(id)) q.offer(cid);
        }

        return result;
    }
}
