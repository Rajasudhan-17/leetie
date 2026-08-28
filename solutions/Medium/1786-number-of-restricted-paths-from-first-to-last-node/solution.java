// ──────────────────────────────────────────────────
// Problem  : 1786. Number of Restricted Paths From First to Last Node
// Difficulty: Medium
// Tags     : Dynamic Programming, Graph Theory, Topological Sort, Heap (Priority Queue), Shortest Path, Dijkstra's Algorithm
// Link     : https://leetcode.com/problems/number-of-restricted-paths-from-first-to-last-node/
// Runtime  : 52 ms (beats 93%)
// Memory   : 138648000 (beats 70%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int countRestrictedPaths(int n, int[][] edges) {
        // Build the adjacency list for the graph
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        // Run Dijkstra's algorithm from node n to find shortest distances
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{n, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > dist[u]) continue;

            for (int[] neighbor : graph[u]) {
                int v = neighbor[0];
                int w = neighbor[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        // DFS with memoization to count restricted paths
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(1, n, graph, dist, memo);
    }

    private int dfs(int u, int n, List<int[]>[] graph, int[] dist, int[] memo) {
        if (u == n) return 1;
        if (memo[u] != -1) return memo[u];

        int mod = 1_000_000_007;
        int count = 0;

        for (int[] neighbor : graph[u]) {
            int v = neighbor[0];
            // Condition for restricted path: distanceToLastNode(u) > distanceToLastNode(v)
            if (dist[u] > dist[v]) {
                count = (count + dfs(v, n, graph, dist, memo)) % mod;
            }
        }

        memo[u] = count;
        return count;
    }
}