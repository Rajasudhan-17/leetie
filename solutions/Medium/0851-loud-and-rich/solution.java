// ──────────────────────────────────────────────────
// Problem  : 851. Loud and Rich
// Difficulty: Medium
// Tags     : Array, Depth-First Search, Graph Theory, Topological Sort, Directed Acyclic Graph
// Link     : https://leetcode.com/problems/loud-and-rich/
// Runtime  : 8 ms (beats 77%)
// Memory   : 54912000 (beats 65%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    List<List<Integer>> adj;
    int[] ans;
    int[] quiet;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        adj = new ArrayList<>(n);
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Build graph from poorer to richer person
        for (int[] r : richer) {
            adj.get(r[1]).add(r[0]);
        }
        
        ans = new int[n];
        Arrays.fill(ans, -1);
        this.quiet = quiet;
        
        for (int i = 0; i < n; i++) {
            dfs(i);
        }
        
        return ans;
    }

    private int dfs(int node) {
        // Return already computed result to avoid redundant calculations
        if (ans[node] != -1) {
            return ans[node];
        }
        
        ans[node] = node;
        for (int neighbor : adj.get(node)) {
            int cand = dfs(neighbor);
            if (quiet[cand] < quiet[ans[node]]) {
                ans[node] = cand;
            }
        }
        
        return ans[node];
    }
}