// ──────────────────────────────────────────────────
// Problem  : 1019. Next Greater Node In Linked List
// Difficulty: Medium
// Tags     : Array, Linked List, Stack, Monotonic Stack
// Link     : https://leetcode.com/problems/next-greater-node-in-linked-list/
// Runtime  : 22 ms (beats 72%)
// Memory   : 49860000 (beats 39%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
        
        int n = values.size();
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && values.get(stack.peek()) < values.get(i)) {
                answer[stack.pop()] = values.get(i);
            }
            stack.push(i);
        }
        
        return answer;
    }
}