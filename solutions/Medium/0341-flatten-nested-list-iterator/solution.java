// ──────────────────────────────────────────────────
// Problem  : 341. Flatten Nested List Iterator
// Difficulty: Medium
// Tags     : Stack, Tree, Depth-First Search, Design, Queue, Iterator
// Link     : https://leetcode.com/problems/flatten-nested-list-iterator/
// Runtime  : 4 ms (beats 45%)
// Memory   : 48060000 (beats 77%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

public class NestedIterator implements Iterator<Integer> {

    public NestedIterator(List<NestedInteger> nestedList) {
        lists = new Stack<>();
        lists.push(nestedList.listIterator());
    }

    public Integer next() {
        hasNext();
        return lists.peek().next().getInteger();
    }

    public boolean hasNext() {
        while (!lists.empty()) {
            if (!lists.peek().hasNext()) {
                lists.pop();
            } else {
                NestedInteger x = lists.peek().next();
                if (x.isInteger())
                    return lists.peek().previous() == x;
                lists.push(x.getList().listIterator());
            }
        }
        return false;
    }
    
    private Stack<ListIterator<NestedInteger>> lists;
}