// ──────────────────────────────────────────────────
// Problem  : 210. Course Schedule II
// Difficulty: Medium
// Tags     : Depth-First Search, Breadth-First Search, Graph Theory, Topological Sort
// Link     : https://leetcode.com/problems/course-schedule-ii/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42944000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree=new int[numCourses];
        for(int[] edge:prerequisites){
            int u=edge[0];
            int v=edge[1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[] res=new int[numCourses];
        int index=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            res[index++]=curr;
            for(int j:adj.get(curr)){
                indegree[j]--;
                if(indegree[j]==0){
                    q.add(j);
                }
            }
        }
        return res;
    }
}