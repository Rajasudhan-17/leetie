// ──────────────────────────────────────────────────
// Problem  : 684. Redundant Connection
// Difficulty: Medium
// Tags     : Depth-First Search, Breadth-First Search, Union-Find, Graph Theory
// Link     : https://leetcode.com/problems/redundant-connection/
// Runtime  : 3 ms (beats 0%)
// Memory   : 42988000 (beats 0%)
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
            System.out.println(ele[0]+ " " + ele[1]);
            System.out.println(Arrays.toString(parent));
            if(rootA==rootB) return new int[] {ele[0],ele[1]};
            parent[ele[1]] = ele[0];
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