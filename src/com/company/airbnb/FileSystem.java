package com.company.airbnb;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {
    Map<String, Integer> pathMap = new HashMap<>();
    Map<String, Runnable> callback = new HashMap<>();

    public static void main(String[] args) {
        FileSystem solution = new FileSystem();
        assert (solution.create("/a", 1));
        assert (1 == solution.get("/a"));
        assert (solution.create("/a/b", 2));
        assert (2 == solution.get("/a/b"));
        assert (solution.set("/a/b", 3));
        assert (3 == solution.get("/a/b"));
        assert (!solution.create("/c/d", 4));
        assert (!solution.set("/c/d", 4));

        solution = new FileSystem();
        assert (solution.create("/NA", 1));
        assert (solution.create("/EU", 2));
        assert (1 == solution.get("/NA"));
        assert (solution.create("/NA/CA", 101));
        assert (101 == solution.get("/NA/CA"));
        assert (solution.set("/NA/CA", 102));
        assert (102 == solution.get("/NA/CA"));
        assert (solution.create("/NA/US", 101));
        assert (101 == solution.get("/NA/US"));
        assert (!solution.create("/NA/CA", 101));
        assert (!solution.create("/SA/MX", 103));
        assert (!solution.set("SA/MX", 103));
    }

    private boolean create(String path, int val) {
        if (pathMap.containsKey(path)) return false;
        if (!isPathValid(path)) return false;

        pathMap.put(path, val);
        return true;
    }

    private boolean set(String path, int val) {
        if (!pathMap.containsKey(path)) return false;
        if (!isPathValid(path)) return false;

        pathMap.put(path, val);
        triggerWatch(path);
        return true;
    }

    private Integer get(String path) {
        if (!pathMap.containsKey(path)) return null;

        triggerWatch(path);
        return pathMap.get(path);
    }

    void watch(String path, Runnable runnable) {
        if (path.endsWith("/")) path = path.substring(0, path.length() - 1);
        callback.put(path, runnable);
    }

    private boolean isPathValid(String path) {
        String parent = path;
        int lastIndex = parent.lastIndexOf("/");

        while (lastIndex > 0) {
            parent = parent.substring(0, lastIndex);
            if (!parent.isEmpty() && !pathMap.containsKey(parent)) return false;

            lastIndex = parent.lastIndexOf("/");
        }

        return true;
    }

    private void triggerWatch(String path) {
        if (!callback.containsKey(path)) return;
        callback.get(path).run();

        String parent = path;
        int lastIndex = parent.lastIndexOf("/");
        while (lastIndex >= 0) {
            parent = parent.substring(0, lastIndex);
            if (callback.containsKey(parent)) callback.get(parent).run();

            lastIndex = parent.lastIndexOf("/");
        }
    }
}
