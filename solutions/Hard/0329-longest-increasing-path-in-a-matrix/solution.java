// ──────────────────────────────────────────────────
// Problem  : 329. Longest Increasing Path in a Matrix
// Difficulty: Hard
// Tags     : Array, Dynamic Programming, Depth-First Search, Breadth-First Search, Graph Theory, Topological Sort, Memoization, Matrix, Directed Acyclic Graph
// Link     : https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
// Runtime  : 8 ms (beats 88%)
// Memory   : 47204000 (beats 30%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        m = matrix.length;
        n = matrix[0].length;
        int[][] memo = new int[m][n];
        int maxPath = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j, memo));
            }
        }
        
        return maxPath;
    }
    
    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        // Return cached result if already computed
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        
        int max = 1;
        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            // Check bounds and strictly increasing condition
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, 1 + dfs(matrix, x, y, memo));
            }
        }
        
        // Cache and return the max path starting from this cell
        memo[i][j] = max;
        return max;
    }
}