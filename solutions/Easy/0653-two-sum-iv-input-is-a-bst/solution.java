// ──────────────────────────────────────────────────
// Problem  : 653. Two Sum IV - Input is a BST
// Difficulty: Easy
// Tags     : Hash Table, Two Pointers, Tree, Depth-First Search, Breadth-First Search, Binary Search Tree, Binary Tree
// Link     : https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
// Runtime  : 3 ms (beats 73%)
// Memory   : 47200000 (beats 72%)
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
    HashSet<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        // Base case: null node
        if (root == null) return false;

        // If complement is found, return true
        if (set.contains(k - root.val)) return true;

        // Otherwise, add current node value to the set
        set.add(root.val);

        // Recurse on left and right subtrees
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}