// ──────────────────────────────────────────────────
// Problem  : 449. Serialize and Deserialize BST
// Difficulty: Medium
// Tags     : String, Tree, Depth-First Search, Breadth-First Search, Design, Binary Search Tree, Binary Tree
// Link     : https://leetcode.com/problems/serialize-and-deserialize-bst/
// Runtime  : 3 ms (beats 98%)
// Memory   : 46840000 (beats 54%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(intToString(node.val));
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        for (int i = 0; i < data.length(); i += 4) {
            queue.offer(stringToInt(data.substring(i, i + 4)));
        }
        return deserializeHelper(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deserializeHelper(java.util.Queue<Integer> queue, int lower, int upper) {
        if (queue.isEmpty()) return null;
        int val = queue.peek();
        if (val < lower || val > upper) return null;
        
        queue.poll();
        TreeNode root = new TreeNode(val);
        root.left = deserializeHelper(queue, lower, val);
        root.right = deserializeHelper(queue, val, upper);
        return root;
    }

    private String intToString(int val) {
        char[] bytes = new char[4];
        for (int i = 3; i >= 0; i--) {
            bytes[i] = (char) (val & 0xFF);
            val >>= 8;
        }
        return new String(bytes);
    }

    private int stringToInt(String s) {
        int val = 0;
        for (int i = 0; i < 4; i++) {
            val = (val << 8) + (s.charAt(i) & 0xFF);
        }
        return val;
    }
}