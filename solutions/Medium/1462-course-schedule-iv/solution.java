// ──────────────────────────────────────────────────
// Problem  : 1462. Course Schedule IV
// Difficulty: Medium
// Tags     : Depth-First Search, Breadth-First Search, Graph Theory, Topological Sort
// Link     : https://leetcode.com/problems/course-schedule-iv/
// Runtime  : 57 ms (beats 11%)
// Memory   : 45724000 (beats 81%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Matrix to store if course i is a prerequisite of course j
        boolean[][] isReachable = new boolean[numCourses][numCourses];
        
        // Initialize direct prerequisites
        for (int[] pre : prerequisites) {
            isReachable[pre[0]][pre[1]] = true;
        }
        
        // Floyd-Warshall algorithm to find all indirect prerequisites
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    // i is a prerequisite of j if i -> j directly OR i -> k AND k -> j
                    isReachable[i][j] = isReachable[i][j] || (isReachable[i][k] && isReachable[k][j]);
                }
            }
        }
        
        // Answer each query directly from our precomputed matrix
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(isReachable[query[0]][query[1]]);
        }
        
        return result;
    }
}