// ──────────────────────────────────────────────────
// Problem  : 684. Redundant Connection
// Difficulty: Medium
// Tags     : Depth-First Search, Breadth-First Search, Union-Find, Graph Theory
// Link     : https://leetcode.com/problems/redundant-connection/
// Runtime  : 1 ms (beats 92%)
// Memory   : 44424000 (beats 99%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length+1;
        int[] parent=new int[edges.length+1];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         int rootA=find(edges[i],parent);
        //         int rootB=find(edges[j],parent);
        //         if(rootA==rootB) return new int[] {i,j};
        //     }
        // }
        for(int[] ele:edges){
            int rootA=find(ele[0],parent);
            int rootB=find(ele[1],parent);
            if(rootA==rootB) return new int[] {ele[0],ele[1]};
            parent[rootB] = rootA;
        }
        return new int[] {};
    }
    public static int find(int x,int[] parent){
        if(parent[x]!=x){
            parent[x]=find(parent[x],parent);
        }
        return parent[x];
    }

}