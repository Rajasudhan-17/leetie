// ──────────────────────────────────────────────────
// Problem  : 802. Find Eventual Safe States
// Difficulty: Medium
// Tags     : Depth-First Search, Breadth-First Search, Graph Theory, Topological Sort, Kosaraju's Algorithm, Tarjan's SCC Algorithm
// Link     : https://leetcode.com/problems/find-eventual-safe-states/
// Runtime  : 20 ms (beats 50%)
// Memory   : 61972000 (beats 53%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] outdegree=new int[n];
        List<List<Integer>> reverse=new ArrayList<>();
        for(int i=0;i<n;i++){
            reverse.add(new ArrayList<>());
        }
        for(int u=0;u<n;u++){
            outdegree[u]=graph[u].length;
            for(int v:graph[u]){
                reverse.get(v).add(u);
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(outdegree[i]==0){
                q.add(i);
            }
        }
        boolean[] safe=new boolean[n];
        while(!q.isEmpty()){
            int node = q.poll();
            safe[node] = true;
            for (int prev : reverse.get(node)) {
                outdegree[prev]--;
                if (outdegree[prev] == 0) {
                    q.add(prev);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}