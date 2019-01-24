package com.leetcode.graph;

import java.util.*;

public class No399EvaluateDivision {
    final Map<String, List<String>> graph = new HashMap<>();
    final Map<String, List<Double>> edgeValues = new HashMap<>();

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        for (int i = 0; i < equations.length; i++) {
            String a = equations[i][0], b = equations[i][1];
            double value = values[i];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            edgeValues.putIfAbsent(a, new ArrayList<>());
            edgeValues.putIfAbsent(b, new ArrayList<>());

            graph.get(a).add(b);
            edgeValues.get(a).add(value);
            graph.get(b).add(a);
            edgeValues.get(b).add(1 / value);
        }

        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String a = queries[i][0], b = queries[i][1];
            result[i] = dfs(a, b, 1.0, new HashSet<>());
            if (result[i] == 0.0D) result[i] = -1.0D;
        }

        return result;
    }

    private double dfs(String dividend, String divisor, double value, Set<String> visiting) {
        if (visiting.contains(dividend) || !graph.containsKey(dividend)) return 0.0D;
        if (dividend.equals(divisor)) return value;

        visiting.add(dividend);

        List<String> divisors = graph.get(dividend);
        List<Double> values = edgeValues.get(dividend);
        for (int i = 0; i < divisors.size(); i++) {
            double result = dfs(divisors.get(i), divisor, value * values.get(i), visiting);
            if (result > 0.0D) return result;
        }

        visiting.remove(dividend);
        return 0.0D;
    }
}
