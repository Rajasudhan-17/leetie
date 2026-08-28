// ──────────────────────────────────────────────────
// Problem  : 547. Number of Provinces
// Difficulty: Medium
// Tags     : Depth-First Search, Breadth-First Search, Union-Find, Graph Theory
// Link     : https://leetcode.com/problems/number-of-provinces/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42824000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int p=n;
        int[] parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j]==1){
                    if(union(i,j,p,parent)) p--;
                }
            }
        }
        return p;
    }
    public static int find(int x,int[] parent){
        if(parent[x]==x){
            return x;
        }
        parent[x]=find(parent[x],parent);
        return parent[x];
    }
    public static boolean union(int a,int b,int p,int[] parent){
        int rootA=find(a,parent);
        int rootB=find(b,parent);
        if(rootA!=rootB){
            parent[rootA]=rootB;
            return true;
        }
        return false;
    }
}