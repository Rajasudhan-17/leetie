// ──────────────────────────────────────────────────
// Problem  : 429. N-ary Tree Level Order Traversal
// Difficulty: Medium
// Tags     : Tree, Breadth-First Search
// Link     : https://leetcode.com/problems/n-ary-tree-level-order-traversal/
// Runtime  : 4 ms (beats 48%)
// Memory   : 46232000 (beats 73%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                currentLevel.add(curr.val);
                
                if (curr.children != null) {
                    for (Node child : curr.children) {
                        if (child != null) {
                            queue.offer(child);
                        }
                    }
                }
            }
            result.add(currentLevel);
        }
        
        return result;
    }
}