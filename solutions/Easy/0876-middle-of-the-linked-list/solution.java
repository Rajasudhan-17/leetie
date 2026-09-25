// ──────────────────────────────────────────────────
// Problem  : 876. Middle of the Linked List
// Difficulty: Easy
// Tags     : Linked List, Two Pointers
// Link     : https://leetcode.com/problems/middle-of-the-linked-list/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42632000 (beats 86%)
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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}