// ──────────────────────────────────────────────────
// Problem  : 508. Most Frequent Subtree Sum
// Difficulty: Medium
// Tags     : Hash Table, Tree, Depth-First Search, Binary Tree, DP on Trees
// Link     : https://leetcode.com/problems/most-frequent-subtree-sum/
// Runtime  : 3 ms (beats 99%)
// Memory   : 46380000 (beats 95%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxFreq = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> countMap = new HashMap<>();
        postOrder(root, countMap);
        
        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                resultList.add(entry.getKey());
            }
        }
        
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    private int postOrder(TreeNode node, Map<Integer, Integer> countMap) {
        if (node == null) {
            return 0;
        }
        
        int leftSum = postOrder(node.left, countMap);
        int rightSum = postOrder(node.right, countMap);
        
        int currentSum = node.val + leftSum + rightSum;
        int freq = countMap.getOrDefault(currentSum, 0) + 1;
        countMap.put(currentSum, freq);
        
        maxFreq = Math.max(maxFreq, freq);
        
        return currentSum;
    }
}