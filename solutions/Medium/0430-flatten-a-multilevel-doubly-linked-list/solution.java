// ──────────────────────────────────────────────────
// Problem  : 430. Flatten a Multilevel Doubly Linked List
// Difficulty: Medium
// Tags     : Linked List, Depth-First Search, Doubly-Linked List
// Link     : https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43772000 (beats 6%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                Node next = curr.next;
                Node child = curr.child;
                
                Node tail = child;
                while (tail.next != null) {
                    tail = tail.next;
                }
                
                curr.next = child;
                child.prev = curr;
                curr.child = null;
                
                if (next != null) {
                    tail.next = next;
                    next.prev = tail;
                }
            }
            curr = curr.next;
        }
        
        return head;
    }
}