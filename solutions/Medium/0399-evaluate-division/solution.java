// ──────────────────────────────────────────────────
// Problem  : 399. Evaluate Division
// Difficulty: Medium
// Tags     : Array, String, Depth-First Search, Breadth-First Search, Union-Find, Graph Theory, Shortest Path, Bellman–Ford Algorithm, Floyd–Warshall Algorithm
// Link     : https://leetcode.com/problems/evaluate-division/
// Runtime  : 1 ms (beats 99%)
// Memory   : 46880000 (beats 65%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build the graph
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];
            
            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());
            
            graph.get(u).put(v, val);
            graph.get(v).put(u, 1.0 / val);
        }
        
        // Evaluate queries
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                results[i] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(graph, start, end, 1.0, visited);
            }
        }
        
        return results;
    }
    
    private double dfs(Map<String, Map<String, Double>> graph, String current, String target, double product, Set<String> visited) {
        if (current.equals(target)) {
            return product;
        }
        
        visited.add(current);
        Map<String, Double> neighbors = graph.get(current);
        
        if (neighbors != null) {
            for (Map.Entry<String, Double> neighbor : neighbors.entrySet()) {
                if (!visited.contains(neighbor.getKey())) {
                    double result = dfs(graph, neighbor.getKey(), target, product * neighbor.getValue(), visited);
                    if (result != -1.0) {
                        return result;
                    }
                }
            }
        }
        
        return -1.0; // Path not found
    }
}