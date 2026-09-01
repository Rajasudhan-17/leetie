// ──────────────────────────────────────────────────
// Problem  : 206. Reverse Linked List
// Difficulty: Easy
// Tags     : Linked List, Recursion
// Link     : https://leetcode.com/problems/reverse-linked-list/
// Runtime  : 0 ms (beats 100%)
// Memory   : 44404000 (beats 14%)
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
    public ListNode reverseList(ListNode head) {
    ListNode prev=null;
    ListNode curr=head;
    while(curr!=null){
        ListNode  temp=curr.next;    
        curr.next=prev;              
         prev = curr;                
        curr=temp;                   
    }
    return prev;
    }
}