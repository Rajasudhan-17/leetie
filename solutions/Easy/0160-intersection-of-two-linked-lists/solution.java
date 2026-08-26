// ──────────────────────────────────────────────────
// Problem  : 160. Intersection of Two Linked Lists
// Difficulty: Easy
// Tags     : Hash Table, Linked List, Two Pointers
// Link     : https://leetcode.com/problems/intersection-of-two-linked-lists/
// Runtime  : 2 ms (beats 48%)
// Memory   : 52992000 (beats 27%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        
        return a;
    }
}