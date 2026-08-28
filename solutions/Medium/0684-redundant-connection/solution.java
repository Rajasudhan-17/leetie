// ──────────────────────────────────────────────────
// Problem  : 684. Redundant Connection
// Difficulty: Medium
// Tags     : Depth-First Search, Breadth-First Search, Union-Find, Graph Theory
// Link     : https://leetcode.com/problems/redundant-connection/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42812000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[] parent=new int[edges.length];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int rootA=find(i,parent);
                int rootB=find(j,parent);
                if(rootA==rootB) return new int[] {i,j};
            }
        }
        return new int[] {};
    }
    public static int find(int x,int[] parent){
        if(parent[x]==x){
            return x;
        }
        parent[x]=find(parent[x],parent);
        return parent[x];
    }

}