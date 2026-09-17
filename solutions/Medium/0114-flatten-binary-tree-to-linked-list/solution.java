// ──────────────────────────────────────────────────
// Problem  : 114. Flatten Binary Tree to Linked List
// Difficulty: Medium
// Tags     : Linked List, Stack, Tree, Depth-First Search, Binary Tree
// Link     : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43872000 (beats 70%)
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
    TreeNode temp = null;

    public void flatten(TreeNode root) {
        helper(root);
    }
    private void helper(TreeNode root){
        if(root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        if(temp != null){
            temp.right = root;
            
        }

        root.left = null;
        temp = root;

        helper(left);
        helper(right);
    }
}