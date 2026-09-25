// ──────────────────────────────────────────────────
// Problem  : 706. Design HashMap
// Difficulty: Easy
// Tags     : Array, Hash Table, Linked List, Design, Hash Function
// Link     : https://leetcode.com/problems/design-hashmap/
// Runtime  : 14 ms (beats 99%)
// Memory   : 48020000 (beats 92%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class MyHashMap {
    class Node {
        int key, val;
        Node next;
        
        Node(int k, int v) {
            key = k;
            val = v;
        }
    }
    
    private Node[] map;
    private static final int SIZE = 2069;
    
    public MyHashMap() {
        map = new Node[SIZE];
    }
    
    public void put(int key, int value) {
        int idx = key % SIZE;
        if (map[idx] == null) {
            map[idx] = new Node(key, value);
            return;
        }
        Node curr = map[idx];
        while (true) {
            if (curr.key == key) {
                curr.val = value;
                return;
            }
            if (curr.next == null) break;
            curr = curr.next;
        }
        curr.next = new Node(key, value);
    }
    
    public int get(int key) {
        int idx = key % SIZE;
        Node curr = map[idx];
        while (curr != null) {
            if (curr.key == key) return curr.val;
            curr = curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int idx = key % SIZE;
        Node curr = map[idx];
        if (curr == null) return;
        
        if (curr.key == key) {
            map[idx] = curr.next;
            return;
        }
        
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}