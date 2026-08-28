// ──────────────────────────────────────────────────
// Problem  : 1319. Number of Operations to Make Network Connected
// Difficulty: Medium
// Tags     : Depth-First Search, Breadth-First Search, Union-Find, Graph Theory
// Link     : https://leetcode.com/problems/number-of-operations-to-make-network-connected/
// Runtime  : 2 ms (beats 100%)
// Memory   : 64920000 (beats 98%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)
        {
            return -1;
        }
        // int n=connections.length;
        int p=n;
        int[] parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        boolean f = false;
        for(int[] ele : connections)
        { 
            // rootA = find(ele[0],parent);
            // rootB = find(ele[1],parent);
            if(union(ele[0],ele[1],p,parent))
            {
                p--;
                f = true;
            }
        }
        if(f)
        {
            return p-1;
        }
        else
        {
            return -1;
        }
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